package com.google.android.gms.internal.p002firebaseauthapi;

import I0.b;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import j6.O;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagd  reason: invalid package */
final class zzagd {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final HashMap<String, zzagk> zzd = new HashMap<>();

    public zzagd(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    public final void zze(String str) {
        zzagk zzagk = this.zzd.get(str);
        if (zzagk != null) {
            if (!zzagk.zzi) {
                zzd(str);
            }
            zzb(str);
        }
    }

    public final String zzb() {
        Signature[] signatureArr;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures;
            } else {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
            }
            String zza2 = zza(packageName, signatureArr[0].toCharsString());
            if (zza2 != null) {
                return zza2;
            }
            zza.e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(String str) {
        zzagk zzagk = this.zzd.get(str);
        if (zzagk != null && !zzagk.zzh && !zzac.zzc(zzagk.zzd)) {
            zza.w("Timed out waiting for SMS.", new Object[0]);
            for (zzaem zza2 : zzagk.zzb) {
                zza2.zza(zzagk.zzd);
            }
            zzagk.zzi = true;
        }
    }

    public final boolean zzc(String str) {
        return this.zzd.get(str) != null;
    }

    public final zzaem zza(zzaem zzaem, String str) {
        return new zzagi(this, zzaem, str);
    }

    public static String zza(String str) {
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    private static String zza(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str3.getBytes(StandardCharsets.UTF_8));
            String substring = Base64.encodeToString(Arrays.copyOf(instance.digest(), 9), 3).substring(0, 11);
            zza.d("Package: " + str + " -- Hash: " + substring, new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e) {
            zza.e("NoSuchAlgorithm: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static /* synthetic */ void zzb(zzagd zzagd, String str) {
        zzagk zzagk = zzagd.zzd.get(str);
        if (zzagk != null && !zzac.zzc(zzagk.zzd) && !zzac.zzc(zzagk.zze) && !zzagk.zzb.isEmpty()) {
            for (zzaem zza2 : zzagk.zzb) {
                zza2.zza(O.O1(zzagk.zzd, zzagk.zze));
            }
            zzagk.zzh = true;
        }
    }

    public final void zza(String str, zzaem zzaem, long j, boolean z) {
        this.zzd.put(str, new zzagk(j, z));
        zzb(zzaem, str);
        zzagk zzagk = this.zzd.get(str);
        if (zzagk.zza <= 0) {
            zza.w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagk.zzf = this.zzc.schedule(new zzagg(this, str), zzagk.zza, TimeUnit.SECONDS);
        if (!zzagk.zzc) {
            zza.w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzagh zzagh = new zzagh(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        b.registerReceiver(this.zzb.getApplicationContext(), zzagh, intentFilter, 2);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzagf(this));
    }

    public final void zzb(zzaem zzaem, String str) {
        zzagk zzagk = this.zzd.get(str);
        if (zzagk != null) {
            zzagk.zzb.add(zzaem);
            if (zzagk.zzg) {
                zzaem.zzb(zzagk.zzd);
            }
            if (zzagk.zzh) {
                zzaem.zza(O.O1(zzagk.zzd, zzagk.zze));
            }
            if (zzagk.zzi) {
                zzaem.zza(zzagk.zzd);
            }
        }
    }

    public final void zzb(String str) {
        zzagk zzagk = this.zzd.get(str);
        if (zzagk != null) {
            ScheduledFuture<?> scheduledFuture = zzagk.zzf;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                zzagk.zzf.cancel(false);
            }
            zzagk.zzb.clear();
            this.zzd.remove(str);
        }
    }
}
