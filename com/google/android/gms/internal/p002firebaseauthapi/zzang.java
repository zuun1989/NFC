package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzang  reason: invalid package */
final class zzang extends zzanh {
    public zzang() {
        super();
    }

    public final void zza() {
        if (!zze()) {
            for (int i = 0; i < zzb(); i++) {
                Map.Entry zza = zza(i);
                if (((zzala) zza.getKey()).zze()) {
                    zza.setValue(Collections.unmodifiableList((List) zza.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzala) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
