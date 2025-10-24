package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Enumerated;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1GeneralizedTime;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OutputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.style.RFC4519Style;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CRLDistPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPointName;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extension;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralNames;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.PolicyInformation;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCRLStore;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCRLStoreSelector;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertStore;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertStoreSelector;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.exception.ExtCertPathBuilderException;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.exception.ExtCertPathValidatorException;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Store;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.StoreException;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertificate;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

class CertPathValidatorUtilities {
    protected static final String ANY_POLICY = "2.5.29.32.0";
    protected static final String AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
    protected static final String BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
    protected static final String CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
    protected static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
    protected static final String CRL_NUMBER = Extension.cRLNumber.getId();
    protected static final int CRL_SIGN = 6;
    protected static final PKIXCRLUtil CRL_UTIL = new PKIXCRLUtil();
    protected static final String DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
    protected static final String FRESHEST_CRL = Extension.freshestCRL.getId();
    protected static final String INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
    protected static final String ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
    protected static final int KEY_CERT_SIGN = 5;
    protected static final String KEY_USAGE = Extension.keyUsage.getId();
    protected static final String NAME_CONSTRAINTS = Extension.nameConstraints.getId();
    protected static final String POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
    protected static final String POLICY_MAPPINGS = Extension.policyMappings.getId();
    protected static final String SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
    protected static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    public static void checkCRLsNotEmpty(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, Set set, Object obj) throws RecoverableCertPathValidatorException {
        if (!set.isEmpty()) {
            return;
        }
        if (obj instanceof X509AttributeCertificate) {
            throw new RecoverableCertPathValidatorException("No CRLs found for issuer \"" + ((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0] + "\"", (Throwable) null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
        }
        throw new RecoverableCertPathValidatorException("No CRLs found for issuer \"" + RFC4519Style.INSTANCE.toString(PrincipalUtils.getIssuerPrincipal((X509Certificate) obj)) + "\"", (Throwable) null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
    }

    public static Collection findCertificates(PKIXCertStoreSelector pKIXCertStoreSelector, List list) throws AnnotatedException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object next : list) {
            if (next instanceof Store) {
                try {
                    linkedHashSet.addAll(((Store) next).getMatches(pKIXCertStoreSelector));
                } catch (StoreException e) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e);
                }
            } else {
                try {
                    linkedHashSet.addAll(PKIXCertStoreSelector.getCertificates(pKIXCertStoreSelector, (CertStore) next));
                } catch (CertStoreException e2) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e2);
                }
            }
        }
        return linkedHashSet;
    }

    public static Collection findIssuerCerts(X509Certificate x509Certificate, List<CertStore> list, List<PKIXCertStore> list2) throws AnnotatedException {
        byte[] keyIdentifier;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(PrincipalUtils.getIssuerPrincipal(x509Certificate).getEncoded());
            try {
                byte[] extensionValue = x509Certificate.getExtensionValue(AUTHORITY_KEY_IDENTIFIER);
                if (!(extensionValue == null || (keyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()).getKeyIdentifier()) == null)) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            } catch (Exception unused) {
            }
            PKIXCertStoreSelector<? extends Certificate> build = new PKIXCertStoreSelector.Builder(x509CertSelector).build();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                ArrayList<X509Certificate> arrayList = new ArrayList<>();
                arrayList.addAll(findCertificates(build, list));
                arrayList.addAll(findCertificates(build, list2));
                for (X509Certificate add : arrayList) {
                    linkedHashSet.add(add);
                }
                return linkedHashSet;
            } catch (AnnotatedException e) {
                throw new AnnotatedException("Issuer certificate cannot be searched.", e);
            }
        } catch (Exception e2) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", e2);
        }
    }

    public static Collection findTargets(PKIXExtendedBuilderParameters pKIXExtendedBuilderParameters) throws CertPathBuilderException {
        PKIXCertStoreSelector targetConstraints = pKIXExtendedBuilderParameters.getBaseParameters().getTargetConstraints();
        try {
            Collection findCertificates = findCertificates(targetConstraints, pKIXExtendedBuilderParameters.getBaseParameters().getCertificateStores());
            findCertificates.addAll(findCertificates(targetConstraints, pKIXExtendedBuilderParameters.getBaseParameters().getCertStores()));
            if (!findCertificates.isEmpty()) {
                return findCertificates;
            }
            Certificate certificate = targetConstraints.getCertificate();
            if (certificate != null) {
                return Collections.singleton(certificate);
            }
            throw new CertPathBuilderException("No certificate found matching targetConstraints.");
        } catch (AnnotatedException e) {
            throw new ExtCertPathBuilderException("Error finding target certificate.", e);
        }
    }

    public static TrustAnchor findTrustAnchor(X509Certificate x509Certificate, Set set) throws AnnotatedException {
        return findTrustAnchor(x509Certificate, set, (String) null);
    }

    public static List<PKIXCertStore> getAdditionalStoresFromAltNames(byte[] bArr, Map<GeneralName, PKIXCertStore> map) throws CertificateParsingException {
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        GeneralName[] names = GeneralNames.getInstance(ASN1OctetString.getInstance(bArr).getOctets()).getNames();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != names.length; i++) {
            PKIXCertStore pKIXCertStore = map.get(names[i]);
            if (pKIXCertStore != null) {
                arrayList.add(pKIXCertStore);
            }
        }
        return arrayList;
    }

    public static List<PKIXCRLStore> getAdditionalStoresFromCRLDistributionPoint(CRLDistPoint cRLDistPoint, Map<GeneralName, PKIXCRLStore> map, Date date, JcaJceHelper jcaJceHelper) throws AnnotatedException {
        if (cRLDistPoint == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
            ArrayList arrayList = new ArrayList();
            for (DistributionPoint distributionPoint : distributionPoints) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2 != null && distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (GeneralName generalName : names) {
                        PKIXCRLStore pKIXCRLStore = map.get(generalName);
                        if (pKIXCRLStore != null) {
                            arrayList.add(pKIXCRLStore);
                        }
                    }
                }
            }
            if (arrayList.isEmpty() && Properties.isOverrideSet("com.fis.ekyc.nfc.build_in.bouncycastle.x509.enableCRLDP")) {
                try {
                    CertificateFactory createCertificateFactory = jcaJceHelper.createCertificateFactory("X.509");
                    for (int i = 0; i < distributionPoints.length; i++) {
                        DistributionPointName distributionPoint3 = distributionPoints[i].getDistributionPoint();
                        if (distributionPoint3 != null && distributionPoint3.getType() == 0) {
                            GeneralName[] names2 = GeneralNames.getInstance(distributionPoint3.getName()).getNames();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= names2.length) {
                                    break;
                                }
                                GeneralName generalName2 = names2[i];
                                if (generalName2.getTagNo() == 6) {
                                    try {
                                        PKIXCRLStore crl = CrlCache.getCrl(createCertificateFactory, date, new URI(((ASN1String) generalName2.getName()).getString()));
                                        if (crl != null) {
                                            arrayList.add(crl);
                                        }
                                    } catch (Exception unused) {
                                    }
                                } else {
                                    i2++;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new AnnotatedException("cannot create certificate factory: " + e.getMessage(), e);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            throw new AnnotatedException("Distribution points could not be read.", e2);
        }
    }

    public static AlgorithmIdentifier getAlgorithmIdentifier(PublicKey publicKey) throws CertPathValidatorException {
        try {
            return SubjectPublicKeyInfo.getInstance(new ASN1InputStream(publicKey.getEncoded()).readObject()).getAlgorithm();
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", e);
        }
    }

    public static void getCRLIssuersFromDistributionPoint(DistributionPoint distributionPoint, Collection collection, X509CRLSelector x509CRLSelector) throws AnnotatedException {
        ArrayList<X500Name> arrayList = new ArrayList<>();
        if (distributionPoint.getCRLIssuer() != null) {
            GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
            for (int i = 0; i < names.length; i++) {
                if (names[i].getTagNo() == 4) {
                    try {
                        arrayList.add(X500Name.getInstance(names[i].getName().toASN1Primitive().getEncoded()));
                    } catch (IOException e) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e);
                    }
                }
            }
        } else if (distributionPoint.getDistributionPoint() != null) {
            for (Object add : collection) {
                arrayList.add(add);
            }
        } else {
            throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
        }
        for (X500Name encoded : arrayList) {
            try {
                x509CRLSelector.addIssuerName(encoded.getEncoded());
            } catch (IOException e2) {
                throw new AnnotatedException("Cannot decode CRL issuer information.", e2);
            }
        }
    }

    public static void getCertStatus(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        X509CRLEntry x509CRLEntry;
        ASN1Enumerated aSN1Enumerated;
        int i;
        X500Name x500Name;
        try {
            if (X509CRLObject.isIndirectCRL(x509crl)) {
                x509CRLEntry = x509crl.getRevokedCertificate(getSerialNumber(obj));
                if (x509CRLEntry != null) {
                    X500Principal certificateIssuer = x509CRLEntry.getCertificateIssuer();
                    if (certificateIssuer == null) {
                        x500Name = PrincipalUtils.getIssuerPrincipal(x509crl);
                    } else {
                        x500Name = PrincipalUtils.getX500Name(certificateIssuer);
                    }
                    if (!PrincipalUtils.getEncodedIssuerPrincipal(obj).equals(x500Name)) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (!PrincipalUtils.getEncodedIssuerPrincipal(obj).equals(PrincipalUtils.getIssuerPrincipal(x509crl)) || (x509CRLEntry = x509crl.getRevokedCertificate(getSerialNumber(obj))) == null) {
                return;
            }
            if (!x509CRLEntry.hasExtensions()) {
                aSN1Enumerated = null;
            } else if (!x509CRLEntry.hasUnsupportedCriticalExtension()) {
                try {
                    aSN1Enumerated = ASN1Enumerated.getInstance(getExtensionValue(x509CRLEntry, Extension.reasonCode.getId()));
                } catch (Exception e) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e);
                }
            } else {
                throw new AnnotatedException("CRL entry has unsupported critical extensions.");
            }
            if (aSN1Enumerated == null) {
                i = 0;
            } else {
                i = aSN1Enumerated.intValueExact();
            }
            if (date.getTime() >= x509CRLEntry.getRevocationDate().getTime() || i == 0 || i == 1 || i == 2 || i == 10) {
                certStatus.setCertStatus(i);
                certStatus.setRevocationDate(x509CRLEntry.getRevocationDate());
            }
        } catch (CRLException e2) {
            throw new AnnotatedException("Failed check for indirect CRL.", e2);
        }
    }

    public static Set getCompleteCRLs(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, DistributionPoint distributionPoint, Object obj, Date date, PKIXExtendedParameters pKIXExtendedParameters) throws AnnotatedException, RecoverableCertPathValidatorException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(PrincipalUtils.getEncodedIssuerPrincipal(obj));
            getCRLIssuersFromDistributionPoint(distributionPoint, hashSet, x509CRLSelector);
            if (obj instanceof X509Certificate) {
                x509CRLSelector.setCertificateChecking((X509Certificate) obj);
            }
            PKIXCRLStoreSelector<? extends CRL> build = new PKIXCRLStoreSelector.Builder(x509CRLSelector).setCompleteCRLEnabled(true).build();
            if (pKIXExtendedParameters.getDate() != null) {
                date = pKIXExtendedParameters.getDate();
            }
            Set findCRLs = CRL_UTIL.findCRLs(build, date, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores());
            checkCRLsNotEmpty(pKIXCertRevocationCheckerParameters, findCRLs, obj);
            return findCRLs;
        } catch (AnnotatedException e) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", e);
        }
    }

    public static Set getDeltaCRLs(Date date, X509CRL x509crl, List<CertStore> list, List<PKIXCRLStore> list2, JcaJceHelper jcaJceHelper) throws AnnotatedException {
        BigInteger bigInteger;
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            x509CRLSelector.addIssuerName(PrincipalUtils.getIssuerPrincipal(x509crl).getEncoded());
            try {
                ASN1Primitive extensionValue = getExtensionValue(x509crl, CRL_NUMBER);
                BigInteger bigInteger2 = null;
                if (extensionValue != null) {
                    bigInteger = ASN1Integer.getInstance(extensionValue).getPositiveValue();
                } else {
                    bigInteger = null;
                }
                try {
                    byte[] extensionValue2 = x509crl.getExtensionValue(ISSUING_DISTRIBUTION_POINT);
                    if (bigInteger != null) {
                        bigInteger2 = bigInteger.add(BigInteger.valueOf(1));
                    }
                    x509CRLSelector.setMinCRLNumber(bigInteger2);
                    PKIXCRLStoreSelector.Builder builder = new PKIXCRLStoreSelector.Builder(x509CRLSelector);
                    builder.setIssuingDistributionPoint(extensionValue2);
                    builder.setIssuingDistributionPointEnabled(true);
                    builder.setMaxBaseCRLNumber(bigInteger);
                    PKIXCRLStoreSelector<? extends CRL> build = builder.build();
                    Set<X509CRL> findCRLs = CRL_UTIL.findCRLs(build, date, list, list2);
                    if (findCRLs.isEmpty() && Properties.isOverrideSet("com.fis.ekyc.nfc.build_in.bouncycastle.x509.enableCRLDP")) {
                        try {
                            CertificateFactory createCertificateFactory = jcaJceHelper.createCertificateFactory("X.509");
                            DistributionPoint[] distributionPoints = CRLDistPoint.getInstance(extensionValue2).getDistributionPoints();
                            for (int i = 0; i < distributionPoints.length; i++) {
                                DistributionPointName distributionPoint = distributionPoints[i].getDistributionPoint();
                                if (distributionPoint != null && distributionPoint.getType() == 0) {
                                    GeneralName[] names = GeneralNames.getInstance(distributionPoint.getName()).getNames();
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= names.length) {
                                            break;
                                        }
                                        GeneralName generalName = names[i];
                                        if (generalName.getTagNo() == 6) {
                                            try {
                                                PKIXCRLStore crl = CrlCache.getCrl(createCertificateFactory, date, new URI(((ASN1String) generalName.getName()).getString()));
                                                if (crl != null) {
                                                    findCRLs = CRL_UTIL.findCRLs(build, date, Collections.emptyList(), Collections.singletonList(crl));
                                                }
                                            } catch (Exception unused) {
                                            }
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            throw new AnnotatedException("cannot create certificate factory: " + e.getMessage(), e);
                        }
                    }
                    HashSet hashSet = new HashSet();
                    for (X509CRL x509crl2 : findCRLs) {
                        if (isDeltaCRL(x509crl2)) {
                            hashSet.add(x509crl2);
                        }
                    }
                    return hashSet;
                } catch (Exception e2) {
                    throw new AnnotatedException("Issuing distribution point extension value could not be read.", e2);
                }
            } catch (Exception e3) {
                throw new AnnotatedException("CRL number extension could not be extracted from CRL.", e3);
            }
        } catch (IOException e4) {
            throw new AnnotatedException("Cannot extract issuer from CRL.", e4);
        }
    }

    public static ASN1Primitive getExtensionValue(X509Extension x509Extension, String str) throws AnnotatedException {
        byte[] extensionValue = x509Extension.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return getObject(str, extensionValue);
    }

    public static PublicKey getNextWorkingKey(List list, int i, JcaJceHelper jcaJceHelper) throws CertPathValidatorException {
        DSAPublicKey dSAPublicKey;
        PublicKey publicKey = ((Certificate) list.get(i)).getPublicKey();
        if (!(publicKey instanceof DSAPublicKey)) {
            return publicKey;
        }
        DSAPublicKey dSAPublicKey2 = (DSAPublicKey) publicKey;
        if (dSAPublicKey2.getParams() != null) {
            return dSAPublicKey2;
        }
        do {
            i++;
            if (i < list.size()) {
                PublicKey publicKey2 = ((X509Certificate) list.get(i)).getPublicKey();
                if (publicKey2 instanceof DSAPublicKey) {
                    dSAPublicKey = (DSAPublicKey) publicKey2;
                } else {
                    throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
                }
            } else {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
        } while (dSAPublicKey.getParams() == null);
        DSAParams params = dSAPublicKey.getParams();
        try {
            return jcaJceHelper.createKeyFactory("DSA").generatePublic(new DSAPublicKeySpec(dSAPublicKey2.getY(), params.getP(), params.getQ(), params.getG()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static ASN1Primitive getObject(String str, byte[] bArr) throws AnnotatedException {
        try {
            return ASN1Primitive.fromByteArray(ASN1OctetString.getInstance(new ASN1InputStream(bArr).readObject()).getOctets());
        } catch (Exception e) {
            throw new AnnotatedException("exception processing extension " + str, e);
        }
    }

    public static final Set getQualifierSet(ASN1Sequence aSN1Sequence) throws CertPathValidatorException {
        HashSet hashSet = new HashSet();
        if (aSN1Sequence == null) {
            return hashSet;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream create = ASN1OutputStream.create(byteArrayOutputStream);
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            try {
                create.writeObject((ASN1Encodable) objects.nextElement());
                hashSet.add(new PolicyQualifierInfo(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.reset();
            } catch (IOException e) {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", e);
            }
        }
        return hashSet;
    }

    private static BigInteger getSerialNumber(Object obj) {
        return ((X509Certificate) obj).getSerialNumber();
    }

    public static Date getValidCertDateFromValidityModel(PKIXExtendedParameters pKIXExtendedParameters, CertPath certPath, int i) throws AnnotatedException {
        ASN1GeneralizedTime aSN1GeneralizedTime;
        if (pKIXExtendedParameters.getValidityModel() != 1) {
            return getValidDate(pKIXExtendedParameters);
        }
        if (i <= 0) {
            return getValidDate(pKIXExtendedParameters);
        }
        int i2 = i - 1;
        if (i2 != 0) {
            return ((X509Certificate) certPath.getCertificates().get(i2)).getNotBefore();
        }
        try {
            byte[] extensionValue = ((X509Certificate) certPath.getCertificates().get(i2)).getExtensionValue(ISISMTTObjectIdentifiers.id_isismtt_at_dateOfCertGen.getId());
            if (extensionValue != null) {
                aSN1GeneralizedTime = ASN1GeneralizedTime.getInstance(ASN1Primitive.fromByteArray(extensionValue));
            } else {
                aSN1GeneralizedTime = null;
            }
            if (aSN1GeneralizedTime == null) {
                return ((X509Certificate) certPath.getCertificates().get(i2)).getNotBefore();
            }
            try {
                return aSN1GeneralizedTime.getDate();
            } catch (ParseException e) {
                throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", e);
            }
        } catch (IOException unused) {
            throw new AnnotatedException("Date of cert gen extension could not be read.");
        } catch (IllegalArgumentException unused2) {
            throw new AnnotatedException("Date of cert gen extension could not be read.");
        }
    }

    public static Date getValidDate(PKIXExtendedParameters pKIXExtendedParameters) {
        Date date = pKIXExtendedParameters.getDate();
        if (date == null) {
            return new Date();
        }
        return date;
    }

    public static boolean isAnyPolicy(Set set) {
        if (set == null || set.contains("2.5.29.32.0") || set.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isDeltaCRL(X509CRL x509crl) {
        Set<String> criticalExtensionOIDs = x509crl.getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        return criticalExtensionOIDs.contains(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
    }

    public static boolean isIssuerTrustAnchor(X509Certificate x509Certificate, Set set, String str) throws AnnotatedException {
        try {
            if (findTrustAnchor(x509Certificate, set, str) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSelfIssued(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
    }

    public static void prepareNextCertB1(int i, List[] listArr, String str, Map map, X509Certificate x509Certificate) throws AnnotatedException, CertPathValidatorException {
        Set set;
        boolean z;
        for (PKIXPolicyNode pKIXPolicyNode : listArr[i]) {
            if (pKIXPolicyNode.getValidPolicy().equals(str)) {
                pKIXPolicyNode.expectedPolicies = (Set) map.get(str);
                return;
            }
        }
        for (PKIXPolicyNode pKIXPolicyNode2 : listArr[i]) {
            if ("2.5.29.32.0".equals(pKIXPolicyNode2.getValidPolicy())) {
                try {
                    Enumeration objects = ASN1Sequence.getInstance(getExtensionValue(x509Certificate, CERTIFICATE_POLICIES)).getObjects();
                    while (true) {
                        if (!objects.hasMoreElements()) {
                            set = null;
                            break;
                        }
                        try {
                            PolicyInformation instance = PolicyInformation.getInstance(objects.nextElement());
                            if ("2.5.29.32.0".equals(instance.getPolicyIdentifier().getId())) {
                                try {
                                    set = getQualifierSet(instance.getPolicyQualifiers());
                                    break;
                                } catch (CertPathValidatorException e) {
                                    throw new ExtCertPathValidatorException("Policy qualifier info set could not be built.", e);
                                }
                            }
                        } catch (Exception e2) {
                            throw new AnnotatedException("Policy information cannot be decoded.", e2);
                        }
                    }
                    Set set2 = set;
                    if (x509Certificate.getCriticalExtensionOIDs() != null) {
                        z = x509Certificate.getCriticalExtensionOIDs().contains(CERTIFICATE_POLICIES);
                    } else {
                        z = false;
                    }
                    boolean z2 = z;
                    PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
                    if ("2.5.29.32.0".equals(pKIXPolicyNode3.getValidPolicy())) {
                        PKIXPolicyNode pKIXPolicyNode4 = new PKIXPolicyNode(new ArrayList(), i, (Set) map.get(str), pKIXPolicyNode3, set2, str, z2);
                        pKIXPolicyNode3.addChild(pKIXPolicyNode4);
                        listArr[i].add(pKIXPolicyNode4);
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    throw new AnnotatedException("Certificate policies cannot be decoded.", e3);
                }
            }
        }
    }

    public static PKIXPolicyNode prepareNextCertB2(int i, List[] listArr, String str, PKIXPolicyNode pKIXPolicyNode) {
        Iterator it = listArr[i].iterator();
        while (it.hasNext()) {
            PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) it.next();
            if (pKIXPolicyNode2.getValidPolicy().equals(str)) {
                ((PKIXPolicyNode) pKIXPolicyNode2.getParent()).removeChild(pKIXPolicyNode2);
                it.remove();
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    List list = listArr[i2];
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) list.get(i3);
                        if (!pKIXPolicyNode3.hasChildren() && (pKIXPolicyNode = removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode3)) == null) {
                            break;
                        }
                    }
                }
            }
        }
        return pKIXPolicyNode;
    }

    public static boolean processCertD1i(int i, List[] listArr, ASN1ObjectIdentifier aSN1ObjectIdentifier, Set set) {
        List list = listArr[i - 1];
        for (int i2 = 0; i2 < list.size(); i2++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) list.get(i2);
            if (pKIXPolicyNode.getExpectedPolicies().contains(aSN1ObjectIdentifier.getId())) {
                HashSet hashSet = new HashSet();
                hashSet.add(aSN1ObjectIdentifier.getId());
                PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), i, hashSet, pKIXPolicyNode, set, aSN1ObjectIdentifier.getId(), false);
                pKIXPolicyNode.addChild(pKIXPolicyNode2);
                listArr[i].add(pKIXPolicyNode2);
                return true;
            }
        }
        return false;
    }

    public static void processCertD1ii(int i, List[] listArr, ASN1ObjectIdentifier aSN1ObjectIdentifier, Set set) {
        List list = listArr[i - 1];
        for (int i2 = 0; i2 < list.size(); i2++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) list.get(i2);
            if ("2.5.29.32.0".equals(pKIXPolicyNode.getValidPolicy())) {
                HashSet hashSet = new HashSet();
                hashSet.add(aSN1ObjectIdentifier.getId());
                PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), i, hashSet, pKIXPolicyNode, set, aSN1ObjectIdentifier.getId(), false);
                pKIXPolicyNode.addChild(pKIXPolicyNode2);
                listArr[i].add(pKIXPolicyNode2);
                return;
            }
        }
    }

    public static PKIXPolicyNode removePolicyNode(PKIXPolicyNode pKIXPolicyNode, List[] listArr, PKIXPolicyNode pKIXPolicyNode2) {
        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
        if (pKIXPolicyNode == null) {
            return null;
        }
        if (pKIXPolicyNode3 == null) {
            for (int i = 0; i < listArr.length; i++) {
                listArr[i] = new ArrayList();
            }
            return null;
        }
        pKIXPolicyNode3.removeChild(pKIXPolicyNode2);
        removePolicyNodeRecurse(listArr, pKIXPolicyNode2);
        return pKIXPolicyNode;
    }

    private static void removePolicyNodeRecurse(List[] listArr, PKIXPolicyNode pKIXPolicyNode) {
        listArr[pKIXPolicyNode.getDepth()].remove(pKIXPolicyNode);
        if (pKIXPolicyNode.hasChildren()) {
            Iterator children = pKIXPolicyNode.getChildren();
            while (children.hasNext()) {
                removePolicyNodeRecurse(listArr, (PKIXPolicyNode) children.next());
            }
        }
    }

    public static void verifyX509Certificate(X509Certificate x509Certificate, PublicKey publicKey, String str) throws GeneralSecurityException {
        if (str == null) {
            x509Certificate.verify(publicKey);
        } else {
            x509Certificate.verify(publicKey, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072 A[SYNTHETIC, Splitter:B:24:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0015 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.TrustAnchor findTrustAnchor(java.security.cert.X509Certificate r8, java.util.Set r9, java.lang.String r10) throws com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException {
        /*
            java.security.cert.X509CertSelector r0 = new java.security.cert.X509CertSelector
            r0.<init>()
            javax.security.auth.x500.X500Principal r1 = r8.getIssuerX500Principal()
            r0.setSubject(r1)
            java.util.Iterator r9 = r9.iterator()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
        L_0x0015:
            boolean r7 = r9.hasNext()
            if (r7 == 0) goto L_0x007a
            if (r3 != 0) goto L_0x007a
            java.lang.Object r3 = r9.next()
            java.security.cert.TrustAnchor r3 = (java.security.cert.TrustAnchor) r3
            java.security.cert.X509Certificate r7 = r3.getTrustedCert()
            if (r7 == 0) goto L_0x003e
            java.security.cert.X509Certificate r7 = r3.getTrustedCert()
            boolean r7 = r0.match(r7)
            if (r7 == 0) goto L_0x003c
            java.security.cert.X509Certificate r6 = r3.getTrustedCert()
            java.security.PublicKey r6 = r6.getPublicKey()
            goto L_0x0070
        L_0x003c:
            r3 = r2
            goto L_0x0070
        L_0x003e:
            javax.security.auth.x500.X500Principal r7 = r3.getCA()
            if (r7 == 0) goto L_0x003c
            java.lang.String r7 = r3.getCAName()
            if (r7 == 0) goto L_0x003c
            java.security.PublicKey r7 = r3.getCAPublicKey()
            if (r7 == 0) goto L_0x003c
            if (r5 != 0) goto L_0x005a
            byte[] r5 = r1.getEncoded()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name r5 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name.getInstance(r5)
        L_0x005a:
            javax.security.auth.x500.X500Principal r7 = r3.getCA()     // Catch:{ IllegalArgumentException -> 0x003c }
            byte[] r7 = r7.getEncoded()     // Catch:{ IllegalArgumentException -> 0x003c }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name r7 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name.getInstance(r7)     // Catch:{ IllegalArgumentException -> 0x003c }
            boolean r7 = r5.equals(r7)     // Catch:{ IllegalArgumentException -> 0x003c }
            if (r7 == 0) goto L_0x003c
            java.security.PublicKey r6 = r3.getCAPublicKey()     // Catch:{ IllegalArgumentException -> 0x003c }
        L_0x0070:
            if (r6 == 0) goto L_0x0015
            verifyX509Certificate(r8, r6, r10)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0015
        L_0x0076:
            r4 = move-exception
            r3 = r2
            r6 = r3
            goto L_0x0015
        L_0x007a:
            if (r3 != 0) goto L_0x0087
            if (r4 != 0) goto L_0x007f
            goto L_0x0087
        L_0x007f:
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException r8 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r9 = "TrustAnchor found but certificate validation failed."
            r8.<init>(r9, r4)
            throw r8
        L_0x0087:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.CertPathValidatorUtilities.findTrustAnchor(java.security.cert.X509Certificate, java.util.Set, java.lang.String):java.security.cert.TrustAnchor");
    }
}
