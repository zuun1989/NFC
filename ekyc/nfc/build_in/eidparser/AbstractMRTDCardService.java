package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.eidparser.cert.CVCPrincipal;
import com.fis.ekyc.nfc.build_in.eidparser.cert.CardVerifiableCertificate;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.AAResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.BACResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.EACCAResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.EACTAResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.PACEResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.SecureMessagingWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.List;
import javax.crypto.SecretKey;

public abstract class AbstractMRTDCardService extends FileSystemCardService {
    public abstract AAResult doAA(PublicKey publicKey, String str, String str2, byte[] bArr) throws CardServiceException;

    public abstract BACResult doBAC(AccessKeySpec accessKeySpec) throws CardServiceException;

    public abstract BACResult doBAC(SecretKey secretKey, SecretKey secretKey2) throws CardServiceException, GeneralSecurityException;

    public abstract EACCAResult doEACCA(BigInteger bigInteger, String str, String str2, PublicKey publicKey) throws CardServiceException;

    public abstract EACTAResult doEACTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, PACEResult pACEResult) throws CardServiceException;

    public abstract EACTAResult doEACTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, String str2) throws CardServiceException;

    @Deprecated
    public PACEResult doPACE(AccessKeySpec accessKeySpec, String str, AlgorithmParameterSpec algorithmParameterSpec) throws CardServiceException {
        return doPACE(accessKeySpec, str, algorithmParameterSpec, (BigInteger) null);
    }

    public abstract PACEResult doPACE(AccessKeySpec accessKeySpec, String str, AlgorithmParameterSpec algorithmParameterSpec, BigInteger bigInteger) throws CardServiceException;

    public abstract int getMaxReadBinaryLength();

    public abstract SecureMessagingWrapper getWrapper();

    public abstract void sendSelectApplet(boolean z) throws CardServiceException;

    public abstract void sendSelectMF() throws CardServiceException;
}
