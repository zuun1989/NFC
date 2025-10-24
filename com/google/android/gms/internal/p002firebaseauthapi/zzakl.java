package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakl  reason: invalid package */
final class zzakl extends zzaki {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final int zzaa() throws IOException {
        byte b;
        byte b2;
        int i = this.zzg;
        int i2 = this.zze;
        if (i2 != i) {
            byte[] bArr = this.zzd;
            int i3 = i + 1;
            byte b3 = bArr[i];
            if (b3 >= 0) {
                this.zzg = i3;
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
                this.zzg = i4;
                return b;
            }
        }
        return (int) zzm();
    }

    private final long zzab() throws IOException {
        int i = this.zzg;
        if (this.zze - i >= 8) {
            byte[] bArr = this.zzd;
            this.zzg = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzalm.zzj();
    }

    private final long zzac() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzg;
        int i2 = this.zze;
        if (i2 != i) {
            byte[] bArr = this.zzd;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzg = i3;
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
                this.zzg = i4;
                return j;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i = this.zze + this.zzf;
        this.zze = i;
        int i2 = i - this.zzh;
        int i3 = this.zzj;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzf = i4;
            this.zze = i - i4;
            return;
        }
        this.zzf = 0;
    }

    private final byte zzy() throws IOException {
        int i = this.zzg;
        if (i != this.zze) {
            byte[] bArr = this.zzd;
            this.zzg = i + 1;
            return bArr[i];
        }
        throw zzalm.zzj();
    }

    private final int zzz() throws IOException {
        int i = this.zzg;
        if (this.zze - i >= 4) {
            byte[] bArr = this.zzd;
            this.zzg = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzalm.zzj();
    }

    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzab());
    }

    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzz());
    }

    public final int zzc() {
        return this.zzg - this.zzh;
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
        byte[] bArr;
        int zzaa = zzaa();
        if (zzaa > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (zzaa <= i - i2) {
                zzajw zza = zzajw.zza(this.zzd, i2, zzaa);
                this.zzg += zzaa;
                return zza;
            }
        }
        if (zzaa == 0) {
            return zzajw.zza;
        }
        if (zzaa > 0) {
            int i3 = this.zze;
            int i4 = this.zzg;
            if (zzaa <= i3 - i4) {
                int i5 = zzaa + i4;
                this.zzg = i5;
                bArr = Arrays.copyOfRange(this.zzd, i4, i5);
                return zzajw.zzb(bArr);
            }
        }
        if (zzaa > 0) {
            throw zzalm.zzj();
        } else if (zzaa == 0) {
            bArr = zzali.zzb;
            return zzajw.zzb(bArr);
        } else {
            throw zzalm.zzf();
        }
    }

    public final String zzr() throws IOException {
        int zzaa = zzaa();
        if (zzaa > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (zzaa <= i - i2) {
                String str = new String(this.zzd, i2, zzaa, zzali.zza);
                this.zzg += zzaa;
                return str;
            }
        }
        if (zzaa == 0) {
            return "";
        }
        if (zzaa < 0) {
            throw zzalm.zzf();
        }
        throw zzalm.zzj();
    }

    public final String zzs() throws IOException {
        int zzaa = zzaa();
        if (zzaa > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (zzaa <= i - i2) {
                String zzb = zzaob.zzb(this.zzd, i2, zzaa);
                this.zzg += zzaa;
                return zzb;
            }
        }
        if (zzaa == 0) {
            return "";
        }
        if (zzaa <= 0) {
            throw zzalm.zzf();
        }
        throw zzalm.zzj();
    }

    public final boolean zzw() throws IOException {
        if (this.zzg == this.zze) {
            return true;
        }
        return false;
    }

    public final boolean zzx() throws IOException {
        if (zzac() != 0) {
            return true;
        }
        return false;
    }

    private zzakl(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzj = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzd = bArr;
        this.zze = i2 + i;
        this.zzg = i;
        this.zzh = i;
    }

    private final void zzf(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zze;
            int i3 = this.zzg;
            if (i <= i2 - i3) {
                this.zzg = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzalm.zzf();
        }
        throw zzalm.zzj();
    }

    public final int zzb(int i) throws zzalm {
        if (i >= 0) {
            int zzc = i + zzc();
            if (zzc >= 0) {
                int i2 = this.zzj;
                if (zzc <= i2) {
                    this.zzj = zzc;
                    zzad();
                    return i2;
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
        this.zzj = i;
        zzad();
    }

    public final boolean zze(int i) throws IOException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zze - this.zzg >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzd;
                    int i4 = this.zzg;
                    this.zzg = i4 + 1;
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
            zzf(8);
            return true;
        } else if (i2 == 2) {
            zzf(zzaa());
            return true;
        } else if (i2 == 3) {
            zzv();
            zzc(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            zzu();
            return false;
        } else if (i2 == 5) {
            zzf(4);
            return true;
        } else {
            throw zzalm.zza();
        }
    }
}
