package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakh  reason: invalid package */
class zzakh extends zzake {
    protected final byte[] zzb;

    public zzakh(byte[] bArr) {
        super();
        bArr.getClass();
        this.zzb = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzajw) || zzb() != ((zzajw) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (!(obj instanceof zzakh)) {
            return obj.equals(this);
        }
        zzakh zzakh = (zzakh) obj;
        int zza = zza();
        int zza2 = zzakh.zza();
        if (zza == 0 || zza2 == 0 || zza == zza2) {
            return zza(zzakh, 0, zzb());
        }
        return false;
    }

    public byte zza(int i) {
        return this.zzb[i];
    }

    public byte zzb(int i) {
        return this.zzb[i];
    }

    public final zzaki zzc() {
        return zzaki.zza(this.zzb, zze(), zzb(), true);
    }

    public int zze() {
        return 0;
    }

    public final zzajw zza(int i, int i2) {
        int zza = zzajw.zza(0, i2, zzb());
        if (zza == 0) {
            return zzajw.zza;
        }
        return new zzaka(this.zzb, zze(), zza);
    }

    public final int zzb(int i, int i2, int i3) {
        return zzali.zza(i, this.zzb, zze(), i3);
    }

    public int zzb() {
        return this.zzb.length;
    }

    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    public final void zza(zzajx zzajx) throws IOException {
        zzajx.zza(this.zzb, zze(), zzb());
    }

    public final boolean zza(zzajw zzajw, int i, int i2) {
        if (i2 > zzajw.zzb()) {
            int zzb2 = zzb();
            throw new IllegalArgumentException("Length too large: " + i2 + zzb2);
        } else if (i2 > zzajw.zzb()) {
            int zzb3 = zzajw.zzb();
            throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + i2 + ", " + zzb3);
        } else if (!(zzajw instanceof zzakh)) {
            return zzajw.zza(0, i2).equals(zza(0, i2));
        } else {
            zzakh zzakh = (zzakh) zzajw;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzakh.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzakh.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }
}
