package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import j6.O;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaem  reason: invalid package */
public class zzaem implements zzaen {
    private final zzaen zza;
    private final Logger zzb;

    public zzaem(zzaem zzaem) {
        this(zzaem.zza, zzaem.zzb);
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending auto retrieval timeout response.", e, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending send verification code response.", e, new Object[0]);
        }
    }

    public final void zzc(String str) {
        try {
            this.zza.zzc(str);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending set account info response.", e, new Object[0]);
        }
    }

    public final void zza(zzagw zzagw) {
        try {
            this.zza.zza(zzagw);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending create auth uri response.", e, new Object[0]);
        }
    }

    public final void zzb() {
        try {
            this.zza.zzb();
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending email verification response.", e, new Object[0]);
        }
    }

    public final void zzc() {
        try {
            this.zza.zzc();
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when setting FirebaseUI Version", e, new Object[0]);
        }
    }

    public zzaem(zzaen zzaen, Logger logger) {
        this.zza = (zzaen) Preconditions.checkNotNull(zzaen);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void zza() {
        try {
            this.zza.zza();
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending delete account response.", e, new Object[0]);
        }
    }

    public final void zza(zzaaq zzaaq) {
        try {
            this.zza.zza(zzaaq);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result with credential", e, new Object[0]);
        }
    }

    public final void zza(zzaat zzaat) {
        try {
            this.zza.zza(zzaat);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result for mfa", e, new Object[0]);
        }
    }

    public final void zza(Status status, O o) {
        try {
            this.zza.zza(status, o);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public void zza(Status status) {
        try {
            this.zza.zza(status);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zza(zzahs zzahs) {
        try {
            this.zza.zza(zzahs);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending Play Integrity Producer project response.", e, new Object[0]);
        }
    }

    public final void zza(zzaht zzaht) {
        try {
            this.zza.zza(zzaht);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending get recaptcha config response.", e, new Object[0]);
        }
    }

    public final void zza(zzahw zzahw, zzahl zzahl) {
        try {
            this.zza.zza(zzahw, zzahl);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending get token and account info user response", e, new Object[0]);
        }
    }

    public final void zza(zzaig zzaig) {
        try {
            this.zza.zza(zzaig);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending password reset response.", e, new Object[0]);
        }
    }

    public final void zza(zzaih zzaih) {
        try {
            this.zza.zza(zzaih);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending revoke token response.", e, new Object[0]);
        }
    }

    public final void zza(zzais zzais) {
        try {
            this.zza.zza(zzais);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending start mfa enrollment response.", e, new Object[0]);
        }
    }

    public final void zza(zzahw zzahw) {
        try {
            this.zza.zza(zzahw);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending token result.", e, new Object[0]);
        }
    }

    public final void zza(O o) {
        try {
            this.zza.zza(o);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending verification completed response.", e, new Object[0]);
        }
    }
}
