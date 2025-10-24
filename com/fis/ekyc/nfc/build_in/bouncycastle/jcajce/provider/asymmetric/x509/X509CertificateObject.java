package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.BasicConstraints;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.util.Date;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

class X509CertificateObject extends X509CertificateImpl implements PKCS12BagAttributeCarrier {
    private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
    private final Object cacheLock = new Object();
    private volatile int hashValue;
    private volatile boolean hashValueSet;
    private X509CertificateInternal internalCertificateValue;
    private X500Principal issuerValue;
    private PublicKey publicKeyValue;
    private X500Principal subjectValue;
    private long[] validityValues;

    public X509CertificateObject(JcaJceHelper jcaJceHelper, Certificate certificate) throws CertificateParsingException {
        super(jcaJceHelper, certificate, createBasicConstraints(certificate), createKeyUsage(certificate), createSigAlgName(certificate), createSigAlgParams(certificate));
    }

    private static BasicConstraints createBasicConstraints(Certificate certificate) throws CertificateParsingException {
        try {
            byte[] extensionOctets = X509CertificateImpl.getExtensionOctets(certificate, "2.5.29.19");
            if (extensionOctets == null) {
                return null;
            }
            return BasicConstraints.getInstance(ASN1Primitive.fromByteArray(extensionOctets));
        } catch (Exception e) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + e);
        }
    }

    private static boolean[] createKeyUsage(Certificate certificate) throws CertificateParsingException {
        boolean z;
        try {
            byte[] extensionOctets = X509CertificateImpl.getExtensionOctets(certificate, "2.5.29.15");
            if (extensionOctets == null) {
                return null;
            }
            DERBitString instance = DERBitString.getInstance(ASN1Primitive.fromByteArray(extensionOctets));
            byte[] bytes = instance.getBytes();
            int length = (bytes.length * 8) - instance.getPadBits();
            int i = 9;
            if (length >= 9) {
                i = length;
            }
            boolean[] zArr = new boolean[i];
            for (int i2 = 0; i2 != length; i2++) {
                if ((bytes[i2 / 8] & (128 >>> (i2 % 8))) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[i2] = z;
            }
            return zArr;
        } catch (Exception e) {
            throw new CertificateParsingException("cannot construct KeyUsage: " + e);
        }
    }

    private static String createSigAlgName(Certificate certificate) throws CertificateParsingException {
        try {
            return X509SignatureUtil.getSignatureName(certificate.getSignatureAlgorithm());
        } catch (Exception e) {
            throw new CertificateParsingException("cannot construct SigAlgName: " + e);
        }
    }

    private static byte[] createSigAlgParams(Certificate certificate) throws CertificateParsingException {
        try {
            ASN1Encodable parameters = certificate.getSignatureAlgorithm().getParameters();
            if (parameters == null) {
                return null;
            }
            return parameters.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (Exception e) {
            throw new CertificateParsingException("cannot construct SigAlgParams: " + e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0 = getEncoded();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0012, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal getInternalCertificate() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.cacheLock
            monitor-enter(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal r1 = r9.internalCertificateValue     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return r1
        L_0x0009:
            r1 = move-exception
            goto L_0x0038
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            byte[] r0 = r9.getEncoded()     // Catch:{ CertificateEncodingException -> 0x0012 }
        L_0x0010:
            r8 = r0
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0010
        L_0x0014:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper r2 = r9.bcHelper
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate r3 = r9.c
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.BasicConstraints r4 = r9.basicConstraints
            boolean[] r5 = r9.keyUsage
            java.lang.String r6 = r9.sigAlgName
            byte[] r7 = r9.sigAlgParams
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.lang.Object r1 = r9.cacheLock
            monitor-enter(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal r2 = r9.internalCertificateValue     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0032
            r9.internalCertificateValue = r0     // Catch:{ all -> 0x0030 }
            goto L_0x0032
        L_0x0030:
            r0 = move-exception
            goto L_0x0036
        L_0x0032:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal r0 = r9.internalCertificateValue     // Catch:{ all -> 0x0030 }
            monitor-exit(r1)     // Catch:{ all -> 0x0030 }
            return r0
        L_0x0036:
            monitor-exit(r1)     // Catch:{ all -> 0x0030 }
            throw r0
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getInternalCertificate():com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateInternal");
    }

    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        long time = date.getTime();
        long[] validityValues2 = getValidityValues();
        if (time > validityValues2[1]) {
            throw new CertificateExpiredException("certificate expired on " + this.c.getEndDate().getTime());
        } else if (time < validityValues2[0]) {
            throw new CertificateNotYetValidException("certificate not valid till " + this.c.getStartDate().getTime());
        }
    }

    public boolean equals(Object obj) {
        DERBitString signature;
        if (obj == this) {
            return true;
        }
        if (obj instanceof X509CertificateObject) {
            X509CertificateObject x509CertificateObject = (X509CertificateObject) obj;
            if (!this.hashValueSet || !x509CertificateObject.hashValueSet) {
                if ((this.internalCertificateValue == null || x509CertificateObject.internalCertificateValue == null) && (signature = this.c.getSignature()) != null && !signature.equals((ASN1Primitive) x509CertificateObject.c.getSignature())) {
                    return false;
                }
            } else if (this.hashValue != x509CertificateObject.hashValue) {
                return false;
            }
        }
        return getInternalCertificate().equals(obj);
    }

    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(aSN1ObjectIdentifier);
    }

    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000c, code lost:
        r0 = super.getIssuerX500Principal();
        r1 = r3.cacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
        if (r3.issuerValue != null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0017, code lost:
        r3.issuerValue = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001c, code lost:
        r0 = r3.issuerValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x001e, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x001f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0021, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.cacheLock
            monitor-enter(r0)
            javax.security.auth.x500.X500Principal r1 = r3.issuerValue     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return r1
        L_0x0009:
            r1 = move-exception
            goto L_0x0022
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            javax.security.auth.x500.X500Principal r0 = super.getIssuerX500Principal()
            java.lang.Object r1 = r3.cacheLock
            monitor-enter(r1)
            javax.security.auth.x500.X500Principal r2 = r3.issuerValue     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x001c
            r3.issuerValue = r0     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
            r0 = move-exception
            goto L_0x0020
        L_0x001c:
            javax.security.auth.x500.X500Principal r0 = r3.issuerValue     // Catch:{ all -> 0x001a }
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            return r0
        L_0x0020:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r0
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getIssuerX500Principal():javax.security.auth.x500.X500Principal");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000c, code lost:
        r0 = super.getPublicKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        if (r0 != null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0014, code lost:
        r1 = r3.cacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0016, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0019, code lost:
        if (r3.publicKeyValue != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001b, code lost:
        r3.publicKeyValue = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0020, code lost:
        r0 = r3.publicKeyValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0022, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0023, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0025, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.PublicKey getPublicKey() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.cacheLock
            monitor-enter(r0)
            java.security.PublicKey r1 = r3.publicKeyValue     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return r1
        L_0x0009:
            r1 = move-exception
            goto L_0x0026
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            java.security.PublicKey r0 = super.getPublicKey()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            return r0
        L_0x0014:
            java.lang.Object r1 = r3.cacheLock
            monitor-enter(r1)
            java.security.PublicKey r2 = r3.publicKeyValue     // Catch:{ all -> 0x001e }
            if (r2 != 0) goto L_0x0020
            r3.publicKeyValue = r0     // Catch:{ all -> 0x001e }
            goto L_0x0020
        L_0x001e:
            r0 = move-exception
            goto L_0x0024
        L_0x0020:
            java.security.PublicKey r0 = r3.publicKeyValue     // Catch:{ all -> 0x001e }
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            return r0
        L_0x0024:
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            throw r0
        L_0x0026:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getPublicKey():java.security.PublicKey");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000c, code lost:
        r0 = super.getSubjectX500Principal();
        r1 = r3.cacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
        if (r3.subjectValue != null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0017, code lost:
        r3.subjectValue = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001c, code lost:
        r0 = r3.subjectValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x001e, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x001f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0021, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.security.auth.x500.X500Principal getSubjectX500Principal() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.cacheLock
            monitor-enter(r0)
            javax.security.auth.x500.X500Principal r1 = r3.subjectValue     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return r1
        L_0x0009:
            r1 = move-exception
            goto L_0x0022
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            javax.security.auth.x500.X500Principal r0 = super.getSubjectX500Principal()
            java.lang.Object r1 = r3.cacheLock
            monitor-enter(r1)
            javax.security.auth.x500.X500Principal r2 = r3.subjectValue     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x001c
            r3.subjectValue = r0     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
            r0 = move-exception
            goto L_0x0020
        L_0x001c:
            javax.security.auth.x500.X500Principal r0 = r3.subjectValue     // Catch:{ all -> 0x001a }
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            return r0
        L_0x0020:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r0
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getSubjectX500Principal():javax.security.auth.x500.X500Principal");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000c, code lost:
        r4 = new long[]{super.getNotBefore().getTime(), super.getNotAfter().getTime()};
        r1 = r6.cacheLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r6.validityValues != null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r6.validityValues = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        r0 = r6.validityValues;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long[] getValidityValues() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.cacheLock
            monitor-enter(r0)
            long[] r1 = r6.validityValues     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return r1
        L_0x0009:
            r1 = move-exception
            goto L_0x0037
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            java.util.Date r0 = super.getNotBefore()
            long r0 = r0.getTime()
            java.util.Date r2 = super.getNotAfter()
            long r2 = r2.getTime()
            r4 = 2
            long[] r4 = new long[r4]
            r5 = 0
            r4[r5] = r0
            r0 = 1
            r4[r0] = r2
            java.lang.Object r1 = r6.cacheLock
            monitor-enter(r1)
            long[] r0 = r6.validityValues     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0031
            r6.validityValues = r4     // Catch:{ all -> 0x002f }
            goto L_0x0031
        L_0x002f:
            r0 = move-exception
            goto L_0x0035
        L_0x0031:
            long[] r0 = r6.validityValues     // Catch:{ all -> 0x002f }
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            return r0
        L_0x0035:
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            throw r0
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getValidityValues():long[]");
    }

    public int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = getInternalCertificate().hashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }

    public int originalHashCode() {
        try {
            byte[] encoded = getInternalCertificate().getEncoded();
            int i = 0;
            for (int i2 = 1; i2 < encoded.length; i2++) {
                i += encoded[i2] * i2;
            }
            return i;
        } catch (CertificateEncodingException unused) {
            return 0;
        }
    }

    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }
}
