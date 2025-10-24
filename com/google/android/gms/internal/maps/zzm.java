package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzm extends zzb implements zzn {
    public static zzn zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        if (queryLocalInterface instanceof zzn) {
            return (zzn) queryLocalInterface;
        }
        return new zzl(iBinder);
    }
}
