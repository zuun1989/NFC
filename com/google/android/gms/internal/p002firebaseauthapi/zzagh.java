package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagh  reason: invalid package */
final class zzagh extends BroadcastReceiver {
    private final String zza;
    private final /* synthetic */ zzagd zzb;

    public zzagh(zzagd zzagd, String str) {
        Objects.requireNonNull(zzagd);
        this.zzb = zzagd;
        this.zza = str;
    }

    public final void onReceive(Context context, Intent intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                zzagk zzagk = (zzagk) this.zzb.zzd.get(this.zza);
                if (zzagk == null) {
                    zzagd.zza.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    String zza2 = zzagd.zza(str);
                    zzagk.zze = zza2;
                    if (zza2 == null) {
                        zzagd.zza.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzac.zzc(zzagk.zzd)) {
                        zzagd.zzb(this.zzb, this.zza);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
