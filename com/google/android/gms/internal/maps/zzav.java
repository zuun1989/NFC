package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzav extends zzb implements zzaw {
    public static zzaw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        if (queryLocalInterface instanceof zzaw) {
            return (zzaw) queryLocalInterface;
        }
        return new zzau(iBinder);
    }
}
