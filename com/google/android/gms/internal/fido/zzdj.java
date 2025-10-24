package com.google.android.gms.internal.fido;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import java.util.Arrays;

public final class zzdj extends zzdr {
    private final boolean zza;

    public zzdj(boolean z) {
        this.zza = z;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int i;
        zzdr zzdr = (zzdr) obj;
        if (zzdr.zzd(ISO7816.INS_CREATE_FILE) != zzdr.zza()) {
            return zzdr.zzd(ISO7816.INS_CREATE_FILE) - zzdr.zza();
        }
        zzdj zzdj = (zzdj) zzdr;
        int i2 = 21;
        if (true != this.zza) {
            i = 20;
        } else {
            i = 21;
        }
        if (true != zzdj.zza) {
            i2 = 20;
        }
        return i - i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdj.class == obj.getClass() && this.zza == ((zzdj) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd(ISO7816.INS_CREATE_FILE)), Boolean.valueOf(this.zza)});
    }

    public final String toString() {
        return Boolean.toString(this.zza);
    }

    public final int zza() {
        return zzdr.zzd(ISO7816.INS_CREATE_FILE);
    }
}
