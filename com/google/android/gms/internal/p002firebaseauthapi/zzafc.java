package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import b6.g;
import com.google.android.gms.common.internal.Preconditions;
import j6.f0;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafc  reason: invalid package */
public final class zzafc extends zzafu implements zzago {
    private zzaew zza;
    private zzaez zzb;
    private zzafz zzc;
    private final zzafd zzd;
    private final g zze;
    private String zzf;
    private zzaff zzg;

    public zzafc(g gVar, zzafd zzafd) {
        this(gVar, zzafd, (zzafz) null, (zzaew) null, (zzaez) null, (zzaex) null);
    }

    private final zzaff zzb() {
        if (this.zzg == null) {
            this.zzg = new zzaff(this.zze, this.zzd.zzb());
        }
        return this.zzg;
    }

    public final void zza(zzagt zzagt, zzafw<zzagw> zzafw) {
        Preconditions.checkNotNull(zzagt);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/createAuthUri", this.zzf), zzagt, zzafw, zzagw.class, zzaew.zza);
    }

    private zzafc(g gVar, zzafd zzafd, zzafz zzafz, zzaew zzaew, zzaez zzaez, zzaex zzaex) {
        this.zze = gVar;
        this.zzf = gVar.r().b();
        gVar.r().g();
        this.zzd = (zzafd) Preconditions.checkNotNull(zzafd);
        zza((zzafz) null, (zzaew) null, (zzaez) null, (zzaex) null);
        zzagm.zza(this.zzf, this);
    }

    public final void zza(zzagv zzagv, zzafw<Void> zzafw) {
        Preconditions.checkNotNull(zzagv);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/deleteAccount", this.zzf), zzagv, zzafw, Void.class, zzaew.zza);
    }

    public final void zza(zzagy zzagy, zzafw<zzagx> zzafw) {
        Preconditions.checkNotNull(zzagy);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/emailLinkSignin", this.zzf), zzagy, zzafw, zzagx.class, zzaew.zza);
    }

    public final void zza(zzaha zzaha, zzafw<zzagz> zzafw) {
        Preconditions.checkNotNull(zzaha);
        Preconditions.checkNotNull(zzafw);
        zzaez zzaez = this.zzb;
        zzaez.zza(zzaez.zza("/accounts/mfaEnrollment:finalize", this.zzf), zzaha, zzafw, zzagz.class, zzaez.zza);
    }

    public final void zza(zzahc zzahc, zzafw<zzahb> zzafw) {
        Preconditions.checkNotNull(zzahc);
        Preconditions.checkNotNull(zzafw);
        zzaez zzaez = this.zzb;
        zzaez.zza(zzaez.zza("/accounts/mfaSignIn:finalize", this.zzf), zzahc, zzafw, zzahb.class, zzaez.zza);
    }

    public final void zza(zzahk zzahk, zzafw<zzahw> zzafw) {
        Preconditions.checkNotNull(zzahk);
        Preconditions.checkNotNull(zzafw);
        zzafz zzafz = this.zzc;
        zzafv.zza(zzafz.zza("/token", this.zzf), zzahk, zzafw, zzahw.class, zzafz.zza);
    }

    public final void zza(zzahj zzahj, zzafw<zzahm> zzafw) {
        Preconditions.checkNotNull(zzahj);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/getAccountInfo", this.zzf), zzahj, zzafw, zzahm.class, zzaew.zza);
    }

    public final void zza(zzahn zzahn, zzafw<zzahq> zzafw) {
        Preconditions.checkNotNull(zzahn);
        Preconditions.checkNotNull(zzafw);
        if (zzahn.zzb() != null) {
            zzb().zzb(zzahn.zzb().zze());
        }
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/getOobConfirmationCode", this.zzf), zzahn, zzafw, zzahq.class, zzaew.zza);
    }

    public final void zza(zzahp zzahp, zzafw<zzahs> zzafw) {
        Preconditions.checkNotNull(zzahp);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/getRecaptchaParam", this.zzf), zzafw, zzahs.class, zzaew.zza);
    }

    public final void zza(zzahu zzahu, zzafw<zzaht> zzafw) {
        Preconditions.checkNotNull(zzahu);
        Preconditions.checkNotNull(zzafw);
        zzaez zzaez = this.zzb;
        String str = zzaez.zza("/recaptchaConfig", this.zzf) + "&clientType=" + zzahu.zzb() + "&version=" + zzahu.zzc();
        if (!zzac.zzc(zzahu.zzd())) {
            str = str + "&tenantId=" + zzahu.zzd();
        }
        zzafv.zza(str, zzafw, zzaht.class, zzaez.zza);
    }

    public final void zza() {
        zza((zzafz) null, (zzaew) null, (zzaez) null, (zzaex) null);
    }

    public final void zza(zzaid zzaid, zzafw<zzaig> zzafw) {
        Preconditions.checkNotNull(zzaid);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/resetPassword", this.zzf), zzaid, zzafw, zzaig.class, zzaew.zza);
    }

