package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class zzfo {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzfm zzfm, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zzd(zzfm, sb2, 0);
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
            zzc(i, sb2);
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
                sb2.append(zzgq.zza(new zzde(((String) obj).getBytes(zzep.zza))));
                sb2.append('\"');
            } else if (obj instanceof zzdf) {
                sb2.append(": \"");
                sb2.append(zzgq.zza((zzdf) obj));
                sb2.append('\"');
            } else if (obj instanceof zzeh) {
                sb2.append(" {");
                zzd((zzeh) obj, sb2, i + 2);
                sb2.append("\n");
                zzc(i, sb2);
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                int i3 = i + 2;
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                zzb(sb2, i3, "key", entry.getKey());
                zzb(sb2, i3, "value", entry.getValue());
                sb2.append("\n");
                zzc(i, sb2);
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj);
            }
        }
    }

    private static void zzc(int i, StringBuilder sb2) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb2.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzfm zzfm, StringBuilder sb2, int i) {
        int i2;
        boolean z;
        Method method;
        Method method2;
        zzfm zzfm2 = zzfm;
        StringBuilder sb3 = sb2;
        int i3 = i;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzfm.getClass().getDeclaredMethods();
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
                zzb(sb3, i3, substring.substring(0, substring.length() - 4), zzeh.zzR(method2, zzfm2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb3, i3, substring.substring(0, substring.length() - 3), zzeh.zzR(method, zzfm2, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzR = zzeh.zzR(method4, zzfm2, new Object[0]);
                    if (method5 == null) {
                        if (zzR instanceof Boolean) {
                            if (!((Boolean) zzR).booleanValue()) {
                            }
                        } else if (zzR instanceof Integer) {
                            if (((Integer) zzR).intValue() == 0) {
                            }
                        } else if (zzR instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzR).floatValue()) == 0) {
                            }
                        } else if (!(zzR instanceof Double)) {
                            if (zzR instanceof String) {
                                z = zzR.equals("");
                            } else if (zzR instanceof zzdf) {
                                z = zzR.equals(zzdf.zzb);
                            } else if (zzR instanceof zzfm) {
                                if (zzR == ((zzfm) zzR).zzac()) {
                                }
                            } else if ((zzR instanceof Enum) && ((Enum) zzR).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzR).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzeh.zzR(method5, zzfm2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb3, i3, substring, zzR);
                }
            }
            i2 = 3;
        }
        if (zzfm2 instanceof zzed) {
            Iterator zzf = ((zzed) zzfm2).zzb.zzf();
            while (zzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzf.next();
                zzb(sb3, i3, "[" + ((zzee) entry2.getKey()).zza + "]", entry2.getValue());
            }
        }
        zzgt zzgt = ((zzeh) zzfm2).zzc;
        if (zzgt != null) {
            zzgt.zzi(sb3, i3);
        }
    }
}
