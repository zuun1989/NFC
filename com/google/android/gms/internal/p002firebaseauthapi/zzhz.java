package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhz  reason: invalid package */
public final class zzhz implements zzaz {
    private final zzaz zza;
    private final byte[] zzb;

    private zzhz(zzaz zzaz, byte[] bArr) {
        this.zza = zzaz;
        if (bArr.length == 0 || bArr.length == 5) {
            this.zzb = bArr;
            return;
        }
        throw new IllegalArgumentException("identifier has an invalid length");
    }

    public static zzaz zza(zzoe zzoe) throws GeneralSecurityException {
        byte[] bArr;
        zzqe zza2 = zzoe.zza(zzbi.zza());
        zzaz zzaz = (zzaz) zznt.zza().zza(zza2.zzf(), zzaz.class).zzb(zza2.zzd());
        zzyc zzc = zza2.zzc();
        int i = zzic.zza[zzc.ordinal()];
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
        return new zzhz(zzaz, bArr);
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zzb(bArr, bArr2);
        }
        return zzzc.zza(bArr3, this.zza.zzb(bArr, bArr2));
    }

    public static zzaz zza(zzaz zzaz, zzaam zzaam) {
        return new zzhz(zzaz, zzaam.zzb());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqq.zza(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
