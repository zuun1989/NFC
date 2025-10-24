package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.Blake2xsDigest;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaku  reason: invalid package */
final class zzaku {
    private final Object zza;
    private final int zzb;

    public zzaku(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaku)) {
            return false;
        }
        zzaku zzaku = (zzaku) obj;
        if (this.zza == zzaku.zza && this.zzb == zzaku.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) + this.zzb;
    }
}
