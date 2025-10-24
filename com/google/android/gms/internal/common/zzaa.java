package com.google.android.gms.internal.common;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzaa {
    /* access modifiers changed from: private */
    public final zzr zza;
    /* access modifiers changed from: private */
    public final boolean zzb;
    private final zzx zzc;

    private zzaa(zzx zzx, boolean z, zzr zzr, int i) {
        this.zzc = zzx;
        this.zzb = z;
        this.zza = zzr;
    }

    public static zzaa zzc(zzr zzr) {
        return new zzaa(new zzx(zzr), false, zzq.zza, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    /* access modifiers changed from: private */
    public final Iterator zzh(CharSequence charSequence) {
        zzx zzx = this.zzc;
        return new zzw(zzx, this, charSequence, zzx.zza);
    }

    public final zzaa zzb() {
        return new zzaa(this.zzc, true, this.zza, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final Iterable zzd(CharSequence charSequence) {
        return new zzy(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zzh = zzh(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzh.hasNext()) {
            arrayList.add((String) zzh.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
