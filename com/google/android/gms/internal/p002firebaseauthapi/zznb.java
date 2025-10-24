package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznb  reason: invalid package */
final class zznb implements zzaz {
    private final SecretKey zza;

    public zznb(String str, KeyStore keyStore) throws GeneralSecurityException {
        SecretKey secretKey = (SecretKey) keyStore.getKey(str, (char[]) null);
        this.zza = secretKey;
        if (secretKey == null) {
            throw new InvalidKeyException("Keystore cannot load the key with ID: " + str);
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 28) {
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(2, this.zza, gCMParameterSpec);
            instance.updateAAD(bArr2);
            return instance.doFinal(bArr, 12, bArr.length - 12);
        }
        throw new BadPaddingException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 2147483619) {
            byte[] bArr3 = new byte[(bArr.length + 28)];
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(1, this.zza);
            instance.updateAAD(bArr2);
            if (instance.doFinal(bArr, 0, bArr.length, bArr3, 12) == bArr.length + 16) {
                byte[] iv = instance.getIV();
                if (iv.length == 12) {
                    System.arraycopy(iv, 0, bArr3, 0, 12);
                    return bArr3;
                }
                throw new GeneralSecurityException("IV has unexpected length");
            }
            throw new GeneralSecurityException("encryption failed: bytesWritten is wrong");
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
