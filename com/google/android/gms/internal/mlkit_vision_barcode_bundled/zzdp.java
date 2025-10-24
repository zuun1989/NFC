package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdp extends zzcs implements RandomAccess, zzeo {
    private double[] zza;
    private int zzb;

    static {
        new zzdp(new double[0], 0, false);
    }

    public zzdp() {
        this(new double[10], 0, true);
    }

    private final String zzg(int i) {
        int i2 = this.zzb;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void zzh(int i) {
        if (i < 0 || i >= this.zzb) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        if (i < 0 || i > (i2 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
        int i3 = i + 1;
        double[] dArr = this.zza;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i3, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zza, i, dArr2, i3, this.zzb - i);
            this.zza = dArr2;
        }
        this.zza[i] = doubleValue;
        this.zzb++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzep.zzb;
        collection.getClass();
        if (!(collection instanceof zzdp)) {
            return super.addAll(collection);
        }
        zzdp zzdp = (zzdp) collection;
        int i = zzdp.zzb;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzb;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zza;
            if (i3 > dArr.length) {
                this.zza = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzdp.zza, 0, this.zza, this.zzb, zzdp.zzb);
            this.zzb = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdp)) {
            return super.equals(obj);
        }
        zzdp zzdp = (zzdp) obj;
        if (this.zzb != zzdp.zzb) {
            return false;
        }
        double[] dArr = zzdp.zza;
        for (int i = 0; i < this.zzb; i++) {
            if (Double.doubleToLongBits(this.zza[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Double.valueOf(this.zza[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            long doubleToLongBits = Double.doubleToLongBits(this.zza[i2]);
            byte[] bArr = zzep.zzb;
            i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i = this.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zza[i2] == doubleValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzh(i);
        double[] dArr = this.zza;
        double d = dArr[i];
        int i2 = this.zzb;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.zzb--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final void removeRange(int i, int i2) {
        zza();
        if (i2 >= i) {
            double[] dArr = this.zza;
            System.arraycopy(dArr, i2, dArr, i, this.zzb - i2);
            this.zzb -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        zzh(i);
        double[] dArr = this.zza;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ zzeo zzd(int i) {
        if (i >= this.zzb) {
            return new zzdp(Arrays.copyOf(this.zza, i), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final double zze(int i) {
        zzh(i);
        return this.zza[i];
    }

    public final void zzf(double d) {
        zza();
        int i = this.zzb;
        double[] dArr = this.zza;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zza = dArr2;
        }
        double[] dArr3 = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        dArr3[i2] = d;
    }

    private zzdp(double[] dArr, int i, boolean z) {
        super(z);
        this.zza = dArr;
        this.zzb = i;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Double) obj).doubleValue());
        return true;
    }
}
