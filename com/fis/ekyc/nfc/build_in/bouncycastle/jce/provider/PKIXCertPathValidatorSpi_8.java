package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extension;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.TBSCertificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertRevocationChecker;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.interfaces.BCX509Certificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.exception.ExtCertPathValidatorException;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.ExtendedPKIXParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PKIXCertPathValidatorSpi_8 extends CertPathValidatorSpi {
    private final JcaJceHelper helper;
    private final boolean isForCRLCheck;

    public PKIXCertPathValidatorSpi_8() {
        this(false);
    }

    public static void checkCertificate(X509Certificate x509Certificate) throws AnnotatedException {
        if (x509Certificate instanceof BCX509Certificate) {
            try {
                if (((BCX509Certificate) x509Certificate).getTBSCertificateNative() == null) {
                    e = null;
                    throw new AnnotatedException("unable to process TBSCertificate", e);
                }
            } catch (RuntimeException e) {
                e = e;
            }
        } else {
            try {
                TBSCertificate.getInstance(x509Certificate.getTBSCertificate());
            } catch (CertificateEncodingException e2) {
                throw new AnnotatedException("unable to process TBSCertificate", e2);
            } catch (IllegalArgumentException e3) {
                throw new AnnotatedException(e3.getMessage());
            }
        }
    }

    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters pKIXExtendedParameters;
        List<? extends Certificate> list;
        int i;
        int i2;
        PublicKey publicKey;
        X500Name x500Name;
        HashSet hashSet;
        boolean z;
        int i3;
        HashSet hashSet2;
        CertPath certPath2 = certPath;
        CertPathParameters certPathParameters2 = certPathParameters;
        if (certPathParameters2 instanceof PKIXParameters) {
            PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder((PKIXParameters) certPathParameters2);
            if (certPathParameters2 instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters2;
                builder.setUseDeltasEnabled(extendedPKIXParameters.isUseDeltasEnabled());
                builder.setValidityModel(extendedPKIXParameters.getValidityModel());
            }
            pKIXExtendedParameters = builder.build();
        } else if (certPathParameters2 instanceof PKIXExtendedBuilderParameters) {
            pKIXExtendedParameters = ((PKIXExtendedBuilderParameters) certPathParameters2).getBaseParameters();
        } else if (certPathParameters2 instanceof PKIXExtendedParameters) {
            pKIXExtendedParameters = (PKIXExtendedParameters) certPathParameters2;
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
        }
        if (pKIXExtendedParameters.getTrustAnchors() != null) {
            List<? extends Certificate> certificates = certPath.getCertificates();
            int size = certificates.size();
            if (!certificates.isEmpty()) {
                Set initialPolicies = pKIXExtendedParameters.getInitialPolicies();
                try {
                    TrustAnchor findTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), pKIXExtendedParameters.getTrustAnchors(), pKIXExtendedParameters.getSigProvider());
                    if (findTrustAnchor != null) {
                        checkCertificate(findTrustAnchor.getTrustedCert());
                        PKIXExtendedParameters build = new PKIXExtendedParameters.Builder(pKIXExtendedParameters).setTrustAnchor(findTrustAnchor).build();
                        ArrayList arrayList = new ArrayList();
                        PKIXCertRevocationChecker pKIXCertRevocationChecker = null;
                        for (PKIXCertPathChecker pKIXCertPathChecker : build.getCertPathCheckers()) {
                            pKIXCertPathChecker.init(false);
                            if (!(pKIXCertPathChecker instanceof PKIXRevocationChecker)) {
                                arrayList.add(pKIXCertPathChecker);
                            } else if (pKIXCertRevocationChecker != null) {
                                throw new CertPathValidatorException("only one PKIXRevocationChecker allowed");
                            } else if (pKIXCertPathChecker instanceof PKIXCertRevocationChecker) {
                                pKIXCertRevocationChecker = (PKIXCertRevocationChecker) pKIXCertPathChecker;
                            } else {
                                pKIXCertRevocationChecker = new WrappedRevocationChecker(pKIXCertPathChecker);
                            }
                        }
                        if (build.isRevocationEnabled() && pKIXCertRevocationChecker == null) {
                            pKIXCertRevocationChecker = new ProvRevocationChecker(this.helper);
                        }
                        PKIXCertRevocationChecker pKIXCertRevocationChecker2 = pKIXCertRevocationChecker;
                        int i4 = size + 1;
                        ArrayList[] arrayListArr = new ArrayList[i4];
                        for (int i5 = 0; i5 < i4; i5++) {
                            arrayListArr[i5] = new ArrayList();
                        }
                        HashSet hashSet3 = new HashSet();
                        hashSet3.add(RFC3280CertPathUtilities.ANY_POLICY);
                        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, (PolicyNode) null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
                        arrayListArr[0].add(pKIXPolicyNode);
                        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                        HashSet hashSet4 = new HashSet();
                        if (build.isExplicitPolicyRequired()) {
                            i = 0;
                        } else {
                            i = i4;
                        }
                        if (build.isAnyPolicyInhibited()) {
                            i2 = 0;
                        } else {
                            i2 = i4;
                        }
                        if (build.isPolicyMappingInhibited()) {
                            i4 = 0;
                        }
                        X509Certificate trustedCert = findTrustAnchor.getTrustedCert();
                        if (trustedCert != null) {
                            try {
                                x500Name = PrincipalUtils.getSubjectPrincipal(trustedCert);
                                publicKey = trustedCert.getPublicKey();
                            } catch (RuntimeException e) {
                                throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e, certPath2, -1);
                            }
                        } else {
                            x500Name = PrincipalUtils.getCA(findTrustAnchor);
                            publicKey = findTrustAnchor.getCAPublicKey();
                        }
                        try {
                            AlgorithmIdentifier algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
                            algorithmIdentifier.getAlgorithm();
                            algorithmIdentifier.getParameters();
                            if (build.getTargetConstraints() == null || build.getTargetConstraints().match((Certificate) (X509Certificate) certificates.get(0))) {
                                int size2 = certificates.size() - 1;
                                int i6 = size;
                                X509Certificate x509Certificate = null;
                                int i7 = i4;
                                int i8 = i;
                                PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                                while (size2 >= 0) {
                                    int i9 = size - size2;
                                    Set set = initialPolicies;
                                    X509Certificate x509Certificate2 = (X509Certificate) certificates.get(size2);
                                    if (size2 == certificates.size() - 1) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    try {
                                        checkCertificate(x509Certificate2);
                                        int i10 = i8;
                                        int i11 = size2;
                                        List<? extends Certificate> list2 = certificates;
                                        PKIXNameConstraintValidator pKIXNameConstraintValidator2 = pKIXNameConstraintValidator;
                                        PKIXExtendedParameters pKIXExtendedParameters2 = build;
                                        int i12 = i7;
                                        ArrayList[] arrayListArr2 = arrayListArr;
                                        ArrayList arrayList2 = arrayList;
                                        TrustAnchor trustAnchor = findTrustAnchor;
                                        RFC3280CertPathUtilities.processCertA(certPath, build, pKIXCertRevocationChecker2, i11, publicKey, z, x500Name, trustedCert);
                                        int i13 = i11;
                                        RFC3280CertPathUtilities.processCertBC(certPath2, i13, pKIXNameConstraintValidator2, this.isForCRLCheck);
                                        PKIXPolicyNode processCertE = RFC3280CertPathUtilities.processCertE(certPath2, i13, RFC3280CertPathUtilities.processCertD(certPath, i13, hashSet4, pKIXPolicyNode2, arrayListArr2, i2, this.isForCRLCheck));
                                        RFC3280CertPathUtilities.processCertF(certPath2, i13, processCertE, i10);
                                        if (i9 != size) {
                                            if (x509Certificate2 == null || x509Certificate2.getVersion() != 1) {
                                                RFC3280CertPathUtilities.prepareNextCertA(certPath2, i13);
                                                arrayListArr = arrayListArr2;
                                                PKIXPolicyNode prepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath2, i13, arrayListArr, processCertE, i12);
                                                RFC3280CertPathUtilities.prepareNextCertG(certPath2, i13, pKIXNameConstraintValidator2);
                                                int prepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath2, i13, i10);
                                                int prepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath2, i13, i12);
                                                int prepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath2, i13, i2);
                                                int prepareNextCertI1 = RFC3280CertPathUtilities.prepareNextCertI1(certPath2, i13, prepareNextCertH1);
                                                i12 = RFC3280CertPathUtilities.prepareNextCertI2(certPath2, i13, prepareNextCertH2);
                                                int prepareNextCertJ = RFC3280CertPathUtilities.prepareNextCertJ(certPath2, i13, prepareNextCertH3);
                                                RFC3280CertPathUtilities.prepareNextCertK(certPath2, i13);
                                                i6 = RFC3280CertPathUtilities.prepareNextCertM(certPath2, i13, RFC3280CertPathUtilities.prepareNextCertL(certPath2, i13, i6));
                                                RFC3280CertPathUtilities.prepareNextCertN(certPath2, i13);
                                                Set<String> criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                                                if (criticalExtensionOIDs != null) {
                                                    hashSet2 = new HashSet(criticalExtensionOIDs);
                                                    hashSet2.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                                    hashSet2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                                    hashSet2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                                    hashSet2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                                    hashSet2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                                    hashSet2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                                    hashSet2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                                } else {
                                                    hashSet2 = new HashSet();
                                                }
                                                arrayList = arrayList2;
                                                RFC3280CertPathUtilities.prepareNextCertO(certPath2, i13, hashSet2, arrayList);
                                                X500Name subjectPrincipal = PrincipalUtils.getSubjectPrincipal(x509Certificate2);
                                                try {
                                                    PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), i13, this.helper);
                                                    AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                                    algorithmIdentifier2.getAlgorithm();
                                                    algorithmIdentifier2.getParameters();
                                                    pKIXPolicyNode2 = prepareCertB;
                                                    i8 = prepareNextCertI1;
                                                    i3 = prepareNextCertJ;
                                                    x500Name = subjectPrincipal;
                                                    publicKey = nextWorkingKey;
                                                    trustedCert = x509Certificate2;
                                                    i7 = i12;
                                                    size2 = i13 - 1;
                                                    pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                                    certificates = list2;
                                                    build = pKIXExtendedParameters2;
                                                    findTrustAnchor = trustAnchor;
                                                    Set set2 = set;
                                                    x509Certificate = x509Certificate2;
                                                    initialPolicies = set2;
                                                } catch (CertPathValidatorException e2) {
                                                    throw new CertPathValidatorException("Next working key could not be retrieved.", e2, certPath2, i13);
                                                }
                                            } else if (i9 != 1 || !x509Certificate2.equals(trustAnchor.getTrustedCert())) {
                                                throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", (Throwable) null, certPath2, i13);
                                            }
                                        }
                                        arrayListArr = arrayListArr2;
                                        arrayList = arrayList2;
                                        pKIXPolicyNode2 = processCertE;
                                        i3 = i2;
                                        i6 = i6;
                                        i8 = i10;
                                        i7 = i12;
                                        size2 = i13 - 1;
                                        pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                        certificates = list2;
                                        build = pKIXExtendedParameters2;
                                        findTrustAnchor = trustAnchor;
                                        Set set22 = set;
                                        x509Certificate = x509Certificate2;
                                        initialPolicies = set22;
                                    } catch (AnnotatedException e3) {
                                        AnnotatedException annotatedException = e3;
                                        throw new CertPathValidatorException(annotatedException.getMessage(), annotatedException.getUnderlyingException(), certPath2, size2);
                                    }
                                }
                                PKIXExtendedParameters pKIXExtendedParameters3 = build;
                                TrustAnchor trustAnchor2 = findTrustAnchor;
                                X509Certificate x509Certificate3 = x509Certificate;
                                int i14 = size2;
                                Set set3 = initialPolicies;
                                int i15 = i14 + 1;
                                int wrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath2, i15, RFC3280CertPathUtilities.wrapupCertA(i8, x509Certificate3));
                                Set<String> criticalExtensionOIDs2 = x509Certificate3.getCriticalExtensionOIDs();
                                if (criticalExtensionOIDs2 != null) {
                                    hashSet = new HashSet(criticalExtensionOIDs2);
                                    hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                    hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                    hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                    hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                    hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                    hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                    hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                    hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                                    hashSet.remove(Extension.extendedKeyUsage.getId());
                                } else {
                                    hashSet = new HashSet();
                                }
                                RFC3280CertPathUtilities.wrapupCertF(certPath2, i15, arrayList, hashSet);
                                PKIXPolicyNode wrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, pKIXExtendedParameters3, set3, i15, arrayListArr, pKIXPolicyNode2, hashSet4);
                                if (wrapupCertB > 0 || wrapupCertG != null) {
                                    return new PKIXCertPathValidatorResult(trustAnchor2, wrapupCertG, x509Certificate3.getPublicKey());
                                }
                                throw new CertPathValidatorException("Path processing failed on policy.", (Throwable) null, certPath2, i14);
                            }
                            throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", (Throwable) null, certPath2, 0);
                        } catch (CertPathValidatorException e4) {
                            throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e4, certPath2, -1);
                        }
                    } else {
                        list = certificates;
                        try {
                            throw new CertPathValidatorException("Trust anchor for certification path not found.", (Throwable) null, certPath2, -1);
                        } catch (AnnotatedException e5) {
                            e = e5;
                            throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, list.size() - 1);
                        }
                    }
                } catch (AnnotatedException e6) {
                    e = e6;
                    list = certificates;
                    throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, list.size() - 1);
                }
            } else {
                throw new CertPathValidatorException("Certification path is empty.", (Throwable) null, certPath2, -1);
            }
        } else {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
    }

    public PKIXCertPathValidatorSpi_8(boolean z) {
        this.helper = new BCJcaJceHelper();
        this.isForCRLCheck = z;
    }

    public PKIXCertPathChecker engineGetRevocationChecker() {
        return new ProvRevocationChecker(this.helper);
    }
}
