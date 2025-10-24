package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

final class zzbd extends AbstractMap implements Serializable {
    /* access modifiers changed from: private */
    public static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    /* access modifiers changed from: private */
    public transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    public zzbd() {
        zzo(3);
    }

    /* access modifiers changed from: private */
    public final Object[] zzA() {
        Object[] objArr = this.zzb;
        objArr.getClass();
        return objArr;
    }

    /* access modifiers changed from: private */
    public final Object[] zzB() {
        Object[] objArr = this.zzc;
        objArr.getClass();
        return objArr;
    }

    public static /* synthetic */ int zzb(zzbd zzbd) {
        int i = zzbd.zzg;
        zzbd.zzg = i - 1;
        return i;
    }

    public static /* synthetic */ Object zzg(zzbd zzbd, int i) {
        return zzbd.zzA()[i];
    }

    public static /* synthetic */ Object zzj(zzbd zzbd, int i) {
        return zzbd.zzB()[i];
    }

    public static /* synthetic */ Object zzk(zzbd zzbd) {
        Object obj = zzbd.zze;
        obj.getClass();
        return obj;
    }

    public static /* synthetic */ void zzm(zzbd zzbd, int i, Object obj) {
        zzbd.zzB()[i] = obj;
    }

    /* access modifiers changed from: private */
    public final int zzu() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public final int zzv(Object obj) {
        if (zzq()) {
            return -1;
        }
        int zza2 = zzbf.zza(obj);
        int zzu = zzu();
        Object obj2 = this.zze;
        obj2.getClass();
        int zzc2 = zzbe.zzc(obj2, zza2 & zzu);
        if (zzc2 != 0) {
            int i = ~zzu;
            int i2 = zza2 & i;
            do {
                int i3 = zzc2 - 1;
                int i4 = zzz()[i3];
                if ((i4 & i) == i2 && zzx.zza(obj, zzA()[i3])) {
                    return i3;
                }
                zzc2 = i4 & zzu;
            } while (zzc2 != 0);
        }
        return -1;
    }

