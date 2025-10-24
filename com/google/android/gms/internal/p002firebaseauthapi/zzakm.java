package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakm  reason: invalid package */
final class zzakm implements zzand {
    private final zzaki zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzakm(zzaki zzaki) {
        zzaki zzaki2 = (zzaki) zzali.zza(zzaki, "input");
        this.zza = zzaki2;
        zzaki2.zzc = this;
    }

    public final double zza() throws IOException {
        zzb(1);
        return this.zza.zza();
    }

    public final float zzb() throws IOException {
        zzb(5);
        return this.zza.zzb();
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i2 = this.zzb;
        return (i2 == 0 || i2 == this.zzc) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i2 >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzb(0);
        return this.zza.zzd();
    }

    public final int zzf() throws IOException {
        zzb(5);
        return this.zza.zze();
    }

    public final int zzg() throws IOException {
        zzb(0);
        return this.zza.zzf();
    }

    public final int zzh() throws IOException {
        zzb(5);
        return this.zza.zzg();
    }

    public final int zzi() throws IOException {
        zzb(0);
        return this.zza.zzh();
    }

    public final int zzj() throws IOException {
        zzb(0);
        return this.zza.zzj();
    }

    public final long zzk() throws IOException {
        zzb(1);
        return this.zza.zzk();
    }

    public final long zzl() throws IOException {
        zzb(0);
        return this.zza.zzl();
    }

    public final long zzm() throws IOException {
        zzb(1);
        return this.zza.zzn();
    }

    public final long zzn() throws IOException {
        zzb(0);
        return this.zza.zzo();
    }

    public final long zzo() throws IOException {
        zzb(0);
        return this.zza.zzp();
    }

    public final zzajw zzp() throws IOException {
        zzb(2);
        return this.zza.zzq();
    }

    public final String zzq() throws IOException {
        zzb(2);
        return this.zza.zzr();
    }

    public final String zzr() throws IOException {
        zzb(2);
        return this.zza.zzs();
    }

    public final boolean zzs() throws IOException {
        zzb(0);
        return this.zza.zzx();
    }

