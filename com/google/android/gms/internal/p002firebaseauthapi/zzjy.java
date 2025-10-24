package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjy  reason: invalid package */
public final class zzjy implements zzbd {
    private final zzbd zza;
    private final zzyc zzb;
    private final byte[] zzc;

    private zzjy(zzbd zzbd, zzyc zzyc, byte[] bArr) {
        this.zza = zzbd;
        this.zzb = zzyc;
        this.zzc = bArr;
    }

    public static zzbd zza(zzoe zzoe) throws GeneralSecurityException {
        byte[] bArr;
        zzqe zza2 = zzoe.zza(zzbi.zza());
        zzbd zzbd = (zzbd) zznt.zza().zza(zza2.zzf(), zzbd.class).zzb(zza2.zzd());
        zzyc zzc2 = zza2.zzc();
        int i = zzjx.zza[zzc2.ordinal()];
        if (i == 1) {
            bArr = zzpd.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArr = zzpd.zza(zzoe.zzb().intValue()).zzb();
        } else if (i == 4) {
            bArr = zzpd.zzb(zzoe.zzb().intValue()).zzb();
        } else {
            int zza3 = zzc2.zza();
            throw new GeneralSecurityException("unknown output prefix type " + zza3);
        }
        return new zzjy(zzbd, zzc2, bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (this.zzb == zzyc.RAW) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqq.zza(this.zzc, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
