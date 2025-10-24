package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhe  reason: invalid package */
public final class zzhe {
    private static final zzaam zza;
    private static final zzpk<zzeg, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzeb, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzhd(), zzeg.class, cls);
        zzc = zzpg.zza(new zzhg(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzhf(), zzeb.class, cls2);
        zze = zzns.zza(new zzhi(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzeb zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzum zza2 = zzum.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzeb.zze().zza(zzeg.zzc().zza(zza2.zzd().zzb()).zza(zza(zzqe.zzc())).zza()).zza(zzaan.zza(zza2.zzd().zzd(), zzck.zza(zzck))).zza(zzqe.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
    }

    private static zzeg.zza zza(zzyc zzyc) throws GeneralSecurityException {
        int i = zzhh.zza[zzyc.ordinal()];
        if (i == 1) {
            return zzeg.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzeg.zza.zzb;
        }
        if (i == 4) {
            return zzeg.zza.zzc;
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    /* access modifiers changed from: private */
    public static zzeg zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzup zza2 = zzup.zza(zzqd.zza().zze(), zzakv.zza());
                if (zza2.zzb() == 0) {
                    return zzeg.zzc().zza(zza2.zza()).zza(zza(zzqd.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzyc zza(zzeg.zza zza2) throws GeneralSecurityException {
        if (zzeg.zza.zza.equals(zza2)) {
            return zzyc.TINK;
        }
        if (zzeg.zza.zzb.equals(zza2)) {
            return zzyc.CRUNCHY;
        }
        if (zzeg.zza.zzc.equals(zza2)) {
            return zzyc.RAW;
        }
        String valueOf = String.valueOf(zza2);
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
