package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjh;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjr  reason: invalid package */
public final class zzjr {
    private static final zzaam zza;
    private static final zzpk<zzjh, zzqd> zzb;
    private static final zzpg<zzqd> zzc;
    private static final zznw<zzja, zzqe> zzd;
    private static final zzns<zzqe> zze;
    private static final Map<zzjh.zzb, zzyc> zzf;
    private static final Map<zzyc, zzjh.zzb> zzg;

    static {
        zzaam zzb2 = zzqq.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zza = zzb2;
        Class<zzqd> cls = zzqd.class;
        zzb = zzpk.zza(new zzju(), zzjh.class, cls);
        zzc = zzpg.zza(new zzjt(), zzb2, cls);
        Class<zzqe> cls2 = zzqe.class;
        zzd = zznw.zza(new zzjw(), zzja.class, cls2);
        zze = zzns.zza(new zzjv(), zzb2, cls2);
        HashMap hashMap = new HashMap();
        zzjh.zzb zzb3 = zzjh.zzb.zzc;
        zzyc zzyc = zzyc.RAW;
        hashMap.put(zzb3, zzyc);
        zzjh.zzb zzb4 = zzjh.zzb.zza;
        zzyc zzyc2 = zzyc.TINK;
        hashMap.put(zzb4, zzyc2);
        zzjh.zzb zzb5 = zzjh.zzb.zzb;
        zzyc zzyc3 = zzyc.CRUNCHY;
        hashMap.put(zzb5, zzyc3);
        zzf = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zzyc.class);
        enumMap.put(zzyc, zzb3);
        enumMap.put(zzyc2, zzb4);
        enumMap.put(zzyc3, zzb5);
        enumMap.put(zzyc.LEGACY, zzb5);
        zzg = Collections.unmodifiableMap(enumMap);
    }

    /* access modifiers changed from: private */
    public static zzja zzb(zzqe zzqe, zzck zzck) throws GeneralSecurityException {
        if (zzqe.zzf().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzus zza2 = zzus.zza(zzqe.zzd(), zzakv.zza());
                if (zza2.zza() == 0) {
                    return zzja.zzc().zza(zzjh.zzc().zza(zza2.zzd().zzb()).zza(zza(zzqe.zzc())).zza()).zza(zzaan.zza(zza2.zzd().zzd(), zzck.zza(zzck))).zza(zzqe.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm unused) {
                throw new GeneralSecurityException("Parsing AesSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
    }

    private static zzjh.zzb zza(zzyc zzyc) throws GeneralSecurityException {
        Map<zzyc, zzjh.zzb> map = zzg;
        if (map.containsKey(zzyc)) {
            return map.get(zzyc);
        }
        int zza2 = zzyc.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    /* access modifiers changed from: private */
    public static zzjh zzb(zzqd zzqd) throws GeneralSecurityException {
        if (zzqd.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzuv zza2 = zzuv.zza(zzqd.zza().zze(), zzakv.zza());
                if (zza2.zzb() == 0) {
                    return zzjh.zzc().zza(zza2.zza()).zza(zza(zzqd.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzalm e) {
                throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e);
            }
        } else {
            String zzf2 = zzqd.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: " + zzf2);
        }
    }

    private static zzyc zza(zzjh.zzb zzb2) throws GeneralSecurityException {
        Map<zzjh.zzb, zzyc> map = zzf;
        if (map.containsKey(zzb2)) {
            return map.get(zzb2);
        }
        String valueOf = String.valueOf(zzb2);
        throw new GeneralSecurityException("Unable to serialize variant: " + valueOf);
    }

    public static void zza() throws GeneralSecurityException {
        zzpc zza2 = zzpc.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
