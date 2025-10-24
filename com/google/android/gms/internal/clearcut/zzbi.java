package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.charset.Charset;

class zzbi extends zzbh {
    protected final byte[] zzfp;

    public zzbi(byte[] bArr) {
        this.zzfp = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbb) || size() != ((zzbb) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzbi)) {
            return obj.equals(this);
        }
        zzbi zzbi = (zzbi) obj;
        int zzab = zzab();
        int zzab2 = zzbi.zzab();
        if (zzab == 0 || zzab2 == 0 || zzab == zzab2) {
            return zza(zzbi, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzfp.length;
    }

    public final int zza(int i, int i2, int i3) {
        return zzci.zza(i, this.zzfp, zzac(), i3);
    }

    public final boolean zzaa() {
        int zzac = zzac();
        return zzff.zze(this.zzfp, zzac, size() + zzac);
    }

    public int zzac() {
        return 0;
    }

    public byte zzj(int i) {
        return this.zzfp[i];
    }

    public final zzbb zza(int i, int i2) {
        int zzb = zzbb.zzb(0, i2, size());
        return zzb == 0 ? zzbb.zzfi : new zzbe(this.zzfp, zzac(), zzb);
    }

    public final String zza(Charset charset) {
        return new String(this.zzfp, zzac(), size(), charset);
    }

    public final void zza(zzba zzba) throws IOException {
        zzba.zza(this.zzfp, zzac(), size());
    }

    public final boolean zza(zzbb zzbb, int i, int i2) {
        if (i2 > zzbb.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i2 > zzbb.size()) {
            int size2 = zzbb.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(i2);
            sb3.append(", ");
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        } else if (!(zzbb instanceof zzbi)) {
            return zzbb.zza(0, i2).equals(zza(0, i2));
        } else {
            zzbi zzbi = (zzbi) zzbb;
            byte[] bArr = this.zzfp;
            byte[] bArr2 = zzbi.zzfp;
            int zzac = zzac() + i2;
            int zzac2 = zzac();
            int zzac3 = zzbi.zzac();
            while (zzac2 < zzac) {
                if (bArr[zzac2] != bArr2[zzac3]) {
                    return false;
                }
                zzac2++;
                zzac3++;
            }
            return true;
        }
    }
}
