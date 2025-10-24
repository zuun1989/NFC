package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoc  reason: invalid package */
public class zzoc<P> implements zzbk<P> {
    final String zza;
    final zzxa.zza zzb;
    private final Class<P> zzc;

    public zzoc(String str, Class<P> cls, zzxa.zza zza2, zzamw<? extends zzamn> zzamw) {
        this.zza = str;
        this.zzc = cls;
        this.zzb = zza2;
    }

    public static <P> zzbk<P> zza(String str, Class<P> cls, zzxa.zza zza2, zzamw<? extends zzamn> zzamw) {
        return new zzoc(str, cls, zza2, zzamw);
    }

    public final P zzb(zzajw zzajw) throws GeneralSecurityException {
        return zzoz.zza().zza(zzpc.zza().zza(zzqe.zza(this.zza, zzajw, this.zzb, zzyc.RAW, (Integer) null), zzbi.zza()), this.zzc);
    }

    public static <P> zzcg<P> zza(String str, Class<P> cls, zzamw<? extends zzamn> zzamw) {
        return new zzof(str, cls, zzamw);
    }

    public final zzxa zza(zzajw zzajw) throws GeneralSecurityException {
        zzqe zzqe = (zzqe) zzpc.zza().zza(zzos.zza().zza(zzpc.zza().zza(zzqd.zza((zzxe) ((zzalg) zzxe.zza().zza(this.zza).zza(zzajw).zza(zzyc.RAW).zze()))), (Integer) null), zzqe.class, zzbi.zza());
        return (zzxa) ((zzalg) zzxa.zza().zza(zzqe.zzf()).zza(zzqe.zzd()).zza(zzqe.zza()).zze());
    }

    public final String zzb() {
        return this.zza;
    }

    public final Class<P> zza() {
        return this.zzc;
    }
}
