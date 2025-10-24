package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzane  reason: invalid package */
final class zzane {
    private static final zzanv<?, ?> zza = new zzanx();

    public static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzako.zza(i, true);
    }

    public static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzako.zzg(i));
    }

    public static int zzc(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzako.zzb(i, 0);
    }

    public static int zzd(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzako.zza(i, 0);
    }

    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzako.zzg(i));
    }

    public static int zzf(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzako.zzg(i));
    }

    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzako.zzg(i));
    }

    public static int zzh(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzako.zzg(i));
    }

    public static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzako.zzg(i));
    }

    public static int zzj(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzako.zzg(i));
    }

    public static void zzk(int i, List<Integer> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzk(i, list, z);
        }
    }

    public static void zzl(int i, List<Long> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzl(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzm(i, list, z);
        }
    }

    public static void zzn(int i, List<Long> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzn(i, list, z);
        }
    }

    public static int zza(List<?> list) {
        return list.size();
    }

    public static int zzc(List<?> list) {
        return list.size() << 2;
    }

    public static int zzd(List<?> list) {
        return list.size() << 3;
    }

    public static int zza(int i, List<zzajw> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzg = size * zzako.zzg(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzg += zzako.zza(list.get(i2));
        }
        return zzg;
    }

    public static int zzb(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            i = 0;
            while (i2 < size) {
                i += zzako.zza(zzalj.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzako.zza(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzc(int i, List<Integer> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Integer> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzd(i, list, z);
        }
    }

    public static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            i = 0;
            while (i2 < size) {
                i += zzako.zzc(zzalj.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzako.zzc(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            i = 0;
            while (i2 < size) {
                i += zzako.zzb(zzaly.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzako.zzb(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            i = 0;
            while (i2 < size) {
                i += zzako.zzf(zzalj.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzako.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzh(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            i = 0;
            while (i2 < size) {
                i += zzako.zzd(zzaly.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzako.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzi(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            i = 0;
            while (i2 < size) {
                i += zzako.zzh(zzalj.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzako.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzj(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            i = 0;
            while (i2 < size) {
                i += zzako.zze(zzaly.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzako.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zza(int i, List<zzamn> list, zzanc<?> zzanc) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzako.zza(i, list.get(i3), zzanc);
        }
        return i2;
    }

    public static int zzb(int i, List<?> list, zzanc<?> zzanc) {
        int zza2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzg = zzako.zzg(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzalv) {
                zza2 = zzako.zza((zzalv) obj);
            } else {
                zza2 = zzako.zza((zzamn) obj, (zzanc) zzanc);
            }
            zzg += zza2;
        }
        return zzg;
    }

    public static void zze(int i, List<Long> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zze(i, list, z);
        }
    }

    public static void zzf(int i, List<Float> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzf(i, list, z);
        }
    }

    public static void zzg(int i, List<Integer> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzg(i, list, z);
        }
    }

    public static void zzh(int i, List<Long> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzh(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzi(i, list, z);
        }
    }

    public static void zzj(int i, List<Long> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzj(i, list, z);
        }
    }

    public static int zza(int i, Object obj, zzanc<?> zzanc) {
        if (obj instanceof zzalv) {
            return zzako.zzb(i, (zzalv) obj);
        }
        return zzako.zzb(i, (zzamn) obj, (zzanc) zzanc);
    }

    public static zzanv<?, ?> zza() {
        return zza;
    }

    public static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzalk zzalk, UB ub, zzanv<UT, UB> zzanv) {
        if (zzalk == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = list.get(i3);
                int intValue = num.intValue();
                if (zzalk.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    ub = zza(obj, i, intValue, ub, zzanv);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzalk.zza(intValue2)) {
                    ub = zza(obj, i, intValue2, ub, zzanv);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static int zzb(int i, List<?> list) {
        int zza2;
        int zza3;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzg = zzako.zzg(i) * size;
        if (list instanceof zzalu) {
            zzalu zzalu = (zzalu) list;
            while (i2 < size) {
                Object zza4 = zzalu.zza(i2);
                if (zza4 instanceof zzajw) {
                    zza3 = zzako.zza((zzajw) zza4);
                } else {
                    zza3 = zzako.zza((String) zza4);
                }
                zzg += zza3;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzajw) {
                    zza2 = zzako.zza((zzajw) obj);
                } else {
                    zza2 = zzako.zza((String) obj);
                }
                zzg += zza2;
                i2++;
            }
        }
        return zzg;
    }

    public static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzanv<UT, UB> zzanv) {
        if (ub == null) {
            ub = zzanv.zzc(obj);
        }
        zzanv.zzb(ub, i, (long) i2);
        return ub;
    }

    public static void zzb(int i, List<Double> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzb(i, list, z);
        }
    }

    public static <T, FT extends zzala<FT>> void zza(zzakx<FT> zzakx, T t, T t2) {
        zzaky<FT> zza2 = zzakx.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzakx.zzb(t).zza(zza2);
        }
    }

    public static void zzb(int i, List<?> list, zzaom zzaom, zzanc<?> zzanc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzb(i, list, (zzanc) zzanc);
        }
    }

    public static void zzb(int i, List<String> list, zzaom zzaom) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zzb(i, list);
        }
    }

    public static <T> void zza(zzamg zzamg, T t, T t2, long j) {
        zzaoa.zza((Object) t, j, zzamg.zza(zzaoa.zze(t, j), zzaoa.zze(t2, j)));
    }

    public static <T, UT, UB> void zza(zzanv<UT, UB> zzanv, T t, T t2) {
        zzanv.zzc(t, zzanv.zza(zzanv.zzd(t), zzanv.zzd(t2)));
    }

    public static void zza(Class<?> cls) {
        zzalg.class.isAssignableFrom(cls);
    }

    public static void zza(int i, List<Boolean> list, zzaom zzaom, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zza(i, list, z);
        }
    }

    public static void zza(int i, List<zzajw> list, zzaom zzaom) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zza(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzaom zzaom, zzanc<?> zzanc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaom.zza(i, list, (zzanc) zzanc);
        }
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
