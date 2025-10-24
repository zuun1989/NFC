package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzdn extends zzcx {
    private static final Logger zzb = Logger.getLogger(zzdn.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzgz.zzx();
    zzdo zza;

    private zzdn() {
        throw null;
    }

    public static int zzA(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzB(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzw(int i, zzfm zzfm, zzge zzge) {
        int zzA = zzA(i << 3);
        return zzA + zzA + ((zzcq) zzfm).zzB(zzge);
    }

    public static int zzx(zzfm zzfm) {
        int zzF = zzfm.zzF();
        return zzA(zzF) + zzF;
    }

    public static int zzy(zzfm zzfm, zzge zzge) {
        int zzB = ((zzcq) zzfm).zzB(zzge);
        return zzA(zzB) + zzB;
    }

    public static int zzz(String str) {
        int i;
        try {
            i = zzhe.zze(str);
        } catch (zzhd unused) {
            i = str.getBytes(zzep.zza).length;
        }
        return zzA(i) + i;
    }

    public final void zzC() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzD(String str, zzhd zzhd) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzhd);
        byte[] bytes = str.getBytes(zzep.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b) throws IOException;

    public abstract void zzd(int i, boolean z) throws IOException;

    public abstract void zze(int i, zzdf zzdf) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(long j) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzm(int i, zzfm zzfm, zzge zzge) throws IOException;

    public abstract void zzn(int i, zzfm zzfm) throws IOException;

    public abstract void zzo(int i, zzdf zzdf) throws IOException;

    public abstract void zzp(int i, String str) throws IOException;

    public abstract void zzr(int i, int i2) throws IOException;

    public abstract void zzs(int i, int i2) throws IOException;

    public abstract void zzt(int i) throws IOException;

    public abstract void zzu(int i, long j) throws IOException;

    public abstract void zzv(long j) throws IOException;

    public /* synthetic */ zzdn(zzdm zzdm) {
    }
}
