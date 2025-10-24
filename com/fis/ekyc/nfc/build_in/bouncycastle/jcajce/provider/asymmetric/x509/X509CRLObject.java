package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CertificateList;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extension;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.IssuingDistributionPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import java.security.cert.CRLException;

class X509CRLObject extends X509CRLImpl {
    private final Object cacheLock = new Object();
    private volatile int hashValue;
    private volatile boolean hashValueSet;
    private X509CRLInternal internalCRLValue;

    public X509CRLObject(JcaJceHelper jcaJceHelper, CertificateList certificateList) throws CRLException {
        super(jcaJceHelper, certificateList, createSigAlgName(certificateList), createSigAlgParams(certificateList), isIndirectCRL(certificateList));
    }

    private static String createSigAlgName(CertificateList certificateList) throws CRLException {
        try {
            return X509SignatureUtil.getSignatureName(certificateList.getSignatureAlgorithm());
        } catch (Exception e) {
            throw new CRLException("CRL contents invalid: " + e);
        }
    }

    private static byte[] createSigAlgParams(CertificateList certificateList) throws CRLException {
        try {
            ASN1Encodable parameters = certificateList.getSignatureAlgorithm().getParameters();
            if (parameters == null) {
                return null;
            }
            return parameters.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (Exception e) {
            throw new CRLException("CRL contents invalid: " + e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0 = getEncoded();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0012, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal getInternalCRL() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.cacheLock
            monitor-enter(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal r1 = r8.internalCRLValue     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return r1
        L_0x0009:
            r1 = move-exception
            goto L_0x0036
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            byte[] r0 = r8.getEncoded()     // Catch:{ CRLException -> 0x0012 }
        L_0x0010:
            r7 = r0
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0010
        L_0x0014:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper r2 = r8.bcHelper
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CertificateList r3 = r8.c
            java.lang.String r4 = r8.sigAlgName
            byte[] r5 = r8.sigAlgParams
            boolean r6 = r8.isIndirect
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            java.lang.Object r1 = r8.cacheLock
            monitor-enter(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal r2 = r8.internalCRLValue     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x0030
            r8.internalCRLValue = r0     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x002e:
            r0 = move-exception
            goto L_0x0034
        L_0x0030:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal r0 = r8.internalCRLValue     // Catch:{ all -> 0x002e }
            monitor-exit(r1)     // Catch:{ all -> 0x002e }
            return r0
        L_0x0034:
            monitor-exit(r1)     // Catch:{ all -> 0x002e }
            throw r0
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLObject.getInternalCRL():com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLInternal");
    }

    private static boolean isIndirectCRL(CertificateList certificateList) throws CRLException {
        try {
            byte[] extensionOctets = X509CRLImpl.getExtensionOctets(certificateList, Extension.issuingDistributionPoint.getId());
            if (extensionOctets == null) {
                return false;
            }
            return IssuingDistributionPoint.getInstance(extensionOctets).isIndirectCRL();
        } catch (Exception e) {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", e);
        }
    }

    public boolean equals(Object obj) {
        DERBitString signature;
        if (this == obj) {
            return true;
        }
        if (obj instanceof X509CRLObject) {
            X509CRLObject x509CRLObject = (X509CRLObject) obj;
            if (!this.hashValueSet || !x509CRLObject.hashValueSet) {
                if ((this.internalCRLValue == null || x509CRLObject.internalCRLValue == null) && (signature = this.c.getSignature()) != null && !signature.equals((ASN1Primitive) x509CRLObject.c.getSignature())) {
                    return false;
                }
            } else if (this.hashValue != x509CRLObject.hashValue) {
                return false;
            }
        }
        return getInternalCRL().equals(obj);
    }

    public int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = getInternalCRL().hashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }
}
