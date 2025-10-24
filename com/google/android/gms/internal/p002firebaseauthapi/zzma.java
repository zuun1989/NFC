package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzma  reason: invalid package */
public final class zzma {
    private static final byte[] zza = new byte[0];
    private final zzmb zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private BigInteger zzf = BigInteger.ZERO;

    private zzma(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzmb zzmb) {
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzmb;
    }

    public static zzma zza(byte[] bArr, zzmh zzmh, zzme zzme, zzmf zzmf, zzmb zzmb, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = zzme.zza(bArr, zzmh);
        byte[] bArr3 = zzmn.zza;
        byte[] zza3 = zzmn.zza(zzme.zza(), zzmf.zzb(), zzmb.zzc());
        byte[] bArr4 = zzmn.zzl;
        byte[] bArr5 = zza;
        byte[] zza4 = zzzc.zza(bArr3, zzmf.zza(bArr4, bArr5, "psk_id_hash", zza3), zzmf.zza(bArr4, bArr2, "info_hash", zza3));
        zzmf zzmf2 = zzmf;
        byte[] zza5 = zzmf.zza(zza2, bArr5, "secret", zza3);
        byte[] bArr6 = zza4;
        byte[] bArr7 = zza3;
        byte[] zza6 = zzmf2.zza(zza5, bArr6, "key", bArr7, zzmb.zza());
        byte[] zza7 = zzmf2.zza(zza5, bArr6, "base_nonce", bArr7, zzmb.zzb());
        zzmb.zzb();
        BigInteger bigInteger = BigInteger.ONE;
        return new zzma(bArr, zza6, zza7, bigInteger.shiftLeft(96).subtract(bigInteger), zzmb);
    }

    private final synchronized byte[] zza() throws GeneralSecurityException {
        byte[] zza2;
        zza2 = zzzc.zza(this.zze, zznh.zza(this.zzf, this.zzb.zzb()));
        if (this.zzf.compareTo(this.zzc) < 0) {
            this.zzf = this.zzf.add(BigInteger.ONE);
        } else {
            throw new GeneralSecurityException("message limit reached");
        }
        return zza2;
    }

    public final byte[] zza(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zza(this.zzd, zza(), bArr, i, bArr2);
    }
}
