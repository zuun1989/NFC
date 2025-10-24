package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.LibraryVersion;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafd  reason: invalid package */
public final class zzafd {
    private final int zza;

    private zzafd(String str) {
        this.zza = zza(str);
    }

    private static int zza(String str) {
        try {
            List<String> zza2 = zzt.zza("[.-]").zza((CharSequence) str);
            if (zza2.size() == 1) {
                return Integer.parseInt(str);
            }
            if (zza2.size() >= 3) {
                return (Integer.parseInt(zza2.get(0)) * 1000000) + (Integer.parseInt(zza2.get(1)) * CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT) + Integer.parseInt(zza2.get(2));
            }
            return -1;
        } catch (IllegalArgumentException e) {
            if (!Log.isLoggable("LibraryVersionContainer", 3)) {
                return -1;
            }
            Log.d("LibraryVersionContainer", String.format("Version code parsing failed for: %s with exception %s.", new Object[]{str, e}));
            return -1;
        }
    }

    public final String zzb() {
        return String.format("X%s", new Object[]{Integer.toString(this.zza)});
    }

    public static zzafd zza() {
        String version = LibraryVersion.getInstance().getVersion("firebase-auth");
        if (TextUtils.isEmpty(version) || version.equals("UNKNOWN")) {
            version = "-1";
        }
        return new zzafd(version);
    }
}
