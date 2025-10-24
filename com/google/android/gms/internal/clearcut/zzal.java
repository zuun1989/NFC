package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;

final class zzal extends zzae {
    private final Object lock = new Object();
    private String zzec;
    private Object zzed;
    private final /* synthetic */ zzan zzee;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzal(zzao zzao, String str, Object obj, zzan zzan) {
        super(zzao, str, obj, (zzai) null);
        this.zzee = zzan;
    }

    public final Object zza(SharedPreferences sharedPreferences) {
        try {
            return zzb(sharedPreferences.getString(this.zzds, ""));
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(this.zzds);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid byte[] value in SharedPreferences for ".concat(valueOf) : new String("Invalid byte[] value in SharedPreferences for "), e);
            return null;
        }
    }

    public final Object zzb(String str) {
        Object obj;
        try {
            synchronized (this.lock) {
                if (!str.equals(this.zzec)) {
                    Object zzb = this.zzee.zzb(Base64.decode(str, 3));
                    this.zzec = str;
                    this.zzed = zzb;
                }
                obj = this.zzed;
            }
            return obj;
        } catch (IOException | IllegalArgumentException unused) {
            String str2 = this.zzds;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb2.append("Invalid byte[] value for ");
            sb2.append(str2);
            sb2.append(": ");
            sb2.append(str);
            Log.e("PhenotypeFlag", sb2.toString());
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
