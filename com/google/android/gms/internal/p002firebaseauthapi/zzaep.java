package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import b6.g;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import j6.I;
import j6.O;
import j6.P;
import j6.W;
import j6.Z;
import j6.d0;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaep  reason: invalid package */
public final class zzaep {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzaas zzb;
    private final zzagd zzc;

    public zzaep(g gVar, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.checkNotNull(gVar);
        Context m = gVar.m();
        Preconditions.checkNotNull(m);
        this.zzb = new zzaas(new zzafc(gVar, zzafd.zza()));
        this.zzc = new zzagd(m, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(str, str2, new zzaem(zzaen, zza));
    }

    public final void zzb(String str, String str2, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzb(str, str2, new zzaem(zzaen, zza));
    }

    public final void zzc(String str, String str2, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzc(str, str2, new zzaem(zzaen, zza));
    }

    public final void zzd(String str, String str2, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzd(str, str2, new zzaem(zzaen, zza));
    }

    public final void zze(String str, String str2, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        this.zzb.zze(str, str2, new zzaem(zzaen, zza));
    }

    public final void zzf(String str, String str2, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzf(str, str2, new zzaem(zzaen, zza));
    }

    public final void zze(String str, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzf(str, new zzaem(zzaen, zza));
    }

    public final void zza(zzaid zzaid, zzaen zzaen) {
        Preconditions.checkNotNull(zzaid);
        Preconditions.checkNotEmpty(zzaid.zzb());
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(zzaid, new zzaem(zzaen, zza));
    }

    public final void zzd(String str, zzaen zzaen) {
        Preconditions.checkNotNull(zzaen);
        this.zzb.zze(str, new zzaem(zzaen, zza));
    }

    public final void zzb(String str, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzb(str, new zzaem(zzaen, zza));
    }

    public final void zzc(String str, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzc(str, new zzaem(zzaen, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(str, str2, str3, str4, new zzaem(zzaen, zza));
    }

    public final void zzb(zzahn zzahn, zzaen zzaen) {
        Preconditions.checkNotNull(zzahn);
        Preconditions.checkNotEmpty(zzahn.zzc());
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzb(zzahn, new zzaem(zzaen, zza));
    }

    public final void zzc(zzahn zzahn, zzaen zzaen) {
        Preconditions.checkNotNull(zzahn);
        this.zzb.zzc(zzahn, new zzaem(zzaen, zza));
    }

    public final void zza(String str, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(str, new zzaem(zzaen, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaen);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzb(str, str2, str3, str4, new zzaem(zzaen, zza));
    }

    public final void zza(I i, String str, String str2, String str3, zzaen zzaen) {
        zzaha zzaha;
        Preconditions.checkNotNull(i);
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotNull(zzaen);
        if (i instanceof P) {
            O a = ((P) i).a();
            zzaha = zzahe.zza(str, (String) Preconditions.checkNotNull(a.zzc()), (String) Preconditions.checkNotNull(a.N1()), str2, str3);
        } else if (i instanceof W) {
            W w = (W) i;
            zzaha = zzahg.zza(str, Preconditions.checkNotEmpty(str2), Preconditions.checkNotEmpty(((Z) Preconditions.checkNotNull(w.a())).c()), Preconditions.checkNotEmpty(w.c()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zzaha, str, new zzaem(zzaen, zza));
    }

    public final void zza(String str, I i, String str2, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(i);
        Preconditions.checkNotNull(zzaen);
        if (i instanceof P) {
            O a = ((P) i).a();
            this.zzb.zza((zzahc) zzahd.zza(str, (String) Preconditions.checkNotNull(a.zzc()), (String) Preconditions.checkNotNull(a.N1()), str2), new zzaem(zzaen, zza));
        } else if (i instanceof W) {
            W w = (W) i;
            this.zzb.zza((zzahc) zzahf.zza(str, Preconditions.checkNotEmpty(w.c()), str2, Preconditions.checkNotEmpty(w.b())), new zzaem(zzaen, zza));
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zza(zzahp zzahp, zzaen zzaen) {
        Preconditions.checkNotNull(zzahp);
        this.zzb.zza(zzahp, new zzaem(zzaen, zza));
    }

    public final void zza(zzahu zzahu, zzaen zzaen) {
        Preconditions.checkNotNull(zzahu);
        this.zzb.zza(zzahu, new zzaem(zzaen, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(str, str2, str3, str4, str5, new zzaem(zzaen, zza));
    }

    public final void zza(String str, zzajc zzajc, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzajc);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(str, zzajc, new zzaem(zzaen, zza));
    }

    public final void zza(zzaia zzaia, zzaen zzaen) {
        Preconditions.checkNotNull(zzaen);
        Preconditions.checkNotNull(zzaia);
        this.zzb.zza(Preconditions.checkNotEmpty(zzaia.zzb()), zzaia.zza(), new zzaem(zzaen, zza));
    }

    public final void zza(zzaif zzaif, zzaen zzaen) {
        Preconditions.checkNotNull(zzaif);
        this.zzb.zza(zzaif, new zzaem(zzaen, zza));
    }

    public final void zza(zzahn zzahn, zzaen zzaen) {
        Preconditions.checkNotNull(zzahn);
        Preconditions.checkNotEmpty(zzahn.zzd());
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(zzahn, new zzaem(zzaen, zza));
    }

    public final void zza(zzaik zzaik, zzaen zzaen) {
        Preconditions.checkNotNull(zzaen);
        Preconditions.checkNotNull(zzaik);
        String zzd = zzaik.zzd();
        zzaem zzaem = new zzaem(zzaen, zza);
        if (this.zzc.zzc(zzd)) {
            if (zzaik.zze()) {
                this.zzc.zzb(zzd);
            } else {
                this.zzc.zzb(zzaem, zzd);
                return;
            }
        }
        long zzb2 = zzaik.zzb();
        boolean zzf = zzaik.zzf();
        if (zza(zzb2, zzf)) {
            zzaik.zza(new zzagn(this.zzc.zzb()));
        }
        this.zzc.zza(zzd, zzaem, zzb2, zzf);
        this.zzb.zza(zzaik, this.zzc.zza(zzaem, zzd));
    }

    public final void zza(zzaio zzaio, zzaen zzaen) {
        Preconditions.checkNotNull(zzaio);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zzd(zzaio.zza(), new zzaem(zzaen, zza));
    }

    public final void zza(zzajc zzajc, zzaen zzaen) {
        Preconditions.checkNotNull(zzajc);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(zzajc, new zzaem(zzaen, zza));
    }

    public final void zza(zzajd zzajd, zzaen zzaen) {
        Preconditions.checkNotNull(zzajd);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(zzajd, new zzaem(zzaen, zza));
    }

    public final void zza(zzagy zzagy, zzaen zzaen) {
        Preconditions.checkNotNull(zzaen);
        Preconditions.checkNotNull(zzagy.zzb());
        this.zzb.zza(zzagy.zzb(), zzagy.zzc(), new zzaem(zzaen, zza));
    }

    public final void zza(zzaao zzaao, zzaen zzaen) {
        Preconditions.checkNotNull(zzaen);
        Preconditions.checkNotNull(zzaao);
        this.zzb.zza(zzafx.zza((O) Preconditions.checkNotNull(zzaao.zza())), new zzaem(zzaen, zza));
    }

    public final void zza(String str, String str2, String str3, long j, boolean z, boolean z2, String str4, String str5, String str6, boolean z3, zzaen zzaen) {
        String str7 = str2;
        String str8 = str;
        Preconditions.checkNotEmpty(str, "idToken should not be empty.");
        Preconditions.checkNotNull(zzaen);
        zzaem zzaem = new zzaem(zzaen, zza);
        if (this.zzc.zzc(str2)) {
            if (z) {
                this.zzc.zzb(str2);
            } else {
                this.zzc.zzb(zzaem, str2);
                return;
            }
        }
        zzait zza2 = zzait.zza(str, str2, str3, str4, str5, str6, (String) null);
        long j2 = j;
        if (zza(j, z3)) {
            zza2.zza(new zzagn(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzaem, j, z3);
        this.zzb.zza((zzaip) zza2, this.zzc.zza(zzaem, str2));
    }

    public final void zza(zzaar zzaar, zzaen zzaen) {
        Preconditions.checkNotNull(zzaar);
        Preconditions.checkNotNull(zzaen);
        String phoneNumber = zzaar.zzb().getPhoneNumber();
        zzaem zzaem = new zzaem(zzaen, zza);
        if (this.zzc.zzc(phoneNumber)) {
            if (zzaar.zzh()) {
                this.zzc.zzb(phoneNumber);
            } else {
                this.zzc.zzb(zzaem, phoneNumber);
                return;
            }
        }
        long zza2 = zzaar.zza();
        boolean zzi = zzaar.zzi();
        zzair zza3 = zzair.zza(zzaar.zze(), zzaar.zzb().d(), zzaar.zzb().getPhoneNumber(), zzaar.zzd(), zzaar.zzg(), zzaar.zzf(), zzaar.zzc());
        if (zza(zza2, zzi)) {
            zza3.zza(new zzagn(this.zzc.zzb()));
        }
        this.zzc.zza(phoneNumber, zzaem, zza2, zzi);
        this.zzb.zza(zza3, this.zzc.zza(zzaem, phoneNumber));
    }

    public final void zza(zzaiv zzaiv, zzaen zzaen) {
        this.zzb.zza((zzaip) zzaiv, new zzaem((zzaen) Preconditions.checkNotNull(zzaen), zza));
    }

    public final void zza(String str, String str2, String str3, zzaen zzaen) {
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotEmpty(str2, "uid should not be empty.");
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(str, str2, str3, new zzaem(zzaen, zza));
    }

    public final void zza(String str, d0 d0Var, zzaen zzaen) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(d0Var);
        Preconditions.checkNotNull(zzaen);
        this.zzb.zza(str, d0Var, new zzaem(zzaen, zza));
    }

    private static boolean zza(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
