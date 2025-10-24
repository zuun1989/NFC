package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaev  reason: invalid package */
public final class zzaev {
    private static Boolean zza;

    public static boolean zza(Context context) {
        boolean z;
        if (zza == null) {
            int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
                z = true;
            } else {
                z = false;
            }
            zza = Boolean.valueOf(z);
        }
        return zza.booleanValue();
    }
}
