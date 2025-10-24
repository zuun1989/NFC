package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class ClassUtil {
    public static Class loadClass(Class cls, final String str) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                return classLoader.loadClass(str);
            }
            return (Class) AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    try {
                        return Class.forName(str);
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
