package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocalizedMessage;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import com.fis.ekyc.nfc.build_in.eidparser.APDULevelEACTACapable;
import com.fis.ekyc.nfc.build_in.eidparser.CardServiceProtocolException;
import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate;
import com.fis.ekyc.nfc.build_in.eidparser.cert.CVCPrincipal;
import com.fis.ekyc.nfc.build_in.eidparser.cert.CardVerifiableCertificate;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVOutputStream;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVUtil;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.interfaces.DHPublicKey;

public class EACTAProtocol {
    private static final Provider BC_PROVIDER = Util.getBouncyCastleProvider();
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd.protocol");
    private static final int TAG_CVCERTIFICATE_SIGNATURE = 24375;
    private APDULevelEACTACapable service;
    private SecureMessagingWrapper wrapper;

    public EACTAProtocol(APDULevelEACTACapable aPDULevelEACTACapable, SecureMessagingWrapper secureMessagingWrapper) {
        this.service = aPDULevelEACTACapable;
        this.wrapper = secureMessagingWrapper;
    }

    public static byte[] deriveIdentifier(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[(length + 1)];
        try {
            System.arraycopy(str.getBytes(LocalizedMessage.DEFAULT_ENCODING), 0, bArr, 0, length);
            bArr[length] = (byte) MRZInfo.checkDigit(str);
            return bArr;
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Unsupported encoding", e);
        }
    }

