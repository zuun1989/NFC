package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalj  reason: invalid package */
final class zzalj extends zzajq<Integer> implements zzaln<Integer>, RandomAccess {
    private static final int[] zza;
    private int[] zzb;
    private int zzc;

    static {
        int[] iArr = new int[0];
        zza = iArr;
        new zzalj(iArr, 0, false);
    }

    public zzalj() {
        this(zza, 0, true);
    }

    private static int zze(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final String zzf(int i) {
        int i2 = this.zzc;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        zza();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
        int[] iArr = this.zzb;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[zze(iArr.length)];
            System.arraycopy(this.zzb, 0, iArr2, 0, i);
            System.arraycopy(this.zzb, i, iArr2, i + 1, this.zzc - i);
            this.zzb = iArr2;
        }
        this.zzb[i] = intValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zza();
        zzali.zza(collection);
        if (!(collection instanceof zzalj)) {
            return super.addAll(collection);
        }
        zzalj zzalj = (zzalj) collection;
        int i = zzalj.zzc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzb;
            if (i3 > iArr.length) {
                this.zzb = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzalj.zzb, 0, this.zzb, this.zzc, zzalj.zzc);
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
        if (!(obj instanceof zzalj)) {
            return super.equals(obj);
        }
        zzalj zzalj = (zzalj) obj;
        if (this.zzc != zzalj.zzc) {
            return false;
        }
        int[] iArr = zzalj.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (this.zzb[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(zzb(i));
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            i = (i * 31) + this.zzb[i2];
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zzb[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i) {
        zza();
        zzg(i);
        int[] iArr = this.zzb;
        int i2 = iArr[i];
        int i3 = this.zzc;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final void removeRange(int i, int i2) {
        zza();
        if (i2 >= i) {
            int[] iArr = this.zzb;
            System.arraycopy(iArr, i2, iArr, i, this.zzc - i2);
            this.zzc -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zza();
        zzg(i);
        int[] iArr = this.zzb;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* synthetic */ zzaln zza(int i) {
        int[] iArr;
        if (i >= this.zzc) {
            if (i == 0) {
                iArr = zza;
            } else {
                iArr = Arrays.copyOf(this.zzb, i);
            }
            return new zzalj(iArr, this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zzb(int i) {
        zzg(i);
        return this.zzb[i];
    }

    public final void zzc(int i) {
        zza();
        int i2 = this.zzc;
        int[] iArr = this.zzb;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[zze(iArr.length)];
            System.arraycopy(this.zzb, 0, iArr2, 0, this.zzc);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        iArr3[i3] = i;
    }

    public final void zzd(int i) {
        int[] iArr = this.zzb;
        if (i > iArr.length) {
            if (iArr.length == 0) {
                this.zzb = new int[Math.max(i, 10)];
                return;
            }
            int length = iArr.length;
            while (length < i) {
                length = zze(length);
            }
            this.zzb = Arrays.copyOf(this.zzb, length);
        }
    }

    private zzalj(int[] iArr, int i, boolean z) {
        super(z);
        this.zzb = iArr;
        this.zzc = i;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzc(((Integer) obj).intValue());
        return true;
    }
}
