package com.google.android.gms.internal.measurement;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.Blake2xsDigest;

final class zzlq {
    private final Object zza;
    private final int zzb;

    public zzlq(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlq)) {
            return false;
        }
        zzlq zzlq = (zzlq) obj;
        if (this.zza == zzlq.zza && this.zzb == zzlq.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) + this.zzb;
    }
}