    public final boolean zzt() throws IOException {
        int i;
        if (this.zza.zzw() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zze(i);
    }

    private final <T> void zzd(T t, zzanc<T> zzanc, zzakv zzakv) throws IOException {
        int zzj = this.zza.zzj();
        this.zza.zzt();
        int zzb2 = this.zza.zzb(zzj);
        this.zza.zza++;
        zzanc.zza(t, this, zzakv);
        this.zza.zzc(0);
        zzaki zzaki = this.zza;
        zzaki.zza--;
        zzaki.zzd(zzb2);
    }

    public static zzakm zza(zzaki zzaki) {
        zzakm zzakm = zzaki.zzc;
        if (zzakm != null) {
            return zzakm;
        }
        return new zzakm(zzaki);
    }

    private final <T> T zzb(zzanc<T> zzanc, zzakv zzakv) throws IOException {
        T zza2 = zzanc.zza();
        zzd(zza2, zzanc, zzakv);
        zzanc.zzd(zza2);
        return zza2;
    }

    public final void zze(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzalj.zzc(this.zza.zze());
                } while (this.zza.zzc() < zzc2);
            } else if (i == 5) {
                do {
                    zzalj.zzc(this.zza.zze());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzc(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                } while (this.zza.zzc() < zzc3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzaly.zza(this.zza.zzk());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzaly.zza(this.zza.zzk());
                } while (this.zza.zzc() < zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzk()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzd(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Long.valueOf(this.zza.zzk()));
                } while (this.zza.zzc() < zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzg(List<Float> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzale) {
            zzale zzale = (zzale) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzale.zza(this.zza.zzb());
                } while (this.zza.zzc() < zzc2);
            } else if (i == 5) {
                do {
                    zzale.zza(this.zza.zzb());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzc(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                } while (this.zza.zzc() < zzc3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzh(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzalj.zzc(this.zza.zzf());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzalj.zzc(this.zza.zzf());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzi(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaly.zza(this.zza.zzl());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzaly.zza(this.zza.zzl());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzl()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzl()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzj(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzalj.zzc(this.zza.zzg());
                } while (this.zza.zzc() < zzc2);
            } else if (i == 5) {
                do {
                    zzalj.zzc(this.zza.zzg());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzc(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzc() < zzc3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzk(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzaly.zza(this.zza.zzn());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzaly.zza(this.zza.zzn());
                } while (this.zza.zzc() < zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzd(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                } while (this.zza.zzc() < zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzalj.zzc(this.zza.zzh());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzalj.zzc(this.zza.zzh());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzm(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaly.zza(this.zza.zzo());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzaly.zza(this.zza.zzo());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzn(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzo(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzp(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzalj.zzc(this.zza.zzj());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzalj.zzc(this.zza.zzj());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final void zzq(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzaly) {
            zzaly zzaly = (zzaly) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaly.zza(this.zza.zzp());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzaly.zza(this.zza.zzp());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    private final Object zza(zzaoh zzaoh, Class<?> cls, zzakv zzakv) throws IOException {
        switch (zzakp.zza[zzaoh.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzamy.zza().zza(cls), zzakv);
            case 11:
                return Integer.valueOf(zzh());
            case 12:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final <T> void zzc(T t, zzanc<T> zzanc, zzakv zzakv) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzanc.zza(t, this, zzakv);
            if (this.zzb != this.zzc) {
                throw zzalm.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    public final <T> void zzb(T t, zzanc<T> zzanc, zzakv zzakv) throws IOException {
        zzb(2);
        zzd(t, zzanc, zzakv);
    }

    public final void zzb(List<zzajw> list) throws IOException {
        int zzi;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (!this.zza.zzw()) {
                    zzi = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        throw zzalm.zza();
    }

    public final void zzd(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzalj) {
            zzalj zzalj = (zzalj) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzalj.zzc(this.zza.zzd());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzalj.zzc(this.zza.zzd());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzd()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzd()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    public final <T> void zzb(List<T> list, zzanc<T> zzanc, zzakv zzakv) throws IOException {
        int zzi;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzb(zzanc, zzakv));
                if (!this.zza.zzw() && this.zzd == 0) {
                    zzi = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi == i);
            this.zzd = zzi;
            return;
        }
        throw zzalm.zza();
    }

    public final void zzc(List<Double> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzakt) {
            zzakt zzakt = (zzakt) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzakt.zza(this.zza.zza());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzakt.zza(this.zza.zza());
                } while (this.zza.zzc() < zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzd(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                } while (this.zza.zzc() < zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    private final void zzb(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzalm.zza();
        }
    }

    private final <T> T zza(zzanc<T> zzanc, zzakv zzakv) throws IOException {
        T zza2 = zzanc.zza();
        zzc(zza2, zzanc, zzakv);
        zzanc.zzd(zza2);
        return zza2;
    }

    public final <T> void zza(T t, zzanc<T> zzanc, zzakv zzakv) throws IOException {
        zzb(3);
        zzc(t, zzanc, zzakv);
    }

    public final void zza(List<Boolean> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzaju) {
            zzaju zzaju = (zzaju) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaju.zza(this.zza.zzx());
                    if (!this.zza.zzw()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzaju.zza(this.zza.zzx());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzalm.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzx()));
                    if (!this.zza.zzw()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Boolean.valueOf(this.zza.zzx()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzalm.zza();
            }
        }
    }

    private static void zzd(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzalm.zzg();
        }
    }

    private static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzalm.zzg();
        }
    }

    @Deprecated
    public final <T> void zza(List<T> list, zzanc<T> zzanc, zzakv zzakv) throws IOException {
        int zzi;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zza(zzanc, zzakv));
                if (!this.zza.zzw() && this.zzd == 0) {
                    zzi = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi == i);
            this.zzd = zzi;
            return;
        }
        throw zzalm.zza();
    }

    public final <K, V> void zza(Map<K, V> map, zzame<K, V> zzame, zzakv zzakv) throws IOException {
        String str;
        zzb(2);
        int zzb2 = this.zza.zzb(this.zza.zzj());
        K k = zzame.zzb;
        V v = zzame.zzd;
        while (true) {
            try {
                int zzc2 = zzc();
                if (zzc2 == Integer.MAX_VALUE || this.zza.zzw()) {
                    map.put(k, v);
                } else {
                    str = "Unable to parse map entry.";
                    if (zzc2 == 1) {
                        k = zza(zzame.zza, (Class<?>) null, (zzakv) null);
                    } else if (zzc2 == 2) {
                        v = zza(zzame.zzc, zzame.zzd.getClass(), zzakv);
                    } else if (!zzt()) {
                        throw new zzalm(str);
                    }
                }
            } catch (zzalp e) {
                if (!zzt()) {
                    throw new zzalm(str, e);
                }
            } catch (Throwable th) {
                this.zza.zzd(zzb2);
                throw th;
            }
        }
        map.put(k, v);
        this.zza.zzd(zzb2);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzi;
        int zzi2;
        if ((this.zzb & 7) != 2) {
            throw zzalm.zza();
        } else if (!(list instanceof zzalu) || z) {
            do {
                list.add(z ? zzr() : zzq());
                if (!this.zza.zzw()) {
                    zzi = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
        } else {
            zzalu zzalu = (zzalu) list;
            do {
                zzalu.zza(zzp());
                if (!this.zza.zzw()) {
                    zzi2 = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        }
    }

    private final void zza(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw zzalm.zzj();
        }
    }
}
