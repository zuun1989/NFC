package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzau extends zzav {
    public zzau() {
        this.zza.add(zzbk.BITWISE_AND);
        this.zza.add(zzbk.BITWISE_LEFT_SHIFT);
        this.zza.add(zzbk.BITWISE_NOT);
        this.zza.add(zzbk.BITWISE_OR);
        this.zza.add(zzbk.BITWISE_RIGHT_SHIFT);
        this.zza.add(zzbk.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.zza.add(zzbk.BITWISE_XOR);
    }

    public final zzao zza(String str, zzg zzg, List list) {
        zzah zzah;
        zzbk zzbk = zzbk.ADD;
        switch (zzh.zze(str).ordinal()) {
            case 4:
                zzh.zza(zzbk.BITWISE_AND.name(), 2, list);
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) list.get(0)).zzd().doubleValue()) & zzh.zzg(zzg.zza((zzao) list.get(1)).zzd().doubleValue()))));
                break;
            case 5:
                zzh.zza(zzbk.BITWISE_LEFT_SHIFT.name(), 2, list);
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) list.get(0)).zzd().doubleValue()) << ((int) (zzh.zzh(zzg.zza((zzao) list.get(1)).zzd().doubleValue()) & 31)))));
                break;
            case 6:
                zzh.zza(zzbk.BITWISE_NOT.name(), 1, list);
                zzah = new zzah(Double.valueOf((double) (~zzh.zzg(zzg.zza((zzao) list.get(0)).zzd().doubleValue()))));
                break;
            case 7:
                zzh.zza(zzbk.BITWISE_OR.name(), 2, list);
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) list.get(0)).zzd().doubleValue()) | zzh.zzg(zzg.zza((zzao) list.get(1)).zzd().doubleValue()))));
                break;
            case 8:
                zzh.zza(zzbk.BITWISE_RIGHT_SHIFT.name(), 2, list);
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) list.get(0)).zzd().doubleValue()) >> ((int) (zzh.zzh(zzg.zza((zzao) list.get(1)).zzd().doubleValue()) & 31)))));
                break;
            case 9:
                zzh.zza(zzbk.BITWISE_UNSIGNED_RIGHT_SHIFT.name(), 2, list);
                zzah = new zzah(Double.valueOf((double) (zzh.zzh(zzg.zza((zzao) list.get(0)).zzd().doubleValue()) >>> ((int) (zzh.zzh(zzg.zza((zzao) list.get(1)).zzd().doubleValue()) & 31)))));
                break;
            case 10:
                zzh.zza(zzbk.BITWISE_XOR.name(), 2, list);
                zzah = new zzah(Double.valueOf((double) (zzh.zzg(zzg.zza((zzao) list.get(0)).zzd().doubleValue()) ^ zzh.zzg(zzg.zza((zzao) list.get(1)).zzd().doubleValue()))));
                break;
            default:
                return super.zzb(str);
        }
        return zzah;
    }
}
