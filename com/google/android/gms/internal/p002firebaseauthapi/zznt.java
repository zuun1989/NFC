package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznt  reason: invalid package */
public final class zznt {
    private static final Logger zza = Logger.getLogger(zznt.class.getName());
    private static final zznt zzb = new zznt();
    private ConcurrentMap<String, zzbk<?>> zzc = new ConcurrentHashMap();
    private ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();

    private final synchronized zzbk<?> zzc(String str) throws GeneralSecurityException {
        if (this.zzc.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type " + str + ", see https://developers.google.com/tink/faq/registration_errors");
        }
        return this.zzc.get(str);
    }

    public final <P> zzbk<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zzbk<?> zzc2 = zzc(str);
        if (zzc2.zza().equals(cls)) {
            return zzc2;
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzc2.getClass());
        String valueOf2 = String.valueOf(zzc2.zza());
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", which only supports: " + valueOf2);
    }

    public final boolean zzb(String str) {
        return this.zzd.get(str).booleanValue();
    }

    public final zzbk<?> zza(String str) throws GeneralSecurityException {
        return zzc(str);
    }

    public static zznt zza() {
        return zzb;
    }

    private final synchronized void zza(zzbk<?> zzbk, boolean z, boolean z2) throws GeneralSecurityException {
        try {
            String zzb2 = zzbk.zzb();
            if (z2 && this.zzd.containsKey(zzb2)) {
                if (!this.zzd.get(zzb2).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + zzb2);
                }
            }
            zzbk zzbk2 = this.zzc.get(zzb2);
            if (zzbk2 != null) {
                if (!zzbk2.getClass().equals(zzbk.getClass())) {
                    Logger logger = zza;
                    Level level = Level.WARNING;
                    logger.logp(level, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type " + zzb2);
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{zzb2, zzbk2.getClass().getName(), zzbk.getClass().getName()}));
                }
            }
            this.zzc.putIfAbsent(zzb2, zzbk);
            this.zzd.put(zzb2, Boolean.valueOf(z2));
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized <P> void zza(zzbk<P> zzbk, boolean z) throws GeneralSecurityException {
        zza(zzbk, zzix.zza.ALGORITHM_NOT_FIPS, z);
    }

    public final synchronized <P> void zza(zzbk<P> zzbk, zzix.zza zza2, boolean z) throws GeneralSecurityException {
        if (zza2.zza()) {
            zza((zzbk<?>) zzbk, false, z);
        } else {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
    }
}
