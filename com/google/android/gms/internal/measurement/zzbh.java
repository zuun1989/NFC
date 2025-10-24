package com.google.android.gms.internal.measurement;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.EACTags;
import java.util.List;

public final class zzbh extends zzav {
    public zzbh() {
        this.zza.add(zzbk.ADD);
        this.zza.add(zzbk.DIVIDE);
        this.zza.add(zzbk.MODULUS);
        this.zza.add(zzbk.MULTIPLY);
        this.zza.add(zzbk.NEGATE);
        this.zza.add(zzbk.POST_DECREMENT);
        this.zza.add(zzbk.POST_INCREMENT);
        this.zza.add(zzbk.PRE_DECREMENT);
        this.zza.add(zzbk.PRE_INCREMENT);
        this.zza.add(zzbk.SUBTRACT);
    }

    public final zzao zza(String str, zzg zzg, List list) {
        zzbk zzbk = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 0) {
            zzh.zza(zzbk.ADD.name(), 2, list);
            zzao zza = zzg.zza((zzao) list.get(0));
            zzao zza2 = zzg.zza((zzao) list.get(1));
            if (!(zza instanceof zzak) && !(zza instanceof zzas) && !(zza2 instanceof zzak) && !(zza2 instanceof zzas)) {
                return new zzah(Double.valueOf(zza.zzd().doubleValue() + zza2.zzd().doubleValue()));
            }
            return new zzas(String.valueOf(zza.zzc()).concat(String.valueOf(zza2.zzc())));
        } else if (ordinal == 21) {
            zzh.zza(zzbk.DIVIDE.name(), 2, list);
            return new zzah(Double.valueOf(zzg.zza((zzao) list.get(0)).zzd().doubleValue() / zzg.zza((zzao) list.get(1)).zzd().doubleValue()));
        } else if (ordinal == 59) {
            zzh.zza(zzbk.SUBTRACT.name(), 2, list);
            return new zzah(Double.valueOf(zzg.zza((zzao) list.get(0)).zzd().doubleValue() + new zzah(Double.valueOf(-zzg.zza((zzao) list.get(1)).zzd().doubleValue())).zzd().doubleValue()));
        } else if (ordinal == 52 || ordinal == 53) {
            zzh.zza(str, 2, list);
            zzao zza3 = zzg.zza((zzao) list.get(0));
            zzg.zza((zzao) list.get(1));
            return zza3;
        } else if (ordinal == 55 || ordinal == 56) {
            zzh.zza(str, 1, list);
            return zzg.zza((zzao) list.get(0));
        } else {
            switch (ordinal) {
                case EACTags.CARDHOLDER_NATIONALITY:
                    zzh.zza(zzbk.MODULUS.name(), 2, list);
                    return new zzah(Double.valueOf(zzg.zza((zzao) list.get(0)).zzd().doubleValue() % zzg.zza((zzao) list.get(1)).zzd().doubleValue()));
                case EACTags.LANGUAGE_PREFERENCES:
                    zzh.zza(zzbk.MULTIPLY.name(), 2, list);
                    return new zzah(Double.valueOf(zzg.zza((zzao) list.get(0)).zzd().doubleValue() * zzg.zza((zzao) list.get(1)).zzd().doubleValue()));
                case 46:
                    zzh.zza(zzbk.NEGATE.name(), 1, list);
                    return new zzah(Double.valueOf(-zzg.zza((zzao) list.get(0)).zzd().doubleValue()));
                default:
                    return super.zzb(str);
            }
        }
    }
}
