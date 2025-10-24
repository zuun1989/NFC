package com.google.android.gms.internal.p002firebaseauthapi;

import V6.i;
import android.content.Context;
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.util.Log;
import b6.g;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import j6.f0;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaff  reason: invalid package */
public final class zzaff {
    private Context zza;
    private zzafy zzb;
    private String zzc;
    private final g zzd;
    private boolean zze;
    private String zzf;

    public zzaff(g gVar, String str) {
        this(gVar.m(), gVar, str);
    }

    private static FirebaseAuth zza(g gVar) {
        f0 f = f0.f(gVar);
        if (f == null) {
            Log.w("LocalRequestInterceptor", "FirebaseAuthComponent is null.");
            return null;
        }
        FirebaseAuth e = f.e();
        if (e == null) {
            Log.w("LocalRequestInterceptor", "FirebaseAuthComponent returned null FirebaseAuth instance.");
        }
        return e;
    }

    private static String zzb(g gVar) {
        FirebaseAuth zza2 = zza(gVar);
        if (zza2 == null) {
            return null;
        }
        b.a(zza2.t0().get());
        return null;
    }

    private static String zzc(g gVar) {
        i iVar;
        FirebaseAuth zza2 = zza(gVar);
        if (!(zza2 == null || (iVar = (i) zza2.x0().get()) == null)) {
            try {
                return (String) Tasks.await(iVar.a());
            } catch (InterruptedException | ExecutionException e) {
                String message = e.getMessage();
                Log.w("LocalRequestInterceptor", "Unable to get heartbeats: " + message);
            }
        }
        return null;
    }

    public zzaff(Context context, g gVar, String str) {
        this.zze = false;
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzd = (g) Preconditions.checkNotNull(gVar);
        this.zzc = String.format("Android/%s/%s", new Object[]{"Fallback", str});
    }

    public final void zzb(String str) {
        this.zzf = str;
    }

    public final void zza(URLConnection uRLConnection) {
        String str;
        if (this.zze) {
            str = this.zzc + "/FirebaseUI-Android";
        } else {
            str = this.zzc + "/FirebaseCore-Android";
        }
        if (this.zzb == null) {
            this.zzb = new zzafy(this.zza);
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.zzb.zzb());
        uRLConnection.setRequestProperty("X-Android-Cert", this.zzb.zza());
        uRLConnection.setRequestProperty("Accept-Language", zzafe.zza());
        uRLConnection.setRequestProperty("X-Client-Version", str);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.zzf);
        uRLConnection.setRequestProperty("X-Firebase-GMPID", this.zzd.r().c());
        uRLConnection.setRequestProperty("X-Firebase-Client", zzc(this.zzd));
        String zzb2 = zzb(this.zzd);
        if (!TextUtils.isEmpty(zzb2)) {
            uRLConnection.setRequestProperty("X-Firebase-AppCheck", zzb2);
        }
        this.zzf = null;
    }

    public final void zza(String str) {
        this.zze = !TextUtils.isEmpty(str);
    }
}
