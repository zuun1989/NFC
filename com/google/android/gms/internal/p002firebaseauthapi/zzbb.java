package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzvy;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbb  reason: invalid package */
public final class zzbb implements zzbx {
    private final OutputStream zza;

    private zzbb(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzbx zza(OutputStream outputStream) {
        return new zzbb(outputStream);
    }

    public final void zza(zzvy zzvy) throws IOException {
        try {
            ((zzvy) ((zzalg) ((zzvy.zza) zzvy.zzn()).zza().zze())).zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    public final void zza(zzxk zzxk) throws IOException {
        try {
            zzxk.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
