package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

final class zbb implements PendingResultUtil.ResultConverter {
    private zbb() {
    }

    public final /* synthetic */ Object convert(Result result) {
        return ((GoogleSignInResult) result).getSignInAccount();
    }

    public /* synthetic */ zbb(zba zba) {
    }
}
