package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzako  reason: invalid package */
public abstract class zzako extends zzajx {
    private static final Logger zzb = Logger.getLogger(zzako.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzaoa.zzc();
    zzakq zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzako$zza */
    public static class zza extends zzako {
        private final byte[] zzb;
        private final int zzc;
        private int zzd;

        public zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if (((bArr.length - i2) | i2) >= 0) {
                this.zzb = bArr;
                this.zzd = 0;
                this.zzc = i2;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
        }

        public final int zza() {
            return this.zzc - this.zzd;
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzj(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zzc() {
        }

        public final void zzd(int i, zzajw zzajw) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzajw);
            zzj(1, 4);
        }

        public final void zzf(int i, long j) throws IOException {
            zzj(i, 1);
            zzf(j);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzj(i, 5);
            zzi(i2);
        }

        public final void zzh(int i, int i2) throws IOException {
            zzj(i, 0);
            zzj(i2);
        }

        public final void zzi(int i) throws IOException {
            int i2 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i2] = (byte) i;
                bArr[i2 + 1] = (byte) (i >> 8);
                bArr[i2 + 2] = (byte) (i >> 16);
                bArr[i2 + 3] = i >> 24;
                this.zzd = i2 + 4;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(i2, this.zzc, 4, (Throwable) e);
            }
        }

        public final void zzj(int i) throws IOException {
            if (i >= 0) {
                zzl(i);
            } else {
                zzh((long) i);
            }
        }

        public final void zzk(int i, int i2) throws IOException {
            zzj(i, 0);
            zzl(i2);
        }

