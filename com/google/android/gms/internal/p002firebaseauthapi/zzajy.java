package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajy  reason: invalid package */
final class zzajy implements Comparator<zzajw> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzajw zzajw = (zzajw) obj;
        zzajw zzajw2 = (zzajw) obj2;
        zzakc zzakc = (zzakc) zzajw.iterator();
        zzakc zzakc2 = (zzakc) zzajw2.iterator();
        while (zzakc.hasNext() && zzakc2.hasNext()) {
            int compare = Integer.compare(zzajw.zza(zzakc.zza()), zzajw.zza(zzakc2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzajw.zzb(), zzajw2.zzb());
    }
}
