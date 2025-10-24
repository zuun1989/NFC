package com.google.android.gms.internal.mlkit_vision_common;

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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class zzmj {
    private static zzp zza;
    private static final zzr zzb = zzr.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzc;
    private final String zzd;
    private final zzmc zze;
    private final n zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzmj(Context context, n nVar, zzmc zzmc, String str) {
        int i;
        this.zzc = context.getPackageName();
        this.zzd = c.a(context);
        this.zzf = nVar;
        this.zze = zzmc;
        zzmw.zza();
        this.zzi = str;
        this.zzg = g.a().b(new zzmg(this));
        g a = g.a();
        nVar.getClass();
        this.zzh = a.b(new zzmh(nVar));
        zzr zzr = zzb;
        if (zzr.containsKey(str)) {
            i = DynamiteModule.getRemoteVersion(context, (String) zzr.get(str));
        } else {
            i = -1;
        }
        this.zzj = i;
    }

    private static synchronized zzp zzd() {
        synchronized (zzmj.class) {
            try {
                zzp zzp = zza;
                if (zzp != null) {
                    return zzp;
                }
                j a = f.a(Resources.getSystem().getConfiguration());
                zzm zzm = new zzm();
                for (int i = 0; i < a.f(); i++) {
                    zzm.zzb(c.b(a.c(i)));
                }
                zzp zzc2 = zzm.zzc();
                zza = zzc2;
                return zzc2;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    public final /* synthetic */ void zzb(zzmb zzmb, zziv zziv, String str) {
        String str2;
        zzmb.zza(zziv);
        String zzc2 = zzmb.zzc();
        zzky zzky = new zzky();
        zzky.zzb(this.zzc);
        zzky.zzc(this.zzd);
        zzky.zzh(zzd());
        zzky.zzg(Boolean.TRUE);
        zzky.zzl(zzc2);
        zzky.zzj(str);
        if (this.zzh.isSuccessful()) {
            str2 = (String) this.zzh.getResult();
        } else {
            str2 = this.zzf.a();
        }
        zzky.zzi(str2);
        zzky.zzd(10);
        zzky.zzk(Integer.valueOf(this.zzj));
        zzmb.zzb(zzky);
        this.zze.zza(zzmb);
    }

    public final void zzc(zzmt zzmt, zziv zziv) {
        zzii zzii;
        zzio zzio;
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzk.get(zziv) == null || elapsedRealtime - ((Long) this.zzk.get(zziv)).longValue() > TimeUnit.SECONDS.toMillis(30)) {
            this.zzk.put(zziv, Long.valueOf(elapsedRealtime));
            int i = zzmt.zza;
            int i2 = zzmt.zzb;
            int i3 = zzmt.zzc;
            int i4 = zzmt.zzd;
            int i5 = zzmt.zze;
            long j = zzmt.zzf;
            int i6 = zzmt.zzg;
            zzin zzin = new zzin();
            if (i == -1) {
                zzii = zzii.BITMAP;
            } else if (i == 35) {
                zzii = zzii.YUV_420_888;
            } else if (i == 842094169) {
                zzii = zzii.YV12;
            } else if (i == 16) {
                zzii = zzii.NV16;
            } else if (i != 17) {
                zzii = zzii.UNKNOWN_FORMAT;
            } else {
                zzii = zzii.NV21;
            }
            zzin.zzd(zzii);
            if (i2 == 1) {
                zzio = zzio.BITMAP;
            } else if (i2 == 2) {
                zzio = zzio.BYTEARRAY;
            } else if (i2 == 3) {
                zzio = zzio.BYTEBUFFER;
            } else if (i2 != 4) {
                zzio = zzio.ANDROID_MEDIA_IMAGE;
            } else {
                zzio = zzio.FILEPATH;
            }
            zzin.zzf(zzio);
            zzin.zzc(Integer.valueOf(i3));
            zzin.zze(Integer.valueOf(i4));
            zzin.zzg(Integer.valueOf(i5));
            zzin.zzb(Long.valueOf(j));
            zzin.zzh(Integer.valueOf(i6));
            zziq zzj2 = zzin.zzj();
            zziw zziw = new zziw();
            zziw.zzd(zzj2);
            zzmb zze2 = zzmk.zze(zziw);
            if (this.zzg.isSuccessful()) {
                str = (String) this.zzg.getResult();
            } else {
                str = LibraryVersion.getInstance().getVersion(this.zzi);
            }
            g.d().execute(new zzmi(this, zze2, zziv, str));
        }
    }
}
