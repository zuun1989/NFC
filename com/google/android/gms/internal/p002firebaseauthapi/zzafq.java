package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import j6.A;
import j6.h;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafq  reason: invalid package */
public final class zzafq<ResultT, CallbackT> implements zzafh<ResultT> {
    private final zzafg<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzafq(zzafg<ResultT, CallbackT> zzafg, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzafg;
        this.zzb = taskCompletionSource;
    }

    public final void zza(ResultT resultt, Status status) {
        A a;
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status != null) {
            zzafg<ResultT, CallbackT> zzafg = this.zza;
            if (zzafg.zzq != null) {
                TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
                FirebaseAuth instance = FirebaseAuth.getInstance(zzafg.zzc);
                zzafg<ResultT, CallbackT> zzafg2 = this.zza;
                zzaat zzaat = zzafg2.zzq;
                if ("reauthenticateWithCredential".equals(zzafg2.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) {
                    a = this.zza.zzd;
                } else {
                    a = null;
                }
                taskCompletionSource.setException(zzaeo.zza(instance, zzaat, a));
                return;
            }
            h hVar = zzafg.zzn;
            if (hVar != null) {
                this.zzb.setException(zzaeo.zza(status, hVar, zzafg.zzo, zzafg.zzp));
            } else {
                this.zzb.setException(zzaeo.zza(status));
            }
        } else {
            this.zzb.setResult(resultt);
        }
    }
}
