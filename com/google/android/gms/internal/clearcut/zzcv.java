package com.google.android.gms.internal.clearcut;

public class zzcv {
    private static final zzbt zzez = zzbt.zzan();
    private zzbb zzln;
    private volatile zzdo zzlo;
    private volatile zzbb zzlp;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.clearcut.zzdo zzh(com.google.android.gms.internal.clearcut.zzdo r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.clearcut.zzdo r0 = r1.zzlo
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.clearcut.zzdo r0 = r1.zzlo     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x000d
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x000b }
            goto L_0x001d
        L_0x000b:
            r2 = move-exception
            goto L_0x001b
        L_0x000d:
            r1.zzlo = r2     // Catch:{ zzco -> 0x0014 }
            com.google.android.gms.internal.clearcut.zzbb r0 = com.google.android.gms.internal.clearcut.zzbb.zzfi     // Catch:{ zzco -> 0x0014 }
            r1.zzlp = r0     // Catch:{ zzco -> 0x0014 }
            goto L_0x0009
        L_0x0014:
            r1.zzlo = r2     // Catch:{ all -> 0x000b }
            com.google.android.gms.internal.clearcut.zzbb r2 = com.google.android.gms.internal.clearcut.zzbb.zzfi     // Catch:{ all -> 0x000b }
            r1.zzlp = r2     // Catch:{ all -> 0x000b }
            goto L_0x0009
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x000b }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.clearcut.zzdo r2 = r1.zzlo
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzcv.zzh(com.google.android.gms.internal.clearcut.zzdo):com.google.android.gms.internal.clearcut.zzdo");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcv)) {
            return false;
        }
        zzcv zzcv = (zzcv) obj;
        zzdo zzdo = this.zzlo;
        zzdo zzdo2 = zzcv.zzlo;
        return (zzdo == null && zzdo2 == null) ? zzr().equals(zzcv.zzr()) : (zzdo == null || zzdo2 == null) ? zzdo != null ? zzdo.equals(zzcv.zzh(zzdo.zzbe())) : zzh(zzdo2.zzbe()).equals(zzdo2) : zzdo.equals(zzdo2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zzas() {
        if (this.zzlp != null) {
            return this.zzlp.size();
        }
        if (this.zzlo != null) {
            return this.zzlo.zzas();
        }
        return 0;
    }

    public final zzdo zzi(zzdo zzdo) {
        zzdo zzdo2 = this.zzlo;
        this.zzln = null;
        this.zzlp = null;
        this.zzlo = zzdo;
        return zzdo2;
    }

    public final zzbb zzr() {
        if (this.zzlp != null) {
            return this.zzlp;
        }
        synchronized (this) {
            try {
                if (this.zzlp != null) {
                    zzbb zzbb = this.zzlp;
                    return zzbb;
                }
                this.zzlp = this.zzlo == null ? zzbb.zzfi : this.zzlo.zzr();
                zzbb zzbb2 = this.zzlp;
                return zzbb2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
