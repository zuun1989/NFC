package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxk;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbv  reason: invalid package */
public final class zzbv {
    private final zzxk.zzb zza;

    private zzbv(zzxk.zzb zzb) {
        this.zza = zzb;
    }

    public final synchronized zzbl zza() throws GeneralSecurityException {
        return zzbl.zza((zzxk) ((zzalg) this.zza.zze()));
    }

    public static zzbv zza(zzbl zzbl) {
        return new zzbv((zzxk.zzb) zzbl.zzd().zzn());
    }
}
