package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv  reason: invalid package */
public enum zzvv implements zzall {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    CURVE25519(5),
    UNRECOGNIZED(-1);
    
    private final int zzh;

    private zzvv(int i) {
        this.zzh = i;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("<");
        sb2.append(zzvv.class.getName());
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
            return this.zzh;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzvv zza(int i) {
        if (i == 0) {
            return UNKNOWN_CURVE;
        }
        if (i == 2) {
            return NIST_P256;
        }
        if (i == 3) {
            return NIST_P384;
        }
        if (i == 4) {
            return NIST_P521;
        }
        if (i != 5) {
            return null;
        }
        return CURVE25519;
    }
}
