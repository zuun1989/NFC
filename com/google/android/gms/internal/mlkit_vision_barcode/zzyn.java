package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzyn extends zzb implements zzyo {
    public static zzyo zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
        if (queryLocalInterface instanceof zzyo) {
            return (zzyo) queryLocalInterface;
        }
        return new zzym(iBinder);
    }
}
