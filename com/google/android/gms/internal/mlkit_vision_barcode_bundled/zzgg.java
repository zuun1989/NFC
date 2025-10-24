package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.List;

final class zzgg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgs zzb = new zzgu();

    static {
        int i = zzfu.zza;
    }

    public static void zzA(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzC(i, list, z);
        }
    }

    public static void zzB(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzE(i, list, z);
        }
    }

    public static void zzC(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzJ(i, list, z);
        }
    }

    public static void zzD(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzL(i, list, z);
        }
    }

    public static boolean zzE(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB((long) zzei.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdn.zzB((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdn.zzA(i << 3) + 4);
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdn.zzA(i << 3) + 8);
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB((long) zzei.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdn.zzB((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfb) {
            zzfb zzfb = (zzfb) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(zzfb.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdn.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzh(int i, Object obj, zzge zzge) {
        int i2 = i << 3;
        if (!(obj instanceof zzex)) {
            return zzdn.zzA(i2) + zzdn.zzy((zzfm) obj, zzge);
        }
        int zzA = zzdn.zzA(i2);
        int zza2 = ((zzex) obj).zza();
        return zzA + zzdn.zzA(zza2) + zza2;
    }

    public static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            i = 0;
            while (i2 < size) {
                int zze = zzei.zze(i2);
                i += zzdn.zzA((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzdn.zzA((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfb) {
            zzfb zzfb = (zzfb) list;
            i = 0;
            while (i2 < size) {
                long zze = zzfb.zze(i2);
                i += zzdn.zzB((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzdn.zzB((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzA(zzei.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdn.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfb) {
            zzfb zzfb = (zzfb) list;
            i = 0;
            while (i2 < size) {
                i += zzdn.zzB(zzfb.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzdn.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzgs zzm() {
        return zzb;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object zzn(java.lang.Object r2, int r3, int r4, java.lang.Object r5, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgs r6) {
        /*
            if (r5 != 0) goto L_0x0012
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh r2 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh) r2
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r5 = r2.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r6 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt.zzc()
            if (r5 != r6) goto L_0x0012
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r5 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt.zzf()
            r2.zzc = r5
        L_0x0012:
            long r0 = (long) r4
            int r2 = r3 << 3
            r3 = r5
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r3 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt) r3
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            r3.zzj(r2, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgg.zzn(java.lang.Object, int, int, java.lang.Object, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgs):java.lang.Object");
    }

    public static void zzo(zzdt zzdt, Object obj, Object obj2) {
        zzdx zzdx = ((zzed) obj2).zzb;
        if (!zzdx.zza.isEmpty()) {
            ((zzed) obj).zzc().zzh(zzdx);
        }
    }

    public static void zzp(zzgs zzgs, Object obj, Object obj2) {
        zzeh zzeh = (zzeh) obj;
        zzgt zzgt = zzeh.zzc;
        zzgt zzgt2 = ((zzeh) obj2).zzc;
        if (!zzgt.zzc().equals(zzgt2)) {
            if (zzgt.zzc().equals(zzgt)) {
                zzgt = zzgt.zze(zzgt, zzgt2);
            } else {
                zzgt.zzd(zzgt2);
            }
        }
        zzeh.zzc = zzgt;
    }

    public static void zzq(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzc(i, list, z);
        }
    }

    public static void zzr(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzg(i, list, z);
        }
    }

    public static void zzs(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzj(i, list, z);
        }
    }

    public static void zzt(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzl(i, list, z);
        }
    }

    public static void zzu(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzn(i, list, z);
        }
    }

    public static void zzv(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzp(i, list, z);
        }
    }

    public static void zzw(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzs(i, list, z);
        }
    }

    public static void zzx(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzu(i, list, z);
        }
    }

    public static void zzy(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzy(i, list, z);
        }
    }

    public static void zzz(int i, List list, zzhh zzhh, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhh.zzA(i, list, z);
        }
    }
}
