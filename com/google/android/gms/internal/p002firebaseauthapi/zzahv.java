package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahv  reason: invalid package */
public final class zzahv implements Parcelable.Creator<zzahw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        Long l = null;
        String str3 = null;
        Long l2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 3) {
                str2 = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 4) {
                l = SafeParcelReader.readLongObject(parcel, readHeader);
            } else if (fieldId == 5) {
                str3 = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId != 6) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                l2 = SafeParcelReader.readLongObject(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzahw(str, str2, l, str3, l2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzahw[i];
    }
}
