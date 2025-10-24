package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzo  reason: invalid package */
final class zzo extends zzl implements Serializable {
    private final Pattern zza;

    public zzo(Pattern pattern) {
        this.zza = (Pattern) zzu.zza(pattern);
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final zzm zza(CharSequence charSequence) {
        return new zzn(this.zza.matcher(charSequence));
    }
}
