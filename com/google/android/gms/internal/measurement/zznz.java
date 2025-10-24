package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

final class zznz {
    public static final /* synthetic */ int zza = 0;
    private static final zzoi zzb = new zzok();

    static {
        int i = zznu.zza;
    }

    public static zzoi zzA() {
        return zzb;
    }

    public static boolean zzB(Object obj, Object obj2) {
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

    public static void zzC(zzls zzls, Object obj, Object obj2) {
        if (!((zzmc) obj2).zzb.zza.isEmpty()) {
            zzmc zzmc = (zzmc) obj;
            throw null;
        }
    }

    public static void zzD(zzoi zzoi, Object obj, Object obj2) {
        zzmf zzmf = (zzmf) obj;
        zzoj zzoj = zzmf.zzc;
        zzoj zzoj2 = ((zzmf) obj2).zzc;
        if (!zzoj.zza().equals(zzoj2)) {
            if (zzoj.zza().equals(zzoj)) {
                zzoj = zzoj.zzc(zzoj, zzoj2);
            } else {
                zzoj.zzl(zzoj2);
            }
        }
        zzmf.zzc = zzoj;
    }

    public static Object zzE(Object obj, int i, int i2, Object obj2, zzoi zzoi) {
        if (obj2 == null) {
            obj2 = zzoi.zza(obj);
        }
        ((zzoj) obj2).zzk(i << 3, Long.valueOf((long) i2));
        return obj2;
    }

    public static void zza(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzC(i, list, z);
        }
    }

    public static void zzb(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzB(i, list, z);
        }
    }

    public static void zzc(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzy(i, list, z);
        }
    }

    public static void zzd(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzz(i, list, z);
        }
    }

    public static void zze(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzL(i, list, z);
        }
    }

    public static void zzf(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzA(i, list, z);
        }
    }

    public static void zzg(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzJ(i, list, z);
        }
    }

    public static void zzh(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzw(i, list, z);
        }
    }

    public static void zzi(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzH(i, list, z);
        }
    }

    public static void zzj(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzK(i, list, z);
        }
    }

    public static void zzk(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzx(i, list, z);
        }
    }

    public static void zzl(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzI(i, list, z);
        }
    }

    public static void zzm(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzD(i, list, z);
        }
    }

    public static void zzn(int i, List list, zzov zzov, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzov.zzE(i, list, z);
        }
    }

    public static int zzo(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzna) {
            zzna zzna = (zzna) list;
            i = 0;
            while (i2 < size) {
                i += zzlm.zzA(zzna.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzlm.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzp(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzna) {
            zzna zzna = (zzna) list;
            i = 0;
            while (i2 < size) {
                i += zzlm.zzA(zzna.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzlm.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzq(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzna) {
            zzna zzna = (zzna) list;
            i = 0;
            while (i2 < size) {
                long zzc = zzna.zzc(i2);
                i += zzlm.zzA((zzc >> 63) ^ (zzc + zzc));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzlm.zzA((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzr(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            i = 0;
            while (i2 < size) {
                i += zzlm.zzA((long) zzmg.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzlm.zzA((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzs(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            i = 0;
            while (i2 < size) {
                i += zzlm.zzA((long) zzmg.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzlm.zzA((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzt(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            i = 0;
            while (i2 < size) {
                i += zzlm.zzz(zzmg.zzf(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzlm.zzz(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzu(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            i = 0;
            while (i2 < size) {
                int zzf = zzmg.zzf(i2);
                i += zzlm.zzz((zzf >> 31) ^ (zzf + zzf));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzlm.zzz((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    public static int zzv(List list) {
        return list.size() * 4;
    }

    public static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlm.zzz(i << 3) + 4);
    }

    public static int zzx(List list) {
        return list.size() * 8;
    }

    public static int zzy(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlm.zzz(i << 3) + 8);
    }

    public static int zzz(int i, Object obj, zznx zznx) {
        int i2 = i << 3;
        if (!(obj instanceof zzmw)) {
            return zzlm.zzz(i2) + zzlm.zzD((zznm) obj, zznx);
        }
        int zzz = zzlm.zzz(i2);
        int zzb2 = ((zzmw) obj).zzb();
        return zzz + zzlm.zzz(zzb2) + zzb2;
    }
}
