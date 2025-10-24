package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkr;
import com.google.android.gms.internal.measurement.zzks;
import java.io.IOException;
import java.util.List;

public abstract class zzks<MessageType extends zzks<MessageType, BuilderType>, BuilderType extends zzkr<MessageType, BuilderType>> implements zznm {
    protected int zza = 0;

    public static void zzce(Iterable iterable, List list) {
        zzkr.zzaU(iterable, list);
    }

    public final zzlh zzcb() {
        try {
            int zzcn = zzcn();
            zzlh zzlh = zzlh.zzb;
            byte[] bArr = new byte[zzcn];
            int i = zzlm.zzb;
            zzlk zzlk = new zzlk(bArr, 0, zzcn);
            zzcB(zzlk);
            return zzle.zza(zzlk, bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 72);
            sb2.append("Serializing ");
            sb2.append(name);
            sb2.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e);
        }
    }

    public final byte[] zzcc() {
        try {
            int zzcn = zzcn();
            byte[] bArr = new byte[zzcn];
            int i = zzlm.zzb;
            zzlk zzlk = new zzlk(bArr, 0, zzcn);
            zzcB(zzlk);
            zzlk.zzE();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 72);
            sb2.append("Serializing ");
            sb2.append(name);
            sb2.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e);
        }
    }

    public int zzcd(zznx zznx) {
        throw null;
    }
}
