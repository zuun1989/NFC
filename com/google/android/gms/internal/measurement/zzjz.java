package com.google.android.gms.internal.measurement;

import G5.l;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import w0.k;

public final class zzjz {
    private static volatile l zza;

    private zzjz() {
    }

    public static l zza(Context context) {
        Context context2;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        l lVar;
        BufferedReader bufferedReader;
        Throwable th;
        l lVar2 = zza;
        if (lVar2 == null) {
            synchronized (zzjz.class) {
                try {
                    lVar2 = zza;
                    if (lVar2 == null) {
                        String str = Build.TYPE;
                        String str2 = Build.TAGS;
                        int i = zzkb.zza;
                        if (!str.equals("eng")) {
                            if (str.equals("userdebug")) {
                            }
                            lVar2 = l.a();
                            zza = lVar2;
                        }
                        if (!str2.contains("dev-keys")) {
                            if (str2.contains("test-keys")) {
                            }
                            lVar2 = l.a();
                            zza = lVar2;
                        }
                        if (!zzjm.zza() || context.isDeviceProtectedStorage()) {
                            context2 = context;
                        } else {
                            context2 = context.createDeviceProtectedStorageContext();
                        }
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        StrictMode.allowThreadDiskWrites();
                        char c = 0;
                        try {
                            File file = new File(context2.getDir("phenotype_hermetic", 0), "overrides.txt");
                            if (file.exists()) {
                                lVar = l.d(file);
                            } else {
                                lVar = l.a();
                            }
                        } catch (RuntimeException e) {
                            Log.e("HermeticFileOverrides", "no data dir", e);
                            lVar = l.a();
                        }
                        if (lVar.c()) {
                            File file2 = (File) lVar.b();
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                k kVar = new k();
                                HashMap hashMap = new HashMap();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    String[] split = readLine.split(" ", 3);
                                    if (split.length != 3) {
                                        StringBuilder sb2 = new StringBuilder(readLine.length() + 9);
                                        sb2.append("Invalid: ");
                                        sb2.append(readLine);
                                        Log.e("HermeticFileOverrides", sb2.toString());
                                    } else {
                                        String str3 = new String(split[c]);
                                        String decode = Uri.decode(new String(split[1]));
                                        String str4 = (String) hashMap.get(split[2]);
                                        if (str4 == null) {
                                            String str5 = new String(split[2]);
                                            str4 = Uri.decode(str5);
                                            if (str4.length() < 1024 || str4 == str5) {
                                                hashMap.put(str5, str4);
                                            }
                                        }
                                        k kVar2 = (k) kVar.get(str3);
                                        if (kVar2 == null) {
                                            kVar2 = new k();
                                            kVar.put(str3, kVar2);
                                        }
                                        kVar2.put(decode, str4);
                                        c = 0;
                                    }
                                }
                                String obj = file2.toString();
                                String packageName = context2.getPackageName();
                                StringBuilder sb3 = new StringBuilder(obj.length() + 28 + String.valueOf(packageName).length());
                                sb3.append("Parsed ");
                                sb3.append(obj);
                                sb3.append(" for Android package ");
                                sb3.append(packageName);
                                Log.w("HermeticFileOverrides", sb3.toString());
                                zzjt zzjt = new zzjt(kVar);
                                bufferedReader.close();
                                lVar2 = l.d(zzjt);
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            lVar2 = l.a();
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        zza = lVar2;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return lVar2;
        throw th;
    }
}
