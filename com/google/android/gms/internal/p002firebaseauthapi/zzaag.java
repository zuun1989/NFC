package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaag  reason: invalid package */
final class zzaag extends ThreadLocal<Mac> {
    private final /* synthetic */ zzaad zza;

    public zzaag(zzaad zzaad) {
        Objects.requireNonNull(zzaad);
        this.zza = zzaad;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac zza2 = zzzm.zzb.zza(this.zza.zzc);
            zza2.init(this.zza.zzd);
            return zza2;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
