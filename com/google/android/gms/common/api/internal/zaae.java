package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;
import w0.b;

public final class zaae extends zap {
    private final b zad = new b();
    private final GoogleApiManager zae;

    public zaae(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment, googleApiAvailability);
        this.zae = googleApiManager;
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    public static void zad(Activity activity, GoogleApiManager googleApiManager, ApiKey apiKey) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zaae zaae = (zaae) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
        if (zaae == null) {
            zaae = new zaae(fragment, googleApiManager, GoogleApiAvailability.getInstance());
        }
        Preconditions.checkNotNull(apiKey, "ApiKey cannot be null");
        zaae.zad.add(apiKey);
        googleApiManager.zaA(zaae);
    }

    private final void zae() {
        if (!this.zad.isEmpty()) {
            this.zae.zaA(this);
        }
    }

    public final void onResume() {
        super.onResume();
        zae();
    }

    public final void onStart() {
        super.onStart();
        zae();
    }

    public final void onStop() {
        super.onStop();
        this.zae.zaB(this);
    }

    public final b zaa() {
        return this.zad;
    }

    public final void zab(ConnectionResult connectionResult, int i) {
        this.zae.zax(connectionResult, i);
    }

    public final void zac() {
        this.zae.zay();
    }
}
