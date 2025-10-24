package com.google.android.gms.internal.auth;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class zzfy {
    public static String zza(zzfw zzfw, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zzd(zzfw, sb2, 0);
        return sb2.toString();
    }

    public static final void zzb(StringBuilder sb2, int i, String str, Object obj) {
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
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb2.append(' ');
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(zzgw.zza(zzee.zzl((String) obj)));
                sb2.append('\"');
            } else if (obj instanceof zzee) {
                sb2.append(": \"");
                sb2.append(zzgw.zza((zzee) obj));
                sb2.append('\"');
            } else if (obj instanceof zzeu) {
                sb2.append(" {");
                zzd((zzeu) obj, sb2, i + 2);
                sb2.append("\n");
                while (i2 < i) {
                    sb2.append(' ');
                    i2++;
                }
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zzb(sb2, i4, "key", entry.getKey());
                zzb(sb2, i4, "value", entry.getValue());
                sb2.append("\n");
                while (i2 < i) {
                    sb2.append(' ');
                    i2++;
                }
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj);
            }
        }
    }

    private static final String zzc(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb2.append("_");
            }
            sb2.append(Character.toLowerCase(charAt));
        }
        return sb2.toString();
    }

    private static void zzd(zzfw zzfw, StringBuilder sb2, int i) {
        String str;
        boolean z;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzfw.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str2 : treeSet) {
            if (str2.startsWith("get")) {
                str = str2.substring(3);
            } else {
                str = str2;
            }
            if (str.endsWith("List") && !str.endsWith("OrBuilderList") && !str.equals("List")) {
                String concat = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1, str.length() - 4)));
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb2, i, zzc(concat), zzeu.zze(method2, zzfw, new Object[0]));
                }
            }
            if (str.endsWith("Map") && !str.equals("Map")) {
                String concat2 = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1, str.length() - 3)));
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb2, i, zzc(concat2), zzeu.zze(method3, zzfw, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(str))) != null && (!str.endsWith("Bytes") || !hashMap.containsKey("get".concat(String.valueOf(str.substring(0, str.length() - 5)))))) {
                String concat3 = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1)));
                Method method4 = (Method) hashMap.get("get".concat(str));
                Method method5 = (Method) hashMap.get("has".concat(str));
                if (method4 != null) {
                    Object zze = zzeu.zze(method4, zzfw, new Object[0]);
                    if (method5 == null) {
                        if (zze instanceof Boolean) {
                            if (!((Boolean) zze).booleanValue()) {
                            }
                        } else if (zze instanceof Integer) {
                            if (((Integer) zze).intValue() == 0) {
                            }
                        } else if (zze instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zze).floatValue()) == 0) {
                            }
                        } else if (!(zze instanceof Double)) {
                            if (zze instanceof String) {
                                z = zze.equals("");
                            } else if (zze instanceof zzee) {
                                z = zze.equals(zzee.zzb);
                            } else if (zze instanceof zzfw) {
                                if (zze == ((zzfw) zze).zzh()) {
                                }
                            } else if ((zze instanceof Enum) && ((Enum) zze).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zze).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzeu.zze(method5, zzfw, new Object[0])).booleanValue()) {
                    }
                    zzb(sb2, i, zzc(concat3), zze);
                }
            }
        }
        if (!(zzfw instanceof zzet)) {
            zzgz zzgz = ((zzeu) zzfw).zzc;
            if (zzgz != null) {
                zzgz.zze(sb2, i);
                return;
            }
            return;
        }
        zzet zzet = (zzet) zzfw;
        throw null;
    }
}
