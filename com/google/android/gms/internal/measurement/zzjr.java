package com.google.android.gms.internal.measurement;

import G5.o;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import w0.a;

public final class zzjr implements zzjv {
    public static final String[] zza = {"key", "value"};
    private static final ConcurrentMap zzb = new ConcurrentHashMap();
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private ContentObserver zzf = null;
    private volatile boolean zzg = true;
    private final Object zzh = new Object();
    private volatile Map zzi;
    private final List zzj = new ArrayList();

    private zzjr(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        o.o(contentResolver);
        o.o(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
    }

    public static zzjr zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzjr zzjr = (zzjr) zzb.computeIfAbsent(uri, new zzjq(contentResolver, uri, runnable));
        try {
            if (zzjr.zzg) {
                synchronized (zzjr) {
                    if (zzjr.zzg) {
                        zzjo zzjo = new zzjo(zzjr, (Handler) null);
                        zzjr.zzc.registerContentObserver(zzjr.zzd, false, zzjo);
                        zzjr.zzf = zzjo;
                        zzjr.zzg = false;
                    }
                }
            }
            return zzjr;
        } catch (SecurityException unused) {
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void zzd() {
        Iterator it = zzb.values().iterator();
        while (it.hasNext()) {
            zzjr zzjr = (zzjr) it.next();
            synchronized (zzjr) {
                try {
                    if (zzjr.zzg) {
                        zzjr.zzg = false;
                    } else {
                        ContentObserver contentObserver = zzjr.zzf;
                        if (contentObserver != null) {
                            zzjr.zzc.unregisterContentObserver(contentObserver);
                            zzjr.zzf = null;
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            it.remove();
        }
    }

    public static /* synthetic */ zzjr zzf(ContentResolver contentResolver, Uri uri, Runnable runnable, Uri uri2) {
        return new zzjr(contentResolver, uri, runnable);
    }

    public final Map zzb() {
        Map emptyMap;
        Map map = this.zzi;
        if (map == null) {
            synchronized (this.zzh) {
                map = this.zzi;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        emptyMap = (Map) zzjv.zzh(new zzjp(this));
                    } catch (SQLiteException | IllegalStateException | SecurityException e) {
                        try {
                            Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                            emptyMap = Collections.emptyMap();
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            throw th;
                        }
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    this.zzi = emptyMap;
                    map = emptyMap;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    public final void zzc() {
        synchronized (this.zzh) {
            this.zzi = null;
            this.zze.run();
        }
        synchronized (this) {
            try {
                for (zzjs zza2 : this.zzj) {
                    zza2.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* bridge */ /* synthetic */ Object zze(String str) {
        return (String) zzb().get(str);
    }

    public final /* synthetic */ Map zzg() {
        Map emptyMap;
        Cursor query;
        a aVar;
        Map emptyMap2;
        ContentResolver contentResolver = this.zzc;
        Uri uri = this.zzd;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        if (acquireUnstableContentProviderClient == null) {
            Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
            return Collections.emptyMap();
        }
        try {
            query = acquireUnstableContentProviderClient.query(uri, zza, (String) null, (String[]) null, (String) null);
            if (query == null) {
                Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                emptyMap = Collections.emptyMap();
                acquireUnstableContentProviderClient.release();
                return emptyMap;
            }
            int count = query.getCount();
            if (count == 0) {
                emptyMap2 = Collections.emptyMap();
            } else {
                if (count <= 256) {
                    aVar = new a(count);
                } else {
                    aVar = new HashMap(count, 1.0f);
                }
                while (query.moveToNext()) {
                    aVar.put(query.getString(0), query.getString(1));
                }
                if (!query.isAfterLast()) {
                    Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                    emptyMap2 = Collections.emptyMap();
                } else {
                    query.close();
                    acquireUnstableContentProviderClient.release();
                    return aVar;
                }
            }
            query.close();
            acquireUnstableContentProviderClient.release();
            return emptyMap2;
        } catch (RemoteException e) {
            try {
                Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
                emptyMap = Collections.emptyMap();
            } catch (Throwable th) {
                acquireUnstableContentProviderClient.release();
                throw th;
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
