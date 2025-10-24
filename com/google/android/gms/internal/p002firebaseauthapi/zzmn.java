package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmn  reason: invalid package */
public final class zzmn {
    public static final byte[] zza = zza(1, 0);
    public static final byte[] zzb = zza(2, 32);
    public static final byte[] zzc = zza(2, 16);
    public static final byte[] zzd = zza(2, 17);
    public static final byte[] zze = zza(2, 18);
    public static final byte[] zzf = zza(2, 1);
    public static final byte[] zzg = zza(2, 2);
    public static final byte[] zzh = zza(2, 3);
    public static final byte[] zzi = zza(2, 1);
    public static final byte[] zzj = zza(2, 2);
    public static final byte[] zzk = zza(2, 3);
    public static final byte[] zzl = new byte[0];
    private static final byte[] zzm;
    private static final byte[] zzn;
    private static final byte[] zzo;

    static {
        zza(1, 2);
        Charset charset = zzqq.zza;
        zzm = "KEM".getBytes(charset);
        zzn = "HPKE".getBytes(charset);
        zzo = "HPKE-v1".getBytes(charset);
    }

    public static int zza(zzki.zzd zzd2) throws GeneralSecurityException {
        if (zzd2 == zzki.zzd.zzd || zzd2 == zzki.zzd.zza) {
            return 32;
        }
        if (zzd2 == zzki.zzd.zzb) {
            return 48;
        }
        if (zzd2 == zzki.zzd.zzc) {
            return 66;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static int zzb(zzki.zzd zzd2) throws GeneralSecurityException {
        if (zzd2 == zzki.zzd.zzd) {
            return 32;
        }
        if (zzd2 == zzki.zzd.zza) {
            return 65;
        }
        if (zzd2 == zzki.zzd.zzb) {
            return 97;
        }
        if (zzd2 == zzki.zzd.zzc) {
            return 133;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static zzzh zzc(zzki.zzd zzd2) throws GeneralSecurityException {
        if (zzd2 == zzki.zzd.zza) {
            return zzzh.NIST_P256;
        }
        if (zzd2 == zzki.zzd.zzb) {
            return zzzh.NIST_P384;
        }
        if (zzd2 == zzki.zzd.zzc) {
            return zzzh.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzzc.zza(zzn, bArr, bArr2, bArr3);
    }

    private static byte[] zza(int i, int i2) {
        if (i > 4 || i < 0) {
            throw new IllegalArgumentException("capacity must be between 0 and 4");
        } else if (i2 < 0 || (i < 4 && i2 >= (1 << (i << 3)))) {
            throw new IllegalArgumentException("value too large");
        } else {
            byte[] bArr = new byte[i];
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) (i2 >> (((i - i3) - 1) * 8));
            }
            return bArr;
        }
    }

    public static byte[] zza(byte[] bArr) throws GeneralSecurityException {
        return zzzc.zza(zzm, bArr);
    }

    public static byte[] zza(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzzc.zza(zzo, bArr2, str.getBytes(zzqq.zza), bArr);
    }

    public static byte[] zza(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzzc.zza(zza(2, i), zzo, bArr2, str.getBytes(zzqq.zza), bArr);
    }
}
