package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzzs;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzm  reason: invalid package */
public final class zzzm<T_WRAPPER extends zzzs<JcePrimitiveT>, JcePrimitiveT> {
    public static final zzzm<zzzr, Cipher> zza = new zzzm<>(new zzzr());
    public static final zzzm<zzzv, Mac> zzb = new zzzm<>(new zzzv());
    public static final zzzm<zzzu, KeyAgreement> zzc = new zzzm<>(new zzzu());
    public static final zzzm<zzzw, KeyPairGenerator> zzd = new zzzm<>(new zzzw());
    public static final zzzm<zzzt, KeyFactory> zze = new zzzm<>(new zzzt());
    private final zzzq<JcePrimitiveT> zzf;

    static {
        new zzzm(new zzzx());
        new zzzm(new zzzy());
    }

    private zzzm(T_WRAPPER t_wrapper) {
        if (zzix.zzb()) {
            this.zzf = new zzzn(t_wrapper);
        } else if (zzaai.zza()) {
            this.zzf = new zzzl(t_wrapper);
        } else {
            this.zzf = new zzzo(t_wrapper);
        }
    }

    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        return this.zzf.zza(str);
    }

    public static List<Provider> zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }
}
