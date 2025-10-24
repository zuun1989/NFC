package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;

@KeepForSdk
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(StringBuilder sb2, HashMap<String, String> hashMap) {
        sb2.append("{");
        boolean z = true;
        for (String next : hashMap.keySet()) {
            if (!z) {
                sb2.append(",");
            }
            String str = hashMap.get(next);
            sb2.append("\"");
            sb2.append(next);
            sb2.append("\":");
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\"");
            }
            z = false;
        }
        sb2.append("}");
    }
}
