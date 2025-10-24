package com.google.android.gms.internal.mlkit_common;

import java.util.Set;

public final class zzar {
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
}
