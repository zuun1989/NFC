package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzev;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzex  reason: invalid package */
final class zzex {
    private static final zzaam zza;
    private static final zzpk<zzev, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzew, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzez(), zzev.class, cls);
        zzc = zzpg.zza(new zzey(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzfb(), zzew.class, cls2);
        zze = zzns.zza(new zzfa(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzew zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                zzxq zza2 = zzxq.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzew.zza(zzev.zza(zza2.zzd().zzd(), zza(zzqe.zzc())), zzqe.zze());
                }
                String valueOf = String.valueOf(zza2);
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + valueOf);
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
    }

    private static zzev.zza zza(zzyc zzyc) throws GeneralSecurityException {
        int i = zzfd.zza[zzyc.ordinal()];
        if (i == 1) {
            return zzev.zza.zza;
        }
        if (i == 2) {
            return zzev.zza.zzb;
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    /* access modifiers changed from: private */
    public static zzev zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                return zzev.zza(zzxt.zza(zzqd.zza().zze(), zzakv.zza()).zzd(), zza(zzqd.zza().zzd()));
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzyc zza(zzev.zza zza2) throws GeneralSecurityException {
        if (zzev.zza.zza.equals(zza2)) {
            return zzyc.TINK;
        }
        if (zzev.zza.zzb.equals(zza2)) {
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
