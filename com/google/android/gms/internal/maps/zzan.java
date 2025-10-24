package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzan extends zzb implements zzao {
    public static zzao zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
        if (queryLocalInterface instanceof zzao) {
            return (zzao) queryLocalInterface;
        }
        return new zzam(iBinder);
    }
}
