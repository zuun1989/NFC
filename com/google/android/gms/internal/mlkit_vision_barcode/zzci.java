package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

final class zzci extends AbstractMap implements Serializable {
    /* access modifiers changed from: private */
    public static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    /* access modifiers changed from: private */
    public transient int zzf;
    /* access modifiers changed from: private */
    public transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    public zzci() {
        zzp(3);
    }

    /* access modifiers changed from: private */
    public final int[] zzA() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* access modifiers changed from: private */
    public final Object[] zzB() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* access modifiers changed from: private */
    public final Object[] zzC() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public static /* synthetic */ Object zzg(zzci zzci, int i) {
        return zzci.zzB()[i];
    }

    public static /* synthetic */ Object zzi(zzci zzci) {
        Object obj = zzci.zze;
        Objects.requireNonNull(obj);
        return obj;
    }

    public static /* synthetic */ Object zzj(zzci zzci, int i) {
        return zzci.zzC()[i];
    }

    public static /* synthetic */ void zzn(zzci zzci, int i, Object obj) {
        zzci.zzC()[i] = obj;
    }

    /* access modifiers changed from: private */
    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public final int zzw(Object obj) {
        if (zzr()) {
            return -1;
        }
        int zza2 = zzck.zza(obj);
        int zzv = zzv();
        Object obj2 = this.zze;
        Objects.requireNonNull(obj2);
        int zzc2 = zzcj.zzc(obj2, zza2 & zzv);
        if (zzc2 != 0) {
            int i = ~zzv;
            int i2 = zza2 & i;
            do {
                int i3 = zzc2 - 1;
                int i4 = zzA()[i3];
                if ((i4 & i) == i2 && zzax.zza(obj, zzB()[i3])) {
                    return i3;
                }
                zzc2 = i4 & zzv;
            } while (zzc2 != 0);
        }
        return -1;
    }

