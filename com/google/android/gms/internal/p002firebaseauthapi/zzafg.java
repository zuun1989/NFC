package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import b6.g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.b;
import j6.A;
import j6.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import k6.x;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafg  reason: invalid package */
abstract class zzafg<ResultT, CallbackT> implements zzafr<ResultT> {
    protected final int zza;
    protected final zzafi zzb = new zzafi(this);
    protected g zzc;
    protected A zzd;
    protected CallbackT zze;
    protected x zzf;
    protected zzafh<ResultT> zzg;
    protected final List<b.b> zzh = new ArrayList();
    protected Executor zzi;
    protected zzahw zzj;
    protected zzahl zzk;
    protected zzagw zzl;
    protected zzaig zzm;
    protected h zzn;
    protected String zzo;
    protected String zzp;
    protected zzaat zzq;
    protected zzaht zzr;
    protected zzahs zzs;
    protected zzais zzt;
    boolean zzu;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafg$zza */
    public static class zza extends LifecycleCallback {
        private final List<b.b> zza;

        private zza(LifecycleFragment lifecycleFragment, List<b.b> list) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("PhoneAuthActivityStopCallback", this);
            this.zza = list;
        }

        public static void zza(Activity activity, List<b.b> list) {
            LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
            if (((zza) fragment.getCallbackOrNull("PhoneAuthActivityStopCallback", zza.class)) == null) {
                new zza(fragment, list);
            }
        }

        public void onStop() {
            synchronized (this.zza) {
                this.zza.clear();
            }
        }
    }

    public zzafg(int i) {
        this.zza = i;
    }

    public final zzafg<ResultT, CallbackT> zza(CallbackT callbackt) {
        this.zze = Preconditions.checkNotNull(callbackt, "external callback cannot be null");
        return this;
    }

    public abstract void zzb();

    public final void zzb(ResultT resultt) {
        this.zzu = true;
        this.zzg.zza(resultt, (Status) null);
    }

    public final zzafg<ResultT, CallbackT> zza(x xVar) {
        this.zzf = (x) Preconditions.checkNotNull(xVar, "external failure callback cannot be null");
        return this;
    }

    public final zzafg<ResultT, CallbackT> zza(g gVar) {
        this.zzc = (g) Preconditions.checkNotNull(gVar, "firebaseApp cannot be null");
        return this;
    }

    public final zzafg<ResultT, CallbackT> zza(A a) {
        this.zzd = (A) Preconditions.checkNotNull(a, "firebaseUser cannot be null");
        return this;
    }

    public final zzafg<ResultT, CallbackT> zza(b.b bVar, Activity activity, Executor executor, String str) {
        b.b zza2 = zzagc.zza(str, bVar, this);
        synchronized (this.zzh) {
            this.zzh.add((b.b) Preconditions.checkNotNull(zza2));
        }
        if (activity != null) {
            zza.zza(activity, this.zzh);
        }
        this.zzi = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    public static /* synthetic */ void zza(zzafg zzafg) {
        zzafg.zzb();
        Preconditions.checkState(zzafg.zzu, "no success or failure set on method implementation");
    }

    public static /* synthetic */ void zza(zzafg zzafg, Status status) {
        x xVar = zzafg.zzf;
        if (xVar != null) {
            xVar.zza(status);
        }
    }

    public final void zza(Status status) {
        this.zzu = true;
        this.zzg.zza(null, status);
    }
}
