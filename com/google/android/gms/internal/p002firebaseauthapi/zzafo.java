package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafo  reason: invalid package */
final class zzafo implements Runnable {
    private final /* synthetic */ zzafn zza;
    private final /* synthetic */ zzafi zzb;

    public zzafo(zzafi zzafi, zzafn zzafn) {
        this.zza = zzafn;
        Objects.requireNonNull(zzafi);
        this.zzb = zzafi;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            try {
                if (!this.zzb.zza.zzh.isEmpty()) {
                    this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
