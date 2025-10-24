package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalw  reason: invalid package */
final class zzalw implements zzalx {
    private static <E> zzaln<E> zzc(Object obj, long j) {
        return (zzaln) zzaoa.zze(obj, j);
    }

    public final <L> List<L> zza(Object obj, long j) {
        zzaln zzc = zzc(obj, j);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzaln zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzaoa.zza(obj, j, (Object) zza);
        return zza;
    }

    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    public final <E> void zza(Object obj, Object obj2, long j) {
        zzaln zzc = zzc(obj, j);
        zzaln zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzc()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzaoa.zza(obj, j, (Object) zzc2);
    }
}
