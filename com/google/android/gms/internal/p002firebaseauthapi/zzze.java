package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzze  reason: invalid package */
public final class zzze implements zzbg {
    private final ECPrivateKey zza;
    private final zzzg zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzzk zze;
    private final zzlq zzf;
    private final byte[] zzg;

    private zzze(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzzk zzzk, zzlq zzlq, byte[] bArr2) {
        this.zza = eCPrivateKey;
        this.zzb = new zzzg(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzzk;
        this.zzf = zzlq;
        this.zzg = bArr2;
    }

    public static zzbg zza(zzkh zzkh) throws GeneralSecurityException {
        ECPrivateKey zza2 = zzzi.zza(zzzd.zza.zza(((zzke) ((zzlj) zzkh.zza())).zzd()), zznh.zza(zzkh.zzf().zza(zzbi.zza())));
        byte[] bArr = new byte[0];
        if (((zzke) ((zzlj) zzkh.zza())).zzh() != null) {
            bArr = ((zzke) ((zzlj) zzkh.zza())).zzh().zzb();
        }
        return new zzze(zza2, bArr, zzzd.zza(((zzke) ((zzlj) zzkh.zza())).zze()), zzzd.zzb.zza(((zzke) ((zzlj) zzkh.zza())).zzf()), zzlm.zza((zzke) ((zzlj) zzkh.zza())), zzkh.zzh().zzb());
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(byte[] r11, byte[] r12) throws java.security.GeneralSecurityException {
        /*
            r10 = this;
            byte[] r0 = r10.zzg
            boolean r0 = com.google.android.gms.internal.p002firebaseauthapi.zzqq.zza(r0, r11)
            if (r0 == 0) goto L_0x005f
            byte[] r0 = r10.zzg
            int r0 = r0.length
            java.security.interfaces.ECPrivateKey r1 = r10.zza
            java.security.spec.ECParameterSpec r1 = r1.getParams()
            java.security.spec.EllipticCurve r1 = r1.getCurve()
            com.google.android.gms.internal.firebase-auth-api.zzzk r2 = r10.zze
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzzi.zza((java.security.spec.EllipticCurve) r1)
            int r2 = r2.ordinal()
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 == r4) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            int r1 = r1 * r3
            goto L_0x0035
        L_0x0029:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "unknown EC point format"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            int r1 = r1 + r4
            goto L_0x0035
        L_0x0033:
            int r1 = r1 * r3
            goto L_0x0031
        L_0x0035:
            int r2 = r11.length
            int r1 = r1 + r0
            if (r2 < r1) goto L_0x0057
            byte[] r4 = java.util.Arrays.copyOfRange(r11, r0, r1)
            com.google.android.gms.internal.firebase-auth-api.zzzg r3 = r10.zzb
            java.lang.String r5 = r10.zzc
            byte[] r6 = r10.zzd
            com.google.android.gms.internal.firebase-auth-api.zzlq r0 = r10.zzf
            int r8 = r0.zza()
            com.google.android.gms.internal.firebase-auth-api.zzzk r9 = r10.zze
            r7 = r12
            byte[] r12 = r3.zza(r4, r5, r6, r7, r8, r9)
            com.google.android.gms.internal.firebase-auth-api.zzlq r0 = r10.zzf
            byte[] r11 = r0.zza(r12, r11, r1)
            return r11
        L_0x0057:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "ciphertext too short"
            r11.<init>(r12)
            throw r11
        L_0x005f:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "Invalid ciphertext (output prefix mismatch)"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzze.zza(byte[], byte[]):byte[]");
    }
}
