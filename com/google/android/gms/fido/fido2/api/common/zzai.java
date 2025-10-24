package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PrfExtensionCreator")
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    @SafeParcelable.Field(getter = "getEvaluationPoints", id = 1)
    private final byte[][] zza;

    @SafeParcelable.Constructor
    public zzai(@SafeParcelable.Param(id = 1) byte[][] bArr) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z5;
        boolean z6;
        if (bArr != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (1 != ((bArr.length & 1) ^ 1)) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        for (int i = 0; i < bArr.length; i += 2) {
            if (i == 0 || bArr[i] != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            int i2 = i + 1;
            if (bArr[i2] != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            int length = bArr[i2].length;
            if (length == 32 || length == 64) {
                z6 = true;
            } else {
                z6 = false;
            }
            Preconditions.checkArgument(z6);
        }
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzai)) {
            return false;
        }
        return Arrays.deepEquals(this.zza, ((zzai) obj).zza);
    }

    public final int hashCode() {
        int i = 0;
        for (byte[] bArr : this.zza) {
            i ^= Objects.hashCode(bArr);
        }
        return i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArrayArray(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
