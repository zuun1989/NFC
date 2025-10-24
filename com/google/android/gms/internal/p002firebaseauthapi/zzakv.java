package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakv  reason: invalid package */
public final class zzakv {
    static final zzakv zza = new zzakv(true);
    private static volatile boolean zzb = false;
    private final Map<zzaku, zzalg.zzf<?, ?>> zzc;

    public zzakv() {
        this.zzc = new HashMap();
    }

    public static zzakv zza() {
        return zza;
    }

    public final <ContainingType extends zzamn> zzalg.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzc.get(new zzaku(containingtype, i));
    }

    private zzakv(boolean z) {
        this.zzc = Collections.emptyMap();
    }
}
