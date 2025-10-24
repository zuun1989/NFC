package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocalizedMessage;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzep {
    static final Charset zza = Charset.forName("UTF-8");
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        int i = zzdj.zza;
        try {
            new zzdh(bArr, 0, 0, false, (zzdg) null).zza(0);
        } catch (zzer e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzb(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static Object zzc(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }
}
