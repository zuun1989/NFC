package com.fis.ekyc.nfc.build_in.bouncycastle.util;

public interface Selector<T> extends Cloneable {
    Object clone();

    boolean match(T t);
}
