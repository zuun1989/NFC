package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzln implements zzov {
    private final zzlm zza;

    private zzln(zzlm zzlm) {
        byte[] bArr = zzmp.zzb;
        this.zza = zzlm;
        zzlm.zza = this;
    }

    public static zzln zza(zzlm zzlm) {
        zzln zzln = zzlm.zza;
        if (zzln != null) {
            return zzln;
        }
        return new zzln(zzlm);
    }

    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzna) {
            zzna zzna = (zzna) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzna.size(); i4++) {
                    zzna.zzc(i4);
                    i3 += 8;
                }
                zzlm.zzr(i3);
                while (i2 < zzna.size()) {
                    zzlm.zzu(zzna.zzc(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzna.size()) {
                this.zza.zzf(i, zzna.zzc(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzly) {
            zzly zzly = (zzly) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzly.size(); i4++) {
                    zzly.zze(i4);
                    i3 += 4;
                }
                zzlm.zzr(i3);
                while (i2 < zzly.size()) {
                    zzlm.zzs(Float.floatToRawIntBits(zzly.zze(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzly.size()) {
                this.zza.zzd(i, Float.floatToRawIntBits(zzly.zze(i2)));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).floatValue();
                i5 += 4;
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzs(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzd(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        }
    }

    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzlo) {
            zzlo zzlo = (zzlo) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzlo.size(); i4++) {
                    zzlo.zze(i4);
                    i3 += 8;
                }
                zzlm.zzr(i3);
                while (i2 < zzlo.size()) {
                    zzlm.zzu(Double.doubleToRawLongBits(zzlo.zze(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzlo.size()) {
                this.zza.zzf(i, Double.doubleToRawLongBits(zzlo.zze(i2)));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).doubleValue();
                i5 += 8;
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzu(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        }
    }

    public final void zzD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmg.size(); i4++) {
                    i3 += zzlm.zzA((long) zzmg.zzf(i4));
                }
                zzlm.zzr(i3);
                while (i2 < zzmg.size()) {
                    zzlm.zzq(zzmg.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmg.size()) {
                this.zza.zzb(i, zzmg.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzlm.zzA((long) ((Integer) list.get(i6)).intValue());
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzky) {
            zzky zzky = (zzky) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzky.size(); i4++) {
                    zzky.zze(i4);
                    i3++;
                }
                zzlm.zzr(i3);
                while (i2 < zzky.size()) {
                    zzlm.zzp(zzky.zze(i2) ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < zzky.size()) {
                this.zza.zzg(i, zzky.zze(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).booleanValue();
                i5++;
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzp(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : 0);
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzg(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
        }
    }

    public final void zzF(int i, List list) throws IOException {
        int i2 = 0;
        if (list instanceof zzmx) {
            zzmx zzmx = (zzmx) list;
            while (i2 < list.size()) {
                Object zzc = zzmx.zzc();
                if (zzc instanceof String) {
                    this.zza.zzh(i, (String) zzc);
                } else {
                    this.zza.zzi(i, (zzlh) zzc);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzG(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzi(i, (zzlh) list.get(i2));
        }
    }

    public final void zzH(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmg.size(); i4++) {
                    i3 += zzlm.zzz(zzmg.zzf(i4));
                }
                zzlm.zzr(i3);
                while (i2 < zzmg.size()) {
                    zzlm.zzr(zzmg.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmg.size()) {
                this.zza.zzc(i, zzmg.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzlm.zzz(((Integer) list.get(i6)).intValue());
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzr(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzI(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmg.size(); i4++) {
                    zzmg.zzf(i4);
                    i3 += 4;
                }
                zzlm.zzr(i3);
                while (i2 < zzmg.size()) {
                    zzlm.zzs(zzmg.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmg.size()) {
                this.zza.zzd(i, zzmg.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzna) {
            zzna zzna = (zzna) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzna.size(); i4++) {
                    zzna.zzc(i4);
                    i3 += 8;
                }
                zzlm.zzr(i3);
                while (i2 < zzna.size()) {
                    zzlm.zzu(zzna.zzc(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzna.size()) {
                this.zza.zzf(i, zzna.zzc(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmg.size(); i4++) {
                    int zzf = zzmg.zzf(i4);
                    i3 += zzlm.zzz((zzf >> 31) ^ (zzf + zzf));
                }
                zzlm.zzr(i3);
                while (i2 < zzmg.size()) {
                    int zzf2 = zzmg.zzf(i2);
                    zzlm.zzr((zzf2 >> 31) ^ (zzf2 + zzf2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmg.size()) {
                zzlm zzlm2 = this.zza;
                int zzf3 = zzmg.zzf(i2);
                zzlm2.zzc(i, (zzf3 >> 31) ^ (zzf3 + zzf3));
                i2++;
            }
        } else if (z) {
            zzlm zzlm3 = this.zza;
            zzlm3.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                i5 += zzlm.zzz((intValue >> 31) ^ (intValue + intValue));
            }
            zzlm3.zzr(i5);
            while (i2 < list.size()) {
                int intValue2 = ((Integer) list.get(i2)).intValue();
                zzlm3.zzr((intValue2 >> 31) ^ (intValue2 + intValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzlm zzlm4 = this.zza;
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzlm4.zzc(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
        }
    }

    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzna) {
            zzna zzna = (zzna) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzna.size(); i4++) {
                    long zzc = zzna.zzc(i4);
                    i3 += zzlm.zzA((zzc >> 63) ^ (zzc + zzc));
                }
                zzlm.zzr(i3);
                while (i2 < zzna.size()) {
                    long zzc2 = zzna.zzc(i2);
                    zzlm.zzt((zzc2 >> 63) ^ (zzc2 + zzc2));
                    i2++;
                }
                return;
            }
            while (i2 < zzna.size()) {
                zzlm zzlm2 = this.zza;
                long zzc3 = zzna.zzc(i2);
                zzlm2.zze(i, (zzc3 >> 63) ^ (zzc3 + zzc3));
                i2++;
            }
        } else if (z) {
            zzlm zzlm3 = this.zza;
            zzlm3.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                long longValue = ((Long) list.get(i6)).longValue();
                i5 += zzlm.zzA((longValue >> 63) ^ (longValue + longValue));
            }
            zzlm3.zzr(i5);
            while (i2 < list.size()) {
                long longValue2 = ((Long) list.get(i2)).longValue();
                zzlm3.zzt((longValue2 >> 63) ^ (longValue2 + longValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzlm zzlm4 = this.zza;
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzlm4.zze(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
        }
    }

    public final void zzM(int i, zzne zzne, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzlm zzlm = this.zza;
            zzlm.zza(i, 2);
            zzlm.zzr(zznf.zzc(zzne, entry.getKey(), entry.getValue()));
            zznf.zzb(zzlm, zzne, entry.getKey(), entry.getValue());
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zze(int i, float f) throws IOException {
        this.zza.zzd(i, Float.floatToRawIntBits(f));
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzh(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zzl(int i, boolean z) throws IOException {
        this.zza.zzg(i, z);
    }

    public final void zzm(int i, String str) throws IOException {
        this.zza.zzh(i, str);
    }

    public final void zzn(int i, zzlh zzlh) throws IOException {
        this.zza.zzi(i, zzlh);
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zza.zzc(i, i2);
    }

    public final void zzp(int i, int i2) throws IOException {
        this.zza.zzc(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzq(int i, long j) throws IOException {
        this.zza.zze(i, (j >> 63) ^ (j + j));
    }

    public final void zzr(int i, Object obj, zznx zznx) throws IOException {
        this.zza.zzl(i, (zznm) obj, zznx);
    }

    public final void zzs(int i, Object obj, zznx zznx) throws IOException {
        zzlm zzlm = this.zza;
        zzlm.zza(i, 3);
        zznx.zzf((zznm) obj, zzlm.zza);
        zzlm.zza(i, 4);
    }

    @Deprecated
    public final void zzt(int i) throws IOException {
        this.zza.zza(i, 3);
    }

    @Deprecated
    public final void zzu(int i) throws IOException {
        this.zza.zza(i, 4);
    }

    public final void zzv(int i, Object obj) throws IOException {
        if (obj instanceof zzlh) {
            this.zza.zzn(i, (zzlh) obj);
        } else {
            this.zza.zzm(i, (zznm) obj);
        }
    }

    public final void zzw(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmg.size(); i4++) {
                    i3 += zzlm.zzA((long) zzmg.zzf(i4));
                }
                zzlm.zzr(i3);
                while (i2 < zzmg.size()) {
                    zzlm.zzq(zzmg.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmg.size()) {
                this.zza.zzb(i, zzmg.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzlm.zzA((long) ((Integer) list.get(i6)).intValue());
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzx(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmg) {
            zzmg zzmg = (zzmg) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmg.size(); i4++) {
                    zzmg.zzf(i4);
                    i3 += 4;
                }
                zzlm.zzr(i3);
                while (i2 < zzmg.size()) {
                    zzlm.zzs(zzmg.zzf(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzmg.size()) {
                this.zza.zzd(i, zzmg.zzf(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzna) {
            zzna zzna = (zzna) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzna.size(); i4++) {
                    i3 += zzlm.zzA(zzna.zzc(i4));
                }
                zzlm.zzr(i3);
                while (i2 < zzna.size()) {
                    zzlm.zzt(zzna.zzc(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzna.size()) {
                this.zza.zze(i, zzna.zzc(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzlm.zzA(((Long) list.get(i6)).longValue());
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zze(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzna) {
            zzna zzna = (zzna) list;
            if (z) {
                zzlm zzlm = this.zza;
                zzlm.zza(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzna.size(); i4++) {
                    i3 += zzlm.zzA(zzna.zzc(i4));
                }
                zzlm.zzr(i3);
                while (i2 < zzna.size()) {
                    zzlm.zzt(zzna.zzc(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzna.size()) {
                this.zza.zze(i, zzna.zzc(i2));
                i2++;
            }
        } else if (z) {
            zzlm zzlm2 = this.zza;
            zzlm2.zza(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzlm.zzA(((Long) list.get(i6)).longValue());
            }
            zzlm2.zzr(i5);
            while (i2 < list.size()) {
                zzlm2.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zze(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }
}
