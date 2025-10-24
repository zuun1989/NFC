package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzag  reason: invalid package */
public abstract class zzag<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zza = new Object[0];

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    public final Object[] toArray() {
        return toArray(zza);
    }

    public int zza(Object[] objArr, int i) {
        zzay zzay = (zzay) iterator();
        while (zzay.hasNext()) {
            objArr[i] = zzay.next();
            i++;
        }
        return i;
    }

    public int zzb() {
        throw new UnsupportedOperationException();
    }

    public zzah<E> zzc() {
        if (isEmpty()) {
            return zzah.zzg();
        }
        return zzah.zza(toArray());
    }

    /* renamed from: zzd */
    public abstract zzay<E> iterator();

    public Object[] zze() {
        return null;
    }

    public final <T> T[] toArray(T[] tArr) {
        zzu.zza(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zze = zze();
            if (zze != null) {
                return Arrays.copyOfRange(zze, zzb(), zza(), tArr.getClass());
            }
            if (tArr.length != 0) {
                tArr = Arrays.copyOf(tArr, 0);
            }
            tArr = Arrays.copyOf(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    public int zza() {
        throw new UnsupportedOperationException();
    }
}
