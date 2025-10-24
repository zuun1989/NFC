package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzby {
    public static int zza(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static void zzb(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        } else if (obj2 == null) {
            String obj3 = obj.toString();
            throw new NullPointerException("null value in entry: " + obj3 + "=null");
        }
    }
}
