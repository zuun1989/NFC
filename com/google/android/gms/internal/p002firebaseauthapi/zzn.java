package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.regex.Matcher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzn  reason: invalid package */
final class zzn extends zzm {
    private final Matcher zza;

    public zzn(Matcher matcher) {
        this.zza = (Matcher) zzu.zza(matcher);
    }

    public final int zza() {
        return this.zza.end();
    }

    public final int zzb() {
        return this.zza.start();
    }

    public final boolean zzc() {
        return this.zza.matches();
    }

    public final boolean zza(int i) {
        return this.zza.find(i);
    }
}
