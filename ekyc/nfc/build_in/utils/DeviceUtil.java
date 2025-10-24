package com.fis.ekyc.nfc.build_in.utils;

import android.content.res.Resources;
import android.os.Build;

public final class DeviceUtil {
    private DeviceUtil() {
        throw new UnsupportedOperationException("can't instantiate me...");
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        String str = Build.MODEL;
        if (str != null) {
            return str.trim().replaceAll("\\s*", "");
        }
        return "";
    }

    public static int getSDKVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    public static String getSDKVersionName() {
        return Build.VERSION.RELEASE;
    }

    public static boolean isTablet() {
        if ((Resources.getSystem().getConfiguration().screenLayout & 15) >= 3) {
            return true;
        }
        return false;
    }
}
