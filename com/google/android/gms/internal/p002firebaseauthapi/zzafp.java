package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafp  reason: invalid package */
public class zzafp {
    zzaep zza;
    Executor zzb;

    public final <ResultT> Task<ResultT> zza(zzafr<ResultT> zzafr) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new zzafs(this, zzafr, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
