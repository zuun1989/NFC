package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import w0.a;

public class AvailabilityException extends Exception {
    private final a zaa;

    public AvailabilityException(a aVar) {
        this.zaa = aVar;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        a aVar = this.zaa;
        ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        Object obj = aVar.get(apiKey);
        String zaa2 = apiKey.zaa();
        Preconditions.checkArgument(obj != null, "The given API (" + zaa2 + ") was not part of the availability request.");
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (ApiKey apiKey : this.zaa.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
            z &= !connectionResult.isSuccess();
            arrayList.add(apiKey.zaa() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public ConnectionResult getConnectionResult(HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        a aVar = this.zaa;
        ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        Object obj = aVar.get(apiKey);
        String zaa2 = apiKey.zaa();
        Preconditions.checkArgument(obj != null, "The given API (" + zaa2 + ") was not part of the availability request.");
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }
}
