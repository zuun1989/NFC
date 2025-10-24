package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdq;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgo  reason: invalid package */
public final class zzgo {
    private static final zzaam zza;
    private static final zzpk<zzdq, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzdl, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzgn(), zzdq.class, cls);
        zzc = zzpg.zza(new zzgq(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzgp(), zzdl.class, cls2);
        zze = zzns.zza(new zzgs(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzdl zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zztx zza2 = zztx.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzdl.zze().zza(zzdq.zze().zzb(zza2.zze().zzb()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzqe.zzc())).zza()).zza(zzaan.zza(zza2.zze().zzd(), zzck.zza(zzck))).zza(zzqe.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
    }

    private static zzdq.zza zza(zzyc zzyc) throws GeneralSecurityException {
        int i = zzgr.zza[zzyc.ordinal()];
        if (i == 1) {
            return zzdq.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzdq.zza.zzb;
        }
        if (i == 4) {
            return zzdq.zza.zzc;
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    /* access modifiers changed from: private */
    public static zzdq zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzua zza2 = zzua.zza(zzqd.zza().zze(), zzakv.zza());
                return zzdq.zze().zzb(zza2.zza()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzqd.zza().zzd())).zza();
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzyc zza(zzdq.zza zza2) throws GeneralSecurityException {
        if (zzdq.zza.zza.equals(zza2)) {
            return zzyc.TINK;
        }
        if (zzdq.zza.zzb.equals(zza2)) {
            return zzyc.CRUNCHY;
        }
        if (zzdq.zza.zzc.equals(zza2)) {
            return zzyc.RAW;
        }
        String valueOf = String.valueOf(zza2);
        throw new GeneralSecurityException("Unable to serialize variant: " + valueOf);
    }

    private static zzud zzb(zzdq zzdq) throws GeneralSecurityException {
        if (zzdq.zzd() == 16) {
            return (zzud) ((zzalg) zzud.zzb().zza(zzdq.zzb()).zze());
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", new Object[]{Integer.valueOf(zzdq.zzd())}));
    }

    public static void zza() throws GeneralSecurityException {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
