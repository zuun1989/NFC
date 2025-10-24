package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakk  reason: invalid package */
final class zzakk extends zzaki {
    private final InputStream zzd;
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private final int zzaa() throws IOException {
        byte b;
        byte b2;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b3 = bArr[i];
            if (b3 >= 0) {
                this.zzh = i3;
                return b3;
            } else if (i2 - i3 >= 9) {
                int i4 = i + 2;
                byte b4 = (bArr[i3] << 7) ^ b3;
                if (b4 < 0) {
                    b = b4 ^ ISOFileInfo.DATA_BYTES1;
                } else {
                    int i5 = i + 3;
                    byte b5 = (bArr[i4] << 14) ^ b4;
                    if (b5 >= 0) {
                        b2 = b5 ^ ISOFileInfo.DATA_BYTES1;
                    } else {
                        int i6 = i + 4;
                        byte b6 = b5 ^ (bArr[i5] << 21);
                        if (b6 < 0) {
                            b = -2080896 ^ b6;
                        } else {
                            i5 = i + 5;
                            byte b7 = bArr[i6];
                            byte b8 = (b6 ^ (b7 << 28)) ^ ISOFileInfo.DATA_BYTES1;
                            if (b7 < 0) {
                                i6 = i + 6;
                                if (bArr[i5] < 0) {
                                    i5 = i + 7;
                                    if (bArr[i6] < 0) {
                                        i6 = i + 8;
                                        if (bArr[i5] < 0) {
                                            i5 = i + 9;
                                            if (bArr[i6] < 0) {
                                                int i7 = i + 10;
                                                if (bArr[i5] >= 0) {
                                                    byte b9 = b8;
                                                    i4 = i7;
                                                    b = b9;
                                                }
                                            }
                                        }
                                    }
                                }
                                b = b8;
                            }
                            b2 = b8;
                        }
                        i4 = i6;
                    }
                    i4 = i5;
                }
                this.zzh = i4;
                return b;
            }
        }
        return (int) zzm();
    }

    private final long zzab() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            zzg(8);
            i = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final long zzac() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzh = i3;
                return (long) b;
            } else if (i2 - i3 >= 9) {
                int i4 = i + 2;
                byte b2 = (bArr[i3] << 7) ^ b;
                if (b2 < 0) {
                    j = (long) (b2 ^ ISOFileInfo.DATA_BYTES1);
                } else {
                    int i5 = i + 3;
                    byte b3 = (bArr[i4] << 14) ^ b2;
                    if (b3 >= 0) {
                        j = (long) (b3 ^ ISOFileInfo.DATA_BYTES1);
                        i4 = i5;
                    } else {
                        int i6 = i + 4;
                        byte b4 = b3 ^ (bArr[i5] << 21);
                        if (b4 < 0) {
                            i4 = i6;
                            j = (long) (-2080896 ^ b4);
                        } else {
                            long j4 = (long) b4;
                            int i7 = i + 5;
                            long j5 = j4 ^ (((long) bArr[i6]) << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i8 = i + 6;
                                long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i7 = i + 7;
                                    j5 = j6 ^ (((long) bArr[i8]) << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i8 = i + 8;
                                        j6 = j5 ^ (((long) bArr[i7]) << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j7 = (j6 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                int i9 = i + 10;
                                                if (((long) bArr[i4]) >= 0) {
                                                    i4 = i9;
                                                }
                                            }
                                            j = j7;
                                        }
                                    }
                                }
                                j = j6 ^ j2;
                                i4 = i8;
                            }
                            j = j5 ^ j3;
                        }
                    }
                }
                this.zzh = i4;
                return j;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = this.zzj + i;
        int i3 = this.zzk;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzg = i4;
            this.zzf = i - i4;
            return;
        }
        this.zzg = 0;
    }

    private final byte zzy() throws IOException {
        if (this.zzh == this.zzf) {
            zzg(1);
        }
        byte[] bArr = this.zze;
        int i = this.zzh;
        this.zzh = i + 1;
        return bArr[i];
    }

    private final int zzz() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            zzg(4);
            i = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzab());
    }

    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzz());
    }

    public final int zzc() {
        return this.zzj + this.zzh;
    }

    public final int zzd() throws IOException {
        return zzaa();
    }

    public final int zze() throws IOException {
        return zzz();
    }

    public final int zzf() throws IOException {
        return zzaa();
    }

    public final int zzg() throws IOException {
        return zzz();
    }

    public final int zzh() throws IOException {
        return zzaki.zza(zzaa());
    }

    public final int zzi() throws IOException {
        if (zzw()) {
            this.zzi = 0;
            return 0;
        }
        int zzaa = zzaa();
        this.zzi = zzaa;
        if ((zzaa >>> 3) != 0) {
            return zzaa;
        }
        throw zzalm.zzc();
    }

    public final int zzj() throws IOException {
        return zzaa();
    }

    public final long zzk() throws IOException {
        return zzab();
    }

    public final long zzl() throws IOException {
        return zzac();
    }

    public final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzy = zzy();
            j |= ((long) (zzy & Byte.MAX_VALUE)) << i;
            if ((zzy & ISOFileInfo.DATA_BYTES1) == 0) {
                return j;
            }
        }
        throw zzalm.zze();
    }

    public final long zzn() throws IOException {
        return zzab();
    }

    public final long zzo() throws IOException {
        return zzaki.zza(zzac());
    }

    public final long zzp() throws IOException {
        return zzac();
    }

    public final zzajw zzq() throws IOException {
        int zzaa = zzaa();
        int i = this.zzf;
        int i2 = this.zzh;
        if (zzaa <= i - i2 && zzaa > 0) {
            zzajw zza = zzajw.zza(this.zze, i2, zzaa);
            this.zzh += zzaa;
            return zza;
        } else if (zzaa == 0) {
            return zzajw.zza;
        } else {
            if (zzaa >= 0) {
                byte[] zzj2 = zzj(zzaa);
                if (zzj2 != null) {
                    return zzajw.zza(zzj2);
                }
                int i3 = this.zzh;
                int i4 = this.zzf;
                int i5 = i4 - i3;
                this.zzj += i4;
                this.zzh = 0;
                this.zzf = 0;
                List<byte[]> zzf2 = zzf(zzaa - i5);
                byte[] bArr = new byte[zzaa];
                System.arraycopy(this.zze, i3, bArr, 0, i5);
                for (byte[] next : zzf2) {
                    System.arraycopy(next, 0, bArr, i5, next.length);
                    i5 += next.length;
                }
                return zzajw.zzb(bArr);
            }
            throw zzalm.zzf();
        }
    }

    public final String zzr() throws IOException {
        int zzaa = zzaa();
        if (zzaa > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzaa <= i - i2) {
                String str = new String(this.zze, i2, zzaa, zzali.zza);
                this.zzh += zzaa;
                return str;
            }
        }
        if (zzaa == 0) {
            return "";
        }
        if (zzaa < 0) {
            throw zzalm.zzf();
        } else if (zzaa > this.zzf) {
            return new String(zza(zzaa, false), zzali.zza);
        } else {
            zzg(zzaa);
            String str2 = new String(this.zze, this.zzh, zzaa, zzali.zza);
            this.zzh += zzaa;
            return str2;
        }
    }

    public final String zzs() throws IOException {
        byte[] bArr;
        int zzaa = zzaa();
        int i = this.zzh;
        int i2 = this.zzf;
        if (zzaa <= i2 - i && zzaa > 0) {
            bArr = this.zze;
            this.zzh = i + zzaa;
        } else if (zzaa == 0) {
            return "";
        } else {
            if (zzaa >= 0) {
                i = 0;
                if (zzaa <= i2) {
                    zzg(zzaa);
                    bArr = this.zze;
                    this.zzh = zzaa;
                } else {
                    bArr = zza(zzaa, false);
                }
            } else {
                throw zzalm.zzf();
            }
        }
        return zzaob.zzb(bArr, i, zzaa);
    }

    public final boolean zzw() throws IOException {
        if (this.zzh != this.zzf || zzi(1)) {
            return false;
        }
        return true;
    }

    public final boolean zzx() throws IOException {
        if (zzac() != 0) {
            return true;
        }
        return false;
    }

    private zzakk(InputStream inputStream, int i) {
        super();
        this.zzk = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        zzali.zza(inputStream, "input");
        this.zzd = inputStream;
        this.zze = new byte[4096];
        this.zzf = 0;
        this.zzh = 0;
        this.zzj = 0;
    }

    private static int zza(InputStream inputStream) throws IOException {
        try {
            return inputStream.available();
        } catch (zzalm e) {
            e.zzk();
            throw e;
        }
    }

    private final List<byte[]> zzf(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zzd.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.zzj += read;
                    i2 += read;
                } else {
                    throw zzalm.zzj();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzg(int i) throws IOException {
        if (zzi(i)) {
            return;
        }
        if (i > (this.zzb - this.zzj) - this.zzh) {
            throw zzalm.zzi();
        }
        throw zzalm.zzj();
    }

    private final void zzh(int i) throws IOException {
        int i2 = this.zzf;
        int i3 = this.zzh;
        if (i <= i2 - i3 && i >= 0) {
            this.zzh = i3 + i;
        } else if (i >= 0) {
            int i4 = this.zzj;
            int i5 = i4 + i3 + i;
            int i6 = this.zzk;
            if (i5 <= i6) {
                this.zzj = i4 + i3;
                int i7 = i2 - i3;
                this.zzf = 0;
                this.zzh = 0;
                while (i7 < i) {
                    try {
                        long j = (long) (i - i7);
                        long zza = zza(this.zzd, j);
                        int i8 = (zza > 0 ? 1 : (zza == 0 ? 0 : -1));
                        if (i8 >= 0 && zza <= j) {
                            if (i8 == 0) {
                                break;
                            }
                            i7 += (int) zza;
                        } else {
                            throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#skip returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
                        }
                    } catch (Throwable th) {
                        this.zzj += i7;
                        zzad();
                        throw th;
                    }
                }
                this.zzj += i7;
                zzad();
                if (i7 < i) {
                    int i9 = this.zzf;
                    int i10 = i9 - this.zzh;
                    this.zzh = i9;
                    zzg(1);
                    while (true) {
                        int i11 = i - i10;
                        int i12 = this.zzf;
                        if (i11 > i12) {
                            i10 += i12;
                            this.zzh = i12;
                            zzg(1);
                        } else {
                            this.zzh = i11;
                            return;
                        }
                    }
                }
            } else {
                zzh((i6 - i4) - i3);
                throw zzalm.zzj();
            }
        } else {
            throw zzalm.zzf();
        }
    }

    private final byte[] zzj(int i) throws IOException {
        if (i == 0) {
            return zzali.zzb;
        }
        if (i >= 0) {
            int i2 = this.zzj;
            int i3 = this.zzh;
            int i4 = i2 + i3 + i;
            if (i4 - this.zzb <= 0) {
                int i5 = this.zzk;
                if (i4 <= i5) {
                    int i6 = this.zzf - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096 && i7 > zza(this.zzd)) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.zze, this.zzh, bArr, 0, i6);
                    this.zzj += this.zzf;
                    this.zzh = 0;
                    this.zzf = 0;
                    while (i6 < i) {
                        int zza = zza(this.zzd, bArr, i6, i - i6);
                        if (zza != -1) {
                            this.zzj += zza;
                            i6 += zza;
                        } else {
                            throw zzalm.zzj();
                        }
                    }
                    return bArr;
                }
                zzh((i5 - i2) - i3);
                throw zzalm.zzj();
            }
            throw zzalm.zzi();
        }
        throw zzalm.zzf();
    }

    public final int zzb(int i) throws zzalm {
        if (i >= 0) {
            int i2 = i + this.zzj + this.zzh;
            if (i2 >= 0) {
                int i3 = this.zzk;
                if (i2 <= i3) {
                    this.zzk = i2;
                    zzad();
                    return i3;
                }
                throw zzalm.zzj();
            }
            throw zzalm.zzi();
        }
        throw zzalm.zzf();
    }

    public final void zzc(int i) throws zzalm {
        if (this.zzi != i) {
            throw zzalm.zzb();
        }
    }

    public final void zzd(int i) {
        this.zzk = i;
        zzad();
    }

    public final boolean zze(int i) throws IOException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzf - this.zzh >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zze;
                    int i4 = this.zzh;
                    this.zzh = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzalm.zze();
            }
            while (i3 < 10) {
                if (zzy() < 0) {
                    i3++;
                }
            }
            throw zzalm.zze();
            return true;
        } else if (i2 == 1) {
            zzh(8);
            return true;
        } else if (i2 == 2) {
            zzh(zzaa());
            return true;
        } else if (i2 == 3) {
            zzv();
            zzc(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            zzu();
            return false;
        } else if (i2 == 5) {
            zzh(4);
            return true;
        } else {
            throw zzalm.zza();
        }
    }

    private static int zza(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        try {
            return inputStream.read(bArr, i, i2);
        } catch (zzalm e) {
            e.zzk();
            throw e;
        }
    }

    private final boolean zzi(int i) throws IOException {
        int i2 = this.zzh;
        int i3 = i2 + i;
        int i4 = this.zzf;
        if (i3 > i4) {
            int i5 = this.zzb;
            int i6 = this.zzj;
            if (i > (i5 - i6) - i2 || i6 + i2 + i > this.zzk) {
                return false;
            }
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.zze;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.zzj += i2;
                this.zzf -= i2;
                this.zzh = 0;
            }
            InputStream inputStream = this.zzd;
            byte[] bArr2 = this.zze;
            int i7 = this.zzf;
            int zza = zza(inputStream, bArr2, i7, Math.min(bArr2.length - i7, (this.zzb - this.zzj) - i7));
            if (zza == 0 || zza < -1 || zza > this.zze.length) {
                throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#read(byte[]) returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
            } else if (zza <= 0) {
                return false;
            } else {
                this.zzf += zza;
                zzad();
                if (this.zzf >= i || zzi(i)) {
                    return true;
                }
                return false;
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
    }

    private static long zza(InputStream inputStream, long j) throws IOException {
        try {
            return inputStream.skip(j);
        } catch (zzalm e) {
            e.zzk();
            throw e;
        }
    }

    private final byte[] zza(int i, boolean z) throws IOException {
        byte[] zzj2 = zzj(i);
        if (zzj2 != null) {
            return zzj2;
        }
        int i2 = this.zzh;
        int i3 = this.zzf;
        int i4 = i3 - i2;
        this.zzj += i3;
        this.zzh = 0;
        this.zzf = 0;
        List<byte[]> zzf2 = zzf(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zze, i2, bArr, 0, i4);
        for (byte[] next : zzf2) {
            System.arraycopy(next, 0, bArr, i4, next.length);
            i4 += next.length;
        }
        return bArr;
    }
}
