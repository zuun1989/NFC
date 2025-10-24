package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.Blake2xsDigest;

final class zzdr {
    private final Object zza;
    private final int zzb;

    public zzdr(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdr)) {
            return false;
        }
        zzdr zzdr = (zzdr) obj;
        if (this.zza == zzdr.zza && this.zzb == zzdr.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) + this.zzb;
    }
}
