package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import j6.z0;
import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaba  reason: invalid package */
final class zzaba implements zzafw<zzahm> {
    private final /* synthetic */ zzaft zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ z0 zze;
    private final /* synthetic */ zzaem zzf;
    private final /* synthetic */ zzahw zzg;

    public zzaba(zzaas zzaas, zzaft zzaft, String str, String str2, Boolean bool, z0 z0Var, zzaem zzaem, zzahw zzahw) {
        this.zza = zzaft;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = z0Var;
        this.zzf = zzaem;
        this.zzg = zzahw;
        Objects.requireNonNull(zzaas);
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzahl> zza2 = ((zzahm) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        boolean z = false;
        zzahl zzahl = zza2.get(0);
        zzaib zzf2 = zzahl.zzf();
        List<zzaic> zza3 = zzf2 != null ? zzf2.zza() : null;
        if (zza3 != null && !zza3.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                int i = 0;
                while (true) {
                    if (i >= zza3.size()) {
                        break;
                    } else if (zza3.get(i).zzf().equals(this.zzb)) {
                        zza3.get(i).zza(this.zzc);
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                zza3.get(0).zza(this.zzc);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzahl.zza(bool.booleanValue());
        } else {
            if (zzahl.zzb() - zzahl.zza() < 1000) {
                z = true;
            }
            zzahl.zza(z);
        }
        zzahl.zza(this.zze);
        this.zzf.zza(this.zzg, zzahl);
    }
}
