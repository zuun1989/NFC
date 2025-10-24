package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlg  reason: invalid package */
public final class zzlg {
    public static final zzxe zza;
    private static final byte[] zzb;

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zzvv zzvv = zzvv.NIST_P256;
        zzwb zzwb = zzwb.SHA256;
        zzve zzve = zzve.UNCOMPRESSED;
        zzxe zzxe = zzcy.zza;
        zzyc zzyc = zzyc.TINK;
        zzwb zzwb2 = zzwb;
        zzxe zzxe2 = zzxe;
        byte[] bArr2 = bArr;
        zza = zza(zzvv, zzwb2, zzve, zzxe2, zzyc, bArr2);
        zzvv zzvv2 = zzvv;
        zza(zzvv2, zzwb2, zzve.COMPRESSED, zzxe2, zzyc.RAW, bArr2);
        zza(zzvv2, zzwb2, zzve, zzcy.zzc, zzyc, bArr2);
    }

    @Deprecated
    private static zzxe zza(zzvv zzvv, zzwb zzwb, zzve zzve, zzxe zzxe, zzyc zzyc, byte[] bArr) {
        return (zzxe) ((zzalg) zzxe.zza().zza(zzka.zza()).zza(zzyc).zza(((zzvg) ((zzalg) zzvg.zza().zza((zzvj) ((zzalg) zzvj.zzc().zza((zzvs) ((zzalg) zzvs.zza().zza(zzvv).zza(zzwb).zza(zzajw.zza(bArr)).zze())).zza((zzvd) ((zzalg) zzvd.zza().zza(zzxe).zze())).zza(zzve).zze())).zze())).zzj()).zze());
    }
}
