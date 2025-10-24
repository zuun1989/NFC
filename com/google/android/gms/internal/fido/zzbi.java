package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class zzbi extends zzbj implements NavigableSet, zzbz {
    final transient Comparator zza;
    transient zzbi zzb;

    public zzbi(Comparator comparator) {
        this.zza = comparator;
    }

    public static zzbu zzq(Comparator comparator) {
        if (zzbp.zza.equals(comparator)) {
            return zzbu.zzc;
        }
        int i = zzaz.zzd;
        return new zzbu(zzbs.zza, comparator);
    }

    public Object ceiling(Object obj) {
        obj.getClass();
        return zzbk.zza(zzp(obj, true), (Object) null);
    }

    public final Comparator comparator() {
        return this.zza;
    }

    public Object first() {
        return iterator().next();
    }

    public Object floor(Object obj) {
        obj.getClass();
        return zzbm.zza(zzm(obj, true).descendingIterator(), (Object) null);
    }

    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzm(obj, false);
    }

    public Object higher(Object obj) {
        obj.getClass();
        return zzbk.zza(zzp(obj, false), (Object) null);
    }

    public Object last() {
        return descendingIterator().next();
    }

    public Object lower(Object obj) {
        obj.getClass();
        return zzbm.zza(zzm(obj, false).descendingIterator(), (Object) null);
    }

    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzp(obj, true);
    }

    /* renamed from: zzd */
    public abstract zzcb iterator();

    public abstract zzbi zzf();

    /* renamed from: zzl */
    public final zzbi descendingSet() {
        zzbi zzbi = this.zzb;
        if (zzbi != null) {
            return zzbi;
        }
        zzbi zzf = zzf();
        this.zzb = zzf;
        zzf.zzb = this;
        return zzf;
    }

    public abstract zzbi zzm(Object obj, boolean z);

    /* renamed from: zzn */
    public final zzbi subSet(Object obj, boolean z, Object obj2, boolean z2) {
        boolean z3;
        obj.getClass();
        obj2.getClass();
        if (this.zza.compare(obj, obj2) <= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzap.zzc(z3);
        return zzo(obj, z, obj2, z2);
    }

    public abstract zzbi zzo(Object obj, boolean z, Object obj2, boolean z2);

    public abstract zzbi zzp(Object obj, boolean z);

    /* renamed from: zzr */
    public abstract zzcb descendingIterator();

    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return zzm(obj, z);
    }

    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return zzp(obj, z);
    }
}
