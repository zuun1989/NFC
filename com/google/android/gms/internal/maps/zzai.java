package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzai extends zzb implements zzaj {
    public static zzaj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (queryLocalInterface instanceof zzaj) {
            return (zzaj) queryLocalInterface;
        }
        return new zzah(iBinder);
    }
}
