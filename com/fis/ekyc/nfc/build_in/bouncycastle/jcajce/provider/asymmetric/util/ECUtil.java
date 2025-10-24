package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.ECNamedCurveTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec.CustomNamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.FixedPointCombMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Fingerprint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.math.BigInteger;
import java.security.AccessController;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Enumeration;

public class ECUtil {
    public static int[] convertMidTerms(int[] iArr) {
        int i;
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else if (iArr.length == 3) {
            int i2 = iArr[0];
            int i3 = iArr[1];
            if (i2 >= i3 || i2 >= (i = iArr[2])) {
                int i4 = iArr[2];
                if (i3 < i4) {
                    iArr2[0] = i3;
                    int i5 = iArr[0];
                    if (i5 < i4) {
                        iArr2[1] = i5;
                        iArr2[2] = i4;
                    } else {
                        iArr2[1] = i4;
                        iArr2[2] = i5;
                    }
                } else {
                    iArr2[0] = i4;
                    int i6 = iArr[0];
                    if (i6 < i3) {
                        iArr2[1] = i6;
                        iArr2[2] = iArr[1];
                    } else {
                        iArr2[1] = i3;
                        iArr2[2] = i6;
                    }
                }
            } else {
                iArr2[0] = i2;
                if (i3 < i) {
                    iArr2[1] = i3;
                    iArr2[2] = i;
                } else {
                    iArr2[1] = i;
                    iArr2[2] = iArr[1];
                }
            }
        } else {
            throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
        }
        return iArr2;
    }

