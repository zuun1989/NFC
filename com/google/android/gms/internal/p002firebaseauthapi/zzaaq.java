package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import j6.z0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaq  reason: invalid package */
public final class zzaaq {
    private final Status zza;
    private final z0 zzb;
    private final String zzc;
    private final String zzd;

    @SafeParcelable.Constructor
    public zzaaq(Status status, z0 z0Var, String str, String str2) {
        this.zza = status;
        this.zzb = z0Var;
        this.zzc = str;
        this.zzd = str2;
    }

    public final Status zza() {
        return this.zza;
    }

    public final z0 zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