    private final int zzw(int i, int i2, int i3, int i4) {
        Object zzd2 = zzbe.zzd(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            zzbe.zze(zzd2, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        obj.getClass();
        int[] zzz = zzz();
        for (int i6 = 0; i6 <= i; i6++) {
            int zzc2 = zzbe.zzc(obj, i6);
            while (zzc2 != 0) {
                int i7 = zzc2 - 1;
                int i8 = zzz[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int zzc3 = zzbe.zzc(zzd2, i10);
                zzbe.zze(zzd2, i10, zzc2);
                zzz[i7] = ((~i5) & i9) | (zzc3 & i5);
                zzc2 = i8 & i;
            }
        }
        this.zze = zzd2;
        zzy(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    public final Object zzx(Object obj) {
        if (zzq()) {
            return zzd;
        }
        int zzu = zzu();
        Object obj2 = this.zze;
        obj2.getClass();
        int zzb2 = zzbe.zzb(obj, (Object) null, zzu, obj2, zzz(), zzA(), (Object[]) null);
        if (zzb2 == -1) {
            return zzd;
        }
        Object obj3 = zzB()[zzb2];
        zzp(zzb2, zzu);
        this.zzg--;
        zzn();
        return obj3;
    }

    private final void zzy(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & -32);
    }

    /* access modifiers changed from: private */
    public final int[] zzz() {
        int[] iArr = this.zza;
        iArr.getClass();
        return iArr;
    }

    public final void clear() {
        if (!zzq()) {
            zzn();
            Map zzl = zzl();
            if (zzl != null) {
                this.zzf = zzcn.zza(size(), 3, 1073741823);
                zzl.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(zzA(), 0, this.zzg, (Object) null);
            Arrays.fill(zzB(), 0, this.zzg, (Object) null);
            Object obj = this.zze;
            obj.getClass();
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(zzz(), 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    public final boolean containsKey(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsKey(obj);
        }
        if (zzv(obj) == -1) {
            return false;
        }
        return true;
    }

    public final boolean containsValue(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzx.zza(obj, zzB()[i])) {
                return true;
            }
        }
        return false;
    }

    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzay zzay = new zzay(this);
        this.zzi = zzay;
        return zzay;
    }

    public final Object get(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.get(obj);
        }
        int zzv = zzv(obj);
        if (zzv == -1) {
            return null;
        }
        return zzB()[zzv];
    }

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzba zzba = new zzba(this);
        this.zzh = zzba;
        return zzba;
    }

    public final Object put(Object obj, Object obj2) {
        int min;
        Object obj3 = obj;
        Object obj4 = obj2;
        if (zzq()) {
            zzab.zzd(zzq(), "Arrays already allocated");
            int i = this.zzf;
            int max = Math.max(i + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) ((double) highestOneBit)) && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzbe.zzd(max2);
            zzy(max2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.put(obj3, obj4);
        }
        int[] zzz = zzz();
        Object[] zzA = zzA();
        Object[] zzB = zzB();
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int zza2 = zzbf.zza(obj);
        int zzu = zzu();
        int i4 = zza2 & zzu;
        Object obj5 = this.zze;
        obj5.getClass();
        int zzc2 = zzbe.zzc(obj5, i4);
        if (zzc2 != 0) {
            int i5 = ~zzu;
            int i6 = zza2 & i5;
            int i7 = 0;
            while (true) {
                int i8 = zzc2 - 1;
                int i9 = zzz[i8];
                int i10 = i9 & i5;
                if (i10 != i6 || !zzx.zza(obj3, zzA[i8])) {
                    int i11 = i9 & zzu;
                    i7++;
                    if (i11 != 0) {
                        zzc2 = i11;
                    } else if (i7 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzu() + 1, 1.0f);
                        for (int zze2 = zze(); zze2 >= 0; zze2 = zzf(zze2)) {
                            linkedHashMap.put(zzA()[zze2], zzB()[zze2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzn();
                        return linkedHashMap.put(obj3, obj4);
                    } else if (i3 > zzu) {
                        zzu = zzw(zzu, zzbe.zza(zzu), zza2, i2);
                    } else {
                        zzz[i8] = (i3 & zzu) | i10;
                    }
                } else {
                    Object obj6 = zzB[i8];
                    zzB[i8] = obj4;
                    return obj6;
                }
            }
        } else if (i3 > zzu) {
            zzu = zzw(zzu, zzbe.zza(zzu), zza2, i2);
        } else {
            Object obj7 = this.zze;
            obj7.getClass();
            zzbe.zze(obj7, i4, i3);
        }
        int length = zzz().length;
        if (i3 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(zzz(), min);
            this.zzb = Arrays.copyOf(zzA(), min);
            this.zzc = Arrays.copyOf(zzB(), min);
        }
        zzz()[i2] = (~zzu) & zza2;
        zzA()[i2] = obj3;
        zzB()[i2] = obj4;
        this.zzg = i3;
        zzn();
        return null;
    }

    public final Object remove(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.remove(obj);
        }
        Object zzx = zzx(obj);
        if (zzx == zzd) {
            return null;
        }
        return zzx;
    }

    public final int size() {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.size();
        }
        return this.zzg;
    }

    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzbc zzbc = new zzbc(this);
        this.zzj = zzbc;
        return zzbc;
    }

    public final int zze() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    public final int zzf(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    public final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzn() {
        this.zzf += 32;
    }

    public final void zzo(int i) {
        this.zzf = zzcn.zza(12, 1, 1073741823);
    }

    public final void zzp(int i, int i2) {
        Object obj = this.zze;
        obj.getClass();
        int[] zzz = zzz();
        Object[] zzA = zzA();
        Object[] zzB = zzB();
        int size = size();
        int i3 = size - 1;
        if (i < i3) {
            Object obj2 = zzA[i3];
            zzA[i] = obj2;
            zzB[i] = zzB[i3];
            zzA[i3] = null;
            zzB[i3] = null;
            zzz[i] = zzz[i3];
            zzz[i3] = 0;
            int zza2 = zzbf.zza(obj2) & i2;
            int zzc2 = zzbe.zzc(obj, zza2);
            if (zzc2 != size) {
                while (true) {
                    int i4 = zzc2 - 1;
                    int i5 = zzz[i4];
                    int i6 = i5 & i2;
                    if (i6 != size) {
                        zzc2 = i6;
                    } else {
                        zzz[i4] = ((i + 1) & i2) | (i5 & (~i2));
                        return;
                    }
                }
            } else {
                zzbe.zze(obj, zza2, i + 1);
            }
        } else {
            zzA[i] = null;
            zzB[i] = null;
            zzz[i] = 0;
        }
    }

    public final boolean zzq() {
        return this.zze == null;
    }

    public zzbd(int i) {
        zzo(12);
    }
}
