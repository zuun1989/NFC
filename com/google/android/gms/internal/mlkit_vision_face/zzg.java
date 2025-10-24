package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzg implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = Float.MAX_VALUE;
        float f9 = Float.MAX_VALUE;
        float f10 = Float.MAX_VALUE;
        zzn[] zznArr = null;
        zzd[] zzdArr = null;
        float f11 = -1.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    f = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 4:
                    f2 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 5:
                    f3 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 6:
                    f4 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 7:
                    f8 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 8:
                    f9 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 9:
                    zznArr = (zzn[]) SafeParcelReader.createTypedArray(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 10:
                    f5 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 11:
                    f6 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 12:
                    f7 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 13:
                    zzdArr = (zzd[]) SafeParcelReader.createTypedArray(parcel2, readHeader, zzd.CREATOR);
                    break;
                case 14:
                    f10 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 15:
                    f11 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzf(i, i2, f, f2, f3, f4, f8, f9, f10, zznArr, f5, f6, f7, zzdArr, f11);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzf[i];
    }
}
