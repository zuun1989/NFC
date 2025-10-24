package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzof  reason: invalid package */
final class zzof<P> extends zzoc<P> implements zzcg<P> {
    public zzof(String str, Class<P> cls, zzamw<? extends zzamn> zzamw) {
        super(str, cls, zzxa.zza.ASYMMETRIC_PRIVATE, zzamw);
    }

    public final zzxa zzc(zzajw zzajw) throws GeneralSecurityException {
        zzbh zza = zzpc.zza().zza(zzqe.zza(this.zza, zzajw, this.zzb, zzyc.RAW, (Integer) null), zzbi.zza());
        if (zza instanceof zzcd) {
            zzqe zzqe = (zzqe) zzpc.zza().zza(((zzcd) zza).zzc(), zzqe.class, zzbi.zza());
            return (zzxa) ((zzalg) zzxa.zza().zza(zzqe.zzf()).zza(zzqe.zzd()).zza(zzqe.zza()).zze());
        }
        throw new GeneralSecurityException("Key not private key");
    }
}
