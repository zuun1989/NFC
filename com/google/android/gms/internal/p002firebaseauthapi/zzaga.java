package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.RecaptchaActivity;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaga  reason: invalid package */
public final class zzaga {
    private final FirebaseAuth zza;
    private final Activity zzb;

    public zzaga(FirebaseAuth firebaseAuth, Activity activity) {
        this.zza = firebaseAuth;
        this.zzb = activity;
    }

    public final void zza() {
        Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        intent.setClass(this.zzb, RecaptchaActivity.class);
        intent.setPackage(this.zzb.getPackageName());
        intent.putExtra("com.google.firebase.auth.KEY_API_KEY", this.zza.l().r().b());
        if (!TextUtils.isEmpty(this.zza.q())) {
            intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", this.zza.q());
        }
        intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", zzafd.zza().zzb());
        intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", this.zza.l().q());
        intent.putExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN", this.zza.n());
        this.zzb.startActivity(intent);
    }
}
