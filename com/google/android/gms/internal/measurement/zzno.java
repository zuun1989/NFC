package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class zzno {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zznm zznm, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zzc(zznm, sb2, 0);
        return sb2.toString();
    }

    public static void zzb(StringBuilder sb2, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb2, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb2, i, str, zzb2);
            }
        } else {
            sb2.append(10);
            zzd(i, sb2);
            if (!str.isEmpty()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb3.append("_");
                    }
                    sb3.append(Character.toLowerCase(charAt));
                }
                str = sb3.toString();
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                zzlh zzlh = zzlh.zzb;
                sb2.append(zzog.zza(new zzlg(((String) obj).getBytes(zzmp.zza))));
                sb2.append('\"');
            } else if (obj instanceof zzlh) {
                sb2.append(": \"");
                sb2.append(zzog.zza((zzlh) obj));
                sb2.append('\"');
            } else if (obj instanceof zzmf) {
                sb2.append(" {");
                zzc((zzmf) obj, sb2, i + 2);
                sb2.append("\n");
                zzd(i, sb2);
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                int i3 = i + 2;
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                zzb(sb2, i3, "key", entry.getKey());
                zzb(sb2, i3, "value", entry.getValue());
                sb2.append("\n");
                zzd(i, sb2);
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj);
            }
        }
    }

    private static void zzc(zznm zznm, StringBuilder sb2, int i) {
        int i2;
        boolean z;
        Method method;
        Method method2;
        zznm zznm2 = zznm;
        StringBuilder sb3 = sb2;
        int i3 = i;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zznm.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb3, i3, substring.substring(0, substring.length() - 4), zzmf.zzcr(method2, zznm2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb3, i3, substring.substring(0, substring.length() - 3), zzmf.zzcr(method, zznm2, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzcr = zzmf.zzcr(method4, zznm2, new Object[0]);
                    if (method5 == null) {
                        if (zzcr instanceof Boolean) {
                            if (!((Boolean) zzcr).booleanValue()) {
                            }
                        } else if (zzcr instanceof Integer) {
                            if (((Integer) zzcr).intValue() == 0) {
                            }
                        } else if (zzcr instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzcr).floatValue()) == 0) {
                            }
                        } else if (!(zzcr instanceof Double)) {
                            if (zzcr instanceof String) {
                                z = zzcr.equals("");
                            } else if (zzcr instanceof zzlh) {
                                z = zzcr.equals(zzlh.zzb);
                            } else if (zzcr instanceof zznm) {
                                if (zzcr == ((zznm) zzcr).zzcE()) {
                                }
                            } else if ((zzcr instanceof Enum) && ((Enum) zzcr).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzcr).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzmf.zzcr(method5, zznm2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb3, i3, substring, zzcr);
                }
            }
            i2 = 3;
        }
        if (zznm2 instanceof zzmc) {
            Iterator zzc = ((zzmc) zznm2).zzb.zzc();
            if (zzc.hasNext()) {
                zzmd zzmd = (zzmd) ((Map.Entry) zzc.next()).getKey();
                throw null;
            }
        }
        zzoj zzoj = ((zzmf) zznm2).zzc;
        if (zzoj != null) {
            zzoj.zzj(sb3, i3);
        }
    }

    private static void zzd(int i, StringBuilder sb2) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb2.append(zza, 0, i2);
            i -= i2;
        }
    }
}
