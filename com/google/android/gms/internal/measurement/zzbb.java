package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbb extends zzav {
    public zzbb() {
        this.zza.add(zzbk.AND);
        this.zza.add(zzbk.NOT);
        this.zza.add(zzbk.OR);
    }

    public final zzao zza(String str, zzg zzg, List list) {
        zzbk zzbk = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 1) {
            zzh.zza(zzbk.AND.name(), 2, list);
            zzao zza = zzg.zza((zzao) list.get(0));
            if (zza.zze().booleanValue()) {
                return zzg.zza((zzao) list.get(1));
            }
            return zza;
        } else if (ordinal == 47) {
            zzh.zza(zzbk.NOT.name(), 1, list);
            return new zzaf(Boolean.valueOf(!zzg.zza((zzao) list.get(0)).zze().booleanValue()));
        } else if (ordinal != 50) {
            return super.zzb(str);
        } else {
            zzh.zza(zzbk.OR.name(), 2, list);
            zzao zza2 = zzg.zza((zzao) list.get(0));
            if (!zza2.zze().booleanValue()) {
                return zzg.zza((zzao) list.get(1));
            }
            return zza2;
        }
    }
}
