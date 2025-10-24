package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import com.google.android.gms.internal.p002firebaseauthapi.zzxk;
import com.google.android.gms.internal.p002firebaseauthapi.zzxn;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcl  reason: invalid package */
final class zzcl {
    static {
        Charset.forName("UTF-8");
    }

    public static zzxn zza(zzxk zzxk) {
        zzxn.zzb zza = zzxn.zza().zza(zzxk.zzb());
        for (zzxk.zza next : zzxk.zze()) {
            zza.zza((zzxn.zza) ((zzalg) zzxn.zza.zza().zza(next.zzb().zzf()).zza(next.zzc()).zza(next.zzf()).zza(next.zza()).zze()));
        }
        return (zzxn) ((zzalg) zza.zze());
    }

    public static void zzb(zzxk zzxk) throws GeneralSecurityException {
        int zzb = zzxk.zzb();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzxk.zza next : zzxk.zze()) {
            if (next.zzc() == zzxb.ENABLED) {
                if (!next.zzg()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zza())}));
                } else if (next.zzf() == zzyc.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zza())}));
                } else if (next.zzc() != zzxb.UNKNOWN_STATUS) {
                    if (next.zza() == zzb) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (next.zzb().zzb() != zzxa.zza.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zza())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
