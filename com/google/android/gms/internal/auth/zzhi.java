package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

final class zzhi {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc = zzdr.zza();
    private static final boolean zzd;
    private static final zzhh zze;
    private static final boolean zzf;
    private static final boolean zzg;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0114  */
    static {
        /*
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            sun.misc.Unsafe r1 = zzg()
            zzb = r1
            java.lang.Class r2 = com.google.android.gms.internal.auth.zzdr.zza()
            zzc = r2
            java.lang.Class r2 = java.lang.Long.TYPE
            boolean r3 = zzs(r2)
            zzd = r3
            java.lang.Class r4 = java.lang.Integer.TYPE
            boolean r4 = zzs(r4)
            r5 = 0
            if (r1 != 0) goto L_0x0020
            goto L_0x002f
        L_0x0020:
            if (r3 == 0) goto L_0x0028
            com.google.android.gms.internal.auth.zzhg r5 = new com.google.android.gms.internal.auth.zzhg
            r5.<init>(r1)
            goto L_0x002f
        L_0x0028:
            if (r4 == 0) goto L_0x002f
            com.google.android.gms.internal.auth.zzhf r5 = new com.google.android.gms.internal.auth.zzhf
            r5.<init>(r1)
        L_0x002f:
            zze = r5
            java.lang.String r1 = "getLong"
            java.lang.String r3 = "objectFieldOffset"
            java.lang.Class<java.lang.reflect.Field> r4 = java.lang.reflect.Field.class
            r6 = 1
            r7 = 0
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            if (r5 != 0) goto L_0x003f
        L_0x003d:
            r2 = r7
            goto L_0x0061
        L_0x003f:
            sun.misc.Unsafe r5 = r5.zza
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x005c }
            java.lang.Class[] r9 = new java.lang.Class[]{r4}     // Catch:{ all -> 0x005c }
            r5.getMethod(r3, r9)     // Catch:{ all -> 0x005c }
            java.lang.Class[] r2 = new java.lang.Class[]{r8, r2}     // Catch:{ all -> 0x005c }
            r5.getMethod(r1, r2)     // Catch:{ all -> 0x005c }
            java.lang.reflect.Field r2 = zzy()     // Catch:{ all -> 0x005c }
            if (r2 != 0) goto L_0x005a
            goto L_0x003d
        L_0x005a:
            r2 = r6
            goto L_0x0061
        L_0x005c:
            r2 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.zzhi.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r2.toString()))
            goto L_0x003d
        L_0x0061:
            zzf = r2
            com.google.android.gms.internal.auth.zzhh r2 = zze
            if (r2 != 0) goto L_0x0069
        L_0x0067:
            r0 = r7
            goto L_0x00c7
        L_0x0069:
            sun.misc.Unsafe r2 = r2.zza
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r4 = new java.lang.Class[]{r4}     // Catch:{ all -> 0x00c2 }
            r2.getMethod(r3, r4)     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r3 = new java.lang.Class[]{r0}     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = "arrayBaseOffset"
            r2.getMethod(r4, r3)     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r0 = new java.lang.Class[]{r0}     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = "arrayIndexScale"
            r2.getMethod(r3, r0)     // Catch:{ all -> 0x00c2 }
            java.lang.Class r0 = java.lang.Long.TYPE     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r3 = new java.lang.Class[]{r8, r0}     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = "getInt"
            r2.getMethod(r4, r3)     // Catch:{ all -> 0x00c2 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r3 = new java.lang.Class[]{r8, r0, r3}     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = "putInt"
            r2.getMethod(r4, r3)     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r3 = new java.lang.Class[]{r8, r0}     // Catch:{ all -> 0x00c2 }
            r2.getMethod(r1, r3)     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r1 = new java.lang.Class[]{r8, r0, r0}     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = "putLong"
            r2.getMethod(r3, r1)     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r1 = new java.lang.Class[]{r8, r0}     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = "getObject"
            r2.getMethod(r3, r1)     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r0 = new java.lang.Class[]{r8, r0, r8}     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = "putObject"
            r2.getMethod(r1, r0)     // Catch:{ all -> 0x00c2 }
            r0 = r6
            goto L_0x00c7
        L_0x00c2:
            r0 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.zzhi.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x0067
        L_0x00c7:
            zzg = r0
            java.lang.Class<byte[]> r0 = byte[].class
            zzw(r0)
            java.lang.Class<boolean[]> r0 = boolean[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<int[]> r0 = int[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<long[]> r0 = long[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<float[]> r0 = float[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<double[]> r0 = double[].class
            zzw(r0)
            zzx(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzw(r0)
            zzx(r0)
            java.lang.reflect.Field r0 = zzy()
            if (r0 == 0) goto L_0x010b
            com.google.android.gms.internal.auth.zzhh r1 = zze
            if (r1 == 0) goto L_0x010b
            r1.zzk(r0)
        L_0x010b:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r6 = r7
        L_0x0115:
            zza = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzhi.<clinit>():void");
    }

    private zzhi() {
    }

    public static double zza(Object obj, long j) {
        return zze.zza(obj, j);
    }

    public static float zzb(Object obj, long j) {
        return zze.zzb(obj, j);
    }

    public static int zzc(Object obj, long j) {
        return zze.zzi(obj, j);
    }

    public static long zzd(Object obj, long j) {
        return zze.zzj(obj, j);
    }

    public static Object zze(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zzf(Object obj, long j) {
        return zze.zzl(obj, j);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhe());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        long j2 = -4 & j;
        zzhh zzhh = zze;
        int zzi = zzhh.zzi(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzhh.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzi));
    }

    public static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        long j2 = -4 & j;
        zzhh zzhh = zze;
        int zzi = zzhh.zzi(obj, j2);
        int i = (((int) j) & 3) << 3;
        zzhh.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzi));
    }

    public static void zzk(Object obj, long j, boolean z) {
        zze.zzc(obj, j, z);
    }

    public static void zzl(Object obj, long j, double d) {
        zze.zzd(obj, j, d);
    }

    public static void zzm(Object obj, long j, float f) {
        zze.zze(obj, j, f);
    }

    public static void zzn(Object obj, long j, int i) {
        zze.zzm(obj, j, i);
    }

    public static void zzo(Object obj, long j, long j2) {
        zze.zzn(obj, j, j2);
    }

    public static void zzp(Object obj, long j, Object obj2) {
        zze.zzo(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzq(Object obj, long j) {
        if (((byte) ((zze.zzi(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ boolean zzr(Object obj, long j) {
        if (((byte) ((zze.zzi(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static boolean zzs(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzdr.zza;
        try {
            Class cls3 = zzc;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzt(Object obj, long j) {
        return zze.zzf(obj, j);
    }

    public static boolean zzu() {
        return zzg;
    }

    public static boolean zzv() {
        return zzf;
    }

    private static int zzw(Class cls) {
        if (zzg) {
            return zze.zzg(cls);
        }
        return -1;
    }

    private static int zzx(Class cls) {
        if (zzg) {
            return zze.zzh(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i = zzdr.zza;
        Class<Buffer> cls = Buffer.class;
        Field zzz = zzz(cls, "effectiveDirectAddress");
        if (zzz != null) {
            return zzz;
        }
        Field zzz2 = zzz(cls, "address");
        if (zzz2 == null || zzz2.getType() != Long.TYPE) {
            return null;
        }
        return zzz2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
