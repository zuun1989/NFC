package com.google.android.gms.internal.fido;

import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import java.io.IOException;

final class zzcf extends zzcg {
    private zzcf(zzcd zzcd, Character ch) {
        super(zzcd, ch);
        zzap.zzc(zzcd.zzf.length == 64);
    }

    public final zzch zza(zzcd zzcd, Character ch) {
        return new zzcf(zzcd, ch);
    }

    public final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzap.zze(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            byte b = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
            appendable.append(this.zzb.zza(b >>> 18));
            appendable.append(this.zzb.zza((b >>> IdCardService.SFI_DG12) & 63));
            appendable.append(this.zzb.zza((b >>> 6) & 63));
            appendable.append(this.zzb.zza(b & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zze(appendable, bArr, i3, i2 - i3);
        }
    }

    public zzcf(String str, String str2, Character ch) {
        this(new zzcd(str, str2.toCharArray()), ch);
    }
}
