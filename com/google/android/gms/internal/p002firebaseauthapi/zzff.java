package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfe;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzff  reason: invalid package */
public final class zzff {
    private static final zzaam zza;
    private static final zzpk<zzfe, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzfc, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzfi(), zzfe.class, cls);
        zzc = zzpg.zza(new zzfh(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzfk(), zzfc.class, cls2);
        zze = zzns.zza(new zzfj(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzfc zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                zzxw zza2 = zzxw.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzfc.zza(zza(zza2.zzd(), zzqe.zzc()), zzqe.zze());
                }
                String valueOf = String.valueOf(zza2);
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + valueOf);
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
    }

    private static zzfe zza(zzxz zzxz, zzyc zzyc) throws GeneralSecurityException {
        zzfe.zzc zzc2;
        zzfe.zzb zzb2;
        zzce zza2 = zzcm.zza(((zzxe) ((zzalg) zzxe.zza().zza(zzxz.zza().zzf()).zza(zzxz.zza().zze()).zza(zzyc.RAW).zze())).zzk());
        if (zza2 instanceof zzdz) {
            zzc2 = zzfe.zzc.zza;
        } else if (zza2 instanceof zzem) {
            zzc2 = zzfe.zzc.zzc;
        } else if (zza2 instanceof zzgg) {
            zzc2 = zzfe.zzc.zzb;
        } else if (zza2 instanceof zzdk) {
            zzc2 = zzfe.zzc.zzd;
        } else if (zza2 instanceof zzdq) {
            zzc2 = zzfe.zzc.zze;
        } else if (zza2 instanceof zzeg) {
            zzc2 = zzfe.zzc.zzf;
        } else {
            String valueOf = String.valueOf(zza2);
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing " + valueOf);
        }
        zzfe.zza zza3 = new zzfe.zza();
        int i = zzfm.zza[zzyc.ordinal()];
        if (i == 1) {
            zzb2 = zzfe.zzb.zza;
        } else if (i == 2) {
            zzb2 = zzfe.zzb.zzb;
        } else {
            int zza4 = zzyc.zza();
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza4);
        }
        return zza3.zza(zzb2).zza(zzxz.zze()).zza((zzcx) zza2).zza(zzc2).zza();
    }

    /* access modifiers changed from: private */
    public static zzfe zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return zza(zzxz.zza(zzqd.zza().zze(), zzakv.zza()), zzqd.zza().zzd());
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzxz zzb(zzfe zzfe) throws GeneralSecurityException {
        try {
            return (zzxz) ((zzalg) zzxz.zzb().zza(zzfe.zzd()).zza(zzxe.zza(zzcm.zza((zzce) zzfe.zzb()), zzakv.zza())).zze());
        } catch (zzalm e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzyc zza(zzfe.zzb zzb2) throws GeneralSecurityException {
        if (zzfe.zzb.zza.equals(zzb2)) {
            return zzyc.TINK;
        }
        if (zzfe.zzb.zzb.equals(zzb2)) {
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
