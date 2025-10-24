package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import j6.d0;
import j6.j;
import j6.z0;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaas  reason: invalid package */
public final class zzaas {
    /* access modifiers changed from: private */
    public final zzafu zza;

    public zzaas(zzafu zzafu) {
        this.zza = (zzafu) Preconditions.checkNotNull(zzafu);
    }

    public final void zzb(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzack(this, str2, zzaem));
    }

    public final void zzc(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzacn(this, str2, zzaem));
    }

    public final void zzd(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(new zzaid(str, (String) null, str2), (zzafw<zzaig>) new zzabf(this, zzaem));
    }

    public final void zze(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(new zzagt(str, str2), (zzafw<zzagw>) new zzabd(this, zzaem));
    }

    public final void zzf(String str, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzabo(this, zzaem));
    }

    public static /* synthetic */ void zza(zzaas zzaas, zzaje zzaje, zzaem zzaem, zzaft zzaft) {
        Status status;
        if (zzaje.zzo()) {
            z0 zzb = zzaje.zzb();
            String zzc = zzaje.zzc();
            String zzj = zzaje.zzj();
            if (zzaje.zzm()) {
                status = new Status(17012);
            } else {
                status = r.a(zzaje.zzd());
            }
            zzaem.zza(new zzaaq(status, zzb, zzc, zzj));
            return;
        }
        zzaas.zza(new zzahw(zzaje.zzi(), zzaje.zze(), Long.valueOf(zzaje.zza()), "Bearer"), zzaje.zzh(), zzaje.zzg(), Boolean.valueOf(zzaje.zzn()), zzaje.zzb(), zzaem, zzaft);
    }

    public final void zzf(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        zza(str2, (zzafw<zzahw>) new zzabr(this, str, zzaem));
    }

    private final void zzd(zzahn zzahn, zzaem zzaem) {
        Preconditions.checkNotNull(zzahn);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzahn, (zzafw<zzahq>) new zzacg(this, zzaem));
    }

    public final void zzb(String str, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(new zzahk(str), (zzafw<zzahw>) new zzaav(this, zzaem));
    }

    public final void zzc(String str, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzacd(this, zzaem));
    }

    public final void zze(String str, zzaem zzaem) {
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(new zzain(str), (zzafw<zzaiq>) new zzacj(this, zzaem));
    }

    public final void zzc(zzahn zzahn, zzaem zzaem) {
        zzd(zzahn, zzaem);
    }

    public final void zzd(String str, zzaem zzaem) {
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(str, (zzafw<Void>) new zzach(this, zzaem));
    }

    public final void zzb(zzahn zzahn, zzaem zzaem) {
        Preconditions.checkNotEmpty(zzahn.zzc());
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzahn, (zzafw<zzahq>) new zzabc(this, zzaem));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(new zzajf(str, str2, str3, str4), (zzafw<zzaji>) new zzaax(this, zzaem));
    }

    public static /* synthetic */ void zza(zzaas zzaas, zzaem zzaem, zzain zzain, zzaft zzaft) {
        Preconditions.checkNotNull(zzaem);
        Preconditions.checkNotNull(zzain);
        Preconditions.checkNotNull(zzaft);
        zzaas.zza.zza(zzain, (zzafw<zzaiq>) new zzabl(zzaas, zzaem, zzaft));
    }

    public static /* synthetic */ void zza(zzaas zzaas, zzaem zzaem, zzahw zzahw, zzaim zzaim, zzaft zzaft) {
        Preconditions.checkNotNull(zzaem);
        Preconditions.checkNotNull(zzahw);
        Preconditions.checkNotNull(zzaim);
        Preconditions.checkNotNull(zzaft);
        zzaas.zza.zza(new zzahj(zzahw.zzc()), (zzafw<zzahm>) new zzaay(zzaas, zzaft, zzaem, zzahw, zzaim));
    }

    public static /* synthetic */ void zza(zzaas zzaas, zzaem zzaem, zzahw zzahw, zzahl zzahl, zzaim zzaim, zzaft zzaft) {
        Preconditions.checkNotNull(zzaem);
        Preconditions.checkNotNull(zzahw);
        Preconditions.checkNotNull(zzahl);
        Preconditions.checkNotNull(zzaim);
        Preconditions.checkNotNull(zzaft);
        zzaas.zza.zza(zzaim, (zzafw<zzail>) new zzabb(zzaas, zzaim, zzahl, zzaem, zzahw, zzaft));
    }

    public final void zza(String str, String str2, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        zzaim zzaim = new zzaim();
        zzaim.zze(str);
        zzaim.zzh(str2);
        this.zza.zza(zzaim, (zzafw<zzail>) new zzacm(this, zzaem));
    }

    public final void zza(zzaid zzaid, zzaem zzaem) {
        Preconditions.checkNotEmpty(zzaid.zzb());
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzaid, (zzafw<zzaig>) new zzabh(this, zzaem));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(new zzain(str, str2, (String) null, str3, str4, (String) null), (zzafw<zzaiq>) new zzaau(this, zzaem));
    }

    public final void zza(String str, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzacf(this, zzaem));
    }

    private final void zza(String str, zzafw<zzahw> zzafw) {
        Preconditions.checkNotNull(zzafw);
        Preconditions.checkNotEmpty(str);
        zzahw zzb = zzahw.zzb(str);
        if (zzb.zzg()) {
            zzafw.zza(zzb);
            return;
        }
        this.zza.zza(new zzahk(zzb.zzd()), (zzafw<zzahw>) new zzacp(this, zzafw));
    }

    public final void zza(zzaha zzaha, String str, zzaem zzaem) {
        Preconditions.checkNotNull(zzaha);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzabx(this, zzaha, zzaem));
    }

    public final void zza(zzahc zzahc, zzaem zzaem) {
        Preconditions.checkNotNull(zzahc);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzahc, (zzafw<zzahb>) new zzabz(this, zzaem));
    }

    /* access modifiers changed from: private */
    public final void zza(zzagy zzagy, zzaem zzaem) {
        Preconditions.checkNotNull(zzagy);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzagy, (zzafw<zzagx>) new zzaaz(this, zzaem));
    }

    /* access modifiers changed from: private */
    public final void zza(zzahw zzahw, String str, String str2, Boolean bool, z0 z0Var, zzaem zzaem, zzaft zzaft) {
        Preconditions.checkNotNull(zzahw);
        Preconditions.checkNotNull(zzaft);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(new zzahj(zzahw.zzc()), (zzafw<zzahm>) new zzaba(this, zzaft, str2, str, bool, z0Var, zzaem, zzahw));
    }

    public final void zza(zzahp zzahp, zzaem zzaem) {
        Preconditions.checkNotNull(zzahp);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzahp, (zzafw<zzahs>) new zzaca(this, zzaem));
    }

    public final void zza(zzahu zzahu, zzaem zzaem) {
        Preconditions.checkNotNull(zzahu);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzahu, (zzafw<zzaht>) new zzacb(this, zzaem));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaem);
        zza(str3, (zzafw<zzahw>) new zzabi(this, str, str2, str4, str5, zzaem));
    }

    public final void zza(String str, zzajc zzajc, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzajc);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzabm(this, zzajc, zzaem));
    }

    public final void zza(String str, zzajh zzajh, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzajh);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzabk(this, zzajh, zzaem));
    }

    public final void zza(zzaif zzaif, zzaem zzaem) {
        this.zza.zza(zzaif, (zzafw<zzaih>) new zzaci(this, zzaem));
    }

    public final void zza(zzahn zzahn, zzaem zzaem) {
        Preconditions.checkNotEmpty(zzahn.zzd());
        Preconditions.checkNotNull(zzaem);
        zzd(zzahn, zzaem);
    }

    public final void zza(zzaik zzaik, zzaem zzaem) {
        Preconditions.checkNotEmpty(zzaik.zzd());
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzaik, (zzafw<zzaij>) new zzabg(this, zzaem));
    }

    public final void zza(zzajc zzajc, zzaem zzaem) {
        Preconditions.checkNotNull(zzajc);
        Preconditions.checkNotNull(zzaem);
        zzajc.zzb(true);
        this.zza.zza(zzajc, (zzafw<zzaje>) new zzabv(this, zzaem));
    }

    public final void zza(zzajd zzajd, zzaem zzaem) {
        Preconditions.checkNotNull(zzajd);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzajd, (zzafw<zzajg>) new zzabe(this, zzaem));
    }

    public final void zza(j jVar, String str, zzaem zzaem) {
        Preconditions.checkNotNull(jVar);
        Preconditions.checkNotNull(zzaem);
        if (jVar.zzg()) {
            zza(jVar.zzb(), (zzafw<zzahw>) new zzaaw(this, jVar, str, zzaem));
        } else {
            zza(new zzagy(jVar, (String) null, str), zzaem);
        }
    }

    public final void zza(zzajh zzajh, zzaem zzaem) {
        Preconditions.checkNotNull(zzajh);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzajh, (zzafw<zzajk>) new zzabj(this, zzaem));
    }

    public final void zza(zzaip zzaip, zzaem zzaem) {
        Preconditions.checkNotNull(zzaip);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzaip, (zzafw<zzais>) new zzabu(this, zzaip, zzaem));
    }

    public final void zza(zzair zzair, zzaem zzaem) {
        Preconditions.checkNotNull(zzair);
        Preconditions.checkNotNull(zzaem);
        this.zza.zza(zzair, (zzafw<zzaiu>) new zzaby(this, zzaem));
    }

    public final void zza(String str, String str2, String str3, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzabt(this, str2, str3, zzaem));
    }

    public final void zza(String str, d0 d0Var, zzaem zzaem) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(d0Var);
        Preconditions.checkNotNull(zzaem);
        zza(str, (zzafw<zzahw>) new zzacl(this, d0Var, zzaem));
    }
}
