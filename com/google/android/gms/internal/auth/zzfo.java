package com.google.android.gms.internal.auth;

final class zzfo implements zzgi {
    private static final zzfu zza = new zzfm();
    private final zzfu zzb;

    public zzfo() {
        zzfu zzfu;
        zzer zza2 = zzer.zza();
        try {
            zzfu = (zzfu) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            zzfu = zza;
        }
        zzfn zzfn = new zzfn(zza2, zzfu);
        zzez.zzf(zzfn, "messageInfoFactory");
        this.zzb = zzfn;
    }

    private static boolean zzb(zzft zzft) {
        if (zzft.zzc() == 1) {
            return true;
        }
        return false;
    }

    public final zzgh zza(Class cls) {
        zzgj.zzg(cls);
        zzft zzb2 = this.zzb.zzb(cls);
        Class<zzeu> cls2 = zzeu.class;
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzga.zzb(zzgj.zzc(), zzen.zzb(), zzb2.zza());
            }
            return zzga.zzb(zzgj.zza(), zzen.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzfz.zzj(cls, zzb2, zzgc.zzb(), zzfk.zzd(), zzgj.zzc(), zzen.zzb(), zzfs.zzb());
            }
            return zzfz.zzj(cls, zzb2, zzgc.zzb(), zzfk.zzd(), zzgj.zzc(), (zzel) null, zzfs.zzb());
        } else if (zzb(zzb2)) {
            return zzfz.zzj(cls, zzb2, zzgc.zza(), zzfk.zzc(), zzgj.zza(), zzen.zza(), zzfs.zza());
        } else {
            return zzfz.zzj(cls, zzb2, zzgc.zza(), zzfk.zzc(), zzgj.zzb(), (zzel) null, zzfs.zza());
        }
    }
}
