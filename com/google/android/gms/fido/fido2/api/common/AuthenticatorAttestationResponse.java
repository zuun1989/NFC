package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fido.u2f.api.common.SignResponseData;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;

@SafeParcelable.Class(creator = "AuthenticatorAttestationResponseCreator")
@SafeParcelable.Reserved({1})
public class AuthenticatorAttestationResponse extends AuthenticatorResponse {
    public static final Parcelable.Creator<AuthenticatorAttestationResponse> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getKeyHandle", id = 2)
    private final byte[] zza;
    @SafeParcelable.Field(getter = "getClientDataJSON", id = 3)
    private final byte[] zzb;
    @SafeParcelable.Field(getter = "getAttestationObject", id = 4)
    private final byte[] zzc;
    @SafeParcelable.Field(getter = "getTransports", id = 5)
    private final String[] zzd;

    @SafeParcelable.Constructor
    public AuthenticatorAttestationResponse(@SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) byte[] bArr2, @SafeParcelable.Param(id = 4) byte[] bArr3, @SafeParcelable.Param(id = 5) String[] strArr) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (byte[]) Preconditions.checkNotNull(bArr2);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr3);
        this.zzd = (String[]) Preconditions.checkNotNull(strArr);
    }

    public static AuthenticatorAttestationResponse deserializeFromBytes(byte[] bArr) {
        return (AuthenticatorAttestationResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorAttestationResponse)) {
            return false;
        }
        AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) obj;
        if (!Arrays.equals(this.zza, authenticatorAttestationResponse.zza) || !Arrays.equals(this.zzb, authenticatorAttestationResponse.zzb) || !Arrays.equals(this.zzc, authenticatorAttestationResponse.zzc)) {
            return false;
        }
        return true;
    }

    public byte[] getAttestationObject() {
        return this.zzc;
    }

    public byte[] getClientDataJSON() {
        return this.zzb;
    }

    @Deprecated
    public byte[] getKeyHandle() {
        return this.zza;
    }

    public String[] getTransports() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)));
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public String toString() {
        zzam zza2 = zzan.zza(this);
        zzch zzf = zzch.zzf();
        byte[] bArr = this.zza;
        zza2.zzb(SignResponseData.JSON_RESPONSE_DATA_KEY_HANDLE, zzf.zzg(bArr, 0, bArr.length));
        zzch zzf2 = zzch.zzf();
        byte[] bArr2 = this.zzb;
        zza2.zzb("clientDataJSON", zzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzf3 = zzch.zzf();
        byte[] bArr3 = this.zzc;
        zza2.zzb("attestationObject", zzf3.zzg(bArr3, 0, bArr3.length));
        zza2.zzb("transports", Arrays.toString(this.zzd));
        return zza2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getKeyHandle(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getClientDataJSON(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getAttestationObject(), false);
        SafeParcelWriter.writeStringArray(parcel, 5, getTransports(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ee A[Catch:{ zzdq -> 0x0229, IllegalArgumentException -> 0x0217, zzdq -> 0x0184, JSONException -> 0x0015 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject zza() {
        /*
            r19 = this;
            r1 = r19
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0015 }
            r0.<init>()     // Catch:{ JSONException -> 0x0015 }
            byte[] r2 = r1.zzb     // Catch:{ JSONException -> 0x0015 }
            if (r2 == 0) goto L_0x0018
            java.lang.String r3 = "clientDataJSON"
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r2)     // Catch:{ JSONException -> 0x0015 }
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r0 = move-exception
            goto L_0x0246
        L_0x0018:
            byte[] r2 = r1.zzc     // Catch:{ JSONException -> 0x0015 }
            if (r2 == 0) goto L_0x0025
            java.lang.String r3 = "attestationObject"
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r2)     // Catch:{ JSONException -> 0x0015 }
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x0015 }
        L_0x0025:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0015 }
            r2.<init>()     // Catch:{ JSONException -> 0x0015 }
            r3 = 0
            r4 = r3
        L_0x002c:
            java.lang.String[] r5 = r1.zzd     // Catch:{ JSONException -> 0x0015 }
            int r6 = r5.length     // Catch:{ JSONException -> 0x0015 }
            if (r4 >= r6) goto L_0x004f
            r5 = r5[r4]     // Catch:{ JSONException -> 0x0015 }
            com.google.android.gms.fido.common.Transport r6 = com.google.android.gms.fido.common.Transport.HYBRID     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x0015 }
            boolean r5 = r5.equals(r6)     // Catch:{ JSONException -> 0x0015 }
            if (r5 == 0) goto L_0x0045
            java.lang.String r5 = "hybrid"
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x0015 }
            goto L_0x004c
        L_0x0045:
            java.lang.String[] r5 = r1.zzd     // Catch:{ JSONException -> 0x0015 }
            r5 = r5[r4]     // Catch:{ JSONException -> 0x0015 }
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x0015 }
        L_0x004c:
            int r4 = r4 + 1
            goto L_0x002c
        L_0x004f:
            java.lang.String r4 = "transports"
            r0.put(r4, r2)     // Catch:{ JSONException -> 0x0015 }
            byte[] r2 = r1.zzc     // Catch:{ JSONException -> 0x0015 }
            com.google.android.gms.internal.fido.zzdr r2 = com.google.android.gms.internal.fido.zzdr.zzj(r2)     // Catch:{ zzdq -> 0x023d, zzdl -> 0x023b }
            com.google.android.gms.internal.fido.zzdo r2 = r2.zzh()     // Catch:{ zzdq -> 0x023d, zzdl -> 0x023b }
            com.google.android.gms.internal.fido.zzbg r2 = r2.zzc()     // Catch:{ zzdq -> 0x0229 }
            java.lang.String r4 = "authData"
            com.google.android.gms.internal.fido.zzdp r4 = com.google.android.gms.internal.fido.zzdr.zzi(r4)     // Catch:{ zzdq -> 0x0229 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ zzdq -> 0x0229 }
            com.google.android.gms.internal.fido.zzdr r2 = (com.google.android.gms.internal.fido.zzdr) r2     // Catch:{ zzdq -> 0x0229 }
            if (r2 == 0) goto L_0x022b
            com.google.android.gms.internal.fido.zzdk r2 = r2.zze()     // Catch:{ zzdq -> 0x0229 }
            com.google.android.gms.internal.fido.zzcz r2 = r2.zzc()     // Catch:{ zzdq -> 0x0229 }
            java.nio.ByteBuffer r4 = r2.zzi()     // Catch:{ JSONException -> 0x0015 }
            int r5 = r4.position()     // Catch:{ IllegalArgumentException -> 0x0217 }
            r6 = 32
            int r5 = r5 + r6
            r4.position(r5)     // Catch:{ IllegalArgumentException -> 0x0217 }
            byte r5 = r4.get()     // Catch:{ IllegalArgumentException -> 0x0217 }
            r5 = r5 & 64
            if (r5 == 0) goto L_0x0219
            int r5 = r4.position()     // Catch:{ IllegalArgumentException -> 0x0217 }
            int r5 = r5 + 4
            r4.position(r5)     // Catch:{ IllegalArgumentException -> 0x0217 }
            int r5 = r4.position()     // Catch:{ IllegalArgumentException -> 0x0217 }
            int r5 = r5 + 16
            r4.position(r5)     // Catch:{ IllegalArgumentException -> 0x0217 }
            short r5 = r4.getShort()     // Catch:{ IllegalArgumentException -> 0x0217 }
            int r7 = r4.position()     // Catch:{ IllegalArgumentException -> 0x0217 }
            int r7 = r7 + r5
            r4.position(r7)     // Catch:{ IllegalArgumentException -> 0x0217 }
            int r4 = r4.position()     // Catch:{ zzdq -> 0x020e, zzdl -> 0x020c }
            int r5 = r2.zzd()     // Catch:{ zzdq -> 0x020e, zzdl -> 0x020c }
            com.google.android.gms.internal.fido.zzcz r4 = r2.zzg(r4, r5)     // Catch:{ zzdq -> 0x020e, zzdl -> 0x020c }
            java.io.InputStream r4 = r4.zzh()     // Catch:{ zzdq -> 0x020e, zzdl -> 0x020c }
            com.google.android.gms.internal.fido.zzdr r4 = com.google.android.gms.internal.fido.zzdr.zzk(r4)     // Catch:{ zzdq -> 0x020e, zzdl -> 0x020c }
            com.google.android.gms.internal.fido.zzdo r4 = r4.zzh()     // Catch:{ zzdq -> 0x020e, zzdl -> 0x020c }
            com.google.android.gms.internal.fido.zzbg r5 = r4.zzc()     // Catch:{ JSONException -> 0x0015 }
            r7 = 3
            com.google.android.gms.internal.fido.zzdm r7 = com.google.android.gms.internal.fido.zzdr.zzg(r7)     // Catch:{ JSONException -> 0x0015 }
            java.lang.Object r5 = r5.get(r7)     // Catch:{ JSONException -> 0x0015 }
            com.google.android.gms.internal.fido.zzdr r5 = (com.google.android.gms.internal.fido.zzdr) r5     // Catch:{ JSONException -> 0x0015 }
            com.google.android.gms.internal.fido.zzbg r7 = r4.zzc()     // Catch:{ JSONException -> 0x0015 }
            r8 = 1
            com.google.android.gms.internal.fido.zzdm r10 = com.google.android.gms.internal.fido.zzdr.zzg(r8)     // Catch:{ JSONException -> 0x0015 }
            java.lang.Object r7 = r7.get(r10)     // Catch:{ JSONException -> 0x0015 }
            com.google.android.gms.internal.fido.zzdr r7 = (com.google.android.gms.internal.fido.zzdr) r7     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r10 = "COSE key missing required fields"
            if (r5 == 0) goto L_0x0206
            if (r7 == 0) goto L_0x0206
            com.google.android.gms.internal.fido.zzdm r5 = r5.zzf()     // Catch:{ zzdq -> 0x0184 }
            long r11 = r5.zzc()     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzdm r5 = r7.zzf()     // Catch:{ zzdq -> 0x0184 }
            long r13 = r5.zzc()     // Catch:{ zzdq -> 0x0184 }
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            r15 = 2
            if (r5 == 0) goto L_0x0109
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r5 != 0) goto L_0x0106
            r13 = r15
            goto L_0x0109
        L_0x0106:
            r7 = 0
            goto L_0x01da
        L_0x0109:
            com.google.android.gms.internal.fido.zzbg r5 = r4.zzc()     // Catch:{ zzdq -> 0x0184 }
            r17 = -1
            com.google.android.gms.internal.fido.zzdm r7 = com.google.android.gms.internal.fido.zzdr.zzg(r17)     // Catch:{ zzdq -> 0x0184 }
            java.lang.Object r5 = r5.get(r7)     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzdr r5 = (com.google.android.gms.internal.fido.zzdr) r5     // Catch:{ zzdq -> 0x0184 }
            if (r5 == 0) goto L_0x01f8
            com.google.android.gms.internal.fido.zzdm r5 = r5.zzf()     // Catch:{ zzdq -> 0x0184 }
            long r17 = r5.zzc()     // Catch:{ zzdq -> 0x0184 }
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            java.lang.String r7 = "COSE coordinates are the wrong size"
            r15 = -2
            if (r5 != 0) goto L_0x0193
            int r5 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x0193
            com.google.android.gms.internal.fido.zzbg r5 = r4.zzc()     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzdm r8 = com.google.android.gms.internal.fido.zzdr.zzg(r15)     // Catch:{ zzdq -> 0x0184 }
            java.lang.Object r5 = r5.get(r8)     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzdr r5 = (com.google.android.gms.internal.fido.zzdr) r5     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzbg r4 = r4.zzc()     // Catch:{ zzdq -> 0x0184 }
            r8 = -3
            com.google.android.gms.internal.fido.zzdm r8 = com.google.android.gms.internal.fido.zzdr.zzg(r8)     // Catch:{ zzdq -> 0x0184 }
            java.lang.Object r4 = r4.get(r8)     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzdr r4 = (com.google.android.gms.internal.fido.zzdr) r4     // Catch:{ zzdq -> 0x0184 }
            if (r5 == 0) goto L_0x018d
            if (r4 == 0) goto L_0x018d
            com.google.android.gms.internal.fido.zzdk r5 = r5.zze()     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzcz r5 = r5.zzc()     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzdk r4 = r4.zze()     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzcz r4 = r4.zzc()     // Catch:{ zzdq -> 0x0184 }
            int r8 = r5.zzd()     // Catch:{ zzdq -> 0x0184 }
            if (r8 != r6) goto L_0x0187
            int r8 = r4.zzd()     // Catch:{ zzdq -> 0x0184 }
            if (r8 != r6) goto L_0x0187
            java.lang.String r6 = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE"
            byte[] r3 = android.util.Base64.decode(r6, r3)     // Catch:{ zzdq -> 0x0184 }
            byte[] r5 = r5.zzm()     // Catch:{ zzdq -> 0x0184 }
            byte[] r4 = r4.zzm()     // Catch:{ zzdq -> 0x0184 }
            byte[][] r3 = new byte[][]{r3, r5, r4}     // Catch:{ zzdq -> 0x0184 }
            byte[] r7 = com.google.android.gms.internal.fido.zzcl.zza(r3)     // Catch:{ zzdq -> 0x0184 }
            goto L_0x01da
        L_0x0184:
            r0 = move-exception
            goto L_0x01fe
        L_0x0187:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x0184 }
            r0.<init>(r7)     // Catch:{ zzdq -> 0x0184 }
            throw r0     // Catch:{ zzdq -> 0x0184 }
        L_0x018d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x0184 }
            r0.<init>(r10)     // Catch:{ zzdq -> 0x0184 }
            throw r0     // Catch:{ zzdq -> 0x0184 }
        L_0x0193:
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x0106
            r8 = 6
            int r5 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x0106
            com.google.android.gms.internal.fido.zzbg r4 = r4.zzc()     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzdm r5 = com.google.android.gms.internal.fido.zzdr.zzg(r15)     // Catch:{ zzdq -> 0x0184 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzdr r4 = (com.google.android.gms.internal.fido.zzdr) r4     // Catch:{ zzdq -> 0x0184 }
            if (r4 == 0) goto L_0x01d4
            com.google.android.gms.internal.fido.zzdk r4 = r4.zze()     // Catch:{ zzdq -> 0x0184 }
            com.google.android.gms.internal.fido.zzcz r4 = r4.zzc()     // Catch:{ zzdq -> 0x0184 }
            int r5 = r4.zzd()     // Catch:{ zzdq -> 0x0184 }
            if (r5 != r6) goto L_0x01ce
            java.lang.String r5 = "MCowBQYDK2VwAyEA"
            byte[] r3 = android.util.Base64.decode(r5, r3)     // Catch:{ zzdq -> 0x0184 }
            byte[] r4 = r4.zzm()     // Catch:{ zzdq -> 0x0184 }
            byte[][] r3 = new byte[][]{r3, r4}     // Catch:{ zzdq -> 0x0184 }
            byte[] r7 = com.google.android.gms.internal.fido.zzcl.zza(r3)     // Catch:{ zzdq -> 0x0184 }
            goto L_0x01da
        L_0x01ce:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x0184 }
            r0.<init>(r7)     // Catch:{ zzdq -> 0x0184 }
            throw r0     // Catch:{ zzdq -> 0x0184 }
        L_0x01d4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x0184 }
            r0.<init>(r10)     // Catch:{ zzdq -> 0x0184 }
            throw r0     // Catch:{ zzdq -> 0x0184 }
        L_0x01da:
            java.lang.String r3 = "authenticatorData"
            byte[] r2 = r2.zzm()     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r2)     // Catch:{ JSONException -> 0x0015 }
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r2 = "publicKeyAlgorithm"
            r0.put(r2, r11)     // Catch:{ JSONException -> 0x0015 }
            if (r7 == 0) goto L_0x01f7
            java.lang.String r2 = "publicKey"
            java.lang.String r3 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r7)     // Catch:{ JSONException -> 0x0015 }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x0015 }
        L_0x01f7:
            return r0
        L_0x01f8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x0184 }
            r0.<init>(r10)     // Catch:{ zzdq -> 0x0184 }
            throw r0     // Catch:{ zzdq -> 0x0184 }
        L_0x01fe:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r3 = "COSE key ill-formed"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0015 }
            throw r2     // Catch:{ JSONException -> 0x0015 }
        L_0x0206:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0015 }
            r0.<init>(r10)     // Catch:{ JSONException -> 0x0015 }
            throw r0     // Catch:{ JSONException -> 0x0015 }
        L_0x020c:
            r0 = move-exception
            goto L_0x020f
        L_0x020e:
            r0 = move-exception
        L_0x020f:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r3 = "failed to parse COSE key"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0015 }
            throw r2     // Catch:{ JSONException -> 0x0015 }
        L_0x0217:
            r0 = move-exception
            goto L_0x0221
        L_0x0219:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0217 }
            java.lang.String r2 = "authData does not include credential data"
            r0.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0217 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0217 }
        L_0x0221:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r3 = "ill-formed authenticator data"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0015 }
            throw r2     // Catch:{ JSONException -> 0x0015 }
        L_0x0229:
            r0 = move-exception
            goto L_0x0233
        L_0x022b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x0229 }
            java.lang.String r2 = "attestation object missing authData"
            r0.<init>(r2)     // Catch:{ zzdq -> 0x0229 }
            throw r0     // Catch:{ zzdq -> 0x0229 }
        L_0x0233:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r3 = "authData value has wrong type"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0015 }
            throw r2     // Catch:{ JSONException -> 0x0015 }
        L_0x023b:
            r0 = move-exception
            goto L_0x023e
        L_0x023d:
            r0 = move-exception
        L_0x023e:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r3 = "failed to parse attestation object"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0015 }
            throw r2     // Catch:{ JSONException -> 0x0015 }
        L_0x0246:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error encoding AuthenticatorAttestationResponse to JSON object"
            r2.<init>(r3, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse.zza():org.json.JSONObject");
    }
}
