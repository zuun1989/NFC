package com.google.android.gms.internal.measurement;

import java.util.Objects;

final class zzdu extends zzcw {
    final /* synthetic */ Runnable zza;

    public zzdu(zzdv zzdv, Runnable runnable) {
        this.zza = runnable;
        Objects.requireNonNull(zzdv);
    }

    public final void zze() {
        this.zza.run();
    }
}
