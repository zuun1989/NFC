package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkt  reason: invalid package */
public final class zzkt extends zzll {
    private final zzki zza;
    private final zzaam zzb;
    private final zzaam zzc;
    private final Integer zzd;

    private zzkt(zzki zzki, zzaam zzaam, zzaam zzaam2, Integer num) {
        this.zza = zzki;
        this.zzb = zzaam;
        this.zzc = zzaam2;
        this.zzd = num;
    }

    public final /* synthetic */ zzce zza() {
        return (zzki) zza();
    }

    public final Integer zzb() {
        return this.zzd;
    }

    public final /* synthetic */ zzlj zzc() {
        return this.zza;
    }

    public final zzaam zzd() {
        return this.zzc;
    }

    public final zzaam zze() {
        return this.zzb;
    }

    public static zzkt zza(zzki zzki, zzaam zzaam, Integer num) throws GeneralSecurityException {
        zzaam zzaam2;
        EllipticCurve ellipticCurve;
        zzki.zzf zzf = zzki.zzf();
        zzki.zzf zzf2 = zzki.zzf.zzc;
        if (!zzf.equals(zzf2) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzf) + " variant.");
        } else if (!zzf.equals(zzf2) || num == null) {
            zzki.zzd zze = zzki.zze();
            int zza2 = zzaam.zza();
            String str = "Encoded public key byte length for " + String.valueOf(zze) + " must be %d, not " + zza2;
            zzki.zzd zzd2 = zzki.zzd.zza;
            if (zze == zzd2) {
                if (zza2 != 65) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{65}));
                }
            } else if (zze == zzki.zzd.zzb) {
                if (zza2 != 97) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{97}));
                }
            } else if (zze == zzki.zzd.zzc) {
                if (zza2 != 133) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{133}));
                }
            } else if (zze != zzki.zzd.zzd) {
                throw new GeneralSecurityException("Unable to validate public key length for " + String.valueOf(zze));
            } else if (zza2 != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
            if (zze == zzd2 || zze == zzki.zzd.zzb || zze == zzki.zzd.zzc) {
                if (zze == zzd2) {
                    ellipticCurve = zzni.zza.getCurve();
                } else if (zze == zzki.zzd.zzb) {
                    ellipticCurve = zzni.zzb.getCurve();
                } else if (zze == zzki.zzd.zzc) {
                    ellipticCurve = zzni.zzc.getCurve();
                } else {
                    throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zze));
                }
                zzni.zza(zzzi.zza(ellipticCurve, zzzk.UNCOMPRESSED, zzaam.zzb()), ellipticCurve);
            }
            zzki.zzf zzf3 = zzki.zzf();
            if (zzf3 == zzf2) {
                zzaam2 = zzpd.zza;
            } else if (num == null) {
                throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant " + String.valueOf(zzf3));
            } else if (zzf3 == zzki.zzf.zzb) {
                zzaam2 = zzpd.zza(num.intValue());
            } else if (zzf3 == zzki.zzf.zza) {
                zzaam2 = zzpd.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown HpkeParameters.Variant: " + String.valueOf(zzf3));
            }
            return new zzkt(zzki, zzaam, zzaam2, num);
        } else {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }
}
