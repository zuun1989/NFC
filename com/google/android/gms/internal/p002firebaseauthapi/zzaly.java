package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaly  reason: invalid package */
final class zzaly extends zzajq<Long> implements zzaln<Long>, RandomAccess {
    private static final long[] zza;
    private long[] zzb;
    private int zzc;

    static {
        long[] jArr = new long[0];
        zza = jArr;
        new zzaly(jArr, 0, false);
    }

    public zzaly() {
        this(zza, 0, true);
    }

    private static int zzd(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final String zze(int i) {
        int i2 = this.zzc;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void zzf(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zze(i));
        }
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        zza();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zze(i));
        }
        long[] jArr = this.zzb;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[zzd(jArr.length)];
            System.arraycopy(this.zzb, 0, jArr2, 0, i);
            System.arraycopy(this.zzb, i, jArr2, i + 1, this.zzc - i);
            this.zzb = jArr2;
        }
        this.zzb[i] = longValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zza();
        zzali.zza(collection);
        if (!(collection instanceof zzaly)) {
            return super.addAll(collection);
        }
        zzaly zzaly = (zzaly) collection;
        int i = zzaly.zzc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzb;
            if (i3 > jArr.length) {
                this.zzb = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzaly.zzb, 0, this.zzb, this.zzc, zzaly.zzc);
            this.zzc = i3;
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
        if (!(obj instanceof zzaly)) {
            return super.equals(obj);
        }
        zzaly zzaly = (zzaly) obj;
        if (this.zzc != zzaly.zzc) {
            return false;
        }
        long[] jArr = zzaly.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (this.zzb[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(zzb(i));
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            i = (i * 31) + zzali.zza(this.zzb[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zzb[i] == longValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zza();
        zzf(i);
        long[] jArr = this.zzb;
        long j = jArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final void removeRange(int i, int i2) {
        zza();
        if (i2 >= i) {
            long[] jArr = this.zzb;
            System.arraycopy(jArr, i2, jArr, i, this.zzc - i2);
            this.zzc -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zza();
        zzf(i);
        long[] jArr = this.zzb;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* synthetic */ zzaln zza(int i) {
        if (i >= this.zzc) {
            return new zzaly(i == 0 ? zza : Arrays.copyOf(this.zzb, i), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zzb(int i) {
        zzf(i);
        return this.zzb[i];
    }

    public final void zzc(int i) {
        long[] jArr = this.zzb;
        if (i > jArr.length) {
            if (jArr.length == 0) {
                this.zzb = new long[Math.max(i, 10)];
                return;
            }
            int length = jArr.length;
            while (length < i) {
                length = zzd(length);
            }
            this.zzb = Arrays.copyOf(this.zzb, length);
        }
    }

    private zzaly(long[] jArr, int i, boolean z) {
        super(z);
        this.zzb = jArr;
        this.zzc = i;
    }

    public final void zza(long j) {
        zza();
        int i = this.zzc;
        long[] jArr = this.zzb;
        if (i == jArr.length) {
            long[] jArr2 = new long[zzd(jArr.length)];
            System.arraycopy(this.zzb, 0, jArr2, 0, this.zzc);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        jArr3[i2] = j;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zza(((Long) obj).longValue());
        return true;
    }
}
