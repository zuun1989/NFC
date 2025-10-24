package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "BarcodeParcelCreator")
public final class zzyb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyb> CREATOR = new zzyc();
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
    private final zzxu zzg;
    @SafeParcelable.Field(getter = "getPhoneParcel", id = 8)
    private final zzxx zzh;
    @SafeParcelable.Field(getter = "getSmsParcel", id = 9)
    private final zzxy zzi;
    @SafeParcelable.Field(getter = "getWiFiParcel", id = 10)
    private final zzya zzj;
    @SafeParcelable.Field(getter = "getUrlBookmarkParcel", id = 11)
    private final zzxz zzk;
    @SafeParcelable.Field(getter = "getGeoPointParcel", id = 12)
    private final zzxv zzl;
    @SafeParcelable.Field(getter = "getCalendarEventParcel", id = 13)
    private final zzxr zzm;
    @SafeParcelable.Field(getter = "getContactInfoParcel", id = 14)
    private final zzxs zzn;
    @SafeParcelable.Field(getter = "getDriverLicenseParcel", id = 15)
    private final zzxt zzo;

    @SafeParcelable.Constructor
    public zzyb(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) Point[] pointArr, @SafeParcelable.Param(id = 6) int i2, @SafeParcelable.Param(id = 7) zzxu zzxu, @SafeParcelable.Param(id = 8) zzxx zzxx, @SafeParcelable.Param(id = 9) zzxy zzxy, @SafeParcelable.Param(id = 10) zzya zzya, @SafeParcelable.Param(id = 11) zzxz zzxz, @SafeParcelable.Param(id = 12) zzxv zzxv, @SafeParcelable.Param(id = 13) zzxr zzxr, @SafeParcelable.Param(id = 14) zzxs zzxs, @SafeParcelable.Param(id = 15) zzxt zzxt) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzxu;
        this.zzh = zzxx;
        this.zzi = zzxy;
        this.zzj = zzya;
        this.zzk = zzxz;
        this.zzl = zzxv;
        this.zzm = zzxr;
        this.zzn = zzxs;
        this.zzo = zzxt;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
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

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzf;
    }

    public final zzxr zzc() {
        return this.zzm;
    }

    public final zzxs zzd() {
        return this.zzn;
    }

    public final zzxt zze() {
        return this.zzo;
    }

    public final zzxu zzf() {
        return this.zzg;
    }

    public final zzxv zzg() {
        return this.zzl;
    }

    public final zzxx zzh() {
        return this.zzh;
    }

    public final zzxy zzi() {
        return this.zzi;
    }

    public final zzxz zzj() {
        return this.zzk;
    }

    public final zzya zzk() {
        return this.zzj;
    }

    public final String zzl() {
        return this.zzb;
    }

    public final String zzm() {
        return this.zzc;
    }

    public final byte[] zzn() {
        return this.zzd;
    }

    public final Point[] zzo() {
        return this.zze;
    }
}
