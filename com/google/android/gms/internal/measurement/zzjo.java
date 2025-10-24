package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;

final class zzjo extends ContentObserver {
    final /* synthetic */ zzjr zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjo(zzjr zzjr, Handler handler) {
        super((Handler) null);
        Objects.requireNonNull(zzjr);
        this.zza = zzjr;
    }

    public final void onChange(boolean z) {
        this.zza.zzc();
    }
}
