package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzfd {
    private static final Logger logger = Logger.getLogger(zzfd.class.getName());
    private static final Class<?> zzfb = zzaw.zzy();
    private static final boolean zzfy = zzeg();
    private static final Unsafe zzmh;
    private static final boolean zzpg;
    private static final boolean zzph;
    private static final zzd zzpi;
    private static final boolean zzpj = zzeh();
    /* access modifiers changed from: private */
    public static final long zzpk = ((long) zzg(byte[].class));
    private static final long zzpl;
    private static final long zzpm;
    private static final long zzpn;
    private static final long zzpo;
    private static final long zzpp;
    private static final long zzpq;
    private static final long zzpr;
    private static final long zzps;
    private static final long zzpt;
    private static final long zzpu;
    private static final long zzpv;
    private static final long zzpw;
    private static final long zzpx = zzb(zzei());
    private static final long zzpy;
    /* access modifiers changed from: private */
    public static final boolean zzpz = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte((int) j, b);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfd.zzpz) {
                zzfd.zza(obj, j, b);
            } else {
                zzfd.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzr(obj, j) : zzfd.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzp(obj, j) : zzfd.zzq(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfd.zzpz) {
                zzfd.zzb(obj, j, z);
            } else {
                zzfd.zzc(obj, j, z);
            }
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) j2, bArr, (int) j, (int) j3);
        }
    }

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfd.zzpz) {
                zzfd.zza(obj, j, b);
            } else {
                zzfd.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzr(obj, j) : zzfd.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            return zzfd.zzpz ? zzfd.zzp(obj, j) : zzfd.zzq(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfd.zzpz) {
                zzfd.zzb(obj, j, z);
            } else {
                zzfd.zzc(obj, j, z);
            }
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            this.zzqa.putByte(j, b);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzqa.putByte(obj, j, b);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzqa.getBoolean(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return this.zzqa.getFloat(obj, j);
        }

        public final double zzn(Object obj, long j) {
            return this.zzqa.getDouble(obj, j);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzqa.getByte(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzqa.putDouble(obj, j, d);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzqa.putFloat(obj, j, f);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzqa.putBoolean(obj, j, z);
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzqa.copyMemory(bArr, zzfd.zzpk + j, (Object) null, j2, j3);
        }
    }

    public static abstract class zzd {
        Unsafe zzqa;

        public zzd(Unsafe unsafe) {
            this.zzqa = unsafe;
        }

        public final long zza(Field field) {
            return this.zzqa.objectFieldOffset(field);
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public abstract void zze(Object obj, long j, byte b);

        public final int zzj(Object obj, long j) {
            return this.zzqa.getInt(obj, j);
        }

        public final long zzk(Object obj, long j) {
            return this.zzqa.getLong(obj, j);
        }

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);

        public final void zza(Object obj, long j, int i) {
            this.zzqa.putInt(obj, j, i);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzqa.putLong(obj, j, j2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ec  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.clearcut.zzfd> r0 = com.google.android.gms.internal.clearcut.zzfd.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzef()
            zzmh = r0
            java.lang.Class r1 = com.google.android.gms.internal.clearcut.zzaw.zzy()
            zzfb = r1
            java.lang.Class r1 = java.lang.Long.TYPE
            boolean r1 = zzi(r1)
            zzpg = r1
            java.lang.Class r2 = java.lang.Integer.TYPE
            boolean r2 = zzi(r2)
            zzph = r2
            r3 = 0
            if (r0 != 0) goto L_0x002d
        L_0x002b:
            r1 = r3
            goto L_0x0048
        L_0x002d:
            boolean r4 = com.google.android.gms.internal.clearcut.zzaw.zzx()
            if (r4 == 0) goto L_0x0043
            if (r1 == 0) goto L_0x003b
            com.google.android.gms.internal.clearcut.zzfd$zzb r1 = new com.google.android.gms.internal.clearcut.zzfd$zzb
            r1.<init>(r0)
            goto L_0x0048
        L_0x003b:
            if (r2 == 0) goto L_0x002b
            com.google.android.gms.internal.clearcut.zzfd$zza r1 = new com.google.android.gms.internal.clearcut.zzfd$zza
            r1.<init>(r0)
            goto L_0x0048
        L_0x0043:
            com.google.android.gms.internal.clearcut.zzfd$zzc r1 = new com.google.android.gms.internal.clearcut.zzfd$zzc
            r1.<init>(r0)
        L_0x0048:
            zzpi = r1
            boolean r0 = zzeh()
            zzpj = r0
            boolean r0 = zzeg()
            zzfy = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzg(r0)
            long r0 = (long) r0
            zzpk = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpl = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpm = r0
            java.lang.Class<int[]> r0 = int[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpn = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpo = r0
            java.lang.Class<long[]> r0 = long[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpp = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpq = r0
            java.lang.Class<float[]> r0 = float[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpr = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzps = r0
            java.lang.Class<double[]> r0 = double[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpt = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpu = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpv = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpw = r0
            java.lang.reflect.Field r0 = zzei()
            long r0 = zzb((java.lang.reflect.Field) r0)
            zzpx = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "value"
            java.lang.reflect.Field r0 = zzb(r0, r1)
            if (r0 == 0) goto L_0x00dc
            java.lang.Class r1 = r0.getType()
            java.lang.Class<char[]> r2 = char[].class
            if (r1 != r2) goto L_0x00dc
            r3 = r0
        L_0x00dc:
            long r0 = zzb((java.lang.reflect.Field) r3)
            zzpy = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00ec
            r0 = 1
            goto L_0x00ed
        L_0x00ec:
            r0 = 0
        L_0x00ed:
            zzpz = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzfd.<clinit>():void");
    }

    private zzfd() {
    }

    public static byte zza(byte[] bArr, long j) {
        return zzpi.zzx(bArr, zzpk + j);
    }

    private static long zzb(Field field) {
        zzd zzd2;
        if (field == null || (zzd2 = zzpi) == null) {
            return -1;
        }
        return zzd2.zza(field);
    }

    public static boolean zzed() {
        return zzfy;
    }

    public static boolean zzee() {
        return zzpj;
    }

    public static Unsafe zzef() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfe());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzeg() {
        Class<Class> cls = Class.class;
        Class<Object> cls2 = Object.class;
        Unsafe unsafe = zzmh;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls3 = unsafe.getClass();
            cls3.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls3.getMethod("arrayBaseOffset", new Class[]{cls});
            cls3.getMethod("arrayIndexScale", new Class[]{cls});
            Class cls4 = Long.TYPE;
            cls3.getMethod("getInt", new Class[]{cls2, cls4});
            cls3.getMethod("putInt", new Class[]{cls2, cls4, Integer.TYPE});
            cls3.getMethod("getLong", new Class[]{cls2, cls4});
            cls3.getMethod("putLong", new Class[]{cls2, cls4, cls4});
            cls3.getMethod("getObject", new Class[]{cls2, cls4});
            cls3.getMethod("putObject", new Class[]{cls2, cls4, cls2});
            if (zzaw.zzx()) {
                return true;
            }
            cls3.getMethod("getByte", new Class[]{cls2, cls4});
            cls3.getMethod("putByte", new Class[]{cls2, cls4, Byte.TYPE});
            cls3.getMethod("getBoolean", new Class[]{cls2, cls4});
            cls3.getMethod("putBoolean", new Class[]{cls2, cls4, Boolean.TYPE});
            cls3.getMethod("getFloat", new Class[]{cls2, cls4});
            cls3.getMethod("putFloat", new Class[]{cls2, cls4, Float.TYPE});
            cls3.getMethod("getDouble", new Class[]{cls2, cls4});
            cls3.getMethod("putDouble", new Class[]{cls2, cls4, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb2.toString());
            return false;
        }
    }

    private static boolean zzeh() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzmh;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (zzei() == null) {
                return false;
            }
            if (zzaw.zzx()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls3});
            cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{cls3});
            cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls3});
            cls2.getMethod("putLong", new Class[]{cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb2.toString());
            return false;
        }
    }

    private static Field zzei() {
        Field zzb2;
        Class<Buffer> cls = Buffer.class;
        if (zzaw.zzx() && (zzb2 = zzb(cls, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(cls, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static int zzg(Class<?> cls) {
        if (zzfy) {
            return zzpi.zzqa.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzh(Class<?> cls) {
        if (zzfy) {
            return zzpi.zzqa.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzi(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzaw.zzx()) {
            return false;
        }
        try {
            Class<?> cls3 = zzfb;
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

    public static int zzj(Object obj, long j) {
        return zzpi.zzj(obj, j);
    }

    public static long zzk(Object obj, long j) {
        return zzpi.zzk(obj, j);
    }

    public static boolean zzl(Object obj, long j) {
        return zzpi.zzl(obj, j);
    }

    public static float zzm(Object obj, long j) {
        return zzpi.zzm(obj, j);
    }

    public static double zzn(Object obj, long j) {
        return zzpi.zzn(obj, j);
    }

    public static Object zzo(Object obj, long j) {
        return zzpi.zzqa.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    public static long zza(Field field) {
        return zzpi.zza(field);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        return zzpi.zzk(byteBuffer, zzpx);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    public static void zza(long j, byte b) {
        zzpi.zza(j, b);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzj = zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & (~(255 << i))));
    }

    public static void zza(Object obj, long j, double d) {
        zzpi.zza(obj, j, d);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    public static void zza(Object obj, long j, float f) {
        zzpi.zza(obj, j, f);
    }

    public static void zza(Object obj, long j, int i) {
        zzpi.zza(obj, j, i);
    }

    public static void zza(Object obj, long j, long j2) {
        zzpi.zza(obj, j, j2);
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzpi.zzqa.putObject(obj, j, obj2);
    }

    public static void zza(Object obj, long j, boolean z) {
        zzpi.zza(obj, j, z);
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzpi.zze(bArr, zzpk + j, b);
    }

    public static void zza(byte[] bArr, long j, long j2, long j3) {
        zzpi.zza(bArr, j, j2, j3);
    }
}
