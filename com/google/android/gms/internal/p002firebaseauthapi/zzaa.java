package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaa  reason: invalid package */
abstract class zzaa extends zzd<String> {
    final CharSequence zza;
    private final zzf zzb;
    private final boolean zzc;
    private int zzd = 0;
    private int zze;

    public zzaa(zzt zzt, CharSequence charSequence) {
        this.zzb = zzt.zza;
        this.zzc = false;
        this.zze = zzt.zzc;
        this.zza = charSequence;
    }

    public abstract int zza(int i);

    public final /* synthetic */ Object zza() {
        int i;
        int i2 = this.zzd;
        while (true) {
            int i3 = this.zzd;
            if (i3 != -1) {
                int zzb2 = zzb(i3);
                if (zzb2 == -1) {
                    zzb2 = this.zza.length();
                    this.zzd = -1;
                } else {
                    this.zzd = zza(zzb2);
                }
                int i4 = this.zzd;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.zzd = i5;
                    if (i5 > this.zza.length()) {
                        this.zzd = -1;
                    }
                } else {
                    while (i2 < zzb2 && this.zzb.zza(this.zza.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.zzb.zza(this.zza.charAt(i - 1))) {
                        zzb2 = i - 1;
                    }
                    int i6 = this.zze;
                    if (i6 == 1) {
                        i = this.zza.length();
                        this.zzd = -1;
                        while (i > i2 && this.zzb.zza(this.zza.charAt(i - 1))) {
                            i--;
                        }
                    } else {
                        this.zze = i6 - 1;
                    }
                    return this.zza.subSequence(i2, i).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    public abstract int zzb(int i);
}