    public final void zza(zzaif zzaif, zzafw<zzaih> zzafw) {
        Preconditions.checkNotNull(zzaif);
        Preconditions.checkNotNull(zzafw);
        zzaez zzaez = this.zzb;
        zzaez.zza(zzaez.zza("/accounts:revokeToken", this.zzf), zzaif, zzafw, zzaih.class, zzaez.zza);
    }

    public final void zza(zzaik zzaik, zzafw<zzaij> zzafw) {
        Preconditions.checkNotNull(zzaik);
        Preconditions.checkNotNull(zzafw);
        if (!TextUtils.isEmpty(zzaik.zzc())) {
            zzb().zzb(zzaik.zzc());
        }
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/sendVerificationCode", this.zzf), zzaik, zzafw, zzaij.class, zzaew.zza);
    }

    public final void zza(zzaim zzaim, zzafw<zzail> zzafw) {
        Preconditions.checkNotNull(zzaim);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/setAccountInfo", this.zzf), zzaim, zzafw, zzail.class, zzaew.zza);
    }

    public final void zza(String str, zzafw<Void> zzafw) {
        Preconditions.checkNotNull(zzafw);
        zzb().zza(str);
        zzafw.zza(null);
    }

    public final void zza(zzain zzain, zzafw<zzaiq> zzafw) {
        Preconditions.checkNotNull(zzain);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/signupNewUser", this.zzf), zzain, zzafw, zzaiq.class, zzaew.zza);
    }

    public final void zza(zzaip zzaip, zzafw<zzais> zzafw) {
        Preconditions.checkNotNull(zzaip);
        Preconditions.checkNotNull(zzafw);
        if (zzaip instanceof zzait) {
            zzait zzait = (zzait) zzaip;
            if (!TextUtils.isEmpty(zzait.zzb())) {
                zzb().zzb(zzait.zzb());
            }
        }
        zzaez zzaez = this.zzb;
        zzaez.zza(zzaez.zza("/accounts/mfaEnrollment:start", this.zzf), zzaip, zzafw, zzais.class, zzaez.zza);
    }

    public final void zza(zzair zzair, zzafw<zzaiu> zzafw) {
        Preconditions.checkNotNull(zzair);
        Preconditions.checkNotNull(zzafw);
        if (!TextUtils.isEmpty(zzair.zzb())) {
            zzb().zzb(zzair.zzb());
        }
        zzaez zzaez = this.zzb;
        zzaez.zza(zzaez.zza("/accounts/mfaSignIn:start", this.zzf), zzair, zzafw, zzaiu.class, zzaez.zza);
    }

    private final void zza(zzafz zzafz, zzaew zzaew, zzaez zzaez, zzaex zzaex) {
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        String zza2 = zzagj.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzagm.zzd(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: " + zza2);
        }
        if (this.zzc == null) {
            this.zzc = new zzafz(zza2, zzb());
        }
        String zza3 = zzagj.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzagm.zzb(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: " + zza3);
        }
        if (this.zza == null) {
            this.zza = new zzaew(zza3, zzb());
        }
        String zza4 = zzagj.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza4)) {
            zza4 = zzagm.zzc(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: " + zza4);
        }
        if (this.zzb == null) {
            this.zzb = new zzaez(zza4, zzb());
        }
        f0.f(this.zze);
    }

    public final void zza(zzajc zzajc, zzafw<zzaje> zzafw) {
        Preconditions.checkNotNull(zzajc);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/verifyAssertion", this.zzf), zzajc, zzafw, zzaje.class, zzaew.zza);
    }

    public final void zza(zzajd zzajd, zzafw<zzajg> zzafw) {
        Preconditions.checkNotNull(zzajd);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/verifyCustomToken", this.zzf), zzajd, zzafw, zzajg.class, zzaew.zza);
    }

    public final void zza(zzajf zzajf, zzafw<zzaji> zzafw) {
        Preconditions.checkNotNull(zzajf);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/verifyPassword", this.zzf), zzajf, zzafw, zzaji.class, zzaew.zza);
    }

    public final void zza(zzajh zzajh, zzafw<zzajk> zzafw) {
        Preconditions.checkNotNull(zzajh);
        Preconditions.checkNotNull(zzafw);
        zzaew zzaew = this.zza;
        zzafv.zza(zzaew.zza("/verifyPhoneNumber", this.zzf), zzajh, zzafw, zzajk.class, zzaew.zza);
    }

    public final void zza(zzajj zzajj, zzafw<zzajm> zzafw) {
        Preconditions.checkNotNull(zzajj);
        Preconditions.checkNotNull(zzafw);
        zzaez zzaez = this.zzb;
        zzaez.zza(zzaez.zza("/accounts/mfaEnrollment:withdraw", this.zzf), zzajj, zzafw, zzajm.class, zzaez.zza);
    }
}
