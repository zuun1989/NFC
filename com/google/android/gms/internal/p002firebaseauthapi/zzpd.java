package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpd  reason: invalid package */
public final class zzpd {
    public static final zzaam zza = zzaam.zza(new byte[0]);

    public static final zzaam zza(int i) {
        return zzaam.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzaam zzb(int i) {
        return zzaam.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
