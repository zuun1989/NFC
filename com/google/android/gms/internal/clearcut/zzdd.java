package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

final class zzdd implements zzeg {
    private static final zzdn zzlz = new zzde();
    private final zzdn zzly;

    public zzdd() {
        this(new zzdf(zzcf.zzay(), zzby()));
    }

    private static boolean zza(zzdm zzdm) {
        return zzdm.zzcf() == zzcg.zzg.zzkl;
    }

    private static zzdn zzby() {
        try {
            return (zzdn) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            return zzlz;
        }
    }

    public final <T> zzef<T> zzd(Class<T> cls) {
        zzeh.zzf((Class<?>) cls);
        zzdm zzb = this.zzly.zzb(cls);
        Class<zzcg> cls2 = zzcg.class;
        if (zzb.zzcg()) {
            return cls2.isAssignableFrom(cls) ? zzdu.zza(zzeh.zzdo(), zzbx.zzap(), zzb.zzch()) : zzdu.zza(zzeh.zzdm(), zzbx.zzaq(), zzb.zzch());
        }
        if (cls2.isAssignableFrom(cls)) {
            boolean zza = zza(zzb);
            zzdw zzck = zzdy.zzck();
            zzcy zzbw = zzcy.zzbw();
            zzex<?, ?> zzdo = zzeh.zzdo();
            if (zza) {
                return zzds.zza(cls, zzb, zzck, zzbw, zzdo, zzbx.zzap(), zzdl.zzcd());
            }
            return zzds.zza(cls, zzb, zzck, zzbw, zzdo, (zzbu<?>) null, zzdl.zzcd());
        }
        boolean zza2 = zza(zzb);
        zzdw zzcj = zzdy.zzcj();
        zzcy zzbv = zzcy.zzbv();
        if (zza2) {
            return zzds.zza(cls, zzb, zzcj, zzbv, zzeh.zzdm(), zzbx.zzaq(), zzdl.zzcc());
        }
        return zzds.zza(cls, zzb, zzcj, zzbv, zzeh.zzdn(), (zzbu<?>) null, zzdl.zzcc());
    }

    private zzdd(zzdn zzdn) {
        this.zzly = (zzdn) zzci.zza(zzdn, "messageInfoFactory");
    }
}
