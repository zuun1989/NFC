package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzaf extends zzb implements zzag {
    public static zzag zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMapCapabilitiesDelegate");
        if (queryLocalInterface instanceof zzag) {
            return (zzag) queryLocalInterface;
        }
        return new zzae(iBinder);
    }
}
