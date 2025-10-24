package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import j6.J;
import j6.z0;
import java.util.List;
import k6.N;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaat  reason: invalid package */
public final class zzaat {
    @SafeParcelable.Field(getter = "getMfaPendingCredential", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getMfaInfoList", id = 2)
    private List<zzahz> zzb;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 3)
    private z0 zzc;

    @SafeParcelable.Constructor
    public zzaat(String str, List<zzahz> list, z0 z0Var) {
        this.zza = str;
        this.zzb = list;
        this.zzc = z0Var;
    }

    public final z0 zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final List<J> zzc() {
        return N.b(this.zzb);
    }
}
