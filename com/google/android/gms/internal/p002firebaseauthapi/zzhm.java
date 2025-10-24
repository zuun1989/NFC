package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzem;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhm  reason: invalid package */
public final class zzhm {
    private static final zzaam zza;
    private static final zzpk<zzem, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzei, zzqe> zzd;
    private static final zzns<zzqe> zze;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzhl(), zzem.class, cls);
        zzc = zzpg.zza(new zzho(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzhn(), zzei.class, cls2);
        zze = zzns.zza(new zzhq(), zzb2, cls2);
    }

    /* access modifiers changed from: private */
    public static zzei zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzuy zza2 = zzuy.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzei.zza(zza(zzqe.zzc()), zzaan.zza(zza2.zzd().zzd(), zzck.zza(zzck)), zzqe.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    private static zzem.zza zza(zzyc zzyc) throws GeneralSecurityException {
        int i = zzhp.zza[zzyc.ordinal()];
        if (i == 1) {
            return zzem.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzem.zza.zzb;
        }
        if (i == 4) {
            return zzem.zza.zzc;
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    /* access modifiers changed from: private */
    public static zzem zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzvb.zza(zzqd.zza().zze(), zzakv.zza());
                return zzem.zza(zza(zzqd.zza().zzd()));
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            String zzf = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: " + zzf);
        }
    }

    private static zzyc zza(zzem.zza zza2) throws GeneralSecurityException {
        if (zzem.zza.zza.equals(zza2)) {
            return zzyc.TINK;
        }
        if (zzem.zza.zzb.equals(zza2)) {
            return zzyc.CRUNCHY;
        }
        if (zzem.zza.zzc.equals(zza2)) {
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
