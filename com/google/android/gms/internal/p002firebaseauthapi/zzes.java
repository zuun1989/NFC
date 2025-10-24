package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzes  reason: invalid package */
public final class zzes implements zzaz {
    private static final byte[] zza = new byte[0];
    private static final Set<String> zzb;
    private final String zzc;
    private final zzce zzd;
    private final zzaz zze;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    private zzes(zzxe zzxe, zzaz zzaz) throws GeneralSecurityException {
        if (zzb.contains(zzxe.zzf())) {
            this.zzc = zzxe.zzf();
            this.zzd = zzcm.zza(((zzxe) ((zzalg) zzxe.zza(zzxe).zza(zzyc.RAW).zze())).zzk());
            this.zze = zzaz;
            return;
        }
        String zzf = zzxe.zzf();
        throw new IllegalArgumentException("Unsupported DEK key type: " + zzf + ". Only Tink AEAD key types are supported.");
    }

    public static zzaz zza(zzcx zzcx, zzaz zzaz) throws GeneralSecurityException {
        try {
            return new zzes(zzxe.zza(zzcm.zza((zzce) zzcx), zzakv.zza()), zzaz);
        } catch (zzalm e) {
            throw new GeneralSecurityException(e);
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzbh zza2 = zzos.zza().zza(this.zzd, (Integer) null);
        byte[] zzb2 = this.zze.zzb(((zzqe) zzpc.zza().zza(zza2, zzqe.class, zzbi.zza())).zzd().zzd(), zza);
        if (zzb2.length <= 4096) {
            byte[] zzb3 = ((zzaz) zzoz.zza().zza(zza2, zzaz.class)).zzb(bArr, bArr2);
            return ByteBuffer.allocate(zzb2.length + 4 + zzb3.length).putInt(zzb2.length).put(zzb2).put(zzb3).array();
        }
        throw new GeneralSecurityException("length of encrypted DEK too large");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > 4096 || i > bArr.length - 4) {
                throw new GeneralSecurityException("length of encrypted DEK too large");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((zzaz) zzoz.zza().zza(zzpc.zza().zza(zzqe.zza(this.zzc, zzajw.zza(this.zze.zza(bArr3, zza)), zzxa.zza.SYMMETRIC, zzyc.RAW, (Integer) null), zzbi.zza()), zzaz.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e) {
            e = e;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e3) {
            e = e3;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
