package com.google.android.gms.internal.mlkit_common;

import I0.b;
import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzc implements Callable {
    public final /* synthetic */ Context zza;

    public /* synthetic */ zzc(Context context) {
        this.zza = context;
    }

    public final Object call() {
        int i = zzi.zza;
        return b.getExternalCacheDirs(this.zza);
    }
}
