package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajw  reason: invalid package */
public abstract class zzajw implements Serializable, Iterable<Byte> {
    public static final zzajw zza = new zzakh(zzali.zzb);
    private static final zzakd zzb = new zzakg();
    private int zzc = 0;

    static {
        new zzajy();
    }

    public static /* synthetic */ int zza(byte b) {
        return b & 255;
    }

    public static zzajw zzb(byte[] bArr) {
        return new zzakh(bArr);
    }

    public static zzakf zzc(int i) {
        return new zzakf(i);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzb2 = zzb();
            i = zzb(zzb2, 0, zzb2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzajz(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer valueOf = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            str = zzano.zza(this);
        } else {
            str = zzano.zza(zza(0, 47)) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{hexString, valueOf, str});
    }

    public abstract byte zza(int i);

    public abstract zzajw zza(int i, int i2);

    public abstract void zza(zzajx zzajx) throws IOException;

    public abstract void zza(byte[] bArr, int i, int i2, int i3);

    public abstract byte zzb(int i);

    public abstract int zzb();

    public abstract int zzb(int i, int i2, int i3);

    public abstract zzaki zzc();

    public final byte[] zzd() {
        int zzb2 = zzb();
        if (zzb2 == 0) {
            return zzali.zzb;
        }
        byte[] bArr = new byte[zzb2];
        zza(bArr, 0, 0, zzb2);
        return bArr;
    }

    public static int zza(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    public final int zza() {
        return this.zzc;
    }

    public static zzajw zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzajw zza(byte[] bArr, int i, int i2) {
        zza(i, i + i2, bArr.length);
        return new zzakh(zzb.zza(bArr, i, i2));
    }

    public static zzajw zza(String str) {
        return new zzakh(str.getBytes(zzali.zza));
    }
}
