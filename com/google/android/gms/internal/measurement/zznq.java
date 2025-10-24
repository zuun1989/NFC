package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zznq implements zznx {
    private final zznm zza;
    private final zzoi zzb;
    private final boolean zzc;
    private final zzls zzd;

    private zznq(zzoi zzoi, zzls zzls, zznm zznm) {
        this.zzb = zzoi;
        this.zzc = zznm instanceof zzmc;
        this.zzd = zzls;
        this.zza = zznm;
    }

    public static zznq zzg(zzoi zzoi, zzls zzls, zznm zznm) {
        return new zznq(zzoi, zzls, zznm);
    }

    public final Object zza() {
        zznm zznm = this.zza;
        if (zznm instanceof zzmf) {
            return ((zzmf) zznm).zzch();
        }
        return zznm.zzcC().zzbf();
    }

    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzmf) obj).zzc.equals(((zzmf) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzmc) obj).zzb.equals(((zzmc) obj2).zzb);
        }
        return true;
    }

    public final int zzc(Object obj) {
        int hashCode = ((zzmf) obj).zzc.hashCode();
        if (this.zzc) {
            return (hashCode * 53) + ((zzmc) obj).zzb.zza.hashCode();
        }
        return hashCode;
    }

    public final void zzd(Object obj, Object obj2) {
        zznz.zzD(this.zzb, obj, obj2);
        if (this.zzc) {
            zznz.zzC(this.zzd, obj, obj2);
        }
    }

    public final int zze(Object obj) {
        int zzh = ((zzmf) obj).zzc.zzh();
        if (this.zzc) {
            return zzh + ((zzmc) obj).zzb.zzg();
        }
        return zzh;
    }

    public final void zzf(Object obj, zzov zzov) throws IOException {
        Iterator zzc2 = ((zzmc) obj).zzb.zzc();
        while (zzc2.hasNext()) {
            Map.Entry entry = (Map.Entry) zzc2.next();
            zzlv zzlv = (zzlv) entry.getKey();
            if (zzlv.zzc() != zzou.MESSAGE || zzlv.zzd() || zzlv.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzmt) {
                zzov.zzv(zzlv.zza(), ((zzmt) entry).zza().zzc());
            } else {
                zzov.zzv(zzlv.zza(), entry.getValue());
            }
        }
        ((zzmf) obj).zzc.zzf(zzov);
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkw zzkw) throws IOException {
        zzmf zzmf = (zzmf) obj;
        if (zzmf.zzc == zzoj.zza()) {
            zzmf.zzc = zzoj.zzb();
        }
        zzmc zzmc = (zzmc) obj;
        throw null;
    }

    public final void zzj(Object obj) {
        this.zzb.zzb(obj);
        this.zzd.zza(obj);
    }

    public final boolean zzk(Object obj) {
        return ((zzmc) obj).zzb.zze();
    }
}
