package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzrj;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsi  reason: invalid package */
public final class zzsi {
    private static final zzaam zza;
    private static final zznk<zzyc, zzrj.zzb> zzb = zznk.zza().zza(zzyc.RAW, zzrj.zzb.zzd).zza(zzyc.TINK, zzrj.zzb.zza).zza(zzyc.LEGACY, zzrj.zzb.zzc).zza(zzyc.CRUNCHY, zzrj.zzb.zzb).zza();
    private static final zznk<zzwb, zzrj.zzc> zzc = zznk.zza().zza(zzwb.SHA1, zzrj.zzc.zza).zza(zzwb.SHA224, zzrj.zzc.zzb).zza(zzwb.SHA256, zzrj.zzc.zzc).zza(zzwb.SHA384, zzrj.zzc.zzd).zza(zzwb.SHA512, zzrj.zzc.zze).zza();
    private static final zzpk<zzrj, zzqd> zzd;
    private static final zzpg<zzqd> zze;
    private static final zznw<zzrc, zzqe> zzf;
    private static final zzns<zzqe> zzg;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzd = zzpk.zza(new zzsl(), zzrj.class, cls);
        zze = zzpg.zza(new zzsk(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzf = zznw.zza(new zzsn(), zzrc.class, cls2);
        zzg = zzns.zza(new zzsm(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzrc zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzwa zza2 = zzwa.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzrc.zzc().zza(zzrj.zzd().zza(zza2.zzf().zzb()).zzb(zza2.zze().zza()).zza(zzc.zza(zza2.zze().zzb())).zza(zzb.zza(zzqe.zzc())).zza()).zza(zzaan.zza(zza2.zzf().zzd(), zzck.zza(zzck))).zza(zzqe.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }

    /* access modifiers changed from: private */
    public static zzrj zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzwd zza2 = zzwd.zza(zzqd.zza().zze(), zzakv.zza());
                if (zza2.zzb() == 0) {
                    return zzrj.zzd().zza(zza2.zza()).zzb(zza2.zzf().zza()).zza(zzc.zza(zza2.zzf().zzb())).zza(zzb.zza(zzqd.zza().zzd())).zza();
                }
                int zzb2 = zza2.zzb();
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzb2);
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
            }
        } else {
            String zzf2 = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + zzf2);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
    }

    private static zzwg zzb(zzrj zzrj) throws GeneralSecurityException {
        return (zzwg) ((zzalg) zzwg.zzc().zza(zzrj.zzb()).zza(zzc.zza(zzrj.zze())).zze());
    }
}
