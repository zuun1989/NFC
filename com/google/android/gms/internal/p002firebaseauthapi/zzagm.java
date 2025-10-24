package com.google.android.gms.internal.p002firebaseauthapi;

import b6.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import w0.a;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagm  reason: invalid package */
public final class zzagm {
    private static final Map<String, zzagl> zza = new a();
    private static final Map<String, List<WeakReference<zzago>>> zzb = new a();

    private static String zza(String str, int i, boolean z) {
        if (z) {
            return "http://[" + str + "]:" + i + "/";
        }
        return "http://" + str + ":" + i + "/";
    }

    public static String zzb(String str) {
        zzagl zzagl;
        String str2;
        Map<String, zzagl> map = zza;
        synchronized (map) {
            zzagl = map.get(str);
        }
        if (zzagl != null) {
            str2 = "" + zza(zzagl.zzb(), zzagl.zza(), zzagl.zzb().contains(":"));
        } else {
            str2 = "" + "https://";
        }
        return str2 + "www.googleapis.com/identitytoolkit/v3/relyingparty";
    }

    public static String zzc(String str) {
        zzagl zzagl;
        String str2;
        Map<String, zzagl> map = zza;
        synchronized (map) {
            zzagl = map.get(str);
        }
        if (zzagl != null) {
            str2 = "" + zza(zzagl.zzb(), zzagl.zza(), zzagl.zzb().contains(":"));
        } else {
            str2 = "" + "https://";
        }
        return str2 + "identitytoolkit.googleapis.com/v2";
    }

    public static String zzd(String str) {
        zzagl zzagl;
        String str2;
        Map<String, zzagl> map = zza;
        synchronized (map) {
            zzagl = map.get(str);
        }
        if (zzagl != null) {
            str2 = "" + zza(zzagl.zzb(), zzagl.zza(), zzagl.zzb().contains(":"));
        } else {
            str2 = "" + "https://";
        }
        return str2 + "securetoken.googleapis.com/v1";
    }

    public static String zza(String str) {
        zzagl zzagl;
        Map<String, zzagl> map = zza;
        synchronized (map) {
            zzagl = map.get(str);
        }
        if (zzagl != null) {
            String zza2 = zza(zzagl.zzb(), zzagl.zza(), zzagl.zzb().contains(":"));
            return zza2 + "emulator/auth/handler";
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    public static void zza(String str, zzago zzago) {
        Map<String, List<WeakReference<zzago>>> map = zzb;
        synchronized (map) {
            try {
                if (map.containsKey(str)) {
                    map.get(str).add(new WeakReference(zzago));
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new WeakReference(zzago));
                    map.put(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zza(g gVar, String str, int i) {
        String b = gVar.r().b();
        Map<String, zzagl> map = zza;
        synchronized (map) {
            map.put(b, new zzagl(str, i));
        }
        Map<String, List<WeakReference<zzago>>> map2 = zzb;
        synchronized (map2) {
            try {
                if (map2.containsKey(b)) {
                    boolean z = false;
                    for (WeakReference weakReference : map2.get(b)) {
                        zzago zzago = (zzago) weakReference.get();
                        if (zzago != null) {
                            zzago.zza();
                            z = true;
                        }
                    }
                    if (!z) {
                        zza.remove(b);
                    }
                }
            } finally {
            }
        }
    }

    public static boolean zza(g gVar) {
        return zza.containsKey(gVar.r().b());
    }
}
