package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakq  reason: invalid package */
final class zzakq implements zzaom {
    private final zzako zza;

    private zzakq(zzako zzako) {
        zzako zzako2 = (zzako) zzali.zza(zzako, "output");
        this.zza = zzako2;
        zzako2.zza = this;
    }

    public final int zza() {
        return 1;
    }

    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzakt) {
            zzakt zzakt = (zzakt) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzakt.size(); i4++) {
                    i3 += zzako.zza(zzakt.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzakt.size()) {
                    this.zza.zzb(zzakt.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzakt.size()) {
                this.zza.zzb(i, zzakt.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zza(list.get(i6).doubleValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).doubleValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).doubleValue());
                i2++;
            }
        }
    }

    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalj.size(); i4++) {
                    i3 += zzako.zza(zzalj.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzalj.size()) {
                    this.zza.zzj(zzalj.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalj.size()) {
                this.zza.zzh(i, zzalj.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zza(list.get(i6).intValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzj(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalj.size(); i4++) {
                    i3 += zzako.zzb(zzalj.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzalj.size()) {
                    this.zza.zzi(zzalj.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalj.size()) {
                this.zza.zzg(i, zzalj.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zzb(list.get(i6).intValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzi(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzaly.size(); i4++) {
                    i3 += zzako.zza(zzaly.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzaly.size()) {
                    this.zza.zzf(zzaly.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzaly.size()) {
                this.zza.zzf(i, zzaly.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zza(list.get(i6).longValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzf(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzale) {
            zzale zzale = (zzale) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzale.size(); i4++) {
                    i3 += zzako.zza(zzale.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzale.size()) {
                    this.zza.zzb(zzale.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzale.size()) {
                this.zza.zzb(i, zzale.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zza(list.get(i6).floatValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).floatValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).floatValue());
                i2++;
            }
        }
    }

    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalj.size(); i4++) {
                    i3 += zzako.zzc(zzalj.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzalj.size()) {
                    this.zza.zzj(zzalj.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalj.size()) {
                this.zza.zzh(i, zzalj.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zzc(list.get(i6).intValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzj(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzaly.size(); i4++) {
                    i3 += zzako.zzb(zzaly.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzaly.size()) {
                    this.zza.zzh(zzaly.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzaly.size()) {
                this.zza.zzh(i, zzaly.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zzb(list.get(i6).longValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalj.size(); i4++) {
                    i3 += zzako.zze(zzalj.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzalj.size()) {
                    this.zza.zzi(zzalj.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalj.size()) {
                this.zza.zzg(i, zzalj.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zze(list.get(i6).intValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzi(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzaly.size(); i4++) {
                    i3 += zzako.zzc(zzaly.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzaly.size()) {
                    this.zza.zzf(zzaly.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzaly.size()) {
                this.zza.zzf(i, zzaly.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zzc(list.get(i6).longValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzf(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalj.size(); i4++) {
                    i3 += zzako.zzf(zzalj.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzalj.size()) {
                    this.zza.zzk(zzalj.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalj.size()) {
                this.zza.zzi(i, zzalj.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zzf(list.get(i6).intValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzk(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzi(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzaly.size(); i4++) {
                    i3 += zzako.zzd(zzaly.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzaly.size()) {
                    this.zza.zzg(zzaly.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzaly.size()) {
                this.zza.zzg(i, zzaly.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zzd(list.get(i6).longValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzg(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalj.size(); i4++) {
                    i3 += zzako.zzh(zzalj.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzalj.size()) {
                    this.zza.zzl(zzalj.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalj.size()) {
                this.zza.zzk(i, zzalj.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zzh(list.get(i6).intValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzl(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzk(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzaly.size(); i4++) {
                    i3 += zzako.zze(zzaly.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzaly.size()) {
                    this.zza.zzh(zzaly.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzaly.size()) {
                this.zza.zzh(i, zzaly.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zze(list.get(i6).longValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static zzakq zza(zzako zzako) {
        zzakq zzakq = zzako.zza;
        if (zzakq != null) {
            return zzakq;
        }
        return new zzakq(zzako);
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zza.zzb(i, z);
    }

    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzaju) {
            zzaju zzaju = (zzaju) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzaju.size(); i4++) {
                    i3 += zzako.zza(zzaju.zzb(i4));
                }
                this.zza.zzl(i3);
                while (i2 < zzaju.size()) {
                    this.zza.zzb(zzaju.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzaju.size()) {
                this.zza.zzb(i, zzaju.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzako.zza(list.get(i6).booleanValue());
            }
            this.zza.zzl(i5);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).booleanValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).booleanValue());
                i2++;
            }
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzk(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zze(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    public final void zzb(int i, Object obj, zzanc zzanc) throws IOException {
        this.zza.zzc(i, (zzamn) obj, zzanc);
    }

    public final void zza(int i, zzajw zzajw) throws IOException {
        this.zza.zzc(i, zzajw);
    }

    public final void zzb(int i, List<?> list, zzanc zzanc) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzanc);
        }
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zza(int i, List<zzajw> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzc(i, list.get(i2));
        }
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzj(i, 3);
    }

    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzalu) {
            zzalu zzalu = (zzalu) list;
            while (i2 < list.size()) {
                Object zza2 = zzalu.zza(i2);
                if (zza2 instanceof String) {
                    this.zza.zzb(i, (String) zza2);
                } else {
                    this.zza.zzc(i, (zzajw) zza2);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2));
            i2++;
        }
    }

    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzj(i, 4);
    }

    public final void zza(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    public final void zza(int i, Object obj, zzanc zzanc) throws IOException {
        zzako zzako = this.zza;
        zzako.zzj(i, 3);
        zzanc.zza((zzamn) obj, (zzaom) zzako.zza);
        zzako.zzj(i, 4);
    }

    public final void zza(int i, List<?> list, zzanc zzanc) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzanc);
        }
    }

    public final <K, V> void zza(int i, zzame<K, V> zzame, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zza.zzj(i, 2);
            this.zza.zzl(zzamf.zza(zzame, next.getKey(), next.getValue()));
            zzamf.zza(this.zza, zzame, next.getKey(), next.getValue());
        }
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzajw) {
            this.zza.zzd(i, (zzajw) obj);
        } else {
            this.zza.zzb(i, (zzamn) obj);
        }
    }

    public final void zza(int i, String str) throws IOException {
        this.zza.zzb(i, str);
    }
}
