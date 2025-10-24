package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqw;
import com.google.android.gms.internal.p002firebaseauthapi.zzrj;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaf  reason: invalid package */
public final class zzaaf implements zzcb {
    private static final byte[] zza = {0};
    private final zzst zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzaaf(zzqp zzqp) throws GeneralSecurityException {
        this.zzb = zzaac.zza(zzsr.zza(zzsq.zza(((zzqw) ((zzrm) zzqp.zza())).zzc()), zzqp.zzf()));
        this.zzc = ((zzqw) ((zzrm) zzqp.zza())).zzb();
        this.zzd = zzqp.zze().zzb();
        if (((zzqw) ((zzrm) zzqp.zza())).zze().equals(zzqw.zzb.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        this.zze = new byte[0];
    }

    public static zzcb zza(zzqp zzqp) throws GeneralSecurityException {
        return new zzaaf(zzqp);
    }

    public static zzcb zza(zzrc zzrc) throws GeneralSecurityException {
        return new zzaaf(zzrc);
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(zza(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        if (bArr2.length > 0) {
            return zzzc.zza(this.zzd, this.zzb.zza(zzzc.zza(bArr, bArr2), this.zzc));
        }
        return zzzc.zza(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zzaaf(zzrc zzrc) throws GeneralSecurityException {
        String valueOf = String.valueOf(((zzrj) ((zzrm) zzrc.zza())).zze());
        this.zzb = new zzaad("HMAC" + valueOf, new SecretKeySpec(zzrc.zzf().zza(zzbi.zza()), "HMAC"));
        this.zzc = ((zzrj) ((zzrm) zzrc.zza())).zzb();
        this.zzd = zzrc.zze().zzb();
        if (((zzrj) ((zzrm) zzrc.zza())).zzf().equals(zzrj.zzb.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        this.zze = new byte[0];
    }

    public zzaaf(zzst zzst, int i) throws GeneralSecurityException {
        this.zzb = zzst;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        if (i >= 10) {
            zzst.zza(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }
}
