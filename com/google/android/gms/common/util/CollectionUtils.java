package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w0.a;
import w0.b;

@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3) {
        Map zza = zza(3, false);
        zza.put(k, v);
        zza.put(k2, v2);
        zza.put(k3, v3);
        return Collections.unmodifiableMap(zza);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        } else if (length == 0) {
            return Collections.emptyMap();
        } else {
            if (length == 1) {
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            Map zza = zza(length, false);
            for (int i = 0; i < kArr.length; i++) {
                zza.put(kArr[i], vArr[i]);
            }
            return Collections.unmodifiableMap(zza);
        }
    }

    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i) {
        if (i == 0) {
            return new b();
        }
        return zzb(i, true);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T t, T t2, T t3) {
        Set zzb = zzb(3, false);
        zzb.add(t);
        zzb.add(t2);
        zzb.add(t3);
        return Collections.unmodifiableSet(zzb);
    }

    private static Map zza(int i, boolean z) {
        if (i <= 256) {
            return new a(i);
        }
        return new HashMap(i, 1.0f);
    }

    private static Set zzb(int i, boolean z) {
        int i2;
        float f;
        if (true != z) {
            i2 = 256;
        } else {
            i2 = 128;
        }
        if (i <= i2) {
            return new b(i);
        }
        if (true != z) {
            f = 1.0f;
        } else {
            f = 0.75f;
        }
        return new HashSet(i, f);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T t) {
        return Collections.singletonList(t);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v5, K k5, V v6, K k6, V v7) {
        Map zza = zza(6, false);
        zza.put(k, v);
        zza.put(k2, v2);
        zza.put(k3, v3);
        zza.put(k4, v5);
        zza.put(k5, v6);
        zza.put(k6, v7);
        return Collections.unmodifiableMap(zza);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            Set zzb = zzb(2, false);
            zzb.add(t);
            zzb.add(t2);
            return Collections.unmodifiableSet(zzb);
        } else if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        } else {
            if (length != 4) {
                Set zzb2 = zzb(length, false);
                Collections.addAll(zzb2, tArr);
                return Collections.unmodifiableSet(zzb2);
            }
            T t3 = tArr[0];
            T t5 = tArr[1];
            T t6 = tArr[2];
            T t7 = tArr[3];
            Set zzb3 = zzb(4, false);
            zzb3.add(t3);
            zzb3.add(t5);
            zzb3.add(t6);
            zzb3.add(t7);
            return Collections.unmodifiableSet(zzb3);
        }
    }
}
