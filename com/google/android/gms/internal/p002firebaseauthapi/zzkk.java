package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkk  reason: invalid package */
public final class zzkk {
    private static final zzaam zza;
    private static final zzaam zzb;
    private static final zzpk<zzki, zzqd> zzc;
    private static final zzpg<zzqd> zzd;
    private static final zznw<zzkt, zzqe> zze;
    private static final zzns<zzqe> zzf;
    private static final zznw<zzkl, zzqe> zzg;
    private static final zzns<zzqe> zzh;
    private static final zznk<zzyc, zzki.zzf> zzi;
    private static final zznk<zzwl, zzki.zzd> zzj = zznk.zza().zza(zzwl.DHKEM_P256_HKDF_SHA256, zzki.zzd.zza).zza(zzwl.DHKEM_P384_HKDF_SHA384, zzki.zzd.zzb).zza(zzwl.DHKEM_P521_HKDF_SHA512, zzki.zzd.zzc).zza(zzwl.DHKEM_X25519_HKDF_SHA256, zzki.zzd.zzd).zza();
    private static final zznk<zzwm, zzki.zze> zzk = zznk.zza().zza(zzwm.HKDF_SHA256, zzki.zze.zza).zza(zzwm.HKDF_SHA384, zzki.zze.zzb).zza(zzwm.HKDF_SHA512, zzki.zze.zzc).zza();
    private static final zznk<zzwj, zzki.zza> zzl = zznk.zza().zza(zzwj.AES_128_GCM, zzki.zza.zza).zza(zzwj.AES_256_GCM, zzki.zza.zzb).zza(zzwj.CHACHA20_POLY1305, zzki.zza.zzc).zza();

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zza = zzb2;
        zzaam zzb3 = zzqq.zzb("type.googleapis.com/google.crypto.tink.HpkePublicKey");
        zzb = zzb3;
        Class<zzqd> cls = zzqd.class;
        zzc = zzpk.zza(new zzkn(), zzki.class, cls);
        zzd = zzpg.zza(new zzkm(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zze = zznw.zza(new zzkp(), zzkt.class, cls2);
        zzf = zzns.zza(new zzko(), zzb3, cls2);
        zzg = zznw.zza(new zzkr(), zzkl.class, cls2);
        zzh = zzns.zza(new zzkq(), zzb2, cls2);
        zznn zza2 = zznk.zza().zza(zzyc.RAW, zzki.zzf.zzc).zza(zzyc.TINK, zzki.zzf.zza);
        zzyc zzyc = zzyc.LEGACY;
        zzki.zzf zzf2 = zzki.zzf.zzb;
        zzi = zza2.zza(zzyc, zzf2).zza(zzyc.CRUNCHY, zzf2).zza();
    }

    /* access modifiers changed from: private */
    public static zzkl zzc(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                zzwu zza2 = zzwu.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    zzwx zzd2 = zza2.zzd();
                    if (zzd2.zza() == 0) {
                        zzki zza3 = zza(zzqe.zzc(), zzd2.zzb());
                        return zzkl.zza(zzkt.zza(zza3, zza(zza3.zze(), zzd2.zzf().zzd()), zzqe.zze()), zzaan.zza(zznh.zza(zznh.zza(zza2.zze().zzd()), zzmn.zza(zza3.zze())), zzck.zza(zzck)));
                    }
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
            }
        } else {
            String zzf2 = zzqe.zzf();
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: " + zzf2);
        }
    }

    /* access modifiers changed from: private */
    public static zzkt zzd(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            try {
                zzwx zza2 = zzwx.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    zzki zza3 = zza(zzqe.zzc(), zza2.zzb());
                    return zzkt.zza(zza3, zza(zza3.zze(), zza2.zzf().zzd()), zzqe.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing HpkePublicKey failed");
            }
        } else {
            String zzf2 = zzqe.zzf();
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: " + zzf2);
        }
    }

    /* access modifiers changed from: private */
    public static zzki zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                return zza(zzqd.zza().zzd(), zzwo.zza(zzqd.zza().zze(), zzakv.zza()).zzc());
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e);
            }
        } else {
            String zzf2 = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: " + zzf2);
        }
    }

    private static zzki zza(zzyc zzyc, zzwr zzwr) throws GeneralSecurityException {
        return zzki.zzc().zza(zzi.zza(zzyc)).zza(zzj.zza(zzwr.zzc())).zza(zzk.zza(zzwr.zzb())).zza(zzl.zza(zzwr.zza())).zza();
    }

    private static zzwr zzb(zzki zzki) throws GeneralSecurityException {
        return (zzwr) ((zzalg) zzwr.zzd().zza(zzj.zza(zzki.zze())).zza(zzk.zza(zzki.zzd())).zza(zzl.zza(zzki.zzb())).zze());
    }

    private static zzwx zza(zzkt zzkt) throws GeneralSecurityException {
        return (zzwx) ((zzalg) zzwx.zzc().zza(0).zza(zzb((zzki) ((zzlj) zzkt.zza()))).zza(zzajw.zza(zzkt.zze().zzb())).zze());
    }

    private static zzaam zza(zzki.zzd zzd2, byte[] bArr) throws GeneralSecurityException {
        return zzaam.zza(zznh.zza(zznh.zza(bArr), zzmn.zzb(zzd2)));
    }

    public static void zza() throws GeneralSecurityException {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
        zza2.zza(zzh);
    }
}
