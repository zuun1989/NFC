package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzb  reason: invalid package */
public final class zzzb implements zzaz {
    private final zzhw zza;
    private final byte[] zzb;

    private zzzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zza = new zzhw(bArr);
        this.zzb = bArr2;
    }

    public static zzaz zza(zzei zzei) throws GeneralSecurityException {
        return new zzzb(zzei.zze().zza(zzbi.zza()), zzei.zzd().zzb());
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 28) {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            return this.zza.zza(ByteBuffer.wrap(bArr, 12, bArr.length - 12), copyOf, bArr2);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 28);
        byte[] zza2 = zzqg.zza(12);
        allocate.put(zza2);
        this.zza.zza(allocate, zza2, bArr, bArr2);
        byte[] array = allocate.array();
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return array;
        }
        return zzzc.zza(bArr3, array);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzqq.zza(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }
}
