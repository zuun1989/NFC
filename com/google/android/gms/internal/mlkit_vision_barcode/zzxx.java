package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PhoneParcelCreator")
public final class zzxx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxx> CREATOR = new zzyq();
    @SafeParcelable.Field(getter = "getType", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getNumber", id = 2)
    private final String zzb;

    @SafeParcelable.Constructor
    public zzxx(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
        this.zza = i;
        this.zzb = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
