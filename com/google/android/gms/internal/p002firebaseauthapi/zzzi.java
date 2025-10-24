package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzi  reason: invalid package */
public final class zzzi {
    public static int zza(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (zzni.zza(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    private static BigInteger zza(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger bigInteger2;
        BigInteger zza = zzni.zza(ellipticCurve);
        BigInteger mod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(zza);
        if (zza.signum() == 1) {
            BigInteger mod2 = mod.mod(zza);
            BigInteger bigInteger3 = BigInteger.ZERO;
            if (!mod2.equals(bigInteger3)) {
                if (zza.testBit(0) && zza.testBit(1)) {
                    bigInteger2 = mod2.modPow(zza.add(BigInteger.ONE).shiftRight(2), zza);
                } else if (!zza.testBit(0) || zza.testBit(1)) {
                    bigInteger2 = null;
                } else {
                    bigInteger3 = BigInteger.ONE;
                    BigInteger shiftRight = zza.subtract(bigInteger3).shiftRight(1);
                    int i = 0;
                    while (true) {
                        BigInteger mod3 = bigInteger3.multiply(bigInteger3).subtract(mod2).mod(zza);
                        if (mod3.equals(BigInteger.ZERO)) {
                            break;
                        }
                        BigInteger modPow = mod3.modPow(shiftRight, zza);
                        BigInteger bigInteger4 = BigInteger.ONE;
                        if (modPow.add(bigInteger4).equals(zza)) {
                            BigInteger shiftRight2 = zza.add(bigInteger4).shiftRight(1);
                            BigInteger bigInteger5 = bigInteger3;
                            for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                                BigInteger multiply = bigInteger5.multiply(bigInteger4);
                                bigInteger5 = bigInteger5.multiply(bigInteger5).add(bigInteger4.multiply(bigInteger4).mod(zza).multiply(mod3)).mod(zza);
                                BigInteger mod4 = multiply.add(multiply).mod(zza);
                                if (shiftRight2.testBit(bitLength)) {
                                    BigInteger mod5 = bigInteger5.multiply(bigInteger3).add(mod4.multiply(mod3)).mod(zza);
                                    bigInteger4 = bigInteger3.multiply(mod4).add(bigInteger5).mod(zza);
                                    bigInteger5 = mod5;
                                } else {
                                    bigInteger4 = mod4;
                                }
                            }
                            bigInteger2 = bigInteger5;
                        } else if (modPow.equals(bigInteger4)) {
                            bigInteger3 = bigInteger3.add(bigInteger4);
                            i++;
                            if (i == 128 && !zza.isProbablePrime(80)) {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                        } else {
                            throw new InvalidAlgorithmParameterException("p is not prime");
                        }
                    }
                }
                if (bigInteger3 != null && bigInteger3.multiply(bigInteger3).mod(zza).compareTo(mod2) != 0) {
                    throw new GeneralSecurityException("Could not find a modular square root");
                }
            }
            return z != bigInteger3.testBit(0) ? zza.subtract(bigInteger3).mod(zza) : bigInteger3;
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static KeyPair zza(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator zza = zzzm.zzd.zza("EC");
        zza.initialize(eCParameterSpec);
        return zza.generateKeyPair();
    }

    public static ECPrivateKey zza(zzzh zzzh, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) zzzm.zze.zza("EC").generatePrivate(new ECPrivateKeySpec(zznh.zza(bArr), zza(zzzh)));
    }

    public static ECPublicKey zza(ECParameterSpec eCParameterSpec, zzzk zzzk, byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) zzzm.zze.zza("EC").generatePublic(new ECPublicKeySpec(zza(eCParameterSpec.getCurve(), zzzk, bArr), eCParameterSpec));
    }

    public static ECParameterSpec zza(zzzh zzzh) throws NoSuchAlgorithmException {
        int ordinal = zzzh.ordinal();
        if (ordinal == 0) {
            return zzni.zza;
        }
        if (ordinal == 1) {
            return zzni.zzb;
        }
        if (ordinal == 2) {
            return zzni.zzc;
        }
        String valueOf = String.valueOf(zzzh);
        throw new NoSuchAlgorithmException("curve not implemented:" + valueOf);
    }

    public static ECPoint zza(EllipticCurve ellipticCurve, zzzk zzzk, byte[] bArr) throws GeneralSecurityException {
        int zza = zza(ellipticCurve);
        int ordinal = zzzk.ordinal();
        boolean z = false;
        if (ordinal != 0) {
            if (ordinal == 1) {
                BigInteger zza2 = zzni.zza(ellipticCurve);
                if (bArr.length == zza + 1) {
                    byte b = bArr[0];
                    if (b != 2) {
                        if (b == 3) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("invalid format");
                        }
                    }
                    BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (bigInteger.signum() != -1 && bigInteger.compareTo(zza2) < 0) {
                        return new ECPoint(bigInteger, zza(bigInteger, z, ellipticCurve));
                    }
                    throw new GeneralSecurityException("x is out of range");
                }
                throw new GeneralSecurityException("compressed point has wrong length");
            } else if (ordinal != 2) {
                throw new GeneralSecurityException("invalid format:" + String.valueOf(zzzk));
            } else if (bArr.length == zza * 2) {
                ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOf(bArr, zza)), new BigInteger(1, Arrays.copyOfRange(bArr, zza, bArr.length)));
                zzni.zza(eCPoint, ellipticCurve);
                return eCPoint;
            } else {
                throw new GeneralSecurityException("invalid point size");
            }
        } else if (bArr.length != (zza * 2) + 1) {
            throw new GeneralSecurityException("invalid point size");
        } else if (bArr[0] == 4) {
            int i = zza + 1;
            ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i)), new BigInteger(1, Arrays.copyOfRange(bArr, i, bArr.length)));
            zzni.zza(eCPoint2, ellipticCurve);
            return eCPoint2;
        } else {
            throw new GeneralSecurityException("invalid point format");
        }
    }

    public static byte[] zza(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        try {
            if (zzni.zza(eCPublicKey.getParams(), eCPrivateKey.getParams())) {
                return zza(eCPrivateKey, eCPublicKey.getW());
            }
            throw new GeneralSecurityException("invalid public key spec");
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private static byte[] zza(ECPrivateKey eCPrivateKey, ECPoint eCPoint) throws GeneralSecurityException {
        zzni.zza(eCPoint, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = zzzm.zze.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, eCPrivateKey.getParams()));
        KeyAgreement zza = zzzm.zzc.zza("ECDH");
        zza.init(eCPrivateKey);
        try {
            zza.doPhase(generatePublic, true);
            byte[] generateSecret = zza.generateSecret();
            EllipticCurve curve = eCPrivateKey.getParams().getCurve();
            BigInteger bigInteger = new BigInteger(1, generateSecret);
            if (bigInteger.signum() == -1 || bigInteger.compareTo(zzni.zza(curve)) >= 0) {
                throw new GeneralSecurityException("shared secret is out of range");
            }
            zza(bigInteger, true, curve);
            return generateSecret;
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException(e);
        }
    }
}
