package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

final class zzfe implements zzgf {
    private static final zzfk zza = new zzfc();
    private final zzfk zzb;

    public zzfe() {
        zzea zza2 = zzea.zza();
        int i = zzfu.zza;
        zzfd zzfd = new zzfd(zza2, zza);
        byte[] bArr = zzep.zzb;
        this.zzb = zzfd;
    }

    public final zzge zza(Class cls) {
        zzdt zzdt;
        int i = zzgg.zza;
        if (!zzeh.class.isAssignableFrom(cls)) {
            int i2 = zzfu.zza;
        }
        zzfj zzb2 = this.zzb.zzb(cls);
        if (!zzb2.zzb()) {
            int i3 = zzfu.zza;
            zzfs zza2 = zzft.zza();
            zzez zza3 = zzfa.zza();
            zzgs zzm = zzgg.zzm();
            if (zzb2.zzc() - 1 != 1) {
                zzdt = zzdv.zza();
            } else {
                zzdt = null;
            }
            return zzfp.zzl(cls, zzb2, zza2, zza3, zzm, zzdt, zzfi.zza());
        }
        int i4 = zzfu.zza;
        return zzfq.zzc(zzgg.zzm(), zzdv.zza(), zzb2.zza());
    }
}