    public synchronized EACTAResult doEACTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, String str2) throws CardServiceException {
        return doTA(cVCPrincipal, list, privateKey, str, eACCAResult, deriveIdentifier(str2));
    }

    public synchronized EACTAResult doTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, PACEResult pACEResult) throws CardServiceException {
        try {
        } catch (NoSuchAlgorithmException e) {
            throw new CardServiceException("No such algorithm", (Throwable) e);
        }
        return doTA(cVCPrincipal, list, privateKey, str, eACCAResult, deriveIdentifier(pACEResult.getPICCPublicKey()));
    }

    public synchronized EACTAResult doTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, byte[] bArr) throws CardServiceException {
        CVCPrincipal cVCPrincipal2;
        byte[] sendGetChallenge;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    if (eACCAResult != null) {
                        byte[] keyHash = eACCAResult.getKeyHash();
                        if (keyHash != null) {
                            CardVerifiableCertificate cardVerifiableCertificate = list.get(0);
                            if (CVCAuthorizationTemplate.Role.CVCA.equals(cardVerifiableCertificate.getAuthorizationTemplate().getRole())) {
                                CVCPrincipal holderReference = cardVerifiableCertificate.getHolderReference();
                                if (cVCPrincipal != null) {
                                    if (!cVCPrincipal.equals(holderReference)) {
                                        throw new CardServiceException("First certificate holds wrong authority, found \"" + holderReference.getName() + "\", expected \"" + cVCPrincipal.getName() + "\"");
                                    }
                                }
                                if (cVCPrincipal == null) {
                                    cVCPrincipal = holderReference;
                                }
                                list.remove(0);
                            }
                            CVCPrincipal authorityReference = cardVerifiableCertificate.getAuthorityReference();
                            if (cVCPrincipal != null) {
                                if (!cVCPrincipal.equals(authorityReference)) {
                                    throw new CardServiceException("First certificate not signed by expected CA, found " + authorityReference.getName() + ", expected " + cVCPrincipal.getName());
                                }
                            }
                            cVCPrincipal2 = cVCPrincipal == null ? authorityReference : cVCPrincipal;
                            CardVerifiableCertificate cardVerifiableCertificate2 = list.get(list.size() - 1);
                            CVCAuthorizationTemplate.Role role = cardVerifiableCertificate2.getAuthorizationTemplate().getRole();
                            if (CVCAuthorizationTemplate.Role.IS.equals(role)) {
                                for (CardVerifiableCertificate next : list) {
                                    this.service.sendMSESetDST(this.wrapper, TLVUtil.wrapDO(ISO781611.CREATION_DATE_AND_TIME_TAG, next.getAuthorityReference().getName().getBytes(LocalizedMessage.DEFAULT_ENCODING)));
                                    byte[] certBodyData = next.getCertBodyData();
                                    byte[] signature = next.getSignature();
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    TLVOutputStream tLVOutputStream = new TLVOutputStream(byteArrayOutputStream);
                                    tLVOutputStream.writeTag(TAG_CVCERTIFICATE_SIGNATURE);
                                    tLVOutputStream.writeValue(signature);
                                    tLVOutputStream.close();
                                    this.service.sendPSOExtendedLengthMode(this.wrapper, certBodyData, byteArrayOutputStream.toByteArray());
                                }
                                if (privateKey != null) {
                                    this.service.sendMSESetATExtAuth(this.wrapper, TLVUtil.wrapDO(ISO781611.CREATION_DATE_AND_TIME_TAG, cardVerifiableCertificate2.getHolderReference().getName().getBytes(LocalizedMessage.DEFAULT_ENCODING)));
                                    sendGetChallenge = this.service.sendGetChallenge(this.wrapper);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    byteArrayOutputStream2.write(bArr);
                                    byteArrayOutputStream2.write(sendGetChallenge);
                                    byteArrayOutputStream2.write(keyHash);
                                    byteArrayOutputStream2.close();
                                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                    String sigAlgName = cardVerifiableCertificate2.getSigAlgName();
                                    if (sigAlgName != null) {
                                        Signature instance = Signature.getInstance(sigAlgName, BC_PROVIDER);
                                        instance.initSign(privateKey);
                                        instance.update(byteArray);
                                        byte[] sign = instance.sign();
                                        if (sigAlgName.toUpperCase().endsWith("ECDSA")) {
                                            sign = Util.getRawECDSASignature(sign, (int) Math.ceil(((double) ((ECPrivateKey) privateKey).getParameters().getCurve().getFieldSize()) / 8.0d));
                                        }
                                        this.service.sendMutualAuthenticate(this.wrapper, sign);
                                    } else {
                                        throw new IllegalStateException("Could not determine signature algorithm for terminal certificate " + cardVerifiableCertificate2.getHolderReference().getName());
                                    }
                                } else {
                                    throw new CardServiceException("No terminal key");
                                }
                            } else {
                                throw new CardServiceException("Last certificate in chain (" + cardVerifiableCertificate2.getHolderReference().getName() + ") does not have role IS, but has role " + role);
                            }
                        } else {
                            throw new IllegalArgumentException("Could nnot get EAC-CA key hash");
                        }
                    } else {
                        throw new IllegalArgumentException("Could not get EAC-CA key hash");
                    }
                }
            } catch (Exception e) {
                throw new CardServiceProtocolException("Exception in MSE Set AT", 3, (Throwable) e);
            } catch (Exception e2) {
                throw new CardServiceProtocolException("Exception in Get Challenge", 4, (Throwable) e2);
            } catch (Exception e3) {
                LOGGER.log(Level.WARNING, "Exception", e3);
                throw new CardServiceProtocolException("Exception in External Authenticate", 5, (Throwable) e3);
            } catch (Exception e4) {
                throw new CardServiceProtocolException("Exception in MSE:SetDST", 1, (Throwable) e4);
            } catch (Exception e5) {
                throw new CardServiceProtocolException("Exception", 2, (Throwable) e5);
            } catch (CardServiceException e6) {
                throw e6;
            } catch (Exception e7) {
                throw new CardServiceException("Unexpected exception", (Throwable) e7);
            } catch (Throwable th) {
                throw th;
            }
        }
        throw new IllegalArgumentException("Need at least 1 certificate to perform TA, found: " + list);
        return new EACTAResult(eACCAResult, cVCPrincipal2, list, privateKey, (String) null, sendGetChallenge);
    }

    public static byte[] deriveIdentifier(PublicKey publicKey) throws NoSuchAlgorithmException {
        if (publicKey == null) {
            return null;
        }
        String algorithm = publicKey.getAlgorithm();
        if ("DH".equals(algorithm) || (publicKey instanceof DHPublicKey)) {
            return MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA1).digest(Util.i2os(((DHPublicKey) publicKey).getY()));
        }
        if ("ECDH".equals(algorithm) || (publicKey instanceof ECPublicKey)) {
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPublicKey eCPublicKey = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPublicKey) publicKey;
            return Util.alignKeyDataToSize(Util.i2os(eCPublicKey.getQ().getAffineXCoord().toBigInteger()), (int) Math.ceil(((double) eCPublicKey.getParameters().getCurve().getFieldSize()) / 8.0d));
        }
        throw new NoSuchAlgorithmException("Unsupported agreement algorithm " + algorithm);
    }
}
