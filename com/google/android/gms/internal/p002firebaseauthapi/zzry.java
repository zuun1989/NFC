package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqw;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzry  reason: invalid package */
public final class zzry {
    private static final zzaam zza;
    private static final zzpk<zzqw, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzqp, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzsb(), zzqw.class, cls);
        zzc = zzpg.zza(new zzsa(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzsd(), zzqp.class, cls2);
        zze = zzns.zza(new zzsc(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzqp zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzsz zza2 = zzsz.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzqp.zzc().zza(zzqw.zzd().zza(zza2.zze().zzb()).zzb(zza2.zzd().zza()).zza(zza(zzqe.zzc())).zza()).zza(zzaan.zza(zza2.zze().zzd(), zzck.zza(zzck))).zza(zzqe.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
    }

    /* access modifiers changed from: private */
    public static zzqw zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zztc zza2 = zztc.zza(zzqd.zza().zze(), zzakv.zza());
                return zzqw.zzd().zza(zza2.zza()).zzb(zza2.zzd().zza()).zza(zza(zzqd.zza().zzd())).zza();
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzqw.zzb zza(zzyc zzyc) throws GeneralSecurityException {
        int i = zzsf.zza[zzyc.ordinal()];
        if (i == 1) {
            return zzqw.zzb.zza;
        }
        if (i == 2) {
            return zzqw.zzb.zzb;
        }
        if (i == 3) {
            return zzqw.zzb.zzc;
        }
        if (i == 4) {
            return zzqw.zzb.zzd;
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    private static zztf zzb(zzqw zzqw) {
        return (zztf) ((zzalg) zztf.zzb().zza(zzqw.zzb()).zze());
    }

    private static zzyc zza(zzqw.zzb zzb2) throws GeneralSecurityException {
        if (zzqw.zzb.zza.equals(zzb2)) {
            return zzyc.TINK;
        }
        if (zzqw.zzb.zzb.equals(zzb2)) {
            return zzyc.CRUNCHY;
        }
        if (zzqw.zzb.zzd.equals(zzb2)) {
            return zzyc.RAW;
        }
        if (zzqw.zzb.zzc.equals(zzb2)) {
            return zzyc.LEGACY;
        }
        String valueOf = String.valueOf(zzb2);
        throw new GeneralSecurityException("Unable to serialize variant: " + valueOf);
    }

    public static void zza() throws GeneralSecurityException {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
