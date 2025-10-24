package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcy  reason: invalid package */
public final class zzcy {
    public static final zzxe zza = zza(16);
    public static final zzxe zzb = zza(32);
    public static final zzxe zzc;

    static {
        zza(16, 16);
        zza(32, 16);
        zzwb zzwb = zzwb.SHA256;
        zzc = zza(16, 16, 32, 16, zzwb);
        zza(32, 16, 32, 32, zzwb);
        zzxe.zza zza2 = zzxe.zza().zza(zzel.zza());
        zzyc zzyc = zzyc.TINK;
        zzxe zzxe = (zzxe) ((zzalg) zza2.zza(zzyc).zze());
        zzxe zzxe2 = (zzxe) ((zzalg) zzxe.zza().zza(zzgd.zza()).zza(zzyc).zze());
    }

    private static zzxe zza(int i, int i2, int i3, int i4, zzwb zzwb) {
        return (zzxe) ((zzalg) zzxe.zza().zza(((zztl) ((zzalg) zztl.zza().zza((zztr) ((zzalg) zztr.zzb().zza((zztu) ((zzalg) zztu.zzb().zza(16).zze())).zza(i).zze())).zza((zzwd) ((zzalg) zzwd.zzc().zza((zzwg) ((zzalg) zzwg.zzc().zza(zzwb).zza(i4).zze())).zza(32).zze())).zze())).zzj()).zza(zzdh.zza()).zza(zzyc.TINK).zze());
    }

    private static zzxe zza(int i, int i2) {
        return (zzxe) ((zzalg) zzxe.zza().zza(((zzua) ((zzalg) zzua.zzb().zza(i).zza((zzud) ((zzalg) zzud.zzb().zza(16).zze())).zze())).zzj()).zza(zzdp.zza()).zza(zzyc.TINK).zze());
    }

    private static zzxe zza(int i) {
        return (zzxe) ((zzalg) zzxe.zza().zza(((zzuj) ((zzalg) zzuj.zzc().zza(i).zze())).zzj()).zza(zzdw.zza()).zza(zzyc.TINK).zze());
    }
}
