package com.google.android.gms.internal.measurement;

import com.fasterxml.jackson.databind.node.a;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public final class zzah implements zzao {
    private final Double zza;

    public zzah(Double d) {
        if (d == null) {
            this.zza = Double.valueOf(Double.NaN);
        } else {
            this.zza = d;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        return this.zza.equals(((zzah) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return zzc();
    }

    public final String zzc() {
        int scale;
        Double d = this.zza;
        if (Double.isNaN(d.doubleValue())) {
            return "NaN";
        }
        if (!Double.isInfinite(d.doubleValue())) {
            BigDecimal a = a.a(BigDecimal.valueOf(d.doubleValue()));
            DecimalFormat decimalFormat = new DecimalFormat("0E0");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (a.scale() > 0) {
                scale = a.precision();
            } else {
                scale = a.scale();
            }
            decimalFormat.setMinimumFractionDigits(scale - 1);
            String format = decimalFormat.format(a);
            int indexOf = format.indexOf("E");
            if (indexOf <= 0) {
                return format;
            }
            int parseInt = Integer.parseInt(format.substring(indexOf + 1));
            if ((parseInt >= 0 || parseInt <= -7) && (parseInt < 0 || parseInt >= 21)) {
                return format.replace("E-", "e-").replace("E", "e+");
            }
            return a.toPlainString();
        } else if (d.doubleValue() > 0.0d) {
            return "Infinity";
        } else {
            return "-Infinity";
        }
    }

    public final zzao zzcA(String str, zzg zzg, List list) {
        if ("toString".equals(str)) {
            return new zzas(zzc());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{zzc(), str}));
    }

    public final Double zzd() {
        return this.zza;
    }

    public final Boolean zze() {
        Double d = this.zza;
        boolean z = false;
        if (!Double.isNaN(d.doubleValue()) && d.doubleValue() != 0.0d) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public final Iterator zzf() {
        return null;
    }

    public final zzao zzt() {
        return new zzah(this.zza);
    }
}
