package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.Serializable;

public class NullsConstantProvider implements NullValueProvider, Serializable {
    private static final NullsConstantProvider NULLER = new NullsConstantProvider((Object) null);
    private static final NullsConstantProvider SKIPPER = new NullsConstantProvider((Object) null);
    private static final long serialVersionUID = 1;
    protected final AccessPattern _access;
    protected final Object _nullValue;

    public NullsConstantProvider(Object obj) {
        AccessPattern accessPattern;
        this._nullValue = obj;
        if (obj == null) {
            accessPattern = AccessPattern.ALWAYS_NULL;
        } else {
            accessPattern = AccessPattern.CONSTANT;
        }
        this._access = accessPattern;
    }

    public static NullsConstantProvider forValue(Object obj) {
        if (obj == null) {
            return NULLER;
        }
        return new NullsConstantProvider(obj);
    }

    public static boolean isNuller(NullValueProvider nullValueProvider) {
        if (nullValueProvider == NULLER) {
            return true;
        }
        return false;
    }

    public static boolean isSkipper(NullValueProvider nullValueProvider) {
        if (nullValueProvider == SKIPPER) {
            return true;
        }
        return false;
    }

    public static NullsConstantProvider nuller() {
        return NULLER;
    }

    public static NullsConstantProvider skipper() {
        return SKIPPER;
    }

    public AccessPattern getNullAccessPattern() {
        return this._access;
    }

    public Object getNullValue(DeserializationContext deserializationContext) {
        return this._nullValue;
    }
}
