package com.google.android.gms.internal.p002firebaseauthapi;

import b6.m;
import com.google.firebase.auth.b;
import j6.O;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagb  reason: invalid package */
final class zzagb extends b.b {
    private final /* synthetic */ b.b zza;
    private final /* synthetic */ String zzb;

    public zzagb(b.b bVar, String str) {
        this.zza = bVar;
        this.zzb = str;
    }

    public final void onCodeAutoRetrievalTimeOut(String str) {
        zzagc.zza.remove(this.zzb);
        this.zza.onCodeAutoRetrievalTimeOut(str);
    }

    public final void onCodeSent(String str, b.a aVar) {
        this.zza.onCodeSent(str, aVar);
    }

    public final void onVerificationCompleted(O o) {
        zzagc.zza.remove(this.zzb);
        this.zza.onVerificationCompleted(o);
    }

    public final void onVerificationFailed(m mVar) {
        zzagc.zza.remove(this.zzb);
        this.zza.onVerificationFailed(mVar);
    }
}
