package com.google.android.gms.internal.fido;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import java.util.Arrays;

public final class zzdm extends zzdr {
    private final long zza;

    public zzdm(long j) {
        this.zza = j;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzdr zzdr = (zzdr) obj;
        if (zza() != zzdr.zza()) {
            return zza() - zzdr.zza();
        }
        int i = (Math.abs(this.zza) > Math.abs(((zzdm) zzdr).zza) ? 1 : (Math.abs(this.zza) == Math.abs(((zzdm) zzdr).zza) ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            return 1;
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdm.class == obj.getClass() && this.zza == ((zzdm) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zza()), Long.valueOf(this.zza)});
    }

    public final String toString() {
        return Long.toString(this.zza);
    }

    public final int zza() {
        return zzdr.zzd(this.zza >= 0 ? 0 : ISO7816.INS_VERIFY);
    }

    public final long zzc() {
        return this.zza;
    }
}
