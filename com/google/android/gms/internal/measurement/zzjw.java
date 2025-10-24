package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;

final class zzjw extends ContentObserver {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjw(zzjy zzjy, Handler handler) {
        super((Handler) null);
        Objects.requireNonNull(zzjy);
    }

    public final void onChange(boolean z) {
        zzkm.zzc();
    }
}