    public static String generateKeyFingerprint(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        ECCurve curve = eCParameterSpec.getCurve();
        ECPoint g = eCParameterSpec.getG();
        if (curve != null) {
            return new Fingerprint(Arrays.concatenate(eCPoint.getEncoded(false), curve.getA().getEncoded(), curve.getB().getEncoded(), g.getEncoded(false))).toString();
        }
        return new Fingerprint(eCPoint.getEncoded(false)).toString();
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            ECParameterSpec parameters = eCPrivateKey.getParameters();
            if (parameters == null) {
                parameters = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
            }
            if (!(eCPrivateKey.getParameters() instanceof ECNamedCurveParameterSpec)) {
                return new ECPrivateKeyParameters(eCPrivateKey.getD(), new ECDomainParameters(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
            }
            return new ECPrivateKeyParameters(eCPrivateKey.getD(), new ECNamedDomainParameters(ECNamedCurveTable.getOID(((ECNamedCurveParameterSpec) eCPrivateKey.getParameters()).getName()), parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
        } else if (privateKey instanceof java.security.interfaces.ECPrivateKey) {
            java.security.interfaces.ECPrivateKey eCPrivateKey2 = (java.security.interfaces.ECPrivateKey) privateKey;
            ECParameterSpec convertSpec = EC5Util.convertSpec(eCPrivateKey2.getParams());
            return new ECPrivateKeyParameters(eCPrivateKey2.getS(), new ECDomainParameters(convertSpec.getCurve(), convertSpec.getG(), convertSpec.getN(), convertSpec.getH(), convertSpec.getSeed()));
        } else {
            try {
                byte[] encoded = privateKey.getEncoded();
                if (encoded != null) {
                    PrivateKey privateKey2 = BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(encoded));
                    if (privateKey2 instanceof java.security.interfaces.ECPrivateKey) {
                        return generatePrivateKeyParameter(privateKey2);
                    }
                    throw new InvalidKeyException("can't identify EC private key.");
                }
                throw new InvalidKeyException("no encoding for EC private key");
            } catch (Exception e) {
                throw new InvalidKeyException("cannot identify EC private key: " + e.toString());
            }
        }
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            ECParameterSpec parameters = eCPublicKey.getParameters();
            return new ECPublicKeyParameters(eCPublicKey.getQ(), new ECDomainParameters(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
        } else if (publicKey instanceof java.security.interfaces.ECPublicKey) {
            java.security.interfaces.ECPublicKey eCPublicKey2 = (java.security.interfaces.ECPublicKey) publicKey;
            ECParameterSpec convertSpec = EC5Util.convertSpec(eCPublicKey2.getParams());
            return new ECPublicKeyParameters(EC5Util.convertPoint(eCPublicKey2.getParams(), eCPublicKey2.getW()), new ECDomainParameters(convertSpec.getCurve(), convertSpec.getG(), convertSpec.getN(), convertSpec.getH(), convertSpec.getSeed()));
        } else {
            try {
                byte[] encoded = publicKey.getEncoded();
                if (encoded != null) {
                    PublicKey publicKey2 = BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(encoded));
                    if (publicKey2 instanceof java.security.interfaces.ECPublicKey) {
                        return generatePublicKeyParameter(publicKey2);
                    }
                    throw new InvalidKeyException("cannot identify EC public key.");
                }
                throw new InvalidKeyException("no encoding for EC public key");
            } catch (Exception e) {
                throw new InvalidKeyException("cannot identify EC public key: " + e.toString());
            }
        }
    }

    public static String getCurveName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return ECNamedCurveTable.getName(aSN1ObjectIdentifier);
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration providerConfiguration, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec instanceof ECNamedCurveParameterSpec) {
            ECNamedCurveParameterSpec eCNamedCurveParameterSpec = (ECNamedCurveParameterSpec) eCParameterSpec;
            return new ECNamedDomainParameters(getNamedCurveOid(eCNamedCurveParameterSpec.getName()), eCNamedCurveParameterSpec.getCurve(), eCNamedCurveParameterSpec.getG(), eCNamedCurveParameterSpec.getN(), eCNamedCurveParameterSpec.getH(), eCNamedCurveParameterSpec.getSeed());
        } else if (eCParameterSpec != null) {
            return new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN(), eCParameterSpec.getH(), eCParameterSpec.getSeed());
        } else {
            ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
            return new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN(), ecImplicitlyCa.getH(), ecImplicitlyCa.getSeed());
        }
    }

    public static String getNameFrom(final AlgorithmParameterSpec algorithmParameterSpec) {
        return (String) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    return algorithmParameterSpec.getClass().getMethod("getName", (Class[]) null).invoke(algorithmParameterSpec, (Object[]) null);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    public static X9ECParameters getNamedCurveByName(String str) {
        X9ECParameters byName = CustomNamedCurves.getByName(str);
        if (byName == null) {
            return ECNamedCurveTable.getByName(str);
        }
        return byName;
    }

    public static X9ECParameters getNamedCurveByOid(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = CustomNamedCurves.getByOID(aSN1ObjectIdentifier);
        if (byOID == null) {
            return ECNamedCurveTable.getByOID(aSN1ObjectIdentifier);
        }
        return byOID;
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf > 0) {
            str = str.substring(indexOf + 1);
        }
        try {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '2') {
                return new ASN1ObjectIdentifier(str);
            }
        } catch (IllegalArgumentException unused) {
        }
        return ECNamedCurveTable.getOID(str);
    }

    public static int getOrderBitLength(ProviderConfiguration providerConfiguration, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != null) {
            return bigInteger.bitLength();
        }
        ECParameterSpec ecImplicitlyCa = providerConfiguration.getEcImplicitlyCa();
        if (ecImplicitlyCa == null) {
            return bigInteger2.bitLength();
        }
        return ecImplicitlyCa.getN().bitLength();
    }

    public static String privateKeyToString(String str, BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        ECPoint normalize = new FixedPointCombMultiplier().multiply(eCParameterSpec.getG(), bigInteger).normalize();
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(generateKeyFingerprint(normalize, eCParameterSpec));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            X: ");
        stringBuffer.append(normalize.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            Y: ");
        stringBuffer.append(normalize.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public static String publicKeyToString(String str, ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(generateKeyFingerprint(eCPoint, eCParameterSpec));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            X: ");
        stringBuffer.append(eCPoint.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            Y: ");
        stringBuffer.append(eCPoint.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(ECParameterSpec eCParameterSpec) {
        Enumeration names = ECNamedCurveTable.getNames();
        while (names.hasMoreElements()) {
            String str = (String) names.nextElement();
            X9ECParameters byName = ECNamedCurveTable.getByName(str);
            if (byName.getN().equals(eCParameterSpec.getN()) && byName.getH().equals(eCParameterSpec.getH()) && byName.getCurve().equals(eCParameterSpec.getCurve()) && byName.getG().equals(eCParameterSpec.getG())) {
                return ECNamedCurveTable.getOID(str);
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters getDomainParameters(com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ProviderConfiguration r6, com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters r7) {
        /*
            boolean r0 = r7.isNamedCurve()
            if (r0 == 0) goto L_0x0025
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r7 = r7.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r7 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r0 = getNamedCurveByOid(r7)
            if (r0 != 0) goto L_0x001f
            java.util.Map r6 = r6.getAdditionalECParameters()
            java.lang.Object r6 = r6.get(r7)
            r0 = r6
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters) r0
        L_0x001f:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters
            r6.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r7, (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters) r0)
            goto L_0x006e
        L_0x0025:
            boolean r0 = r7.isImplicitlyCA()
            if (r0 == 0) goto L_0x004b
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec r6 = r6.getEcImplicitlyCa()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r1 = r6.getCurve()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r2 = r6.getG()
            java.math.BigInteger r3 = r6.getN()
            java.math.BigInteger r4 = r6.getH()
            byte[] r5 = r6.getSeed()
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0049:
            r6 = r7
            goto L_0x006e
        L_0x004b:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r6 = r7.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r6 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters.getInstance(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r1 = r6.getCurve()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r2 = r6.getG()
            java.math.BigInteger r3 = r6.getN()
            java.math.BigInteger r4 = r6.getH()
            byte[] r5 = r6.getSeed()
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0049
        L_0x006e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getDomainParameters(com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ProviderConfiguration, com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters):com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters");
    }
}
