package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzajn;
import com.google.android.gms.internal.p002firebaseauthapi.zzajp;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajn  reason: invalid package */
public abstract class zzajn<MessageType extends zzajn<MessageType, BuilderType>, BuilderType extends zzajp<MessageType, BuilderType>> implements zzamn {
    protected int zza = 0;

    public int zza(zzanc zzanc) {
        int zzi = zzi();
        if (zzi != -1) {
            return zzi;
        }
        int zza2 = zzanc.zza(this);
        zzb(zza2);
        return zza2;
    }

    public void zzb(int i) {
        throw new UnsupportedOperationException();
    }

    public int zzi() {
        throw new UnsupportedOperationException();
    }

    public final zzajw zzj() {
        try {
            zzakf zzc = zzajw.zzc(zzl());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a " + "ByteString" + " threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzk() {
        try {
            byte[] bArr = new byte[zzl()];
            zzako zzb = zzako.zzb(bArr);
            zza(zzb);
            zzb.zzb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a " + "byte array" + " threw an IOException (should never happen).", e);
        }
    }

    public final void zza(OutputStream outputStream) throws IOException {
        zzako zza2 = zzako.zza(outputStream, zzako.zzd(zzl()));
        zza(zza2);
        zza2.zzc();
    }
}
