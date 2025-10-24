package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaad  reason: invalid package */
public final class zzaad implements zzst {
    private static final zzix.zza zza = zzix.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final ThreadLocal<Mac> zzb;
    /* access modifiers changed from: private */
    public final String zzc;
    /* access modifiers changed from: private */
    public final Key zzd;
    private final int zze;

    public zzaad(String str, Key key) throws GeneralSecurityException {
        zzaag zzaag = new zzaag(this);
        this.zzb = zzaag;
        if (zza.zza()) {
            this.zzc = str;
            this.zzd = key;
            if (key.getEncoded().length >= 16) {
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case -1823053428:
                        if (str.equals("HMACSHA1")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 392315023:
                        if (str.equals("HMACSHA224")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 392315118:
                        if (str.equals("HMACSHA256")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 392316170:
                        if (str.equals("HMACSHA384")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 392317873:
                        if (str.equals("HMACSHA512")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.zze = 20;
                        break;
                    case 1:
                        this.zze = 28;
                        break;
                    case 2:
                        this.zze = 32;
                        break;
                    case 3:
                        this.zze = 48;
                        break;
                    case 4:
                        this.zze = 64;
                        break;
                    default:
                        throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
                }
                zzaag.get();
                return;
            }
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i <= this.zze) {
            this.zzb.get().update(bArr);
            return Arrays.copyOf(this.zzb.get().doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
