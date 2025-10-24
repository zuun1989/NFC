package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdk  reason: invalid package */
public final class zzdk extends zzcx {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzb zze;
    private final zzc zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdk$zza */
    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private Integer zzc;
        private Integer zzd;
        private zzc zze;
        private zzb zzf;

        public final zza zza(int i) throws GeneralSecurityException {
            if (i == 16 || i == 24 || i == 32) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
        }

        public final zza zzb(int i) throws GeneralSecurityException {
            if (i >= 16) {
                this.zzb = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", new Object[]{Integer.valueOf(i)}));
        }

        public final zza zzc(int i) throws GeneralSecurityException {
            if (i < 12 || i > 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", new Object[]{Integer.valueOf(i)}));
            }
            this.zzc = Integer.valueOf(i);
            return this;
        }

        public final zza zzd(int i) throws GeneralSecurityException {
            if (i >= 10) {
                this.zzd = Integer.valueOf(i);
                return this;
            }
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(i)}));
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzf = zzb.zzc;
        }

        public final zza zza(zzc zzc2) {
            this.zze = zzc2;
            return this;
        }

        public final zza zza(zzb zzb2) {
            this.zzf = zzb2;
            return this;
        }

        public final zzdk zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("AES key size is not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("HMAC key size is not set");
            } else if (this.zzc != null) {
                Integer num = this.zzd;
                if (num == null) {
                    throw new GeneralSecurityException("tag size is not set");
                } else if (this.zze == null) {
                    throw new GeneralSecurityException("hash type is not set");
                } else if (this.zzf != null) {
                    int intValue = num.intValue();
                    zzc zzc2 = this.zze;
                    if (zzc2 == zzc.zza) {
                        if (intValue > 20) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{num}));
                        }
                    } else if (zzc2 == zzc.zzb) {
                        if (intValue > 28) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{num}));
                        }
                    } else if (zzc2 == zzc.zzc) {
                        if (intValue > 32) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{num}));
                        }
                    } else if (zzc2 == zzc.zzd) {
                        if (intValue > 48) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{num}));
                        }
                    } else if (zzc2 != zzc.zze) {
                        throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                    } else if (intValue > 64) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{num}));
                    }
                    return new zzdk(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze);
                } else {
                    throw new GeneralSecurityException("variant is not set");
                }
            } else {
                throw new GeneralSecurityException("iv size is not set");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdk$zzb */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("NO_PREFIX");
        private final String zzd;

        private zzb(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdk$zzc */
    public static final class zzc {
        public static final zzc zza = new zzc("SHA1");
        public static final zzc zzb = new zzc("SHA224");
        public static final zzc zzc = new zzc("SHA256");
        public static final zzc zzd = new zzc("SHA384");
        public static final zzc zze = new zzc("SHA512");
        private final String zzf;

        private zzc(String str) {
            this.zzf = str;
        }

        public final String toString() {
            return this.zzf;
        }
    }

    public static zza zzf() {
        return new zza();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdk)) {
            return false;
        }
        zzdk zzdk = (zzdk) obj;
        if (zzdk.zza == this.zza && zzdk.zzb == this.zzb && zzdk.zzc == this.zzc && zzdk.zzd == this.zzd && zzdk.zze == this.zze && zzdk.zzf == this.zzf) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzdk.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        int i = this.zzc;
        int i2 = this.zzd;
        int i3 = this.zza;
        int i4 = this.zzb;
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i + "-byte IV, and " + i2 + "-byte tags, and " + i3 + "-byte AES key, and " + i4 + "-byte HMAC key)";
    }

    public final boolean zza() {
        if (this.zze != zzb.zzc) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzc zzg() {
        return this.zzf;
    }

    public final zzb zzh() {
        return this.zze;
    }

    private zzdk(int i, int i2, int i3, int i4, zzb zzb2, zzc zzc2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzb2;
        this.zzf = zzc2;
    }
}
