package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zznu implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        Rect rect = null;
        ArrayList<zznz> arrayList = null;
        ArrayList<zznp> arrayList2 = null;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    rect = (Rect) SafeParcelReader.createParcelable(parcel2, readHeader, Rect.CREATOR);
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
                    f5 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 8:
                    f6 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 9:
                    f7 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 10:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, zznz.CREATOR);
                    break;
                case 11:
                    arrayList2 = SafeParcelReader.createTypedList(parcel2, readHeader, zznp.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zznt(i, rect, f, f2, f3, f4, f5, f6, f7, arrayList, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zznt[i];
    }
}
