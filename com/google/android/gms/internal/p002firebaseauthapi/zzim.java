package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzgg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzim  reason: invalid package */
public final class zzim {
    private static final zzaam zza;
    private static final zzpk<zzgg, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzgb, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzil(), zzgg.class, cls);
        zzc = zzpg.zza(new zzio(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzin(), zzgb.class, cls2);
        zze = zzns.zza(new zziq(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzgb zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzyn zza2 = zzyn.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzgb.zza(zza(zzqe.zzc()), zzaan.zza(zza2.zzd().zzd(), zzck.zza(zzck)), zzqe.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    private static zzgg.zza zza(zzyc zzyc) throws GeneralSecurityException {
        int i = zzip.zza[zzyc.ordinal()];
        if (i == 1) {
            return zzgg.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzgg.zza.zzb;
        }
        if (i == 4) {
            return zzgg.zza.zzc;
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    /* access modifiers changed from: private */
    public static zzgg zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                if (zzyq.zza(zzqd.zza().zze(), zzakv.zza()).zza() == 0) {
                    return zzgg.zza(zza(zzqd.zza().zzd()));
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzyc zza(zzgg.zza zza2) throws GeneralSecurityException {
        if (zzgg.zza.zza.equals(zza2)) {
            return zzyc.TINK;
        }
        if (zzgg.zza.zzb.equals(zza2)) {
            return zzyc.CRUNCHY;
        }
        if (zzgg.zza.zzc.equals(zza2)) {
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
