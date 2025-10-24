package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zznx extends zzb implements zzny {
    public static zzny zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
        if (queryLocalInterface instanceof zzny) {
            return (zzny) queryLocalInterface;
        }
        return new zznw(iBinder);
    }
}
