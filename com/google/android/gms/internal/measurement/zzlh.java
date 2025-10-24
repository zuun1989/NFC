package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzlh implements Iterable, Serializable {
    public static final zzlh zzb = new zzlg(zzmp.zzb);
    private int zza = 0;

    static {
        int i = zzkv.zza;
    }

    public static zzlh zzh(byte[] bArr, int i, int i2) {
        zzj(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzlg(bArr2);
    }

    public static int zzj(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 21);
            sb2.append("Beginning index: ");
            sb2.append(i);
            sb2.append(" < 0");
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i2 < i) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i2).length());
            sb3.append("Beginning index larger than ending index: ");
            sb3.append(i);
            sb3.append(", ");
            sb3.append(i2);
            throw new IndexOutOfBoundsException(sb3.toString());
        } else {
            StringBuilder sb4 = new StringBuilder(String.valueOf(i2).length() + 15 + String.valueOf(i3).length());
            sb4.append("End index: ");
            sb4.append(i2);
            sb4.append(" >= ");
            sb4.append(i3);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zza;
        if (i == 0) {
            int zzc = zzc();
            i = zzg(zzc, 0, zzc);
            if (i == 0) {
                i = 1;
            }
            this.zza = i;
        }
        return i;
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzla(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer valueOf = Integer.valueOf(zzc());
        if (zzc() <= 50) {
            str = zzog.zza(this);
        } else {
            str = zzog.zza(zze(0, 47)).concat("...");
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{hexString, valueOf, str});
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzc();

    public abstract zzlh zze(int i, int i2);

    public abstract void zzf(zzkz zzkz) throws IOException;

    public abstract int zzg(int i, int i2, int i3);

    public final int zzi() {
        return this.zza;
    }
}
