package com.google.android.gms.internal.common;

import java.util.Iterator;

public abstract class zzan implements Iterator {
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
