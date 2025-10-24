package com.google.android.gms.internal.measurement;

import android.os.Binder;

interface zzjv {
    static Object zzh(zzju zzju) {
        long clearCallingIdentity;
        try {
            return zzju.zza();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            Object zza = zzju.zza();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zza;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    Object zze(String str);
}