    private final int zzx(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object zzd2 = zzcj.zzd(i2);
        if (i4 != 0) {
            zzcj.zze(zzd2, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] zzA = zzA();
        for (int i6 = 0; i6 <= i; i6++) {
            int zzc2 = zzcj.zzc(obj, i6);
            while (zzc2 != 0) {
                int i7 = zzc2 - 1;
                int i8 = zzA[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int zzc3 = zzcj.zzc(zzd2, i10);
                zzcj.zze(zzd2, i10, zzc2);
                zzA[i7] = ((~i5) & i9) | (zzc3 & i5);
                zzc2 = i8 & i;
            }
        }
        this.zze = zzd2;
        zzz(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    public final Object zzy(Object obj) {
        if (!zzr()) {
            int zzv = zzv();
            Object obj2 = this.zze;
            Objects.requireNonNull(obj2);
            int zzb2 = zzcj.zzb(obj, (Object) null, zzv, obj2, zzA(), zzB(), (Object[]) null);
            if (zzb2 != -1) {
                Object obj3 = zzC()[zzb2];
                zzq(zzb2, zzv);
                this.zzg--;
                zzo();
                return obj3;
            }
        }
        return zzd;
    }

    private final void zzz(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & -32);
    }

    public final void clear() {
        if (!zzr()) {
            zzo();
            Map zzl = zzl();
            if (zzl != null) {
                this.zzf = zzdw.zza(size(), 3, 1073741823);
                zzl.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(zzB(), 0, this.zzg, (Object) null);
            Arrays.fill(zzC(), 0, this.zzg, (Object) null);
            Object obj = this.zze;
            Objects.requireNonNull(obj);
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(zzA(), 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    public final boolean containsKey(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsKey(obj);
        }
        if (zzw(obj) == -1) {
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
            if (zzax.zza(obj, zzC()[i])) {
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
        zzcc zzcc = new zzcc(this);
        this.zzi = zzcc;
        return zzcc;
    }

    public final Object get(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.get(obj);
        }
        int zzw = zzw(obj);
        if (zzw == -1) {
            return null;
        }
        return zzC()[zzw];
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
        zzcf zzcf = new zzcf(this);
        this.zzh = zzcf;
        return zzcf;
    }

    public final Object put(Object obj, Object obj2) {
        int min;
        Object obj3 = obj;
        Object obj4 = obj2;
        if (zzr()) {
            zzaz.zzf(zzr(), "Arrays already allocated");
            int i = this.zzf;
            int max = Math.max(i + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) ((double) highestOneBit)) && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzcj.zzd(max2);
            zzz(max2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.put(obj3, obj4);
        }
        int[] zzA = zzA();
        Object[] zzB = zzB();
        Object[] zzC = zzC();
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int zza2 = zzck.zza(obj);
        int zzv = zzv();
        int i4 = zza2 & zzv;
        Object obj5 = this.zze;
        Objects.requireNonNull(obj5);
        int zzc2 = zzcj.zzc(obj5, i4);
        if (zzc2 != 0) {
            int i5 = ~zzv;
            int i6 = zza2 & i5;
            int i7 = 0;
            while (true) {
                int i8 = zzc2 - 1;
                int i9 = zzA[i8];
                int i10 = i9 & i5;
                if (i10 != i6 || !zzax.zza(obj3, zzB[i8])) {
                    int i11 = i9 & zzv;
                    i7++;
                    if (i11 != 0) {
                        zzc2 = i11;
                    } else if (i7 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                        for (int zze2 = zze(); zze2 >= 0; zze2 = zzf(zze2)) {
                            linkedHashMap.put(zzB()[zze2], zzC()[zze2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzo();
                        return linkedHashMap.put(obj3, obj4);
                    } else if (i3 > zzv) {
                        zzv = zzx(zzv, zzcj.zza(zzv), zza2, i2);
                    } else {
                        zzA[i8] = (i3 & zzv) | i10;
                    }
                } else {
                    Object obj6 = zzC[i8];
                    zzC[i8] = obj4;
                    return obj6;
                }
            }
        } else if (i3 > zzv) {
            zzv = zzx(zzv, zzcj.zza(zzv), zza2, i2);
        } else {
            Object obj7 = this.zze;
            Objects.requireNonNull(obj7);
            zzcj.zze(obj7, i4, i3);
        }
        int length = zzA().length;
        if (i3 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(zzA(), min);
            this.zzb = Arrays.copyOf(zzB(), min);
            this.zzc = Arrays.copyOf(zzC(), min);
        }
        zzA()[i2] = (~zzv) & zza2;
        zzB()[i2] = obj3;
        zzC()[i2] = obj4;
        this.zzg = i3;
        zzo();
        return null;
    }

    public final Object remove(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.remove(obj);
        }
        Object zzy = zzy(obj);
        if (zzy == zzd) {
            return null;
        }
        return zzy;
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
        zzch zzch = new zzch(this);
        this.zzj = zzch;
        return zzch;
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

    public final void zzo() {
        this.zzf += 32;
    }

    public final void zzp(int i) {
        this.zzf = zzdw.zza(i, 1, 1073741823);
    }

    public final void zzq(int i, int i2) {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] zzA = zzA();
        Object[] zzB = zzB();
        Object[] zzC = zzC();
        int size = size();
        int i3 = size - 1;
        if (i < i3) {
            int i4 = i + 1;
            Object obj2 = zzB[i3];
            zzB[i] = obj2;
            zzC[i] = zzC[i3];
            zzB[i3] = null;
            zzC[i3] = null;
            zzA[i] = zzA[i3];
            zzA[i3] = 0;
            int zza2 = zzck.zza(obj2) & i2;
            int zzc2 = zzcj.zzc(obj, zza2);
            if (zzc2 != size) {
                while (true) {
                    int i5 = zzc2 - 1;
                    int i6 = zzA[i5];
                    int i7 = i6 & i2;
                    if (i7 != size) {
                        zzc2 = i7;
                    } else {
                        zzA[i5] = (i6 & (~i2)) | (i2 & i4);
                        return;
                    }
                }
            } else {
                zzcj.zze(obj, zza2, i4);
            }
        } else {
            zzB[i] = null;
            zzC[i] = null;
            zzA[i] = 0;
        }
    }

    public final boolean zzr() {
        return this.zze == null;
    }

    public zzci(int i) {
        zzp(12);
    }
}
