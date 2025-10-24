package com.google.android.gms.internal.fido;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzdi extends zzdr {
    private final zzaz zza;
    private final int zzb;

    public zzdi(zzaz zzaz) throws zzdh {
        zzaz.getClass();
        this.zza = zzaz;
        int i = 0;
        int i2 = 0;
        while (true) {
            zzaz zzaz2 = this.zza;
            if (i >= zzaz2.size()) {
                break;
            }
            int zzb2 = ((zzdr) zzaz2.get(i)).zzb();
            if (i2 < zzb2) {
                i2 = zzb2;
            }
            i++;
        }
        int i3 = i2 + 1;
        this.zzb = i3;
        if (i3 > 4) {
            throw new zzdh("Exceeded cutoff limit for max depth of cbor value");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzdr zzdr = (zzdr) obj;
        if (zzdr.zzd(ISOFileInfo.DATA_BYTES1) != zzdr.zza()) {
            return zzdr.zzd(ISOFileInfo.DATA_BYTES1) - zzdr.zza();
        }
        zzdi zzdi = (zzdi) zzdr;
        zzaz zzaz = this.zza;
        int size = zzaz.size();
        zzaz zzaz2 = zzdi.zza;
        if (size != zzaz2.size()) {
            return zzaz.size() - zzaz2.size();
        }
        int i = 0;
        while (true) {
            zzaz zzaz3 = this.zza;
            if (i >= zzaz3.size()) {
                return 0;
            }
            int compareTo = ((zzdr) zzaz3.get(i)).compareTo((zzdr) zzdi.zza.get(i));
            if (compareTo != 0) {
                return compareTo;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdi.class == obj.getClass()) {
            return this.zza.equals(((zzdi) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd(ISOFileInfo.DATA_BYTES1)), this.zza});
    }

    public final String toString() {
        if (this.zza.isEmpty()) {
            return "[]";
        }
        ArrayList arrayList = new ArrayList();
        zzaz zzaz = this.zza;
        int size = zzaz.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((zzdr) zzaz.get(i)).toString().replace("\n", "\n  "));
        }
        zzag zza2 = zzag.zza(",\n  ");
        StringBuilder sb2 = new StringBuilder("[\n  ");
        try {
            zza2.zzb(sb2, arrayList.iterator());
            sb2.append("\n]");
            return sb2.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final int zza() {
        return zzdr.zzd(ISOFileInfo.DATA_BYTES1);
    }

    public final int zzb() {
        return this.zzb;
    }
}
