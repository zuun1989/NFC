package com.google.android.gms.internal.p002firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import j6.q0;
import j6.z0;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahl  reason: invalid package */
public final class zzahl {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzaib zzf;
    private String zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private z0 zzk;
    private List<zzahz> zzl;
    private zzah<q0> zzm;

    public zzahl() {
        this.zzf = new zzaib();
        this.zzm = zzah.zzg();
    }

    public final long zza() {
        return this.zzh;
    }

    public final long zzb() {
        return this.zzi;
    }

    public final Uri zzc() {
        if (!TextUtils.isEmpty(this.zze)) {
            return Uri.parse(this.zze);
        }
        return null;
    }

    public final zzah<q0> zzd() {
        return this.zzm;
    }

    public final z0 zze() {
        return this.zzk;
    }

    public final zzaib zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return this.zza;
    }

    public final String zzj() {
        return this.zzg;
    }

    public final List<zzahz> zzk() {
        return this.zzl;
    }

    public final List<zzaic> zzl() {
        return this.zzf.zza();
    }

    public final boolean zzm() {
        return this.zzc;
    }

    public final boolean zzn() {
        return this.zzj;
    }

    public final zzahl zza(z0 z0Var) {
        this.zzk = z0Var;
        return this;
    }

    public final zzahl zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzahl zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzahl zzc(String str) {
        this.zze = str;
        return this;
    }

    public zzahl(String str, String str2, boolean z, String str3, String str4, zzaib zzaib, String str5, String str6, long j, long j2, boolean z2, z0 z0Var, List<zzahz> list, zzah<q0> zzah) {
        zzaib zzaib2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = str4;
        if (zzaib == null) {
            zzaib2 = new zzaib();
        } else {
            List<zzaic> zza2 = zzaib.zza();
            zzaib zzaib3 = new zzaib();
            if (zza2 != null) {
                zzaib3.zza().addAll(zza2);
            }
            zzaib2 = zzaib3;
        }
        this.zzf = zzaib2;
        this.zzg = str6;
        this.zzh = j;
        this.zzi = j2;
        this.zzj = false;
        this.zzk = null;
        this.zzl = list == null ? new ArrayList<>() : list;
        this.zzm = zzah;
    }

    public final zzahl zza(boolean z) {
        this.zzj = z;
        return this;
    }

    public final zzahl zza(zzah<q0> zzah) {
        Preconditions.checkNotNull(zzah);
        this.zzm = zzah;
        return this;
    }

    public final zzahl zza(List<zzaic> list) {
        Preconditions.checkNotNull(list);
        zzaib zzaib = new zzaib();
        this.zzf = zzaib;
        zzaib.zza().addAll(list);
        return this;
    }
}
