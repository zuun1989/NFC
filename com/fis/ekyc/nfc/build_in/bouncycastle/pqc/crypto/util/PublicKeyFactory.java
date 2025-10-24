package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.XMSSKeyParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.XMSSMTKeyParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.XMSSPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSMTParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class PublicKeyFactory {
    private static Map converters;

    public static class LMSConverter extends SubjectPublicKeyInfoConverter {
        private LMSConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            byte[] octets = ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets();
            if (Pack.bigEndianToInt(octets, 0) == 1) {
                return LMSPublicKeyParameters.getInstance(Arrays.copyOfRange(octets, 4, octets.length));
            }
            if (octets.length == 64) {
                octets = Arrays.copyOfRange(octets, 4, octets.length);
            }
            return HSSPublicKeyParameters.getInstance(octets);
        }
    }

    public static class NHConverter extends SubjectPublicKeyInfoConverter {
        private NHConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            return new NHPublicKeyParameters(subjectPublicKeyInfo.getPublicKeyData().getBytes());
        }
    }

    public static class QTeslaConverter extends SubjectPublicKeyInfoConverter {
        private QTeslaConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            return new QTESLAPublicKeyParameters(Utils.qTeslaLookupSecurityCategory(subjectPublicKeyInfo.getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData().getOctets());
        }
    }

    public static class SPHINCSConverter extends SubjectPublicKeyInfoConverter {
        private SPHINCSConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            return new SPHINCSPublicKeyParameters(subjectPublicKeyInfo.getPublicKeyData().getBytes(), Utils.sphincs256LookupTreeAlgName(SPHINCS256KeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters())));
        }
    }

    public static abstract class SubjectPublicKeyInfoConverter {
        private SubjectPublicKeyInfoConverter() {
        }

        public abstract AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException;
    }

    public static class XMSSConverter extends SubjectPublicKeyInfoConverter {
        private XMSSConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            XMSSKeyParams instance = XMSSKeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            if (instance != null) {
                ASN1ObjectIdentifier algorithm = instance.getTreeDigest().getAlgorithm();
                XMSSPublicKey instance2 = XMSSPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
                return new XMSSPublicKeyParameters.Builder(new XMSSParameters(instance.getHeight(), Utils.getDigest(algorithm))).withPublicSeed(instance2.getPublicSeed()).withRoot(instance2.getRoot()).build();
            }
            byte[] octets = ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets();
            return new XMSSPublicKeyParameters.Builder(XMSSParameters.lookupByOID(Pack.bigEndianToInt(octets, 0))).withPublicKey(octets).build();
        }
    }

    public static class XMSSMTConverter extends SubjectPublicKeyInfoConverter {
        private XMSSMTConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            XMSSMTKeyParams instance = XMSSMTKeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            if (instance != null) {
                ASN1ObjectIdentifier algorithm = instance.getTreeDigest().getAlgorithm();
                XMSSPublicKey instance2 = XMSSPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
                return new XMSSMTPublicKeyParameters.Builder(new XMSSMTParameters(instance.getHeight(), instance.getLayers(), Utils.getDigest(algorithm))).withPublicSeed(instance2.getPublicSeed()).withRoot(instance2.getRoot()).build();
            }
            byte[] octets = ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets();
            return new XMSSMTPublicKeyParameters.Builder(XMSSMTParameters.lookupByOID(Pack.bigEndianToInt(octets, 0))).withPublicKey(octets).build();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        converters = hashMap;
        hashMap.put(PQCObjectIdentifiers.qTESLA_p_I, new QTeslaConverter());
        converters.put(PQCObjectIdentifiers.qTESLA_p_III, new QTeslaConverter());
        converters.put(PQCObjectIdentifiers.sphincs256, new SPHINCSConverter());
        converters.put(PQCObjectIdentifiers.newHope, new NHConverter());
        converters.put(PQCObjectIdentifiers.xmss, new XMSSConverter());
        converters.put(PQCObjectIdentifiers.xmss_mt, new XMSSMTConverter());
        converters.put(IsaraObjectIdentifiers.id_alg_xmss, new XMSSConverter());
        converters.put(IsaraObjectIdentifiers.id_alg_xmssmt, new XMSSMTConverter());
        converters.put(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new LMSConverter());
    }

    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        return createKey(subjectPublicKeyInfo, (Object) null);
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
        AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
        SubjectPublicKeyInfoConverter subjectPublicKeyInfoConverter = (SubjectPublicKeyInfoConverter) converters.get(algorithm.getAlgorithm());
        if (subjectPublicKeyInfoConverter != null) {
            return subjectPublicKeyInfoConverter.getPublicKeyParameters(subjectPublicKeyInfo, obj);
        }
        throw new IOException("algorithm identifier in public key not recognised: " + algorithm.getAlgorithm());
    }
}
