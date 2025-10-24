package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "BarcodeParcelCreator")
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new zzaz();
    @SafeParcelable.Field(getter = "getFormat", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getDisplayValue", id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getRawValue", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getRawBytes", id = 4)
    private final byte[] zzd;
    @SafeParcelable.Field(getter = "getCornerPoints", id = 5)
    private final Point[] zze;
    @SafeParcelable.Field(getter = "getValueType", id = 6)
    private final int zzf;
    @SafeParcelable.Field(getter = "getEmailParcel", id = 7)
    private final zzar zzg;
    @SafeParcelable.Field(getter = "getPhoneParcel", id = 8)
    private final zzau zzh;
    @SafeParcelable.Field(getter = "getSmsParcel", id = 9)
    private final zzav zzi;
    @SafeParcelable.Field(getter = "getWiFiParcel", id = 10)
    private final zzax zzj;
    @SafeParcelable.Field(getter = "getUrlBookmarkParcel", id = 11)
    private final zzaw zzk;
    @SafeParcelable.Field(getter = "getGeoPointParcel", id = 12)
    private final zzas zzl;
    @SafeParcelable.Field(getter = "getCalendarEventParcel", id = 13)
    private final zzao zzm;
    @SafeParcelable.Field(getter = "getContactInfoParcel", id = 14)
    private final zzap zzn;
    @SafeParcelable.Field(getter = "getDriverLicenseParcel", id = 15)
    private final zzaq zzo;

    @SafeParcelable.Constructor
    public zzay(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) Point[] pointArr, @SafeParcelable.Param(id = 6) int i2, @SafeParcelable.Param(id = 7) zzar zzar, @SafeParcelable.Param(id = 8) zzau zzau, @SafeParcelable.Param(id = 9) zzav zzav, @SafeParcelable.Param(id = 10) zzax zzax, @SafeParcelable.Param(id = 11) zzaw zzaw, @SafeParcelable.Param(id = 12) zzas zzas, @SafeParcelable.Param(id = 13) zzao zzao, @SafeParcelable.Param(id = 14) zzap zzap, @SafeParcelable.Param(id = 15) zzaq zzaq) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzar;
        this.zzh = zzau;
        this.zzi = zzav;
        this.zzj = zzax;
        this.zzk = zzaw;
        this.zzl = zzas;
        this.zzm = zzao;
        this.zzn = zzap;
        this.zzo = zzaq;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzo, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
