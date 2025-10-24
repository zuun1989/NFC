package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzck {
    public static int zza(Object obj) {
        int i;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)) * 461845907);
    }
}
