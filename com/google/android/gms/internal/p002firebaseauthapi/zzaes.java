package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaes  reason: invalid package */
public final /* synthetic */ class zzaes {
    public static String zza(zzaet zzaet, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance("SHA-256").digest(str.getBytes()));
            int length = str2.length();
            int i = 0;
            while (i < length) {
                if (zzg.zza(str2.charAt(i))) {
                    char[] charArray = str2.toCharArray();
                    while (i < length) {
                        char c = charArray[i];
                        if (zzg.zza(c)) {
                            charArray[i] = (char) (c ^ ' ');
                        }
                        i++;
                    }
                    return String.valueOf(charArray);
                }
                i++;
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            zzaet.zza.e("Failed to get SHA-256 MessageDigest", new Object[0]);
            return null;
        }
    }

    public static void zzb(zzaet zzaet, String str) {
        zzaet.zza(str, (Status) null);
    }
}
