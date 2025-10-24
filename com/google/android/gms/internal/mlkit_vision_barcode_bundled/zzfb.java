package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfb extends zzcs implements RandomAccess, zzeo {
    private long[] zza;
    private int zzb;

    static {
        new zzfb(new long[0], 0, false);
    }

    public zzfb() {
        this(new long[10], 0, true);
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
        long longValue = ((Long) obj).longValue();
        zza();
        if (i < 0 || i > (i2 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
        int i3 = i + 1;
        long[] jArr = this.zza;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i3, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zza, i, jArr2, i3, this.zzb - i);
            this.zza = jArr2;
        }
        this.zza[i] = longValue;
        this.zzb++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzep.zzb;
        collection.getClass();
        if (!(collection instanceof zzfb)) {
            return super.addAll(collection);
        }
        zzfb zzfb = (zzfb) collection;
        int i = zzfb.zzb;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzb;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zza;
            if (i3 > jArr.length) {
                this.zza = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzfb.zza, 0, this.zza, this.zzb, zzfb.zzb);
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
        if (!(obj instanceof zzfb)) {
            return super.equals(obj);
        }
        zzfb zzfb = (zzfb) obj;
        if (this.zzb != zzfb.zzb) {
            return false;
        }
        long[] jArr = zzfb.zza;
        for (int i = 0; i < this.zzb; i++) {
            if (this.zza[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Long.valueOf(this.zza[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            long j = this.zza[i2];
            byte[] bArr = zzep.zzb;
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i = this.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zza[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzh(i);
        long[] jArr = this.zza;
        long j = jArr[i];
        int i2 = this.zzb;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.zzb--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final void removeRange(int i, int i2) {
        zza();
        if (i2 >= i) {
            long[] jArr = this.zza;
            System.arraycopy(jArr, i2, jArr, i, this.zzb - i2);
            this.zzb -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zza();
        zzh(i);
        long[] jArr = this.zza;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ zzeo zzd(int i) {
        if (i >= this.zzb) {
            return new zzfb(Arrays.copyOf(this.zza, i), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i) {
        zzh(i);
        return this.zza[i];
    }

    public final void zzf(long j) {
        zza();
        int i = this.zzb;
        long[] jArr = this.zza;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zza = jArr2;
        }
        long[] jArr3 = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        jArr3[i2] = j;
    }

    private zzfb(long[] jArr, int i, boolean z) {
        super(z);
        this.zza = jArr;
        this.zzb = i;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
