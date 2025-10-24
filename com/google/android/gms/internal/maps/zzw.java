package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzw extends zzb implements zzx {
    public static zzx zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        if (queryLocalInterface instanceof zzx) {
            return (zzx) queryLocalInterface;
        }
        return new zzv(iBinder);
    }
}
