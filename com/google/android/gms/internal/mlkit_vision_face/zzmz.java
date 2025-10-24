package com.google.android.gms.internal.mlkit_vision_face;

import S0.f;
import S0.j;
import W7.c;
import W7.g;
import W7.n;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class zzmz {
    private static zzbn zza;
    private static final zzbp zzb = zzbp.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzc;
    private final String zzd;
    private final zzmy zze;
    private final n zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzmz(Context context, n nVar, zzmy zzmy, String str) {
        int i;
        this.zzc = context.getPackageName();
        this.zzd = c.a(context);
        this.zzf = nVar;
        this.zze = zzmy;
        zznl.zza();
        this.zzi = str;
        this.zzg = g.a().b(new zzmw(this));
        g a = g.a();
        nVar.getClass();
        this.zzh = a.b(new zzmv(nVar));
        zzbp zzbp = zzb;
        if (zzbp.containsKey(str)) {
            i = DynamiteModule.getRemoteVersion(context, (String) zzbp.get(str));
        } else {
            i = -1;
        }
        this.zzj = i;
    }

    public static long zza(List list, double d) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d / 100.0d) * ((double) list.size()))) - 1, 0))).longValue();
    }

    private static synchronized zzbn zzi() {
        synchronized (zzmz.class) {
            try {
                zzbn zzbn = zza;
                if (zzbn != null) {
                    return zzbn;
                }
                j a = f.a(Resources.getSystem().getConfiguration());
                zzbk zzbk = new zzbk();
                for (int i = 0; i < a.f(); i++) {
                    zzbk.zzb(c.b(a.c(i)));
                }
                zzbn zzc2 = zzbk.zzc();
                zza = zzc2;
                return zzc2;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    private final boolean zzk(zzkb zzkb, long j, long j2) {
        if (this.zzk.get(zzkb) != null && j - ((Long) this.zzk.get(zzkb)).longValue() <= TimeUnit.SECONDS.toMillis(30)) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ String zzb() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    public final void zzc(zzmx zzmx, zzkb zzkb) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzkb, elapsedRealtime, 30)) {
            this.zzk.put(zzkb, Long.valueOf(elapsedRealtime));
            zzh(zzmx.zza(), zzkb, zzj());
        }
    }

    public final /* synthetic */ void zzd(zznc zznc, zzkb zzkb, String str) {
        String str2;
        zznc.zzf(zzkb);
        String zzb2 = zznc.zzb();
        zzlr zzlr = new zzlr();
        zzlr.zzb(this.zzc);
        zzlr.zzc(this.zzd);
        zzlr.zzh(zzi());
        zzlr.zzg(Boolean.TRUE);
        zzlr.zzl(zzb2);
        zzlr.zzj(str);
        if (this.zzh.isSuccessful()) {
            str2 = (String) this.zzh.getResult();
        } else {
            str2 = this.zzf.a();
        }
        zzlr.zzi(str2);
        zzlr.zzd(10);
        zzlr.zzk(Integer.valueOf(this.zzj));
        zznc.zzg(zzlr);
        this.zze.zza(zznc);
    }

    public final /* synthetic */ void zze(zzkb zzkb, g8.g gVar) {
        zzbs zzbs = (zzbs) this.zzl.get(zzkb);
        if (zzbs != null) {
            for (Object next : zzbs.zzq()) {
                ArrayList<Long> arrayList = new ArrayList<>(zzbs.zzc(next));
                Collections.sort(arrayList);
                zzjb zzjb = new zzjb();
                long j = 0;
                for (Long longValue : arrayList) {
                    j += longValue.longValue();
                }
                zzjb.zza(Long.valueOf(j / ((long) arrayList.size())));
                zzjb.zzc(Long.valueOf(zza(arrayList, 100.0d)));
                zzjb.zzf(Long.valueOf(zza(arrayList, 75.0d)));
                zzjb.zzd(Long.valueOf(zza(arrayList, 50.0d)));
                zzjb.zzb(Long.valueOf(zza(arrayList, 25.0d)));
                zzjb.zze(Long.valueOf(zza(arrayList, 0.0d)));
                zzh(gVar.a(next, arrayList.size(), zzjb.zzg()), zzkb, zzj());
            }
            this.zzl.remove(zzkb);
        }
    }

    public final /* synthetic */ void zzf(zzkb zzkb, Object obj, long j, g8.g gVar) {
        if (!this.zzl.containsKey(zzkb)) {
            this.zzl.put(zzkb, zzas.zzr());
        }
        ((zzbs) this.zzl.get(zzkb)).zzo(obj, Long.valueOf(j));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzkb, elapsedRealtime, 30)) {
            this.zzk.put(zzkb, Long.valueOf(elapsedRealtime));
            g.d().execute(new zzms(this, zzkb, gVar, (byte[]) null));
        }
    }

    public final void zzg(zznc zznc, zzkb zzkb) {
        zzh(zznc, zzkb, zzj());
    }

    public final void zzh(zznc zznc, zzkb zzkb, String str) {
        g.d().execute(new zzmu(this, zznc, zzkb, str, (byte[]) null));
    }
}
