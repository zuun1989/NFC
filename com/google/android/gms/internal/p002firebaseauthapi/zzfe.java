package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfe  reason: invalid package */
public final class zzfe extends zzcx {
    private final zzb zza;
    private final String zzb;
    private final zzc zzc;
    private final zzcx zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfe$zza */
    public static class zza {
        private zzb zza;
        private String zzb;
        private zzc zzc;
        private zzcx zzd;

        private zza() {
        }

        public final zza zza(zzcx zzcx) {
            this.zzd = zzcx;
            return this;
        }

        public final zza zza(zzc zzc2) {
            this.zzc = zzc2;
            return this;
        }

        public final zza zza(String str) {
            this.zzb = str;
            return this;
        }

        public final zza zza(zzb zzb2) {
            this.zza = zzb2;
            return this;
        }

        public final zzfe zza() throws GeneralSecurityException {
            if (this.zza == null) {
                this.zza = zzb.zzb;
            }
            if (this.zzb == null) {
                throw new GeneralSecurityException("kekUri must be set");
            } else if (this.zzc != null) {
                zzcx zzcx = this.zzd;
                if (zzcx == null) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must be set");
                } else if (!zzcx.zza()) {
                    zzc zzc2 = this.zzc;
                    zzcx zzcx2 = this.zzd;
                    if ((zzc2.equals(zzc.zza) && (zzcx2 instanceof zzdz)) || ((zzc2.equals(zzc.zzc) && (zzcx2 instanceof zzem)) || ((zzc2.equals(zzc.zzb) && (zzcx2 instanceof zzgg)) || ((zzc2.equals(zzc.zzd) && (zzcx2 instanceof zzdk)) || ((zzc2.equals(zzc.zze) && (zzcx2 instanceof zzdq)) || (zzc2.equals(zzc.zzf) && (zzcx2 instanceof zzeg))))))) {
                        return new zzfe(this.zza, this.zzb, this.zzc, this.zzd);
                    }
                    String zzc3 = this.zzc.toString();
                    String valueOf = String.valueOf(this.zzd);
                    throw new GeneralSecurityException("Cannot use parsing strategy " + zzc3 + " when new keys are picked according to " + valueOf + ".");
                } else {
                    throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
                }
            } else {
                throw new GeneralSecurityException("dekParsingStrategy must be set");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfe$zzb */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("NO_PREFIX");
        private final String zzc;

        private zzb(String str) {
            this.zzc = str;
        }

        public final String toString() {
            return this.zzc;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfe$zzc */
    public static final class zzc {
        public static final zzc zza = new zzc("ASSUME_AES_GCM");
        public static final zzc zzb = new zzc("ASSUME_XCHACHA20POLY1305");
        public static final zzc zzc = new zzc("ASSUME_CHACHA20POLY1305");
        public static final zzc zzd = new zzc("ASSUME_AES_CTR_HMAC");
        public static final zzc zze = new zzc("ASSUME_AES_EAX");
        public static final zzc zzf = new zzc("ASSUME_AES_GCM_SIV");
        private final String zzg;

        private zzc(String str) {
            this.zzg = str;
        }

        public final String toString() {
            return this.zzg;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfe)) {
            return false;
        }
        zzfe zzfe = (zzfe) obj;
        if (!zzfe.zzc.equals(this.zzc) || !zzfe.zzd.equals(this.zzd) || !zzfe.zzb.equals(this.zzb) || !zzfe.zza.equals(this.zza)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzfe.class, this.zzb, this.zzc, this.zzd, this.zza});
    }

    public final String toString() {
        String str = this.zzb;
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        String valueOf3 = String.valueOf(this.zza);
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + str + ", dekParsingStrategy: " + valueOf + ", dekParametersForNewKeys: " + valueOf2 + ", variant: " + valueOf3 + ")";
    }

    public final boolean zza() {
        if (this.zza != zzb.zzb) {
            return true;
        }
        return false;
    }

    public final zzcx zzb() {
        return this.zzd;
    }

    public final zzb zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    private zzfe(zzb zzb2, String str, zzc zzc2, zzcx zzcx) {
        this.zza = zzb2;
        this.zzb = str;
        this.zzc = zzc2;
        this.zzd = zzcx;
    }
}
