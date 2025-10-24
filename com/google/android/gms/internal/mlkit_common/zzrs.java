package com.google.android.gms.internal.mlkit_common;

final class zzrs extends zzsa {
    private String zza;
    private boolean zzb;
    private int zzc;
    private byte zzd;

    public final zzsa zza(boolean z) {
        this.zzb = true;
        this.zzd = (byte) (1 | this.zzd);
        return this;
    }

    public final zzsa zzb(int i) {
        this.zzc = 1;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    public final zzsa zzc(String str) {
        this.zza = "common";
        return this;
    }

    public final zzsb zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzru(str, this.zzb, this.zzc, (zzrt) null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" libraryName");
        }
        if ((this.zzd & 1) == 0) {
            sb2.append(" enableFirelog");
        }
        if ((this.zzd & 2) == 0) {
            sb2.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
