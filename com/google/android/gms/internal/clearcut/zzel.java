package com.google.android.gms.internal.clearcut;

import java.util.Iterator;

final class zzel extends zzer {
    private final /* synthetic */ zzei zzos;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzel(zzei zzei) {
        super(zzei, (zzej) null);
        this.zzos = zzei;
    }

    public final Iterator iterator() {
        return new zzek(this.zzos, (zzej) null);
    }

    public /* synthetic */ zzel(zzei zzei, zzej zzej) {
        this(zzei);
    }
}
