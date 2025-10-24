package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwm  reason: invalid package */
public enum zzwm implements zzall {
    KDF_UNKNOWN(0),
    HKDF_SHA256(1),
    HKDF_SHA384(2),
    HKDF_SHA512(3),
    UNRECOGNIZED(-1);
    
    private final int zzg;

    private zzwm(int i) {
        this.zzg = i;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("<");
        sb2.append(zzwm.class.getName());
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb2.append(" number=");
            sb2.append(zza());
        }
        sb2.append(" name=");
        sb2.append(name());
        sb2.append('>');
        return sb2.toString();
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzg;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzwm zza(int i) {
        if (i == 0) {
            return KDF_UNKNOWN;
        }
        if (i == 1) {
            return HKDF_SHA256;
        }
        if (i == 2) {
            return HKDF_SHA384;
        }
        if (i != 3) {
            return null;
        }
        return HKDF_SHA512;
    }
}
