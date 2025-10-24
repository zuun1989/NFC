package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzy {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzcq = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzcr = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzcs = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    /* access modifiers changed from: private */
    public static final AtomicBoolean zzct = new AtomicBoolean();
    private static HashMap<String, String> zzcu;
    private static final HashMap<String, Boolean> zzcv = new HashMap<>();
    private static final HashMap<String, Integer> zzcw = new HashMap<>();
    private static final HashMap<String, Long> zzcx = new HashMap<>();
    private static final HashMap<String, Float> zzcy = new HashMap<>();
    private static Object zzcz;
    private static boolean zzda;
    private static String[] zzdb = new String[0];

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        Object zzb = zzb(contentResolver);
        long j2 = 0;
        Long l = (Long) zza(zzcx, str, 0L);
        if (l != null) {
            return l.longValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null) {
            try {
                long parseLong = Long.parseLong(zza);
                l = Long.valueOf(parseLong);
                j2 = parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        zza(zzb, zzcx, str, l);
        return j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T zza(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.clearcut.zzy> r0 = com.google.android.gms.internal.clearcut.zzy.class
            monitor-enter(r0)
            boolean r1 = r2.containsKey(r3)     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0014
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0012 }
            if (r2 == 0) goto L_0x0010
            r4 = r2
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return r4
        L_0x0012:
            r2 = move-exception
            goto L_0x0017
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            r2 = 0
            return r2
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzy.zza(java.util.HashMap, java.lang.String, java.lang.Object):java.lang.Object");
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzy.class) {
            zza(contentResolver);
            obj = zzcz;
        }
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
        r12 = r12.query(CONTENT_URI, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r13}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r12 == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
        if (r12.moveToFirst() != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
        r14 = r12.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
        if (r14 == null) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        if (r14.equals((java.lang.Object) null) == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0087, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0089, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008b, code lost:
        zza(r0, r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (r14 == null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0090, code lost:
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0091, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0094, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        zza(r0, r13, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0098, code lost:
        if (r12 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009a, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009e, code lost:
        if (r12 != null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a0, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a3, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r12, java.lang.String r13, java.lang.String r14) {
        /*
            java.lang.Class<com.google.android.gms.internal.clearcut.zzy> r14 = com.google.android.gms.internal.clearcut.zzy.class
            monitor-enter(r14)
            zza(r12)     // Catch:{ all -> 0x001e }
            java.lang.Object r0 = zzcz     // Catch:{ all -> 0x001e }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = zzcu     // Catch:{ all -> 0x001e }
            boolean r1 = r1.containsKey(r13)     // Catch:{ all -> 0x001e }
            r2 = 0
            if (r1 == 0) goto L_0x0021
            java.util.HashMap<java.lang.String, java.lang.String> r12 = zzcu     // Catch:{ all -> 0x001e }
            java.lang.Object r12 = r12.get(r13)     // Catch:{ all -> 0x001e }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x001e }
            if (r12 == 0) goto L_0x001c
            r2 = r12
        L_0x001c:
            monitor-exit(r14)     // Catch:{ all -> 0x001e }
            return r2
        L_0x001e:
            r12 = move-exception
            goto L_0x00a4
        L_0x0021:
            java.lang.String[] r1 = zzdb     // Catch:{ all -> 0x001e }
            int r3 = r1.length     // Catch:{ all -> 0x001e }
            r4 = 0
        L_0x0025:
            r5 = 1
            if (r4 >= r3) goto L_0x0063
            r6 = r1[r4]     // Catch:{ all -> 0x001e }
            boolean r6 = r13.startsWith(r6)     // Catch:{ all -> 0x001e }
            if (r6 == 0) goto L_0x0060
            boolean r0 = zzda     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x003c
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzcu     // Catch:{ all -> 0x001e }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x005e
        L_0x003c:
            java.lang.String[] r0 = zzdb     // Catch:{ all -> 0x001e }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = zzcu     // Catch:{ all -> 0x001e }
            java.util.Map r12 = zza(r12, r0)     // Catch:{ all -> 0x001e }
            r1.putAll(r12)     // Catch:{ all -> 0x001e }
            zzda = r5     // Catch:{ all -> 0x001e }
            java.util.HashMap<java.lang.String, java.lang.String> r12 = zzcu     // Catch:{ all -> 0x001e }
            boolean r12 = r12.containsKey(r13)     // Catch:{ all -> 0x001e }
            if (r12 == 0) goto L_0x005e
            java.util.HashMap<java.lang.String, java.lang.String> r12 = zzcu     // Catch:{ all -> 0x001e }
            java.lang.Object r12 = r12.get(r13)     // Catch:{ all -> 0x001e }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x001e }
            if (r12 == 0) goto L_0x005c
            r2 = r12
        L_0x005c:
            monitor-exit(r14)     // Catch:{ all -> 0x001e }
            return r2
        L_0x005e:
            monitor-exit(r14)     // Catch:{ all -> 0x001e }
            return r2
        L_0x0060:
            int r4 = r4 + 1
            goto L_0x0025
        L_0x0063:
            monitor-exit(r14)     // Catch:{ all -> 0x001e }
            android.net.Uri r7 = CONTENT_URI
            java.lang.String[] r10 = new java.lang.String[]{r13}
            r11 = 0
            r8 = 0
            r9 = 0
            r6 = r12
            android.database.Cursor r12 = r6.query(r7, r8, r9, r10, r11)
            if (r12 == 0) goto L_0x0095
            boolean r14 = r12.moveToFirst()     // Catch:{ all -> 0x0089 }
            if (r14 != 0) goto L_0x007b
            goto L_0x0095
        L_0x007b:
            java.lang.String r14 = r12.getString(r5)     // Catch:{ all -> 0x0089 }
            if (r14 == 0) goto L_0x008b
            boolean r1 = r14.equals(r2)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x008b
            r14 = r2
            goto L_0x008b
        L_0x0089:
            r13 = move-exception
            goto L_0x009e
        L_0x008b:
            zza((java.lang.Object) r0, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ all -> 0x0089 }
            if (r14 == 0) goto L_0x0091
            r2 = r14
        L_0x0091:
            r12.close()
            return r2
        L_0x0095:
            zza((java.lang.Object) r0, (java.lang.String) r13, (java.lang.String) r2)     // Catch:{ all -> 0x0089 }
            if (r12 == 0) goto L_0x009d
            r12.close()
        L_0x009d:
            return r2
        L_0x009e:
            if (r12 == 0) goto L_0x00a3
            r12.close()
        L_0x00a3:
            throw r13
        L_0x00a4:
            monitor-exit(r14)     // Catch:{ all -> 0x001e }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzy.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzcq, (String[]) null, (String) null, strArr, (String) null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzcu == null) {
            zzct.set(false);
            zzcu = new HashMap<>();
            zzcz = new Object();
            zzda = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzz((Handler) null));
        } else if (zzct.getAndSet(false)) {
            zzcu.clear();
            zzcv.clear();
            zzcw.clear();
            zzcx.clear();
            zzcy.clear();
            zzcz = new Object();
            zzda = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzy.class) {
            try {
                if (obj == zzcz) {
                    zzcu.put(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzy.class) {
            try {
                if (obj == zzcz) {
                    hashMap.put(str, t);
                    zzcu.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        HashMap<String, Boolean> hashMap = zzcv;
        Boolean bool = (Boolean) zza(hashMap, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String zza = zza(contentResolver, str, (String) null);
        if (zza != null && !zza.equals("")) {
            if (zzcr.matcher(zza).matches()) {
                bool = Boolean.TRUE;
                z = true;
            } else if (zzcs.matcher(zza).matches()) {
                bool = Boolean.FALSE;
                z = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + zza + "\") as boolean");
            }
        }
        zza(zzb, hashMap, str, bool);
        return z;
    }
}
