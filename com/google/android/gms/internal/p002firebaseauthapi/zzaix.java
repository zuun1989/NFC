package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaix  reason: invalid package */
public final class zzaix {
    private List<String> zza;

    public zzaix() {
        this((List<String>) null);
    }

    public static zzaix zza() {
        return new zzaix((List<String>) null);
    }

    public final List<String> zzb() {
        return this.zza;
    }

    private zzaix(List<String> list) {
        this.zza = new ArrayList();
    }

    public zzaix(int i, List<String> list) {
        if (list == null || list.isEmpty()) {
            this.zza = Collections.emptyList();
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.set(i2, Strings.emptyToNull(list.get(i2)));
        }
        this.zza = Collections.unmodifiableList(list);
    }
}
