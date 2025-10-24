package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "EmailParcelCreator")
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new zzbk();
    @SafeParcelable.Field(getter = "getType", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getAddress", id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getSubject", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getBody", id = 4)
    private final String zzd;

    @SafeParcelable.Constructor
    public zzar(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
