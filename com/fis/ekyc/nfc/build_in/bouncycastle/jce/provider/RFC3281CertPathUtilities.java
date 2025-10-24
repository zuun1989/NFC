package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extension;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.TargetInformation;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.X509Extensions;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertStoreSelector;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.exception.ExtCertPathValidatorException;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.PKIXAttrCertChecker;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertStoreSelector;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

class RFC3281CertPathUtilities {
    private static final String AUTHORITY_INFO_ACCESS = Extension.authorityInfoAccess.getId();
    private static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
    private static final String NO_REV_AVAIL = Extension.noRevAvail.getId();
    private static final String TARGET_INFORMATION = Extension.targetInformation.getId();

    public static void additionalChecks(X509AttributeCertificate x509AttributeCertificate, Set set, Set set2) throws CertPathValidatorException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (x509AttributeCertificate.getAttributes(str) != null) {
                throw new CertPathValidatorException("Attribute certificate contains prohibited attribute: " + str + ".");
            }
        }
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (x509AttributeCertificate.getAttributes(str2) == null) {
                throw new CertPathValidatorException("Attribute certificate does not contain necessary attribute: " + str2 + ".");
            }
        }
    }

    private static void checkCRL(DistributionPoint distributionPoint, X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters, Date date, X509Certificate x509Certificate, CertStatus certStatus, ReasonsMask reasonsMask, List list, JcaJceHelper jcaJceHelper) throws AnnotatedException, RecoverableCertPathValidatorException {
        Iterator it;
        X509CRL x509crl;
        DistributionPoint distributionPoint2 = distributionPoint;
        X509AttributeCertificate x509AttributeCertificate2 = x509AttributeCertificate;
        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParameters;
        Date date2 = date;
        CertStatus certStatus2 = certStatus;
        ReasonsMask reasonsMask2 = reasonsMask;
        if (x509AttributeCertificate2.getExtensionValue(X509Extensions.NoRevAvail.getId()) == null) {
            Date date3 = new Date(System.currentTimeMillis());
            if (date.getTime() <= date3.getTime()) {
                Iterator it2 = CertPathValidatorUtilities.getCompleteCRLs(new PKIXCertRevocationCheckerParameters(pKIXExtendedParameters, date, (CertPath) null, -1, x509Certificate, (PublicKey) null), distributionPoint2, x509AttributeCertificate2, date3, pKIXExtendedParameters2).iterator();
                boolean z = false;
                e = null;
                while (it2.hasNext() && certStatus.getCertStatus() == 11 && !reasonsMask.isAllReasons()) {
                    try {
                        X509CRL x509crl2 = (X509CRL) it2.next();
                        ReasonsMask processCRLD = RFC3280CertPathUtilities.processCRLD(x509crl2, distributionPoint2);
                        if (!processCRLD.hasNewReasons(reasonsMask2)) {
                            continue;
                        } else {
                            ReasonsMask reasonsMask3 = processCRLD;
                            it = it2;
                            try {
                                X509CRL x509crl3 = x509crl2;
                                PublicKey processCRLG = RFC3280CertPathUtilities.processCRLG(x509crl3, RFC3280CertPathUtilities.processCRLF(x509crl2, x509AttributeCertificate, (X509Certificate) null, (PublicKey) null, pKIXExtendedParameters, list, jcaJceHelper));
                                if (pKIXExtendedParameters.isUseDeltasEnabled()) {
                                    try {
                                        x509crl = RFC3280CertPathUtilities.processCRLH(CertPathValidatorUtilities.getDeltaCRLs(date3, x509crl3, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores(), jcaJceHelper), processCRLG);
                                    } catch (AnnotatedException e) {
                                        e = e;
                                        it2 = it;
                                    }
                                } else {
                                    JcaJceHelper jcaJceHelper2 = jcaJceHelper;
                                    x509crl = null;
                                }
                                if (pKIXExtendedParameters.getValidityModel() != 1) {
                                    if (x509AttributeCertificate.getNotAfter().getTime() < x509crl3.getThisUpdate().getTime()) {
                                        throw new AnnotatedException("No valid CRL for current time found.");
                                    }
                                }
                                RFC3280CertPathUtilities.processCRLB1(distributionPoint2, x509AttributeCertificate2, x509crl3);
                                RFC3280CertPathUtilities.processCRLB2(distributionPoint2, x509AttributeCertificate2, x509crl3);
                                RFC3280CertPathUtilities.processCRLC(x509crl, x509crl3, pKIXExtendedParameters2);
                                RFC3280CertPathUtilities.processCRLI(date2, x509crl, x509AttributeCertificate2, certStatus2, pKIXExtendedParameters2);
                                RFC3280CertPathUtilities.processCRLJ(date2, x509crl3, x509AttributeCertificate2, certStatus2);
                                if (certStatus.getCertStatus() == 8) {
                                    certStatus2.setCertStatus(11);
                                }
                                reasonsMask2.addReasons(reasonsMask3);
                                it2 = it;
                                z = true;
                            } catch (AnnotatedException e2) {
                                e = e2;
                                JcaJceHelper jcaJceHelper3 = jcaJceHelper;
                                it2 = it;
                            }
                        }
                    } catch (AnnotatedException e3) {
                        e = e3;
                        JcaJceHelper jcaJceHelper4 = jcaJceHelper;
                        it = it2;
                        it2 = it;
                    }
                }
                if (!z) {
                    throw e;
                }
                return;
            }
            throw new AnnotatedException("Validation time is in future.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x016f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void checkCRLs(com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertificate r19, com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters r20, java.security.cert.X509Certificate r21, java.util.Date r22, java.util.List r23, com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper r24) throws java.security.cert.CertPathValidatorException {
        /*
            r10 = r19
            boolean r0 = r20.isRevocationEnabled()
            if (r0 == 0) goto L_0x01a2
            java.lang.String r0 = NO_REV_AVAIL
            byte[] r0 = r10.getExtensionValue(r0)
            if (r0 != 0) goto L_0x0189
            java.lang.String r0 = CRL_DISTRIBUTION_POINTS     // Catch:{ AnnotatedException -> 0x0180 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r10, r0)     // Catch:{ AnnotatedException -> 0x0180 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CRLDistPoint r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CRLDistPoint.getInstance(r0)     // Catch:{ AnnotatedException -> 0x0180 }
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r2 = r20.getNamedCRLStoreMap()     // Catch:{ AnnotatedException -> 0x0177 }
            r11 = r22
            r12 = r24
            java.util.List r2 = com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.CertPathValidatorUtilities.getAdditionalStoresFromCRLDistributionPoint(r0, r2, r11, r12)     // Catch:{ AnnotatedException -> 0x0177 }
            r1.addAll(r2)     // Catch:{ AnnotatedException -> 0x0177 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters$Builder r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters$Builder
            r3 = r20
            r2.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters) r3)
            java.util.Iterator r3 = r1.iterator()
        L_0x0039:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0046
            r4 = r1
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCRLStore r4 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCRLStore) r4
            r2.addCRLStore(r4)
            goto L_0x0039
        L_0x0046:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters r13 = r2.build()
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.CertStatus r14 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.CertStatus
            r14.<init>()
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.ReasonsMask r15 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.ReasonsMask
            r15.<init>()
            java.lang.String r9 = "No valid CRL for distribution point found."
            r16 = 1
            r8 = 0
            r7 = 0
            r6 = 11
            if (r0 == 0) goto L_0x00b5
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPoint[] r0 = r0.getDistributionPoints()     // Catch:{ Exception -> 0x00ab }
            r5 = r8
            r17 = r5
        L_0x0065:
            int r1 = r0.length     // Catch:{ AnnotatedException -> 0x009e }
            if (r5 >= r1) goto L_0x00a1
            int r1 = r14.getCertStatus()     // Catch:{ AnnotatedException -> 0x009e }
            if (r1 != r6) goto L_0x00a1
            boolean r1 = r15.isAllReasons()     // Catch:{ AnnotatedException -> 0x009e }
            if (r1 != 0) goto L_0x00a1
            java.lang.Object r1 = r13.clone()     // Catch:{ AnnotatedException -> 0x009e }
            r3 = r1
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters) r3     // Catch:{ AnnotatedException -> 0x009e }
            r1 = r0[r5]     // Catch:{ AnnotatedException -> 0x009e }
            r2 = r19
            r4 = r22
            r18 = r5
            r5 = r21
            r11 = r6
            r6 = r14
            r7 = r15
            r8 = r23
            r11 = r9
            r9 = r24
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ AnnotatedException -> 0x009c }
            int r5 = r18 + 1
            r9 = r11
            r17 = r16
            r6 = 11
            r7 = 0
            r8 = 0
            r11 = r22
            goto L_0x0065
        L_0x009c:
            r0 = move-exception
            goto L_0x00a4
        L_0x009e:
            r0 = move-exception
            r11 = r9
            goto L_0x00a4
        L_0x00a1:
            r11 = r9
            r0 = 0
            goto L_0x00b9
        L_0x00a4:
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException
            r7.<init>(r11, r0)
            r0 = r7
            goto L_0x00b9
        L_0x00ab:
            r0 = move-exception
            r1 = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "Distribution points could not be read."
            r0.<init>(r2, r1)
            throw r0
        L_0x00b5:
            r11 = r9
            r0 = 0
            r17 = 0
        L_0x00b9:
            int r1 = r14.getCertStatus()
            r2 = 11
            if (r1 != r2) goto L_0x010c
            boolean r1 = r15.isAllReasons()
            if (r1 != 0) goto L_0x010c
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name r1 = com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PrincipalUtils.getEncodedIssuerPrincipal(r19)     // Catch:{ Exception -> 0x00fc }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPoint r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPoint     // Catch:{ AnnotatedException -> 0x00fa }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPointName r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPointName     // Catch:{ AnnotatedException -> 0x00fa }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralNames r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralNames     // Catch:{ AnnotatedException -> 0x00fa }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName     // Catch:{ AnnotatedException -> 0x00fa }
            r6 = 4
            r5.<init>((int) r6, (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r1)     // Catch:{ AnnotatedException -> 0x00fa }
            r4.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName) r5)     // Catch:{ AnnotatedException -> 0x00fa }
            r1 = 0
            r3.<init>(r1, r4)     // Catch:{ AnnotatedException -> 0x00fa }
            r1 = 0
            r2.<init>(r3, r1, r1)     // Catch:{ AnnotatedException -> 0x00fa }
            java.lang.Object r1 = r13.clone()     // Catch:{ AnnotatedException -> 0x00fa }
            r3 = r1
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters) r3     // Catch:{ AnnotatedException -> 0x00fa }
            r1 = r2
            r2 = r19
            r4 = r22
            r5 = r21
            r6 = r14
            r7 = r15
            r8 = r23
            r9 = r24
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ AnnotatedException -> 0x00fa }
            goto L_0x010e
        L_0x00fa:
            r0 = move-exception
            goto L_0x0106
        L_0x00fc:
            r0 = move-exception
            r1 = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00fa }
            java.lang.String r2 = "Issuer from certificate for CRL could not be reencoded."
            r0.<init>(r2, r1)     // Catch:{ AnnotatedException -> 0x00fa }
            throw r0     // Catch:{ AnnotatedException -> 0x00fa }
        L_0x0106:
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException
            r1.<init>(r11, r0)
            r0 = r1
        L_0x010c:
            r16 = r17
        L_0x010e:
            if (r16 == 0) goto L_0x016f
            int r0 = r14.getCertStatus()
            r1 = 11
            if (r0 != r1) goto L_0x0138
            boolean r0 = r15.isAllReasons()
            r2 = 12
            if (r0 != 0) goto L_0x0129
            int r0 = r14.getCertStatus()
            if (r0 != r1) goto L_0x0129
            r14.setCertStatus(r2)
        L_0x0129:
            int r0 = r14.getCertStatus()
            if (r0 == r2) goto L_0x0130
            goto L_0x01a2
        L_0x0130:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Attribute certificate status could not be determined."
            r0.<init>(r1)
            throw r0
        L_0x0138:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Attribute certificate revocation after "
            r0.append(r1)
            java.util.Date r1 = r14.getRevocationDate()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = ", reason: "
            r1.append(r0)
            java.lang.String[] r0 = com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.RFC3280CertPathUtilities.crlReasons
            int r2 = r14.getCertStatus()
            r0 = r0[r2]
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            r1.<init>(r0)
            throw r1
        L_0x016f:
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.exception.ExtCertPathValidatorException r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "No valid CRL found."
            r1.<init>(r2, r0)
            throw r1
        L_0x0177:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "No additional CRL locations could be decoded from CRL distribution point extension."
            r1.<init>(r2, r0)
            throw r1
        L_0x0180:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "CRL distribution point extension could not be read."
            r1.<init>(r2, r0)
            throw r1
        L_0x0189:
            java.lang.String r0 = CRL_DISTRIBUTION_POINTS
            byte[] r0 = r10.getExtensionValue(r0)
            if (r0 != 0) goto L_0x019a
            java.lang.String r0 = AUTHORITY_INFO_ACCESS
            byte[] r0 = r10.getExtensionValue(r0)
            if (r0 != 0) goto L_0x019a
            goto L_0x01a2
        L_0x019a:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "No rev avail extension is set, but also an AC revocation pointer."
            r0.<init>(r1)
            throw r0
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.RFC3281CertPathUtilities.checkCRLs(com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertificate, com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters, java.security.cert.X509Certificate, java.util.Date, java.util.List, com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper):void");
    }

    public static CertPath processAttrCert1(X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters) throws CertPathValidatorException {
        HashSet<X509Certificate> hashSet = new HashSet<>();
        int i = 0;
        if (x509AttributeCertificate.getHolder().getIssuer() != null) {
            X509CertSelector x509CertSelector = new X509CertSelector();
            x509CertSelector.setSerialNumber(x509AttributeCertificate.getHolder().getSerialNumber());
            Principal[] issuer = x509AttributeCertificate.getHolder().getIssuer();
            int i2 = 0;
            while (i2 < issuer.length) {
                try {
                    Principal principal = issuer[i2];
                    if (principal instanceof X500Principal) {
                        x509CertSelector.setIssuer(((X500Principal) principal).getEncoded());
                    }
                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(new PKIXCertStoreSelector.Builder(x509CertSelector).build(), pKIXExtendedParameters.getCertStores()));
                    i2++;
                } catch (AnnotatedException e) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e);
                } catch (IOException e2) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e2);
                }
            }
            if (hashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in base certificate ID for attribute certificate cannot be found.");
            }
        }
        if (x509AttributeCertificate.getHolder().getEntityNames() != null) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            Principal[] entityNames = x509AttributeCertificate.getHolder().getEntityNames();
            while (i < entityNames.length) {
                try {
                    Principal principal2 = entityNames[i];
                    if (principal2 instanceof X500Principal) {
                        x509CertStoreSelector.setIssuer(((X500Principal) principal2).getEncoded());
                    }
                    hashSet.addAll(CertPathValidatorUtilities.findCertificates(new PKIXCertStoreSelector.Builder(x509CertStoreSelector).build(), pKIXExtendedParameters.getCertStores()));
                    i++;
                } catch (AnnotatedException e3) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e3);
                } catch (IOException e4) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e4);
                }
            }
            if (hashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in entity name for attribute certificate cannot be found.");
            }
        }
        PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder(pKIXExtendedParameters);
        ExtCertPathValidatorException extCertPathValidatorException = null;
        CertPathBuilderResult certPathBuilderResult = null;
        for (X509Certificate certificate : hashSet) {
            X509CertStoreSelector x509CertStoreSelector2 = new X509CertStoreSelector();
            x509CertStoreSelector2.setCertificate(certificate);
            builder.setTargetConstraints(new PKIXCertStoreSelector.Builder(x509CertStoreSelector2).build());
            try {
                try {
                    certPathBuilderResult = CertPathBuilder.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).build(new PKIXExtendedBuilderParameters.Builder(builder.build()).build());
                } catch (CertPathBuilderException e5) {
                    extCertPathValidatorException = new ExtCertPathValidatorException("Certification path for public key certificate of attribute certificate could not be build.", e5);
                } catch (InvalidAlgorithmParameterException e6) {
                    throw new RuntimeException(e6.getMessage());
                }
            } catch (NoSuchProviderException e7) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e7);
            } catch (NoSuchAlgorithmException e8) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e8);
            }
        }
        if (extCertPathValidatorException == null) {
            return certPathBuilderResult.getCertPath();
        }
        throw extCertPathValidatorException;
    }

    public static CertPathValidatorResult processAttrCert2(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters) throws CertPathValidatorException {
        try {
            try {
                return CertPathValidator.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).validate(certPath, pKIXExtendedParameters);
            } catch (CertPathValidatorException e) {
                throw new ExtCertPathValidatorException("Certification path for issuer certificate of attribute certificate could not be validated.", e);
            } catch (InvalidAlgorithmParameterException e2) {
                throw new RuntimeException(e2.getMessage());
            }
        } catch (NoSuchProviderException e3) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e4);
        }
    }

    public static void processAttrCert3(X509Certificate x509Certificate, PKIXExtendedParameters pKIXExtendedParameters) throws CertPathValidatorException {
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (keyUsage != null && ((keyUsage.length <= 0 || !keyUsage[0]) && (keyUsage.length <= 1 || !keyUsage[1]))) {
            throw new CertPathValidatorException("Attribute certificate issuer public key cannot be used to validate digital signatures.");
        } else if (x509Certificate.getBasicConstraints() != -1) {
            throw new CertPathValidatorException("Attribute certificate issuer is also a public key certificate issuer.");
        }
    }

    public static void processAttrCert4(X509Certificate x509Certificate, Set set) throws CertPathValidatorException {
        Iterator it = set.iterator();
        boolean z = false;
        while (it.hasNext()) {
            TrustAnchor trustAnchor = (TrustAnchor) it.next();
            if (x509Certificate.getSubjectX500Principal().getName("RFC2253").equals(trustAnchor.getCAName()) || x509Certificate.equals(trustAnchor.getTrustedCert())) {
                z = true;
            }
        }
        if (!z) {
            throw new CertPathValidatorException("Attribute certificate issuer is not directly trusted.");
        }
    }

    public static void processAttrCert5(X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters) throws CertPathValidatorException {
        try {
            x509AttributeCertificate.checkValidity(CertPathValidatorUtilities.getValidDate(pKIXExtendedParameters));
        } catch (CertificateExpiredException e) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e);
        } catch (CertificateNotYetValidException e2) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e2);
        }
    }

    public static void processAttrCert7(X509AttributeCertificate x509AttributeCertificate, CertPath certPath, CertPath certPath2, PKIXExtendedParameters pKIXExtendedParameters, Set set) throws CertPathValidatorException {
        Set<String> criticalExtensionOIDs = x509AttributeCertificate.getCriticalExtensionOIDs();
        String str = TARGET_INFORMATION;
        if (criticalExtensionOIDs.contains(str)) {
            try {
                TargetInformation.getInstance(CertPathValidatorUtilities.getExtensionValue(x509AttributeCertificate, str));
            } catch (AnnotatedException e) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e);
            } catch (IllegalArgumentException e2) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e2);
            }
        }
        criticalExtensionOIDs.remove(str);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((PKIXAttrCertChecker) it.next()).check(x509AttributeCertificate, certPath, certPath2, criticalExtensionOIDs);
        }
        if (!criticalExtensionOIDs.isEmpty()) {
            throw new CertPathValidatorException("Attribute certificate contains unsupported critical extensions: " + criticalExtensionOIDs);
        }
    }
}
