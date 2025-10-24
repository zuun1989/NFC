package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Build;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqq  reason: invalid package */
public final class zzqq {
    public static final Charset zza = Charset.forName("UTF-8");

    public static int zza() {
        byte b = 0;
        while (b == 0) {
            byte[] zza2 = zzqg.zza(4);
            b = (zza2[3] & 255) | ((zza2[0] & 255) << 24) | ((zza2[1] & 255) << 16) | ((zza2[2] & 255) << 8);
        }
        return b;
    }

    public static final zzaam zzb(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '!' || charAt > '~') {
                throw new zzqo("Not a printable ASCII character: " + charAt);
            }
            bArr[i] = (byte) charAt;
        }
        return zzaam.zza(bArr);
    }

    public static final zzaam zza(String str) throws GeneralSecurityException {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '!' || charAt > '~') {
                throw new GeneralSecurityException("Not a printable ASCII character: " + charAt);
            }
            bArr[i] = (byte) charAt;
        }
        return zzaam.zza(bArr);
    }

    public static Integer zzb() {
        if (!Objects.equals(System.getProperty("java.vendor"), "The Android Project")) {
            return null;
        }
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }

    public static boolean zza(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr2[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }
}
