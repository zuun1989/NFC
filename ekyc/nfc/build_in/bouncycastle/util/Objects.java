package com.fis.ekyc.nfc.build_in.bouncycastle.util;

public class Objects {
    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == obj2 || (obj != null && obj2 != null && obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
