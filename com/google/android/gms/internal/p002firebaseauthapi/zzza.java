package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzza  reason: invalid package */
public final class zzza implements zzbd {
    private static final zzix.zza zza = zzix.zza.ALGORITHM_NOT_FIPS;
    private static final Collection<Integer> zzb = Arrays.asList(new Integer[]{64});
    private static final byte[] zzc = new byte[16];
    private static final ThreadLocal<Cipher> zzd = new zzyz();
    private final zzst zze;
    private final byte[] zzf;
    private final byte[] zzg;

    private zzza(byte[] bArr, zzaam zzaam) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        } else if (zzb.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.zzf = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.zze = zzaac.zza(zzsr.zza(zzsq.zza(copyOfRange.length), zzaan.zza(copyOfRange, zzbi.zza())));
            this.zzg = zzaam.zzb();
        } else {
            int length = bArr.length;
            throw new InvalidKeyException("invalid key size: " + length + " bytes; key must have 64 bytes");
        }
    }

    public static zzbd zza(zzja zzja) throws GeneralSecurityException {
        return new zzza(zzja.zzf().zza(zzbi.zza()), zzja.zze());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        byte[] bArr4 = this.zzg;
        if (length < bArr4.length + 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        } else if (zzqq.zza(bArr4, bArr)) {
            Cipher cipher = zzd.get();
            byte[] bArr5 = this.zzg;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr5.length, bArr5.length + 16);
            byte[] bArr6 = (byte[]) copyOfRange.clone();
            bArr6[8] = (byte) (bArr6[8] & Byte.MAX_VALUE);
            bArr6[12] = (byte) (bArr6[12] & Byte.MAX_VALUE);
            cipher.init(2, new SecretKeySpec(this.zzf, "AES"), new IvParameterSpec(bArr6));
            int length2 = this.zzg.length + 16;
            int length3 = bArr.length - length2;
            byte[] doFinal = cipher.doFinal(bArr, length2, length3);
            if (length3 == 0 && doFinal == null && zzaai.zza()) {
                doFinal = new byte[0];
            }
            byte[][] bArr7 = {bArr2, doFinal};
            byte[] zza2 = this.zze.zza(zzc, 16);
            for (int i = 0; i <= 0; i++) {
                byte[] bArr8 = bArr7[i];
                if (bArr8 == null) {
                    bArr8 = new byte[0];
                }
                zza2 = zzzc.zza(zzse.zzb(zza2), this.zze.zza(bArr8, 16));
            }
            byte[] bArr9 = bArr7[1];
            if (bArr9.length < 16) {
                bArr3 = zzzc.zza(zzse.zza(bArr9), zzse.zzb(zza2));
            } else if (bArr9.length >= zza2.length) {
                int length4 = bArr9.length - zza2.length;
                bArr3 = Arrays.copyOf(bArr9, bArr9.length);
                for (int i2 = 0; i2 < zza2.length; i2++) {
                    int i3 = length4 + i2;
                    bArr3[i3] = (byte) (bArr3[i3] ^ zza2[i2]);
                }
            } else {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            if (MessageDigest.isEqual(copyOfRange, this.zze.zza(bArr3, 16))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }
}
