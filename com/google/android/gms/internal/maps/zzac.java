package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzac extends zzb implements zzad {
    public static zzad zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        if (queryLocalInterface instanceof zzad) {
            return (zzad) queryLocalInterface;
        }
        return new zzab(iBinder);
    }
}
