package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdz;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgw  reason: invalid package */
public final class zzgw {
    private static final zzaam zza;
    private static final zzpk<zzdz, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzds, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzgv(), zzdz.class, cls);
        zzc = zzpg.zza(new zzgy(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzgx(), zzds.class, cls2);
        zze = zzns.zza(new zzha(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzds zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzug zza2 = zzug.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzds.zze().zza(zzdz.zze().zzb(zza2.zzd().zzb()).zza(12).zzc(16).zza(zza(zzqe.zzc())).zza()).zza(zzaan.zza(zza2.zzd().zzd(), zzck.zza(zzck))).zza(zzqe.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
    }

    private static zzdz.zzb zza(zzyc zzyc) throws GeneralSecurityException {
        int i = zzgz.zza[zzyc.ordinal()];
        if (i == 1) {
            return zzdz.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzdz.zzb.zzb;
        }
        if (i == 4) {
            return zzdz.zzb.zzc;
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    /* access modifiers changed from: private */
    public static zzdz zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzuj zza2 = zzuj.zza(zzqd.zza().zze(), zzakv.zza());
                if (zza2.zzb() == 0) {
                    return zzdz.zze().zzb(zza2.zza()).zza(12).zzc(16).zza(zza(zzqd.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzyc zza(zzdz.zzb zzb2) throws GeneralSecurityException {
        if (zzdz.zzb.zza.equals(zzb2)) {
            return zzyc.TINK;
        }
        if (zzdz.zzb.zzb.equals(zzb2)) {
            return zzyc.CRUNCHY;
        }
        if (zzdz.zzb.zzc.equals(zzb2)) {
            return zzyc.RAW;
        }
        String valueOf = String.valueOf(zzb2);
        throw new GeneralSecurityException("Unable to serialize variant: " + valueOf);
    }

    /* access modifiers changed from: private */
    public static void zzb(zzdz zzdz) throws GeneralSecurityException {
        if (zzdz.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", new Object[]{Integer.valueOf(zzdz.zzd())}));
        } else if (zzdz.zzb() != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", new Object[]{Integer.valueOf(zzdz.zzb())}));
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
