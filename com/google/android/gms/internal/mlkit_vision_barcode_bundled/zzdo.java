package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.List;

final class zzdo implements zzhh {
    private final zzdn zza;

    private zzdo(zzdn zzdn) {
        byte[] bArr = zzep.zzb;
        this.zza = zzdn;
        zzdn.zza = this;
    }

    public static zzdo zza(zzdn zzdn) {
        zzdo zzdo = zzdn.zza;
        if (zzdo != null) {
            return zzdo;
        }
        return new zzdo(zzdn);
    }

    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzfb) {
            zzfb zzfb = (zzfb) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzfb.size(); i4++) {
                    zzfb.zze(i4);
                    i3 += 8;
                }
                this.zza.zzt(i3);
                while (i2 < zzfb.size()) {
                    this.zza.zzi(zzfb.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzfb.size()) {
                this.zza.zzh(i, zzfb.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzs(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzei.size(); i4++) {
                    int zze = zzei.zze(i4);
                    i3 += zzdn.zzA((zze >> 31) ^ (zze + zze));
                }
                this.zza.zzt(i3);
                while (i2 < zzei.size()) {
                    zzdn zzdn = this.zza;
                    int zze2 = zzei.zze(i2);
                    zzdn.zzt((zze2 >> 31) ^ (zze2 + zze2));
                    i2++;
                }
                return;
            }
            while (i2 < zzei.size()) {
                zzdn zzdn2 = this.zza;
                int zze3 = zzei.zze(i2);
                zzdn2.zzs(i, (zze3 >> 31) ^ (zze3 + zze3));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                i5 += zzdn.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                zzdn zzdn3 = this.zza;
                int intValue2 = ((Integer) list.get(i2)).intValue();
                zzdn3.zzt((intValue2 >> 31) ^ (intValue2 + intValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzdn zzdn4 = this.zza;
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzdn4.zzs(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
        }
    }

    public final void zzD(int i, long j) throws IOException {
        this.zza.zzu(i, (j >> 63) ^ (j + j));
    }

    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzfb) {
            zzfb zzfb = (zzfb) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzfb.size(); i4++) {
                    long zze = zzfb.zze(i4);
                    i3 += zzdn.zzB((zze >> 63) ^ (zze + zze));
                }
                this.zza.zzt(i3);
                while (i2 < zzfb.size()) {
                    zzdn zzdn = this.zza;
                    long zze2 = zzfb.zze(i2);
                    zzdn.zzv((zze2 >> 63) ^ (zze2 + zze2));
                    i2++;
                }
                return;
            }
            while (i2 < zzfb.size()) {
                zzdn zzdn2 = this.zza;
                long zze3 = zzfb.zze(i2);
                zzdn2.zzu(i, (zze3 >> 63) ^ (zze3 + zze3));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                long longValue = ((Long) list.get(i6)).longValue();
                i5 += zzdn.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                zzdn zzdn3 = this.zza;
                long longValue2 = ((Long) list.get(i2)).longValue();
                zzdn3.zzv((longValue2 >> 63) ^ (longValue2 + longValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzdn zzdn4 = this.zza;
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzdn4.zzu(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
        }
    }

    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzr(i, 3);
    }

    public final void zzG(int i, String str) throws IOException {
        this.zza.zzp(i, str);
    }

    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (list instanceof zzey) {
            zzey zzey = (zzey) list;
            while (i2 < list.size()) {
                Object zza2 = zzey.zza();
                if (zza2 instanceof String) {
                    this.zza.zzp(i, (String) zza2);
                } else {
                    this.zza.zze(i, (zzdf) zza2);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzp(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzs(i, i2);
    }

    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzei.size(); i4++) {
                    i3 += zzdn.zzA(zzei.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zzei.size()) {
                    this.zza.zzt(zzei.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzei.size()) {
                this.zza.zzs(i, zzei.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzdn.zzA(((Integer) list.get(i6)).intValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzt(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzs(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzK(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzfb) {
            zzfb zzfb = (zzfb) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzfb.size(); i4++) {
                    i3 += zzdn.zzB(zzfb.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zzfb.size()) {
                    this.zza.zzv(zzfb.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzfb.size()) {
                this.zza.zzu(i, zzfb.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzdn.zzB(((Long) list.get(i6)).longValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzcw) {
            zzcw zzcw = (zzcw) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzcw.size(); i4++) {
                    zzcw.zzf(i4);
                    i3++;
                }
                this.zza.zzt(i3);
                while (i2 < zzcw.size()) {
                    this.zza.zzb(zzcw.zzf(i2) ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < zzcw.size()) {
                this.zza.zzd(i, zzcw.zzf(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).booleanValue();
                i5++;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : 0);
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
        }
    }

    public final void zzd(int i, zzdf zzdf) throws IOException {
        this.zza.zze(i, zzdf);
    }

    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzdf) list.get(i2));
        }
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzdp) {
            zzdp zzdp = (zzdp) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzdp.size(); i4++) {
                    zzdp.zze(i4);
                    i3 += 8;
                }
                this.zza.zzt(i3);
                while (i2 < zzdp.size()) {
                    this.zza.zzi(Double.doubleToRawLongBits(zzdp.zze(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzdp.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(zzdp.zze(i2)));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).doubleValue();
                i5 += 8;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        }
    }

    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzr(i, 4);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzei.size(); i4++) {
                    i3 += zzdn.zzB((long) zzei.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zzei.size()) {
                    this.zza.zzk(zzei.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzei.size()) {
                this.zza.zzj(i, zzei.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzdn.zzB((long) ((Integer) list.get(i6)).intValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzei.size(); i4++) {
                    zzei.zze(i4);
                    i3 += 4;
                }
                this.zza.zzt(i3);
                while (i2 < zzei.size()) {
                    this.zza.zzg(zzei.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzei.size()) {
                this.zza.zzf(i, zzei.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzfb) {
            zzfb zzfb = (zzfb) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzfb.size(); i4++) {
                    zzfb.zze(i4);
                    i3 += 8;
                }
                this.zza.zzt(i3);
                while (i2 < zzfb.size()) {
                    this.zza.zzi(zzfb.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzfb.size()) {
                this.zza.zzh(i, zzfb.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzo(int i, float f) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f));
    }

    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzdz) {
            zzdz zzdz = (zzdz) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzdz.size(); i4++) {
                    zzdz.zze(i4);
                    i3 += 4;
                }
                this.zza.zzt(i3);
                while (i2 < zzdz.size()) {
                    this.zza.zzg(Float.floatToRawIntBits(zzdz.zze(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzdz.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(zzdz.zze(i2)));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).floatValue();
                i5 += 4;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        }
    }

    public final void zzq(int i, Object obj, zzge zzge) throws IOException {
        zzdn zzdn = this.zza;
        zzdn.zzr(i, 3);
        zzge.zzi((zzfm) obj, zzdn.zza);
        zzdn.zzr(i, 4);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzei.size(); i4++) {
                    i3 += zzdn.zzB((long) zzei.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zzei.size()) {
                    this.zza.zzk(zzei.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzei.size()) {
                this.zza.zzj(i, zzei.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzdn.zzB((long) ((Integer) list.get(i6)).intValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzt(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzfb) {
            zzfb zzfb = (zzfb) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzfb.size(); i4++) {
                    i3 += zzdn.zzB(zzfb.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zzfb.size()) {
                    this.zza.zzv(zzfb.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzfb.size()) {
                this.zza.zzu(i, zzfb.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzdn.zzB(((Long) list.get(i6)).longValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzv(int i, Object obj, zzge zzge) throws IOException {
        this.zza.zzm(i, (zzfm) obj, zzge);
    }

    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzdf) {
            this.zza.zzo(i, (zzdf) obj);
        } else {
            this.zza.zzn(i, (zzfm) obj);
        }
    }

    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzei) {
            zzei zzei = (zzei) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzei.size(); i4++) {
                    zzei.zze(i4);
                    i3 += 4;
                }
                this.zza.zzt(i3);
                while (i2 < zzei.size()) {
                    this.zza.zzg(zzei.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzei.size()) {
                this.zza.zzf(i, zzei.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzz(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }
}
