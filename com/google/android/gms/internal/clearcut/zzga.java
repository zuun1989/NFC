package com.google.android.gms.internal.clearcut;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DisplayText;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzga {
    public static <T extends zzfz> String zza(T t) {
        if (t == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            zza((String) null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            String valueOf = String.valueOf(e.getMessage());
            return valueOf.length() != 0 ? "Error printing proto: ".concat(valueOf) : new String("Error printing proto: ");
        } catch (InvocationTargetException e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            return valueOf2.length() != 0 ? "Error printing proto: ".concat(valueOf2) : new String("Error printing proto: ");
        }
    }

    private static String zzl(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i != 0) {
                if (Character.isUpperCase(charAt)) {
                    stringBuffer.append('_');
                }
                stringBuffer.append(charAt);
            }
            charAt = Character.toLowerCase(charAt);
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    private static void zza(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        if (obj != null) {
            int i = 0;
            if (obj instanceof zzfz) {
                int length = stringBuffer.length();
                if (str != null) {
                    stringBuffer2.append(stringBuffer);
                    stringBuffer2.append(zzl(str));
                    stringBuffer2.append(" <\n");
                    stringBuffer.append("  ");
                }
                Class<?> cls = obj.getClass();
                for (Field field : cls.getFields()) {
                    int modifiers = field.getModifiers();
                    String name = field.getName();
                    if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                        Class<?> type = field.getType();
                        Object obj2 = field.get(obj);
                        if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                            zza(name, obj2, stringBuffer, stringBuffer2);
                        } else {
                            int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                            for (int i2 = 0; i2 < length2; i2++) {
                                zza(name, Array.get(obj2, i2), stringBuffer, stringBuffer2);
                            }
                        }
                    }
                }
                Method[] methods = cls.getMethods();
                int length3 = methods.length;
                while (i < length3) {
                    String name2 = methods[i].getName();
                    if (name2.startsWith("set")) {
                        String substring = name2.substring(3);
                        try {
                            String valueOf = String.valueOf(substring);
                            if (((Boolean) cls.getMethod(valueOf.length() != 0 ? "has".concat(valueOf) : new String("has"), (Class[]) null).invoke(obj, (Object[]) null)).booleanValue()) {
                                String valueOf2 = String.valueOf(substring);
                                zza(substring, cls.getMethod(valueOf2.length() != 0 ? "get".concat(valueOf2) : new String("get"), (Class[]) null).invoke(obj, (Object[]) null), stringBuffer, stringBuffer2);
                            }
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    i++;
                }
                if (str != null) {
                    stringBuffer.setLength(length);
                    stringBuffer2.append(stringBuffer);
                    stringBuffer2.append(">\n");
                    return;
                }
                return;
            }
            String zzl = zzl(str);
            stringBuffer2.append(stringBuffer);
            stringBuffer2.append(zzl);
            stringBuffer2.append(": ");
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (!str2.startsWith("http") && str2.length() > 200) {
                    str2 = String.valueOf(str2.substring(0, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE)).concat("[...]");
                }
                int length4 = str2.length();
                StringBuilder sb2 = new StringBuilder(length4);
                while (i < length4) {
                    char charAt = str2.charAt(i);
                    if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                        sb2.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    } else {
                        sb2.append(charAt);
                    }
                    i++;
                }
                String sb3 = sb2.toString();
                stringBuffer2.append("\"");
                stringBuffer2.append(sb3);
                stringBuffer2.append("\"");
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                stringBuffer2.append('\"');
                while (i < bArr.length) {
                    byte b = bArr[i] & 255;
                    if (b == 92 || b == 34) {
                        stringBuffer2.append('\\');
                    } else if (b < 32 || b >= Byte.MAX_VALUE) {
                        stringBuffer2.append(String.format("\\%03o", new Object[]{Integer.valueOf(b)}));
                        i++;
                    }
                    stringBuffer2.append((char) b);
                    i++;
                }
                stringBuffer2.append('\"');
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append("\n");
        }
    }
}
