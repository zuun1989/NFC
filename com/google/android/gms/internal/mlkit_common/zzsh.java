package com.google.android.gms.internal.mlkit_common;

import S0.f;
import S0.j;
import V7.b;
import W7.c;
import W7.g;
import W7.l;
import W7.n;
import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.Objects;

public final class zzsh {
    private static zzaf zza;
    private static final zzai zzb = zzai.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzc;
    private final String zzd;
    private final zzrz zze;
    private final n zzf;
    private final Task zzg = g.a().b(new zzse(this));
    private final Task zzh;
    private final String zzi;
    private final int zzj;

    public zzsh(Context context, n nVar, zzrz zzrz, String str) {
        int i;
        new HashMap();
        new HashMap();
        this.zzc = context.getPackageName();
        this.zzd = c.a(context);
        this.zzf = nVar;
        this.zze = zzrz;
        zzsv.zza();
        this.zzi = str;
        g a = g.a();
        Objects.requireNonNull(nVar);
        this.zzh = a.b(new zzsf(nVar));
        zzai zzai = zzb;
        if (zzai.containsKey(str)) {
            i = DynamiteModule.getRemoteVersion(context, (String) zzai.get(str));
        } else {
            i = -1;
        }
        this.zzj = i;
    }

    private static synchronized zzaf zzh() {
        synchronized (zzsh.class) {
            try {
                zzaf zzaf = zza;
                if (zzaf != null) {
                    return zzaf;
                }
                j a = f.a(Resources.getSystem().getConfiguration());
                zzac zzac = new zzac();
                for (int i = 0; i < a.f(); i++) {
                    zzac.zzb(c.b(a.c(i)));
                }
                zzaf zzc2 = zzac.zzc();
                zza = zzc2;
                return zzc2;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private final zzqt zzi(String str, String str2) {
        String str3;
        zzqt zzqt = new zzqt();
        zzqt.zzb(this.zzc);
        zzqt.zzc(this.zzd);
        zzqt.zzh(zzh());
        zzqt.zzg(Boolean.TRUE);
        zzqt.zzl(str);
        zzqt.zzj(str2);
        if (this.zzh.isSuccessful()) {
            str3 = (String) this.zzh.getResult();
        } else {
            str3 = this.zzf.a();
        }
        zzqt.zzi(str3);
        zzqt.zzd(10);
        zzqt.zzk(Integer.valueOf(this.zzj));
        return zzqt;
    }

    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    public final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    public final /* synthetic */ void zzb(zzry zzry, zzmv zzmv, String str) {
        zzry.zza(zzmv);
        zzry.zzc(zzi(zzry.zzd(), str));
        this.zze.zza(zzry);
    }

    public final /* synthetic */ void zzc(zzry zzry, zzsj zzsj, b bVar) {
        zzry.zza(zzmv.MODEL_DOWNLOAD);
        zzry.zzc(zzi(zzsj.zze(), zzj()));
        zzry.zzb(zzst.zza(bVar, this.zzf, zzsj));
        this.zze.zza(zzry);
    }

    public final void zzd(zzry zzry, zzmv zzmv) {
        g.d().execute(new zzsd(this, zzry, zzmv, zzj()));
    }

    public final void zze(zzry zzry, b bVar, boolean z, int i) {
        zzsj.zzh().zzf(false);
        throw null;
    }

    public final void zzf(zzry zzry, b bVar, zzmu zzmu, boolean z, l lVar, zzna zzna) {
        zzsi zzh2 = zzsj.zzh();
        zzh2.zzf(z);
        zzh2.zzd(lVar);
        zzh2.zzb(zzmu);
        zzh2.zza(zzna);
        zzg(zzry, bVar, zzh2.zzh());
    }

    public final void zzg(zzry zzry, b bVar, zzsj zzsj) {
        g.d().execute(new zzsg(this, zzry, zzsj, bVar));
    }
}
