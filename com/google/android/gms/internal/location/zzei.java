package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzw;
import com.google.android.gms.location.zzy;
import com.google.android.gms.location.zzz;

@SafeParcelable.Class(creator = "LocationRequestUpdateDataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public final class zzei extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzei> CREATOR = new zzej();
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequestUpdateData.OPERATION_ADD", getter = "getOperation", id = 1)
    private final int zza;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getLocationRequest", id = 2)
    private final zzeg zzb;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getLocationListenerAsBinder", id = 3, type = "android.os.IBinder")
    private final zzz zzc;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getLocationCallbackAsBinder", id = 5, type = "android.os.IBinder")
    private final zzw zzd;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getPendingIntent", id = 4)
    private final PendingIntent zze;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getFusedLocationProviderCallbackAsBinder", id = 6, type = "android.os.IBinder")
    private final zzr zzf;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getListenerId", id = 8)
    private final String zzg;

    @SafeParcelable.Constructor
    public zzei(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) zzeg zzeg, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 5) IBinder iBinder2, @SafeParcelable.Param(id = 4) PendingIntent pendingIntent, @SafeParcelable.Param(id = 6) IBinder iBinder3, @SafeParcelable.Param(id = 8) String str) {
        zzz zzz;
        zzw zzw;
        this.zza = i;
        this.zzb = zzeg;
        zzr zzr = null;
        if (iBinder != null) {
            zzz = zzy.zzb(iBinder);
        } else {
            zzz = null;
        }
        this.zzc = zzz;
        this.zze = pendingIntent;
        if (iBinder2 != null) {
            zzw = zzv.zzb(iBinder2);
        } else {
            zzw = null;
        }
        this.zzd = zzw;
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (queryLocalInterface instanceof zzr) {
                zzr = (zzr) queryLocalInterface;
            } else {
                zzr = new zzp(iBinder3);
            }
        }
        this.zzf = zzr;
        this.zzg = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        IBinder iBinder2;
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzz zzz = this.zzc;
        IBinder iBinder3 = null;
        if (zzz == null) {
            iBinder = null;
        } else {
            iBinder = zzz.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, iBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zze, i, false);
        zzw zzw = this.zzd;
        if (zzw == null) {
            iBinder2 = null;
        } else {
            iBinder2 = zzw.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, iBinder2, false);
        zzr zzr = this.zzf;
        if (zzr != null) {
            iBinder3 = zzr.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, iBinder3, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
