package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagi  reason: invalid package */
final class zzagi extends zzaem {
    private final String zza;
    private final /* synthetic */ zzagd zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzagi(zzagd zzagd, zzaem zzaem, String str) {
        super(zzaem);
        Objects.requireNonNull(zzagd);
        this.zzb = zzagd;
        this.zza = str;
    }

    public final void zza(Status status) {
        Logger zza2 = zzagd.zza;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(status.getStatusCode());
        String statusMessage = status.getStatusMessage();
        int i = 0;
        zza2.e("SMS verification code request failed: " + statusCodeString + " " + statusMessage, new Object[0]);
        zzagk zzagk = (zzagk) this.zzb.zzd.get(this.zza);
        if (zzagk != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(zzagk.zzb);
            this.zzb.zzb(this.zza);
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzaem) obj).zza(status);
            }
        }
    }

    public final void zzb(String str) {
        zzagd.zza.d("onCodeSent", new Object[0]);
        zzagk zzagk = (zzagk) this.zzb.zzd.get(this.zza);
        if (zzagk != null) {
            for (zzaem zzb2 : zzagk.zzb) {
                zzb2.zzb(str);
            }
            zzagk.zzg = true;
            zzagk.zzd = str;
            if (zzagk.zza <= 0) {
                this.zzb.zze(this.zza);
            } else if (!zzagk.zzc) {
                this.zzb.zzd(this.zza);
            } else if (!zzac.zzc(zzagk.zze)) {
                zzagd.zzb(this.zzb, this.zza);
            }
        }
    }
}
