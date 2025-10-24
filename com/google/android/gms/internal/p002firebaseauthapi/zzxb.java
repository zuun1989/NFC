package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxb  reason: invalid package */
public enum zzxb implements zzall {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    
    private final int zzg;

    private zzxb(int i) {
        this.zzg = i;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("<");
        sb2.append(zzxb.class.getName());
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

    public static zzxb zza(int i) {
        if (i == 0) {
            return UNKNOWN_STATUS;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i == 2) {
            return DISABLED;
        }
        if (i != 3) {
            return null;
        }
        return DESTROYED;
    }
}
