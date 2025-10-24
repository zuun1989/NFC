package com.google.android.gms.internal.location;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class zzeo {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    private static final StringBuilder zzc = new StringBuilder(33);

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
    }

    public static String zza(long j) {
        if (j >= 0) {
            return zza.format(new Date(j));
        }
        return Long.toString(j);
    }

    public static String zzb(long j) {
        String sb2;
        StringBuilder sb3 = zzc;
        synchronized (sb3) {
            sb3.setLength(0);
            zzc(j, sb3);
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public static StringBuilder zzc(long j, StringBuilder sb2) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            sb2.append("0s");
            return sb2;
        }
        sb2.ensureCapacity(sb2.length() + 27);
        boolean z = false;
        if (i < 0) {
            sb2.append("-");
            if (j != Long.MIN_VALUE) {
                j = -j;
            } else {
                j = Long.MAX_VALUE;
                z = true;
            }
        }
        if (j >= 86400000) {
            sb2.append(j / 86400000);
            sb2.append("d");
            j %= 86400000;
        }
        if (true == z) {
            j = 25975808;
        }
        if (j >= 3600000) {
            sb2.append(j / 3600000);
            sb2.append("h");
            j %= 3600000;
        }
        if (j >= 60000) {
            sb2.append(j / 60000);
            sb2.append("m");
            j %= 60000;
        }
        if (j >= 1000) {
            sb2.append(j / 1000);
            sb2.append("s");
            j %= 1000;
        }
        if (j > 0) {
            sb2.append(j);
            sb2.append("ms");
        }
        return sb2;
    }
}
