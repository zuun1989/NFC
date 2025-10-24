package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.XMSSKeyParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.XMSSMTKeyParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.XMSSMTPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.XMSSPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.Composer;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Encodable;
import java.io.IOException;

public class SubjectPublicKeyInfoFactory {
    private SubjectPublicKeyInfoFactory() {
    }

    public static SubjectPublicKeyInfo createSubjectPublicKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter) throws IOException {
        if (asymmetricKeyParameter instanceof QTESLAPublicKeyParameters) {
            QTESLAPublicKeyParameters qTESLAPublicKeyParameters = (QTESLAPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(Utils.qTeslaLookupAlgID(qTESLAPublicKeyParameters.getSecurityCategory()), qTESLAPublicKeyParameters.getPublicData());
        } else if (asymmetricKeyParameter instanceof SPHINCSPublicKeyParameters) {
            SPHINCSPublicKeyParameters sPHINCSPublicKeyParameters = (SPHINCSPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(Utils.sphincs256LookupTreeAlgID(sPHINCSPublicKeyParameters.getTreeDigest()))), sPHINCSPublicKeyParameters.getKeyData());
        } else if (asymmetricKeyParameter instanceof NHPublicKeyParameters) {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.newHope), ((NHPublicKeyParameters) asymmetricKeyParameter).getPubData());
        } else {
            if (asymmetricKeyParameter instanceof LMSPublicKeyParameters) {
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), (ASN1Encodable) new DEROctetString(Composer.compose().u32str(1).bytes((Encodable) (LMSPublicKeyParameters) asymmetricKeyParameter).build()));
            } else if (asymmetricKeyParameter instanceof HSSPublicKeyParameters) {
                HSSPublicKeyParameters hSSPublicKeyParameters = (HSSPublicKeyParameters) asymmetricKeyParameter;
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), (ASN1Encodable) new DEROctetString(Composer.compose().u32str(hSSPublicKeyParameters.getL()).bytes((Encodable) hSSPublicKeyParameters.getLMSPublicKey()).build()));
            } else if (asymmetricKeyParameter instanceof XMSSPublicKeyParameters) {
                XMSSPublicKeyParameters xMSSPublicKeyParameters = (XMSSPublicKeyParameters) asymmetricKeyParameter;
                byte[] publicSeed = xMSSPublicKeyParameters.getPublicSeed();
                byte[] root = xMSSPublicKeyParameters.getRoot();
                byte[] encoded = xMSSPublicKeyParameters.getEncoded();
                if (encoded.length > publicSeed.length + root.length) {
                    return new SubjectPublicKeyInfo(new AlgorithmIdentifier(IsaraObjectIdentifiers.id_alg_xmss), (ASN1Encodable) new DEROctetString(encoded));
                }
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss, new XMSSKeyParams(xMSSPublicKeyParameters.getParameters().getHeight(), Utils.xmssLookupTreeAlgID(xMSSPublicKeyParameters.getTreeDigest()))), (ASN1Encodable) new XMSSPublicKey(publicSeed, root));
            } else if (asymmetricKeyParameter instanceof XMSSMTPublicKeyParameters) {
                XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) asymmetricKeyParameter;
                byte[] publicSeed2 = xMSSMTPublicKeyParameters.getPublicSeed();
                byte[] root2 = xMSSMTPublicKeyParameters.getRoot();
                byte[] encoded2 = xMSSMTPublicKeyParameters.getEncoded();
                if (encoded2.length > publicSeed2.length + root2.length) {
                    return new SubjectPublicKeyInfo(new AlgorithmIdentifier(IsaraObjectIdentifiers.id_alg_xmssmt), (ASN1Encodable) new DEROctetString(encoded2));
                }
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss_mt, new XMSSMTKeyParams(xMSSMTPublicKeyParameters.getParameters().getHeight(), xMSSMTPublicKeyParameters.getParameters().getLayers(), Utils.xmssLookupTreeAlgID(xMSSMTPublicKeyParameters.getTreeDigest()))), (ASN1Encodable) new XMSSMTPublicKey(xMSSMTPublicKeyParameters.getPublicSeed(), xMSSMTPublicKeyParameters.getRoot()));
            } else {
                throw new IOException("key parameters not recognized");
            }
        }
    }
}
