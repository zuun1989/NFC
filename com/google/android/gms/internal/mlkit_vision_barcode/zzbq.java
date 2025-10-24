package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class zzbq extends zzbo implements List {
    final /* synthetic */ zzbr zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbq(zzbr zzbr, Object obj, List list, zzbo zzbo) {
        super(zzbr, obj, list, zzbo);
        this.zzf = zzbr;
    }

    public final void add(int i, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        zzbr zzbr = this.zzf;
        zzbr.zzb = zzbr.zzb + 1;
        if (isEmpty) {
            zza();
        }
    }

    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i, collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzbr zzbr = this.zzf;
        zzbr.zzb = zzbr.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final Object get(int i) {
        zzb();
        return ((List) this.zzb).get(i);
    }

    public final int indexOf(Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        zzb();
        return new zzbp(this);
    }

    public final Object remove(int i) {
        zzb();
        Object remove = ((List) this.zzb).remove(i);
        zzbr zzbr = this.zzf;
        zzbr.zzb = zzbr.zzb - 1;
        zzc();
        return remove;
    }

    public final Object set(int i, Object obj) {
        zzb();
        return ((List) this.zzb).set(i, obj);
    }

    public final List subList(int i, int i2) {
        zzb();
        List subList = ((List) this.zzb).subList(i, i2);
        zzbo zzbo = this.zzc;
        if (zzbo == null) {
            zzbo = this;
        }
        return this.zzf.zzm(this.zza, subList, zzbo);
    }

    public final ListIterator listIterator(int i) {
        zzb();
        return new zzbp(this, i);
    }
}
