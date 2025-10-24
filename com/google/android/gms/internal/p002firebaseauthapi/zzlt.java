package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import com.google.android.gms.internal.p002firebaseauthapi.zzvm;
import com.google.android.gms.internal.p002firebaseauthapi.zzvs;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlt  reason: invalid package */
public final class zzlt {
    private static final zzaam zza;
    private static final zzaam zzb;
    private static final zzpk<zzke, zzqd> zzc;
    private static final zzpg<zzqd> zzd;
    private static final zznw<zzkg, zzqe> zze;
    private static final zzns<zzqe> zzf;
    private static final zznw<zzkh, zzqe> zzg;
    private static final zzns<zzqe> zzh;
    private static final zznk<zzyc, zzke.zze> zzi;
    private static final zznk<zzwb, zzke.zzd> zzj = zznk.zza().zza(zzwb.SHA1, zzke.zzd.zza).zza(zzwb.SHA224, zzke.zzd.zzb).zza(zzwb.SHA256, zzke.zzd.zzc).zza(zzwb.SHA384, zzke.zzd.zzd).zza(zzwb.SHA512, zzke.zzd.zze).zza();
    private static final zznk<zzvv, zzke.zza> zzk = zznk.zza().zza(zzvv.NIST_P256, zzke.zza.zza).zza(zzvv.NIST_P384, zzke.zza.zzb).zza(zzvv.NIST_P521, zzke.zza.zzc).zza(zzvv.CURVE25519, zzke.zza.zzd).zza();
    private static final zznk<zzve, zzke.zzc> zzl = zznk.zza().zza(zzve.UNCOMPRESSED, zzke.zzc.zzb).zza(zzve.COMPRESSED, zzke.zzc.zza).zza(zzve.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzke.zzc.zzc).zza();

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zza = zzb2;
        zzaam zzb3 = zzqq.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
        zzb = zzb3;
        Class<zzqd> cls = zzqd.class;
        zzc = zzpk.zza(new zzls(), zzke.class, cls);
        zzd = zzpg.zza(new zzlv(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zze = zznw.zza(new zzlu(), zzkg.class, cls2);
        zzf = zzns.zza(new zzlx(), zzb3, cls2);
        zzg = zznw.zza(new zzlw(), zzkh.class, cls2);
        zzh = zzns.zza(new zzlz(), zzb2, cls2);
        zznn zza2 = zznk.zza().zza(zzyc.RAW, zzke.zze.zzc).zza(zzyc.TINK, zzke.zze.zza);
        zzyc zzyc = zzyc.LEGACY;
        zzke.zze zze2 = zzke.zze.zzb;
        zzi = zza2.zza(zzyc, zze2).zza(zzyc.CRUNCHY, zze2).zza();
    }

    /* access modifiers changed from: private */
    public static zzkh zzc(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                zzvm zza2 = zzvm.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    zzvp zzd2 = zza2.zzd();
                    if (zzd2.zza() == 0) {
                        zzke zza3 = zza(zzqe.zzc(), zzd2.zzb());
                        if (zza3.zzd().equals(zzke.zza.zzd)) {
                            return zzkh.zza(zzkg.zza(zza3, zzaam.zza(zzd2.zzf().zzd()), zzqe.zze()), zzaan.zza(zza2.zze().zzd(), zzck.zza(zzck)));
                        }
                        return zzkh.zza(zzkg.zza(zza3, new ECPoint(zznh.zza(zzd2.zzf().zzd()), zznh.zza(zzd2.zzg().zzd())), zzqe.zze()), zzaal.zza(zznh.zza(zza2.zze().zzd()), zzck.zza(zzck)));
                    }
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
            }
        } else {
            String zzf2 = zzqe.zzf();
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: " + zzf2);
        }
    }

    /* access modifiers changed from: private */
    public static zzkg zzd(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
            try {
                zzvp zza2 = zzvp.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    zzke zza3 = zza(zzqe.zzc(), zza2.zzb());
                    if (!zza3.zzd().equals(zzke.zza.zzd)) {
                        return zzkg.zza(zza3, new ECPoint(zznh.zza(zza2.zzf().zzd()), zznh.zza(zza2.zzg().zzd())), zzqe.zze());
                    }
                    if (zza2.zzg().zzb() == 0) {
                        return zzkg.zza(zza3, zzaam.zza(zza2.zzf().zzd()), zzqe.zze());
                    }
                    throw new GeneralSecurityException("Y must be empty for X25519 points");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
            }
        } else {
            String zzf2 = zzqe.zzf();
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: " + zzf2);
        }
    }

    /* access modifiers changed from: private */
    public static zzke zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                return zza(zzqd.zza().zzd(), zzvg.zza(zzqd.zza().zze(), zzakv.zza()).zzc());
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
            }
        } else {
            String zzf2 = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parseParameters: " + zzf2);
        }
    }

    private static int zza(zzke.zza zza2) throws GeneralSecurityException {
        if (zzke.zza.zza.equals(zza2)) {
            return 33;
        }
        if (zzke.zza.zzb.equals(zza2)) {
            return 49;
        }
        if (zzke.zza.zzc.equals(zza2)) {
            return 67;
        }
        String valueOf = String.valueOf(zza2);
        throw new GeneralSecurityException("Unable to serialize CurveType " + valueOf);
    }

    private static zzke zza(zzyc zzyc, zzvj zzvj) throws GeneralSecurityException {
        zzke.zzb zza2 = zzke.zzc().zza(zzi.zza(zzyc)).zza(zzk.zza(zzvj.zzf().zzd())).zza(zzj.zza(zzvj.zzf().zze())).zza(zzcm.zza(((zzxe) ((zzalg) zzxe.zza().zza(zzvj.zzb().zzd().zzf()).zza(zzyc.RAW).zza(zzvj.zzb().zzd().zze()).zze())).zzk())).zza(zzaam.zza(zzvj.zzf().zzf().zzd()));
        if (!zzvj.zzf().zzd().equals(zzvv.CURVE25519)) {
            zza2.zza(zzl.zza(zzvj.zza()));
        } else if (!zzvj.zza().equals(zzve.COMPRESSED)) {
            throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
        }
        return zza2.zza();
    }

    private static zzvj zzb(zzke zzke) throws GeneralSecurityException {
        zzvs.zza zza2 = zzvs.zza().zza(zzk.zza(zzke.zzd())).zza(zzj.zza(zzke.zze()));
        if (zzke.zzh() != null && zzke.zzh().zza() > 0) {
            zza2.zza(zzajw.zza(zzke.zzh().zzb()));
        }
        zzvs zzvs = (zzvs) ((zzalg) zza2.zze());
        try {
            zzxe zza3 = zzxe.zza(zzcm.zza(zzke.zzb()), zzakv.zza());
            zzvd zzvd = (zzvd) ((zzalg) zzvd.zza().zza((zzxe) ((zzalg) zzxe.zza().zza(zza3.zzf()).zza(zzyc.TINK).zza(zza3.zze()).zze())).zze());
            zzke.zzc zzf2 = zzke.zzf();
            if (zzf2 == null) {
                zzf2 = zzke.zzc.zza;
            }
            return (zzvj) ((zzalg) zzvj.zzc().zza(zzvs).zza(zzvd).zza(zzl.zza(zzf2)).zze());
        } catch (zzalm e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzqe zza(zzkh zzkh, zzck zzck) {
        zzvm.zza zza2 = zzvm.zzb().zza(0).zza(zza((zzkg) ((zzll) zzkh.zzc())));
        if (((zzke) ((zzlj) zzkh.zza())).zzd().equals(zzke.zza.zzd)) {
            zza2.zza(zzajw.zza(zzkh.zzg().zza(zzck.zza(zzck))));
        } else {
            zza2.zza(zzajw.zza(zznh.zza(zzkh.zzf().zza(zzck.zza(zzck)), zza(((zzke) ((zzlj) zzkh.zza())).zzd()))));
        }
        return zzqe.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", ((zzvm) ((zzalg) zza2.zze())).zzj(), zzxa.zza.ASYMMETRIC_PRIVATE, zzi.zza(((zzke) ((zzlj) zzkh.zza())).zzg()), zzkh.zzb());
    }

    private static zzvp zza(zzkg zzkg) throws GeneralSecurityException {
        if (((zzke) ((zzlj) zzkg.zza())).zzd().equals(zzke.zza.zzd)) {
            return (zzvp) ((zzalg) zzvp.zzc().zza(0).zza(zzb((zzke) ((zzlj) zzkg.zza()))).zza(zzajw.zza(zzkg.zze().zzb())).zzb(zzajw.zza).zze());
        }
        int zza2 = zza(((zzke) ((zzlj) zzkg.zza())).zzd());
        ECPoint zzf2 = zzkg.zzf();
        if (zzf2 != null) {
            return (zzvp) ((zzalg) zzvp.zzc().zza(0).zza(zzb((zzke) ((zzlj) zzkg.zza()))).zza(zzajw.zza(zznh.zza(zzf2.getAffineX(), zza2))).zzb(zzajw.zza(zznh.zza(zzf2.getAffineY(), zza2))).zze());
        }
        throw new GeneralSecurityException("NistCurvePoint was null for NIST curve");
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
