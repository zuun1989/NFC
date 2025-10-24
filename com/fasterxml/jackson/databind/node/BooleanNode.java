package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class BooleanNode extends ValueNode {
    public static final BooleanNode FALSE = new BooleanNode(false);
    public static final BooleanNode TRUE = new BooleanNode(true);
    private final boolean _value;

    public BooleanNode(boolean z) {
        this._value = z;
    }

    public static BooleanNode getFalse() {
        return FALSE;
    }

    public static BooleanNode getTrue() {
        return TRUE;
    }

    public static BooleanNode valueOf(boolean z) {
        if (z) {
            return TRUE;
        }
        return FALSE;
    }

    public boolean asBoolean() {
        return this._value;
    }

    public double asDouble(double d) {
        if (this._value) {
            return 1.0d;
        }
        return 0.0d;
    }

    public int asInt(int i) {
        return this._value ? 1 : 0;
    }

    public long asLong(long j) {
        if (this._value) {
            return 1;
        }
        return 0;
    }

    public String asText() {
        if (this._value) {
            return "true";
        }
        return "false";
    }

    public JsonToken asToken() {
        if (this._value) {
            return JsonToken.VALUE_TRUE;
        }
        return JsonToken.VALUE_FALSE;
    }

    public boolean booleanValue() {
        return this._value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof BooleanNode)) {
            return false;
        }
        if (this._value == ((BooleanNode) obj)._value) {
            return true;
        }
        return false;
    }

    public JsonNodeType getNodeType() {
        return JsonNodeType.BOOLEAN;
    }

    public int hashCode() {
        if (this._value) {
            return 3;
        }
        return 1;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeBoolean(this._value);
    }

    public boolean asBoolean(boolean z) {
        return this._value;
    }
}
