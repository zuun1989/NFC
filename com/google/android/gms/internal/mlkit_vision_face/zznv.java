package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zznv extends zza implements IInterface {
    public zznv(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.face.aidls.IFaceDetector");
    }

    public final List zzd(IObjectWrapper iObjectWrapper, zznn zznn) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzc.zza(zza, zznn);
        Parcel zzb = zzb(3, zza);
        ArrayList<zznt> createTypedArrayList = zzb.createTypedArrayList(zznt.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final void zze() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzc(2, zza());
    }
}
