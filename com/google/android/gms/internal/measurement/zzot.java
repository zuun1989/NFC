package com.google.android.gms.internal.measurement;

public enum zzot {
    DOUBLE(zzou.DOUBLE, 1),
    FLOAT(zzou.FLOAT, 5),
    INT64(r12, 0),
    UINT64(r12, 0),
    INT32(r9, 0),
    FIXED64(r12, 1),
    FIXED32(r9, 5),
    BOOL(zzou.BOOLEAN, 0),
    STRING(zzou.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzou.BYTE_STRING, 2),
    UINT32(r15, 0),
    ENUM(zzou.ENUM, 0),
    SFIXED32(r15, 5),
    SFIXED64(r1, 1),
    SINT32(r3, 0),
    SINT64(r1, 0);
    
    private final zzou zzs;
    private final int zzt;

    private zzot(zzou zzou, int i) {
        this.zzs = zzou;
        this.zzt = i;
    }

    public final zzou zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
