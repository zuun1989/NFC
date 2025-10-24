package com.google.android.gms.internal.measurement;

import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzna extends zzku implements RandomAccess, zzmn, zznt {
    private static final long[] zza;
    private static final zzna zzb;
    private long[] zzc;
    private int zzd;

    static {
        long[] jArr = new long[0];
        zza = jArr;
        zzb = new zzna(jArr, 0, false);
    }

    public zzna() {
        this(zza, 0, true);
    }

    public static zzna zze() {
        return zzb;
    }

    private static int zzi(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final void zzj(int i) {
        if (i < 0 || i >= this.zzd) {
            throw new IndexOutOfBoundsException(zzk(i));
        }
    }

    private final String zzk(int i) {
        return zzkw.zza(this.zzd, i, IdCardService.SFI_DG13, "Index:", ", Size:");
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zzcF();
        if (i < 0 || i > (i2 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzk(i));
        }
        int i3 = i + 1;
        long[] jArr = this.zzc;
        int length = jArr.length;
        if (i2 < length) {
            System.arraycopy(jArr, i, jArr, i3, i2 - i);
        } else {
            long[] jArr2 = new long[zzi(length)];
            System.arraycopy(this.zzc, 0, jArr2, 0, i);
            System.arraycopy(this.zzc, i, jArr2, i3, this.zzd - i);
            this.zzc = jArr2;
        }
        this.zzc[i] = longValue;
        this.zzd++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zzcF();
        byte[] bArr = zzmp.zzb;
        collection.getClass();
        if (!(collection instanceof zzna)) {
            return super.addAll(collection);
        }
        zzna zzna = (zzna) collection;
        int i = zzna.zzd;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzd;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzc;
            if (i3 > jArr.length) {
                this.zzc = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzna.zzc, 0, this.zzc, this.zzd, zzna.zzd);
            this.zzd = i3;
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
        if (!(obj instanceof zzna)) {
            return super.equals(obj);
        }
        zzna zzna = (zzna) obj;
        if (this.zzd != zzna.zzd) {
            return false;
        }
        long[] jArr = zzna.zzc;
        for (int i = 0; i < this.zzd; i++) {
            if (this.zzc[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzj(i);
        return Long.valueOf(this.zzc[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzd; i2++) {
            long j = this.zzc[i2];
            byte[] bArr = zzmp.zzb;
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i = this.zzd;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzc[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzcF();
        zzj(i);
        long[] jArr = this.zzc;
        long j = jArr[i];
        int i2 = this.zzd;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.zzd--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final void removeRange(int i, int i2) {
        zzcF();
        if (i2 >= i) {
            long[] jArr = this.zzc;
            System.arraycopy(jArr, i2, jArr, i, this.zzd - i2);
            this.zzd -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzcF();
        zzj(i);
        long[] jArr = this.zzc;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.zzd;
    }

    public final long zzc(int i) {
        zzj(i);
        return this.zzc[i];
    }

    /* renamed from: zzd */
    public final zzmn zzg(int i) {
        long[] jArr;
        if (i >= this.zzd) {
            if (i == 0) {
                jArr = zza;
            } else {
                jArr = Arrays.copyOf(this.zzc, i);
            }
            return new zzna(jArr, this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzf(long j) {
        zzcF();
        int i = this.zzd;
        int length = this.zzc.length;
        if (i == length) {
            long[] jArr = new long[zzi(length)];
            System.arraycopy(this.zzc, 0, jArr, 0, this.zzd);
            this.zzc = jArr;
        }
        long[] jArr2 = this.zzc;
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        jArr2[i2] = j;
    }

    public final void zzh(int i) {
        int length = this.zzc.length;
        if (i > length) {
            if (length != 0) {
                while (length < i) {
                    length = zzi(length);
                }
                this.zzc = Arrays.copyOf(this.zzc, length);
                return;
            }
            this.zzc = new long[Math.max(i, 10)];
        }
    }

    private zzna(long[] jArr, int i, boolean z) {
        super(z);
        this.zzc = jArr;
        this.zzd = i;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
