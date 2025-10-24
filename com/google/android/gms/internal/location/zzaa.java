package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class zzaa extends zzb implements zzab {
    public zzaa() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzc.zzd(parcel);
        zzb(zzc.zza(parcel, LocationSettingsResult.CREATOR));
        return true;
    }
}
