package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbc  reason: invalid package */
public final class zzbc implements zzby {
    private final InputStream zza;

    private zzbc(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzby zza(byte[] bArr) {
        return new zzbc(new ByteArrayInputStream(bArr));
    }

    public final zzxk zzb() throws IOException {
        try {
            return zzxk.zza(this.zza, zzakv.zza());
        } finally {
            this.zza.close();
        }
    }

    public final zzvy zza() throws IOException {
        try {
            return zzvy.zza(this.zza, zzakv.zza());
        } finally {
            this.zza.close();
        }
    }
}
