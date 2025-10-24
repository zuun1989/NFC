package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzai  reason: invalid package */
public class zzai<E> {
    public static int zza(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        } else if (i2 <= i) {
            return i;
        } else {
            int i3 = i + (i >> 1) + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            return i3;
        }
    }
}
