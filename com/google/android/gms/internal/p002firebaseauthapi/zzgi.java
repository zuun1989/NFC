package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdk;
import com.google.android.gms.internal.p002firebaseauthapi.zzwg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgi  reason: invalid package */
public final class zzgi {
    private static final zzaam zza;
    private static final zzpk<zzdk, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzdd, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzgh(), zzdk.class, cls);
        zzc = zzpg.zza(new zzgk(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzgj(), zzdd.class, cls2);
        zze = zzns.zza(new zzgm(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzdd zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzti zza2 = zzti.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zza2.zzd().zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                } else if (zza2.zze().zza() == 0) {
                    return zzdd.zze().zza(zzdk.zzf().zza(zza2.zzd().zzf().zzb()).zzb(zza2.zze().zzf().zzb()).zzc(zza2.zzd().zze().zza()).zzd(zza2.zze().zze().zza()).zza(zza(zza2.zze().zze().zzb())).zza(zza(zzqe.zzc())).zza()).zza(zzaan.zza(zza2.zzd().zzf().zzd(), zzck.zza(zzck))).zzb(zzaan.zza(zza2.zze().zzf().zzd(), zzck.zza(zzck))).zza(zzqe.zze()).zza();
                } else {
                    throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                }
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }

    private static zzdk.zzc zza(zzwb zzwb) throws GeneralSecurityException {
        int i = zzgl.zzb[zzwb.ordinal()];
        if (i == 1) {
            return zzdk.zzc.zza;
        }
        if (i == 2) {
            return zzdk.zzc.zzb;
        }
        if (i == 3) {
            return zzdk.zzc.zzc;
        }
        if (i == 4) {
            return zzdk.zzc.zzd;
        }
        if (i == 5) {
            return zzdk.zzc.zze;
        }
        int zza2 = zzwb.zza();
        throw new GeneralSecurityException("Unable to parse HashType: " + zza2);
    }

    private static zzdk.zzb zza(zzyc zzyc) throws GeneralSecurityException {
        int i = zzgl.zza[zzyc.ordinal()];
        if (i == 1) {
            return zzdk.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzdk.zzb.zzb;
        }
        if (i == 4) {
            return zzdk.zzb.zzc;
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    /* access modifiers changed from: private */
    public static zzdk zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zztl zza2 = zztl.zza(zzqd.zza().zze(), zzakv.zza());
                if (zza2.zzd().zzb() == 0) {
                    return zzdk.zzf().zza(zza2.zzc().zza()).zzb(zza2.zzd().zza()).zzc(zza2.zzc().zze().zza()).zzd(zza2.zzd().zzf().zza()).zza(zza(zza2.zzd().zzf().zzb())).zza(zza(zzqd.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzwg zzb(zzdk zzdk) throws GeneralSecurityException {
        zzwb zzwb;
        zzwg.zza zza2 = zzwg.zzc().zza(zzdk.zze());
        zzdk.zzc zzg = zzdk.zzg();
        if (zzdk.zzc.zza.equals(zzg)) {
            zzwb = zzwb.SHA1;
        } else if (zzdk.zzc.zzb.equals(zzg)) {
            zzwb = zzwb.SHA224;
        } else if (zzdk.zzc.zzc.equals(zzg)) {
            zzwb = zzwb.SHA256;
        } else if (zzdk.zzc.zzd.equals(zzg)) {
            zzwb = zzwb.SHA384;
        } else if (zzdk.zzc.zze.equals(zzg)) {
            zzwb = zzwb.SHA512;
        } else {
            String valueOf = String.valueOf(zzg);
            throw new GeneralSecurityException("Unable to serialize HashType " + valueOf);
        }
        return (zzwg) ((zzalg) zza2.zza(zzwb).zze());
    }

    private static zzyc zza(zzdk.zzb zzb2) throws GeneralSecurityException {
        if (zzdk.zzb.zza.equals(zzb2)) {
            return zzyc.TINK;
        }
        if (zzdk.zzb.zzb.equals(zzb2)) {
            return zzyc.CRUNCHY;
        }
        if (zzdk.zzb.zzc.equals(zzb2)) {
            return zzyc.RAW;
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
