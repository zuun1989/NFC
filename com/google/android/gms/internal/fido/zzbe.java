package com.google.android.gms.internal.fido;

import java.util.AbstractMap;

final class zzbe extends zzaz {
    final /* synthetic */ zzbf zza;

    public zzbe(zzbf zzbf) {
        this.zza = zzbf;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return new AbstractMap.SimpleImmutableEntry(this.zza.zza.zze.zzd.get(i), this.zza.zza.zzf.get(i));
    }

    public final int size() {
        return this.zza.zza.size();
    }
}
