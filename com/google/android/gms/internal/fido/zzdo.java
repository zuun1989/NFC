package com.google.android.gms.internal.fido;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzdo extends zzdr {
    private final int zza;
    private final zzbg zzb;

    public zzdo(zzbg zzbg) throws zzdh {
        zzbg.getClass();
        this.zzb = zzbg;
        zzcb zzd = zzbg.entrySet().iterator();
        int i = 0;
        while (zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) zzd.next();
            int zzb2 = ((zzdr) entry.getKey()).zzb();
            i = i < zzb2 ? zzb2 : i;
            int zzb3 = ((zzdr) entry.getValue()).zzb();
            if (i < zzb3) {
                i = zzb3;
            }
        }
        int i2 = i + 1;
        this.zza = i2;
        if (i2 > 4) {
            throw new zzdh("Exceeded cutoff limit for max depth of cbor value");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int compareTo;
        int size;
        int size2;
        zzdr zzdr = (zzdr) obj;
        if (zzdr.zzd(ISOFileInfo.A0) != zzdr.zza()) {
            size2 = zzdr.zza();
            size = zzdr.zzd(ISOFileInfo.A0);
        } else {
            zzdo zzdo = (zzdo) zzdr;
            if (this.zzb.size() != zzdo.zzb.size()) {
                size = this.zzb.size();
                size2 = zzdo.zzb.size();
            } else {
                zzcb zzd = this.zzb.entrySet().iterator();
                zzcb zzd2 = zzdo.zzb.entrySet().iterator();
                do {
                    if (!zzd.hasNext() && !zzd2.hasNext()) {
                        return 0;
                    }
                    Map.Entry entry = (Map.Entry) zzd.next();
                    Map.Entry entry2 = (Map.Entry) zzd2.next();
                    int compareTo2 = ((zzdr) entry.getKey()).compareTo((zzdr) entry2.getKey());
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    compareTo = ((zzdr) entry.getValue()).compareTo((zzdr) entry2.getValue());
                } while (compareTo == 0);
                return compareTo;
            }
        }
        return size - size2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdo.class == obj.getClass()) {
            return this.zzb.equals(((zzdo) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzdr.zzd(ISOFileInfo.A0)), this.zzb});
    }

    public final String toString() {
        if (this.zzb.isEmpty()) {
            return "{}";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzcb zzd = this.zzb.entrySet().iterator();
        while (zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) zzd.next();
            linkedHashMap.put(((zzdr) entry.getKey()).toString().replace("\n", "\n  "), ((zzdr) entry.getValue()).toString().replace("\n", "\n  "));
        }
        zzag zza2 = zzag.zza(",\n  ");
        StringBuilder sb2 = new StringBuilder("{\n  ");
        try {
            zzaf.zza(sb2, linkedHashMap.entrySet().iterator(), zza2, " : ");
            sb2.append("\n}");
            return sb2.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final int zza() {
        return zzdr.zzd(ISOFileInfo.A0);
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzbg zzc() {
        return this.zzb;
    }
}
