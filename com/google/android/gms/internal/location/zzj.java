package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzs;
import com.google.android.gms.location.zzt;

@SafeParcelable.Class(creator = "DeviceOrientationRequestUpdateDataCreator")
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    @SafeParcelable.Field(defaultValueUnchecked = "DeviceOrientationRequestUpdateData.OPERATION_ADD", id = 1)
    final int zza;
    @SafeParcelable.Field(defaultValueUnchecked = "null", id = 2)
    final zzh zzb;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getDeviceOrientationListenerBinder", id = 3, type = "android.os.IBinder")
    final zzt zzc;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getFusedLocationProviderCallbackBinder", id = 4, type = "android.os.IBinder")
    final zzr zzd;

    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) zzh zzh, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2) {
        zzt zzt;
        this.zza = i;
        this.zzb = zzh;
        zzr zzr = null;
        if (iBinder == null) {
            zzt = null;
        } else {
            zzt = zzs.zzb(iBinder);
        }
        this.zzc = zzt;
        if (iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (queryLocalInterface instanceof zzr) {
                zzr = (zzr) queryLocalInterface;
            } else {
                zzr = new zzp(iBinder2);
            }
        }
        this.zzd = zzr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzt zzt = this.zzc;
        IBinder iBinder2 = null;
        if (zzt == null) {
            iBinder = null;
        } else {
            iBinder = zzt.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, iBinder, false);
        zzr zzr = this.zzd;
        if (zzr != null) {
            iBinder2 = zzr.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, iBinder2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