        public final void zzl(int i) throws IOException {
            int i2;
            int i3 = this.zzd;
            while ((i & -128) != 0) {
                i2 = i3 + 1;
                this.zzb[i3] = (byte) (i | 128);
                i >>>= 7;
                i3 = i2;
            }
            try {
                i2 = i3 + 1;
                try {
                    this.zzb[i3] = (byte) i;
                    this.zzd = i2;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i3 = i2;
                    throw new zzd(i3, this.zzc, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                throw new zzd(i3, this.zzc, 1, (Throwable) e);
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
                this.zzd += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(this.zzd, this.zzc, i2, (Throwable) e);
            }
        }

        public final void zza(byte b) throws IOException {
            int i = this.zzd;
            try {
                int i2 = i + 1;
                try {
                    this.zzb[i] = b;
                    this.zzd = i2;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i = i2;
                    throw new zzd(i, this.zzc, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                throw new zzd(i, this.zzc, 1, (Throwable) e);
            }
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzl(i2);
            zzc(bArr, 0, i2);
        }

        public final void zzf(long j) throws IOException {
            int i = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i] = (byte) ((int) j);
                bArr[i + 1] = (byte) ((int) (j >> 8));
                bArr[i + 2] = (byte) ((int) (j >> 16));
                bArr[i + 3] = (byte) ((int) (j >> 24));
                bArr[i + 4] = (byte) ((int) (j >> 32));
                bArr[i + 5] = (byte) ((int) (j >> 40));
                bArr[i + 6] = (byte) ((int) (j >> 48));
                bArr[i + 7] = (byte) ((int) (j >> 56));
                this.zzd = i + 8;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(i, this.zzc, 8, (Throwable) e);
            }
        }

        public final void zzh(int i, long j) throws IOException {
            zzj(i, 0);
            zzh(j);
        }

        public final void zzj(int i, int i2) throws IOException {
            zzl((i << 3) | i2);
        }

        public final void zzb(zzajw zzajw) throws IOException {
            zzl(zzajw.zzb());
            zzajw.zza((zzajx) this);
        }

        public final void zzc(int i, zzajw zzajw) throws IOException {
            zzj(i, 2);
            zzb(zzajw);
        }

        public final void zzh(long j) throws IOException {
            int i;
            int i2 = this.zzd;
            if (!zzako.zzc || zza() < 10) {
                while ((j & -128) != 0) {
                    int i3 = i2 + 1;
                    try {
                        this.zzb[i2] = (byte) (((int) j) | 128);
                        j >>>= 7;
                        i2 = i3;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i2 = i3;
                        throw new zzd(i2, this.zzc, 1, (Throwable) e);
                    }
                }
                try {
                    i = i2 + 1;
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    throw new zzd(i2, this.zzc, 1, (Throwable) e);
                }
                try {
                    this.zzb[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e3) {
                    e = e3;
                    i2 = i;
                    throw new zzd(i2, this.zzc, 1, (Throwable) e);
                }
            } else {
                while ((j & -128) != 0) {
                    zzaoa.zza(this.zzb, (long) i2, (byte) (((int) j) | 128));
                    j >>>= 7;
                    i2++;
                }
                i = i2 + 1;
                zzaoa.zza(this.zzb, (long) i2, (byte) ((int) j));
            }
            this.zzd = i;
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        public final void zzb(zzamn zzamn) throws IOException {
            zzl(zzamn.zzl());
            zzamn.zza(this);
        }

        public final void zzc(int i, zzamn zzamn, zzanc zzanc) throws IOException {
            zzj(i, 2);
            zzl(((zzajn) zzamn).zza(zzanc));
            zzanc.zza(zzamn, (zzaom) this.zza);
        }

        public final void zzb(zzamn zzamn, zzanc zzanc) throws IOException {
            zzl(((zzajn) zzamn).zza(zzanc));
            zzanc.zza(zzamn, (zzaom) this.zza);
        }

        public final void zzb(int i, zzamn zzamn) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzb(zzamn);
            zzj(1, 4);
        }

        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        public final void zzb(String str) throws IOException {
            int i = this.zzd;
            try {
                int zzh = zzako.zzh(str.length() * 3);
                int zzh2 = zzako.zzh(str.length());
                if (zzh2 == zzh) {
                    int i2 = i + zzh2;
                    this.zzd = i2;
                    int zza = zzaob.zza(str, this.zzb, i2, zza());
                    this.zzd = i;
                    zzl((zza - i) - zzh2);
                    this.zzd = zza;
                    return;
                }
                zzl(zzaob.zza(str));
                this.zzd = zzaob.zza(str, this.zzb, this.zzd, zza());
            } catch (zzaoe e) {
                this.zzd = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzd(e2);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzako$zzb */
    public static abstract class zzb extends zzako {
        final byte[] zzb;
        final int zzc;
        int zzd;
        int zze;

        public zzb(int i) {
            super();
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.zzb = bArr;
                this.zzc = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void zzb(byte b) {
            int i = this.zzd;
            this.zzb[i] = b;
            this.zzd = i + 1;
            this.zze++;
        }

        public final void zzi(long j) {
            int i = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i] = (byte) ((int) j);
            bArr[i + 1] = (byte) ((int) (j >> 8));
            bArr[i + 2] = (byte) ((int) (j >> 16));
            bArr[i + 3] = (byte) ((int) (j >> 24));
            bArr[i + 4] = (byte) ((int) (j >> 32));
            bArr[i + 5] = (byte) ((int) (j >> 40));
            bArr[i + 6] = (byte) ((int) (j >> 48));
            bArr[i + 7] = (byte) ((int) (j >> 56));
            this.zzd = i + 8;
            this.zze += 8;
        }

        public final void zzj(long j) {
            if (zzako.zzc) {
                long j2 = (long) this.zzd;
                while ((j & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zzd;
                    this.zzd = i + 1;
                    zzaoa.zza(bArr, (long) i, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i2 = this.zzd;
                this.zzd = i2 + 1;
                zzaoa.zza(bArr2, (long) i2, (byte) ((int) j));
                this.zze += (int) (((long) this.zzd) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                bArr3[i3] = (byte) (((int) j) | 128);
                this.zze++;
                j >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i4 = this.zzd;
            this.zzd = i4 + 1;
            bArr4[i4] = (byte) ((int) j);
            this.zze++;
        }

        public final void zzl(int i, int i2) {
            zzn((i << 3) | i2);
        }

        public final void zzm(int i) {
            int i2 = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = i >> 24;
            this.zzd = i2 + 4;
            this.zze += 4;
        }

        public final void zzn(int i) {
            if (zzako.zzc) {
                long j = (long) this.zzd;
                while ((i & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i2 = this.zzd;
                    this.zzd = i2 + 1;
                    zzaoa.zza(bArr, (long) i2, (byte) (i | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                zzaoa.zza(bArr2, (long) i3, (byte) i);
                this.zze += (int) (((long) this.zzd) - j);
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                bArr3[i4] = (byte) (i | 128);
                this.zze++;
                i >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            bArr4[i5] = (byte) i;
            this.zze++;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzako$zzd */
    public static class zzd extends IOException {
        public zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zzd(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        public zzd(int i, int i2, int i3, Throwable th) {
            this((long) i, (long) i2, i3, th);
        }

        private zzd(long j, long j2, int i, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}), th);
        }
    }

    public static int zza(double d) {
        return 8;
    }

    public static int zzb(int i) {
        return 4;
    }

    public static int zzc(long j) {
        return 8;
    }

    public static int zzd(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zze(int i) {
        return 4;
    }

    public static int zzf(int i) {
        return zzh(zzm(i));
    }

    public static int zzg(int i) {
        return zzh(i << 3);
    }

    public static int zzh(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private static int zzm(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zzb(int i, zzamn zzamn) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzajw zzajw) throws IOException;

    public abstract void zzb(zzamn zzamn) throws IOException;

    public abstract void zzb(zzamn zzamn, zzanc zzanc) throws IOException;

    public abstract void zzb(String str) throws IOException;

    public abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc() throws IOException;

    public abstract void zzc(int i, zzajw zzajw) throws IOException;

    public abstract void zzc(int i, zzamn zzamn, zzanc zzanc) throws IOException;

    public abstract void zzd(int i, zzajw zzajw) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzf(long j) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(long j) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public final void zzk(int i) throws IOException {
        zzl(zzm(i));
    }

    public abstract void zzk(int i, int i2) throws IOException;

    public abstract void zzl(int i) throws IOException;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzako$zzc */
    public static final class zzc extends zzb {
        private final OutputStream zzf;

        public zzc(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.zzf = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private final void zze() throws IOException {
            this.zzf.write(this.zzb, 0, this.zzd);
            this.zzd = 0;
        }

        private final void zzo(int i) throws IOException {
            if (this.zzc - this.zzd < i) {
                zze();
            }
        }

        public final void zza(byte b) throws IOException {
            if (this.zzd == this.zzc) {
                zze();
            }
            zzb(b);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzo(11);
            zzl(i, 0);
            zzb(z ? (byte) 1 : 0);
        }

        public final void zzc() throws IOException {
            if (this.zzd > 0) {
                zze();
            }
        }

        public final void zzd(int i, zzajw zzajw) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzajw);
            zzj(1, 4);
        }

        public final void zzf(int i, long j) throws IOException {
            zzo(18);
            zzl(i, 1);
            zzi(j);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzo(14);
            zzl(i, 5);
            zzm(i2);
        }

        public final void zzh(int i, int i2) throws IOException {
            zzo(20);
            zzl(i, 0);
            if (i2 >= 0) {
                zzn(i2);
            } else {
                zzj((long) i2);
            }
        }

        public final void zzi(int i) throws IOException {
            zzo(4);
            zzm(i);
        }

        public final void zzj(int i) throws IOException {
            if (i >= 0) {
                zzl(i);
            } else {
                zzh((long) i);
            }
        }

        public final void zzk(int i, int i2) throws IOException {
            zzo(20);
            zzl(i, 0);
            zzn(i2);
        }

        public final void zzl(int i) throws IOException {
            zzo(5);
            zzn(i);
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.zzc;
            int i4 = this.zzd;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.zzb, i4, i2);
                this.zzd += i2;
            } else {
                int i5 = i3 - i4;
                System.arraycopy(bArr, i, this.zzb, i4, i5);
                int i6 = i + i5;
                i2 -= i5;
                this.zzd = this.zzc;
                this.zze += i5;
                zze();
                if (i2 <= this.zzc) {
                    System.arraycopy(bArr, i6, this.zzb, 0, i2);
                    this.zzd = i2;
                } else {
                    this.zzf.write(bArr, i6, i2);
                }
            }
            this.zze += i2;
        }

        public final void zzj(int i, int i2) throws IOException {
            zzl((i << 3) | i2);
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzl(i2);
            zzc(bArr, 0, i2);
        }

        public final void zzf(long j) throws IOException {
            zzo(8);
            zzi(j);
        }

        public final void zzh(int i, long j) throws IOException {
            zzo(20);
            zzl(i, 0);
            zzj(j);
        }

        public final void zzb(zzajw zzajw) throws IOException {
            zzl(zzajw.zzb());
            zzajw.zza((zzajx) this);
        }

        public final void zzb(zzamn zzamn) throws IOException {
            zzl(zzamn.zzl());
            zzamn.zza(this);
        }

        public final void zzh(long j) throws IOException {
            zzo(10);
            zzj(j);
        }

        public final void zzb(zzamn zzamn, zzanc zzanc) throws IOException {
            zzl(((zzajn) zzamn).zza(zzanc));
            zzanc.zza(zzamn, (zzaom) this.zza);
        }

        public final void zzb(int i, zzamn zzamn) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzb(zzamn);
            zzj(1, 4);
        }

        public final void zzc(int i, zzajw zzajw) throws IOException {
            zzj(i, 2);
            zzb(zzajw);
        }

        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        public final void zzc(int i, zzamn zzamn, zzanc zzanc) throws IOException {
            zzj(i, 2);
            zzb(zzamn, zzanc);
        }

        public final void zzb(String str) throws IOException {
            int i;
            int i2;
            try {
                int length = str.length() * 3;
                int zzh = zzako.zzh(length);
                int i3 = zzh + length;
                int i4 = this.zzc;
                if (i3 > i4) {
                    byte[] bArr = new byte[length];
                    int zza = zzaob.zza(str, bArr, 0, length);
                    zzl(zza);
                    zza(bArr, 0, zza);
                    return;
                }
                if (i3 > i4 - this.zzd) {
                    zze();
                }
                int zzh2 = zzako.zzh(str.length());
                i = this.zzd;
                if (zzh2 == zzh) {
                    int i5 = i + zzh2;
                    this.zzd = i5;
                    int zza2 = zzaob.zza(str, this.zzb, i5, this.zzc - i5);
                    this.zzd = i;
                    i2 = (zza2 - i) - zzh2;
                    zzn(i2);
                    this.zzd = zza2;
                } else {
                    i2 = zzaob.zza(str);
                    zzn(i2);
                    this.zzd = zzaob.zza(str, this.zzb, this.zzd, i2);
                }
                this.zze += i2;
            } catch (zzaoe e) {
                this.zze -= this.zzd - i;
                this.zzd = i;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new zzd(e2);
            } catch (zzaoe e3) {
                zza(str, e3);
            }
        }
    }

    private zzako() {
    }

    public static int zza(float f) {
        return 4;
    }

    public static int zzb(int i, int i2) {
        return zzh(i << 3) + 4;
    }

    public static int zzc(int i, int i2) {
        return zzh(i << 3) + zze((long) i2);
    }

    public static int zze(int i, int i2) {
        return zzh(i << 3) + zzh(zzm(i2));
    }

    public static int zzf(int i, int i2) {
        return zzh(i << 3) + zzh(i2);
    }

    public final void zzg(int i, long j) throws IOException {
        zzh(i, zzi(j));
    }

    public final void zzi(int i, int i2) throws IOException {
        zzk(i, zzm(i2));
    }

    public static int zza(long j) {
        return 8;
    }

    public static int zzb(int i, long j) {
        return zzh(i << 3) + zze(j);
    }

    public static int zzd(int i, int i2) {
        return zzh(i << 3) + 4;
    }

    public final void zzg(long j) throws IOException {
        zzh(zzi(j));
    }

    public static int zza(boolean z) {
        return 1;
    }

    public static int zzc(int i) {
        return zze((long) i);
    }

    public static int zzd(int i, long j) {
        return zzh(i << 3) + zze(zzi(j));
    }

    public static int zze(int i, long j) {
        return zzh(i << 3) + zze(j);
    }

    public static int zza(int i, boolean z) {
        return zzh(i << 3) + 1;
    }

    public static int zzb(long j) {
        return zze(j);
    }

    public static int zzc(int i, long j) {
        return zzh(i << 3) + 8;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzh(length) + length;
    }

    public static int zzb(int i, zzalv zzalv) {
        int zzh = zzh(i << 3);
        int zza2 = zzalv.zza();
        return zzh + zzh(zza2) + zza2;
    }

    public static int zzd(long j) {
        return zze(zzi(j));
    }

    public static int zze(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int zza(int i, zzajw zzajw) {
        int zzh = zzh(i << 3);
        int zzb2 = zzajw.zzb();
        return zzh + zzh(zzb2) + zzb2;
    }

    public static int zzb(int i, zzamn zzamn, zzanc zzanc) {
        return zzh(i << 3) + zza(zzamn, zzanc);
    }

    public static int zza(zzajw zzajw) {
        int zzb2 = zzajw.zzb();
        return zzh(zzb2) + zzb2;
    }

    public static int zzb(int i, zzajw zzajw) {
        return (zzh(8) << 1) + zzf(2, i) + zza(3, zzajw);
    }

    public static int zza(int i, double d) {
        return zzh(i << 3) + 8;
    }

    public static int zza(int i, int i2) {
        return zzh(i << 3) + zze((long) i2);
    }

    public static zzako zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zza(int i) {
        return zze((long) i);
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static int zza(int i, long j) {
        return zzh(i << 3) + 8;
    }

    public static int zza(int i, float f) {
        return zzh(i << 3) + 4;
    }

    public final void zzb(boolean z) throws IOException {
        zza(z ? (byte) 1 : 0);
    }

    @Deprecated
    public static int zza(int i, zzamn zzamn, zzanc zzanc) {
        return (zzh(i << 3) << 1) + ((zzajn) zzamn).zza(zzanc);
    }

    public final void zzb(int i, double d) throws IOException {
        zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzb(double d) throws IOException {
        zzf(Double.doubleToRawLongBits(d));
    }

    public static int zza(int i, zzalv zzalv) {
        return (zzh(8) << 1) + zzf(2, i) + zzb(3, zzalv);
    }

    public final void zzb(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(float f) throws IOException {
        zzi(Float.floatToRawIntBits(f));
    }

    public static int zza(zzalv zzalv) {
        int zza2 = zzalv.zza();
        return zzh(zza2) + zza2;
    }

    public static int zza(int i, zzamn zzamn) {
        return (zzh(8) << 1) + zzf(2, i) + zzh(24) + zza(zzamn);
    }

    public static int zza(zzamn zzamn) {
        int zzl = zzamn.zzl();
        return zzh(zzl) + zzl;
    }

    public static int zza(zzamn zzamn, zzanc zzanc) {
        int zza2 = ((zzajn) zzamn).zza(zzanc);
        return zzh(zza2) + zza2;
    }

    public static int zza(int i, String str) {
        return zzh(i << 3) + zza(str);
    }

    public static int zza(String str) {
        int i;
        try {
            i = zzaob.zza(str);
        } catch (zzaoe unused) {
            i = str.getBytes(zzali.zza).length;
        }
        return zzh(i) + i;
    }

    public static zzako zza(OutputStream outputStream, int i) {
        return new zzc(outputStream, i);
    }

    public final void zza(String str, zzaoe zzaoe) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzaoe);
        byte[] bytes = str.getBytes(zzali.zza);
        try {
            zzl(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzd(e);
        }
    }
}
