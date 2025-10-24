package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkh  reason: invalid package */
public final class zzkh extends zzli {
    private final zzkg zza;
    private final zzaal zzb;
    private final zzaan zzc;

    private zzkh(zzkg zzkg, zzaal zzaal, zzaan zzaan) {
        this.zza = zzkg;
        this.zzb = zzaal;
        this.zzc = zzaan;
    }

    public final /* synthetic */ zzce zza() {
        return (zzke) zza();
    }

    public final /* synthetic */ zzbh zzc() {
        return (zzkg) zzc();
    }

    public final /* synthetic */ zzlj zzd() {
        return (zzke) ((zzlj) this.zza.zza());
    }

    public final /* synthetic */ zzll zze() {
        return this.zza;
    }

    public final zzaal zzf() {
        return this.zzb;
    }

    public final zzaan zzg() {
        return this.zzc;
    }

    public static zzkh zza(zzkg zzkg, zzaan zzaan) throws GeneralSecurityException {
        if (zzkg == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        } else if (zzkg.zze() == null) {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        } else if (zzaan != null) {
            byte[] zza2 = zzaan.zza(zzbi.zza());
            byte[] zzb2 = zzkg.zze().zzb();
            if (zza2.length != 32) {
                throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
            } else if (Arrays.equals(zzaak.zza(zza2), zzb2)) {
                return new zzkh(zzkg, (zzaal) null, zzaan);
            } else {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
    }

    public static zzkh zza(zzkg zzkg, zzaal zzaal) throws GeneralSecurityException {
        if (zzkg == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        } else if (zzkg.zzf() == null) {
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        } else if (zzaal != null) {
            BigInteger zza2 = zzaal.zza(zzbi.zza());
            ECPoint zzf = zzkg.zzf();
            zzke.zza zzd = ((zzke) ((zzlj) zzkg.zza())).zzd();
            BigInteger order = zza(zzd).getOrder();
            if (zza2.signum() <= 0 || zza2.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private value");
            } else if (zzni.zza(zza2, zza(zzd)).equals(zzf)) {
                return new zzkh(zzkg, zzaal, (zzaan) null);
            } else {
                throw new GeneralSecurityException("Invalid private value");
            }
        } else {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
    }

    private static ECParameterSpec zza(zzke.zza zza2) {
        if (zza2 == zzke.zza.zza) {
            return zzni.zza;
        }
        if (zza2 == zzke.zza.zzb) {
            return zzni.zzb;
        }
        if (zza2 == zzke.zza.zzc) {
            return zzni.zzc;
        }
        String valueOf = String.valueOf(zza2);
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + valueOf);
    }
}
