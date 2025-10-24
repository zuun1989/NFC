package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GeoPointParcelCreator")
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new zzbl();
    @SafeParcelable.Field(getter = "getLat", id = 1)
    private final double zza;
    @SafeParcelable.Field(getter = "getLng", id = 2)
    private final double zzb;

    @SafeParcelable.Constructor
    public zzas(@SafeParcelable.Param(id = 1) double d, @SafeParcelable.Param(id = 2) double d2) {
        this.zza = d;
        this.zzb = d2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        double d = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeDouble(parcel, 1, d);
        SafeParcelWriter.writeDouble(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
