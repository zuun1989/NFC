package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsp  reason: invalid package */
public final class zzsp implements zzcb {
    private static final byte[] zza = {0};
    private final zzcb zzb;
    private final zzyc zzc;
    private final byte[] zzd;

    private zzsp(zzcb zzcb, zzyc zzyc, byte[] bArr) {
        this.zzb = zzcb;
        this.zzc = zzyc;
        this.zzd = bArr;
    }

    public static zzcb zza(zzoe zzoe) throws GeneralSecurityException {
        byte[] bArr;
        zzqe zza2 = zzoe.zza(zzbi.zza());
        zzcb zzcb = (zzcb) zznt.zza().zza(zza2.zzf(), zzcb.class).zzb(zza2.zzd());
        zzyc zzc2 = zza2.zzc();
        int i = zzso.zza[zzc2.ordinal()];
        if (i == 1) {
            bArr = zzpd.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArr = zzpd.zza(zzoe.zzb().intValue()).zzb();
        } else if (i == 4) {
            bArr = zzpd.zzb(zzoe.zzb().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return new zzsp(zzcb, zzc2, bArr);
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 10) {
            if (this.zzc.equals(zzyc.LEGACY)) {
                bArr2 = zzzc.zza(bArr2, zza);
            }
            byte[] bArr3 = new byte[0];
            if (!this.zzc.equals(zzyc.RAW)) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                bArr = Arrays.copyOfRange(bArr, 5, bArr.length);
                bArr3 = copyOf;
            }
            if (Arrays.equals(this.zzd, bArr3)) {
                this.zzb.zza(bArr, bArr2);
                return;
            }
            throw new GeneralSecurityException("wrong prefix");
        }
        throw new GeneralSecurityException("tag too short");
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        if (this.zzc.equals(zzyc.LEGACY)) {
            bArr = zzzc.zza(bArr, zza);
        }
        return zzzc.zza(this.zzd, this.zzb.zza(bArr));
    }
}
