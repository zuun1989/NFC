package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzj  reason: invalid package */
public final class zzzj implements zzaz {
    private final zzzz zza;
    private final zzcb zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzzj(zzzz zzzz, zzcb zzcb, int i, byte[] bArr) {
        this.zza = zzzz;
        this.zzb = zzcb;
        this.zzc = i;
        this.zzd = bArr;
    }

    public static zzaz zza(zzdd zzdd) throws GeneralSecurityException {
        zzyt zzyt = new zzyt(zzdd.zzf().zza(zzbi.zza()), ((zzdk) ((zzcx) zzdd.zza())).zzd());
        String valueOf = String.valueOf(((zzdk) ((zzcx) zzdd.zza())).zzg());
        return new zzzj(zzyt, new zzaaf(new zzaad("HMAC" + valueOf, new SecretKeySpec(zzdd.zzg().zza(zzbi.zza()), "HMAC")), ((zzdk) ((zzcx) zzdd.zza())).zze()), ((zzdk) ((zzcx) zzdd.zza())).zze(), zzdd.zzd().zzb());
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzb2 = this.zza.zzb(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzzc.zza(this.zzd, zzb2, this.zzb.zza(zzzc.zza(bArr2, zzb2, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        byte[] bArr3 = this.zzd;
        if (length < i + bArr3.length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        } else if (zzqq.zza(bArr3, bArr)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, bArr.length - this.zzc);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.zzc, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            this.zzb.zza(copyOfRange2, zzzc.zza(bArr2, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8)));
            return this.zza.zza(copyOfRange);
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }
}
