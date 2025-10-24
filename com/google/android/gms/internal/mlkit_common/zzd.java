package com.google.android.gms.internal.mlkit_common;

import I0.f;
import android.content.Context;

final class zzd extends zzk {
    public final int zza(Context context, zzj zzj, boolean z) {
        if (zzj.zza.getAuthority().lastIndexOf(64) < 0 || f.c(context, "android.permission.INTERACT_ACROSS_USERS") != 0) {
            return 3;
        }
        return 2;
    }
}
