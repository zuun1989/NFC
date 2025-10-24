package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface zzak {
    static zzao zzu(zzak zzak, zzao zzao, zzg zzg, List list) {
        if (zzak.zzj(zzao.zzc())) {
            zzao zzk = zzak.zzk(zzao.zzc());
            if (zzk instanceof zzai) {
                return ((zzai) zzk).zza(zzg, list);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", new Object[]{zzao.zzc()}));
        } else if ("hasOwnProperty".equals(zzao.zzc())) {
            zzh.zza("hasOwnProperty", 1, list);
            if (zzak.zzj(zzg.zza((zzao) list.get(0)).zzc())) {
                return zzao.zzk;
            }
            return zzao.zzl;
        } else {
            throw new IllegalArgumentException(String.format("Object has no function %s", new Object[]{zzao.zzc()}));
        }
    }

    static Iterator zzv(Map map) {
        return new zzaj(map.keySet().iterator());
    }

    boolean zzj(String str);

    zzao zzk(String str);

    void zzm(String str, zzao zzao);
}
