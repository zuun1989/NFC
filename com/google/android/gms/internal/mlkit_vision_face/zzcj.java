package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class zzcj {
    public static int zza(Set set) {
        int i;
        int i2 = 0;
        for (Object next : set) {
            if (next != null) {
                i = next.hashCode();
            } else {
                i = 0;
            }
            i2 += i;
        }
        return i2;
    }

    public static boolean zzb(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzcb) {
            collection = ((zzcb) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzc(set, collection.iterator());
        }
        Iterator it = set.iterator();
        collection.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean zzc(Set set, Iterator it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }
}
