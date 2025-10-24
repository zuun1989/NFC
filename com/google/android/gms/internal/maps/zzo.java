package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public final class zzo extends zza implements IInterface {
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IFeatureClickEventDelegate");
    }

    public final LatLng zzd() throws RemoteException {
        Parcel zzJ = zzJ(1, zza());
        LatLng zza = zzc.zza(zzJ, LatLng.CREATOR);
        zzJ.recycle();
        return zza;
    }

    public final List zze() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        ArrayList<IBinder> createBinderArrayList = zzJ.createBinderArrayList();
        zzJ.recycle();
        return createBinderArrayList;
    }
}
