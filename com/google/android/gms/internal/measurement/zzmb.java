package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzmf;
import java.io.IOException;

public class zzmb<MessageType extends zzmf<MessageType, BuilderType>, BuilderType extends zzmb<MessageType, BuilderType>> extends zzkr<MessageType, BuilderType> {
    protected zzmf zza;
    private final zzmf zzb;

    public zzmb(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzcf()) {
            this.zza = messagetype.zzch();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zznu.zza().zzb(obj.getClass()).zzd(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ zzkr zzaS(byte[] bArr, int i, int i2) throws zzmr {
        int i3 = zzlr.zzb;
        int i4 = zznu.zza;
        zzbe(bArr, 0, i2, zzlr.zza);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzkr zzaT(byte[] bArr, int i, int i2, zzlr zzlr) throws zzmr {
        zzbe(bArr, 0, i2, zzlr);
        return this;
    }

    public final void zzaX() {
        if (!this.zza.zzcf()) {
            zzaY();
        }
    }

    public void zzaY() {
        zzmf zzch = this.zzb.zzch();
        zza(zzch, this.zza);
        this.zza = zzch;
    }

    /* renamed from: zzba */
    public final zzmb zzaR() {
        zzmb zzmb = (zzmb) this.zzb.zzl(5, (Object) null, (Object) null);
        zzmb.zza = zzbf();
        return zzmb;
    }

    /* renamed from: zzbb */
    public MessageType zzbf() {
        if (!this.zza.zzcf()) {
            return this.zza;
        }
        this.zza.zzcj();
        return this.zza;
    }

    public final MessageType zzbc() {
        MessageType zzbb = zzbf();
        if (zzbb.zzcD()) {
            return zzbb;
        }
        throw new zzoh(zzbb);
    }

    public final zzmb zzbd(zzmf zzmf) {
        if (!this.zzb.equals(zzmf)) {
            if (!this.zza.zzcf()) {
                zzaY();
            }
            zza(this.zza, zzmf);
        }
        return this;
    }

    public final zzmb zzbe(byte[] bArr, int i, int i2, zzlr zzlr) throws zzmr {
        if (!this.zza.zzcf()) {
            zzaY();
        }
        try {
            zznu.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i2, new zzkw(zzlr));
            return this;
        } catch (zzmr e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    public final boolean zzcD() {
        return zzmf.zzd(this.zza, false);
    }

    public final /* bridge */ /* synthetic */ zznm zzcE() {
        throw null;
    }
}
