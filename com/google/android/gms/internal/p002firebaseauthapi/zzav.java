package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzav  reason: invalid package */
public final class zzav {
    public static int zza(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static boolean zza(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }
}
