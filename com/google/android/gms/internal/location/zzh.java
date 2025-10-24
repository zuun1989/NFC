package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "DeviceOrientationRequestInternalCreator")
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    static final List zza = Collections.emptyList();
    static final DeviceOrientationRequest zzb = new DeviceOrientationRequest.Builder(20000).build();
    @SafeParcelable.Field(defaultValueUnchecked = "DeviceOrientationRequestInternal.DEFAULT_DEVICE_ORIENTATION_REQUEST", id = 1)
    final DeviceOrientationRequest zzc;
    @SafeParcelable.Field(defaultValueUnchecked = "DeviceOrientationRequestInternal.DEFAULT_CLIENTS", id = 2)
    final List zzd;
    @SafeParcelable.Field(defaultValueUnchecked = "null", id = 3)
    final String zze;

    @SafeParcelable.Constructor
    public zzh(@SafeParcelable.Param(id = 1) DeviceOrientationRequest deviceOrientationRequest, @SafeParcelable.Param(id = 2) List list, @SafeParcelable.Param(id = 3) String str) {
        this.zzc = deviceOrientationRequest;
        this.zzd = list;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzh = (zzh) obj;
        if (!Objects.equal(this.zzc, zzh.zzc) || !Objects.equal(this.zzd, zzh.zzd) || !Objects.equal(this.zze, zzh.zze)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int length = valueOf.length();
        int length2 = valueOf2.length();
        String str = this.zze;
        StringBuilder sb2 = new StringBuilder(length + 68 + length2 + 7 + String.valueOf(str).length() + 2);
        sb2.append("DeviceOrientationRequestInternal[deviceOrientationRequest=");
        sb2.append(valueOf);
        sb2.append(", clients=");
        sb2.append(valueOf2);
        sb2.append(", tag='");
        sb2.append(str);
        sb2.append("']");
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzc, i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 3, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
