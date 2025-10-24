package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;

public abstract class zzw extends zzb implements zzx {
    public zzw() {
        super("com.google.android.gms.location.internal.ILocationAvailabilityStatusCallback");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzc.zzd(parcel);
        zzb((Status) zzc.zza(parcel, Status.CREATOR), zzc.zza(parcel, LocationAvailability.CREATOR));
        return true;
    }
}
