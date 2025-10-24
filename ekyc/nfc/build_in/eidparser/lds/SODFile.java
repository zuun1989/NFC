package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.ContentInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.SignedData;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.icao.DataGroupHash;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.icao.LDSSecurityObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.icao.LDSVersionInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.x500.X500Principal;

public class SODFile extends AbstractTaggedLDSFile {
    private static final String ICAO_LDS_SOD_ALT_OID = "1.3.27.1.1.1";
    private static final String ICAO_LDS_SOD_OID = "2.23.136.1.1.1";
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final String SDU_LDS_SOD_OID = "1.2.528.1.1006.1.20.1";
    private static final long serialVersionUID = -1081347374739311111L;
    private transient SignedData signedData;

    public SODFile(String str, String str2, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate) throws GeneralSecurityException {
        this(str, str2, map, privateKey, x509Certificate, (String) null);
    }

    private static LDSSecurityObject getLDSSecurityObject(SignedData signedData2) {
        ASN1InputStream aSN1InputStream;
        try {
            ContentInfo encapContentInfo = signedData2.getEncapContentInfo();
            String id = encapContentInfo.getContentType().getId();
            ASN1OctetString aSN1OctetString = (ASN1OctetString) encapContentInfo.getContent();
            if (!ICAO_LDS_SOD_OID.equals(id) && !SDU_LDS_SOD_OID.equals(id) && !ICAO_LDS_SOD_ALT_OID.equals(id)) {
                Logger logger = LOGGER;
                logger.warning("SignedData does not appear to contain an LDS SOd. (content type is " + id + ", was expecting 2.23.136.1.1.1)");
            }
            aSN1InputStream = new ASN1InputStream((InputStream) new ByteArrayInputStream(aSN1OctetString.getOctets()));
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject instanceof ASN1Sequence) {
                LDSSecurityObject instance = LDSSecurityObject.getInstance(readObject);
                if (aSN1InputStream.readObject() != null) {
                    LOGGER.warning("Ignoring extra object found after LDSSecurityObject...");
                }
                aSN1InputStream.close();
                return instance;
            }
            throw new IllegalStateException("Expected ASN1Sequence, found " + readObject.getClass().getSimpleName());
        } catch (IOException e) {
            throw new IllegalStateException("Could not read security object in signedData", e);
        } catch (Throwable th) {
            aSN1InputStream.close();
            throw th;
        }
    }

    private static ContentInfo toContentInfo(String str, String str2, Map<Integer, byte[]> map, String str3, String str4) throws NoSuchAlgorithmException, IOException {
        LDSSecurityObject lDSSecurityObject;
        DataGroupHash[] dataGroupHashArr = new DataGroupHash[map.size()];
        int i = 0;
        for (Map.Entry<Integer, byte[]> key : map.entrySet()) {
            Integer num = (Integer) key.getKey();
            dataGroupHashArr[i] = new DataGroupHash(num.intValue(), new DEROctetString(map.get(num)));
            i++;
        }
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(new ASN1ObjectIdentifier(SignedDataUtil.lookupOIDByMnemonic(str2)));
        if (str3 == null) {
            lDSSecurityObject = new LDSSecurityObject(algorithmIdentifier, dataGroupHashArr);
        } else {
            lDSSecurityObject = new LDSSecurityObject(algorithmIdentifier, dataGroupHashArr, new LDSVersionInfo(str3, str4));
        }
        return new ContentInfo(new ASN1ObjectIdentifier(str), new DEROctetString((ASN1Encodable) lDSSecurityObject));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        return Arrays.equals(getEncoded(), ((SODFile) obj).getEncoded());
    }

    public Map<Integer, byte[]> getDataGroupHashes() {
        DataGroupHash[] datagroupHash = getLDSSecurityObject(this.signedData).getDatagroupHash();
        TreeMap treeMap = new TreeMap();
        for (DataGroupHash dataGroupHash : datagroupHash) {
            treeMap.put(Integer.valueOf(dataGroupHash.getDataGroupNumber()), dataGroupHash.getDataGroupHashValue().getOctets());
        }
        return treeMap;
    }

    public String getDigestAlgorithm() {
        return getDigestAlgorithm(getLDSSecurityObject(this.signedData));
    }

    public String getDigestEncryptionAlgorithm() {
        return SignedDataUtil.getDigestEncryptionAlgorithm(this.signedData);
    }

    public AlgorithmParameterSpec getDigestEncryptionAlgorithmParams() {
        return SignedDataUtil.getDigestEncryptionAlgorithmParams(this.signedData);
    }

    public X509Certificate getDocSigningCertificate() {
        List<X509Certificate> docSigningCertificates = getDocSigningCertificates();
        if (docSigningCertificates == null || docSigningCertificates.isEmpty()) {
            return null;
        }
        return docSigningCertificates.get(docSigningCertificates.size() - 1);
    }

    public List<X509Certificate> getDocSigningCertificates() {
        return SignedDataUtil.getCertificates(this.signedData);
    }

    public byte[] getEContent() throws SignatureException {
        return SignedDataUtil.getEContent(this.signedData);
    }

    public byte[] getEncryptedDigest() {
        return SignedDataUtil.getEncryptedDigest(this.signedData);
    }

    public X500Principal getIssuerX500Principal() {
        X500Name name;
        try {
            IssuerAndSerialNumber issuerAndSerialNumber = SignedDataUtil.getIssuerAndSerialNumber(this.signedData);
            if (issuerAndSerialNumber == null || (name = issuerAndSerialNumber.getName()) == null) {
                return null;
            }
            return new X500Principal(name.getEncoded(ASN1Encoding.DER));
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Could not get issuer", e);
            return null;
        }
    }

    public String getLDSVersion() {
        LDSVersionInfo versionInfo = getLDSSecurityObject(this.signedData).getVersionInfo();
        if (versionInfo == null) {
            return null;
        }
        return versionInfo.getLdsVersion();
    }

    public BigInteger getSerialNumber() {
        IssuerAndSerialNumber issuerAndSerialNumber = SignedDataUtil.getIssuerAndSerialNumber(this.signedData);
        if (issuerAndSerialNumber == null) {
            return null;
        }
        return issuerAndSerialNumber.getSerialNumber().getValue();
    }

    public String getSignerInfoDigestAlgorithm() {
        return SignedDataUtil.getSignerInfoDigestAlgorithm(this.signedData);
    }

    public byte[] getSubjectKeyIdentifier() {
        return SignedDataUtil.getSubjectKeyIdentifier(this.signedData);
    }

    public String getUnicodeVersion() {
        LDSVersionInfo versionInfo = getLDSSecurityObject(this.signedData).getVersionInfo();
        if (versionInfo == null) {
            return null;
        }
        return versionInfo.getUnicodeVersion();
    }

    public int hashCode() {
        return (Arrays.hashCode(getEncoded()) * 11) + LDSFile.EF_DG15_TAG;
    }

    public void readContent(InputStream inputStream) throws IOException {
        this.signedData = SignedDataUtil.readSignedData(inputStream);
    }

    public String toString() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SODFile ");
            for (X509Certificate issuerX500Principal : getDocSigningCertificates()) {
                sb2.append(issuerX500Principal.getIssuerX500Principal().getName());
                sb2.append(", ");
            }
            return sb2.toString();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Unexpected exception", e);
            return "SODFile";
        }
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        SignedDataUtil.writeData(this.signedData, outputStream);
    }

    public SODFile(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate) throws GeneralSecurityException {
        this(str, str2, algorithmParameterSpec, map, privateKey, x509Certificate, (String) null);
    }

    private static String getDigestAlgorithm(LDSSecurityObject lDSSecurityObject) {
        try {
            return SignedDataUtil.lookupMnemonicByOID(lDSSecurityObject.getDigestAlgorithmIdentifier().getAlgorithm().getId());
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return null;
        }
    }

    public SODFile(String str, String str2, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate, String str3) throws GeneralSecurityException {
        this(str, str2, map, privateKey, x509Certificate, str3, (String) null, (String) null);
    }

    public SODFile(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate, String str3) throws GeneralSecurityException {
        this(str, str2, algorithmParameterSpec, map, privateKey, x509Certificate, str3, (String) null, (String) null);
    }

    public SODFile(String str, String str2, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate, String str3, String str4, String str5) throws GeneralSecurityException {
        super(LDSFile.EF_SOD_TAG);
        try {
            ContentInfo contentInfo = toContentInfo(ICAO_LDS_SOD_OID, str, map, str4, str5);
            this.signedData = SignedDataUtil.createSignedData(str, str2, ICAO_LDS_SOD_OID, contentInfo, SignedDataUtil.signData(str, str2, ICAO_LDS_SOD_OID, contentInfo, privateKey, str3), x509Certificate);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error creating signedData", e);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SODFile(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, Map<Integer, byte[]> map, PrivateKey privateKey, X509Certificate x509Certificate, String str3, String str4, String str5) throws GeneralSecurityException {
        super(LDSFile.EF_SOD_TAG);
        String str6 = str;
        Map<Integer, byte[]> map2 = map;
        try {
            ContentInfo contentInfo = toContentInfo(ICAO_LDS_SOD_OID, str, map, str4, str5);
            this.signedData = SignedDataUtil.createSignedData(str, str2, algorithmParameterSpec, ICAO_LDS_SOD_OID, contentInfo, SignedDataUtil.signData(str, str2, algorithmParameterSpec, ICAO_LDS_SOD_OID, contentInfo, privateKey, str3), x509Certificate);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error creating signedData", e);
        }
    }

    public SODFile(String str, String str2, Map<Integer, byte[]> map, byte[] bArr, X509Certificate x509Certificate) throws GeneralSecurityException {
        super(LDSFile.EF_SOD_TAG);
        if (map != null) {
            try {
                this.signedData = SignedDataUtil.createSignedData(str, str2, ICAO_LDS_SOD_OID, toContentInfo(ICAO_LDS_SOD_OID, str, map, (String) null, (String) null), bArr, x509Certificate);
            } catch (IOException e) {
                throw new IllegalArgumentException("Error creating signedData", e);
            }
        } else {
            throw new IllegalArgumentException("Cannot construct security object from null datagroup hashes");
        }
    }

    public SODFile(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, Map<Integer, byte[]> map, byte[] bArr, X509Certificate x509Certificate) throws GeneralSecurityException {
        super(LDSFile.EF_SOD_TAG);
        if (map != null) {
            try {
                this.signedData = SignedDataUtil.createSignedData(str, str2, algorithmParameterSpec, ICAO_LDS_SOD_OID, toContentInfo(ICAO_LDS_SOD_OID, str, map, (String) null, (String) null), bArr, x509Certificate);
            } catch (IOException e) {
                throw new IllegalArgumentException("Error creating signedData", e);
            }
        } else {
            throw new IllegalArgumentException("Cannot construct security object from null datagroup hashes");
        }
    }

    public SODFile(InputStream inputStream) throws IOException {
        super(LDSFile.EF_SOD_TAG, inputStream);
        SignedDataUtil.getSignerInfo(this.signedData);
    }
}
