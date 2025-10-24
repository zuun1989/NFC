package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Type;

public enum zzcb {
    DOUBLE(0, r4, r42),
    FLOAT(1, r4, r43),
    INT64(2, r4, r5),
    UINT64(3, r4, r5),
    INT32(4, r4, r54),
    FIXED64(5, r4, r55),
    FIXED32(6, r4, r54),
    BOOL(7, r4, r49),
    STRING(8, r4, r33),
    MESSAGE(9, r4, r56),
    BYTES(10, r4, r35),
    UINT32(11, r4, r54),
    ENUM(12, r4, r51),
    SFIXED32(13, r4, r54),
    SFIXED64(14, r4, r55),
    SINT32(15, r4, r54),
    SINT64(16, r4, r55),
    GROUP(17, r4, r56),
    DOUBLE_LIST(18, r4, r42),
    FLOAT_LIST(19, r4, r43),
    INT64_LIST(20, r4, r5),
    UINT64_LIST(21, r4, r5),
    INT32_LIST(22, r4, r54),
    FIXED64_LIST(23, r4, r55),
    FIXED32_LIST(24, r4, r54),
    BOOL_LIST(25, r4, r49),
    STRING_LIST(26, r4, r33),
    MESSAGE_LIST(27, r4, r56),
    BYTES_LIST(28, r4, r35),
    UINT32_LIST(29, r4, r54),
    ENUM_LIST(30, r4, r51),
    SFIXED32_LIST(31, r4, r54),
    SFIXED64_LIST(32, r4, r55),
    SINT32_LIST(33, r4, r54),
    SINT64_LIST(34, r4, r55),
    DOUBLE_LIST_PACKED(35, r4, r42),
    FLOAT_LIST_PACKED(36, r4, r43),
    INT64_LIST_PACKED(37, r4, r5),
    UINT64_LIST_PACKED(38, r4, r5),
    INT32_LIST_PACKED(39, r4, r54),
    FIXED64_LIST_PACKED(40, r4, r55),
    FIXED32_LIST_PACKED(41, r4, r54),
    BOOL_LIST_PACKED(42, r4, r49),
    UINT32_LIST_PACKED(43, r4, r54),
    ENUM_LIST_PACKED(44, r4, r51),
    SFIXED32_LIST_PACKED(45, r4, r54),
    SFIXED64_LIST_PACKED(46, r4, r55),
    SINT32_LIST_PACKED(47, r4, r54),
    SINT64_LIST_PACKED(48, r4, r55),
    GROUP_LIST(49, r57, r56),
    MAP(50, zzcd.MAP, zzcq.VOID);
    
    private static final zzcb[] zzjb = null;
    private static final Type[] zzjc = null;
    private final int id;
    private final zzcq zzix;
    private final zzcd zziy;
    private final Class<?> zziz;
    private final boolean zzja;

    static {
        zzjc = new Type[0];
        zzcb[] values = values();
        zzjb = new zzcb[values.length];
        for (zzcb zzcb : values) {
            zzjb[zzcb.id] = zzcb;
        }
    }

    private zzcb(int i, zzcd zzcd, zzcq zzcq) {
        int i2;
        this.id = i;
        this.zziy = zzcd;
        this.zzix = zzcq;
        int i3 = zzcc.zzje[zzcd.ordinal()];
        boolean z = true;
        this.zziz = (i3 == 1 || i3 == 2) ? zzcq.zzbq() : null;
        this.zzja = (zzcd != zzcd.SCALAR || (i2 = zzcc.zzjf[zzcq.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }
}
