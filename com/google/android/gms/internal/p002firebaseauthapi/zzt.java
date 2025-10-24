package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzt  reason: invalid package */
public final class zzt {
    /* access modifiers changed from: private */
    public final zzf zza;
    private final zzz zzb;
    /* access modifiers changed from: private */
    public final int zzc;

    private zzt(zzz zzz) {
        this(zzz, false, zzj.zza, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static zzt zza(char c) {
        zzh zzh = new zzh(c);
        zzu.zza(zzh);
        return new zzt(new zzw(zzh));
    }

    private zzt(zzz zzz, boolean z, zzf zzf, int i) {
        this.zzb = zzz;
        this.zza = zzf;
        this.zzc = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static zzt zza(String str) {
        zzl zza2 = zzp.zza(str);
        if (!zza2.zza("").zzc()) {
            return new zzt(new zzv(zza2));
        }
        throw new IllegalArgumentException(zzp.zza("The pattern may not match the empty string: %s", zza2));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzu.zza(charSequence);
        Iterator<String> zza2 = this.zzb.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza2.hasNext()) {
            arrayList.add(zza2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
