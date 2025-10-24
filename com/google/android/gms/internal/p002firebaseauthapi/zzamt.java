package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamt  reason: invalid package */
final class zzamt<T> implements zzanc<T> {
    private final zzamn zza;
    private final zzanv<?, ?> zzb;
    private final boolean zzc;
    private final zzakx<?> zzd;

    private zzamt(zzanv<?, ?> zzanv, zzakx<?> zzakx, zzamn zzamn) {
        this.zzb = zzanv;
        this.zzc = zzakx.zza(zzamn);
        this.zzd = zzakx;
        this.zza = zzamn;
    }

    public final int zza(T t) {
        zzanv<?, ?> zzanv = this.zzb;
        int zzb2 = zzanv.zzb(zzanv.zzd(t));
        return this.zzc ? zzb2 + this.zzd.zza((Object) t).zza() : zzb2;
    }

    public final int zzb(T t) {
        int hashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    public final void zzd(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    public final boolean zze(T t) {
        return this.zzd.zza((Object) t).zzg();
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public static <T> zzamt<T> zza(zzanv<?, ?> zzanv, zzakx<?> zzakx, zzamn zzamn) {
        return new zzamt<>(zzanv, zzakx, zzamn);
    }

    public final T zza() {
        zzamn zzamn = this.zza;
        if (zzamn instanceof zzalg) {
            return ((zzalg) zzamn).zzo();
        }
        return zzamn.zzq().zzf();
    }

    public final void zza(T t, T t2) {
        zzane.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzane.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzand zzand, zzakv zzakv) throws IOException {
        boolean z;
        zzanv<?, ?> zzanv = this.zzb;
        zzakx<?> zzakx = this.zzd;
        Object zzc2 = zzanv.zzc(t);
        zzaky<?> zzb2 = zzakx.zzb(t);
        do {
            try {
                if (zzand.zzc() == Integer.MAX_VALUE) {
                    zzanv.zzb((Object) t, zzc2);
                    return;
                }
                int zzd2 = zzand.zzd();
                int i = 0;
                if (zzd2 == 11) {
                    Object obj = null;
                    zzajw zzajw = null;
                    while (zzand.zzc() != Integer.MAX_VALUE) {
                        int zzd3 = zzand.zzd();
                        if (zzd3 != 16) {
                            if (zzd3 != 26) {
                                if (zzd3 == 12 || !zzand.zzt()) {
                                    break;
                                }
                            } else if (obj != null) {
                                zzakx.zza(zzand, obj, zzakv, zzb2);
                            } else {
                                zzajw = zzand.zzp();
                            }
                        } else {
                            i = zzand.zzj();
                            obj = zzakx.zza(zzakv, this.zza, i);
                        }
                    }
                    if (zzand.zzd() != 12) {
                        throw zzalm.zzb();
                    } else if (zzajw != null) {
                        if (obj != null) {
                            zzakx.zza(zzajw, obj, zzakv, zzb2);
                        } else {
                            zzanv.zza(zzc2, i, zzajw);
                        }
                    }
                } else if ((zzd2 & 7) == 2) {
                    Object zza2 = zzakx.zza(zzakv, this.zza, zzd2 >>> 3);
                    if (zza2 != null) {
                        zzakx.zza(zzand, zza2, zzakv, zzb2);
                    } else {
                        z = zzanv.zza(zzc2, zzand, 0);
                        continue;
                    }
                } else {
                    z = zzand.zzt();
                    continue;
                }
                z = true;
                continue;
            } catch (Throwable th) {
                zzanv.zzb((Object) t, zzc2);
                throw th;
            }
        } while (z);
        zzanv.zzb((Object) t, zzc2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.firebase-auth-api.zzalg$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.p002firebaseauthapi.zzajv r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.firebase-auth-api.zzalg r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalg) r0
            com.google.android.gms.internal.firebase-auth-api.zzany r1 = r0.zzb
            com.google.android.gms.internal.firebase-auth-api.zzany r2 = com.google.android.gms.internal.p002firebaseauthapi.zzany.zzc()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.firebase-auth-api.zzany r1 = com.google.android.gms.internal.p002firebaseauthapi.zzany.zzd()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.firebase-auth-api.zzalg$zzd r10 = (com.google.android.gms.internal.p002firebaseauthapi.zzalg.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajs.zzc(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.firebase-auth-api.zzakx<?> r12 = r9.zzd
            com.google.android.gms.internal.firebase-auth-api.zzakv r0 = r14.zzd
            com.google.android.gms.internal.firebase-auth-api.zzamn r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.firebase-auth-api.zzalg$zzf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalg.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.p002firebaseauthapi.zzajs.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzany) r6, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.p002firebaseauthapi.zzamy.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.p002firebaseauthapi.zzajs.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajs.zzc(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajs.zza(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.firebase-auth-api.zzajw r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzajw) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.p002firebaseauthapi.zzamy.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajs.zzc(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.firebase-auth-api.zzakx<?> r0 = r9.zzd
            com.google.android.gms.internal.firebase-auth-api.zzakv r5 = r14.zzd
            com.google.android.gms.internal.firebase-auth-api.zzamn r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.firebase-auth-api.zzalg$zzf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalg.zzf) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzajs.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza((int) r12, (java.lang.Object) r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.firebase-auth-api.zzalm r10 = com.google.android.gms.internal.p002firebaseauthapi.zzalm.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamt.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzajv):void");
    }

    public final void zza(T t, zzaom zzaom) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzala zzala = (zzala) next.getKey();
            if (zzala.zzc() != zzaok.MESSAGE || zzala.zze() || zzala.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzalq) {
                zzaom.zza(zzala.zza(), (Object) ((zzalq) next).zza().zzb());
            } else {
                zzaom.zza(zzala.zza(), next.getValue());
            }
        }
        zzanv<?, ?> zzanv = this.zzb;
        zzanv.zza(zzanv.zzd(t), zzaom);
    }
}
