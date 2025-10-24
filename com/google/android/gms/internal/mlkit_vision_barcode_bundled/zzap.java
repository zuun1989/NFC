package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ContactInfoParcelCreator")
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new zzbi();
    @SafeParcelable.Field(getter = "getName", id = 1)
    private final zzat zza;
    @SafeParcelable.Field(getter = "getOrganization", id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getTitle", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getPhones", id = 4)
    private final zzau[] zzd;
    @SafeParcelable.Field(getter = "getEmails", id = 5)
    private final zzar[] zze;
    @SafeParcelable.Field(getter = "getUrls", id = 6)
    private final String[] zzf;
    @SafeParcelable.Field(getter = "getAddresses", id = 7)
    private final zzam[] zzg;

    @SafeParcelable.Constructor
    public zzap(@SafeParcelable.Param(id = 1) zzat zzat, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) zzau[] zzauArr, @SafeParcelable.Param(id = 5) zzar[] zzarArr, @SafeParcelable.Param(id = 6) String[] strArr, @SafeParcelable.Param(id = 7) zzam[] zzamArr) {
        this.zza = zzat;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzauArr;
        this.zze = zzarArr;
        this.zzf = strArr;
        this.zzg = zzamArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzat zzat = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzat, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeTypedArray(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
