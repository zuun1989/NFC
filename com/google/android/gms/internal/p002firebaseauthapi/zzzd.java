package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzd  reason: invalid package */
public final class zzzd implements zzbf {
    static final zznk<zzzh, zzke.zza> zza = zznk.zza().zza(zzzh.NIST_P256, zzke.zza.zza).zza(zzzh.NIST_P384, zzke.zza.zzb).zza(zzzh.NIST_P521, zzke.zza.zzc).zza();
    static final zznk<zzzk, zzke.zzc> zzb = zznk.zza().zza(zzzk.UNCOMPRESSED, zzke.zzc.zzb).zza(zzzk.COMPRESSED, zzke.zzc.zza).zza(zzzk.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzke.zzc.zzc).zza();

    private zzzd(ECPublicKey eCPublicKey, byte[] bArr, String str, zzzk zzzk, zzlq zzlq, byte[] bArr2) throws GeneralSecurityException {
        zzni.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        new zzzf(eCPublicKey);
    }

    public static zzbf zza(zzkg zzkg) throws GeneralSecurityException {
        byte[] byteArray = zzkg.zzf().getAffineX().toByteArray();
        byte[] byteArray2 = zzkg.zzf().getAffineY().toByteArray();
        ECParameterSpec zza2 = zzzi.zza(zza.zza(((zzke) ((zzlj) zzkg.zza())).zzd()));
        ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
        zzni.zza(eCPoint, zza2.getCurve());
        ECPublicKey eCPublicKey = (ECPublicKey) zzzm.zze.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, zza2));
        byte[] bArr = new byte[0];
        if (((zzke) ((zzlj) zzkg.zza())).zzh() != null) {
            bArr = ((zzke) ((zzlj) zzkg.zza())).zzh().zzb();
        }
        return new zzzd(eCPublicKey, bArr, zza(((zzke) ((zzlj) zzkg.zza())).zze()), zzb.zza(((zzke) ((zzlj) zzkg.zza())).zzf()), zzlm.zza((zzke) ((zzlj) zzkg.zza())), zzkg.zzd().zzb());
    }

    public static final String zza(zzke.zzd zzd) throws GeneralSecurityException {
        if (zzd.equals(zzke.zzd.zza)) {
            return "HmacSha1";
        }
        if (zzd.equals(zzke.zzd.zzb)) {
            return "HmacSha224";
        }
        if (zzd.equals(zzke.zzd.zzc)) {
            return "HmacSha256";
        }
        if (zzd.equals(zzke.zzd.zzd)) {
            return "HmacSha384";
        }
        if (zzd.equals(zzke.zzd.zze)) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzd);
        throw new GeneralSecurityException("hash unsupported for EciesAeadHkdf: " + valueOf);
    }
}
