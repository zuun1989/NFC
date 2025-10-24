package com.google.android.gms.internal.measurement;

final class zznd implements zzny {
    private static final zznk zzb = new zznb();
    private final zznk zza;

    public zznd() {
        zzma zza2 = zzma.zza();
        int i = zznu.zza;
        zznc zznc = new zznc(zza2, zzb);
        byte[] bArr = zzmp.zzb;
        this.zza = zznc;
    }

    public final zznx zza(Class cls) {
        zzls zzls;
        int i = zznz.zza;
        if (!zzmf.class.isAssignableFrom(cls)) {
            int i2 = zznu.zza;
        }
        zznj zzc = this.zza.zzc(cls);
        if (!zzc.zza()) {
            int i3 = zznu.zza;
            zznr zza2 = zzns.zza();
            zzmy zza3 = zzmz.zza();
            zzoi zzA = zznz.zzA();
            if (zzc.zzc() - 1 != 1) {
                zzls = zzlu.zza();
            } else {
                zzls = null;
            }
            return zznp.zzl(cls, zzc, zza2, zza3, zzA, zzls, zzni.zza());
        }
        int i4 = zznu.zza;
        return zznq.zzg(zznz.zzA(), zzlu.zza(), zzc.zzb());
    }
}
