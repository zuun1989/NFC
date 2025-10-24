package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaoh  reason: invalid package */
public enum zzaoh {
    DOUBLE(zzaok.DOUBLE, 1),
    FLOAT(zzaok.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzaok.BOOLEAN, 0),
    STRING(zzaok.STRING, (zzaok) null),
    GROUP(r19, (zzaok) null),
    MESSAGE(r19, (zzaok) null),
    BYTES(zzaok.BYTE_STRING, (zzaok) null),
    UINT32(r11, 0),
    ENUM(zzaok.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzaok zzt;
    private final int zzu;

    public final int zza() {
        return this.zzu;
    }

    public final zzaok zzb() {
        return this.zzt;
    }

    private zzaoh(zzaok zzaok, int i) {
        this.zzt = zzaok;
        this.zzu = i;
    }
}
