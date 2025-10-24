package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzfq implements zzge {
    private final zzfm zza;
    private final zzgs zzb;
    private final boolean zzc;
    private final zzdt zzd;

    private zzfq(zzgs zzgs, zzdt zzdt, zzfm zzfm) {
        this.zzb = zzgs;
        this.zzc = zzfm instanceof zzed;
        this.zzd = zzdt;
        this.zza = zzfm;
    }

    public static zzfq zzc(zzgs zzgs, zzdt zzdt, zzfm zzfm) {
        return new zzfq(zzgs, zzdt, zzfm);
    }

    public final int zza(Object obj) {
        int zzb2 = ((zzeh) obj).zzc.zzb();
        if (this.zzc) {
            return zzb2 + ((zzed) obj).zzb.zzb();
        }
        return zzb2;
    }

    public final int zzb(Object obj) {
        int hashCode = ((zzeh) obj).zzc.hashCode();
        if (this.zzc) {
            return (hashCode * 53) + ((zzed) obj).zzb.zza.hashCode();
        }
        return hashCode;
    }

    public final Object zze() {
        zzfm zzfm = this.zza;
        if (zzfm instanceof zzeh) {
            return ((zzeh) zzfm).zzK();
        }
        return zzfm.zzZ().zzk();
    }

    public final void zzf(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzgg.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzgg.zzo(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzcu zzcu) throws IOException {
        zzeh zzeh = (zzeh) obj;
        zzgt zzgt = zzeh.zzc;
        if (zzgt == zzgt.zzc()) {
            zzgt = zzgt.zzf();
            zzeh.zzc = zzgt;
        }
        zzdx zzc2 = ((zzed) obj).zzc();
        zzef zzef = null;
        while (i < i2) {
            int zzj = zzcv.zzj(bArr, i, zzcu);
            int i3 = zzcu.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzdf zzdf = null;
                while (zzj < i2) {
                    zzj = zzcv.zzj(bArr, zzj, zzcu);
                    int i5 = zzcu.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzef != null) {
                                zzj = zzcv.zze(zzfu.zza().zzb(zzef.zza.getClass()), bArr, zzj, i2, zzcu);
                                zzc2.zzi(zzef.zzb, zzcu.zzc);
                            } else if (i7 == 2) {
                                zzj = zzcv.zza(bArr, zzj, zzcu);
                                zzdf = (zzdf) zzcu.zzc;
                            }
                        }
                    } else if (i7 == 0) {
                        zzj = zzcv.zzj(bArr, zzj, zzcu);
                        i4 = zzcu.zza;
                        zzef = zzcu.zzd.zzb(this.zza, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zzj = zzcv.zzp(i5, bArr, zzj, i2, zzcu);
                }
                if (zzdf != null) {
                    zzgt.zzj((i4 << 3) | 2, zzdf);
                }
                i = zzj;
            } else if ((i3 & 7) == 2) {
                zzef zzb2 = zzcu.zzd.zzb(this.zza, i3 >>> 3);
                if (zzb2 != null) {
                    i = zzcv.zze(zzfu.zza().zzb(zzb2.zza.getClass()), bArr, zzj, i2, zzcu);
                    zzc2.zzi(zzb2.zzb, zzcu.zzc);
                } else {
                    i = zzcv.zzi(i3, bArr, zzj, i2, zzgt, zzcu);
                }
                zzef = zzb2;
            } else {
                i = zzcv.zzp(i3, bArr, zzj, i2, zzcu);
            }
        }
        if (i != i2) {
            throw new zzer("Failed to parse the message.");
        }
    }

    public final void zzi(Object obj, zzhh zzhh) throws IOException {
        Iterator zzf = ((zzed) obj).zzb.zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzdw zzdw = (zzdw) entry.getKey();
            if (zzdw.zze() == zzhg.MESSAGE) {
                zzdw.zzg();
                zzdw.zzf();
                if (entry instanceof zzeu) {
                    zzhh.zzw(zzdw.zza(), ((zzeu) entry).zza().zzb());
                } else {
                    zzhh.zzw(zzdw.zza(), entry.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        ((zzeh) obj).zzc.zzk(zzhh);
    }

    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
        }
        return true;
    }

    public final boolean zzk(Object obj) {
        return ((zzed) obj).zzb.zzk();
    }
}
