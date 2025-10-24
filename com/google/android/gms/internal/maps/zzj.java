package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzj extends zzb implements zzk {
    public static zzk zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        if (queryLocalInterface instanceof zzk) {
            return (zzk) queryLocalInterface;
        }
        return new zzi(iBinder);
    }
}
