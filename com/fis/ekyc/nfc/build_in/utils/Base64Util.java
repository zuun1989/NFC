package com.fis.ekyc.nfc.build_in.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

public class Base64Util {
    public static Bitmap convertBase64ToBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("data:image") && str.split(",").length > 1) {
            str = str.split(",")[1];
        }
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static String convertBitmapToBase64(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return "data:image/png;base64," + Base64.encodeToString(byteArray, 0);
    }
}
