package com.fasterxml.jackson.databind.node;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract /* synthetic */ class a {
    public static /* synthetic */ BigDecimal a(BigDecimal bigDecimal) {
        if (bigDecimal.signum() == 0) {
            return new BigDecimal(BigInteger.ZERO, 0);
        }
        return bigDecimal.stripTrailingZeros();
    }
}
