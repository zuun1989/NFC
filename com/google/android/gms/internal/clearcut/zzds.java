package com.google.android.gms.internal.clearcut;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp.PKIFailureInfo;
import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzds<T> implements zzef<T> {
    private static final Unsafe zzmh = zzfd.zzef();
    private final int[] zzmi;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final zzdo zzmn;
    private final boolean zzmo;
    private final boolean zzmp;
    private final boolean zzmq;
    private final boolean zzmr;
    private final int[] zzms;
    private final int[] zzmt;
    private final int[] zzmu;
    private final zzdw zzmv;
    private final zzcy zzmw;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;
    private final zzdj zzmz;

    private zzds(int[] iArr, Object[] objArr, int i, int i2, int i3, zzdo zzdo, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzdw zzdw, zzcy zzcy, zzex<?, ?> zzex, zzbu<?> zzbu, zzdj zzdj) {
        zzdo zzdo2 = zzdo;
        zzbu<?> zzbu2 = zzbu;
        this.zzmi = iArr;
        this.zzmj = objArr;
        this.zzmk = i;
        this.zzml = i2;
        this.zzmm = i3;
        this.zzmp = zzdo2 instanceof zzcg;
        this.zzmq = z;
        this.zzmo = zzbu2 != null && zzbu2.zze(zzdo);
        this.zzmr = false;
        this.zzms = iArr2;
        this.zzmt = iArr3;
        this.zzmu = iArr4;
        this.zzmv = zzdw;
        this.zzmw = zzcy;
        this.zzmx = zzex;
        this.zzmy = zzbu2;
        this.zzmn = zzdo2;
        this.zzmz = zzdj;
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzay zzay) throws IOException {
        return zzax.zza(i, bArr, i2, i3, zzn(obj), zzay);
    }

    private final zzef zzad(int i) {
        int i2 = (i / 4) << 1;
        zzef zzef = (zzef) this.zzmj[i2];
        if (zzef != null) {
            return zzef;
        }
        zzef zze = zzea.zzcm().zze((Class) this.zzmj[i2 + 1]);
        this.zzmj[i2] = zze;
        return zze;
    }

    private final Object zzae(int i) {
        return this.zzmj[(i / 4) << 1];
    }

    private final zzck<?> zzaf(int i) {
        return (zzck) this.zzmj[((i / 4) << 1) + 1];
    }

    private final int zzag(int i) {
        return this.zzmi[i + 1];
    }

    private final int zzah(int i) {
        return this.zzmi[i + 2];
    }

    private final int zzai(int i) {
        int i2 = this.zzmk;
        if (i >= i2) {
            int i3 = this.zzmm;
            if (i < i3) {
                int i4 = (i - i2) << 2;
                if (this.zzmi[i4] == i) {
                    return i4;
                }
                return -1;
            } else if (i <= this.zzml) {
                int i5 = i3 - i2;
                int length = (this.zzmi.length / 4) - 1;
                while (i5 <= length) {
                    int i6 = (length + i5) >>> 1;
                    int i7 = i6 << 2;
                    int i8 = this.zzmi[i7];
                    if (i == i8) {
                        return i7;
                    }
                    if (i < i8) {
                        length = i6 - 1;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return -1;
    }

    private final void zzb(T t, int i) {
        if (!this.zzmq) {
            int zzah = zzah(i);
            long j = (long) (zzah & 1048575);
            zzfd.zza((Object) t, j, zzfd.zzj(t, j) | (1 << (zzah >>> 20)));
        }
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzfd.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzfd.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzfd.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzfd.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzfd.zzo(t, j)).booleanValue();
    }

    private static zzey zzn(Object obj) {
        zzcg zzcg = (zzcg) obj;
        zzey zzey = zzcg.zzjp;
        if (zzey != zzey.zzea()) {
            return zzey;
        }
        zzey zzeb = zzey.zzeb();
        zzcg.zzjp = zzeb;
        return zzeb;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0070, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0081, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a5, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b6, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c7, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00dd, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0109, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011b, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzl(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzl(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012d, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0141, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0153, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0167, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017b, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x018d, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a1, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        r3 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzmi
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01ac
            int r4 = r9.zzag(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x0191;
                case 1: goto L_0x017f;
                case 2: goto L_0x016b;
                case 3: goto L_0x0157;
                case 4: goto L_0x0145;
                case 5: goto L_0x0131;
                case 6: goto L_0x011f;
                case 7: goto L_0x010d;
                case 8: goto L_0x00f7;
                case 9: goto L_0x00e1;
                case 10: goto L_0x00cb;
                case 11: goto L_0x00b9;
                case 12: goto L_0x00a8;
                case 13: goto L_0x0097;
                case 14: goto L_0x0084;
                case 15: goto L_0x0073;
                case 16: goto L_0x0060;
                case 17: goto L_0x004b;
                case 18: goto L_0x003d;
                case 19: goto L_0x003d;
                case 20: goto L_0x003d;
                case 21: goto L_0x003d;
                case 22: goto L_0x003d;
                case 23: goto L_0x003d;
                case 24: goto L_0x003d;
                case 25: goto L_0x003d;
                case 26: goto L_0x003d;
                case 27: goto L_0x003d;
                case 28: goto L_0x003d;
                case 29: goto L_0x003d;
                case 30: goto L_0x003d;
                case 31: goto L_0x003d;
                case 32: goto L_0x003d;
                case 33: goto L_0x003d;
                case 34: goto L_0x003d;
                case 35: goto L_0x003d;
                case 36: goto L_0x003d;
                case 37: goto L_0x003d;
                case 38: goto L_0x003d;
                case 39: goto L_0x003d;
                case 40: goto L_0x003d;
                case 41: goto L_0x003d;
                case 42: goto L_0x003d;
                case 43: goto L_0x003d;
                case 44: goto L_0x003d;
                case 45: goto L_0x003d;
                case 46: goto L_0x003d;
                case 47: goto L_0x003d;
                case 48: goto L_0x003d;
                case 49: goto L_0x003d;
                case 50: goto L_0x003d;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01a5
        L_0x001c:
            int r4 = r9.zzah(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r4)
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r4)
            if (r8 != r4) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a5
        L_0x003a:
            r3 = r1
            goto L_0x01a5
        L_0x003d:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.clearcut.zzeh.zzd((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01a5
        L_0x004b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a5
            goto L_0x003a
        L_0x0060:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01a5
            goto L_0x003a
        L_0x0073:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a5
            goto L_0x003a
        L_0x0084:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01a5
            goto L_0x003a
        L_0x0097:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a5
            goto L_0x003a
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a5
            goto L_0x003a
        L_0x00b9:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a5
            goto L_0x003a
        L_0x00cb:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a5
            goto L_0x003a
        L_0x00e1:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a5
            goto L_0x003a
        L_0x00f7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01a5
            goto L_0x003a
        L_0x010d:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            boolean r4 = com.google.android.gms.internal.clearcut.zzfd.zzl(r10, r6)
            boolean r5 = com.google.android.gms.internal.clearcut.zzfd.zzl(r11, r6)
            if (r4 == r5) goto L_0x01a5
            goto L_0x003a
        L_0x011f:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a5
            goto L_0x003a
        L_0x0131:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01a5
            goto L_0x003a
        L_0x0145:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a5
            goto L_0x003a
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01a5
            goto L_0x003a
        L_0x016b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01a5
            goto L_0x003a
        L_0x017f:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a5
            goto L_0x003a
        L_0x0191:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01a5
            goto L_0x003a
        L_0x01a5:
            if (r3 != 0) goto L_0x01a8
            return r1
        L_0x01a8:
            int r2 = r2 + 4
            goto L_0x0005
        L_0x01ac:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r9.zzmx
            java.lang.Object r0 = r0.zzq(r10)
            com.google.android.gms.internal.clearcut.zzex<?, ?> r2 = r9.zzmx
            java.lang.Object r2 = r2.zzq(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01bf
            return r1
        L_0x01bf:
            boolean r0 = r9.zzmo
            if (r0 == 0) goto L_0x01d4
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r9.zzmy
            com.google.android.gms.internal.clearcut.zzby r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r9.zzmy
            com.google.android.gms.internal.clearcut.zzby r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01d4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r2 = r2 * 53;
        r3 = zzh(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzci.zzl(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        r2 = r2 * 53;
        r3 = zzg(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0087, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzci.zzc(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e8, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f2, code lost:
        if (r3 != null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f4, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f8, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0110, code lost:
        if (r3 != null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0128, code lost:
        r1 = r1 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002c, code lost:
        r3 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        r2 = r2 + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzmi
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x012c
            int r3 = r8.zzag(r1)
            int[] r4 = r8.zzmi
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0121;
                case 1: goto L_0x011a;
                case 2: goto L_0x00fc;
                case 3: goto L_0x00fc;
                case 4: goto L_0x0104;
                case 5: goto L_0x00fc;
                case 6: goto L_0x0104;
                case 7: goto L_0x0113;
                case 8: goto L_0x0087;
                case 9: goto L_0x010c;
                case 10: goto L_0x0073;
                case 11: goto L_0x0104;
                case 12: goto L_0x0104;
                case 13: goto L_0x0104;
                case 14: goto L_0x00fc;
                case 15: goto L_0x0104;
                case 16: goto L_0x00fc;
                case 17: goto L_0x00ee;
                case 18: goto L_0x0073;
                case 19: goto L_0x0073;
                case 20: goto L_0x0073;
                case 21: goto L_0x0073;
                case 22: goto L_0x0073;
                case 23: goto L_0x0073;
                case 24: goto L_0x0073;
                case 25: goto L_0x0073;
                case 26: goto L_0x0073;
                case 27: goto L_0x0073;
                case 28: goto L_0x0073;
                case 29: goto L_0x0073;
                case 30: goto L_0x0073;
                case 31: goto L_0x0073;
                case 32: goto L_0x0073;
                case 33: goto L_0x0073;
                case 34: goto L_0x0073;
                case 35: goto L_0x0073;
                case 36: goto L_0x0073;
                case 37: goto L_0x0073;
                case 38: goto L_0x0073;
                case 39: goto L_0x0073;
                case 40: goto L_0x0073;
                case 41: goto L_0x0073;
                case 42: goto L_0x0073;
                case 43: goto L_0x0073;
                case 44: goto L_0x0073;
                case 45: goto L_0x0073;
                case 46: goto L_0x0073;
                case 47: goto L_0x0073;
                case 48: goto L_0x0073;
                case 49: goto L_0x0073;
                case 50: goto L_0x0073;
                case 51: goto L_0x00dc;
                case 52: goto L_0x00ca;
                case 53: goto L_0x00c2;
                case 54: goto L_0x00ba;
                case 55: goto L_0x00b3;
                case 56: goto L_0x00ac;
                case 57: goto L_0x00a5;
                case 58: goto L_0x0094;
                case 59: goto L_0x0081;
                case 60: goto L_0x007a;
                case 61: goto L_0x006d;
                case 62: goto L_0x0066;
                case 63: goto L_0x005f;
                case 64: goto L_0x0058;
                case 65: goto L_0x0051;
                case 66: goto L_0x0044;
                case 67: goto L_0x0033;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0128
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
        L_0x0026:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
            int r2 = r2 * 53
        L_0x002c:
            int r3 = r3.hashCode()
        L_0x0030:
            int r2 = r2 + r3
            goto L_0x0128
        L_0x0033:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
        L_0x0039:
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
        L_0x003f:
            int r3 = com.google.android.gms.internal.clearcut.zzci.zzl(r3)
            goto L_0x0030
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
        L_0x004a:
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0030
        L_0x0051:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x0039
        L_0x0058:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x004a
        L_0x005f:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x004a
        L_0x0066:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x004a
        L_0x006d:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
        L_0x0073:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
            goto L_0x002c
        L_0x007a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x0026
        L_0x0081:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
        L_0x0087:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0030
        L_0x0094:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            int r2 = r2 * 53
            boolean r3 = zzi(r9, r5)
        L_0x00a0:
            int r3 = com.google.android.gms.internal.clearcut.zzci.zzc(r3)
            goto L_0x0030
        L_0x00a5:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x004a
        L_0x00ac:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x0039
        L_0x00b3:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x004a
        L_0x00ba:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x0039
        L_0x00c2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            goto L_0x0039
        L_0x00ca:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            int r2 = r2 * 53
            float r3 = zzf(r9, r5)
        L_0x00d6:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0030
        L_0x00dc:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0128
            int r2 = r2 * 53
            double r3 = zze(r9, r5)
        L_0x00e8:
            long r3 = java.lang.Double.doubleToLongBits(r3)
            goto L_0x003f
        L_0x00ee:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
            if (r3 == 0) goto L_0x00f8
        L_0x00f4:
            int r7 = r3.hashCode()
        L_0x00f8:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0128
        L_0x00fc:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.clearcut.zzfd.zzk(r9, r5)
            goto L_0x003f
        L_0x0104:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.clearcut.zzfd.zzj(r9, r5)
            goto L_0x0030
        L_0x010c:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
            if (r3 == 0) goto L_0x00f8
            goto L_0x00f4
        L_0x0113:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.clearcut.zzfd.zzl(r9, r5)
            goto L_0x00a0
        L_0x011a:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.clearcut.zzfd.zzm(r9, r5)
            goto L_0x00d6
        L_0x0121:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.clearcut.zzfd.zzn(r9, r5)
            goto L_0x00e8
        L_0x0128:
            int r1 = r1 + 4
            goto L_0x0005
        L_0x012c:
            int r2 = r2 * 53
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r8.zzmx
            java.lang.Object r0 = r0.zzq(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzmo
            if (r0 == 0) goto L_0x014a
            int r2 = r2 * 53
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r8.zzmy
            com.google.android.gms.internal.clearcut.zzby r9 = r0.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x014a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zzmv.newInstance(this.zzmn);
    }

    public final void zzc(T t) {
        int[] iArr = this.zzmt;
        if (iArr != null) {
            for (int zzag : iArr) {
                long zzag2 = (long) (zzag(zzag) & 1048575);
                Object zzo = zzfd.zzo(t, zzag2);
                if (zzo != null) {
                    zzfd.zza((Object) t, zzag2, this.zzmz.zzj(zzo));
                }
            }
        }
        int[] iArr2 = this.zzmu;
        if (iArr2 != null) {
            for (int i : iArr2) {
                this.zzmw.zza(t, (long) i);
            }
        }
        this.zzmx.zzc(t);
        if (this.zzmo) {
            this.zzmy.zzc(t);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d8, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01e9, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01fa, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x020b, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x021d, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x022f, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0241, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0253, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0265, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0277, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, (com.google.android.gms.internal.clearcut.zzdo) com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r4), zzad(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        r13 = r13 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0365, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03b5, code lost:
        r12 = r12 + 4;
        r3 = 267386880;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzf(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x041f, code lost:
        if (zza(r1, r15, r4) != false) goto L_0x0421;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0421, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzdo) r2.getObject(r1, r10), zzad(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x042f, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0431, code lost:
        r9 = false;
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0442, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzf(r15, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0451, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzi(r15, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x045a, code lost:
        if (zza(r1, r15, r4) != false) goto L_0x045c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x045c, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0467, code lost:
        if (zza(r1, r15, r4) != false) goto L_0x0469;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0469, code lost:
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x046e, code lost:
        r5 = r5 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzi(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x047a, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzl(r15, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0489, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0492, code lost:
        if (zza(r1, r15, r4) != false) goto L_0x0494;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0494, code lost:
        r6 = r2.getObject(r1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0498, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzbb) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x04a3, code lost:
        if (zza(r1, r15, r4) != false) goto L_0x04a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x04a5, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r2.getObject(r1, r10), zzad(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x04bf, code lost:
        if ((r6 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x0498;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x04c2, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, (java.lang.String) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x04ce, code lost:
        if (zza(r1, r15, r4) != false) goto L_0x04d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x04d0, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzh(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0569, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x056b, code lost:
        r2.putInt(r1, (long) r9, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x056f, code lost:
        r9 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r15) + com.google.android.gms.internal.clearcut.zzbn.zzt(r6)) + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x0589, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x059a, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzk(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x05ab, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x05bc, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x05cd, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x05de, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x05ef, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x0601, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x0613, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x0625, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x0637, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x0649, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzl(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x065b, code lost:
        if (r0.zzmr != false) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x066a, code lost:
        r5 = r5 + r6;
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x0715, code lost:
        if ((r12 & r18) != 0) goto L_0x0421;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x072f, code lost:
        if ((r12 & r18) != 0) goto L_0x045c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x0735, code lost:
        if ((r12 & r18) != 0) goto L_0x0469;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x074f, code lost:
        if ((r12 & r18) != 0) goto L_0x0494;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0755, code lost:
        if ((r12 & r18) != 0) goto L_0x04a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzh(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0763, code lost:
        if ((r6 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x0498;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0769, code lost:
        if ((r12 & r18) != 0) goto L_0x04d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x0784, code lost:
        r5 = r5 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x07d6, code lost:
        r4 = r4 + 4;
        r11 = r6;
        r6 = r9;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, (com.google.android.gms.internal.clearcut.zzbb) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c7, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzc(r3, com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r4), zzad(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e0, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e3, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, (java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f1, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fd, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzj(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0109, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzg(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0119, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzg(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0129, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zze(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0139, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzd(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0145, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, 0.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0151, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0185, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0187, code lost:
        r2.putInt(r1, (long) r14, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x018b, code lost:
        r3 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r3) + com.google.android.gms.internal.clearcut.zzbn.zzt(r4)) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a5, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01b6, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01c7, code lost:
        if (r0.zzmr != false) goto L_0x0187;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzm(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zzmq
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r6 = 0
            r7 = 1
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x03c3
            sun.misc.Unsafe r2 = zzmh
            r12 = r11
            r13 = r12
        L_0x0016:
            int[] r14 = r0.zzmi
            int r14 = r14.length
            if (r12 >= r14) goto L_0x03bb
            int r14 = r0.zzag(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzmi
            r3 = r3[r12]
            r14 = r14 & r8
            long r4 = (long) r14
            com.google.android.gms.internal.clearcut.zzcb r14 = com.google.android.gms.internal.clearcut.zzcb.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.clearcut.zzcb r14 = com.google.android.gms.internal.clearcut.zzcb.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzmi
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r8
            goto L_0x0042
        L_0x0041:
            r14 = r11
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x03ad;
                case 1: goto L_0x03a5;
                case 2: goto L_0x0399;
                case 3: goto L_0x038d;
                case 4: goto L_0x0381;
                case 5: goto L_0x0379;
                case 6: goto L_0x0371;
                case 7: goto L_0x0369;
                case 8: goto L_0x0359;
                case 9: goto L_0x0351;
                case 10: goto L_0x0349;
                case 11: goto L_0x033d;
                case 12: goto L_0x0331;
                case 13: goto L_0x0329;
                case 14: goto L_0x0321;
                case 15: goto L_0x0315;
                case 16: goto L_0x0309;
                case 17: goto L_0x0301;
                case 18: goto L_0x028f;
                case 19: goto L_0x0299;
                case 20: goto L_0x02f7;
                case 21: goto L_0x02ed;
                case 22: goto L_0x02e3;
                case 23: goto L_0x028f;
                case 24: goto L_0x0299;
                case 25: goto L_0x02d9;
                case 26: goto L_0x02cf;
                case 27: goto L_0x02c1;
                case 28: goto L_0x02b7;
                case 29: goto L_0x02ad;
                case 30: goto L_0x02a3;
                case 31: goto L_0x0299;
                case 32: goto L_0x028f;
                case 33: goto L_0x0285;
                case 34: goto L_0x027b;
                case 35: goto L_0x0269;
                case 36: goto L_0x0257;
                case 37: goto L_0x0245;
                case 38: goto L_0x0233;
                case 39: goto L_0x0221;
                case 40: goto L_0x020f;
                case 41: goto L_0x01fd;
                case 42: goto L_0x01ec;
                case 43: goto L_0x01db;
                case 44: goto L_0x01ca;
                case 45: goto L_0x01b9;
                case 46: goto L_0x01a8;
                case 47: goto L_0x0197;
                case 48: goto L_0x0177;
                case 49: goto L_0x0169;
                case 50: goto L_0x0159;
                case 51: goto L_0x014b;
                case 52: goto L_0x013f;
                case 53: goto L_0x012f;
                case 54: goto L_0x011f;
                case 55: goto L_0x010f;
                case 56: goto L_0x0103;
                case 57: goto L_0x00f7;
                case 58: goto L_0x00eb;
                case 59: goto L_0x00d4;
                case 60: goto L_0x00c1;
                case 61: goto L_0x00b0;
                case 62: goto L_0x00a1;
                case 63: goto L_0x0092;
                case 64: goto L_0x0087;
                case 65: goto L_0x007c;
                case 66: goto L_0x006d;
                case 67: goto L_0x005e;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x03b5
        L_0x0047:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
        L_0x004d:
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r4)
            com.google.android.gms.internal.clearcut.zzdo r4 = (com.google.android.gms.internal.clearcut.zzdo) r4
            com.google.android.gms.internal.clearcut.zzef r5 = r0.zzad(r12)
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, r4, r5)
        L_0x005b:
            int r13 = r13 + r3
            goto L_0x03b5
        L_0x005e:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
            long r4 = zzh(r1, r4)
        L_0x0068:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzf((int) r3, (long) r4)
            goto L_0x005b
        L_0x006d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
            int r4 = zzg(r1, r4)
        L_0x0077:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzi(r3, r4)
            goto L_0x005b
        L_0x007c:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x03b5
        L_0x0082:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzh((int) r3, (long) r9)
            goto L_0x005b
        L_0x0087:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x03b5
        L_0x008d:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzk(r3, r11)
            goto L_0x005b
        L_0x0092:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
            int r4 = zzg(r1, r4)
        L_0x009c:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzl(r3, r4)
            goto L_0x005b
        L_0x00a1:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
            int r4 = zzg(r1, r4)
        L_0x00ab:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzh((int) r3, (int) r4)
            goto L_0x005b
        L_0x00b0:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
        L_0x00b6:
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r4)
        L_0x00ba:
            com.google.android.gms.internal.clearcut.zzbb r4 = (com.google.android.gms.internal.clearcut.zzbb) r4
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzc((int) r3, (com.google.android.gms.internal.clearcut.zzbb) r4)
            goto L_0x005b
        L_0x00c1:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
        L_0x00c7:
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r4)
            com.google.android.gms.internal.clearcut.zzef r5 = r0.zzad(r12)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzc((int) r3, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.zzef) r5)
            goto L_0x005b
        L_0x00d4:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.clearcut.zzbb
            if (r5 == 0) goto L_0x00e3
        L_0x00e2:
            goto L_0x00ba
        L_0x00e3:
            java.lang.String r4 = (java.lang.String) r4
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzb((int) r3, (java.lang.String) r4)
            goto L_0x005b
        L_0x00eb:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x03b5
        L_0x00f1:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzc((int) r3, (boolean) r7)
            goto L_0x005b
        L_0x00f7:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x03b5
        L_0x00fd:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzj(r3, r11)
            goto L_0x005b
        L_0x0103:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x03b5
        L_0x0109:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzg((int) r3, (long) r9)
            goto L_0x005b
        L_0x010f:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
            int r4 = zzg(r1, r4)
        L_0x0119:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzg((int) r3, (int) r4)
            goto L_0x005b
        L_0x011f:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
            long r4 = zzh(r1, r4)
        L_0x0129:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zze((int) r3, (long) r4)
            goto L_0x005b
        L_0x012f:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x03b5
            long r4 = zzh(r1, r4)
        L_0x0139:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzd((int) r3, (long) r4)
            goto L_0x005b
        L_0x013f:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x03b5
        L_0x0145:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzb((int) r3, (float) r6)
            goto L_0x005b
        L_0x014b:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x03b5
        L_0x0151:
            r4 = 0
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzb((int) r3, (double) r4)
            goto L_0x005b
        L_0x0159:
            com.google.android.gms.internal.clearcut.zzdj r14 = r0.zzmz
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r4)
            java.lang.Object r5 = r0.zzae(r12)
            int r3 = r14.zzb(r3, r4, r5)
            goto L_0x005b
        L_0x0169:
            java.util.List r4 = zzd(r1, r4)
            com.google.android.gms.internal.clearcut.zzef r5 = r0.zzad(r12)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzd(r3, r4, r5)
            goto L_0x005b
        L_0x0177:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
        L_0x0187:
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x018b:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzr(r3)
            int r5 = com.google.android.gms.internal.clearcut.zzbn.zzt(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            goto L_0x005b
        L_0x0197:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzg(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x01a8:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzi(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x01b9:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzh(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x01ca:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzd((java.util.List<java.lang.Integer>) r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x01db:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzf((java.util.List<java.lang.Integer>) r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x01ec:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzj(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x01fd:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzh(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x020f:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzi(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x0221:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zze(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x0233:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzb(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x0245:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zza(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x0257:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzh(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x0269:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzi(r4)
            if (r4 <= 0) goto L_0x03b5
            boolean r5 = r0.zzmr
            if (r5 == 0) goto L_0x018b
            goto L_0x0187
        L_0x027b:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzq(r3, r4, r11)
            goto L_0x005b
        L_0x0285:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzu(r3, r4, r11)
            goto L_0x005b
        L_0x028f:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzw(r3, r4, r11)
            goto L_0x005b
        L_0x0299:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzv(r3, r4, r11)
            goto L_0x005b
        L_0x02a3:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzr(r3, r4, r11)
            goto L_0x005b
        L_0x02ad:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzt(r3, r4, r11)
            goto L_0x005b
        L_0x02b7:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzd((int) r3, (java.util.List<com.google.android.gms.internal.clearcut.zzbb>) r4)
            goto L_0x005b
        L_0x02c1:
            java.util.List r4 = zzd(r1, r4)
            com.google.android.gms.internal.clearcut.zzef r5 = r0.zzad(r12)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzc((int) r3, (java.util.List<?>) r4, (com.google.android.gms.internal.clearcut.zzef) r5)
            goto L_0x005b
        L_0x02cf:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzc(r3, r4)
            goto L_0x005b
        L_0x02d9:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzx(r3, r4, r11)
            goto L_0x005b
        L_0x02e3:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzs(r3, r4, r11)
            goto L_0x005b
        L_0x02ed:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzp(r3, r4, r11)
            goto L_0x005b
        L_0x02f7:
            java.util.List r4 = zzd(r1, r4)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzo(r3, r4, r11)
            goto L_0x005b
        L_0x0301:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            goto L_0x004d
        L_0x0309:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r1, r4)
            goto L_0x0068
        L_0x0315:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r4)
            goto L_0x0077
        L_0x0321:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x03b5
            goto L_0x0082
        L_0x0329:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x03b5
            goto L_0x008d
        L_0x0331:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r4)
            goto L_0x009c
        L_0x033d:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r4)
            goto L_0x00ab
        L_0x0349:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            goto L_0x00b6
        L_0x0351:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            goto L_0x00c7
        L_0x0359:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.clearcut.zzbb
            if (r5 == 0) goto L_0x00e3
            goto L_0x00e2
        L_0x0369:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x03b5
            goto L_0x00f1
        L_0x0371:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x03b5
            goto L_0x00fd
        L_0x0379:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x03b5
            goto L_0x0109
        L_0x0381:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r4)
            goto L_0x0119
        L_0x038d:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r1, r4)
            goto L_0x0129
        L_0x0399:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x03b5
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r1, r4)
            goto L_0x0139
        L_0x03a5:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x03b5
            goto L_0x0145
        L_0x03ad:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x03b5
            goto L_0x0151
        L_0x03b5:
            int r12 = r12 + 4
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x03bb:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r2 = r0.zzmx
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x03c3:
            sun.misc.Unsafe r2 = zzmh
            r3 = -1
            r4 = r11
            r5 = r4
            r12 = r5
        L_0x03c9:
            int[] r13 = r0.zzmi
            int r13 = r13.length
            if (r4 >= r13) goto L_0x07dd
            int r13 = r0.zzag(r4)
            int[] r14 = r0.zzmi
            r15 = r14[r4]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r6 = r17 >>> 20
            r11 = 17
            if (r6 > r11) goto L_0x03f4
            int r11 = r4 + 2
            r11 = r14[r11]
            r14 = r11 & r8
            int r18 = r11 >>> 20
            int r18 = r7 << r18
            if (r14 == r3) goto L_0x03f2
            long r9 = (long) r14
            int r12 = r2.getInt(r1, r9)
            r3 = r14
        L_0x03f2:
            r9 = r11
            goto L_0x0414
        L_0x03f4:
            boolean r9 = r0.zzmr
            if (r9 == 0) goto L_0x0412
            com.google.android.gms.internal.clearcut.zzcb r9 = com.google.android.gms.internal.clearcut.zzcb.DOUBLE_LIST_PACKED
            int r9 = r9.id()
            if (r6 < r9) goto L_0x0412
            com.google.android.gms.internal.clearcut.zzcb r9 = com.google.android.gms.internal.clearcut.zzcb.SINT64_LIST_PACKED
            int r9 = r9.id()
            if (r6 > r9) goto L_0x0412
            int[] r9 = r0.zzmi
            int r10 = r4 + 2
            r9 = r9[r10]
            r9 = r9 & r8
        L_0x040f:
            r18 = 0
            goto L_0x0414
        L_0x0412:
            r9 = 0
            goto L_0x040f
        L_0x0414:
            r10 = r13 & r8
            long r10 = (long) r10
            switch(r6) {
                case 0: goto L_0x07c7;
                case 1: goto L_0x07b9;
                case 2: goto L_0x07a9;
                case 3: goto L_0x0799;
                case 4: goto L_0x0789;
                case 5: goto L_0x0779;
                case 6: goto L_0x076d;
                case 7: goto L_0x0767;
                case 8: goto L_0x0759;
                case 9: goto L_0x0753;
                case 10: goto L_0x074d;
                case 11: goto L_0x0743;
                case 12: goto L_0x0739;
                case 13: goto L_0x0733;
                case 14: goto L_0x072d;
                case 15: goto L_0x0723;
                case 16: goto L_0x0719;
                case 17: goto L_0x0713;
                case 18: goto L_0x0706;
                case 19: goto L_0x0686;
                case 20: goto L_0x06f9;
                case 21: goto L_0x06ec;
                case 22: goto L_0x06df;
                case 23: goto L_0x067a;
                case 24: goto L_0x0686;
                case 25: goto L_0x06d3;
                case 26: goto L_0x06c7;
                case 27: goto L_0x06b7;
                case 28: goto L_0x06ab;
                case 29: goto L_0x069e;
                case 30: goto L_0x0692;
                case 31: goto L_0x0686;
                case 32: goto L_0x067a;
                case 33: goto L_0x066e;
                case 34: goto L_0x065f;
                case 35: goto L_0x064d;
                case 36: goto L_0x063b;
                case 37: goto L_0x0629;
                case 38: goto L_0x0617;
                case 39: goto L_0x0605;
                case 40: goto L_0x05f3;
                case 41: goto L_0x05e1;
                case 42: goto L_0x05d0;
                case 43: goto L_0x05bf;
                case 44: goto L_0x05ae;
                case 45: goto L_0x059d;
                case 46: goto L_0x058c;
                case 47: goto L_0x057b;
                case 48: goto L_0x055b;
                case 49: goto L_0x054b;
                case 50: goto L_0x053b;
                case 51: goto L_0x052d;
                case 52: goto L_0x0520;
                case 53: goto L_0x0510;
                case 54: goto L_0x0500;
                case 55: goto L_0x04f0;
                case 56: goto L_0x04e2;
                case 57: goto L_0x04d6;
                case 58: goto L_0x04ca;
                case 59: goto L_0x04b3;
                case 60: goto L_0x049f;
                case 61: goto L_0x048e;
                case 62: goto L_0x047f;
                case 63: goto L_0x0470;
                case 64: goto L_0x0463;
                case 65: goto L_0x0456;
                case 66: goto L_0x0447;
                case 67: goto L_0x0438;
                case 68: goto L_0x041b;
                default: goto L_0x041a;
            }
        L_0x041a:
            goto L_0x0430
        L_0x041b:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
        L_0x0421:
            java.lang.Object r6 = r2.getObject(r1, r10)
            com.google.android.gms.internal.clearcut.zzdo r6 = (com.google.android.gms.internal.clearcut.zzdo) r6
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r4)
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, r6, r9)
        L_0x042f:
            int r5 = r5 + r6
        L_0x0430:
            r6 = 0
        L_0x0431:
            r9 = 0
            r10 = 0
            r13 = 0
            goto L_0x07d6
        L_0x0438:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            long r9 = zzh(r1, r10)
        L_0x0442:
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzf((int) r15, (long) r9)
            goto L_0x042f
        L_0x0447:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            int r6 = zzg(r1, r10)
        L_0x0451:
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzi(r15, r6)
            goto L_0x042f
        L_0x0456:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
        L_0x045c:
            r9 = 0
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzh((int) r15, (long) r9)
            goto L_0x042f
        L_0x0463:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
        L_0x0469:
            r6 = 0
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, r6)
        L_0x046e:
            int r5 = r5 + r9
            goto L_0x0430
        L_0x0470:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            int r6 = zzg(r1, r10)
        L_0x047a:
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzl(r15, r6)
            goto L_0x042f
        L_0x047f:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            int r6 = zzg(r1, r10)
        L_0x0489:
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzh((int) r15, (int) r6)
            goto L_0x042f
        L_0x048e:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
        L_0x0494:
            java.lang.Object r6 = r2.getObject(r1, r10)
        L_0x0498:
            com.google.android.gms.internal.clearcut.zzbb r6 = (com.google.android.gms.internal.clearcut.zzbb) r6
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzc((int) r15, (com.google.android.gms.internal.clearcut.zzbb) r6)
            goto L_0x042f
        L_0x049f:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
        L_0x04a5:
            java.lang.Object r6 = r2.getObject(r1, r10)
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r4)
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzc((int) r15, (java.lang.Object) r6, (com.google.android.gms.internal.clearcut.zzef) r9)
            goto L_0x042f
        L_0x04b3:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            java.lang.Object r6 = r2.getObject(r1, r10)
            boolean r9 = r6 instanceof com.google.android.gms.internal.clearcut.zzbb
            if (r9 == 0) goto L_0x04c2
        L_0x04c1:
            goto L_0x0498
        L_0x04c2:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzb((int) r15, (java.lang.String) r6)
            goto L_0x042f
        L_0x04ca:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
        L_0x04d0:
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzc((int) r15, (boolean) r7)
            goto L_0x042f
        L_0x04d6:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            r6 = 0
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzj(r15, r6)
            goto L_0x046e
        L_0x04e2:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            r9 = 0
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzg((int) r15, (long) r9)
            goto L_0x042f
        L_0x04f0:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            int r6 = zzg(r1, r10)
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzg((int) r15, (int) r6)
            goto L_0x042f
        L_0x0500:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            long r9 = zzh(r1, r10)
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zze((int) r15, (long) r9)
            goto L_0x042f
        L_0x0510:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            long r9 = zzh(r1, r10)
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzd((int) r15, (long) r9)
            goto L_0x042f
        L_0x0520:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            r6 = 0
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzb((int) r15, (float) r6)
            goto L_0x046e
        L_0x052d:
            boolean r6 = r0.zza(r1, (int) r15, (int) r4)
            if (r6 == 0) goto L_0x0430
            r9 = 0
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzb((int) r15, (double) r9)
            goto L_0x042f
        L_0x053b:
            com.google.android.gms.internal.clearcut.zzdj r6 = r0.zzmz
            java.lang.Object r9 = r2.getObject(r1, r10)
            java.lang.Object r10 = r0.zzae(r4)
            int r6 = r6.zzb(r15, r9, r10)
            goto L_0x042f
        L_0x054b:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r4)
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzd(r15, r6, r9)
            goto L_0x042f
        L_0x055b:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzc(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
        L_0x056b:
            long r9 = (long) r9
            r2.putInt(r1, r9, r6)
        L_0x056f:
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzr(r15)
            int r10 = com.google.android.gms.internal.clearcut.zzbn.zzt(r6)
            int r9 = r9 + r10
            int r9 = r9 + r6
            goto L_0x046e
        L_0x057b:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzg(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x058c:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzi(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x059d:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzh(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x05ae:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzd((java.util.List<java.lang.Integer>) r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x05bf:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzf((java.util.List<java.lang.Integer>) r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x05d0:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzj(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x05e1:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzh(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x05f3:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzi(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x0605:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zze(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x0617:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzb(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x0629:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zza(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x063b:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzh(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x064d:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzi(r6)
            if (r6 <= 0) goto L_0x0430
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x056f
            goto L_0x056b
        L_0x065f:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            r9 = 0
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzq(r15, r6, r9)
        L_0x066a:
            int r5 = r5 + r6
            r6 = r9
            goto L_0x0431
        L_0x066e:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzu(r15, r6, r9)
            goto L_0x066a
        L_0x067a:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzw(r15, r6, r9)
            goto L_0x066a
        L_0x0686:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzv(r15, r6, r9)
            goto L_0x066a
        L_0x0692:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzr(r15, r6, r9)
            goto L_0x066a
        L_0x069e:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzt(r15, r6, r9)
            goto L_0x042f
        L_0x06ab:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzd((int) r15, (java.util.List<com.google.android.gms.internal.clearcut.zzbb>) r6)
            goto L_0x042f
        L_0x06b7:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r4)
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzc((int) r15, (java.util.List<?>) r6, (com.google.android.gms.internal.clearcut.zzef) r9)
            goto L_0x042f
        L_0x06c7:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r6)
            goto L_0x042f
        L_0x06d3:
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            r9 = 0
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzx(r15, r6, r9)
            goto L_0x066a
        L_0x06df:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzs(r15, r6, r9)
            goto L_0x066a
        L_0x06ec:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzp(r15, r6, r9)
            goto L_0x066a
        L_0x06f9:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzo(r15, r6, r9)
            goto L_0x066a
        L_0x0706:
            r9 = 0
            java.lang.Object r6 = r2.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.clearcut.zzeh.zzw(r15, r6, r9)
            goto L_0x042f
        L_0x0713:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            goto L_0x0421
        L_0x0719:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            long r9 = r2.getLong(r1, r10)
            goto L_0x0442
        L_0x0723:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            int r6 = r2.getInt(r1, r10)
            goto L_0x0451
        L_0x072d:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            goto L_0x045c
        L_0x0733:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            goto L_0x0469
        L_0x0739:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            int r6 = r2.getInt(r1, r10)
            goto L_0x047a
        L_0x0743:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            int r6 = r2.getInt(r1, r10)
            goto L_0x0489
        L_0x074d:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            goto L_0x0494
        L_0x0753:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            goto L_0x04a5
        L_0x0759:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            java.lang.Object r6 = r2.getObject(r1, r10)
            boolean r9 = r6 instanceof com.google.android.gms.internal.clearcut.zzbb
            if (r9 == 0) goto L_0x04c2
            goto L_0x04c1
        L_0x0767:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            goto L_0x04d0
        L_0x076d:
            r6 = r12 & r18
            if (r6 == 0) goto L_0x0430
            r6 = 0
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzj(r15, r6)
            int r5 = r5 + r9
            goto L_0x0431
        L_0x0779:
            r6 = 0
            r9 = r12 & r18
            r13 = 0
            if (r9 == 0) goto L_0x0785
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzg((int) r15, (long) r13)
        L_0x0784:
            int r5 = r5 + r9
        L_0x0785:
            r9 = 0
        L_0x0786:
            r10 = 0
            goto L_0x07d6
        L_0x0789:
            r6 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0785
            int r9 = r2.getInt(r1, r10)
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzg((int) r15, (int) r9)
            goto L_0x0784
        L_0x0799:
            r6 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0785
            long r9 = r2.getLong(r1, r10)
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zze((int) r15, (long) r9)
            goto L_0x0784
        L_0x07a9:
            r6 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0785
            long r9 = r2.getLong(r1, r10)
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzd((int) r15, (long) r9)
            goto L_0x0784
        L_0x07b9:
            r6 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0785
            r9 = 0
            int r10 = com.google.android.gms.internal.clearcut.zzbn.zzb((int) r15, (float) r9)
            int r5 = r5 + r10
            goto L_0x0786
        L_0x07c7:
            r6 = 0
            r9 = 0
            r13 = 0
            r10 = r12 & r18
            if (r10 == 0) goto L_0x0786
            r10 = 0
            int r15 = com.google.android.gms.internal.clearcut.zzbn.zzb((int) r15, (double) r10)
            int r5 = r5 + r15
        L_0x07d6:
            int r4 = r4 + 4
            r11 = r6
            r6 = r9
            r9 = r13
            goto L_0x03c9
        L_0x07dd:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r2 = r0.zzmx
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzmo
            if (r2 == 0) goto L_0x07f3
            com.google.android.gms.internal.clearcut.zzbu<?> r2 = r0.zzmy
            com.google.android.gms.internal.clearcut.zzby r1 = r2.zza((java.lang.Object) r1)
            int r1 = r1.zzas()
            int r5 = r5 + r1
        L_0x07f3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zzm(java.lang.Object):int");
    }

    public final boolean zzo(T t) {
        int i;
        int i2;
        T t2 = t;
        int[] iArr = this.zzms;
        int i3 = 1;
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        int length = iArr.length;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = iArr[i5];
            int zzai = zzai(i7);
            int zzag = zzag(zzai);
            if (!this.zzmq) {
                int i8 = this.zzmi[zzai + 2];
                int i9 = i8 & 1048575;
                i2 = i3 << (i8 >>> 20);
                if (i9 != i4) {
                    i = length;
                    i6 = zzmh.getInt(t2, (long) i9);
                    i4 = i9;
                } else {
                    i = length;
                }
            } else {
                i = length;
                i2 = 0;
            }
            if ((268435456 & zzag) != 0 && !zza(t2, zzai, i6, i2)) {
                return false;
            }
            int i10 = (267386880 & zzag) >>> 20;
            if (i10 != 9 && i10 != 17) {
                if (i10 != 27) {
                    if (i10 == 60 || i10 == 68) {
                        if (zza(t2, i7, zzai) && !zza((Object) t2, zzag, zzad(zzai))) {
                            return false;
                        }
                    } else if (i10 != 49) {
                        if (i10 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzh = this.zzmz.zzh(zzfd.zzo(t2, (long) (zzag & 1048575)));
                            if (!zzh.isEmpty()) {
                                if (this.zzmz.zzl(zzae(zzai)).zzmd.zzek() == zzfq.MESSAGE) {
                                    zzef<?> zzef = null;
                                    for (Object next : zzh.values()) {
                                        if (zzef == null) {
                                            zzef = zzea.zzcm().zze(next.getClass());
                                        }
                                        if (!zzef.zzo(next)) {
                                            return false;
                                        }
                                    }
                                    continue;
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                List list = (List) zzfd.zzo(t2, (long) (zzag & 1048575));
                if (!list.isEmpty()) {
                    zzef zzad = zzad(zzai);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzad.zzo(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zza(t2, zzai, i6, i2) && !zza((Object) t2, zzag, zzad(zzai))) {
                return false;
            }
            i5++;
            length = i;
            i3 = 1;
        }
        return !this.zzmo || this.zzmy.zza((Object) t2).isInitialized();
    }

    private static int zza(zzef<?> zzef, int i, byte[] bArr, int i2, int i3, zzcn<?> zzcn, zzay zzay) throws IOException {
        int zza = zza((zzef) zzef, bArr, i2, i3, zzay);
        while (true) {
            zzcn.add(zzay.zzff);
            if (zza >= i3) {
                break;
            }
            int zza2 = zzax.zza(bArr, zza, zzay);
            if (i != zzay.zzfd) {
                break;
            }
            zza = zza((zzef) zzef, bArr, zza2, i3, zzay);
        }
        return zza;
    }

    private final void zzb(T t, int i, int i2) {
        zzfd.zza((Object) t, (long) (zzah(i2) & 1048575), i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.clearcut.zzfd.zzk(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        zzb(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.clearcut.zzfd.zzj(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.clearcut.zzfd.zzo(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f1, code lost:
        r0 = r0 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.clearcut.zzfd.zzo(r8, r2));
        zzb(r7, r4, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(T r7, T r8) {
        /*
            r6 = this;
            r8.getClass()
            r0 = 0
        L_0x0004:
            int[] r1 = r6.zzmi
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00f5
            int r1 = r6.zzag(r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.zzmi
            r4 = r4[r0]
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r1 = r1 & r5
            int r1 = r1 >>> 20
            switch(r1) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00d3;
                case 2: goto L_0x00cc;
                case 3: goto L_0x00c5;
                case 4: goto L_0x00be;
                case 5: goto L_0x00b7;
                case 6: goto L_0x00b0;
                case 7: goto L_0x00a2;
                case 8: goto L_0x009b;
                case 9: goto L_0x004c;
                case 10: goto L_0x008d;
                case 11: goto L_0x0086;
                case 12: goto L_0x007f;
                case 13: goto L_0x0078;
                case 14: goto L_0x0071;
                case 15: goto L_0x0063;
                case 16: goto L_0x0051;
                case 17: goto L_0x004c;
                case 18: goto L_0x0045;
                case 19: goto L_0x0045;
                case 20: goto L_0x0045;
                case 21: goto L_0x0045;
                case 22: goto L_0x0045;
                case 23: goto L_0x0045;
                case 24: goto L_0x0045;
                case 25: goto L_0x0045;
                case 26: goto L_0x0045;
                case 27: goto L_0x0045;
                case 28: goto L_0x0045;
                case 29: goto L_0x0045;
                case 30: goto L_0x0045;
                case 31: goto L_0x0045;
                case 32: goto L_0x0045;
                case 33: goto L_0x0045;
                case 34: goto L_0x0045;
                case 35: goto L_0x0045;
                case 36: goto L_0x0045;
                case 37: goto L_0x0045;
                case 38: goto L_0x0045;
                case 39: goto L_0x0045;
                case 40: goto L_0x0045;
                case 41: goto L_0x0045;
                case 42: goto L_0x0045;
                case 43: goto L_0x0045;
                case 44: goto L_0x0045;
                case 45: goto L_0x0045;
                case 46: goto L_0x0045;
                case 47: goto L_0x0045;
                case 48: goto L_0x0045;
                case 49: goto L_0x0045;
                case 50: goto L_0x003e;
                case 51: goto L_0x0037;
                case 52: goto L_0x0037;
                case 53: goto L_0x0037;
                case 54: goto L_0x0037;
                case 55: goto L_0x0037;
                case 56: goto L_0x0037;
                case 57: goto L_0x0037;
                case 58: goto L_0x0037;
                case 59: goto L_0x0037;
                case 60: goto L_0x0020;
                case 61: goto L_0x0025;
                case 62: goto L_0x0025;
                case 63: goto L_0x0025;
                case 64: goto L_0x0025;
                case 65: goto L_0x0025;
                case 66: goto L_0x0025;
                case 67: goto L_0x0025;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x00f1
        L_0x0020:
            r6.zzb(r7, r8, (int) r0)
            goto L_0x00f1
        L_0x0025:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00f1
        L_0x002b:
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.zzfd.zzo(r8, r2)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            r6.zzb(r7, (int) r4, (int) r0)
            goto L_0x00f1
        L_0x0037:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x002b
        L_0x003e:
            com.google.android.gms.internal.clearcut.zzdj r1 = r6.zzmz
            com.google.android.gms.internal.clearcut.zzeh.zza((com.google.android.gms.internal.clearcut.zzdj) r1, r7, r8, (long) r2)
            goto L_0x00f1
        L_0x0045:
            com.google.android.gms.internal.clearcut.zzcy r1 = r6.zzmw
            r1.zza(r7, r8, r2)
            goto L_0x00f1
        L_0x004c:
            r6.zza(r7, r8, (int) r0)
            goto L_0x00f1
        L_0x0051:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
        L_0x0057:
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r8, r2)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, (long) r2, (long) r4)
        L_0x005e:
            r6.zzb(r7, (int) r0)
            goto L_0x00f1
        L_0x0063:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
        L_0x0069:
            int r1 = com.google.android.gms.internal.clearcut.zzfd.zzj(r8, r2)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, (long) r2, (int) r1)
            goto L_0x005e
        L_0x0071:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0057
        L_0x0078:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0069
        L_0x007f:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0069
        L_0x0086:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0069
        L_0x008d:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
        L_0x0093:
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.zzfd.zzo(r8, r2)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            goto L_0x005e
        L_0x009b:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0093
        L_0x00a2:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            boolean r1 = com.google.android.gms.internal.clearcut.zzfd.zzl(r8, r2)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, (long) r2, (boolean) r1)
            goto L_0x005e
        L_0x00b0:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0069
        L_0x00b7:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0057
        L_0x00be:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0069
        L_0x00c5:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0057
        L_0x00cc:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0057
        L_0x00d3:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            float r1 = com.google.android.gms.internal.clearcut.zzfd.zzm(r8, r2)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, (long) r2, (float) r1)
            goto L_0x005e
        L_0x00e2:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00f1
            double r4 = com.google.android.gms.internal.clearcut.zzfd.zzn(r8, r2)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r7, (long) r2, (double) r4)
            goto L_0x005e
        L_0x00f1:
            int r0 = r0 + 4
            goto L_0x0004
        L_0x00f5:
            boolean r0 = r6.zzmq
            if (r0 != 0) goto L_0x0107
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r6.zzmx
            com.google.android.gms.internal.clearcut.zzeh.zza(r0, r7, r8)
            boolean r0 = r6.zzmo
            if (r0 == 0) goto L_0x0107
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r6.zzmy
            com.google.android.gms.internal.clearcut.zzeh.zza(r0, r7, r8)
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zzc(java.lang.Object, java.lang.Object):void");
    }

    private static int zza(zzef zzef, byte[] bArr, int i, int i2, int i3, zzay zzay) throws IOException {
        zzds zzds = (zzds) zzef;
        Object newInstance = zzds.newInstance();
        int zza = zzds.zza(newInstance, bArr, i, i2, i3, zzay);
        zzds.zzc(newInstance);
        zzay.zzff = newInstance;
        return zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0484, code lost:
        r10 = r10 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x029b, code lost:
        r15 = r14;
     */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.clearcut.zzfr r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzmo
            if (r3 == 0) goto L_0x0021
            com.google.android.gms.internal.clearcut.zzbu<?> r3 = r0.zzmy
            com.google.android.gms.internal.clearcut.zzby r3 = r3.zza((java.lang.Object) r1)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            int[] r6 = r0.zzmi
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzmh
            r9 = -1
            r10 = 0
            r11 = 0
        L_0x002b:
            if (r10 >= r6) goto L_0x0488
            int r12 = r0.zzag(r10)
            int[] r13 = r0.zzmi
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzmq
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x0059
            r4 = 17
            if (r15 > r4) goto L_0x0059
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            if (r13 == r9) goto L_0x0053
            long r8 = (long) r13
            int r11 = r7.getInt(r1, r8)
            r9 = r13
        L_0x0053:
            int r4 = r4 >>> 20
            r8 = 1
            int r4 = r8 << r4
            goto L_0x005a
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r5 == 0) goto L_0x0078
            com.google.android.gms.internal.clearcut.zzbu<?> r8 = r0.zzmy
            int r8 = r8.zza((java.util.Map.Entry<?, ?>) r5)
            if (r8 > r14) goto L_0x0078
            com.google.android.gms.internal.clearcut.zzbu<?> r8 = r0.zzmy
            r8.zza((com.google.android.gms.internal.clearcut.zzfr) r2, (java.util.Map.Entry<?, ?>) r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0076
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x005a
        L_0x0076:
            r5 = 0
            goto L_0x005a
        L_0x0078:
            r8 = r12 & r16
            long r12 = (long) r8
            switch(r15) {
                case 0: goto L_0x0479;
                case 1: goto L_0x046d;
                case 2: goto L_0x0461;
                case 3: goto L_0x0455;
                case 4: goto L_0x0449;
                case 5: goto L_0x043d;
                case 6: goto L_0x0431;
                case 7: goto L_0x0425;
                case 8: goto L_0x0419;
                case 9: goto L_0x0408;
                case 10: goto L_0x03f9;
                case 11: goto L_0x03ec;
                case 12: goto L_0x03df;
                case 13: goto L_0x03d2;
                case 14: goto L_0x03c5;
                case 15: goto L_0x03b8;
                case 16: goto L_0x03ab;
                case 17: goto L_0x039a;
                case 18: goto L_0x038a;
                case 19: goto L_0x037a;
                case 20: goto L_0x036a;
                case 21: goto L_0x035a;
                case 22: goto L_0x034a;
                case 23: goto L_0x033a;
                case 24: goto L_0x032a;
                case 25: goto L_0x031a;
                case 26: goto L_0x030b;
                case 27: goto L_0x02f8;
                case 28: goto L_0x02e9;
                case 29: goto L_0x02da;
                case 30: goto L_0x02cb;
                case 31: goto L_0x02bc;
                case 32: goto L_0x02ad;
                case 33: goto L_0x029e;
                case 34: goto L_0x028d;
                case 35: goto L_0x027d;
                case 36: goto L_0x026d;
                case 37: goto L_0x025d;
                case 38: goto L_0x024d;
                case 39: goto L_0x023d;
                case 40: goto L_0x022d;
                case 41: goto L_0x021d;
                case 42: goto L_0x020d;
                case 43: goto L_0x01fd;
                case 44: goto L_0x01ed;
                case 45: goto L_0x01dd;
                case 46: goto L_0x01cd;
                case 47: goto L_0x01bd;
                case 48: goto L_0x01ad;
                case 49: goto L_0x019a;
                case 50: goto L_0x0191;
                case 51: goto L_0x0182;
                case 52: goto L_0x0173;
                case 53: goto L_0x0164;
                case 54: goto L_0x0155;
                case 55: goto L_0x0146;
                case 56: goto L_0x0137;
                case 57: goto L_0x0128;
                case 58: goto L_0x0119;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f7;
                case 61: goto L_0x00e7;
                case 62: goto L_0x00d9;
                case 63: goto L_0x00cb;
                case 64: goto L_0x00bd;
                case 65: goto L_0x00af;
                case 66: goto L_0x00a1;
                case 67: goto L_0x0093;
                case 68: goto L_0x0081;
                default: goto L_0x007e;
            }
        L_0x007e:
            r15 = 0
            goto L_0x0484
        L_0x0081:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.zzef r8 = r0.zzad(r10)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.zzef) r8)
            goto L_0x007e
        L_0x0093:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            long r12 = zzh(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x007e
        L_0x00a1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            int r4 = zzg(r1, r12)
            r2.zze(r14, r4)
            goto L_0x007e
        L_0x00af:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            long r12 = zzh(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x007e
        L_0x00bd:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            int r4 = zzg(r1, r12)
            r2.zzm(r14, r4)
            goto L_0x007e
        L_0x00cb:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            int r4 = zzg(r1, r12)
            r2.zzn(r14, r4)
            goto L_0x007e
        L_0x00d9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            int r4 = zzg(r1, r12)
            r2.zzd(r14, r4)
            goto L_0x007e
        L_0x00e7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.zzbb r4 = (com.google.android.gms.internal.clearcut.zzbb) r4
            r2.zza((int) r14, (com.google.android.gms.internal.clearcut.zzbb) r4)
            goto L_0x007e
        L_0x00f7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.zzef r8 = r0.zzad(r10)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.zzef) r8)
            goto L_0x007e
        L_0x010a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            java.lang.Object r4 = r7.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.zzfr) r2)
            goto L_0x007e
        L_0x0119:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            boolean r4 = zzi(r1, r12)
            r2.zzb((int) r14, (boolean) r4)
            goto L_0x007e
        L_0x0128:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            int r4 = zzg(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x007e
        L_0x0137:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            long r12 = zzh(r1, r12)
            r2.zzc((int) r14, (long) r12)
            goto L_0x007e
        L_0x0146:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            int r4 = zzg(r1, r12)
            r2.zzc((int) r14, (int) r4)
            goto L_0x007e
        L_0x0155:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            long r12 = zzh(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x007e
        L_0x0164:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            long r12 = zzh(r1, r12)
            r2.zzi(r14, r12)
            goto L_0x007e
        L_0x0173:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            float r4 = zzf(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x007e
        L_0x0182:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x007e
            double r12 = zze(r1, r12)
            r2.zza((int) r14, (double) r12)
            goto L_0x007e
        L_0x0191:
            java.lang.Object r4 = r7.getObject(r1, r12)
            r0.zza((com.google.android.gms.internal.clearcut.zzfr) r2, (int) r14, (java.lang.Object) r4, (int) r10)
            goto L_0x007e
        L_0x019a:
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzef r12 = r0.zzad(r10)
            com.google.android.gms.internal.clearcut.zzeh.zzb((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.clearcut.zzfr) r2, (com.google.android.gms.internal.clearcut.zzef) r12)
            goto L_0x007e
        L_0x01ad:
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r14 = 1
            com.google.android.gms.internal.clearcut.zzeh.zze(r4, r8, r2, r14)
            goto L_0x007e
        L_0x01bd:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzj(r4, r8, r2, r14)
            goto L_0x007e
        L_0x01cd:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzg(r4, r8, r2, r14)
            goto L_0x007e
        L_0x01dd:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzl(r4, r8, r2, r14)
            goto L_0x007e
        L_0x01ed:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzm(r4, r8, r2, r14)
            goto L_0x007e
        L_0x01fd:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzi(r4, r8, r2, r14)
            goto L_0x007e
        L_0x020d:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzn(r4, r8, r2, r14)
            goto L_0x007e
        L_0x021d:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzk(r4, r8, r2, r14)
            goto L_0x007e
        L_0x022d:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzf(r4, r8, r2, r14)
            goto L_0x007e
        L_0x023d:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzh(r4, r8, r2, r14)
            goto L_0x007e
        L_0x024d:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r8, r2, r14)
            goto L_0x007e
        L_0x025d:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzc(r4, r8, r2, r14)
            goto L_0x007e
        L_0x026d:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.clearcut.zzfr) r2, (boolean) r14)
            goto L_0x007e
        L_0x027d:
            r14 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.clearcut.zzfr) r2, (boolean) r14)
            goto L_0x007e
        L_0x028d:
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r14 = 0
            com.google.android.gms.internal.clearcut.zzeh.zze(r4, r8, r2, r14)
        L_0x029b:
            r15 = r14
            goto L_0x0484
        L_0x029e:
            r14 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzj(r4, r8, r2, r14)
            goto L_0x029b
        L_0x02ad:
            r14 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzg(r4, r8, r2, r14)
            goto L_0x029b
        L_0x02bc:
            r14 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzl(r4, r8, r2, r14)
            goto L_0x029b
        L_0x02cb:
            r14 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzm(r4, r8, r2, r14)
            goto L_0x029b
        L_0x02da:
            r14 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzi(r4, r8, r2, r14)
            goto L_0x029b
        L_0x02e9:
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzb(r4, r8, r2)
            goto L_0x007e
        L_0x02f8:
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzef r12 = r0.zzad(r10)
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.clearcut.zzfr) r2, (com.google.android.gms.internal.clearcut.zzef) r12)
            goto L_0x007e
        L_0x030b:
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r4, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.clearcut.zzfr) r2)
            goto L_0x007e
        L_0x031a:
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.clearcut.zzeh.zzn(r4, r8, r2, r15)
            goto L_0x0484
        L_0x032a:
            r15 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzk(r4, r8, r2, r15)
            goto L_0x0484
        L_0x033a:
            r15 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzf(r4, r8, r2, r15)
            goto L_0x0484
        L_0x034a:
            r15 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzh(r4, r8, r2, r15)
            goto L_0x0484
        L_0x035a:
            r15 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r8, r2, r15)
            goto L_0x0484
        L_0x036a:
            r15 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzc(r4, r8, r2, r15)
            goto L_0x0484
        L_0x037a:
            r15 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.clearcut.zzfr) r2, (boolean) r15)
            goto L_0x0484
        L_0x038a:
            r15 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.clearcut.zzfr) r2, (boolean) r15)
            goto L_0x0484
        L_0x039a:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.zzef r8 = r0.zzad(r10)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.zzef) r8)
            goto L_0x0484
        L_0x03ab:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            long r12 = r7.getLong(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x0484
        L_0x03b8:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            int r4 = r7.getInt(r1, r12)
            r2.zze(r14, r4)
            goto L_0x0484
        L_0x03c5:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            long r12 = r7.getLong(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x0484
        L_0x03d2:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            int r4 = r7.getInt(r1, r12)
            r2.zzm(r14, r4)
            goto L_0x0484
        L_0x03df:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            int r4 = r7.getInt(r1, r12)
            r2.zzn(r14, r4)
            goto L_0x0484
        L_0x03ec:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            int r4 = r7.getInt(r1, r12)
            r2.zzd(r14, r4)
            goto L_0x0484
        L_0x03f9:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.zzbb r4 = (com.google.android.gms.internal.clearcut.zzbb) r4
            r2.zza((int) r14, (com.google.android.gms.internal.clearcut.zzbb) r4)
            goto L_0x0484
        L_0x0408:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.clearcut.zzef r8 = r0.zzad(r10)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.zzef) r8)
            goto L_0x0484
        L_0x0419:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            java.lang.Object r4 = r7.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.zzfr) r2)
            goto L_0x0484
        L_0x0425:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            boolean r4 = com.google.android.gms.internal.clearcut.zzfd.zzl(r1, r12)
            r2.zzb((int) r14, (boolean) r4)
            goto L_0x0484
        L_0x0431:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            int r4 = r7.getInt(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x0484
        L_0x043d:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            long r12 = r7.getLong(r1, r12)
            r2.zzc((int) r14, (long) r12)
            goto L_0x0484
        L_0x0449:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            int r4 = r7.getInt(r1, r12)
            r2.zzc((int) r14, (int) r4)
            goto L_0x0484
        L_0x0455:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            long r12 = r7.getLong(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x0484
        L_0x0461:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            long r12 = r7.getLong(r1, r12)
            r2.zzi(r14, r12)
            goto L_0x0484
        L_0x046d:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            float r4 = com.google.android.gms.internal.clearcut.zzfd.zzm(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x0484
        L_0x0479:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0484
            double r12 = com.google.android.gms.internal.clearcut.zzfd.zzn(r1, r12)
            r2.zza((int) r14, (double) r12)
        L_0x0484:
            int r10 = r10 + 4
            goto L_0x002b
        L_0x0488:
            if (r5 == 0) goto L_0x049f
            com.google.android.gms.internal.clearcut.zzbu<?> r4 = r0.zzmy
            r4.zza((com.google.android.gms.internal.clearcut.zzfr) r2, (java.util.Map.Entry<?, ?>) r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x049d
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x0488
        L_0x049d:
            r5 = 0
            goto L_0x0488
        L_0x049f:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r3 = r0.zzmx
            zza(r3, r1, (com.google.android.gms.internal.clearcut.zzfr) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zzb(java.lang.Object, com.google.android.gms.internal.clearcut.zzfr):void");
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(com.google.android.gms.internal.clearcut.zzef r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.clearcut.zzay r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.clearcut.zzay) r10)
            int r8 = r10.zzfd
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzc(r9)
            r10.zzff = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.clearcut.zzco r6 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(com.google.android.gms.internal.clearcut.zzef, byte[], int, int, com.google.android.gms.internal.clearcut.zzay):int");
    }

    private final void zzb(T t, T t2, int i) {
        int zzag = zzag(i);
        int i2 = this.zzmi[i];
        long j = (long) (zzag & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzfd.zzo(t, j);
            Object zzo2 = zzfd.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zzfd.zza((Object) t, j, zzci.zza(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zzfd.zza((Object) t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    private static <UT, UB> int zza(zzex<UT, UB> zzex, T t) {
        return zzex.zzm(zzex.zzq(t));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0073, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b1, code lost:
        r12.putObject(r1, r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bc, code lost:
        r2 = r2 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bd, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0130, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0141, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.clearcut.zzay r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzmh
            int[] r7 = r0.zzmi
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0167;
                case 52: goto L_0x015c;
                case 53: goto L_0x0152;
                case 54: goto L_0x0152;
                case 55: goto L_0x0148;
                case 56: goto L_0x0136;
                case 57: goto L_0x0126;
                case 58: goto L_0x0110;
                case 59: goto L_0x00e4;
                case 60: goto L_0x00c2;
                case 61: goto L_0x00a5;
                case 62: goto L_0x0148;
                case 63: goto L_0x0078;
                case 64: goto L_0x0126;
                case 65: goto L_0x0136;
                case 66: goto L_0x0067;
                case 67: goto L_0x0056;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x0173
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x0173
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.clearcut.zzef r2 = r0.zzad(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = zza((com.google.android.gms.internal.clearcut.zzef) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.clearcut.zzay) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            java.lang.Object r3 = r11.zzff
            if (r15 != 0) goto L_0x0051
            goto L_0x00b1
        L_0x0051:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzci.zza((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x00b1
        L_0x0056:
            if (r5 != 0) goto L_0x0173
            int r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r11)
            long r3 = r11.zzfe
            long r3 = com.google.android.gms.internal.clearcut.zzbk.zza(r3)
        L_0x0062:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            goto L_0x00b1
        L_0x0067:
            if (r5 != 0) goto L_0x0173
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11)
            int r3 = r11.zzfd
            int r3 = com.google.android.gms.internal.clearcut.zzbk.zzm(r3)
        L_0x0073:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00b1
        L_0x0078:
            if (r5 != 0) goto L_0x0173
            int r3 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11)
            int r4 = r11.zzfd
            com.google.android.gms.internal.clearcut.zzck r5 = r0.zzaf(r6)
            if (r5 == 0) goto L_0x009c
            com.google.android.gms.internal.clearcut.zzcj r5 = r5.zzb(r4)
            if (r5 == 0) goto L_0x008d
            goto L_0x009c
        L_0x008d:
            com.google.android.gms.internal.clearcut.zzey r1 = zzn(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzb(r2, r4)
            r2 = r3
            goto L_0x0174
        L_0x009c:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x00bd
        L_0x00a5:
            if (r5 != r15) goto L_0x0173
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11)
            int r4 = r11.zzfd
            if (r4 != 0) goto L_0x00b5
            com.google.android.gms.internal.clearcut.zzbb r3 = com.google.android.gms.internal.clearcut.zzbb.zzfi
        L_0x00b1:
            r12.putObject(r1, r9, r3)
            goto L_0x00bd
        L_0x00b5:
            com.google.android.gms.internal.clearcut.zzbb r3 = com.google.android.gms.internal.clearcut.zzbb.zzb((byte[]) r3, (int) r2, (int) r4)
            r12.putObject(r1, r9, r3)
        L_0x00bc:
            int r2 = r2 + r4
        L_0x00bd:
            r12.putInt(r1, r13, r8)
            goto L_0x0174
        L_0x00c2:
            if (r5 != r15) goto L_0x0173
            com.google.android.gms.internal.clearcut.zzef r2 = r0.zzad(r6)
            r5 = r20
            int r2 = zza((com.google.android.gms.internal.clearcut.zzef) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.clearcut.zzay) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00d9
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00da
        L_0x00d9:
            r15 = 0
        L_0x00da:
            java.lang.Object r3 = r11.zzff
            if (r15 != 0) goto L_0x00df
        L_0x00de:
            goto L_0x00b1
        L_0x00df:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzci.zza((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x00de
        L_0x00e4:
            if (r5 != r15) goto L_0x0173
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11)
            int r4 = r11.zzfd
            if (r4 != 0) goto L_0x00f1
            java.lang.String r3 = ""
            goto L_0x00b1
        L_0x00f1:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0105
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.clearcut.zzff.zze((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x0100
            goto L_0x0105
        L_0x0100:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbp()
            throw r1
        L_0x0105:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.clearcut.zzci.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            goto L_0x00bc
        L_0x0110:
            if (r5 != 0) goto L_0x0173
            int r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r11)
            long r3 = r11.zzfe
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0120
            r15 = 1
            goto L_0x0121
        L_0x0120:
            r15 = 0
        L_0x0121:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            goto L_0x00b1
        L_0x0126:
            if (r5 != r7) goto L_0x0173
            int r2 = com.google.android.gms.internal.clearcut.zzax.zzc(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0130:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x00bd
        L_0x0136:
            r2 = 1
            if (r5 != r2) goto L_0x0173
            long r2 = com.google.android.gms.internal.clearcut.zzax.zzd(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
        L_0x0141:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
            goto L_0x00bd
        L_0x0148:
            if (r5 != 0) goto L_0x0173
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11)
            int r3 = r11.zzfd
            goto L_0x0073
        L_0x0152:
            if (r5 != 0) goto L_0x0173
            int r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r11)
            long r3 = r11.zzfe
            goto L_0x0062
        L_0x015c:
            if (r5 != r7) goto L_0x0173
            float r2 = com.google.android.gms.internal.clearcut.zzax.zzf(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            goto L_0x0130
        L_0x0167:
            r2 = 1
            if (r5 != r2) goto L_0x0173
            double r2 = com.google.android.gms.internal.clearcut.zzax.zze(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            goto L_0x0141
        L_0x0173:
            r2 = r4
        L_0x0174:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.clearcut.zzay):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0235, code lost:
        if (r7.zzfe != 0) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0237, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0239, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x023a, code lost:
        r12.addBoolean(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x023d, code lost:
        if (r4 >= r5) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x023f, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0245, code lost:
        if (r2 != r7.zzfd) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0247, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x024f, code lost:
        if (r7.zzfe == 0) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0139, code lost:
        if (r4 == 0) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013b, code lost:
        r12.add(com.google.android.gms.internal.clearcut.zzbb.zzfi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0141, code lost:
        r12.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0149, code lost:
        if (r1 >= r5) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014b, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0151, code lost:
        if (r2 != r7.zzfd) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0153, code lost:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7);
        r4 = r7.zzfd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0159, code lost:
        if (r4 != 0) goto L_0x0141;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.clearcut.zzay r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzmh
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.clearcut.zzcn r12 = (com.google.android.gms.internal.clearcut.zzcn) r12
            boolean r13 = r12.zzu()
            r14 = 1
            if (r13 != 0) goto L_0x0033
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002b
            r13 = 10
            goto L_0x002c
        L_0x002b:
            int r13 = r13 << r14
        L_0x002c:
            com.google.android.gms.internal.clearcut.zzcn r12 = r12.zzi(r13)
            r11.putObject(r1, r9, r12)
        L_0x0033:
            r9 = 5
            r10 = 0
            r13 = 2
            switch(r26) {
                case 18: goto L_0x0360;
                case 19: goto L_0x0322;
                case 20: goto L_0x02ea;
                case 21: goto L_0x02ea;
                case 22: goto L_0x02d0;
                case 23: goto L_0x0291;
                case 24: goto L_0x0252;
                case 25: goto L_0x0201;
                case 26: goto L_0x0176;
                case 27: goto L_0x015c;
                case 28: goto L_0x0131;
                case 29: goto L_0x02d0;
                case 30: goto L_0x00f9;
                case 31: goto L_0x0252;
                case 32: goto L_0x0291;
                case 33: goto L_0x00b9;
                case 34: goto L_0x0079;
                case 35: goto L_0x0360;
                case 36: goto L_0x0322;
                case 37: goto L_0x02ea;
                case 38: goto L_0x02ea;
                case 39: goto L_0x02d0;
                case 40: goto L_0x0291;
                case 41: goto L_0x0252;
                case 42: goto L_0x0201;
                case 43: goto L_0x02d0;
                case 44: goto L_0x00f9;
                case 45: goto L_0x0252;
                case 46: goto L_0x0291;
                case 47: goto L_0x00b9;
                case 48: goto L_0x0079;
                case 49: goto L_0x003b;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0076
        L_0x003b:
            r1 = 3
            if (r6 != r1) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzef r1 = r15.zzad(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = zza((com.google.android.gms.internal.clearcut.zzef) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.google.android.gms.internal.clearcut.zzay) r26)
        L_0x0056:
            java.lang.Object r8 = r7.zzff
            r12.add(r8)
            if (r4 >= r5) goto L_0x0076
            int r8 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r9 = r7.zzfd
            if (r2 != r9) goto L_0x0076
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = zza((com.google.android.gms.internal.clearcut.zzef) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.google.android.gms.internal.clearcut.zzay) r26)
            goto L_0x0056
        L_0x0076:
            r1 = r4
            goto L_0x039e
        L_0x0079:
            if (r6 != r13) goto L_0x009d
            com.google.android.gms.internal.clearcut.zzdc r12 = (com.google.android.gms.internal.clearcut.zzdc) r12
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x0084:
            if (r1 >= r2) goto L_0x0094
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r1, r7)
            long r4 = r7.zzfe
            long r4 = com.google.android.gms.internal.clearcut.zzbk.zza(r4)
            r12.zzm(r4)
            goto L_0x0084
        L_0x0094:
            if (r1 != r2) goto L_0x0098
            goto L_0x039e
        L_0x0098:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x009d:
            if (r6 != 0) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzdc r12 = (com.google.android.gms.internal.clearcut.zzdc) r12
        L_0x00a1:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r7)
            long r8 = r7.zzfe
            long r8 = com.google.android.gms.internal.clearcut.zzbk.zza(r8)
            r12.zzm(r8)
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039e
            goto L_0x00a1
        L_0x00b9:
            if (r6 != r13) goto L_0x00dd
            com.google.android.gms.internal.clearcut.zzch r12 = (com.google.android.gms.internal.clearcut.zzch) r12
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x00c4:
            if (r1 >= r2) goto L_0x00d4
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r4 = r7.zzfd
            int r4 = com.google.android.gms.internal.clearcut.zzbk.zzm(r4)
            r12.zzac(r4)
            goto L_0x00c4
        L_0x00d4:
            if (r1 != r2) goto L_0x00d8
            goto L_0x039e
        L_0x00d8:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x00dd:
            if (r6 != 0) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzch r12 = (com.google.android.gms.internal.clearcut.zzch) r12
        L_0x00e1:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            int r4 = com.google.android.gms.internal.clearcut.zzbk.zzm(r4)
            r12.zzac(r4)
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039e
            goto L_0x00e1
        L_0x00f9:
            if (r6 != r13) goto L_0x0100
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.clearcut.zzcn<?>) r12, (com.google.android.gms.internal.clearcut.zzay) r7)
            goto L_0x0111
        L_0x0100:
            if (r6 != 0) goto L_0x0076
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.clearcut.zzcn<?>) r6, (com.google.android.gms.internal.clearcut.zzay) r7)
        L_0x0111:
            com.google.android.gms.internal.clearcut.zzcg r1 = (com.google.android.gms.internal.clearcut.zzcg) r1
            com.google.android.gms.internal.clearcut.zzey r3 = r1.zzjp
            com.google.android.gms.internal.clearcut.zzey r4 = com.google.android.gms.internal.clearcut.zzey.zzea()
            if (r3 != r4) goto L_0x011c
            r3 = 0
        L_0x011c:
            com.google.android.gms.internal.clearcut.zzck r4 = r15.zzaf(r8)
            com.google.android.gms.internal.clearcut.zzex<?, ?> r5 = r0.zzmx
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzeh.zza(r6, r12, r4, r3, r5)
            com.google.android.gms.internal.clearcut.zzey r3 = (com.google.android.gms.internal.clearcut.zzey) r3
            if (r3 == 0) goto L_0x012e
            r1.zzjp = r3
        L_0x012e:
            r1 = r2
            goto L_0x039e
        L_0x0131:
            if (r6 != r13) goto L_0x0076
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            if (r4 != 0) goto L_0x0141
        L_0x013b:
            com.google.android.gms.internal.clearcut.zzbb r4 = com.google.android.gms.internal.clearcut.zzbb.zzfi
            r12.add(r4)
            goto L_0x0149
        L_0x0141:
            com.google.android.gms.internal.clearcut.zzbb r6 = com.google.android.gms.internal.clearcut.zzbb.zzb((byte[]) r3, (int) r1, (int) r4)
            r12.add(r6)
            int r1 = r1 + r4
        L_0x0149:
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039e
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            if (r4 != 0) goto L_0x0141
            goto L_0x013b
        L_0x015c:
            if (r6 != r13) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzef r1 = r15.zzad(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = zza((com.google.android.gms.internal.clearcut.zzef<?>) r21, (int) r22, (byte[]) r23, (int) r24, (int) r25, (com.google.android.gms.internal.clearcut.zzcn<?>) r26, (com.google.android.gms.internal.clearcut.zzay) r27)
            goto L_0x039e
        L_0x0176:
            if (r6 != r13) goto L_0x0076
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01b5
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            if (r4 != 0) goto L_0x018f
        L_0x018b:
            r12.add(r6)
            goto L_0x019a
        L_0x018f:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.clearcut.zzci.UTF_8
            r8.<init>(r3, r1, r4, r9)
        L_0x0196:
            r12.add(r8)
            int r1 = r1 + r4
        L_0x019a:
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r8 = r7.zzfd
            if (r2 != r8) goto L_0x039e
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            if (r4 != 0) goto L_0x01ad
            goto L_0x018b
        L_0x01ad:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.clearcut.zzci.UTF_8
            r8.<init>(r3, r1, r4, r9)
            goto L_0x0196
        L_0x01b5:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            if (r4 != 0) goto L_0x01c1
        L_0x01bd:
            r12.add(r6)
            goto L_0x01d4
        L_0x01c1:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.clearcut.zzff.zze((byte[]) r3, (int) r1, (int) r8)
            if (r9 == 0) goto L_0x01fc
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.clearcut.zzci.UTF_8
            r9.<init>(r3, r1, r4, r10)
        L_0x01d0:
            r12.add(r9)
            r1 = r8
        L_0x01d4:
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r8 = r7.zzfd
            if (r2 != r8) goto L_0x039e
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            if (r4 != 0) goto L_0x01e7
            goto L_0x01bd
        L_0x01e7:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.clearcut.zzff.zze((byte[]) r3, (int) r1, (int) r8)
            if (r9 == 0) goto L_0x01f7
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.clearcut.zzci.UTF_8
            r9.<init>(r3, r1, r4, r10)
            goto L_0x01d0
        L_0x01f7:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbp()
            throw r1
        L_0x01fc:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbp()
            throw r1
        L_0x0201:
            r1 = 0
            if (r6 != r13) goto L_0x0229
            com.google.android.gms.internal.clearcut.zzaz r12 = (com.google.android.gms.internal.clearcut.zzaz) r12
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            int r4 = r4 + r2
        L_0x020d:
            if (r2 >= r4) goto L_0x0220
            int r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r2, r7)
            long r5 = r7.zzfe
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x021b
            r5 = r14
            goto L_0x021c
        L_0x021b:
            r5 = r1
        L_0x021c:
            r12.addBoolean(r5)
            goto L_0x020d
        L_0x0220:
            if (r2 != r4) goto L_0x0224
            goto L_0x012e
        L_0x0224:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x0229:
            if (r6 != 0) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzaz r12 = (com.google.android.gms.internal.clearcut.zzaz) r12
            int r4 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r7)
            long r8 = r7.zzfe
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0239
        L_0x0237:
            r6 = r14
            goto L_0x023a
        L_0x0239:
            r6 = r1
        L_0x023a:
            r12.addBoolean(r6)
            if (r4 >= r5) goto L_0x0076
            int r6 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r8 = r7.zzfd
            if (r2 != r8) goto L_0x0076
            int r4 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r6, r7)
            long r8 = r7.zzfe
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0239
            goto L_0x0237
        L_0x0252:
            if (r6 != r13) goto L_0x0272
            com.google.android.gms.internal.clearcut.zzch r12 = (com.google.android.gms.internal.clearcut.zzch) r12
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x025d:
            if (r1 >= r2) goto L_0x0269
            int r4 = com.google.android.gms.internal.clearcut.zzax.zzc(r3, r1)
            r12.zzac(r4)
            int r1 = r1 + 4
            goto L_0x025d
        L_0x0269:
            if (r1 != r2) goto L_0x026d
            goto L_0x039e
        L_0x026d:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x0272:
            if (r6 != r9) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzch r12 = (com.google.android.gms.internal.clearcut.zzch) r12
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzc(r17, r18)
            r12.zzac(r1)
        L_0x027d:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039e
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzc(r3, r4)
            r12.zzac(r1)
            goto L_0x027d
        L_0x0291:
            if (r6 != r13) goto L_0x02b1
            com.google.android.gms.internal.clearcut.zzdc r12 = (com.google.android.gms.internal.clearcut.zzdc) r12
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x029c:
            if (r1 >= r2) goto L_0x02a8
            long r4 = com.google.android.gms.internal.clearcut.zzax.zzd(r3, r1)
            r12.zzm(r4)
            int r1 = r1 + 8
            goto L_0x029c
        L_0x02a8:
            if (r1 != r2) goto L_0x02ac
            goto L_0x039e
        L_0x02ac:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x02b1:
            if (r6 != r14) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzdc r12 = (com.google.android.gms.internal.clearcut.zzdc) r12
            long r8 = com.google.android.gms.internal.clearcut.zzax.zzd(r17, r18)
            r12.zzm(r8)
        L_0x02bc:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039e
            long r8 = com.google.android.gms.internal.clearcut.zzax.zzd(r3, r4)
            r12.zzm(r8)
            goto L_0x02bc
        L_0x02d0:
            if (r6 != r13) goto L_0x02d8
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.clearcut.zzcn<?>) r12, (com.google.android.gms.internal.clearcut.zzay) r7)
            goto L_0x039e
        L_0x02d8:
            if (r6 != 0) goto L_0x0076
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza((int) r20, (byte[]) r21, (int) r22, (int) r23, (com.google.android.gms.internal.clearcut.zzcn<?>) r24, (com.google.android.gms.internal.clearcut.zzay) r25)
            goto L_0x039e
        L_0x02ea:
            if (r6 != r13) goto L_0x030a
            com.google.android.gms.internal.clearcut.zzdc r12 = (com.google.android.gms.internal.clearcut.zzdc) r12
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x02f5:
            if (r1 >= r2) goto L_0x0301
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r1, r7)
            long r4 = r7.zzfe
            r12.zzm(r4)
            goto L_0x02f5
        L_0x0301:
            if (r1 != r2) goto L_0x0305
            goto L_0x039e
        L_0x0305:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x030a:
            if (r6 != 0) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzdc r12 = (com.google.android.gms.internal.clearcut.zzdc) r12
        L_0x030e:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r7)
            long r8 = r7.zzfe
            r12.zzm(r8)
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039e
            goto L_0x030e
        L_0x0322:
            if (r6 != r13) goto L_0x0341
            com.google.android.gms.internal.clearcut.zzce r12 = (com.google.android.gms.internal.clearcut.zzce) r12
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x032d:
            if (r1 >= r2) goto L_0x0339
            float r4 = com.google.android.gms.internal.clearcut.zzax.zzf(r3, r1)
            r12.zzc(r4)
            int r1 = r1 + 4
            goto L_0x032d
        L_0x0339:
            if (r1 != r2) goto L_0x033c
            goto L_0x039e
        L_0x033c:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x0341:
            if (r6 != r9) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzce r12 = (com.google.android.gms.internal.clearcut.zzce) r12
            float r1 = com.google.android.gms.internal.clearcut.zzax.zzf(r17, r18)
            r12.zzc(r1)
        L_0x034c:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039e
            float r1 = com.google.android.gms.internal.clearcut.zzax.zzf(r3, r4)
            r12.zzc(r1)
            goto L_0x034c
        L_0x0360:
            if (r6 != r13) goto L_0x037f
            com.google.android.gms.internal.clearcut.zzbq r12 = (com.google.android.gms.internal.clearcut.zzbq) r12
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x036b:
            if (r1 >= r2) goto L_0x0377
            double r4 = com.google.android.gms.internal.clearcut.zzax.zze(r3, r1)
            r12.zzc(r4)
            int r1 = r1 + 8
            goto L_0x036b
        L_0x0377:
            if (r1 != r2) goto L_0x037a
            goto L_0x039e
        L_0x037a:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x037f:
            if (r6 != r14) goto L_0x0076
            com.google.android.gms.internal.clearcut.zzbq r12 = (com.google.android.gms.internal.clearcut.zzbq) r12
            double r8 = com.google.android.gms.internal.clearcut.zzax.zze(r17, r18)
            r12.zzc(r8)
        L_0x038a:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x039e
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039e
            double r8 = com.google.android.gms.internal.clearcut.zzax.zze(r3, r4)
            r12.zzc(r8)
            goto L_0x038a
        L_0x039e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.clearcut.zzay):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r7, byte[] r8, int r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.clearcut.zzay r15) throws java.io.IOException {
        /*
            r6 = this;
            sun.misc.Unsafe r12 = zzmh
            java.lang.Object r11 = r6.zzae(r11)
            java.lang.Object r0 = r12.getObject(r7, r13)
            com.google.android.gms.internal.clearcut.zzdj r1 = r6.zzmz
            boolean r1 = r1.zzi(r0)
            if (r1 == 0) goto L_0x0021
            com.google.android.gms.internal.clearcut.zzdj r1 = r6.zzmz
            java.lang.Object r1 = r1.zzk(r11)
            com.google.android.gms.internal.clearcut.zzdj r2 = r6.zzmz
            r2.zzb(r1, r0)
            r12.putObject(r7, r13, r1)
            r0 = r1
        L_0x0021:
            com.google.android.gms.internal.clearcut.zzdj r7 = r6.zzmz
            com.google.android.gms.internal.clearcut.zzdh r7 = r7.zzl(r11)
            com.google.android.gms.internal.clearcut.zzdj r11 = r6.zzmz
            java.util.Map r11 = r11.zzg(r0)
            int r9 = com.google.android.gms.internal.clearcut.zzax.zza(r8, r9, r15)
            int r12 = r15.zzfd
            if (r12 < 0) goto L_0x0097
            int r13 = r10 - r9
            if (r12 > r13) goto L_0x0097
            int r12 = r12 + r9
            K r13 = r7.zzmc
            V r14 = r7.zzdu
        L_0x003e:
            if (r9 >= r12) goto L_0x008c
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x004c
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza((int) r9, (byte[]) r8, (int) r0, (com.google.android.gms.internal.clearcut.zzay) r15)
            int r9 = r15.zzfd
        L_0x004c:
            r1 = r0
            int r0 = r9 >>> 3
            r2 = r9 & 7
            r3 = 1
            if (r0 == r3) goto L_0x0072
            r3 = 2
            if (r0 == r3) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.clearcut.zzfl r0 = r7.zzmd
            int r0 = r0.zzel()
            if (r2 != r0) goto L_0x0087
            com.google.android.gms.internal.clearcut.zzfl r3 = r7.zzmd
            V r9 = r7.zzdu
            java.lang.Class r4 = r9.getClass()
            r0 = r8
            r2 = r10
            r5 = r15
            int r9 = zza((byte[]) r0, (int) r1, (int) r2, (com.google.android.gms.internal.clearcut.zzfl) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.clearcut.zzay) r5)
            java.lang.Object r14 = r15.zzff
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.clearcut.zzfl r0 = r7.zzmb
            int r0 = r0.zzel()
            if (r2 != r0) goto L_0x0087
            com.google.android.gms.internal.clearcut.zzfl r3 = r7.zzmb
            r4 = 0
            r0 = r8
            r2 = r10
            r5 = r15
            int r9 = zza((byte[]) r0, (int) r1, (int) r2, (com.google.android.gms.internal.clearcut.zzfl) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.clearcut.zzay) r5)
            java.lang.Object r13 = r15.zzff
            goto L_0x003e
        L_0x0087:
            int r9 = com.google.android.gms.internal.clearcut.zzax.zza(r9, r8, r1, r10, r15)
            goto L_0x003e
        L_0x008c:
            if (r9 != r12) goto L_0x0092
            r11.put(r13, r14)
            return r12
        L_0x0092:
            com.google.android.gms.internal.clearcut.zzco r7 = com.google.android.gms.internal.clearcut.zzco.zzbo()
            throw r7
        L_0x0097:
            com.google.android.gms.internal.clearcut.zzco r7 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, int, long, com.google.android.gms.internal.clearcut.zzay):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02f5, code lost:
        if (r0 == r15) goto L_0x02f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0302, code lost:
        r15 = r26;
        r14 = r27;
        r12 = r28;
        r1 = r29;
        r13 = r30;
        r11 = r31;
        r9 = r32;
        r7 = r19;
        r6 = r20;
        r10 = r25;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0346, code lost:
        if (r0 == r15) goto L_0x02f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0362, code lost:
        if (r0 == r15) goto L_0x02f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        r5 = r4;
        r29 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ac, code lost:
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ae, code lost:
        r1 = r9;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b0, code lost:
        r11 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b8, code lost:
        r12 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f4, code lost:
        r6 = r6 | r20;
        r13 = r30;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x016b, code lost:
        r6 = r6 | r20;
        r7 = r29;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0170, code lost:
        r1 = r9;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0172, code lost:
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0177, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0199, code lost:
        r10.putObject(r14, r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01f3, code lost:
        r6 = r6 | r20;
        r7 = r29;
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0263, code lost:
        r7 = r29;
        r8 = r31;
        r2 = r5;
        r25 = r10;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0376 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r27, byte[] r28, int r29, int r30, int r31, com.google.android.gms.internal.clearcut.zzay r32) throws java.io.IOException {
        /*
            r26 = this;
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r11 = r31
            r9 = r32
            sun.misc.Unsafe r10 = zzmh
            r8 = -1
            r16 = 0
            r0 = r29
            r7 = r8
            r1 = r16
            r6 = r1
        L_0x0017:
            r17 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 >= r13) goto L_0x0398
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza((int) r0, (byte[]) r12, (int) r1, (com.google.android.gms.internal.clearcut.zzay) r9)
            int r1 = r9.zzfd
            r4 = r0
            r5 = r1
            goto L_0x002d
        L_0x002b:
            r5 = r0
            r4 = r1
        L_0x002d:
            int r3 = r5 >>> 3
            r2 = r5 & 7
            int r1 = r15.zzai(r3)
            if (r1 == r8) goto L_0x0365
            int[] r0 = r15.zzmi
            int r18 = r1 + 1
            r8 = r0[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r8 & r18
            int r11 = r18 >>> 20
            r29 = r5
            r5 = r8 & r17
            long r12 = (long) r5
            r5 = 17
            r18 = r8
            if (r11 > r5) goto L_0x026c
            int r5 = r1 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r8 = 1
            int r20 = r8 << r5
            r0 = r0 & r17
            r5 = -1
            if (r0 == r7) goto L_0x0068
            if (r7 == r5) goto L_0x0062
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0062:
            long r6 = (long) r0
            int r6 = r10.getInt(r14, r6)
            r7 = r0
        L_0x0068:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x024c;
                case 1: goto L_0x0236;
                case 2: goto L_0x0211;
                case 3: goto L_0x0211;
                case 4: goto L_0x01fb;
                case 5: goto L_0x01d5;
                case 6: goto L_0x01be;
                case 7: goto L_0x019d;
                case 8: goto L_0x017a;
                case 9: goto L_0x0143;
                case 10: goto L_0x012e;
                case 11: goto L_0x01fb;
                case 12: goto L_0x00fa;
                case 13: goto L_0x01be;
                case 14: goto L_0x01d5;
                case 15: goto L_0x00dd;
                case 16: goto L_0x00bb;
                case 17: goto L_0x0077;
                default: goto L_0x006c;
            }
        L_0x006c:
            r12 = r28
            r9 = r29
            r11 = r32
        L_0x0072:
            r5 = r4
            r29 = r7
            goto L_0x0263
        L_0x0077:
            r0 = 3
            if (r2 != r0) goto L_0x00b4
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r1)
            r1 = r28
            r2 = r4
            r3 = r30
            r4 = r8
            r9 = r29
            r8 = r5
            r5 = r32
            int r0 = zza((com.google.android.gms.internal.clearcut.zzef) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.clearcut.zzay) r5)
            r1 = r6 & r20
            r11 = r32
            if (r1 != 0) goto L_0x009d
            java.lang.Object r1 = r11.zzff
        L_0x0099:
            r10.putObject(r14, r12, r1)
            goto L_0x00a8
        L_0x009d:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r11.zzff
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.zzci.zza((java.lang.Object) r1, (java.lang.Object) r2)
            goto L_0x0099
        L_0x00a8:
            r6 = r6 | r20
            r12 = r28
        L_0x00ac:
            r13 = r30
        L_0x00ae:
            r1 = r9
            r9 = r11
        L_0x00b0:
            r11 = r31
            goto L_0x0017
        L_0x00b4:
            r9 = r29
            r11 = r32
        L_0x00b8:
            r12 = r28
            goto L_0x0072
        L_0x00bb:
            r9 = r29
            r11 = r32
            r8 = r5
            if (r2 != 0) goto L_0x00b8
            r2 = r12
            r12 = r28
            int r13 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r4, r11)
            long r0 = r11.zzfe
            long r4 = com.google.android.gms.internal.clearcut.zzbk.zza(r0)
            r0 = r10
            r1 = r27
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            r1 = r9
            r9 = r11
            r0 = r13
            r13 = r30
            goto L_0x00b0
        L_0x00dd:
            r9 = r29
            r11 = r32
            r8 = r5
            r0 = r12
            r12 = r28
            if (r2 != 0) goto L_0x0072
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r4, r11)
            int r3 = r11.zzfd
            int r3 = com.google.android.gms.internal.clearcut.zzbk.zzm(r3)
            r10.putInt(r14, r0, r3)
        L_0x00f4:
            r6 = r6 | r20
            r13 = r30
            r0 = r2
            goto L_0x00ae
        L_0x00fa:
            r9 = r29
            r11 = r32
            r8 = r5
            r21 = r12
            r12 = r28
            if (r2 != 0) goto L_0x0072
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r4, r11)
            int r2 = r11.zzfd
            com.google.android.gms.internal.clearcut.zzck r1 = r15.zzaf(r1)
            if (r1 == 0) goto L_0x0117
            com.google.android.gms.internal.clearcut.zzcj r1 = r1.zzb(r2)
            if (r1 == 0) goto L_0x011a
        L_0x0117:
            r3 = r21
            goto L_0x0127
        L_0x011a:
            com.google.android.gms.internal.clearcut.zzey r1 = zzn(r27)
            long r2 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.zzb(r9, r2)
            goto L_0x00ac
        L_0x0127:
            r10.putInt(r14, r3, r2)
            r6 = r6 | r20
            goto L_0x00ac
        L_0x012e:
            r9 = r29
            r11 = r32
            r8 = r5
            r0 = r12
            r3 = 2
            r12 = r28
            if (r2 != r3) goto L_0x0072
            int r2 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r4, r11)
            java.lang.Object r3 = r11.zzff
            r10.putObject(r14, r0, r3)
            goto L_0x00f4
        L_0x0143:
            r9 = r29
            r11 = r32
            r29 = r7
            r7 = r12
            r3 = 2
            r12 = r28
            if (r2 != r3) goto L_0x0175
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r1)
            r5 = r30
            int r0 = zza((com.google.android.gms.internal.clearcut.zzef) r0, (byte[]) r12, (int) r4, (int) r5, (com.google.android.gms.internal.clearcut.zzay) r11)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x0160
            java.lang.Object r1 = r11.zzff
            goto L_0x0199
        L_0x0160:
            java.lang.Object r1 = r10.getObject(r14, r7)
            java.lang.Object r2 = r11.zzff
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.zzci.zza((java.lang.Object) r1, (java.lang.Object) r2)
            goto L_0x0199
        L_0x016b:
            r6 = r6 | r20
            r7 = r29
            r13 = r5
        L_0x0170:
            r1 = r9
            r9 = r11
        L_0x0172:
            r8 = -1
            goto L_0x00b0
        L_0x0175:
            r5 = r30
        L_0x0177:
            r5 = r4
            goto L_0x0263
        L_0x017a:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r0 = 2
            r12 = r28
            if (r2 != r0) goto L_0x0177
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r18 & r0
            if (r0 != 0) goto L_0x0193
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r4, r11)
            goto L_0x0197
        L_0x0193:
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r4, r11)
        L_0x0197:
            java.lang.Object r1 = r11.zzff
        L_0x0199:
            r10.putObject(r14, r7, r1)
            goto L_0x016b
        L_0x019d:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != 0) goto L_0x0177
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r4, r11)
            long r1 = r11.zzfe
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x01b8
            r1 = 1
            goto L_0x01ba
        L_0x01b8:
            r1 = r16
        L_0x01ba:
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r14, (long) r7, (boolean) r1)
            goto L_0x016b
        L_0x01be:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != r0) goto L_0x0177
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r4)
            r10.putInt(r14, r7, r0)
            int r0 = r4 + 4
            goto L_0x016b
        L_0x01d5:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r0 = 1
            r12 = r28
            if (r2 != r0) goto L_0x0177
            long r17 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r4)
            r0 = r10
            r1 = r27
            r2 = r7
            r7 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
        L_0x01f3:
            r6 = r6 | r20
            r7 = r29
            r13 = r30
            goto L_0x0170
        L_0x01fb:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != 0) goto L_0x0263
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r5, r11)
            int r1 = r11.zzfd
            r10.putInt(r14, r7, r1)
            goto L_0x01f3
        L_0x0211:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != 0) goto L_0x0263
            int r17 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r5, r11)
            long r4 = r11.zzfe
            r0 = r10
            r1 = r27
            r2 = r7
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            r7 = r29
            r13 = r30
            r1 = r9
            r9 = r11
            r0 = r17
            goto L_0x0172
        L_0x0236:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != r0) goto L_0x0263
            float r0 = com.google.android.gms.internal.clearcut.zzax.zzf(r12, r5)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r14, (long) r7, (float) r0)
            int r0 = r5 + 4
            goto L_0x01f3
        L_0x024c:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r0 = 1
            r12 = r28
            if (r2 != r0) goto L_0x0263
            double r0 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r5)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r14, (long) r7, (double) r0)
            int r0 = r5 + 8
            goto L_0x01f3
        L_0x0263:
            r7 = r29
            r8 = r31
            r2 = r5
            r25 = r10
            goto L_0x0374
        L_0x026c:
            r9 = r29
            r5 = r4
            r19 = r7
            r7 = r12
            r12 = r28
            r0 = 27
            if (r11 != r0) goto L_0x02c3
            r0 = 2
            if (r2 != r0) goto L_0x02ba
            java.lang.Object r0 = r10.getObject(r14, r7)
            com.google.android.gms.internal.clearcut.zzcn r0 = (com.google.android.gms.internal.clearcut.zzcn) r0
            boolean r2 = r0.zzu()
            if (r2 != 0) goto L_0x0299
            int r2 = r0.size()
            if (r2 != 0) goto L_0x0290
            r2 = 10
            goto L_0x0292
        L_0x0290:
            int r2 = r2 << 1
        L_0x0292:
            com.google.android.gms.internal.clearcut.zzcn r0 = r0.zzi(r2)
            r10.putObject(r14, r7, r0)
        L_0x0299:
            r7 = r0
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r1)
            r1 = r9
            r2 = r28
            r3 = r5
            r4 = r30
            r5 = r7
            r20 = r6
            r6 = r32
            int r0 = zza((com.google.android.gms.internal.clearcut.zzef<?>) r0, (int) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.clearcut.zzcn<?>) r5, (com.google.android.gms.internal.clearcut.zzay) r6)
            r13 = r30
            r11 = r31
            r7 = r19
            r6 = r20
        L_0x02b5:
            r8 = -1
            r9 = r32
            goto L_0x0017
        L_0x02ba:
            r20 = r6
            r15 = r5
            r29 = r9
        L_0x02bf:
            r25 = r10
            goto L_0x036e
        L_0x02c3:
            r20 = r6
            r0 = 49
            if (r11 > r0) goto L_0x0319
            r6 = r18
            long r13 = (long) r6
            r0 = r26
            r18 = r1
            r1 = r27
            r6 = r2
            r2 = r28
            r21 = r3
            r3 = r5
            r4 = r30
            r15 = r5
            r5 = r9
            r22 = r6
            r6 = r21
            r23 = r7
            r7 = r22
            r8 = r18
            r29 = r9
            r25 = r10
            r9 = r13
            r14 = r31
            r12 = r23
            r14 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.clearcut.zzay) r14)
            if (r0 != r15) goto L_0x0302
        L_0x02f7:
            r9 = r29
            r8 = r31
            r2 = r0
        L_0x02fc:
            r7 = r19
            r6 = r20
            goto L_0x0374
        L_0x0302:
            r15 = r26
            r14 = r27
            r12 = r28
            r1 = r29
            r13 = r30
            r11 = r31
            r9 = r32
            r7 = r19
            r6 = r20
            r10 = r25
            r8 = -1
            goto L_0x0017
        L_0x0319:
            r22 = r2
            r21 = r3
            r15 = r5
            r23 = r7
            r29 = r9
            r25 = r10
            r6 = r18
            r18 = r1
            r0 = 50
            r7 = r22
            if (r11 != r0) goto L_0x0349
            r0 = 2
            if (r7 != r0) goto L_0x036e
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r18
            r6 = r21
            r7 = r23
            r9 = r32
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r9)
            if (r0 != r15) goto L_0x0302
            goto L_0x02f7
        L_0x0349:
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r29
            r8 = r6
            r6 = r21
            r9 = r11
            r10 = r23
            r12 = r18
            r13 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.clearcut.zzay) r13)
            if (r0 != r15) goto L_0x0302
            goto L_0x02f7
        L_0x0365:
            r15 = r4
            r29 = r5
            r20 = r6
            r19 = r7
            goto L_0x02bf
        L_0x036e:
            r9 = r29
            r8 = r31
            r2 = r15
            goto L_0x02fc
        L_0x0374:
            if (r9 != r8) goto L_0x037d
            if (r8 != 0) goto L_0x0379
            goto L_0x037d
        L_0x0379:
            r0 = r7
            r1 = -1
            r7 = r2
            goto L_0x03a4
        L_0x037d:
            r0 = r9
            r1 = r28
            r3 = r30
            r4 = r27
            r5 = r32
            int r0 = zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.zzay) r5)
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r11 = r8
            r1 = r9
            r10 = r25
            goto L_0x02b5
        L_0x0398:
            r20 = r6
            r19 = r7
            r25 = r10
            r8 = r11
            r7 = r0
            r9 = r1
            r0 = r19
            r1 = -1
        L_0x03a4:
            if (r0 == r1) goto L_0x03b1
            long r0 = (long) r0
            r10 = r27
            r2 = r25
            r2.putInt(r10, r0, r6)
        L_0x03ae:
            r11 = r26
            goto L_0x03b4
        L_0x03b1:
            r10 = r27
            goto L_0x03ae
        L_0x03b4:
            int[] r12 = r11.zzmt
            if (r12 == 0) goto L_0x03f4
            int r13 = r12.length
            r0 = 0
            r5 = r0
            r14 = r16
        L_0x03bd:
            if (r14 >= r13) goto L_0x03ed
            r1 = r12[r14]
            com.google.android.gms.internal.clearcut.zzex<?, ?> r6 = r11.zzmx
            int[] r0 = r11.zzmi
            r2 = r0[r1]
            int r0 = r11.zzag(r1)
            r0 = r0 & r17
            long r3 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r3)
            if (r0 != 0) goto L_0x03d5
            goto L_0x03e8
        L_0x03d5:
            com.google.android.gms.internal.clearcut.zzck r4 = r11.zzaf(r1)
            if (r4 != 0) goto L_0x03dc
            goto L_0x03e8
        L_0x03dc:
            com.google.android.gms.internal.clearcut.zzdj r3 = r11.zzmz
            java.util.Map r3 = r3.zzg(r0)
            r0 = r26
            java.lang.Object r5 = r0.zza((int) r1, (int) r2, r3, (com.google.android.gms.internal.clearcut.zzck<?>) r4, r5, r6)
        L_0x03e8:
            com.google.android.gms.internal.clearcut.zzey r5 = (com.google.android.gms.internal.clearcut.zzey) r5
            int r14 = r14 + 1
            goto L_0x03bd
        L_0x03ed:
            if (r5 == 0) goto L_0x03f4
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r11.zzmx
            r0.zzf(r10, r5)
        L_0x03f4:
            r0 = r30
            if (r8 != 0) goto L_0x0400
            if (r7 != r0) goto L_0x03fb
            goto L_0x0404
        L_0x03fb:
            com.google.android.gms.internal.clearcut.zzco r0 = com.google.android.gms.internal.clearcut.zzco.zzbo()
            throw r0
        L_0x0400:
            if (r7 > r0) goto L_0x0405
            if (r9 != r8) goto L_0x0405
        L_0x0404:
            return r7
        L_0x0405:
            com.google.android.gms.internal.clearcut.zzco r0 = com.google.android.gms.internal.clearcut.zzco.zzbo()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.zzay):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        r6.zzff = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
        r6.zzff = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r2 = java.lang.Long.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        r6.zzff = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        r2 = java.lang.Integer.valueOf(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.clearcut.zzfl r4, java.lang.Class<?> r5, com.google.android.gms.internal.clearcut.zzay r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.clearcut.zzdt.zzgq
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0086;
                case 2: goto L_0x0081;
                case 3: goto L_0x0078;
                case 4: goto L_0x006f;
                case 5: goto L_0x006f;
                case 6: goto L_0x0062;
                case 7: goto L_0x0062;
                case 8: goto L_0x0055;
                case 9: goto L_0x004e;
                case 10: goto L_0x004e;
                case 11: goto L_0x004e;
                case 12: goto L_0x0047;
                case 13: goto L_0x0047;
                case 14: goto L_0x003a;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzd(r1, r2, r6)
            goto L_0x009a
        L_0x0019:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r1, r2, r6)
            long r2 = r6.zzfe
            long r2 = com.google.android.gms.internal.clearcut.zzbk.zza(r2)
        L_0x0023:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
        L_0x0027:
            r6.zzff = r2
            goto L_0x009a
        L_0x002b:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r1, r2, r6)
            int r2 = r6.zzfd
            int r2 = com.google.android.gms.internal.clearcut.zzbk.zzm(r2)
        L_0x0035:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0027
        L_0x003a:
            com.google.android.gms.internal.clearcut.zzea r4 = com.google.android.gms.internal.clearcut.zzea.zzcm()
            com.google.android.gms.internal.clearcut.zzef r4 = r4.zze(r5)
            int r1 = zza((com.google.android.gms.internal.clearcut.zzef) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.clearcut.zzay) r6)
            goto L_0x009a
        L_0x0047:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r1, r2, r6)
            long r2 = r6.zzfe
            goto L_0x0023
        L_0x004e:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r1, r2, r6)
            int r2 = r6.zzfd
            goto L_0x0035
        L_0x0055:
            float r1 = com.google.android.gms.internal.clearcut.zzax.zzf(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
        L_0x005d:
            r6.zzff = r1
            int r1 = r2 + 4
            goto L_0x009a
        L_0x0062:
            long r3 = com.google.android.gms.internal.clearcut.zzax.zzd(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
        L_0x006a:
            r6.zzff = r1
            int r1 = r2 + 8
            goto L_0x009a
        L_0x006f:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzc(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x005d
        L_0x0078:
            double r3 = com.google.android.gms.internal.clearcut.zzax.zze(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            goto L_0x006a
        L_0x0081:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zze(r1, r2, r6)
            goto L_0x009a
        L_0x0086:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r1, r2, r6)
            long r2 = r6.zzfe
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0094
            r2 = 1
            goto L_0x0095
        L_0x0094:
            r2 = 0
        L_0x0095:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0027
        L_0x009a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(byte[], int, int, com.google.android.gms.internal.clearcut.zzfl, java.lang.Class, com.google.android.gms.internal.clearcut.zzay):int");
    }

    public static <T> zzds<T> zza(Class<T> cls, zzdm zzdm, zzdw zzdw, zzcy zzcy, zzex<?, ?> zzex, zzbu<?> zzbu, zzdj zzdj) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        zzdm zzdm2 = zzdm;
        if (zzdm2 instanceof zzec) {
            zzec zzec = (zzec) zzdm2;
            boolean z = zzec.zzcf() == zzcg.zzg.zzkm;
            if (zzec.getFieldCount() == 0) {
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                int zzcp = zzec.zzcp();
                int zzcq = zzec.zzcq();
                i3 = zzec.zzcu();
                i2 = zzcp;
                i = zzcq;
            }
            int[] iArr = new int[(i3 << 2)];
            Object[] objArr = new Object[(i3 << 1)];
            int[] iArr2 = zzec.zzcr() > 0 ? new int[zzec.zzcr()] : null;
            int[] iArr3 = zzec.zzcs() > 0 ? new int[zzec.zzcs()] : null;
            zzed zzco = zzec.zzco();
            if (zzco.next()) {
                int zzcx = zzco.zzcx();
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    if (zzcx >= zzec.zzcv() || i7 >= ((zzcx - i2) << 2)) {
                        if (zzco.zzda()) {
                            i6 = (int) zzfd.zza(zzco.zzdb());
                            i5 = (int) zzfd.zza(zzco.zzdc());
                            i4 = 0;
                        } else {
                            i6 = (int) zzfd.zza(zzco.zzdd());
                            if (zzco.zzde()) {
                                i5 = (int) zzfd.zza(zzco.zzdf());
                                i4 = zzco.zzdg();
                            } else {
                                i5 = 0;
                                i4 = 0;
                            }
                        }
                        iArr[i7] = zzco.zzcx();
                        int i10 = i7 + 1;
                        iArr[i10] = (zzco.zzdi() ? PKIFailureInfo.duplicateCertReq : 0) | (zzco.zzdh() ? 268435456 : 0) | (zzco.zzcy() << 20) | i6;
                        iArr[i7 + 2] = i5 | (i4 << 20);
                        if (zzco.zzdl() != null) {
                            int i11 = (i7 / 4) << 1;
                            objArr[i11] = zzco.zzdl();
                            if (zzco.zzdj() != null) {
                                objArr[i11 + 1] = zzco.zzdj();
                            } else if (zzco.zzdk() != null) {
                                objArr[i11 + 1] = zzco.zzdk();
                            }
                        } else if (zzco.zzdj() != null) {
                            objArr[((i7 / 4) << 1) + 1] = zzco.zzdj();
                        } else if (zzco.zzdk() != null) {
                            objArr[((i7 / 4) << 1) + 1] = zzco.zzdk();
                        }
                        int zzcy2 = zzco.zzcy();
                        if (zzcy2 == zzcb.MAP.ordinal()) {
                            iArr2[i8] = i7;
                            i8++;
                        } else if (zzcy2 >= 18 && zzcy2 <= 49) {
                            iArr3[i9] = iArr[i10] & 1048575;
                            i9++;
                        }
                        if (!zzco.next()) {
                            break;
                        }
                        zzcx = zzco.zzcx();
                    } else {
                        for (int i12 = 0; i12 < 4; i12++) {
                            iArr[i7 + i12] = -1;
                        }
                    }
                    i7 += 4;
                }
            }
            return new zzds(iArr, objArr, i2, i, zzec.zzcv(), zzec.zzch(), z, false, zzec.zzct(), iArr2, iArr3, zzdw, zzcy, zzex, zzbu, zzdj);
        }
        ((zzes) zzdm2).zzcf();
        throw new NoSuchMethodError();
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzck<?> zzck, UB ub, zzex<UT, UB> zzex) {
        zzdh<?, ?> zzl = this.zzmz.zzl(zzae(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (zzck.zzb(((Integer) next.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = zzex.zzdz();
                }
                zzbg zzk = zzbb.zzk(zzdg.zza(zzl, next.getKey(), next.getValue()));
                try {
                    zzdg.zza(zzk.zzae(), zzl, next.getKey(), next.getValue());
                    zzex.zza(ub, i2, zzk.zzad());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static void zza(int i, Object obj, zzfr zzfr) throws IOException {
        if (obj instanceof String) {
            zzfr.zza(i, (String) obj);
        } else {
            zzfr.zza(i, (zzbb) obj);
        }
    }

    private static <UT, UB> void zza(zzex<UT, UB> zzex, T t, zzfr zzfr) throws IOException {
        zzex.zza(zzex.zzq(t), zzfr);
    }

    private final <K, V> void zza(zzfr zzfr, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzfr.zza(i, this.zzmz.zzl(zzae(i2)), this.zzmz.zzh(obj));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0533, code lost:
        r15.zzb(r10, com.google.android.gms.internal.clearcut.zzfd.zzo(r14, (long) (r9 & 1048575)), zzad(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x054e, code lost:
        r15.zzb(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x055f, code lost:
        r15.zze(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0570, code lost:
        r15.zzj(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0581, code lost:
        r15.zzm(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0592, code lost:
        r15.zzn(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x05a3, code lost:
        r15.zzd(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x05ae, code lost:
        r15.zza(r10, (com.google.android.gms.internal.clearcut.zzbb) com.google.android.gms.internal.clearcut.zzfd.zzo(r14, (long) (r9 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        r15.zzb(r9, com.google.android.gms.internal.clearcut.zzfd.zzo(r14, (long) (r8 & 1048575)), zzad(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x05c1, code lost:
        r15.zza(r10, com.google.android.gms.internal.clearcut.zzfd.zzo(r14, (long) (r9 & 1048575)), zzad(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x05d6, code lost:
        zza(r10, com.google.android.gms.internal.clearcut.zzfd.zzo(r14, (long) (r9 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x05ed, code lost:
        r15.zzb(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x05fe, code lost:
        r15.zzf(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x060f, code lost:
        r15.zzc(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0620, code lost:
        r15.zzc(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0631, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0642, code lost:
        r15.zzi(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0653, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0664, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0089, code lost:
        r15.zzb(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009a, code lost:
        r15.zze(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
        r15.zzj(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bc, code lost:
        r15.zzm(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cd, code lost:
        r15.zzn(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00de, code lost:
        r15.zzd(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e9, code lost:
        r15.zza(r9, (com.google.android.gms.internal.clearcut.zzbb) com.google.android.gms.internal.clearcut.zzfd.zzo(r14, (long) (r8 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fc, code lost:
        r15.zza(r9, com.google.android.gms.internal.clearcut.zzfd.zzo(r14, (long) (r8 & 1048575)), zzad(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0111, code lost:
        zza(r9, com.google.android.gms.internal.clearcut.zzfd.zzo(r14, (long) (r8 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0128, code lost:
        r15.zzb(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0139, code lost:
        r15.zzf(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014a, code lost:
        r15.zzc(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015b, code lost:
        r15.zzc(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x016c, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x017d, code lost:
        r15.zzi(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x018e, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019f, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04c1  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04fe  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0986  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.clearcut.zzfr r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzaj()
            int r1 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzkp
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04d7
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r13.zzmx
            zza(r0, r14, (com.google.android.gms.internal.clearcut.zzfr) r15)
            boolean r0 = r13.zzmo
            if (r0 == 0) goto L_0x0030
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r13.zzmy
            com.google.android.gms.internal.clearcut.zzby r0 = r0.zza((java.lang.Object) r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0030
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0032
        L_0x0030:
            r0 = r3
            r1 = r0
        L_0x0032:
            int[] r7 = r13.zzmi
            int r7 = r7.length
            int r7 = r7 + -4
        L_0x0037:
            if (r7 < 0) goto L_0x04bf
            int r8 = r13.zzag(r7)
            int[] r9 = r13.zzmi
            r9 = r9[r7]
        L_0x0041:
            if (r1 == 0) goto L_0x005f
            com.google.android.gms.internal.clearcut.zzbu<?> r10 = r13.zzmy
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x005f
            com.google.android.gms.internal.clearcut.zzbu<?> r10 = r13.zzmy
            r10.zza((com.google.android.gms.internal.clearcut.zzfr) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0041
        L_0x005d:
            r1 = r3
            goto L_0x0041
        L_0x005f:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04ad;
                case 1: goto L_0x049f;
                case 2: goto L_0x0491;
                case 3: goto L_0x0483;
                case 4: goto L_0x0475;
                case 5: goto L_0x0467;
                case 6: goto L_0x0459;
                case 7: goto L_0x044b;
                case 8: goto L_0x0443;
                case 9: goto L_0x043b;
                case 10: goto L_0x0433;
                case 11: goto L_0x0425;
                case 12: goto L_0x0417;
                case 13: goto L_0x0409;
                case 14: goto L_0x03fb;
                case 15: goto L_0x03ed;
                case 16: goto L_0x03df;
                case 17: goto L_0x03d7;
                case 18: goto L_0x03c6;
                case 19: goto L_0x03b5;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0393;
                case 22: goto L_0x0382;
                case 23: goto L_0x0371;
                case 24: goto L_0x0360;
                case 25: goto L_0x034f;
                case 26: goto L_0x033e;
                case 27: goto L_0x0329;
                case 28: goto L_0x0318;
                case 29: goto L_0x0307;
                case 30: goto L_0x02f6;
                case 31: goto L_0x02e5;
                case 32: goto L_0x02d4;
                case 33: goto L_0x02c3;
                case 34: goto L_0x02b2;
                case 35: goto L_0x02a1;
                case 36: goto L_0x0290;
                case 37: goto L_0x027f;
                case 38: goto L_0x026e;
                case 39: goto L_0x025d;
                case 40: goto L_0x024c;
                case 41: goto L_0x023b;
                case 42: goto L_0x022a;
                case 43: goto L_0x0219;
                case 44: goto L_0x0208;
                case 45: goto L_0x01f7;
                case 46: goto L_0x01e6;
                case 47: goto L_0x01d5;
                case 48: goto L_0x01c4;
                case 49: goto L_0x01af;
                case 50: goto L_0x01a4;
                case 51: goto L_0x0193;
                case 52: goto L_0x0182;
                case 53: goto L_0x0171;
                case 54: goto L_0x0160;
                case 55: goto L_0x014f;
                case 56: goto L_0x013e;
                case 57: goto L_0x012d;
                case 58: goto L_0x011c;
                case 59: goto L_0x010b;
                case 60: goto L_0x00f6;
                case 61: goto L_0x00e3;
                case 62: goto L_0x00d2;
                case 63: goto L_0x00c1;
                case 64: goto L_0x00b0;
                case 65: goto L_0x009f;
                case 66: goto L_0x008e;
                case 67: goto L_0x007d;
                case 68: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x04bb
        L_0x0068:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
        L_0x006e:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            com.google.android.gms.internal.clearcut.zzef r10 = r13.zzad(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.clearcut.zzef) r10)
            goto L_0x04bb
        L_0x007d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
        L_0x0089:
            r15.zzb((int) r9, (long) r10)
            goto L_0x04bb
        L_0x008e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
        L_0x009a:
            r15.zze(r9, r8)
            goto L_0x04bb
        L_0x009f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
        L_0x00ab:
            r15.zzj(r9, r10)
            goto L_0x04bb
        L_0x00b0:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
        L_0x00bc:
            r15.zzm(r9, r8)
            goto L_0x04bb
        L_0x00c1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
        L_0x00cd:
            r15.zzn(r9, r8)
            goto L_0x04bb
        L_0x00d2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
        L_0x00de:
            r15.zzd(r9, r8)
            goto L_0x04bb
        L_0x00e3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
        L_0x00e9:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            com.google.android.gms.internal.clearcut.zzbb r8 = (com.google.android.gms.internal.clearcut.zzbb) r8
            r15.zza((int) r9, (com.google.android.gms.internal.clearcut.zzbb) r8)
            goto L_0x04bb
        L_0x00f6:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
        L_0x00fc:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            com.google.android.gms.internal.clearcut.zzef r10 = r13.zzad(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.clearcut.zzef) r10)
            goto L_0x04bb
        L_0x010b:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
        L_0x0111:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.clearcut.zzfr) r15)
            goto L_0x04bb
        L_0x011c:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzi(r14, r10)
        L_0x0128:
            r15.zzb((int) r9, (boolean) r8)
            goto L_0x04bb
        L_0x012d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
        L_0x0139:
            r15.zzf(r9, r8)
            goto L_0x04bb
        L_0x013e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
        L_0x014a:
            r15.zzc((int) r9, (long) r10)
            goto L_0x04bb
        L_0x014f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
        L_0x015b:
            r15.zzc((int) r9, (int) r8)
            goto L_0x04bb
        L_0x0160:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
        L_0x016c:
            r15.zza((int) r9, (long) r10)
            goto L_0x04bb
        L_0x0171:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
        L_0x017d:
            r15.zzi(r9, r10)
            goto L_0x04bb
        L_0x0182:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzf(r14, r10)
        L_0x018e:
            r15.zza((int) r9, (float) r8)
            goto L_0x04bb
        L_0x0193:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zze(r14, r10)
        L_0x019f:
            r15.zza((int) r9, (double) r10)
            goto L_0x04bb
        L_0x01a4:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            r13.zza((com.google.android.gms.internal.clearcut.zzfr) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x04bb
        L_0x01af:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzef r10 = r13.zzad(r7)
            com.google.android.gms.internal.clearcut.zzeh.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.clearcut.zzfr) r15, (com.google.android.gms.internal.clearcut.zzef) r10)
            goto L_0x04bb
        L_0x01c4:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zze(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x01d5:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzj(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x01e6:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzg(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x01f7:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzl(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x0208:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzm(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x0219:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzi(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x022a:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzn(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x023b:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzk(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x024c:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzf(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x025d:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzh(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x026e:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzd(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x027f:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzc(r9, r8, r15, r4)
            goto L_0x04bb
        L_0x0290:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.clearcut.zzfr) r15, (boolean) r4)
            goto L_0x04bb
        L_0x02a1:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.clearcut.zzfr) r15, (boolean) r4)
            goto L_0x04bb
        L_0x02b2:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zze(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x02c3:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzj(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x02d4:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzg(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x02e5:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzl(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x02f6:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzm(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x0307:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzi(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x0318:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzb(r9, r8, r15)
            goto L_0x04bb
        L_0x0329:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzef r10 = r13.zzad(r7)
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.clearcut.zzfr) r15, (com.google.android.gms.internal.clearcut.zzef) r10)
            goto L_0x04bb
        L_0x033e:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.clearcut.zzfr) r15)
            goto L_0x04bb
        L_0x034f:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzn(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x0360:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzk(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x0371:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzf(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x0382:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzh(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x0393:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzd(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x03a4:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzc(r9, r8, r15, r5)
            goto L_0x04bb
        L_0x03b5:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.clearcut.zzfr) r15, (boolean) r5)
            goto L_0x04bb
        L_0x03c6:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.clearcut.zzfr) r15, (boolean) r5)
            goto L_0x04bb
        L_0x03d7:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            goto L_0x006e
        L_0x03df:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
            goto L_0x0089
        L_0x03ed:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
            goto L_0x009a
        L_0x03fb:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
            goto L_0x00ab
        L_0x0409:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
            goto L_0x00bc
        L_0x0417:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
            goto L_0x00cd
        L_0x0425:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
            goto L_0x00de
        L_0x0433:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            goto L_0x00e9
        L_0x043b:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            goto L_0x00fc
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            goto L_0x0111
        L_0x044b:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.clearcut.zzfd.zzl(r14, r10)
            goto L_0x0128
        L_0x0459:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
            goto L_0x0139
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
            goto L_0x014a
        L_0x0475:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
            goto L_0x015b
        L_0x0483:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
            goto L_0x016c
        L_0x0491:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
            goto L_0x017d
        L_0x049f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.clearcut.zzfd.zzm(r14, r10)
            goto L_0x018e
        L_0x04ad:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04bb
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.clearcut.zzfd.zzn(r14, r10)
            goto L_0x019f
        L_0x04bb:
            int r7 = r7 + -4
            goto L_0x0037
        L_0x04bf:
            if (r1 == 0) goto L_0x04d6
            com.google.android.gms.internal.clearcut.zzbu<?> r14 = r13.zzmy
            r14.zza((com.google.android.gms.internal.clearcut.zzfr) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x04d4
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x04bf
        L_0x04d4:
            r1 = r3
            goto L_0x04bf
        L_0x04d6:
            return
        L_0x04d7:
            boolean r0 = r13.zzmq
            if (r0 == 0) goto L_0x09a0
            boolean r0 = r13.zzmo
            if (r0 == 0) goto L_0x04f6
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r13.zzmy
            com.google.android.gms.internal.clearcut.zzby r0 = r0.zza((java.lang.Object) r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x04f6
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x04f8
        L_0x04f6:
            r0 = r3
            r1 = r0
        L_0x04f8:
            int[] r7 = r13.zzmi
            int r7 = r7.length
            r8 = r5
        L_0x04fc:
            if (r8 >= r7) goto L_0x0984
            int r9 = r13.zzag(r8)
            int[] r10 = r13.zzmi
            r10 = r10[r8]
        L_0x0506:
            if (r1 == 0) goto L_0x0524
            com.google.android.gms.internal.clearcut.zzbu<?> r11 = r13.zzmy
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r1)
            if (r11 > r10) goto L_0x0524
            com.google.android.gms.internal.clearcut.zzbu<?> r11 = r13.zzmy
            r11.zza((com.google.android.gms.internal.clearcut.zzfr) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0522
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0506
        L_0x0522:
            r1 = r3
            goto L_0x0506
        L_0x0524:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0972;
                case 1: goto L_0x0964;
                case 2: goto L_0x0956;
                case 3: goto L_0x0948;
                case 4: goto L_0x093a;
                case 5: goto L_0x092c;
                case 6: goto L_0x091e;
                case 7: goto L_0x0910;
                case 8: goto L_0x0908;
                case 9: goto L_0x0900;
                case 10: goto L_0x08f8;
                case 11: goto L_0x08ea;
                case 12: goto L_0x08dc;
                case 13: goto L_0x08ce;
                case 14: goto L_0x08c0;
                case 15: goto L_0x08b2;
                case 16: goto L_0x08a4;
                case 17: goto L_0x089c;
                case 18: goto L_0x088b;
                case 19: goto L_0x087a;
                case 20: goto L_0x0869;
                case 21: goto L_0x0858;
                case 22: goto L_0x0847;
                case 23: goto L_0x0836;
                case 24: goto L_0x0825;
                case 25: goto L_0x0814;
                case 26: goto L_0x0803;
                case 27: goto L_0x07ee;
                case 28: goto L_0x07dd;
                case 29: goto L_0x07cc;
                case 30: goto L_0x07bb;
                case 31: goto L_0x07aa;
                case 32: goto L_0x0799;
                case 33: goto L_0x0788;
                case 34: goto L_0x0777;
                case 35: goto L_0x0766;
                case 36: goto L_0x0755;
                case 37: goto L_0x0744;
                case 38: goto L_0x0733;
                case 39: goto L_0x0722;
                case 40: goto L_0x0711;
                case 41: goto L_0x0700;
                case 42: goto L_0x06ef;
                case 43: goto L_0x06de;
                case 44: goto L_0x06cd;
                case 45: goto L_0x06bc;
                case 46: goto L_0x06ab;
                case 47: goto L_0x069a;
                case 48: goto L_0x0689;
                case 49: goto L_0x0674;
                case 50: goto L_0x0669;
                case 51: goto L_0x0658;
                case 52: goto L_0x0647;
                case 53: goto L_0x0636;
                case 54: goto L_0x0625;
                case 55: goto L_0x0614;
                case 56: goto L_0x0603;
                case 57: goto L_0x05f2;
                case 58: goto L_0x05e1;
                case 59: goto L_0x05d0;
                case 60: goto L_0x05bb;
                case 61: goto L_0x05a8;
                case 62: goto L_0x0597;
                case 63: goto L_0x0586;
                case 64: goto L_0x0575;
                case 65: goto L_0x0564;
                case 66: goto L_0x0553;
                case 67: goto L_0x0542;
                case 68: goto L_0x052d;
                default: goto L_0x052b;
            }
        L_0x052b:
            goto L_0x0980
        L_0x052d:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
        L_0x0533:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            com.google.android.gms.internal.clearcut.zzef r11 = r13.zzad(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.clearcut.zzef) r11)
            goto L_0x0980
        L_0x0542:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
        L_0x054e:
            r15.zzb((int) r10, (long) r11)
            goto L_0x0980
        L_0x0553:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
        L_0x055f:
            r15.zze(r10, r9)
            goto L_0x0980
        L_0x0564:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
        L_0x0570:
            r15.zzj(r10, r11)
            goto L_0x0980
        L_0x0575:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
        L_0x0581:
            r15.zzm(r10, r9)
            goto L_0x0980
        L_0x0586:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
        L_0x0592:
            r15.zzn(r10, r9)
            goto L_0x0980
        L_0x0597:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
        L_0x05a3:
            r15.zzd(r10, r9)
            goto L_0x0980
        L_0x05a8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
        L_0x05ae:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            com.google.android.gms.internal.clearcut.zzbb r9 = (com.google.android.gms.internal.clearcut.zzbb) r9
            r15.zza((int) r10, (com.google.android.gms.internal.clearcut.zzbb) r9)
            goto L_0x0980
        L_0x05bb:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
        L_0x05c1:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            com.google.android.gms.internal.clearcut.zzef r11 = r13.zzad(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.clearcut.zzef) r11)
            goto L_0x0980
        L_0x05d0:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
        L_0x05d6:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.clearcut.zzfr) r15)
            goto L_0x0980
        L_0x05e1:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzi(r14, r11)
        L_0x05ed:
            r15.zzb((int) r10, (boolean) r9)
            goto L_0x0980
        L_0x05f2:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
        L_0x05fe:
            r15.zzf(r10, r9)
            goto L_0x0980
        L_0x0603:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
        L_0x060f:
            r15.zzc((int) r10, (long) r11)
            goto L_0x0980
        L_0x0614:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
        L_0x0620:
            r15.zzc((int) r10, (int) r9)
            goto L_0x0980
        L_0x0625:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
        L_0x0631:
            r15.zza((int) r10, (long) r11)
            goto L_0x0980
        L_0x0636:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
        L_0x0642:
            r15.zzi(r10, r11)
            goto L_0x0980
        L_0x0647:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzf(r14, r11)
        L_0x0653:
            r15.zza((int) r10, (float) r9)
            goto L_0x0980
        L_0x0658:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zze(r14, r11)
        L_0x0664:
            r15.zza((int) r10, (double) r11)
            goto L_0x0980
        L_0x0669:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            r13.zza((com.google.android.gms.internal.clearcut.zzfr) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0980
        L_0x0674:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzef r11 = r13.zzad(r8)
            com.google.android.gms.internal.clearcut.zzeh.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.clearcut.zzfr) r15, (com.google.android.gms.internal.clearcut.zzef) r11)
            goto L_0x0980
        L_0x0689:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zze(r10, r9, r15, r4)
            goto L_0x0980
        L_0x069a:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzj(r10, r9, r15, r4)
            goto L_0x0980
        L_0x06ab:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzg(r10, r9, r15, r4)
            goto L_0x0980
        L_0x06bc:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzl(r10, r9, r15, r4)
            goto L_0x0980
        L_0x06cd:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzm(r10, r9, r15, r4)
            goto L_0x0980
        L_0x06de:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzi(r10, r9, r15, r4)
            goto L_0x0980
        L_0x06ef:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzn(r10, r9, r15, r4)
            goto L_0x0980
        L_0x0700:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzk(r10, r9, r15, r4)
            goto L_0x0980
        L_0x0711:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzf(r10, r9, r15, r4)
            goto L_0x0980
        L_0x0722:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzh(r10, r9, r15, r4)
            goto L_0x0980
        L_0x0733:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzd(r10, r9, r15, r4)
            goto L_0x0980
        L_0x0744:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzc(r10, r9, r15, r4)
            goto L_0x0980
        L_0x0755:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.clearcut.zzfr) r15, (boolean) r4)
            goto L_0x0980
        L_0x0766:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.clearcut.zzfr) r15, (boolean) r4)
            goto L_0x0980
        L_0x0777:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zze(r10, r9, r15, r5)
            goto L_0x0980
        L_0x0788:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzj(r10, r9, r15, r5)
            goto L_0x0980
        L_0x0799:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzg(r10, r9, r15, r5)
            goto L_0x0980
        L_0x07aa:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzl(r10, r9, r15, r5)
            goto L_0x0980
        L_0x07bb:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzm(r10, r9, r15, r5)
            goto L_0x0980
        L_0x07cc:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzi(r10, r9, r15, r5)
            goto L_0x0980
        L_0x07dd:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzb(r10, r9, r15)
            goto L_0x0980
        L_0x07ee:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzef r11 = r13.zzad(r8)
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.clearcut.zzfr) r15, (com.google.android.gms.internal.clearcut.zzef) r11)
            goto L_0x0980
        L_0x0803:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.clearcut.zzfr) r15)
            goto L_0x0980
        L_0x0814:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzn(r10, r9, r15, r5)
            goto L_0x0980
        L_0x0825:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzk(r10, r9, r15, r5)
            goto L_0x0980
        L_0x0836:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzf(r10, r9, r15, r5)
            goto L_0x0980
        L_0x0847:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzh(r10, r9, r15, r5)
            goto L_0x0980
        L_0x0858:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzd(r10, r9, r15, r5)
            goto L_0x0980
        L_0x0869:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzc(r10, r9, r15, r5)
            goto L_0x0980
        L_0x087a:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.clearcut.zzfr) r15, (boolean) r5)
            goto L_0x0980
        L_0x088b:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.clearcut.zzfr) r15, (boolean) r5)
            goto L_0x0980
        L_0x089c:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            goto L_0x0533
        L_0x08a4:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
            goto L_0x054e
        L_0x08b2:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
            goto L_0x055f
        L_0x08c0:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
            goto L_0x0570
        L_0x08ce:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
            goto L_0x0581
        L_0x08dc:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
            goto L_0x0592
        L_0x08ea:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
            goto L_0x05a3
        L_0x08f8:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            goto L_0x05ae
        L_0x0900:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            goto L_0x05c1
        L_0x0908:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            goto L_0x05d6
        L_0x0910:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.clearcut.zzfd.zzl(r14, r11)
            goto L_0x05ed
        L_0x091e:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
            goto L_0x05fe
        L_0x092c:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
            goto L_0x060f
        L_0x093a:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
            goto L_0x0620
        L_0x0948:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
            goto L_0x0631
        L_0x0956:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
            goto L_0x0642
        L_0x0964:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.clearcut.zzfd.zzm(r14, r11)
            goto L_0x0653
        L_0x0972:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0980
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.clearcut.zzfd.zzn(r14, r11)
            goto L_0x0664
        L_0x0980:
            int r8 = r8 + 4
            goto L_0x04fc
        L_0x0984:
            if (r1 == 0) goto L_0x099a
            com.google.android.gms.internal.clearcut.zzbu<?> r2 = r13.zzmy
            r2.zza((com.google.android.gms.internal.clearcut.zzfr) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0998
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0984
        L_0x0998:
            r1 = r3
            goto L_0x0984
        L_0x099a:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r13.zzmx
            zza(r0, r14, (com.google.android.gms.internal.clearcut.zzfr) r15)
            return
        L_0x09a0:
            r13.zzb(r14, (com.google.android.gms.internal.clearcut.zzfr) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, com.google.android.gms.internal.clearcut.zzfr):void");
    }

    private final void zza(T t, T t2, int i) {
        long zzag = (long) (zzag(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzfd.zzo(t, zzag);
            Object zzo2 = zzfd.zzo(t2, zzag);
            if (zzo != null && zzo2 != null) {
                zzfd.zza((Object) t, zzag, zzci.zza(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zzfd.zza((Object) t, zzag, zzo2);
                zzb(t, i);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
        r9.putLong(r23, r2, r4);
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.putInt(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        if (r7 == 0) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11);
        r1 = r11.zzfd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
        r1 = r11.zzff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        r9.putObject(r14, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d0, code lost:
        r0 = r10 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e0, code lost:
        r0 = r10 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e4, code lost:
        if (r7 == 0) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0163, code lost:
        if (r0 == r15) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0196, code lost:
        if (r0 == r15) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01af, code lost:
        if (r0 == r15) goto L_0x0165;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r23, byte[] r24, int r25, int r26, com.google.android.gms.internal.clearcut.zzay r27) throws java.io.IOException {
        /*
            r22 = this;
            r15 = r22
            r14 = r23
            r12 = r24
            r13 = r26
            r11 = r27
            boolean r0 = r15.zzmq
            if (r0 == 0) goto L_0x01cb
            sun.misc.Unsafe r9 = zzmh
            r0 = r25
        L_0x0012:
            if (r0 >= r13) goto L_0x01c2
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0024
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza((int) r0, (byte[]) r12, (int) r1, (com.google.android.gms.internal.clearcut.zzay) r11)
            int r1 = r11.zzfd
            r10 = r0
            r16 = r1
            goto L_0x0027
        L_0x0024:
            r16 = r0
            r10 = r1
        L_0x0027:
            int r6 = r16 >>> 3
            r7 = r16 & 7
            int r8 = r15.zzai(r6)
            if (r8 < 0) goto L_0x004b
            int[] r0 = r15.zzmi
            int r1 = r8 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r4 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r2 = (long) r0
            r0 = 17
            r1 = 2
            if (r4 > r0) goto L_0x0105
            r0 = 5
            r6 = 1
            switch(r4) {
                case 0: goto L_0x00fb;
                case 1: goto L_0x00f1;
                case 2: goto L_0x00e7;
                case 3: goto L_0x00e7;
                case 4: goto L_0x00e4;
                case 5: goto L_0x00d4;
                case 6: goto L_0x00c7;
                case 7: goto L_0x00b2;
                case 8: goto L_0x00a1;
                case 9: goto L_0x0089;
                case 10: goto L_0x007d;
                case 11: goto L_0x00e4;
                case 12: goto L_0x0074;
                case 13: goto L_0x00c7;
                case 14: goto L_0x00d4;
                case 15: goto L_0x0064;
                case 16: goto L_0x0050;
                default: goto L_0x004b;
            }
        L_0x004b:
            r21 = r9
            r15 = r10
            goto L_0x01b2
        L_0x0050:
            if (r7 != 0) goto L_0x004b
            int r6 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r10, r11)
            long r0 = r11.zzfe
            long r4 = com.google.android.gms.internal.clearcut.zzbk.zza(r0)
        L_0x005c:
            r0 = r9
            r1 = r23
            r0.putLong(r1, r2, r4)
            r0 = r6
            goto L_0x0012
        L_0x0064:
            if (r7 != 0) goto L_0x004b
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11)
            int r1 = r11.zzfd
            int r1 = com.google.android.gms.internal.clearcut.zzbk.zzm(r1)
        L_0x0070:
            r9.putInt(r14, r2, r1)
            goto L_0x0012
        L_0x0074:
            if (r7 != 0) goto L_0x004b
        L_0x0076:
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11)
            int r1 = r11.zzfd
            goto L_0x0070
        L_0x007d:
            if (r7 != r1) goto L_0x004b
            int r0 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r10, r11)
        L_0x0083:
            java.lang.Object r1 = r11.zzff
        L_0x0085:
            r9.putObject(r14, r2, r1)
            goto L_0x0012
        L_0x0089:
            if (r7 != r1) goto L_0x004b
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r8)
            int r0 = zza((com.google.android.gms.internal.clearcut.zzef) r0, (byte[]) r12, (int) r10, (int) r13, (com.google.android.gms.internal.clearcut.zzay) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x009a
            goto L_0x0083
        L_0x009a:
            java.lang.Object r4 = r11.zzff
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.zzci.zza((java.lang.Object) r1, (java.lang.Object) r4)
            goto L_0x0085
        L_0x00a1:
            if (r7 != r1) goto L_0x004b
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00ad
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r10, r11)
            goto L_0x0083
        L_0x00ad:
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r10, r11)
            goto L_0x0083
        L_0x00b2:
            if (r7 != 0) goto L_0x004b
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r10, r11)
            long r4 = r11.zzfe
            r7 = 0
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r6 = 0
        L_0x00c2:
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r14, (long) r2, (boolean) r6)
            goto L_0x0012
        L_0x00c7:
            if (r7 != r0) goto L_0x004b
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r10)
            r9.putInt(r14, r2, r0)
        L_0x00d0:
            int r0 = r10 + 4
            goto L_0x0012
        L_0x00d4:
            if (r7 != r6) goto L_0x004b
            long r4 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r10)
            r0 = r9
            r1 = r23
            r0.putLong(r1, r2, r4)
        L_0x00e0:
            int r0 = r10 + 8
            goto L_0x0012
        L_0x00e4:
            if (r7 != 0) goto L_0x004b
            goto L_0x0076
        L_0x00e7:
            if (r7 != 0) goto L_0x004b
            int r6 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r10, r11)
            long r4 = r11.zzfe
            goto L_0x005c
        L_0x00f1:
            if (r7 != r0) goto L_0x004b
            float r0 = com.google.android.gms.internal.clearcut.zzax.zzf(r12, r10)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r14, (long) r2, (float) r0)
            goto L_0x00d0
        L_0x00fb:
            if (r7 != r6) goto L_0x004b
            double r0 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r10)
            com.google.android.gms.internal.clearcut.zzfd.zza((java.lang.Object) r14, (long) r2, (double) r0)
            goto L_0x00e0
        L_0x0105:
            r0 = 27
            if (r4 != r0) goto L_0x013d
            if (r7 != r1) goto L_0x004b
            java.lang.Object r0 = r9.getObject(r14, r2)
            com.google.android.gms.internal.clearcut.zzcn r0 = (com.google.android.gms.internal.clearcut.zzcn) r0
            boolean r1 = r0.zzu()
            if (r1 != 0) goto L_0x0129
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0120
            r1 = 10
            goto L_0x0122
        L_0x0120:
            int r1 = r1 << 1
        L_0x0122:
            com.google.android.gms.internal.clearcut.zzcn r0 = r0.zzi(r1)
            r9.putObject(r14, r2, r0)
        L_0x0129:
            r5 = r0
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r8)
            r1 = r16
            r2 = r24
            r3 = r10
            r4 = r26
            r6 = r27
            int r0 = zza((com.google.android.gms.internal.clearcut.zzef<?>) r0, (int) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.clearcut.zzcn<?>) r5, (com.google.android.gms.internal.clearcut.zzay) r6)
            goto L_0x0012
        L_0x013d:
            r0 = 49
            if (r4 > r0) goto L_0x0175
            long r0 = (long) r5
            r17 = r0
            r0 = r22
            r1 = r23
            r19 = r2
            r2 = r24
            r3 = r10
            r5 = r4
            r4 = r26
            r25 = r5
            r5 = r16
            r21 = r9
            r15 = r10
            r9 = r17
            r11 = r25
            r12 = r19
            r14 = r27
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.clearcut.zzay) r14)
            if (r0 != r15) goto L_0x0167
        L_0x0165:
            r2 = r0
            goto L_0x01b3
        L_0x0167:
            r15 = r22
            r14 = r23
            r12 = r24
            r13 = r26
            r11 = r27
            r9 = r21
            goto L_0x0012
        L_0x0175:
            r19 = r2
            r25 = r4
            r21 = r9
            r15 = r10
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0199
            if (r7 != r1) goto L_0x01b2
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r15
            r4 = r26
            r5 = r8
            r7 = r19
            r9 = r27
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r9)
            if (r0 != r15) goto L_0x0167
            goto L_0x0165
        L_0x0199:
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r15
            r4 = r26
            r10 = r5
            r5 = r16
            r12 = r8
            r8 = r10
            r10 = r19
            r13 = r27
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.clearcut.zzay) r13)
            if (r0 != r15) goto L_0x0167
            goto L_0x0165
        L_0x01b2:
            r2 = r15
        L_0x01b3:
            r0 = r16
            r1 = r24
            r3 = r26
            r4 = r23
            r5 = r27
            int r0 = zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (java.lang.Object) r4, (com.google.android.gms.internal.clearcut.zzay) r5)
            goto L_0x0167
        L_0x01c2:
            r4 = r13
            if (r0 != r4) goto L_0x01c6
            return
        L_0x01c6:
            com.google.android.gms.internal.clearcut.zzco r0 = com.google.android.gms.internal.clearcut.zzco.zzbo()
            throw r0
        L_0x01cb:
            r4 = r13
            r5 = 0
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r6 = r27
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.clearcut.zzay) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.zzay):void");
    }

    private final boolean zza(T t, int i) {
        if (this.zzmq) {
            int zzag = zzag(i);
            long j = (long) (zzag & 1048575);
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    return zzfd.zzn(t, j) != 0.0d;
                case 1:
                    return zzfd.zzm(t, j) != 0.0f;
                case 2:
                    return zzfd.zzk(t, j) != 0;
                case 3:
                    return zzfd.zzk(t, j) != 0;
                case 4:
                    return zzfd.zzj(t, j) != 0;
                case 5:
                    return zzfd.zzk(t, j) != 0;
                case 6:
                    return zzfd.zzj(t, j) != 0;
                case 7:
                    return zzfd.zzl(t, j);
                case 8:
                    Object zzo = zzfd.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzbb) {
                        return !zzbb.zzfi.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzfd.zzo(t, j) != null;
                case 10:
                    return !zzbb.zzfi.equals(zzfd.zzo(t, j));
                case 11:
                    return zzfd.zzj(t, j) != 0;
                case 12:
                    return zzfd.zzj(t, j) != 0;
                case 13:
                    return zzfd.zzj(t, j) != 0;
                case 14:
                    return zzfd.zzk(t, j) != 0;
                case 15:
                    return zzfd.zzj(t, j) != 0;
                case 16:
                    return zzfd.zzk(t, j) != 0;
                case 17:
                    return zzfd.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzah = zzah(i);
            return (zzfd.zzj(t, (long) (zzah & 1048575)) & (1 << (zzah >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfd.zzj(t, (long) (zzah(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzmq) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private static boolean zza(Object obj, int i, zzef zzef) {
        return zzef.zzo(zzfd.zzo(obj, (long) (i & 1048575)));
    }
}
