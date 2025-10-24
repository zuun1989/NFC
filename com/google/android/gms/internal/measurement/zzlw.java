package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzlw {
    private static final zzlw zzd = new zzlw(true);
    final zzoe zza = new zzoa();
    private boolean zzb;
    private boolean zzc;

    private zzlw() {
    }

    public static zzlw zza() {
        return zzd;
    }

    public static void zzf(zzlm zzlm, zzot zzot, int i, Object obj) throws IOException {
        if (zzot != zzot.GROUP) {
            zzlm.zza(i, zzot.zzb());
            zzou zzou = zzou.INT;
            switch (zzot.ordinal()) {
                case 0:
                    zzlm.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case 1:
                    zzlm.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case 2:
                    zzlm.zzt(((Long) obj).longValue());
                    return;
                case 3:
                    zzlm.zzt(((Long) obj).longValue());
                    return;
                case 4:
                    zzlm.zzq(((Integer) obj).intValue());
                    return;
                case 5:
                    zzlm.zzu(((Long) obj).longValue());
                    return;
                case 6:
                    zzlm.zzs(((Integer) obj).intValue());
                    return;
                case 7:
                    zzlm.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                    return;
                case 8:
                    if (obj instanceof zzlh) {
                        zzlm.zzj((zzlh) obj);
                        return;
                    } else {
                        zzlm.zzx((String) obj);
                        return;
                    }
                case 9:
                    ((zznm) obj).zzcB(zzlm);
                    return;
                case 10:
                    zzlm.zzo((zznm) obj);
                    return;
                case 11:
                    if (obj instanceof zzlh) {
                        zzlm.zzj((zzlh) obj);
                        return;
                    }
                    byte[] bArr = (byte[]) obj;
                    zzlm.zzk(bArr, 0, bArr.length);
                    return;
                case 12:
                    zzlm.zzr(((Integer) obj).intValue());
                    return;
                case 13:
                    if (obj instanceof zzmj) {
                        zzlm.zzq(((zzmj) obj).zza());
                        return;
                    } else {
                        zzlm.zzq(((Integer) obj).intValue());
                        return;
                    }
                case 14:
                    zzlm.zzs(((Integer) obj).intValue());
                    return;
                case 15:
                    zzlm.zzu(((Long) obj).longValue());
                    return;
                case 16:
                    int intValue = ((Integer) obj).intValue();
                    zzlm.zzr((intValue >> 31) ^ (intValue + intValue));
                    return;
                case 17:
                    long longValue = ((Long) obj).longValue();
                    zzlm.zzt((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        } else {
            zznm zznm = (zznm) obj;
            zzmp.zzd(zznm);
            zzlm.zza(i, 3);
            zznm.zzcB(zzlm);
            zzlm.zza(i, 4);
        }
    }

    public static int zzh(zzot zzot, int i, Object obj) {
        int zzz = zzlm.zzz(i << 3);
        if (zzot == zzot.GROUP) {
            zzmp.zzd((zznm) obj);
            zzz += zzz;
        }
        return zzz + zzi(zzot, obj);
    }

    public static int zzi(zzot zzot, Object obj) {
        int zzc2;
        int zzz;
        zzot zzot2 = zzot.DOUBLE;
        zzou zzou = zzou.INT;
        switch (zzot.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzlm.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzlm.zzb;
                return 4;
            case 2:
                return zzlm.zzA(((Long) obj).longValue());
            case 3:
                return zzlm.zzA(((Long) obj).longValue());
            case 4:
                return zzlm.zzA((long) ((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzlm.zzb;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzlm.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzlm.zzb;
                return 1;
            case 8:
                if (obj instanceof zzlh) {
                    int i6 = zzlm.zzb;
                    zzc2 = ((zzlh) obj).zzc();
                    zzz = zzlm.zzz(zzc2);
                    break;
                } else {
                    return zzlm.zzB((String) obj);
                }
            case 9:
                return ((zznm) obj).zzcn();
            case 10:
                if (obj instanceof zzmv) {
                    int i7 = zzlm.zzb;
                    zzc2 = ((zzmv) obj).zzb();
                    zzz = zzlm.zzz(zzc2);
                    break;
                } else {
                    return zzlm.zzC((zznm) obj);
                }
            case 11:
                if (!(obj instanceof zzlh)) {
                    int i8 = zzlm.zzb;
                    zzc2 = ((byte[]) obj).length;
                    zzz = zzlm.zzz(zzc2);
                    break;
                } else {
                    int i9 = zzlm.zzb;
                    zzc2 = ((zzlh) obj).zzc();
                    zzz = zzlm.zzz(zzc2);
                    break;
                }
            case 12:
                return zzlm.zzz(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzmj) {
                    return zzlm.zzA((long) ((zzmj) obj).zza());
                }
                return zzlm.zzA((long) ((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i10 = zzlm.zzb;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i11 = zzlm.zzb;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzlm.zzz((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzlm.zzA((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzz + zzc2;
    }

    public static int zzj(zzlv zzlv, Object obj) {
        zzot zzb2 = zzlv.zzb();
        int zza2 = zzlv.zza();
        if (!zzlv.zzd()) {
            return zzh(zzb2, zza2, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzlv.zze()) {
            int i2 = 0;
            while (i < size) {
                i2 += zzh(zzb2, zza2, list.get(i));
                i++;
            }
            return i2;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            int i3 = 0;
            while (i < size) {
                i3 += zzi(zzb2, list.get(i));
                i++;
            }
            return zzlm.zzz(zza2 << 3) + i3 + zzlm.zzz(i3);
        }
    }

    private static boolean zzk(Map.Entry entry) {
        zzlv zzlv = (zzlv) entry.getKey();
        if (zzlv.zzc() != zzou.MESSAGE) {
            return true;
        }
        if (!zzlv.zzd()) {
            return zzl(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzl(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zznn) {
            return ((zznn) obj).zzcD();
        }
        if (obj instanceof zzmv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int zzz;
        int zzz2;
        zzlv zzlv = (zzlv) entry.getKey();
        Object value = entry.getValue();
        if (zzlv.zzc() != zzou.MESSAGE || zzlv.zzd() || zzlv.zze()) {
            return zzj(zzlv, value);
        }
        if (value instanceof zzmv) {
            int zza2 = ((zzlv) entry.getKey()).zza();
            int zzz3 = zzlm.zzz(8);
            i = zzz3 + zzz3;
            zzz = zzlm.zzz(16) + zzlm.zzz(zza2);
            int zzz4 = zzlm.zzz(24);
            int zzb2 = ((zzmv) value).zzb();
            zzz2 = zzz4 + zzlm.zzz(zzb2) + zzb2;
        } else {
            int zza3 = ((zzlv) entry.getKey()).zza();
            int zzz5 = zzlm.zzz(8);
            i = zzz5 + zzz5;
            zzz = zzlm.zzz(16) + zzlm.zzz(zza3);
            zzz2 = zzlm.zzz(24) + zzlm.zzC((zznm) value);
        }
        return i + zzz + zzz2;
    }

    private static final void zzn(zzlv zzlv, Object obj) {
        boolean z;
        zzot zzb2 = zzlv.zzb();
        byte[] bArr = zzmp.zzb;
        obj.getClass();
        zzot zzot = zzot.DOUBLE;
        zzou zzou = zzou.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzlh) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzmj)) {
                    return;
                }
            case 8:
                if ((obj instanceof zznm) || (obj instanceof zzmv)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzlv.zza()), zzlv.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzlw zzlw = new zzlw();
        zzoe zzoe = this.zza;
        int zzc2 = zzoe.zzc();
        for (int i = 0; i < zzc2; i++) {
            Map.Entry zzd2 = zzoe.zzd(i);
            zzlw.zzd((zzlv) ((zzob) zzd2).zza(), zzd2.getValue());
        }
        for (Map.Entry entry : zzoe.zze()) {
            zzlw.zzd((zzlv) entry.getKey(), entry.getValue());
        }
        zzlw.zzc = this.zzc;
        return zzlw;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlw)) {
            return false;
        }
        return this.zza.equals(((zzlw) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzb) {
            zzoe zzoe = this.zza;
            int zzc2 = zzoe.zzc();
            for (int i = 0; i < zzc2; i++) {
                Object value = zzoe.zzd(i).getValue();
                if (value instanceof zzmf) {
                    ((zzmf) value).zzcj();
                }
            }
            for (Map.Entry value2 : zzoe.zze()) {
                Object value3 = value2.getValue();
                if (value3 instanceof zzmf) {
                    ((zzmf) value3).zzcj();
                }
            }
            zzoe.zza();
            this.zzb = true;
        }
    }

    public final Iterator zzc() {
        zzoe zzoe = this.zza;
        if (zzoe.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzc) {
            return new zzmu(zzoe.entrySet().iterator());
        }
        return zzoe.entrySet().iterator();
    }

    public final void zzd(zzlv zzlv, Object obj) {
        if (!zzlv.zzd()) {
            zzn(zzlv, obj);
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzlv, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzmv) {
            this.zzc = true;
        }
        this.zza.put(zzlv, obj);
    }

    public final boolean zze() {
        zzoe zzoe = this.zza;
        int zzc2 = zzoe.zzc();
        for (int i = 0; i < zzc2; i++) {
            if (!zzk(zzoe.zzd(i))) {
                return false;
            }
        }
        for (Map.Entry zzk : zzoe.zze()) {
            if (!zzk(zzk)) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzoe zzoe = this.zza;
        int zzc2 = zzoe.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc2; i2++) {
            i += zzm(zzoe.zzd(i2));
        }
        for (Map.Entry zzm : zzoe.zze()) {
            i += zzm(zzm);
        }
        return i;
    }

    private zzlw(boolean z) {
        zzb();
        zzb();
    }
}
