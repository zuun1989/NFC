package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;

final class zzy implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzaa zzb;

    public zzy(zzaa zzaa, CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = zzaa;
    }

    public final Iterator iterator() {
        return this.zzb.zzh(this.zza);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb2.append(zzt.zza(it.next(), ", "));
                while (it.hasNext()) {
                    sb2.append(", ");
                    sb2.append(zzt.zza(it.next(), ", "));
                }
            }
            sb2.append(']');
            return sb2.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
