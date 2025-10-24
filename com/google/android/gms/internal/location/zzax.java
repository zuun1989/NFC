package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzax extends zzba {
    final /* synthetic */ boolean zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzax(zzbb zzbb, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient);
        this.zza = z;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzdz zzdz = (zzdz) anyClient;
        if (this.zza) {
            zzdz.zzy(zzbb.zza(this));
        } else {
            zzdz.zzz(zzbb.zza(this));
        }
    }
}
