package com.fis.ekyc.nfc.build_in.bouncycastle.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERIA5String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AccessDescription;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AuthorityInformationAccess;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.BasicConstraints;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CRLDistPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DistributionPointName;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extension;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralNames;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralSubtree;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.NameConstraints;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.qualified.ETSIQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.qualified.MonetaryValue;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.qualified.QCStatement;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.qualified.RFC3739QCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle;
import com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput;
import com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.AnnotatedException;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXNameConstraintValidator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXNameConstraintValidatorException;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;

public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final String AUTH_INFO_ACCESS = Extension.authorityInfoAccess.getId();
    private static final String CRL_DIST_POINTS = Extension.cRLDistributionPoints.getId();
    private static final String QC_STATEMENT = Extension.qCStatements.getId();
    private static final String RESOURCE_NAME = "com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerMessages";
    protected CertPath certPath;
    protected List certs;
    protected List[] errors;
    private boolean initialized;
    protected int n;
    protected List[] notifications;
    protected PKIXParameters pkixParams;
    protected PolicyNode policyTree;
    protected PublicKey subjectPublicKey;
    protected TrustAnchor trustAnchor;
    protected Date validDate;

    public PKIXCertPathReviewer(CertPath certPath2, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        init(certPath2, pKIXParameters);
    }

    private String IPtoString(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i != bArr.length; i++) {
                stringBuffer.append(Integer.toHexString(bArr[i] & 255));
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }

    private void checkCriticalExtensions() {
        int size;
        List<PKIXCertPathChecker> certPathCheckers = this.pkixParams.getCertPathCheckers();
        for (PKIXCertPathChecker init : certPathCheckers) {
            try {
                init.init(false);
            } catch (CertPathValidatorException e) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.criticalExtensionError", new Object[]{e.getMessage(), e, e.getClass().getName()}), e.getCause(), this.certPath, size);
            } catch (CertPathValidatorException e2) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathCheckerError", new Object[]{e2.getMessage(), e2, e2.getClass().getName()}), e2);
            } catch (CertPathReviewerException e3) {
                addError(e3.getErrorMessage(), e3.getIndex());
                return;
            }
        }
        size = this.certs.size() - 1;
        while (size >= 0) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null) {
                if (!criticalExtensionOIDs.isEmpty()) {
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.KEY_USAGE);
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.CERTIFICATE_POLICIES);
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_MAPPINGS);
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.INHIBIT_ANY_POLICY);
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT);
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.DELTA_CRL_INDICATOR);
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_CONSTRAINTS);
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.BASIC_CONSTRAINTS);
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                    criticalExtensionOIDs.remove(CertPathValidatorUtilities.NAME_CONSTRAINTS);
                    String str = QC_STATEMENT;
                    if (criticalExtensionOIDs.contains(str) && processQcStatements(x509Certificate, size)) {
                        criticalExtensionOIDs.remove(str);
                    }
                    for (PKIXCertPathChecker check : certPathCheckers) {
                        check.check(x509Certificate, criticalExtensionOIDs);
                    }
                    if (!criticalExtensionOIDs.isEmpty()) {
                        for (String aSN1ObjectIdentifier : criticalExtensionOIDs) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknownCriticalExt", new Object[]{new ASN1ObjectIdentifier(aSN1ObjectIdentifier)}), size);
                        }
                    }
                }
            }
            size--;
        }
    }

    private void checkNameConstraints() {
        GeneralName instance;
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        for (int size = this.certs.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                X500Principal subjectPrincipal = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate);
                try {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream((InputStream) new ByteArrayInputStream(subjectPrincipal.getEncoded())).readObject();
                    pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                    pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                    if (aSN1Sequence2 != null) {
                        for (int i = 0; i < aSN1Sequence2.size(); i++) {
                            instance = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i));
                            pKIXNameConstraintValidator.checkPermitted(instance);
                            pKIXNameConstraintValidator.checkExcluded(instance);
                        }
                    }
                } catch (AnnotatedException e) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncExtError"), e, this.certPath, size);
                } catch (IOException e2) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e2, this.certPath, size);
                } catch (PKIXNameConstraintValidatorException e3) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e3, this.certPath, size);
                } catch (PKIXNameConstraintValidatorException e4) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                } catch (AnnotatedException e5) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), e5, this.certPath, size);
                } catch (PKIXNameConstraintValidatorException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(instance)}), e6, this.certPath, size);
                } catch (CertPathReviewerException e7) {
                    addError(e7.getErrorMessage(), e7.getIndex());
                    return;
                }
            }
            ASN1Sequence aSN1Sequence3 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.NAME_CONSTRAINTS);
            if (aSN1Sequence3 != null) {
                NameConstraints instance2 = NameConstraints.getInstance(aSN1Sequence3);
                GeneralSubtree[] permittedSubtrees = instance2.getPermittedSubtrees();
                if (permittedSubtrees != null) {
                    pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                }
                GeneralSubtree[] excludedSubtrees = instance2.getExcludedSubtrees();
                if (excludedSubtrees != null) {
                    for (int i2 = 0; i2 != excludedSubtrees.length; i2++) {
                        pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i2]);
                    }
                }
            }
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        BigInteger pathLenConstraint;
        int intValue;
        int i = this.n;
        int i2 = 0;
        for (int size = this.certs.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                if (i <= 0) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pathLengthExtended"));
                }
                i--;
                i2++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (!(basicConstraints == null || (pathLenConstraint = basicConstraints.getPathLenConstraint()) == null || (intValue = pathLenConstraint.intValue()) >= i)) {
                i = intValue;
            }
        }
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.totalPathLength", new Object[]{Integers.valueOf(i2)}));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0403, code lost:
        throw new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException(new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyInhibitExtError"), r1.certPath, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getQualifierSet(r2.getPolicyQualifiers());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r2 = r5[r4 - 1];
        r30 = r13;
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0169, code lost:
        if (r15 >= r2.size()) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x016b, code lost:
        r13 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r2.get(r15);
        r31 = r13.getExpectedPolicies().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x017d, code lost:
        if (r31.hasNext() == false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017f, code lost:
        r32 = r2;
        r2 = r31.next();
        r33 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0189, code lost:
        if ((r2 instanceof java.lang.String) == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018b, code lost:
        r2 = (java.lang.String) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0190, code lost:
        if ((r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) == false) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0192, code lost:
        r2 = ((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r2).getId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0198, code lost:
        r10 = r13.getChildren();
        r17 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a2, code lost:
        if (r10.hasNext() == false) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a4, code lost:
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b4, code lost:
        if (r2.equals(((com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r10.next()).getValidPolicy()) == false) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b6, code lost:
        r17 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01b8, code lost:
        r10 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01bb, code lost:
        if (r17 != false) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01bd, code lost:
        r10 = new java.util.HashSet();
        r10.add(r2);
        r34 = r11;
        r17 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode(new java.util.ArrayList(), r4, r10, r13, r0, r2, false);
        r13.addChild(r17);
        r5[r4].add(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e8, code lost:
        r34 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01ea, code lost:
        r2 = r32;
        r10 = r33;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f1, code lost:
        r2 = r32;
        r10 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f6, code lost:
        r32 = r2;
        r33 = r10;
        r34 = r11;
        r15 = r15 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0200, code lost:
        r33 = r10;
        r34 = r11;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:216:0x03f5 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0219 A[Catch:{ AnnotatedException -> 0x05ee, AnnotatedException -> 0x0439, AnnotatedException -> 0x0413, AnnotatedException -> 0x0404, AnnotatedException -> 0x0365, CertPathValidatorException -> 0x0356, CertPathValidatorException -> 0x0205, CertPathValidatorException -> 0x00e3, CertPathReviewerException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0242 A[Catch:{ AnnotatedException -> 0x05ee, AnnotatedException -> 0x0439, AnnotatedException -> 0x0413, AnnotatedException -> 0x0404, AnnotatedException -> 0x0365, CertPathValidatorException -> 0x0356, CertPathValidatorException -> 0x0205, CertPathValidatorException -> 0x00e3, CertPathReviewerException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x012e A[EDGE_INSN: B:351:0x012e->B:64:0x012e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0123 A[Catch:{ AnnotatedException -> 0x05ee, AnnotatedException -> 0x0439, AnnotatedException -> 0x0413, AnnotatedException -> 0x0404, AnnotatedException -> 0x0365, CertPathValidatorException -> 0x0356, CertPathValidatorException -> 0x0205, CertPathValidatorException -> 0x00e3, CertPathReviewerException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0140 A[Catch:{ AnnotatedException -> 0x05ee, AnnotatedException -> 0x0439, AnnotatedException -> 0x0413, AnnotatedException -> 0x0404, AnnotatedException -> 0x0365, CertPathValidatorException -> 0x0356, CertPathValidatorException -> 0x0205, CertPathValidatorException -> 0x00e3, CertPathReviewerException -> 0x00e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkPolicy() {
        /*
            r35 = this;
            r1 = r35
            java.lang.String r2 = "CertPathReviewer.policyExtError"
            java.security.cert.PKIXParameters r0 = r1.pkixParams
            java.util.Set r0 = r0.getInitialPolicies()
            int r3 = r1.n
            r4 = 1
            int r3 = r3 + r4
            java.util.ArrayList[] r5 = new java.util.ArrayList[r3]
            r6 = 0
            r7 = r6
        L_0x0012:
            if (r7 >= r3) goto L_0x001e
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r5[r7] = r8
            int r7 = r7 + 1
            goto L_0x0012
        L_0x001e:
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            java.lang.String r7 = "2.5.29.32.0"
            r11.add(r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r15 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
            java.lang.String r14 = "2.5.29.32.0"
            r16 = 0
            r10 = 0
            r12 = 0
            r8 = r15
            r4 = r15
            r15 = r16
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            r8 = r5[r6]
            r8.add(r4)
            java.security.cert.PKIXParameters r8 = r1.pkixParams
            boolean r8 = r8.isExplicitPolicyRequired()
            if (r8 == 0) goto L_0x0051
            r8 = r6
            r9 = 1
            goto L_0x0055
        L_0x0051:
            int r8 = r1.n
            r9 = 1
            int r8 = r8 + r9
        L_0x0055:
            java.security.cert.PKIXParameters r10 = r1.pkixParams
            boolean r10 = r10.isAnyPolicyInhibited()
            if (r10 == 0) goto L_0x005f
            r10 = r6
            goto L_0x0062
        L_0x005f:
            int r10 = r1.n
            int r10 = r10 + r9
        L_0x0062:
            java.security.cert.PKIXParameters r11 = r1.pkixParams
            boolean r11 = r11.isPolicyMappingInhibited()
            if (r11 == 0) goto L_0x006c
            r11 = r6
            goto L_0x006f
        L_0x006c:
            int r11 = r1.n
            int r11 = r11 + r9
        L_0x006f:
            java.util.List r12 = r1.certs     // Catch:{ CertPathReviewerException -> 0x00e0 }
            int r12 = r12.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            int r12 = r12 - r9
            r15 = r4
            r4 = 0
            r13 = 0
        L_0x0079:
            java.lang.String r14 = "CertPathReviewer.policyConstExtError"
            java.lang.String r9 = "com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerMessages"
            if (r12 < 0) goto L_0x0448
            int r4 = r1.n     // Catch:{ CertPathReviewerException -> 0x00e0 }
            int r4 = r4 - r12
            java.util.List r6 = r1.certs     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.Object r6 = r6.get(r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r25 = r3
            java.lang.String r3 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.CERTIFICATE_POLICIES     // Catch:{ AnnotatedException -> 0x0439 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r3 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r6, r3)     // Catch:{ AnnotatedException -> 0x0439 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence) r3     // Catch:{ AnnotatedException -> 0x0439 }
            r26 = r14
            java.lang.String r14 = "CertPathReviewer.policyQualifierError"
            if (r3 == 0) goto L_0x0260
            if (r15 == 0) goto L_0x0260
            java.util.Enumeration r17 = r3.getObjects()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r27 = r0
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.<init>()     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x00a7:
            boolean r18 = r17.hasMoreElements()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r18 == 0) goto L_0x00f6
            java.lang.Object r18 = r17.nextElement()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.PolicyInformation r18 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.PolicyInformation.getInstance(r18)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r28 = r15
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r15 = r18.getPolicyIdentifier()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r29 = r2
            java.lang.String r2 = r15.getId()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.add(r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r2 = r15.getId()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r2 = r7.equals(r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r2 != 0) goto L_0x00f1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r2 = r18.getPolicyQualifiers()     // Catch:{ CertPathValidatorException -> 0x00e3 }
            java.util.Set r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getQualifierSet(r2)     // Catch:{ CertPathValidatorException -> 0x00e3 }
            boolean r18 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.processCertD1i(r4, r5, r15, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r18 != 0) goto L_0x00f1
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.processCertD1ii(r4, r5, r15, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            goto L_0x00f1
        L_0x00e0:
            r0 = move-exception
            goto L_0x05fb
        L_0x00e3:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r9, r14)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r3.<init>(r2, r0, r4, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x00f1:
            r15 = r28
            r2 = r29
            goto L_0x00a7
        L_0x00f6:
            r29 = r2
            r28 = r15
            if (r13 == 0) goto L_0x0120
            boolean r2 = r13.contains(r7)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r2 == 0) goto L_0x0103
            goto L_0x0120
        L_0x0103:
            java.util.Iterator r2 = r13.iterator()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.util.HashSet r13 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r13.<init>()     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x010c:
            boolean r15 = r2.hasNext()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r15 == 0) goto L_0x0121
            java.lang.Object r15 = r2.next()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r17 = r0.contains(r15)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r17 == 0) goto L_0x010c
            r13.add(r15)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            goto L_0x010c
        L_0x0120:
            r13 = r0
        L_0x0121:
            if (r10 > 0) goto L_0x0136
            int r0 = r1.n     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r4 >= r0) goto L_0x012e
            boolean r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.isSelfIssued(r6)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r0 == 0) goto L_0x012e
            goto L_0x0136
        L_0x012e:
            r33 = r10
            r34 = r11
            r30 = r13
            goto L_0x0213
        L_0x0136:
            java.util.Enumeration r0 = r3.getObjects()     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x013a:
            boolean r2 = r0.hasMoreElements()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r2 == 0) goto L_0x012e
            java.lang.Object r2 = r0.nextElement()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.PolicyInformation r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.PolicyInformation.getInstance(r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r15 = r2.getPolicyIdentifier()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r15 = r15.getId()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r15 = r7.equals(r15)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r15 == 0) goto L_0x013a
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r0 = r2.getPolicyQualifiers()     // Catch:{ CertPathValidatorException -> 0x0205 }
            java.util.Set r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getQualifierSet(r0)     // Catch:{ CertPathValidatorException -> 0x0205 }
            int r2 = r4 + -1
            r2 = r5[r2]     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r30 = r13
            r15 = 0
        L_0x0165:
            int r13 = r2.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r15 >= r13) goto L_0x0200
            java.lang.Object r13 = r2.get(r15)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r13 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r13     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.util.Set r17 = r13.getExpectedPolicies()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.util.Iterator r31 = r17.iterator()     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0179:
            boolean r17 = r31.hasNext()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r17 == 0) goto L_0x01f6
            r32 = r2
            java.lang.Object r2 = r31.next()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r33 = r10
            boolean r10 = r2 instanceof java.lang.String     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r10 == 0) goto L_0x018e
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
            goto L_0x0198
        L_0x018e:
            boolean r10 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r10 == 0) goto L_0x01f1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r2 = r2.getId()     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0198:
            java.util.Iterator r10 = r13.getChildren()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r17 = 0
        L_0x019e:
            boolean r18 = r10.hasNext()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r18 == 0) goto L_0x01bb
            java.lang.Object r18 = r10.next()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r18 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r18     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r19 = r10
            java.lang.String r10 = r18.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r10 = r2.equals(r10)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r10 == 0) goto L_0x01b8
            r17 = 1
        L_0x01b8:
            r10 = r19
            goto L_0x019e
        L_0x01bb:
            if (r17 != 0) goto L_0x01e8
            java.util.HashSet r10 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r10.<init>()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r10.add(r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r34 = r11
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.util.ArrayList r18 = new java.util.ArrayList     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r18.<init>()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r24 = 0
            r17 = r11
            r19 = r4
            r20 = r10
            r21 = r13
            r22 = r0
            r23 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r13.addChild(r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2 = r5[r4]     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.add(r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            goto L_0x01ea
        L_0x01e8:
            r34 = r11
        L_0x01ea:
            r2 = r32
            r10 = r33
            r11 = r34
            goto L_0x0179
        L_0x01f1:
            r2 = r32
            r10 = r33
            goto L_0x0179
        L_0x01f6:
            r32 = r2
            r33 = r10
            r34 = r11
            int r15 = r15 + 1
            goto L_0x0165
        L_0x0200:
            r33 = r10
            r34 = r11
            goto L_0x0213
        L_0x0205:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r9, r14)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r3.<init>(r2, r0, r4, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0213:
            int r0 = r4 + -1
            r15 = r28
        L_0x0217:
            if (r0 < 0) goto L_0x023c
            r2 = r5[r0]     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r10 = 0
        L_0x021c:
            int r11 = r2.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r10 >= r11) goto L_0x0239
            java.lang.Object r11 = r2.get(r10)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r11 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r11     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r13 = r11.hasChildren()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r13 != 0) goto L_0x0236
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r11 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.removePolicyNode(r15, r5, r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r15 = r11
            if (r11 != 0) goto L_0x0236
            goto L_0x0239
        L_0x0236:
            int r10 = r10 + 1
            goto L_0x021c
        L_0x0239:
            int r0 = r0 + -1
            goto L_0x0217
        L_0x023c:
            java.util.Set r0 = r6.getCriticalExtensionOIDs()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r0 == 0) goto L_0x025d
            java.lang.String r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.CERTIFICATE_POLICIES     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r0 = r0.contains(r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2 = r5[r4]     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r10 = 0
        L_0x024b:
            int r11 = r2.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r10 >= r11) goto L_0x025d
            java.lang.Object r11 = r2.get(r10)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r11 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r11     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r11.setCritical(r0)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            int r10 = r10 + 1
            goto L_0x024b
        L_0x025d:
            r13 = r30
            goto L_0x026c
        L_0x0260:
            r27 = r0
            r29 = r2
            r33 = r10
            r34 = r11
            r28 = r15
            r15 = r28
        L_0x026c:
            if (r3 != 0) goto L_0x026f
            r15 = 0
        L_0x026f:
            if (r8 > 0) goto L_0x0281
            if (r15 == 0) goto L_0x0274
            goto L_0x0281
        L_0x0274:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r2 = "CertPathReviewer.noValidPolicyTree"
            r0.<init>(r9, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0281:
            int r0 = r1.n     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r4 == r0) goto L_0x0423
            java.lang.String r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.POLICY_MAPPINGS     // Catch:{ AnnotatedException -> 0x0413 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r6, r0)     // Catch:{ AnnotatedException -> 0x0413 }
            if (r0 == 0) goto L_0x02e2
            r2 = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence) r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r3 = 0
        L_0x0291:
            int r10 = r2.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r3 >= r10) goto L_0x02e2
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r10 = r2.getObjectAt(r3)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r10 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence) r10     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r11 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r17 = r10.getObjectAt(r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r17 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r17     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r11 = 1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r10 = r10.getObjectAt(r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r10 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r10     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r11 = r17.getId()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r11 = r7.equals(r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r17 = r2
            java.lang.String r2 = "CertPathReviewer.invalidPolicyMapping"
            if (r11 != 0) goto L_0x02d5
            java.lang.String r10 = r10.getId()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r10 = r7.equals(r10)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r10 != 0) goto L_0x02c8
            int r3 = r3 + 1
            r2 = r17
            goto L_0x0291
        L_0x02c8:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.<init>(r9, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r0, r3, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x02d5:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.<init>(r9, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r0, r3, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x02e2:
            if (r0 == 0) goto L_0x0385
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence) r0     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r3.<init>()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r10 = 0
        L_0x02f1:
            int r11 = r0.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r10 >= r11) goto L_0x033c
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r11 = r0.getObjectAt(r10)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r11 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence) r11     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r17 = r0
            r0 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r18 = r11.getObjectAt(r0)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r18 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r18     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r0 = r18.getId()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r18 = r13
            r13 = 1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r11 = r11.getObjectAt(r13)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r11 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r11     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r11 = r11.getId()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r13 = r2.containsKey(r0)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r13 != 0) goto L_0x032c
            java.util.HashSet r13 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r13.<init>()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r13.add(r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.put(r0, r13)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r3.add(r0)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            goto L_0x0335
        L_0x032c:
            java.lang.Object r0 = r2.get(r0)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.util.Set r0 = (java.util.Set) r0     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.add(r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0335:
            int r10 = r10 + 1
            r0 = r17
            r13 = r18
            goto L_0x02f1
        L_0x033c:
            r18 = r13
            java.util.Iterator r0 = r3.iterator()     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0342:
            boolean r3 = r0.hasNext()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r3 == 0) goto L_0x0382
            java.lang.Object r3 = r0.next()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r34 <= 0) goto L_0x0376
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.prepareNextCertB1(r4, r5, r3, r2, r6)     // Catch:{ AnnotatedException -> 0x0365, CertPathValidatorException -> 0x0356 }
            r10 = r29
            goto L_0x037f
        L_0x0356:
            r0 = move-exception
            r2 = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.<init>(r9, r14)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r3.<init>(r0, r2, r4, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0365:
            r0 = move-exception
            r2 = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r10 = r29
            r0.<init>(r9, r10)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r3.<init>(r0, r2, r4, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0376:
            r10 = r29
            if (r34 > 0) goto L_0x037f
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r3 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.prepareNextCertB2(r4, r5, r3, r15)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r15 = r3
        L_0x037f:
            r29 = r10
            goto L_0x0342
        L_0x0382:
            r10 = r29
            goto L_0x0388
        L_0x0385:
            r18 = r13
            goto L_0x0382
        L_0x0388:
            boolean r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.isSelfIssued(r6)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r0 != 0) goto L_0x03a1
            if (r8 == 0) goto L_0x0392
            int r8 = r8 + -1
        L_0x0392:
            if (r34 == 0) goto L_0x0397
            int r11 = r34 + -1
            goto L_0x0399
        L_0x0397:
            r11 = r34
        L_0x0399:
            if (r33 == 0) goto L_0x039e
            int r0 = r33 + -1
            goto L_0x03a5
        L_0x039e:
            r0 = r33
            goto L_0x03a5
        L_0x03a1:
            r0 = r33
            r11 = r34
        L_0x03a5:
            java.lang.String r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.POLICY_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x0404 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r6, r2)     // Catch:{ AnnotatedException -> 0x0404 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence) r2     // Catch:{ AnnotatedException -> 0x0404 }
            if (r2 == 0) goto L_0x03e3
            java.util.Enumeration r2 = r2.getObjects()     // Catch:{ AnnotatedException -> 0x0404 }
        L_0x03b3:
            boolean r3 = r2.hasMoreElements()     // Catch:{ AnnotatedException -> 0x0404 }
            if (r3 == 0) goto L_0x03e3
            java.lang.Object r3 = r2.nextElement()     // Catch:{ AnnotatedException -> 0x0404 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject) r3     // Catch:{ AnnotatedException -> 0x0404 }
            int r4 = r3.getTagNo()     // Catch:{ AnnotatedException -> 0x0404 }
            if (r4 == 0) goto L_0x03d6
            r13 = 1
            if (r4 == r13) goto L_0x03c9
            goto L_0x03b3
        L_0x03c9:
            r4 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer.getInstance(r3, r4)     // Catch:{ AnnotatedException -> 0x0404 }
            int r3 = r3.intValueExact()     // Catch:{ AnnotatedException -> 0x0404 }
            if (r3 >= r11) goto L_0x03b3
            r11 = r3
            goto L_0x03b3
        L_0x03d6:
            r4 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer.getInstance(r3, r4)     // Catch:{ AnnotatedException -> 0x0404 }
            int r3 = r3.intValueExact()     // Catch:{ AnnotatedException -> 0x0404 }
            if (r3 >= r8) goto L_0x03b3
            r8 = r3
            goto L_0x03b3
        L_0x03e3:
            java.lang.String r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.INHIBIT_ANY_POLICY     // Catch:{ AnnotatedException -> 0x03f5 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r6, r2)     // Catch:{ AnnotatedException -> 0x03f5 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer) r2     // Catch:{ AnnotatedException -> 0x03f5 }
            if (r2 == 0) goto L_0x042b
            int r2 = r2.intValueExact()     // Catch:{ AnnotatedException -> 0x03f5 }
            if (r2 >= r0) goto L_0x042b
            r0 = r2
            goto L_0x042b
        L_0x03f5:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r2 = "CertPathReviewer.policyInhibitExtError"
            r0.<init>(r9, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r0, r3, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0404:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2 = r26
            r0.<init>(r9, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r0, r3, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0413:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r3 = "CertPathReviewer.policyMapExtError"
            r2.<init>(r9, r3)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r3.<init>(r2, r0, r4, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0423:
            r18 = r13
            r10 = r29
            r0 = r33
            r11 = r34
        L_0x042b:
            int r12 = r12 + -1
            r4 = r6
            r2 = r10
            r13 = r18
            r3 = r25
            r6 = 0
            r10 = r0
            r0 = r27
            goto L_0x0079
        L_0x0439:
            r0 = move-exception
            r10 = r2
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r9, r10)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r3.<init>(r2, r0, r4, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0448:
            r27 = r0
            r25 = r3
            r2 = r14
            r28 = r15
            boolean r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.isSelfIssued(r4)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r0 != 0) goto L_0x0459
            if (r8 <= 0) goto L_0x0459
            int r8 = r8 + -1
        L_0x0459:
            java.lang.String r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.POLICY_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x05ee }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r4, r0)     // Catch:{ AnnotatedException -> 0x05ee }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence) r0     // Catch:{ AnnotatedException -> 0x05ee }
            if (r0 == 0) goto L_0x048c
            java.util.Enumeration r0 = r0.getObjects()     // Catch:{ AnnotatedException -> 0x05ee }
            r11 = r8
        L_0x0468:
            boolean r3 = r0.hasMoreElements()     // Catch:{ AnnotatedException -> 0x05ee }
            if (r3 == 0) goto L_0x0489
            java.lang.Object r3 = r0.nextElement()     // Catch:{ AnnotatedException -> 0x05ee }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject) r3     // Catch:{ AnnotatedException -> 0x05ee }
            int r4 = r3.getTagNo()     // Catch:{ AnnotatedException -> 0x05ee }
            if (r4 == 0) goto L_0x047c
            r4 = 0
            goto L_0x0468
        L_0x047c:
            r4 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer.getInstance(r3, r4)     // Catch:{ AnnotatedException -> 0x05ee }
            int r3 = r3.intValueExact()     // Catch:{ AnnotatedException -> 0x05ee }
            if (r3 != 0) goto L_0x0468
            r11 = r4
            goto L_0x0468
        L_0x0489:
            r4 = 0
            r8 = r11
            goto L_0x048d
        L_0x048c:
            r4 = 0
        L_0x048d:
            java.lang.String r0 = "CertPathReviewer.explicitPolicy"
            if (r28 != 0) goto L_0x04a9
            java.security.cert.PKIXParameters r2 = r1.pkixParams     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r2 = r2.isExplicitPolicyRequired()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r2 != 0) goto L_0x049c
            r15 = 0
            goto L_0x05dc
        L_0x049c:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r9, r0)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.<init>(r2, r3, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r0     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x04a9:
            boolean r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.isAnyPolicy(r27)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r2 == 0) goto L_0x0548
            java.security.cert.PKIXParameters r2 = r1.pkixParams     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r2 = r2.isExplicitPolicyRequired()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r2 == 0) goto L_0x0544
            boolean r2 = r13.isEmpty()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r2 != 0) goto L_0x0537
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.<init>()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r11 = r4
            r3 = r25
        L_0x04c5:
            if (r11 >= r3) goto L_0x04f8
            r2 = r5[r11]     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r6 = r4
        L_0x04ca:
            int r10 = r2.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r6 >= r10) goto L_0x04f5
            java.lang.Object r10 = r2.get(r6)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r10 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r10     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r12 = r10.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r12 = r7.equals(r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r12 == 0) goto L_0x04f2
            java.util.Iterator r10 = r10.getChildren()     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x04e4:
            boolean r12 = r10.hasNext()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r12 == 0) goto L_0x04f2
            java.lang.Object r12 = r10.next()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.add(r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            goto L_0x04e4
        L_0x04f2:
            int r6 = r6 + 1
            goto L_0x04ca
        L_0x04f5:
            int r11 = r11 + 1
            goto L_0x04c5
        L_0x04f8:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x04fc:
            boolean r2 = r0.hasNext()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r2 == 0) goto L_0x0510
            java.lang.Object r2 = r0.next()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r2 = r2.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r13.contains(r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            goto L_0x04fc
        L_0x0510:
            int r0 = r1.n     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2 = 1
            int r0 = r0 - r2
            r15 = r28
        L_0x0516:
            if (r0 < 0) goto L_0x05dc
            r2 = r5[r0]     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r11 = r4
        L_0x051b:
            int r3 = r2.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r11 >= r3) goto L_0x0534
            java.lang.Object r3 = r2.get(r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r3     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r6 = r3.hasChildren()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r6 != 0) goto L_0x0531
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r15 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.removePolicyNode(r15, r5, r3)     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0531:
            int r11 = r11 + 1
            goto L_0x051b
        L_0x0534:
            int r0 = r0 + -1
            goto L_0x0516
        L_0x0537:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r9, r0)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.<init>(r2, r3, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r0     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x0544:
            r15 = r28
            goto L_0x05dc
        L_0x0548:
            r3 = r25
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.<init>()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r11 = r4
        L_0x0550:
            if (r11 >= r3) goto L_0x058f
            r2 = r5[r11]     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r6 = r4
        L_0x0555:
            int r10 = r2.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r6 >= r10) goto L_0x058c
            java.lang.Object r10 = r2.get(r6)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r10 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r10     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r12 = r10.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r12 = r7.equals(r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r12 == 0) goto L_0x0589
            java.util.Iterator r10 = r10.getChildren()     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x056f:
            boolean r12 = r10.hasNext()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r12 == 0) goto L_0x0589
            java.lang.Object r12 = r10.next()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r12 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r12     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r13 = r12.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r13 = r7.equals(r13)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r13 != 0) goto L_0x056f
            r0.add(r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            goto L_0x056f
        L_0x0589:
            int r6 = r6 + 1
            goto L_0x0555
        L_0x058c:
            int r11 = r11 + 1
            goto L_0x0550
        L_0x058f:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r15 = r28
        L_0x0595:
            boolean r2 = r0.hasNext()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r2 == 0) goto L_0x05b5
            java.lang.Object r2 = r0.next()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r3 = r2.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r6 = r27
            boolean r3 = r6.contains(r3)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r3 != 0) goto L_0x05b2
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.removePolicyNode(r15, r5, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r15 = r2
        L_0x05b2:
            r27 = r6
            goto L_0x0595
        L_0x05b5:
            if (r15 == 0) goto L_0x05dc
            int r0 = r1.n     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2 = 1
            int r0 = r0 - r2
        L_0x05bb:
            if (r0 < 0) goto L_0x05dc
            r2 = r5[r0]     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r11 = r4
        L_0x05c0:
            int r3 = r2.size()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r11 >= r3) goto L_0x05d9
            java.lang.Object r3 = r2.get(r11)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode) r3     // Catch:{ CertPathReviewerException -> 0x00e0 }
            boolean r6 = r3.hasChildren()     // Catch:{ CertPathReviewerException -> 0x00e0 }
            if (r6 != 0) goto L_0x05d6
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.PKIXPolicyNode r15 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.removePolicyNode(r15, r5, r3)     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x05d6:
            int r11 = r11 + 1
            goto L_0x05c0
        L_0x05d9:
            int r0 = r0 + -1
            goto L_0x05bb
        L_0x05dc:
            if (r8 > 0) goto L_0x0606
            if (r15 == 0) goto L_0x05e1
            goto L_0x0606
        L_0x05e1:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.lang.String r2 = "CertPathReviewer.invalidPolicy"
            r0.<init>(r9, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x05ee:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r0.<init>(r9, r2)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x00e0 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x00e0 }
            r2.<init>(r0, r3, r12)     // Catch:{ CertPathReviewerException -> 0x00e0 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x00e0 }
        L_0x05fb:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = r0.getErrorMessage()
            int r0 = r0.getIndex()
            r1.addError(r2, r0)
        L_0x0606:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.x509.PKIXCertPathReviewer.checkPolicy():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.security.cert.X509Certificate} */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ae, code lost:
        r0 = th;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00c0 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02b4 A[LOOP:1: B:104:0x02ae->B:106:0x02b4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02d7 A[LOOP:2: B:108:0x02d1->B:110:0x02d7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ae A[Catch:{ CertPathReviewerException -> 0x00b0, all -> 0x00ae }, ExcHandler: all (th java.lang.Throwable), Splitter:B:23:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0292 A[Catch:{ AnnotatedException -> 0x0297 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkSignatures() {
        /*
            r25 = this;
            r10 = r25
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r2 = r10.validDate
            r1.<init>(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            r2.<init>(r3)
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r2}
            java.lang.String r11 = "com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.certPathValidDate"
            r0.<init>((java.lang.String) r11, (java.lang.String) r2, (java.lang.Object[]) r1)
            r10.addNotification(r0)
            r12 = 1
            java.util.List r0 = r10.certs     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            int r1 = r0.size()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            int r1 = r1 - r12
            java.lang.Object r0 = r0.get(r1)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.security.cert.PKIXParameters r1 = r10.pkixParams     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.util.Set r1 = r1.getTrustAnchors()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.util.Collection r1 = r10.getTrustAnchors(r0, r1)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            int r2 = r1.size()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            if (r2 <= r12) goto L_0x0068
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.lang.String r3 = "CertPathReviewer.conflictingTrustAnchors"
            int r1 = r1.size()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.lang.Integer r1 = com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers.valueOf(r1)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            javax.security.auth.x500.X500Principal r0 = r0.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            r4.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.lang.Object[] r0 = new java.lang.Object[]{r1, r4}     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            r2.<init>((java.lang.String) r11, (java.lang.String) r3, (java.lang.Object[]) r0)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            r10.addError(r2)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            goto L_0x0093
        L_0x0061:
            r0 = move-exception
            r1 = 0
            goto L_0x00cc
        L_0x0064:
            r0 = move-exception
            r1 = 0
            goto L_0x00e9
        L_0x0068:
            boolean r2 = r1.isEmpty()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            if (r2 == 0) goto L_0x0095
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.lang.String r2 = "CertPathReviewer.noTrustAnchorFound"
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            javax.security.auth.x500.X500Principal r0 = r0.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            r3.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.security.cert.PKIXParameters r0 = r10.pkixParams     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.util.Set r0 = r0.getTrustAnchors()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            int r0 = r0.size()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.lang.Integer r0 = com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers.valueOf(r0)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.lang.Object[] r0 = new java.lang.Object[]{r3, r0}     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            r1.<init>((java.lang.String) r11, (java.lang.String) r2, (java.lang.Object[]) r0)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            r10.addError(r1)     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
        L_0x0093:
            r1 = 0
            goto L_0x00ca
        L_0x0095:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.lang.Object r1 = r1.next()     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.security.cert.TrustAnchor r1 = (java.security.cert.TrustAnchor) r1     // Catch:{ CertPathReviewerException -> 0x0064, all -> 0x0061 }
            java.security.cert.X509Certificate r2 = r1.getTrustedCert()     // Catch:{ CertPathReviewerException -> 0x00b0, all -> 0x00ae }
            if (r2 == 0) goto L_0x00b2
            java.security.cert.X509Certificate r2 = r1.getTrustedCert()     // Catch:{ CertPathReviewerException -> 0x00b0, all -> 0x00ae }
            java.security.PublicKey r2 = r2.getPublicKey()     // Catch:{ CertPathReviewerException -> 0x00b0, all -> 0x00ae }
            goto L_0x00b6
        L_0x00ae:
            r0 = move-exception
            goto L_0x00cc
        L_0x00b0:
            r0 = move-exception
            goto L_0x00e9
        L_0x00b2:
            java.security.PublicKey r2 = r1.getCAPublicKey()     // Catch:{ CertPathReviewerException -> 0x00b0, all -> 0x00ae }
        L_0x00b6:
            java.security.cert.PKIXParameters r3 = r10.pkixParams     // Catch:{ SignatureException -> 0x00c0, Exception -> 0x00ca, all -> 0x00ae }
            java.lang.String r3 = r3.getSigProvider()     // Catch:{ SignatureException -> 0x00c0, Exception -> 0x00ca, all -> 0x00ae }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.verifyX509Certificate(r0, r2, r3)     // Catch:{ SignatureException -> 0x00c0, Exception -> 0x00ca, all -> 0x00ae }
            goto L_0x00ca
        L_0x00c0:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00b0, all -> 0x00ae }
            java.lang.String r2 = "CertPathReviewer.trustButInvalidCert"
            r0.<init>(r11, r2)     // Catch:{ CertPathReviewerException -> 0x00b0, all -> 0x00ae }
            r10.addError(r0)     // Catch:{ CertPathReviewerException -> 0x00b0, all -> 0x00ae }
        L_0x00ca:
            r14 = r1
            goto L_0x00f1
        L_0x00cc:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput
            java.lang.String r4 = r0.getMessage()
            r3.<init>(r4)
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput
            r4.<init>(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r3, r4}
            java.lang.String r3 = "CertPathReviewer.unknown"
            r2.<init>((java.lang.String) r11, (java.lang.String) r3, (java.lang.Object[]) r0)
            r10.addError(r2)
            goto L_0x00ca
        L_0x00e9:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = r0.getErrorMessage()
            r10.addError(r0)
            goto L_0x00ca
        L_0x00f1:
            r15 = 5
            if (r14 == 0) goto L_0x013b
            java.security.cert.X509Certificate r0 = r14.getTrustedCert()
            if (r0 == 0) goto L_0x00ff
            javax.security.auth.x500.X500Principal r1 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getSubjectPrincipal(r0)     // Catch:{ IllegalArgumentException -> 0x0109 }
            goto L_0x0121
        L_0x00ff:
            javax.security.auth.x500.X500Principal r1 = new javax.security.auth.x500.X500Principal     // Catch:{ IllegalArgumentException -> 0x0109 }
            java.lang.String r2 = r14.getCAName()     // Catch:{ IllegalArgumentException -> 0x0109 }
            r1.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0109 }
            goto L_0x0121
        L_0x0109:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput
            java.lang.String r3 = r14.getCAName()
            r2.<init>(r3)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "CertPathReviewer.trustDNInvalid"
            r1.<init>((java.lang.String) r11, (java.lang.String) r3, (java.lang.Object[]) r2)
            r10.addError(r1)
            r1 = 0
        L_0x0121:
            if (r0 == 0) goto L_0x013c
            boolean[] r0 = r0.getKeyUsage()
            if (r0 == 0) goto L_0x013c
            int r2 = r0.length
            if (r2 <= r15) goto L_0x0130
            boolean r0 = r0[r15]
            if (r0 != 0) goto L_0x013c
        L_0x0130:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.trustKeyUsage"
            r0.<init>(r11, r2)
            r10.addNotification(r0)
            goto L_0x013c
        L_0x013b:
            r1 = 0
        L_0x013c:
            if (r14 == 0) goto L_0x0163
            java.security.cert.X509Certificate r0 = r14.getTrustedCert()
            if (r0 == 0) goto L_0x0149
            java.security.PublicKey r2 = r0.getPublicKey()
            goto L_0x014d
        L_0x0149:
            java.security.PublicKey r2 = r14.getCAPublicKey()
        L_0x014d:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r3 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getAlgorithmIdentifier(r2)     // Catch:{ CertPathValidatorException -> 0x0158 }
            r3.getAlgorithm()     // Catch:{ CertPathValidatorException -> 0x0158 }
            r3.getParameters()     // Catch:{ CertPathValidatorException -> 0x0158 }
            goto L_0x0165
        L_0x0158:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r4 = "CertPathReviewer.trustPubKeyError"
            r3.<init>(r11, r4)
            r10.addError(r3)
            goto L_0x0165
        L_0x0163:
            r0 = 0
            r2 = 0
        L_0x0165:
            java.util.List r3 = r10.certs
            int r3 = r3.size()
            int r3 = r3 - r12
            r5 = r0
            r9 = r1
            r8 = r2
            r7 = r3
        L_0x0170:
            if (r7 < 0) goto L_0x03d9
            int r0 = r10.n
            int r6 = r0 - r7
            java.util.List r0 = r10.certs
            java.lang.Object r0 = r0.get(r7)
            r4 = r0
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4
            java.lang.String r1 = "CertPathReviewer.signatureNotVerified"
            if (r8 == 0) goto L_0x01a9
            java.security.cert.PKIXParameters r0 = r10.pkixParams     // Catch:{ GeneralSecurityException -> 0x018e }
            java.lang.String r0 = r0.getSigProvider()     // Catch:{ GeneralSecurityException -> 0x018e }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.verifyX509Certificate(r4, r8, r0)     // Catch:{ GeneralSecurityException -> 0x018e }
            goto L_0x0235
        L_0x018e:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = r0.getMessage()
            java.lang.Class r16 = r0.getClass()
            java.lang.String r13 = r16.getName()
            java.lang.Object[] r0 = new java.lang.Object[]{r3, r0, r13}
            r2.<init>((java.lang.String) r11, (java.lang.String) r1, (java.lang.Object[]) r0)
            r10.addError(r2, r7)
            goto L_0x0235
        L_0x01a9:
            boolean r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.isSelfIssued(r4)
            if (r0 == 0) goto L_0x01e1
            java.security.PublicKey r0 = r4.getPublicKey()     // Catch:{ GeneralSecurityException -> 0x01c7 }
            java.security.cert.PKIXParameters r2 = r10.pkixParams     // Catch:{ GeneralSecurityException -> 0x01c7 }
            java.lang.String r2 = r2.getSigProvider()     // Catch:{ GeneralSecurityException -> 0x01c7 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.verifyX509Certificate(r4, r0, r2)     // Catch:{ GeneralSecurityException -> 0x01c7 }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ GeneralSecurityException -> 0x01c7 }
            java.lang.String r2 = "CertPathReviewer.rootKeyIsValidButNotATrustAnchor"
            r0.<init>(r11, r2)     // Catch:{ GeneralSecurityException -> 0x01c7 }
            r10.addError(r0, r7)     // Catch:{ GeneralSecurityException -> 0x01c7 }
            goto L_0x0235
        L_0x01c7:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = r0.getMessage()
            java.lang.Class r13 = r0.getClass()
            java.lang.String r13 = r13.getName()
            java.lang.Object[] r0 = new java.lang.Object[]{r3, r0, r13}
            r2.<init>((java.lang.String) r11, (java.lang.String) r1, (java.lang.Object[]) r0)
            r10.addError(r2, r7)
            goto L_0x0235
        L_0x01e1:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r1 = "CertPathReviewer.NoIssuerPublicKey"
            r0.<init>(r11, r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extension.authorityKeyIdentifier
            java.lang.String r1 = r1.getId()
            byte[] r1 = r4.getExtensionValue(r1)
            if (r1 == 0) goto L_0x0232
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString.getInstance(r1)
            byte[] r1 = r1.getOctets()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AuthorityKeyIdentifier r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AuthorityKeyIdentifier.getInstance(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralNames r2 = r1.getAuthorityCertIssuer()
            if (r2 == 0) goto L_0x0232
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName[] r2 = r2.getNames()
            r3 = 0
            r19 = r2[r3]
            java.math.BigInteger r23 = r1.getAuthorityCertSerialNumber()
            if (r23 == 0) goto L_0x0232
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocaleString r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocaleString
            java.lang.String r2 = "missingIssuer"
            r1.<init>(r11, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocaleString r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocaleString
            java.lang.String r3 = "missingSerial"
            r2.<init>(r11, r3)
            java.lang.String r22 = " "
            java.lang.String r18 = " \""
            java.lang.String r20 = "\" "
            r17 = r1
            r21 = r2
            java.lang.Object[] r1 = new java.lang.Object[]{r17, r18, r19, r20, r21, r22, r23}
            r0.setExtraArguments(r1)
        L_0x0232:
            r10.addError(r0, r7)
        L_0x0235:
            java.util.Date r0 = r10.validDate     // Catch:{ CertificateNotYetValidException -> 0x0253, CertificateExpiredException -> 0x023b }
            r4.checkValidity(r0)     // Catch:{ CertificateNotYetValidException -> 0x0253, CertificateExpiredException -> 0x023b }
            goto L_0x026a
        L_0x023b:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r2 = r4.getNotAfter()
            r1.<init>(r2)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r2 = "CertPathReviewer.certificateExpired"
            r0.<init>((java.lang.String) r11, (java.lang.String) r2, (java.lang.Object[]) r1)
            r10.addError(r0, r7)
            goto L_0x026a
        L_0x0253:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r2 = r4.getNotBefore()
            r1.<init>(r2)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r2 = "CertPathReviewer.certificateNotYetValid"
            r0.<init>((java.lang.String) r11, (java.lang.String) r2, (java.lang.Object[]) r1)
            r10.addError(r0, r7)
        L_0x026a:
            java.security.cert.PKIXParameters r0 = r10.pkixParams
            boolean r0 = r0.isRevocationEnabled()
            if (r0 == 0) goto L_0x031f
            java.lang.String r0 = CRL_DIST_POINTS     // Catch:{ AnnotatedException -> 0x027f }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r4, r0)     // Catch:{ AnnotatedException -> 0x027f }
            if (r0 == 0) goto L_0x0289
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CRLDistPoint r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CRLDistPoint.getInstance(r0)     // Catch:{ AnnotatedException -> 0x027f }
            goto L_0x028a
        L_0x027f:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r1 = "CertPathReviewer.crlDistPtExtError"
            r0.<init>(r11, r1)
            r10.addError(r0, r7)
        L_0x0289:
            r0 = 0
        L_0x028a:
            java.lang.String r1 = AUTH_INFO_ACCESS     // Catch:{ AnnotatedException -> 0x0297 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r1 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r4, r1)     // Catch:{ AnnotatedException -> 0x0297 }
            if (r1 == 0) goto L_0x02a1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AuthorityInformationAccess r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AuthorityInformationAccess.getInstance(r1)     // Catch:{ AnnotatedException -> 0x0297 }
            goto L_0x02a2
        L_0x0297:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.crlAuthInfoAccError"
            r1.<init>(r11, r2)
            r10.addError(r1, r7)
        L_0x02a1:
            r1 = 0
        L_0x02a2:
            java.util.Vector r0 = r10.getCRLDistUrls(r0)
            java.util.Vector r13 = r10.getOCSPUrls(r1)
            java.util.Iterator r1 = r0.iterator()
        L_0x02ae:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x02cd
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput
            java.lang.Object r15 = r1.next()
            r3.<init>(r15)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r15 = "CertPathReviewer.crlDistPoint"
            r2.<init>((java.lang.String) r11, (java.lang.String) r15, (java.lang.Object[]) r3)
            r10.addNotification(r2, r7)
            r15 = 5
            goto L_0x02ae
        L_0x02cd:
            java.util.Iterator r1 = r13.iterator()
        L_0x02d1:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x02ef
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput
            java.lang.Object r15 = r1.next()
            r3.<init>(r15)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r15 = "CertPathReviewer.ocspLocation"
            r2.<init>((java.lang.String) r11, (java.lang.String) r15, (java.lang.Object[]) r3)
            r10.addNotification(r2, r7)
            goto L_0x02d1
        L_0x02ef:
            java.security.cert.PKIXParameters r2 = r10.pkixParams     // Catch:{ CertPathReviewerException -> 0x030c }
            java.util.Date r15 = r10.validDate     // Catch:{ CertPathReviewerException -> 0x030c }
            r1 = r25
            r3 = r4
            r17 = r4
            r4 = r15
            r15 = r6
            r6 = r8
            r18 = r7
            r7 = r0
            r24 = r8
            r8 = r13
            r13 = r9
            r9 = r18
            r1.checkRevocation(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ CertPathReviewerException -> 0x030a }
            r3 = r18
            goto L_0x0326
        L_0x030a:
            r0 = move-exception
            goto L_0x0315
        L_0x030c:
            r0 = move-exception
            r17 = r4
            r15 = r6
            r18 = r7
            r24 = r8
            r13 = r9
        L_0x0315:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = r0.getErrorMessage()
            r3 = r18
            r10.addError(r0, r3)
            goto L_0x0326
        L_0x031f:
            r17 = r4
            r15 = r6
            r3 = r7
            r24 = r8
            r13 = r9
        L_0x0326:
            if (r13 == 0) goto L_0x034c
            javax.security.auth.x500.X500Principal r0 = r17.getIssuerX500Principal()
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x034c
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r1 = r13.getName()
            javax.security.auth.x500.X500Principal r2 = r17.getIssuerX500Principal()
            java.lang.String r2 = r2.getName()
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r2}
            java.lang.String r2 = "CertPathReviewer.certWrongIssuer"
            r0.<init>((java.lang.String) r11, (java.lang.String) r2, (java.lang.Object[]) r1)
            r10.addError(r0, r3)
        L_0x034c:
            int r0 = r10.n
            if (r15 == r0) goto L_0x03af
            java.lang.String r0 = "CertPathReviewer.noCACert"
            r1 = r17
            if (r1 == 0) goto L_0x0364
            int r2 = r1.getVersion()
            if (r2 != r12) goto L_0x0364
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            r2.<init>(r11, r0)
            r10.addError(r2, r3)
        L_0x0364:
            java.lang.String r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.BASIC_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x038a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r1, r2)     // Catch:{ AnnotatedException -> 0x038a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.BasicConstraints r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.BasicConstraints.getInstance(r2)     // Catch:{ AnnotatedException -> 0x038a }
            if (r2 == 0) goto L_0x037f
            boolean r2 = r2.isCA()     // Catch:{ AnnotatedException -> 0x038a }
            if (r2 != 0) goto L_0x0394
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ AnnotatedException -> 0x038a }
            r2.<init>(r11, r0)     // Catch:{ AnnotatedException -> 0x038a }
            r10.addError(r2, r3)     // Catch:{ AnnotatedException -> 0x038a }
            goto L_0x0394
        L_0x037f:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ AnnotatedException -> 0x038a }
            java.lang.String r2 = "CertPathReviewer.noBasicConstraints"
            r0.<init>(r11, r2)     // Catch:{ AnnotatedException -> 0x038a }
            r10.addError(r0, r3)     // Catch:{ AnnotatedException -> 0x038a }
            goto L_0x0394
        L_0x038a:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.errorProcesingBC"
            r0.<init>(r11, r2)
            r10.addError(r0, r3)
        L_0x0394:
            boolean[] r0 = r1.getKeyUsage()
            if (r0 == 0) goto L_0x03ad
            int r2 = r0.length
            r4 = 5
            if (r2 <= r4) goto L_0x03a2
            boolean r0 = r0[r4]
            if (r0 != 0) goto L_0x03b2
        L_0x03a2:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.noCertSign"
            r0.<init>(r11, r2)
            r10.addError(r0, r3)
            goto L_0x03b2
        L_0x03ad:
            r4 = 5
            goto L_0x03b2
        L_0x03af:
            r1 = r17
            goto L_0x03ad
        L_0x03b2:
            javax.security.auth.x500.X500Principal r9 = r1.getSubjectX500Principal()
            java.util.List r0 = r10.certs     // Catch:{ CertPathValidatorException -> 0x03c7 }
            java.security.PublicKey r8 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getNextWorkingKey(r0, r3)     // Catch:{ CertPathValidatorException -> 0x03c7 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getAlgorithmIdentifier(r8)     // Catch:{ CertPathValidatorException -> 0x03c9 }
            r0.getAlgorithm()     // Catch:{ CertPathValidatorException -> 0x03c9 }
            r0.getParameters()     // Catch:{ CertPathValidatorException -> 0x03c9 }
            goto L_0x03d3
        L_0x03c7:
            r8 = r24
        L_0x03c9:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.pubKeyError"
            r0.<init>(r11, r2)
            r10.addError(r0, r3)
        L_0x03d3:
            int r7 = r3 + -1
            r5 = r1
            r15 = r4
            goto L_0x0170
        L_0x03d9:
            r24 = r8
            r10.trustAnchor = r14
            r2 = r24
            r10.subjectPublicKey = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.x509.PKIXCertPathReviewer.checkSignatures():void");
    }

    private X509CRL getCRL(String str) throws CertPathReviewerException {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals("http")) {
                if (!url.getProtocol().equals("https")) {
                    return null;
                }
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME).generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i) {
        ErrorBundle errorBundle;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, QC_STATEMENT);
            boolean z = false;
            for (int i2 = 0; i2 < aSN1Sequence.size(); i2++) {
                QCStatement instance = QCStatement.getInstance(aSN1Sequence.getObjectAt(i2));
                if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcCompliance.equals((ASN1Primitive) instance.getStatementId())) {
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcEuCompliance"), i);
                } else if (!RFC3739QCObjectIdentifiers.id_qcs_pkixQCSyntax_v1.equals((ASN1Primitive) instance.getStatementId())) {
                    if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcSSCD.equals((ASN1Primitive) instance.getStatementId())) {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcSSCD"), i);
                    } else if (ETSIQCObjectIdentifiers.id_etsi_qcs_LimiteValue.equals((ASN1Primitive) instance.getStatementId())) {
                        MonetaryValue instance2 = MonetaryValue.getInstance(instance.getStatementInfo());
                        instance2.getCurrency();
                        double doubleValue = instance2.getAmount().doubleValue() * Math.pow(10.0d, instance2.getExponent().doubleValue());
                        if (instance2.getCurrency().isAlphabetic()) {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueAlpha", new Object[]{instance2.getCurrency().getAlphabetic(), new TrustedInput(new Double(doubleValue)), instance2});
                        } else {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueNum", new Object[]{Integers.valueOf(instance2.getCurrency().getNumeric()), new TrustedInput(new Double(doubleValue)), instance2});
                        }
                        addNotification(errorBundle, i);
                    } else {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcUnknownStatement", new Object[]{instance.getStatementId(), new UntrustedInput(instance)}), i);
                        z = true;
                    }
                }
            }
            return !z;
        } catch (AnnotatedException unused) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcStatementExtError"), i);
            return false;
        }
    }

    public void addError(ErrorBundle errorBundle) {
        this.errors[0].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: java.util.Iterator} */
    /* JADX WARNING: type inference failed for: r12v5, types: [java.util.Iterator] */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0295  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkCRLs(java.security.cert.PKIXParameters r20, java.security.cert.X509Certificate r21, java.util.Date r22, java.security.cert.X509Certificate r23, java.security.PublicKey r24, java.util.Vector r25, int r26) throws com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r24
            r5 = r26
            java.lang.String r6 = "CertPathReviewer.crlIssuerException"
            java.lang.String r7 = "CertPathReviewer.distrPtExtError"
            java.lang.String r8 = "CertPathReviewer.crlExtractionError"
            java.lang.String r9 = "com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerMessages"
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector
            r0.<init>()
            javax.security.auth.x500.X500Principal r10 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getEncodedIssuerPrincipal(r21)     // Catch:{ IOException -> 0x043a }
            byte[] r10 = r10.getEncoded()     // Catch:{ IOException -> 0x043a }
            r0.addIssuerName(r10)     // Catch:{ IOException -> 0x043a }
            r0.setCertificateChecking(r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.PKIXCRLUtil r10 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.CRL_UTIL     // Catch:{ AnnotatedException -> 0x005b }
            java.util.Set r11 = r10.findCRLs((com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector) r0, (java.security.cert.PKIXParameters) r2)     // Catch:{ AnnotatedException -> 0x005b }
            java.util.Iterator r12 = r11.iterator()     // Catch:{ AnnotatedException -> 0x005b }
            boolean r11 = r11.isEmpty()     // Catch:{ AnnotatedException -> 0x005b }
            if (r11 == 0) goto L_0x00af
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector     // Catch:{ AnnotatedException -> 0x005b }
            r11.<init>()     // Catch:{ AnnotatedException -> 0x005b }
            java.util.Set r10 = r10.findCRLs((com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector) r11, (java.security.cert.PKIXParameters) r2)     // Catch:{ AnnotatedException -> 0x005b }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ AnnotatedException -> 0x005b }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ AnnotatedException -> 0x005b }
            r11.<init>()     // Catch:{ AnnotatedException -> 0x005b }
        L_0x0047:
            boolean r13 = r10.hasNext()     // Catch:{ AnnotatedException -> 0x005b }
            if (r13 == 0) goto L_0x005d
            java.lang.Object r13 = r10.next()     // Catch:{ AnnotatedException -> 0x005b }
            java.security.cert.X509CRL r13 = (java.security.cert.X509CRL) r13     // Catch:{ AnnotatedException -> 0x005b }
            javax.security.auth.x500.X500Principal r13 = r13.getIssuerX500Principal()     // Catch:{ AnnotatedException -> 0x005b }
            r11.add(r13)     // Catch:{ AnnotatedException -> 0x005b }
            goto L_0x0047
        L_0x005b:
            r0 = move-exception
            goto L_0x0082
        L_0x005d:
            int r10 = r11.size()     // Catch:{ AnnotatedException -> 0x005b }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r13 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ AnnotatedException -> 0x005b }
            java.lang.String r14 = "CertPathReviewer.noCrlInCertstore"
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput r15 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ AnnotatedException -> 0x005b }
            java.util.Collection r0 = r0.getIssuerNames()     // Catch:{ AnnotatedException -> 0x005b }
            r15.<init>(r0)     // Catch:{ AnnotatedException -> 0x005b }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ AnnotatedException -> 0x005b }
            r0.<init>(r11)     // Catch:{ AnnotatedException -> 0x005b }
            java.lang.Integer r10 = com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers.valueOf(r10)     // Catch:{ AnnotatedException -> 0x005b }
            java.lang.Object[] r0 = new java.lang.Object[]{r15, r0, r10}     // Catch:{ AnnotatedException -> 0x005b }
            r13.<init>((java.lang.String) r9, (java.lang.String) r14, (java.lang.Object[]) r0)     // Catch:{ AnnotatedException -> 0x005b }
            r1.addNotification(r13, r5)     // Catch:{ AnnotatedException -> 0x005b }
            goto L_0x00af
        L_0x0082:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r10 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.Throwable r11 = r0.getCause()
            java.lang.String r11 = r11.getMessage()
            java.lang.Throwable r12 = r0.getCause()
            java.lang.Throwable r0 = r0.getCause()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            java.lang.Object[] r0 = new java.lang.Object[]{r11, r12, r0}
            r10.<init>((java.lang.String) r9, (java.lang.String) r8, (java.lang.Object[]) r0)
            r1.addError(r10, r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r12 = r0.iterator()
        L_0x00af:
            r0 = 0
        L_0x00b0:
            boolean r11 = r12.hasNext()
            if (r11 == 0) goto L_0x0115
            java.lang.Object r0 = r12.next()
            java.security.cert.X509CRL r0 = (java.security.cert.X509CRL) r0
            java.util.Date r11 = r0.getNextUpdate()
            if (r11 == 0) goto L_0x00f2
            java.util.Date r11 = r20.getDate()
            java.util.Date r14 = r0.getNextUpdate()
            boolean r11 = r11.before(r14)
            if (r11 == 0) goto L_0x00d1
            goto L_0x00f2
        L_0x00d1:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r13 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r14 = r0.getThisUpdate()
            r13.<init>(r14)
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r14 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r15 = r0.getNextUpdate()
            r14.<init>(r15)
            java.lang.Object[] r13 = new java.lang.Object[]{r13, r14}
            java.lang.String r14 = "CertPathReviewer.localInvalidCRL"
            r11.<init>((java.lang.String) r9, (java.lang.String) r14, (java.lang.Object[]) r13)
            r1.addNotification(r11, r5)
            goto L_0x00b0
        L_0x00f2:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r12 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r14 = r0.getThisUpdate()
            r12.<init>(r14)
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r14 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r15 = r0.getNextUpdate()
            r14.<init>(r15)
            java.lang.Object[] r12 = new java.lang.Object[]{r12, r14}
            java.lang.String r14 = "CertPathReviewer.localValidCRL"
            r11.<init>((java.lang.String) r9, (java.lang.String) r14, (java.lang.Object[]) r12)
            r1.addNotification(r11, r5)
            r11 = r0
            r0 = 1
            goto L_0x011b
        L_0x0115:
            r11 = 0
            r18 = r11
            r11 = r0
            r0 = r18
        L_0x011b:
            if (r0 != 0) goto L_0x0203
            java.util.Iterator r12 = r25.iterator()
            r14 = r0
        L_0x0122:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x01ff
            java.lang.Object r0 = r12.next()     // Catch:{ CertPathReviewerException -> 0x017d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ CertPathReviewerException -> 0x017d }
            java.security.cert.X509CRL r15 = r1.getCRL(r0)     // Catch:{ CertPathReviewerException -> 0x017d }
            if (r15 == 0) goto L_0x01ed
            javax.security.auth.x500.X500Principal r10 = r21.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x017d }
            javax.security.auth.x500.X500Principal r13 = r15.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x017d }
            boolean r10 = r10.equals(r13)     // Catch:{ CertPathReviewerException -> 0x017d }
            if (r10 != 0) goto L_0x0181
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r10 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x017d }
            java.lang.String r13 = "CertPathReviewer.onlineCRLWrongCA"
            r16 = r11
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x0178 }
            javax.security.auth.x500.X500Principal r15 = r15.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x0178 }
            java.lang.String r15 = r15.getName()     // Catch:{ CertPathReviewerException -> 0x0178 }
            r11.<init>(r15)     // Catch:{ CertPathReviewerException -> 0x0178 }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput r15 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x0178 }
            javax.security.auth.x500.X500Principal r17 = r21.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x0178 }
            r25 = r12
            java.lang.String r12 = r17.getName()     // Catch:{ CertPathReviewerException -> 0x0175 }
            r15.<init>(r12)     // Catch:{ CertPathReviewerException -> 0x0175 }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput r12 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput     // Catch:{ CertPathReviewerException -> 0x0175 }
            r12.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x0175 }
            java.lang.Object[] r0 = new java.lang.Object[]{r11, r15, r12}     // Catch:{ CertPathReviewerException -> 0x0175 }
            r10.<init>((java.lang.String) r9, (java.lang.String) r13, (java.lang.Object[]) r0)     // Catch:{ CertPathReviewerException -> 0x0175 }
            r1.addNotification(r10, r5)     // Catch:{ CertPathReviewerException -> 0x0175 }
            goto L_0x01f1
        L_0x0175:
            r0 = move-exception
            goto L_0x01f7
        L_0x0178:
            r0 = move-exception
        L_0x0179:
            r25 = r12
            goto L_0x01f7
        L_0x017d:
            r0 = move-exception
            r16 = r11
            goto L_0x0179
        L_0x0181:
            r16 = r11
            r25 = r12
            java.util.Date r10 = r15.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x0175 }
            if (r10 == 0) goto L_0x01c2
            java.security.cert.PKIXParameters r10 = r1.pkixParams     // Catch:{ CertPathReviewerException -> 0x0175 }
            java.util.Date r10 = r10.getDate()     // Catch:{ CertPathReviewerException -> 0x0175 }
            java.util.Date r11 = r15.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x0175 }
            boolean r10 = r10.before(r11)     // Catch:{ CertPathReviewerException -> 0x0175 }
            if (r10 == 0) goto L_0x019c
            goto L_0x01c2
        L_0x019c:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r10 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0175 }
            java.lang.String r11 = "CertPathReviewer.onlineInvalidCRL"
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r12 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x0175 }
            java.util.Date r13 = r15.getThisUpdate()     // Catch:{ CertPathReviewerException -> 0x0175 }
            r12.<init>(r13)     // Catch:{ CertPathReviewerException -> 0x0175 }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r13 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x0175 }
            java.util.Date r15 = r15.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x0175 }
            r13.<init>(r15)     // Catch:{ CertPathReviewerException -> 0x0175 }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput r15 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput     // Catch:{ CertPathReviewerException -> 0x0175 }
            r15.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x0175 }
            java.lang.Object[] r0 = new java.lang.Object[]{r12, r13, r15}     // Catch:{ CertPathReviewerException -> 0x0175 }
            r10.<init>((java.lang.String) r9, (java.lang.String) r11, (java.lang.Object[]) r0)     // Catch:{ CertPathReviewerException -> 0x0175 }
            r1.addNotification(r10, r5)     // Catch:{ CertPathReviewerException -> 0x0175 }
            goto L_0x01f1
        L_0x01c2:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r10 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x01ea }
            java.lang.String r11 = "CertPathReviewer.onlineValidCRL"
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r12 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x01ea }
            java.util.Date r13 = r15.getThisUpdate()     // Catch:{ CertPathReviewerException -> 0x01ea }
            r12.<init>(r13)     // Catch:{ CertPathReviewerException -> 0x01ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r13 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x01ea }
            java.util.Date r14 = r15.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x01ea }
            r13.<init>(r14)     // Catch:{ CertPathReviewerException -> 0x01ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput r14 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.UntrustedUrlInput     // Catch:{ CertPathReviewerException -> 0x01ea }
            r14.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x01ea }
            java.lang.Object[] r0 = new java.lang.Object[]{r12, r13, r14}     // Catch:{ CertPathReviewerException -> 0x01ea }
            r10.<init>((java.lang.String) r9, (java.lang.String) r11, (java.lang.Object[]) r0)     // Catch:{ CertPathReviewerException -> 0x01ea }
            r1.addNotification(r10, r5)     // Catch:{ CertPathReviewerException -> 0x01ea }
            r11 = r15
            r13 = 1
            goto L_0x0206
        L_0x01ea:
            r0 = move-exception
            r14 = 1
            goto L_0x01f7
        L_0x01ed:
            r16 = r11
            r25 = r12
        L_0x01f1:
            r12 = r25
            r11 = r16
            goto L_0x0122
        L_0x01f7:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = r0.getErrorMessage()
            r1.addNotification(r0, r5)
            goto L_0x01f1
        L_0x01ff:
            r16 = r11
            r13 = r14
            goto L_0x0206
        L_0x0203:
            r16 = r11
            r13 = r0
        L_0x0206:
            if (r11 == 0) goto L_0x042a
            if (r23 == 0) goto L_0x0226
            boolean[] r0 = r23.getKeyUsage()
            if (r0 == 0) goto L_0x0226
            int r10 = r0.length
            r12 = 6
            if (r10 <= r12) goto L_0x0219
            boolean r0 = r0[r12]
            if (r0 == 0) goto L_0x0219
            goto L_0x0226
        L_0x0219:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.noCrlSigningPermited"
            r0.<init>(r9, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0226:
            if (r4 == 0) goto L_0x041d
            java.lang.String r0 = "BC"
            r11.verify(r4, r0)     // Catch:{ Exception -> 0x040f }
            java.math.BigInteger r0 = r21.getSerialNumber()
            java.security.cert.X509CRLEntry r0 = r11.getRevokedCertificate(r0)
            if (r0 == 0) goto L_0x02af
            boolean r4 = r0.hasExtensions()
            if (r4 == 0) goto L_0x0264
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extension.reasonCode     // Catch:{ AnnotatedException -> 0x0256 }
            java.lang.String r4 = r4.getId()     // Catch:{ AnnotatedException -> 0x0256 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r4 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r0, r4)     // Catch:{ AnnotatedException -> 0x0256 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Enumerated r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Enumerated.getInstance(r4)     // Catch:{ AnnotatedException -> 0x0256 }
            if (r4 == 0) goto L_0x0264
            java.lang.String[] r10 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.crlReasons
            int r4 = r4.intValueExact()
            r10 = r10[r4]
            goto L_0x0265
        L_0x0256:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = "CertPathReviewer.crlReasonExtError"
            r2.<init>(r9, r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x0264:
            r10 = 0
        L_0x0265:
            if (r10 != 0) goto L_0x026c
            java.lang.String[] r4 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.crlReasons
            r10 = 7
            r10 = r4[r10]
        L_0x026c:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocaleString r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocaleString
            r4.<init>(r9, r10)
            java.util.Date r10 = r0.getRevocationDate()
            r12 = r22
            boolean r10 = r12.before(r10)
            if (r10 == 0) goto L_0x0295
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r10 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r12 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r0 = r0.getRevocationDate()
            r12.<init>(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r12, r4}
            java.lang.String r4 = "CertPathReviewer.revokedAfterValidation"
            r10.<init>((java.lang.String) r9, (java.lang.String) r4, (java.lang.Object[]) r0)
            r1.addNotification(r10, r5)
            goto L_0x02b9
        L_0x0295:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r0 = r0.getRevocationDate()
            r3.<init>(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r3, r4}
            java.lang.String r3 = "CertPathReviewer.certRevoked"
            r2.<init>((java.lang.String) r9, (java.lang.String) r3, (java.lang.Object[]) r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r0.<init>(r2)
            throw r0
        L_0x02af:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r4 = "CertPathReviewer.notRevoked"
            r0.<init>(r9, r4)
            r1.addNotification(r0, r5)
        L_0x02b9:
            java.util.Date r0 = r11.getNextUpdate()
            if (r0 == 0) goto L_0x02e6
            java.util.Date r0 = r11.getNextUpdate()
            java.security.cert.PKIXParameters r4 = r1.pkixParams
            java.util.Date r4 = r4.getDate()
            boolean r0 = r0.before(r4)
            if (r0 == 0) goto L_0x02e6
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r10 = r11.getNextUpdate()
            r4.<init>(r10)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r10 = "CertPathReviewer.crlUpdateAvailable"
            r0.<init>((java.lang.String) r9, (java.lang.String) r10, (java.lang.Object[]) r4)
            r1.addNotification(r0, r5)
        L_0x02e6:
            java.lang.String r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT     // Catch:{ AnnotatedException -> 0x0404 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r11, r0)     // Catch:{ AnnotatedException -> 0x0404 }
            java.lang.String r4 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.DELTA_CRL_INDICATOR     // Catch:{ AnnotatedException -> 0x03f7 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r4 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r11, r4)     // Catch:{ AnnotatedException -> 0x03f7 }
            if (r4 == 0) goto L_0x038d
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector
            r5.<init>()
            javax.security.auth.x500.X500Principal r10 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getIssuerPrincipal(r11)     // Catch:{ IOException -> 0x0381 }
            byte[] r10 = r10.getEncoded()     // Catch:{ IOException -> 0x0381 }
            r5.addIssuerName(r10)     // Catch:{ IOException -> 0x0381 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r4 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer) r4
            java.math.BigInteger r4 = r4.getPositiveValue()
            r5.setMinCRLNumber(r4)
            java.lang.String r4 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.CRL_NUMBER     // Catch:{ AnnotatedException -> 0x0373 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r4 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r11, r4)     // Catch:{ AnnotatedException -> 0x0373 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r4 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer) r4     // Catch:{ AnnotatedException -> 0x0373 }
            java.math.BigInteger r4 = r4.getPositiveValue()     // Catch:{ AnnotatedException -> 0x0373 }
            r10 = 1
            java.math.BigInteger r6 = java.math.BigInteger.valueOf(r10)     // Catch:{ AnnotatedException -> 0x0373 }
            java.math.BigInteger r4 = r4.subtract(r6)     // Catch:{ AnnotatedException -> 0x0373 }
            r5.setMaxCRLNumber(r4)     // Catch:{ AnnotatedException -> 0x0373 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.PKIXCRLUtil r4 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.CRL_UTIL     // Catch:{ AnnotatedException -> 0x0367 }
            java.util.Set r2 = r4.findCRLs((com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector) r5, (java.security.cert.PKIXParameters) r2)     // Catch:{ AnnotatedException -> 0x0367 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ AnnotatedException -> 0x0367 }
        L_0x0330:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x035a
            java.lang.Object r4 = r2.next()
            java.security.cert.X509CRL r4 = (java.security.cert.X509CRL) r4
            java.lang.String r5 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT     // Catch:{ AnnotatedException -> 0x034e }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r4 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r4, r5)     // Catch:{ AnnotatedException -> 0x034e }
            if (r0 != 0) goto L_0x0347
            if (r4 != 0) goto L_0x0330
            goto L_0x038d
        L_0x0347:
            boolean r4 = r0.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r4)
            if (r4 == 0) goto L_0x0330
            goto L_0x038d
        L_0x034e:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            r2.<init>(r9, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x035a:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.noBaseCRL"
            r0.<init>(r9, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0367:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            r2.<init>(r9, r8)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x0373:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = "CertPathReviewer.crlNbrExtError"
            r2.<init>(r9, r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x0381:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            r2.<init>(r9, r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x038d:
            if (r0 == 0) goto L_0x042a
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.IssuingDistributionPoint r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.IssuingDistributionPoint.getInstance(r0)
            java.lang.String r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.BASIC_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x03e9 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r2 = com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathValidatorUtilities.getExtensionValue(r3, r2)     // Catch:{ AnnotatedException -> 0x03e9 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.BasicConstraints r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.BasicConstraints.getInstance(r2)     // Catch:{ AnnotatedException -> 0x03e9 }
            boolean r3 = r0.onlyContainsUserCerts()
            if (r3 == 0) goto L_0x03b9
            if (r2 == 0) goto L_0x03b9
            boolean r3 = r2.isCA()
            if (r3 != 0) goto L_0x03ac
            goto L_0x03b9
        L_0x03ac:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.crlOnlyUserCert"
            r0.<init>(r9, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x03b9:
            boolean r3 = r0.onlyContainsCACerts()
            if (r3 == 0) goto L_0x03d5
            if (r2 == 0) goto L_0x03c8
            boolean r2 = r2.isCA()
            if (r2 == 0) goto L_0x03c8
            goto L_0x03d5
        L_0x03c8:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.crlOnlyCaCert"
            r0.<init>(r9, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x03d5:
            boolean r0 = r0.onlyContainsAttributeCerts()
            if (r0 != 0) goto L_0x03dc
            goto L_0x042a
        L_0x03dc:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.crlOnlyAttrCert"
            r0.<init>(r9, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x03e9:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = "CertPathReviewer.crlBCExtError"
            r2.<init>(r9, r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x03f7:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.deltaCrlExtError"
            r0.<init>(r9, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0404:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            r0.<init>(r9, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x040f:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = "CertPathReviewer.crlVerifyFailed"
            r2.<init>(r9, r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x041d:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.crlNoIssuerPublicKey"
            r0.<init>(r9, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x042a:
            if (r13 == 0) goto L_0x042d
            return
        L_0x042d:
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.noValidCrlFound"
            r0.<init>(r9, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x043a:
            r0 = move-exception
            com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle
            r2.<init>(r9, r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.x509.PKIXCertPathReviewer.checkCRLs(java.security.cert.PKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.Vector, int):void");
    }

    public void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i) throws CertPathReviewerException {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i);
    }

    public void doChecks() {
        if (!this.initialized) {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        } else if (this.notifications == null) {
            int i = this.n;
            this.notifications = new List[(i + 1)];
            this.errors = new List[(i + 1)];
            int i2 = 0;
            while (true) {
                List[] listArr = this.notifications;
                if (i2 < listArr.length) {
                    listArr[i2] = new ArrayList();
                    this.errors[i2] = new ArrayList();
                    i2++;
                } else {
                    checkSignatures();
                    checkNameConstraints();
                    checkPathLength();
                    checkPolicy();
                    checkCriticalExtensions();
                    return;
                }
            }
        }
    }

    public Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
            for (DistributionPoint distributionPoint : distributionPoints) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].getTagNo() == 6) {
                            vector.add(((DERIA5String) names[i].getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.n;
    }

    public List[] getErrors() {
        doChecks();
        return this.errors;
    }

    public List[] getNotifications() {
        doChecks();
        return this.notifications;
    }

    public Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i = 0; i < accessDescriptions.length; i++) {
                if (accessDescriptions[i].getAccessMethod().equals((ASN1Primitive) AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((DERIA5String) accessLocation.getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    public PolicyNode getPolicyTree() {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() {
        doChecks();
        return this.trustAnchor;
    }

    public Collection getTrustAnchors(X509Certificate x509Certificate, Set set) throws CertPathReviewerException {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(Extension.authorityKeyIdentifier.getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier instance = AuthorityKeyIdentifier.getInstance(ASN1Primitive.fromByteArray(((ASN1OctetString) ASN1Primitive.fromByteArray(extensionValue)).getOctets()));
                x509CertSelector.setSerialNumber(instance.getAuthorityCertSerialNumber());
                byte[] keyIdentifier = instance.getKeyIdentifier();
                if (keyIdentifier != null) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor2 = (TrustAnchor) it.next();
                if (trustAnchor2.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor2.getTrustedCert())) {
                        arrayList.add(trustAnchor2);
                    }
                } else if (!(trustAnchor2.getCAName() == null || trustAnchor2.getCAPublicKey() == null || !CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor2.getCAName())))) {
                    arrayList.add(trustAnchor2);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    public void init(CertPath certPath2, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (!this.initialized) {
            this.initialized = true;
            if (certPath2 != null) {
                this.certPath = certPath2;
                List<? extends Certificate> certificates = certPath2.getCertificates();
                this.certs = certificates;
                this.n = certificates.size();
                if (!this.certs.isEmpty()) {
                    PKIXParameters pKIXParameters2 = (PKIXParameters) pKIXParameters.clone();
                    this.pkixParams = pKIXParameters2;
                    this.validDate = CertPathValidatorUtilities.getValidDate(pKIXParameters2);
                    this.notifications = null;
                    this.errors = null;
                    this.trustAnchor = null;
                    this.subjectPublicKey = null;
                    this.policyTree = null;
                    return;
                }
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.emptyCertPath"));
            }
            throw new NullPointerException("certPath was null");
        }
        throw new IllegalStateException("object is already initialized!");
    }

    public boolean isValidCertPath() {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.errors;
            if (i >= listArr.length) {
                return true;
            }
            if (!listArr[i].isEmpty()) {
                return false;
            }
            i++;
        }
    }

    public void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.errors[i + 1].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    public PKIXCertPathReviewer() {
    }

    public List getErrors(int i) {
        doChecks();
        return this.errors[i + 1];
    }

    public List getNotifications(int i) {
        doChecks();
        return this.notifications[i + 1];
    }
}
