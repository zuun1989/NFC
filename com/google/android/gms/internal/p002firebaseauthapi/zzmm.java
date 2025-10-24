package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmm  reason: invalid package */
public final class zzmm implements zzbg {
    private final zzbg zza;
    private final byte[] zzb;

    private zzmm(zzbg zzbg, byte[] bArr) {
        this.zza = zzbg;
        this.zzb = bArr;
    }

    public static zzbg zza(zzoe zzoe) throws GeneralSecurityException {
        byte[] bArr;
        zzqe zza2 = zzoe.zza(zzbi.zza());
        zzbg zzbg = (zzbg) zznt.zza().zza(zza2.zzf(), zzbg.class).zzb(zza2.zzd());
        zzyc zzc = zza2.zzc();
        int i = zzmp.zza[zzc.ordinal()];
        if (i == 1) {
            bArr = zzpd.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArr = zzpd.zza(zzoe.zzb().intValue()).zzb();
        } else if (i == 4) {
            bArr = zzpd.zzb(zzoe.zzb().intValue()).zzb();
        } else {
            String valueOf = String.valueOf(zzc);
            throw new GeneralSecurityException("unknown output prefix type " + valueOf);
        }
        return new zzmm(zzbg, bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqq.zza(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }
}
