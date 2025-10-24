package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import androidx.loader.content.b;
import com.google.android.gms.common.api.GoogleApiClient;
import y1.a;

final class zbw implements a.a {
    final /* synthetic */ SignInHubActivity zba;

    public /* synthetic */ zbw(SignInHubActivity signInHubActivity, zbv zbv) {
        this.zba = signInHubActivity;
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [android.content.Context, com.google.android.gms.auth.api.signin.internal.SignInHubActivity] */
    public final b onCreateLoader(int i, Bundle bundle) {
        return new zbc(this.zba, GoogleApiClient.getAllClients());
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [com.google.android.gms.auth.api.signin.internal.SignInHubActivity, android.app.Activity] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.android.gms.auth.api.signin.internal.SignInHubActivity, android.app.Activity] */
    public final /* bridge */ /* synthetic */ void onLoadFinished(b bVar, Object obj) {
        Void voidR = (Void) obj;
        ? r2 = this.zba;
        r2.setResult(r2.zbe, r2.zbf);
        this.zba.finish();
    }

    public final void onLoaderReset(b bVar) {
    }
}
