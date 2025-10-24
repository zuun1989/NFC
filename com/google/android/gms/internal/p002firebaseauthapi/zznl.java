package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznl  reason: invalid package */
final class zznl {
    static final zznl zza;
    BigInteger zzb;
    BigInteger zzc;
    BigInteger zzd;

    static {
        BigInteger bigInteger = BigInteger.ONE;
        zza = new zznl(bigInteger, bigInteger, BigInteger.ZERO);
    }

    public zznl(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.zzb = bigInteger;
        this.zzc = bigInteger2;
        this.zzd = bigInteger3;
    }

    public final boolean zza() {
        return this.zzd.equals(BigInteger.ZERO);
    }
}
