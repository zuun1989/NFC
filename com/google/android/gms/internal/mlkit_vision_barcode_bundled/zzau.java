package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PhoneParcelCreator")
public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new zzby();
    @SafeParcelable.Field(getter = "getType", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getNumber", id = 2)
    private final String zzb;

    @SafeParcelable.Constructor
    public zzau(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
        this.zza = i;
        this.zzb = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
