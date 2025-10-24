package com.google.android.gms.internal.measurement;

import com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocalizedMessage;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzmp {
    static final Charset zza = Charset.forName("UTF-8");
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        int i = zzlj.zza;
        try {
            new zzli(bArr, 0, 0, false, (byte[]) null).zza(0);
        } catch (zzmr e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static int zzb(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzc(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static boolean zzd(zznm zznm) {
        if (!(zznm instanceof zzkt)) {
            return false;
        }
        throw null;
    }
}
