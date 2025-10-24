package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzah  reason: invalid package */
public abstract class zzah<E> extends zzag<E> implements List<E>, RandomAccess {
    private static final zzax<Object> zza = new zzaj(zzap.zza, 0);

    public static <E> zzah<E> zzb(Object[] objArr, int i) {
        if (i == 0) {
            return zzap.zza;
        }
        return new zzap(objArr, i);
    }

    public static <E> zzak<E> zzf() {
        return new zzak<>();
    }

    public static <E> zzah<E> zzg() {
        return zzap.zza;
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == zzu.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (Objects.equals(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object obj2 = get(i2);
                        i2++;
                        if (!Objects.equals(obj2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzax) listIterator(0);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Deprecated
    public final zzah<E> zzc() {
        return this;
    }

    public final zzay<E> zzd() {
        return (zzax) listIterator();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzu.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzaj(this, i);
    }

    public static <E> zzah<E> zza(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    public static <E> zzah<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        Object[] objArr = {e, e2, e3, e4, e5, e6, e7, e8};
        int i = 0;
        while (i < 8) {
            if (objArr[i] != null) {
                i++;
            } else {
                throw new NullPointerException("at index " + i);
            }
        }
        return zzb(objArr, 8);
    }

    /* renamed from: zza */
    public zzah<E> subList(int i, int i2) {
        zzu.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzap.zza;
        }
        return new zzam(this, i, i3);
    }
}
