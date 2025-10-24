package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmd  reason: invalid package */
public final class zzmd implements zzbg {
    private static final byte[] zza = new byte[0];
    private final zzmh zzb;
    private final zzme zzc;
    private final zzmf zzd;
    private final zzmb zze;
    private final int zzf;
    private final byte[] zzg;

    private zzmd(zzmh zzmh, zzme zzme, zzmf zzmf, zzmb zzmb, int i, zzaam zzaam) {
        this.zzb = zzmh;
        this.zzc = zzme;
        this.zzd = zzmf;
        this.zze = zzmb;
        this.zzf = i;
        this.zzg = zzaam.zzb();
    }

    public static zzbg zza(zzkl zzkl) throws GeneralSecurityException {
        int i;
        zzki zzki = (zzki) ((zzlj) zzkl.zza());
        zzme zza2 = zzmg.zza(zzki.zze());
        zzmf zza3 = zzmg.zza(zzki.zzd());
        zzmb zza4 = zzmg.zza(zzki.zzb());
        zzki.zzd zze2 = zzki.zze();
        zzki.zzd zzd2 = zzki.zzd.zzd;
        if (zze2.equals(zzd2)) {
            i = 32;
        } else if (zze2.equals(zzki.zzd.zza)) {
            i = 65;
        } else if (zze2.equals(zzki.zzd.zzb)) {
            i = 97;
        } else if (zze2.equals(zzki.zzd.zzc)) {
            i = 133;
        } else {
            throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
        }
        int i2 = i;
        zzki.zzd zze3 = ((zzki) ((zzlj) zzkl.zza())).zze();
        if (zze3.equals(zzd2) || zze3.equals(zzki.zzd.zza) || zze3.equals(zzki.zzd.zzb) || zze3.equals(zzki.zzd.zzc)) {
            return new zzmd(new zzmh(zzaam.zza(zzkl.zzf().zza(zzbi.zza())), ((zzkt) ((zzll) zzkl.zzc())).zze()), zza2, zza3, zza4, i2, zzkl.zzh());
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzg;
        int length = bArr3.length + this.zzf;
        if (bArr.length < length) {
            throw new GeneralSecurityException("Ciphertext is too short.");
        } else if (zzqq.zza(bArr3, bArr)) {
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            return zzma.zza(Arrays.copyOfRange(bArr, this.zzg.length, length), this.zzb, this.zzc, this.zzd, this.zze, bArr2).zza(bArr, length, zza);
        } else {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
    }
}
