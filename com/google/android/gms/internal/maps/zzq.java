package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzq extends zzb implements zzr {
    public static zzr zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IFeatureDelegate");
        if (queryLocalInterface instanceof zzr) {
            return (zzr) queryLocalInterface;
        }
        return new zzp(iBinder);
    }
}
