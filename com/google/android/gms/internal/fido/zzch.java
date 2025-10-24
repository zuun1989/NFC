package com.google.android.gms.internal.fido;

import java.io.IOException;

public abstract class zzch {
    private static final zzch zza = new zzcf("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzch zzb = new zzcf("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzch zzc = new zzcg("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final zzch zzd = new zzcg("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final zzch zze = new zzce("base16()", "0123456789ABCDEF");

    public static zzch zzf() {
        return zze;
    }

    public abstract void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzc(int i);

    public abstract zzch zzd();

    public final String zzg(byte[] bArr, int i, int i2) {
        zzap.zze(0, i2, bArr.length);
        StringBuilder sb2 = new StringBuilder(zzc(i2));
        try {
            zzb(sb2, bArr, 0, i2);
            return sb2.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
