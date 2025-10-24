package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.XDHParameterSpec;
import com.google.android.gms.internal.p002firebaseauthapi.zzdk;
import com.google.android.gms.internal.p002firebaseauthapi.zzdz;
import com.google.android.gms.internal.p002firebaseauthapi.zzjh;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzke  reason: invalid package */
public final class zzke extends zzlj {
    /* access modifiers changed from: private */
    public static final Set<zzce> zza = ((Set) zzqo.zza(new zzkd()));
    private final zza zzb;
    private final zzd zzc;
    private final zzc zzd;
    private final zze zze;
    private final zzce zzf;
    private final zzaam zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzke$zza */
    public static final class zza {
        public static final zza zza = new zza("NIST_P256");
        public static final zza zzb = new zza("NIST_P384");
        public static final zza zzc = new zza("NIST_P521");
        public static final zza zzd = new zza(XDHParameterSpec.X25519);
        private final String zze;

        private zza(String str) {
            this.zze = str;
        }

        public final String toString() {
            return this.zze;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzke$zzb */
    public static final class zzb {
        private zza zza;
        private zzd zzb;
        private zzc zzc;
        private zzce zzd;
        private zze zze;
        private zzaam zzf;

        public final zzb zza(zza zza2) {
            this.zza = zza2;
            return this;
        }

        private zzb() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = zze.zzc;
            this.zzf = null;
        }

        public final zzb zza(zzce zzce) throws GeneralSecurityException {
            if (zzke.zza.contains(zzce)) {
                this.zzd = zzce;
                return this;
            }
            String valueOf = String.valueOf(zzce);
            throw new GeneralSecurityException("Invalid DEM parameters " + valueOf + "; only AES128_GCM_RAW, AES256_GCM_RAW, AES128_CTR_HMAC_SHA256_RAW, AES256_CTR_HMAC_SHA256_RAW XCHACHA20_POLY1305_RAW and AES256_SIV_RAW are currently supported.");
        }

        public final zzb zza(zzd zzd2) {
            this.zzb = zzd2;
            return this;
        }

        public final zzb zza(zzc zzc2) {
            this.zzc = zzc2;
            return this;
        }

        public final zzb zza(zzaam zzaam) {
            if (zzaam.zza() == 0) {
                this.zzf = null;
                return this;
            }
            this.zzf = zzaam;
            return this;
        }

        public final zzb zza(zze zze2) {
            this.zze = zze2;
            return this;
        }

        public final zzke zza() throws GeneralSecurityException {
            zza zza2 = this.zza;
            if (zza2 == null) {
                throw new GeneralSecurityException("Elliptic curve type is not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("Hash type is not set");
            } else if (this.zzd == null) {
                throw new GeneralSecurityException("DEM parameters are not set");
            } else if (this.zze != null) {
                zza zza3 = zza.zzd;
                if (zza2 != zza3 && this.zzc == null) {
                    throw new GeneralSecurityException("Point format is not set");
                } else if (zza2 != zza3 || this.zzc == null) {
                    return new zzke(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
                } else {
                    throw new GeneralSecurityException("For Curve25519 point format must not be set");
                }
            } else {
                throw new GeneralSecurityException("Variant is not set");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzke$zzc */
    public static final class zzc {
        public static final zzc zza = new zzc("COMPRESSED");
        public static final zzc zzb = new zzc("UNCOMPRESSED");
        public static final zzc zzc = new zzc("LEGACY_UNCOMPRESSED");
        private final String zzd;

        private zzc(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzke$zzd */
    public static final class zzd {
        public static final zzd zza = new zzd("SHA1");
        public static final zzd zzb = new zzd("SHA224");
        public static final zzd zzc = new zzd("SHA256");
        public static final zzd zzd = new zzd("SHA384");
        public static final zzd zze = new zzd("SHA512");
        private final String zzf;

        private zzd(String str) {
            this.zzf = str;
        }

        public final String toString() {
            return this.zzf;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzke$zze */
    public static final class zze {
        public static final zze zza = new zze("TINK");
        public static final zze zzb = new zze("CRUNCHY");
        public static final zze zzc = new zze("NO_PREFIX");
        private final String zzd;

        private zze(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    public static zzb zzc() {
        return new zzb();
    }

    public static /* synthetic */ Set zzj() throws Exception {
        HashSet hashSet = new HashSet();
        zzdz.zza zzc2 = zzdz.zze().zza(12).zzb(16).zzc(16);
        zzdz.zzb zzb2 = zzdz.zzb.zzc;
        hashSet.add(zzc2.zza(zzb2).zza());
        hashSet.add(zzdz.zze().zza(12).zzb(32).zzc(16).zza(zzb2).zza());
        zzdk.zza zzc3 = zzdk.zzf().zza(16).zzb(32).zzd(16).zzc(16);
        zzdk.zzc zzc4 = zzdk.zzc.zzc;
        zzdk.zza zza2 = zzc3.zza(zzc4);
        zzdk.zzb zzb3 = zzdk.zzb.zzc;
        hashSet.add(zza2.zza(zzb3).zza());
        hashSet.add(zzdk.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzc4).zza(zzb3).zza());
        hashSet.add(zzgg.zzc());
        hashSet.add(zzjh.zzc().zza(64).zza(zzjh.zzb.zzc).zza());
        return Collections.unmodifiableSet(hashSet);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzke)) {
            return false;
        }
        zzke zzke = (zzke) obj;
        if (!Objects.equals(zzke.zzb, this.zzb) || !Objects.equals(zzke.zzc, this.zzc) || !Objects.equals(zzke.zzd, this.zzd) || !Objects.equals(zzke.zzf, this.zzf) || !Objects.equals(zzke.zze, this.zze) || !Objects.equals(zzke.zzg, this.zzg)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzke.class, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    public final String toString() {
        return String.format("EciesParameters(curveType=%s, hashType=%s, pointFormat=%s, demParameters=%s, variant=%s, salt=%s)", new Object[]{this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    public final boolean zza() {
        if (this.zze != zze.zzc) {
            return true;
        }
        return false;
    }

    public final zzce zzb() {
        return this.zzf;
    }

    public final zza zzd() {
        return this.zzb;
    }

    public final zzd zze() {
        return this.zzc;
    }

    public final zzc zzf() {
        return this.zzd;
    }

    public final zze zzg() {
        return this.zze;
    }

    public final zzaam zzh() {
        return this.zzg;
    }

    private zzke(zza zza2, zzd zzd2, zzc zzc2, zzce zzce, zze zze2, zzaam zzaam) {
        this.zzb = zza2;
        this.zzc = zzd2;
        this.zzd = zzc2;
        this.zzf = zzce;
        this.zze = zze2;
        this.zzg = zzaam;
    }
}
