package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzt extends zzb implements zzu {
    public static zzu zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IFeatureLayerDelegate");
        if (queryLocalInterface instanceof zzu) {
            return (zzu) queryLocalInterface;
        }
        return new zzs(iBinder);
    }
}
