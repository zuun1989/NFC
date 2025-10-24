package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocalizedMessage;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzali  reason: invalid package */
public final class zzali {
    static final Charset zza = Charset.forName("UTF-8");
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        zzaki.zza(bArr, 0, bArr.length, false);
    }

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int zza2 = zza(length, bArr, 0, length);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    public static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static <T> T zza(T t) {
        t.getClass();
        return t;
    }

    public static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zza(zzamn zzamn) {
        boolean z = zzamn instanceof zzajo;
        return false;
    }
}
