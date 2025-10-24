package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoe  reason: invalid package */
public final class zzoe extends zzbh {
    private final zzqe zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoe$zza */
    public static class zza extends zzce {
        private final String zza;
        private final zzyc zzb;

        public final String toString() {
            String str;
            String str2 = this.zza;
            int i = zzog.zza[this.zzb.ordinal()];
            if (i == 1) {
                str = "TINK";
            } else if (i == 2) {
                str = "LEGACY";
            } else if (i == 3) {
                str = "RAW";
            } else if (i != 4) {
                str = "UNKNOWN";
            } else {
                str = "CRUNCHY";
            }
            return String.format("(typeUrl=%s, outputPrefixType=%s)", new Object[]{str2, str});
        }

        public final boolean zza() {
            if (this.zzb != zzyc.RAW) {
                return true;
            }
            return false;
        }

        private zza(String str, zzyc zzyc) {
            this.zza = str;
            this.zzb = zzyc;
        }
    }

    public zzoe(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        zza(zzqe, zzck);
        this.zza = zzqe;
    }

    public final zzce zza() {
        return new zza(this.zza.zzf(), this.zza.zzc());
    }

    public final Integer zzb() {
        return this.zza.zze();
    }

    public final zzaam zzc() throws GeneralSecurityException {
        zzqe zzqe = this.zza;
        if (zzqe.zzc().equals(zzyc.RAW)) {
            return zzaam.zza(new byte[0]);
        }
        if (zzqe.zzc().equals(zzyc.TINK)) {
            return zzpd.zzb(zzqe.zze().intValue());
        }
        if (zzqe.zzc().equals(zzyc.LEGACY) || zzqe.zzc().equals(zzyc.CRUNCHY)) {
            return zzpd.zza(zzqe.zze().intValue());
        }
        throw new GeneralSecurityException("Unknown output prefix type");
    }

    public final zzqe zza(zzck zzck) throws GeneralSecurityException {
        zza(this.zza, zzck);
        return this.zza;
    }

    private static void zza(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        int i = zzog.zzb[zzqe.zza().ordinal()];
        if (i == 1 || i == 2) {
            zzck.zza(zzck);
        }
    }
}
