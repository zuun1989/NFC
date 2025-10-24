package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzos  reason: invalid package */
public final class zzos {
    private static final zzou<zzoh> zza = new zzor();
    private static final zzos zzb = zzb();
    private final Map<Class<? extends zzce>, zzou<? extends zzce>> zzc = new HashMap();

    private final synchronized <ParametersT extends zzce> zzbh zzb(ParametersT parameterst, Integer num) throws GeneralSecurityException {
        zzou zzou;
        zzou = this.zzc.get(parameterst.getClass());
        if (zzou != null) {
        } else {
            String valueOf = String.valueOf(parameterst);
            throw new GeneralSecurityException("Cannot create a new key for parameters " + valueOf + ": no key creator for this class was registered.");
        }
        return zzou.zza(parameterst, num);
    }

    public final zzbh zza(zzce zzce, Integer num) throws GeneralSecurityException {
        return zzb(zzce, num);
    }

    public static /* synthetic */ zzoe zza(zzoh zzoh, Integer num) {
        zzxe zza2 = zzoh.zzb().zza();
        zzbk<?> zza3 = zznt.zza().zza(zza2.zzf());
        if (zznt.zza().zzb(zza2.zzf())) {
            zzxa zza4 = zza3.zza(zza2.zze());
            return new zzoe(zzqe.zza(zza4.zzf(), zza4.zze(), zza4.zzb(), zza2.zzd(), num), zzbi.zza());
        }
        throw new GeneralSecurityException("Creating new keys is not allowed.");
    }

    private static zzos zzb() {
        zzos zzos = new zzos();
        try {
            zzos.zza(zza, zzoh.class);
            return zzos;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public static zzos zza() {
        return zzb;
    }

    public final synchronized <ParametersT extends zzce> void zza(zzou<ParametersT> zzou, Class<ParametersT> cls) throws GeneralSecurityException {
        try {
            zzou zzou2 = this.zzc.get(cls);
            if (zzou2 != null) {
                if (!zzou2.equals(zzou)) {
                    String valueOf = String.valueOf(cls);
                    throw new GeneralSecurityException("Different key creator for parameters class " + valueOf + " already inserted");
                }
            }
            this.zzc.put(cls, zzou);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }
}
