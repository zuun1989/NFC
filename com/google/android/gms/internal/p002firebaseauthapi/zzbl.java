package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxk;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbl  reason: invalid package */
public final class zzbl implements zzoa {
    private final List<zzbr> zza;
    private final zzoj zzb;
    private final zzbl zzc;

    private final zzbl zze() {
        zzbl zzbl = this.zzc;
        if (zzbl == null) {
            return this;
        }
        return zzbl;
    }

    public final String toString() {
        return zzcl.zza(zzd()).toString();
    }

    public final /* synthetic */ zzod zzc() {
        for (zzbr next : this.zza) {
            if (next != null && next.zze()) {
                if (next.zzc() == zzbj.zza) {
                    return next;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no valid primary");
    }

    public final zzxk zzd() {
        try {
            zzxk.zzb zzc2 = zzxk.zzc();
            for (zzbr next : this.zza) {
                zzc2.zza(zzb(next.zzb(), next.zzc, next.zza()));
                if (next.zze()) {
                    zzc2.zza(next.zza());
                }
            }
            return (zzxk) ((zzalg) zzc2.zze());
        } catch (GeneralSecurityException e) {
            throw new zzqo((Throwable) e);
        }
    }

    private zzbl(zzxk zzxk, List<zzbr> list, zzoj zzoj) throws GeneralSecurityException {
        this.zza = list;
        this.zzb = zzoj;
        if (zzit.zza.zza()) {
            HashSet hashSet = new HashSet();
            for (zzxk.zza next : zzxk.zze()) {
                if (!hashSet.contains(Integer.valueOf(next.zza()))) {
                    hashSet.add(Integer.valueOf(next.zza()));
                } else {
                    int zza2 = next.zza();
                    throw new GeneralSecurityException("KeyID " + zza2 + " is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
                }
            }
            if (!hashSet.contains(Integer.valueOf(zzxk.zzb()))) {
                throw new GeneralSecurityException("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
            }
        }
        this.zzc = null;
    }

    /* access modifiers changed from: private */
    public static zzbl zzb(zzbl zzbl) {
        zzoj zzoj = zzbl.zzb;
        if (zzoj.zza()) {
            return zzbl;
        }
        zzbo zzbo = new zzbo(zzbl, zzoj);
        ArrayList arrayList = new ArrayList(zzbl.zza.size());
        for (zzbr next : zzbl.zza) {
            arrayList.add(new zzbr(next.zzb, next.zzc, next.zze, next.zzf, next.zzg, zzbo));
        }
        return new zzbl((List<zzbr>) arrayList, zzoj, zzbl);
    }

    public final int zza() {
        return this.zza.size();
    }

    private static zzbh zza(zzxk.zza zza2) throws GeneralSecurityException {
        zzqe zzb2 = zzb(zza2);
        zzpc zza3 = zzpc.zza();
        zzck zza4 = zzck.zza();
        if (!zza3.zzb(zzb2)) {
            return new zzoe(zzb2, zza4);
        }
        return zza3.zza(zzb2, zza4);
    }

    private static List<zzbr> zzc(zzxk zzxk) throws GeneralSecurityException {
        boolean z;
        zzbh zzbh;
        ArrayList arrayList = new ArrayList(zzxk.zza());
        for (zzxk.zza next : zzxk.zze()) {
            int zza2 = next.zza();
            try {
                zzbh = zza(next);
                z = false;
            } catch (GeneralSecurityException e) {
                if (!zzit.zza.zza()) {
                    zzbh = new zzoe(zzb(next), zzck.zza());
                    z = true;
                } else {
                    throw e;
                }
            }
            if (!zzit.zza.zza() || zza(next.zzc())) {
                arrayList.add(new zzbr(zzbh, next.zzc(), zza2, zza2 == zzxk.zzb(), z, zzbr.zza));
            } else {
                throw new GeneralSecurityException("Parsing of a single key failed (wrong status) and Tink is configured via validateKeysetsOnParsing to reject such keysets.");
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    public static void zzd(zzxk zzxk) throws GeneralSecurityException {
        if (zzxk == null || zzxk.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: com.google.android.gms.internal.firebase-auth-api.zzoe} */
    /* JADX WARNING: type inference failed for: r0v17, types: [com.google.android.gms.internal.firebase-auth-api.zzalg] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzbl zzb() throws java.security.GeneralSecurityException {
        /*
            r21 = this;
            r1 = r21
            com.google.android.gms.internal.firebase-auth-api.zzxk r2 = r21.zzd()
            com.google.android.gms.internal.firebase-auth-api.zzxk$zzb r3 = com.google.android.gms.internal.p002firebaseauthapi.zzxk.zzc()
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.List<com.google.android.gms.internal.firebase-auth-api.zzbr> r0 = r1.zza
            int r0 = r0.size()
            r4.<init>(r0)
            java.util.List<com.google.android.gms.internal.firebase-auth-api.zzbr> r0 = r1.zza
            java.util.Iterator r5 = r0.iterator()
            r6 = 0
            r7 = r6
        L_0x001d:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00ee
            java.lang.Object r0 = r5.next()
            r8 = r0
            com.google.android.gms.internal.firebase-auth-api.zzbr r8 = (com.google.android.gms.internal.p002firebaseauthapi.zzbr) r8
            com.google.android.gms.internal.firebase-auth-api.zzbh r0 = r8.zzb()
            boolean r0 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzcd
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.internal.firebase-auth-api.zzbh r0 = r8.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzcd r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzcd) r0
            com.google.android.gms.internal.firebase-auth-api.zzbh r0 = r0.zzc()
            com.google.android.gms.internal.firebase-auth-api.zzbr r17 = new com.google.android.gms.internal.firebase-auth-api.zzbr
            com.google.android.gms.internal.firebase-auth-api.zzxb r11 = r8.zzc
            int r12 = r8.zza()
            boolean r13 = r8.zze()
            com.google.android.gms.internal.firebase-auth-api.zzbt r15 = com.google.android.gms.internal.p002firebaseauthapi.zzbr.zza
            r16 = 0
            r14 = 0
            r9 = r17
            r10 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15)
            com.google.android.gms.internal.firebase-auth-api.zzxb r9 = r8.zzc
            int r8 = r8.zza()
            com.google.android.gms.internal.firebase-auth-api.zzxk$zza r0 = zzb(r0, r9, r8)
            r11 = r17
            goto L_0x00db
        L_0x0067:
            com.google.android.gms.internal.firebase-auth-api.zzxk$zza r0 = r2.zza(r7)
            com.google.android.gms.internal.firebase-auth-api.zzxa r9 = r0.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzxa$zza r10 = r9.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzxa$zza r11 = com.google.android.gms.internal.p002firebaseauthapi.zzxa.zza.ASYMMETRIC_PRIVATE
            if (r10 != r11) goto L_0x00e6
            java.lang.String r10 = r9.zzf()
            com.google.android.gms.internal.firebase-auth-api.zzajw r9 = r9.zze()
            com.google.android.gms.internal.firebase-auth-api.zzxa r9 = com.google.android.gms.internal.p002firebaseauthapi.zzch.zza(r10, r9)
            com.google.android.gms.internal.firebase-auth-api.zzalg$zzb r0 = r0.zzn()
            com.google.android.gms.internal.firebase-auth-api.zzxk$zza$zza r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzxk.zza.C0017zza) r0
            com.google.android.gms.internal.firebase-auth-api.zzxk$zza$zza r0 = r0.zza((com.google.android.gms.internal.p002firebaseauthapi.zzxa) r9)
            com.google.android.gms.internal.firebase-auth-api.zzamn r0 = r0.zze()
            com.google.android.gms.internal.firebase-auth-api.zzalg r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalg) r0
            r9 = r0
            com.google.android.gms.internal.firebase-auth-api.zzxk$zza r9 = (com.google.android.gms.internal.p002firebaseauthapi.zzxk.zza) r9
            r10 = 1
            com.google.android.gms.internal.firebase-auth-api.zzbh r0 = zza((com.google.android.gms.internal.p002firebaseauthapi.zzxk.zza) r9)     // Catch:{ GeneralSecurityException -> 0x009f }
            r14 = r0
            r18 = r6
            goto L_0x00b9
        L_0x009f:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.internal.firebase-auth-api.zziv r0 = com.google.android.gms.internal.p002firebaseauthapi.zzit.zza
            boolean r0 = r0.zza()
            if (r0 != 0) goto L_0x00e5
            com.google.android.gms.internal.firebase-auth-api.zzoe r0 = new com.google.android.gms.internal.firebase-auth-api.zzoe
            com.google.android.gms.internal.firebase-auth-api.zzqe r11 = zzb((com.google.android.gms.internal.p002firebaseauthapi.zzxk.zza) r9)
            com.google.android.gms.internal.firebase-auth-api.zzck r12 = com.google.android.gms.internal.p002firebaseauthapi.zzck.zza()
            r0.<init>(r11, r12)
            r14 = r0
            r18 = r10
        L_0x00b9:
            int r0 = r9.zza()
            com.google.android.gms.internal.firebase-auth-api.zzbr r11 = new com.google.android.gms.internal.firebase-auth-api.zzbr
            com.google.android.gms.internal.firebase-auth-api.zzxb r15 = r8.zzc
            int r8 = r2.zzb()
            if (r0 != r8) goto L_0x00cc
            r17 = r10
            goto L_0x00ce
        L_0x00cc:
            r17 = r6
        L_0x00ce:
            com.google.android.gms.internal.firebase-auth-api.zzbt r19 = com.google.android.gms.internal.p002firebaseauthapi.zzbr.zza
            r20 = 0
            r13 = r11
            r16 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19)
            r0 = r9
        L_0x00db:
            r3.zza((com.google.android.gms.internal.p002firebaseauthapi.zzxk.zza) r0)
            r4.add(r11)
            int r7 = r7 + 1
            goto L_0x001d
        L_0x00e5:
            throw r11
        L_0x00e6:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r2 = "The keyset contains a non-private key"
            r0.<init>(r2)
            throw r0
        L_0x00ee:
            int r0 = r2.zzb()
            r3.zza((int) r0)
            com.google.android.gms.internal.firebase-auth-api.zzbl r0 = new com.google.android.gms.internal.firebase-auth-api.zzbl
            com.google.android.gms.internal.firebase-auth-api.zzamn r2 = r3.zze()
            com.google.android.gms.internal.firebase-auth-api.zzalg r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzalg) r2
            com.google.android.gms.internal.firebase-auth-api.zzxk r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzxk) r2
            com.google.android.gms.internal.firebase-auth-api.zzoj r3 = r1.zzb
            r0.<init>((com.google.android.gms.internal.p002firebaseauthapi.zzxk) r2, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzbr>) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzoj) r3)
            com.google.android.gms.internal.firebase-auth-api.zzbl r0 = zzb((com.google.android.gms.internal.p002firebaseauthapi.zzbl) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbl.zzb():com.google.android.gms.internal.firebase-auth-api.zzbl");
    }

    public static final zzbl zza(zzxk zzxk) throws GeneralSecurityException {
        zzd(zzxk);
        return new zzbl(zzxk, zzc(zzxk), zzoj.zza);
    }

    public static final zzbl zza(zzbm zzbm) throws GeneralSecurityException {
        return new zzbq().zza(new zzbp(zzbm.zza()).zzb().zza()).zza();
    }

    private zzbl(List<zzbr> list, zzoj zzoj, zzbl zzbl) {
        this.zza = list;
        this.zzb = zzoj;
        this.zzc = zzbl;
    }

    @Deprecated
    public static final zzbl zza(zzby zzby, zzaz zzaz, byte[] bArr) throws GeneralSecurityException, IOException {
        zzvy zza2 = zzby.zza();
        if (zza2 != null && zza2.zzc().zzb() != 0) {
            return zza(zza(zza2, zzaz, bArr));
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final /* synthetic */ zzod zza(int i) {
        if (i < 0 || i >= zza()) {
            int zza2 = zza();
            throw new IndexOutOfBoundsException("Invalid index " + i + " for keyset of size " + zza2);
        }
        zzbr zzbr = this.zza.get(i);
        if (!zza(zzbr.zzc)) {
            throw new IllegalStateException("Keyset-Entry at position " + i + " has wrong status");
        } else if (!zzbr.zzg) {
            return this.zza.get(i);
        } else {
            throw new IllegalStateException("Keyset-Entry at position " + i + " didn't parse correctly");
        }
    }

    public static /* synthetic */ zzxb zza(zzbj zzbj) {
        if (zzbj.zza.equals(zzbj)) {
            return zzxb.ENABLED;
        }
        if (zzbj.zzb.equals(zzbj)) {
            return zzxb.DISABLED;
        }
        if (zzbj.zzc.equals(zzbj)) {
            return zzxb.DESTROYED;
        }
        throw new IllegalStateException("Unknown key status");
    }

    private static zzxk zza(zzvy zzvy, zzaz zzaz, byte[] bArr) throws GeneralSecurityException {
        try {
            zzxk zza2 = zzxk.zza(zzaz.zza(zzvy.zzc().zzd(), bArr), zzakv.zza());
            zzd(zza2);
            return zza2;
        } catch (zzalm unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static zzqe zzb(zzxk.zza zza2) throws GeneralSecurityException {
        return zzqe.zza(zza2.zzb().zzf(), zza2.zzb().zze(), zza2.zzb().zzb(), zza2.zzf(), zza2.zzf() == zzyc.RAW ? null : Integer.valueOf(zza2.zza()));
    }

    public final <P> P zza(zzbe zzbe, Class<P> cls) throws GeneralSecurityException {
        if (zzbe instanceof zzno) {
            zzno zzno = (zzno) zzbe;
            zzxk zzd = zze().zzd();
            zzcl.zzb(zzd);
            for (int i = 0; i < zza(); i++) {
                if (this.zza.get(i).zzg || !zza(this.zza.get(i).zzc)) {
                    String zzf = zzd.zza(i).zzb().zzf();
                    throw new GeneralSecurityException("Key parsing of key with index " + i + " and type_url " + zzf + " failed, unable to get primitive");
                }
            }
            return zzno.zza(zze(), this.zzb, cls);
        }
        throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
    }

    /* access modifiers changed from: private */
    public static zzxk.zza zzb(zzbh zzbh, zzxb zzxb, int i) throws GeneralSecurityException {
        zzqe zzqe = (zzqe) zzpc.zza().zza(zzbh, zzqe.class, zzck.zza());
        Integer zze = zzqe.zze();
        if (zze == null || zze.intValue() == i) {
            return (zzxk.zza) ((zzalg) zzxk.zza.zzd().zza(zzxa.zza().zza(zzqe.zzf()).zza(zzqe.zzd()).zza(zzqe.zza())).zza(zzxb).zza(i).zza(zzqe.zzc()).zze());
        }
        throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0012  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.p002firebaseauthapi.zzbx r6) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r5 = this;
            com.google.android.gms.internal.firebase-auth-api.zzxk r0 = r5.zzd()
            java.util.List r1 = r0.zze()
            java.util.Iterator r1 = r1.iterator()
        L_0x000c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0061
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.firebase-auth-api.zzxk$zza r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzxk.zza) r2
            com.google.android.gms.internal.firebase-auth-api.zzxa r3 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzxa$zza r3 = r3.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzxa$zza r4 = com.google.android.gms.internal.p002firebaseauthapi.zzxa.zza.UNKNOWN_KEYMATERIAL
            if (r3 == r4) goto L_0x003d
            com.google.android.gms.internal.firebase-auth-api.zzxa r3 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzxa$zza r3 = r3.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzxa$zza r4 = com.google.android.gms.internal.p002firebaseauthapi.zzxa.zza.SYMMETRIC
            if (r3 == r4) goto L_0x003d
            com.google.android.gms.internal.firebase-auth-api.zzxa r3 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzxa$zza r3 = r3.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzxa$zza r4 = com.google.android.gms.internal.p002firebaseauthapi.zzxa.zza.ASYMMETRIC_PRIVATE
            if (r3 == r4) goto L_0x003d
            goto L_0x000c
        L_0x003d:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException
            com.google.android.gms.internal.firebase-auth-api.zzxa r0 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzxa$zza r0 = r0.zzb()
            java.lang.String r0 = r0.name()
            com.google.android.gms.internal.firebase-auth-api.zzxa r1 = r2.zzb()
            java.lang.String r1 = r1.zzf()
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1}
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r6.<init>(r0)
            throw r6
        L_0x0061:
            r6.zza((com.google.android.gms.internal.p002firebaseauthapi.zzxk) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbl.zza(com.google.android.gms.internal.firebase-auth-api.zzbx):void");
    }

    @Deprecated
    public final void zza(zzbx zzbx, zzaz zzaz, byte[] bArr) throws GeneralSecurityException, IOException {
        zzxk zzd = zzd();
        zzbx.zza((zzvy) ((zzalg) zzvy.zza().zza(zzajw.zza(zzaz.zzb(zzd.zzk(), bArr))).zza(zzcl.zza(zzd)).zze()));
    }

    private static boolean zza(zzxb zzxb) {
        int i = zzbn.zza[zzxb.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
