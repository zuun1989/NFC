package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzaq extends zzb implements zzar {
    public static zzar zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        if (queryLocalInterface instanceof zzar) {
            return (zzar) queryLocalInterface;
        }
        return new zzap(iBinder);
    }
}
