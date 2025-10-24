package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import j6.q0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabb  reason: invalid package */
final class zzabb implements zzafw<zzail> {
    private final /* synthetic */ zzaim zza;
    private final /* synthetic */ zzahl zzb;
    private final /* synthetic */ zzaem zzc;
    private final /* synthetic */ zzahw zzd;
    private final /* synthetic */ zzaft zze;
    private final /* synthetic */ zzaas zzf;

    public zzabb(zzaas zzaas, zzaim zzaim, zzahl zzahl, zzaem zzaem, zzahw zzahw, zzaft zzaft) {
        this.zza = zzaim;
        this.zzb = zzahl;
        this.zzc = zzaem;
        this.zzd = zzahw;
        this.zze = zzaft;
        Objects.requireNonNull(zzaas);
        this.zzf = zzaas;
    }

    public final void zza(String str) {
        this.zze.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzail zzail = (zzail) obj;
        if (this.zza.zzi("EMAIL")) {
            this.zzb.zzb((String) null);
        } else if (this.zza.zzc() != null) {
            this.zzb.zzb(this.zza.zzc());
        }
        if (this.zza.zzi("DISPLAY_NAME")) {
            this.zzb.zza((String) null);
        } else if (this.zza.zzb() != null) {
            this.zzb.zza(this.zza.zzb());
        }
        if (this.zza.zzi("PHOTO_URL")) {
            this.zzb.zzc((String) null);
        } else if (this.zza.zze() != null) {
            this.zzb.zzc(this.zza.zze());
        }
        if (!TextUtils.isEmpty(this.zza.zzd())) {
            Preconditions.checkNotEmpty(Base64Utils.encode("redacted".getBytes()));
        }
        if (this.zza.zzi("delete_passkey")) {
            this.zzb.zza((zzah<q0>) zzah.zzg());
        }
        List zze2 = zzail.zze();
        if (zze2 == null) {
            zze2 = new ArrayList();
        }
        this.zzb.zza((List<zzaic>) zze2);
        zzaem zzaem = this.zzc;
        zzahw zzahw = this.zzd;
        Preconditions.checkNotNull(zzahw);
        Preconditions.checkNotNull(zzail);
        String zzc2 = zzail.zzc();
        String zzd2 = zzail.zzd();
        if (!TextUtils.isEmpty(zzc2) && !TextUtils.isEmpty(zzd2)) {
            zzahw = new zzahw(zzd2, zzc2, Long.valueOf(zzail.zza()), zzahw.zze());
        }
        zzaem.zza(zzahw, this.zzb);
    }
}
