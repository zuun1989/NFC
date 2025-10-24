package com.google.android.gms.internal.location;

import Vc.q;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.n;

@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({2, 5})
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    public static final zzd zza = new zzd((h) null);
    @SafeParcelable.Field(getter = "getUid", id = 1)
    private final int zzb;
    @SafeParcelable.Field(getter = "getPackageName", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getAttributionTag", id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getListenerId", id = 6)
    private final String zze;
    @SafeParcelable.Field(getter = "getClientFeatures", id = 8)
    private final List zzf;
    @SafeParcelable.Field(getter = "getImpersonator", id = 7)
    private final zze zzg;

    static {
        Process.myUid();
        Process.myPid();
    }

    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 8) List list, @SafeParcelable.Param(id = 7) zze zze2) {
        n.f(str, "packageName");
        if (zze2 == null || !zze2.zza()) {
            this.zzb = i;
            this.zzc = str;
            this.zzd = str2;
            List list2 = null;
            if (str3 == null) {
                if (zze2 != null) {
                    str3 = zze2.zze;
                } else {
                    str3 = null;
                }
            }
            this.zze = str3;
            if (list == null) {
                list = zze2 != null ? zze2.zzf : list2;
                if (list == null) {
                    list = zzex.zzi();
                    n.e(list, "of(...)");
                }
            }
            n.f(list, "<this>");
            zzex zzj = zzex.zzj(list);
            n.e(zzj, "copyOf(...)");
            this.zzf = zzj;
            this.zzg = zze2;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zze) {
            zze zze2 = (zze) obj;
            if (this.zzb != zze2.zzb || !n.a(this.zzc, zze2.zzc) || !n.a(this.zzd, zze2.zzd) || !n.a(this.zze, zze2.zze) || !n.a(this.zzg, zze2.zzg) || !n.a(this.zzf, zze2.zzf)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzg});
    }

    public final String toString() {
        int i;
        int length = this.zzc.length() + 18;
        String str = this.zzd;
        int i2 = 0;
        if (str != null) {
            i = str.length();
        } else {
            i = 0;
        }
        StringBuilder sb2 = new StringBuilder(length + i);
        sb2.append(this.zzb);
        sb2.append("/");
        sb2.append(this.zzc);
        String str2 = this.zzd;
        if (str2 != null) {
            sb2.append("[");
            if (q.A(str2, this.zzc, false, 2, (Object) null)) {
                sb2.append(str2, this.zzc.length(), str2.length());
            } else {
                sb2.append(str2);
            }
            sb2.append("]");
        }
        if (this.zze != null) {
            sb2.append("/");
            String str3 = this.zze;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            sb2.append(Integer.toHexString(i2));
        }
        String sb3 = sb2.toString();
        n.e(sb3, "toString(...)");
        return sb3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        n.f(parcel, "dest");
        int i2 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeTypedList(parcel, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza() {
        return this.zzg != null;
    }
}
