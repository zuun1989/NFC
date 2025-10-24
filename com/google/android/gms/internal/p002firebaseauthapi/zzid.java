package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfz;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzid  reason: invalid package */
public final class zzid {
    private static final zzaam zza;
    private static final zzpk<zzfz, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzfv, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzig(), zzfz.class, cls);
        zzc = zzpg.zza(new zzif(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzii(), zzfv.class, cls2);
        zze = zzns.zza(new zzih(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzfv zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            try {
                zzye zza2 = zzye.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zza2.zze().zzb() == 32) {
                    return zzfv.zza(zzfz.zza(zza(zzqe.zzc()), zza2.zzd().zza()), zzaan.zza(zza2.zze().zzd(), zzck.zza(zzck)), zzqe.zze());
                } else {
                    throw new GeneralSecurityException("Only 32 byte key size is accepted");
                }
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing XAesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
        }
    }

    private static zzfz.zza zza(zzyc zzyc) throws GeneralSecurityException {
        int i = zzik.zza[zzyc.ordinal()];
        if (i == 1) {
            return zzfz.zza.zza;
        }
        if (i == 2) {
            return zzfz.zza.zzb;
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    /* access modifiers changed from: private */
    public static zzfz zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            try {
                zzyh zza2 = zzyh.zza(zzqd.zza().zze(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzfz.zza(zza(zzqd.zza().zzd()), zza2.zzd().zza());
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzyc zza(zzfz.zza zza2) throws GeneralSecurityException {
        if (Objects.equals(zza2, zzfz.zza.zza)) {
            return zzyc.TINK;
        }
        if (Objects.equals(zza2, zzfz.zza.zzb)) {
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
