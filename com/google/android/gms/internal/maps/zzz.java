package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzz extends zzb implements zzaa {
    public static zzaa zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        if (queryLocalInterface instanceof zzaa) {
            return (zzaa) queryLocalInterface;
        }
        return new zzy(iBinder);
    }
}
