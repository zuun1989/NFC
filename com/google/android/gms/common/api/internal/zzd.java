package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.q;
import androidx.fragment.app.v;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class zzd extends q implements LifecycleFragment {
    private static final WeakHashMap zza = new WeakHashMap();
    private final zzc zzb = new zzc();

    public static zzd zza(v vVar) {
        zzd zzd;
        WeakHashMap weakHashMap = zza;
        WeakReference weakReference = (WeakReference) weakHashMap.get(vVar);
        if (weakReference != null && (zzd = (zzd) weakReference.get()) != null) {
            return zzd;
        }
        try {
            zzd k0 = vVar.getSupportFragmentManager().k0("SLifecycleFragmentImpl");
            if (k0 == null || k0.isRemoving()) {
                k0 = new zzd();
                vVar.getSupportFragmentManager().p().d(k0, "SLifecycleFragmentImpl").g();
            }
            weakHashMap.put(vVar, new WeakReference(k0));
            return k0;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        this.zzb.zzd(str, lifecycleCallback);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        zzd.super.dump(str, fileDescriptor, printWriter, strArr);
        this.zzb.zze(str, fileDescriptor, printWriter, strArr);
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return this.zzb.zzc(str, cls);
    }

    public final Activity getLifecycleActivity() {
        return getActivity();
    }

    public final boolean isCreated() {
        return this.zzb.zzm();
    }

    public final boolean isStarted() {
        return this.zzb.zzn();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        zzd.super.onActivityResult(i, i2, intent);
        this.zzb.zzf(i, i2, intent);
    }

    public final void onCreate(Bundle bundle) {
        zzd.super.onCreate(bundle);
        this.zzb.zzg(bundle);
    }

    public final void onDestroy() {
        zzd.super.onDestroy();
        this.zzb.zzh();
    }

    public final void onResume() {
        zzd.super.onResume();
        this.zzb.zzi();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        zzd.super.onSaveInstanceState(bundle);
        this.zzb.zzj(bundle);
    }

    public final void onStart() {
        zzd.super.onStart();
        this.zzb.zzk();
    }

    public final void onStop() {
        zzd.super.onStop();
        this.zzb.zzl();
    }
}
