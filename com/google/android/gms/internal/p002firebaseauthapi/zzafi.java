package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import j6.O;
import j6.h;
import java.util.Objects;
import k6.r;
import k6.x;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafi  reason: invalid package */
final class zzafi implements zzaen {
    final /* synthetic */ zzafg zza;

    public zzafi(zzafg zzafg) {
        Objects.requireNonNull(zzafg);
        this.zza = zzafg;
    }

    private final void zza(zzafn zzafn) {
        this.zza.zzi.execute(new zzafo(this, zzafn));
    }

    public final void zzb(String str) throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 8;
        Preconditions.checkState(z, "Unexpected response type " + i);
        zza((zzafn) new zzafk(this, str));
    }

    public final void zzc(String str) throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 7;
        Preconditions.checkState(z, "Unexpected response type " + i);
        zzafg.zza(this.zza);
    }

    private final void zza(Status status, h hVar, String str, String str2) {
        zzafg.zza(this.zza, status);
        zzafg zzafg = this.zza;
        zzafg.zzn = hVar;
        zzafg.zzo = str;
        zzafg.zzp = str2;
        x xVar = zzafg.zzf;
        if (xVar != null) {
            xVar.zza(status);
        }
        this.zza.zza(status);
    }

    public final void zzb() throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 6;
        Preconditions.checkState(z, "Unexpected response type " + i);
        zzafg.zza(this.zza);
    }

    public final void zzc() throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 9;
        Preconditions.checkState(z, "Unexpected response type " + i);
        zzafg.zza(this.zza);
    }

    public final void zza(String str) throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 8;
        Preconditions.checkState(z, "Unexpected response type " + i);
        this.zza.zzu = true;
        zza((zzafn) new zzafm(this, str));
    }

    public final void zza(zzagw zzagw) throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 3;
        Preconditions.checkState(z, "Unexpected response type " + i);
        zzafg zzafg = this.zza;
        zzafg.zzl = zzagw;
        zzafg.zza(zzafg);
    }

    public final void zza() throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 5;
        Preconditions.checkState(z, "Unexpected response type " + i);
        zzafg.zza(this.zza);
    }

    public final void zza(zzaaq zzaaq) {
        zza(zzaaq.zza(), zzaaq.zzb(), zzaaq.zzc(), zzaaq.zzd());
    }

    public final void zza(zzaat zzaat) {
        zzafg zzafg = this.zza;
        zzafg.zzq = zzaat;
        zzafg.zza(r.a("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    public final void zza(Status status, O o) throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 2;
        Preconditions.checkState(z, "Unexpected response type " + i);
        zza(status, o, (String) null, (String) null);
    }

    public final void zza(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzafg zzafg = this.zza;
        if (zzafg.zza == 8) {
            zzafg.zzu = true;
            zza((zzafn) new zzafl(this, status));
            return;
        }
        zzafg.zza(zzafg, status);
        this.zza.zza(status);
    }

    public final void zza(zzahs zzahs) throws RemoteException {
        zzafg zzafg = this.zza;
        zzafg.zzs = zzahs;
        zzafg.zza(zzafg);
    }

    public final void zza(zzaht zzaht) throws RemoteException {
        zzafg zzafg = this.zza;
        zzafg.zzr = zzaht;
        zzafg.zza(zzafg);
    }

    public final void zza(zzahw zzahw, zzahl zzahl) throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 2;
        Preconditions.checkState(z, "Unexpected response type: " + i);
        zzafg zzafg = this.zza;
        zzafg.zzj = zzahw;
        zzafg.zzk = zzahl;
        zzafg.zza(zzafg);
    }

    public final void zza(zzaig zzaig) throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 4;
        Preconditions.checkState(z, "Unexpected response type " + i);
        zzafg zzafg = this.zza;
        zzafg.zzm = zzaig;
        zzafg.zza(zzafg);
    }

    public final void zza(zzaih zzaih) throws RemoteException {
        zzafg.zza(this.zza);
    }

    public final void zza(zzais zzais) throws RemoteException {
        zzafg zzafg = this.zza;
        zzafg.zzt = zzais;
        zzafg.zza(zzafg);
    }

    public final void zza(zzahw zzahw) throws RemoteException {
        int i = this.zza.zza;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        Preconditions.checkState(z, "Unexpected response type: " + i);
        zzafg zzafg = this.zza;
        zzafg.zzj = zzahw;
        zzafg.zza(zzafg);
    }

    public final void zza(O o) throws RemoteException {
        int i = this.zza.zza;
        boolean z = i == 8;
        Preconditions.checkState(z, "Unexpected response type " + i);
        this.zza.zzu = true;
        zza((zzafn) new zzafj(this, o));
    }
}
