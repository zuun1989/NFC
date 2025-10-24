package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxk;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbq  reason: invalid package */
public final class zzbq {
    private final List<zzbp> zza = new ArrayList();
    private zzoj zzb = zzoj.zza;
    private boolean zzc = false;

    /* access modifiers changed from: private */
    public final void zzb() {
        for (zzbp zza2 : this.zza) {
            zza2.zza = false;
        }
    }

    public final zzbq zza(zzbp zzbp) {
        if (zzbp.zze == null) {
            if (zzbp.zza) {
                zzb();
            }
            zzbp.zze = this;
            this.zza.add(zzbp);
            return this;
        }
        throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
    }

    public final zzbl zza() throws GeneralSecurityException {
        int i;
        if (!this.zzc) {
            this.zzc = true;
            zzxk.zzb zzc2 = zzxk.zzc();
            ArrayList arrayList = new ArrayList(this.zza.size());
            List<zzbp> list = this.zza;
            int i2 = 0;
            while (i2 < list.size() - 1) {
                if (list.get(i2).zzd != zzbs.zza || list.get(i2 + 1).zzd == zzbs.zza) {
                    i2++;
                } else {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
            HashSet hashSet = new HashSet();
            Integer num = null;
            for (zzbp next : this.zza) {
                if (next.zzb == null) {
                    throw new GeneralSecurityException("Key Status not set.");
                } else if (next.zzd != null) {
                    if (next.zzd == zzbs.zza) {
                        i = 0;
                        while (true) {
                            if (i != 0 && !hashSet.contains(Integer.valueOf(i))) {
                                break;
                            }
                            i = zzqq.zza();
                        }
                    } else {
                        i = zzbs.zza(next.zzd);
                    }
                    if (!hashSet.contains(Integer.valueOf(i))) {
                        hashSet.add(Integer.valueOf(i));
                        zzbh zza2 = zzos.zza().zza(next.zzc, next.zzc.zza() ? Integer.valueOf(i) : null);
                        zzbr zzbr = r10;
                        zzbr zzbr2 = new zzbr(zza2, zzbl.zza(next.zzb), i, next.zza, false, zzbr.zza);
                        zzc2.zza(zzbl.zzb(zza2, zzbl.zza(next.zzb), i));
                        if (next.zza) {
                            if (num == null) {
                                num = Integer.valueOf(i);
                                if (next.zzb != zzbj.zza) {
                                    throw new GeneralSecurityException("Primary key is not enabled");
                                }
                            } else {
                                throw new GeneralSecurityException("Two primaries were set");
                            }
                        }
                        arrayList.add(zzbr);
                    } else {
                        throw new GeneralSecurityException("Id " + i + " is used twice in the keyset");
                    }
                } else {
                    throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
                }
            }
            if (num != null) {
                zzc2.zza(num.intValue());
                zzxk zzxk = (zzxk) ((zzalg) zzc2.zze());
                zzbl.zzd(zzxk);
                return zzbl.zzb(new zzbl(zzxk, arrayList, this.zzb));
            }
            throw new GeneralSecurityException("No primary was set");
        }
        throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
    }
}
