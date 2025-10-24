package com.google.android.gms.internal.maps;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class zzbm {
    Object[] zza;
    int zzb;
    zzbl zzc;

    public zzbm() {
        this(4);
    }

    private final void zzb(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            if (i2 > length) {
                length = length + (length >> 1) + 1;
                if (length < i2) {
                    int highestOneBit = Integer.highestOneBit(i2 - 1);
                    length = highestOneBit + highestOneBit;
                }
                if (length < 0) {
                    length = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
            }
            this.zza = Arrays.copyOf(objArr, length);
        }
    }

    public final zzbm zza(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzb(this.zzb + ((Collection) iterable).size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            zzb(this.zzb + 1);
            zzbf.zza(key, value);
            Object[] objArr = this.zza;
            int i = this.zzb;
            int i2 = i + i;
            objArr[i2] = key;
            objArr[i2 + 1] = value;
            this.zzb = i + 1;
        }
        return this;
    }

    public zzbm(int i) {
        this.zza = new Object[(i + i)];
        this.zzb = 0;
    }
}
