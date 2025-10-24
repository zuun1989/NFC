package com.google.android.gms.internal.measurement;

import G5.g;
import android.net.Uri;

public final class zzkg {
    final Uri zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final boolean zze;

    private zzkg(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z5, g gVar) {
        this.zza = uri;
        this.zzb = "";
        this.zzc = "";
        this.zzd = z;
        this.zze = z3;
    }

    public final zzkg zza() {
        String str = this.zzb;
        if (str.isEmpty()) {
            return new zzkg((String) null, this.zza, str, this.zzc, true, false, this.zze, false, (g) null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzkg zzb() {
        return new zzkg((String) null, this.zza, this.zzb, this.zzc, this.zzd, false, true, false, (g) null);
    }

    public final zzkm zzc(String str, long j) {
        Long valueOf = Long.valueOf(j);
        int i = zzkm.zzc;
        return new zzkc(this, str, valueOf, true);
    }

    public final zzkm zzd(String str, boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        int i = zzkm.zzc;
        return new zzkd(this, str, valueOf, true);
    }

    public final zzkm zze(String str, double d) {
        Double valueOf = Double.valueOf(-3.0d);
        int i = zzkm.zzc;
        return new zzke(this, "measurement.test.double_flag", valueOf, true);
    }

    public final zzkm zzf(String str, String str2) {
        int i = zzkm.zzc;
        return new zzkf(this, str, str2, true);
    }

    public zzkg(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (g) null);
    }
}
