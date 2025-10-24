package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzlr {
    static final zzlr zza = new zzlr(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzlr zzd;
    private final Map zze;

    public zzlr() {
        this.zze = new HashMap();
    }

    public static zzlr zza() {
        zzlr zzlr = zzd;
        if (zzlr != null) {
            return zzlr;
        }
        synchronized (zzlr.class) {
            try {
                zzlr zzlr2 = zzd;
                if (zzlr2 != null) {
                    return zzlr2;
                }
                int i = zznu.zza;
                zzlr zzb2 = zzlz.zzb(zzlr.class);
                zzd = zzb2;
                return zzb2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzme zzb(zznm zznm, int i) {
        return (zzme) this.zze.get(new zzlq(zznm, i));
    }

    public zzlr(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
