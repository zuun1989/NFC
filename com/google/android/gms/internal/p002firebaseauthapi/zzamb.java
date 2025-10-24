package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamb  reason: invalid package */
final class zzamb implements zzanf {
    private static final zzamk zza = new zzama();
    private final zzamk zzb;

    public zzamb() {
        this(new zzamc(zzalh.zza(), zza));
    }

    public final <T> zzanc<T> zza(Class<T> cls) {
        zzakx<?> zzakx;
        zzane.zza((Class<?>) cls);
        zzaml zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            return zzamt.zza(zzane.zza(), zzakz.zza(), zza2.zza());
        }
        zzamv zza3 = zzamx.zza();
        zzalx zza4 = zzalz.zza();
        zzanv<?, ?> zza5 = zzane.zza();
        if (zzamd.zza[zza2.zzb().ordinal()] != 1) {
            zzakx = zzakz.zza();
        } else {
            zzakx = null;
        }
        return zzamr.zza(cls, zza2, zza3, zza4, zza5, zzakx, zzami.zza());
    }

    private zzamb(zzamk zzamk) {
        this.zzb = (zzamk) zzali.zza(zzamk, "messageInfoFactory");
    }
}
