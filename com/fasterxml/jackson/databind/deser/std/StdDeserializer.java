package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsFailProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp.PKIFailureInfo;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public abstract class StdDeserializer<T> extends JsonDeserializer<T> implements Serializable {
    protected static final int F_MASK_ACCEPT_ARRAYS = (DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS.getMask() | DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.getMask());
    protected static final int F_MASK_INT_COERCIONS = (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.getMask() | DeserializationFeature.USE_LONG_FOR_INTS.getMask());
    private static final long serialVersionUID = 1;
    protected final Class<?> _valueClass;

    public StdDeserializer(Class<?> cls) {
        this._valueClass = cls;
    }

    public static final boolean _neitherNull(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    public static final double parseDouble(String str) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_NORMAL;
        }
        return Double.parseDouble(str);
    }

    public final boolean _byteOverflow(int i) {
        return i < -128 || i > 255;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.fasterxml.jackson.databind.MapperFeature} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.fasterxml.jackson.databind.DeserializationFeature} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.fasterxml.jackson.databind.MapperFeature} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.fasterxml.jackson.databind.MapperFeature} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object _coerceEmptyString(com.fasterxml.jackson.databind.DeserializationContext r3, boolean r4) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r2 = this;
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.ALLOW_COERCION_OF_SCALARS
            boolean r1 = r3.isEnabled((com.fasterxml.jackson.databind.MapperFeature) r0)
            if (r1 != 0) goto L_0x000a
            r4 = 1
            goto L_0x0015
        L_0x000a:
            if (r4 == 0) goto L_0x001c
            com.fasterxml.jackson.databind.DeserializationFeature r0 = com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES
            boolean r4 = r3.isEnabled((com.fasterxml.jackson.databind.DeserializationFeature) r0)
            if (r4 == 0) goto L_0x001c
            r4 = 0
        L_0x0015:
            java.lang.String r1 = "empty String (\"\")"
            r2._reportFailedNullCoerce(r3, r4, r0, r1)
            r3 = 0
            return r3
        L_0x001c:
            java.lang.Object r3 = r2.getNullValue(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._coerceEmptyString(com.fasterxml.jackson.databind.DeserializationContext, boolean):java.lang.Object");
    }

    public Object _coerceIntegral(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures)) {
            return jsonParser.getBigIntegerValue();
        }
        if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures)) {
            return Long.valueOf(jsonParser.getLongValue());
        }
        return jsonParser.getBigIntegerValue();
    }

    public Object _coerceNullToken(DeserializationContext deserializationContext, boolean z) throws JsonMappingException {
        if (z) {
            _verifyNullForPrimitive(deserializationContext);
        }
        return getNullValue(deserializationContext);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.fasterxml.jackson.databind.MapperFeature} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.fasterxml.jackson.databind.DeserializationFeature} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.fasterxml.jackson.databind.MapperFeature} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.fasterxml.jackson.databind.MapperFeature} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object _coerceTextualNull(com.fasterxml.jackson.databind.DeserializationContext r3, boolean r4) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r2 = this;
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.ALLOW_COERCION_OF_SCALARS
            boolean r1 = r3.isEnabled((com.fasterxml.jackson.databind.MapperFeature) r0)
            if (r1 != 0) goto L_0x000a
            r4 = 1
            goto L_0x0015
        L_0x000a:
            if (r4 == 0) goto L_0x001c
            com.fasterxml.jackson.databind.DeserializationFeature r0 = com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES
            boolean r4 = r3.isEnabled((com.fasterxml.jackson.databind.DeserializationFeature) r0)
            if (r4 == 0) goto L_0x001c
            r4 = 0
        L_0x0015:
            java.lang.String r1 = "String \"null\""
            r2._reportFailedNullCoerce(r3, r4, r0, r1)
            r3 = 0
            return r3
        L_0x001c:
            java.lang.Object r3 = r2.getNullValue(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._coerceTextualNull(com.fasterxml.jackson.databind.DeserializationContext, boolean):java.lang.Object");
    }

    public String _coercedTypeDesc() {
        String str;
        JavaType valueType = getValueType();
        boolean z = true;
        if (valueType == null || valueType.isPrimitive()) {
            Class<?> handledType = handledType();
            if (!handledType.isArray() && !Collection.class.isAssignableFrom(handledType) && !Map.class.isAssignableFrom(handledType)) {
                z = false;
            }
            str = ClassUtil.nameOf(handledType);
        } else {
            if (!valueType.isContainerType() && !valueType.isReferenceType()) {
                z = false;
            }
            str = "'" + valueType.toString() + "'";
        }
        if (z) {
            return "as content of type " + str;
        }
        return "for type " + str;
    }

    public T _deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken;
        if (deserializationContext.hasSomeOfFeatures(F_MASK_ACCEPT_ARRAYS)) {
            currentToken = jsonParser.nextToken();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            if (currentToken == jsonToken && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                return getNullValue(deserializationContext);
            }
            if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                T deserialize = deserialize(jsonParser, deserializationContext);
                if (jsonParser.nextToken() != jsonToken) {
                    handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                }
                return deserialize;
            }
        } else {
            currentToken = jsonParser.getCurrentToken();
        }
        return deserializationContext.handleUnexpectedToken(this._valueClass, currentToken, jsonParser, (String) null, new Object[0]);
    }

    public T _deserializeFromEmpty(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_ARRAY) {
            if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                if (jsonParser.nextToken() == JsonToken.END_ARRAY) {
                    return null;
                }
                return deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
            }
        } else if (currentToken == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().trim().isEmpty()) {
            return null;
        }
        return deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
    }

    public T _deserializeWrappedValue(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonToken = JsonToken.START_ARRAY;
        if (!jsonParser.hasToken(jsonToken)) {
            return deserialize(jsonParser, deserializationContext);
        }
        return deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser.getCurrentToken(), jsonParser, String.format("Cannot deserialize instance of %s out of %s token: nested Arrays not allowed with %s", new Object[]{ClassUtil.nameOf(this._valueClass), jsonToken, "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"}), new Object[0]);
    }

    public void _failDoubleToIntCoercion(JsonParser jsonParser, DeserializationContext deserializationContext, String str) throws IOException {
        deserializationContext.reportInputMismatch(handledType(), "Cannot coerce a floating-point value ('%s') into %s (enable `DeserializationFeature.ACCEPT_FLOAT_AS_INT` to allow)", jsonParser.getValueAsString(), str);
    }

    public final NullValueProvider _findNullProvider(DeserializationContext deserializationContext, BeanProperty beanProperty, Nulls nulls, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        if (nulls == Nulls.FAIL) {
            if (beanProperty == null) {
                return NullsFailProvider.constructForRootValue(deserializationContext.constructType(jsonDeserializer.handledType()));
            }
            return NullsFailProvider.constructForProperty(beanProperty);
        } else if (nulls == Nulls.AS_EMPTY) {
            if (jsonDeserializer == null) {
                return null;
            }
            if ((jsonDeserializer instanceof BeanDeserializerBase) && !((BeanDeserializerBase) jsonDeserializer).getValueInstantiator().canCreateUsingDefault()) {
                JavaType type = beanProperty.getType();
                deserializationContext.reportBadDefinition(type, String.format("Cannot create empty instance of %s, no default Creator", new Object[]{type}));
            }
            AccessPattern emptyAccessPattern = jsonDeserializer.getEmptyAccessPattern();
            if (emptyAccessPattern == AccessPattern.ALWAYS_NULL) {
                return NullsConstantProvider.nuller();
            }
            if (emptyAccessPattern == AccessPattern.CONSTANT) {
                return NullsConstantProvider.forValue(jsonDeserializer.getEmptyValue(deserializationContext));
            }
            return new NullsAsEmptyProvider(jsonDeserializer);
        } else if (nulls == Nulls.SKIP) {
            return NullsConstantProvider.skipper();
        } else {
            return null;
        }
    }

    public boolean _hasTextualNull(String str) {
        return "null".equals(str);
    }

    public final boolean _intOverflow(long j) {
        return j < -2147483648L || j > 2147483647L;
    }

    public boolean _isEmptyOrTextualNull(String str) {
        if (str.isEmpty() || "null".equals(str)) {
            return true;
        }
        return false;
    }

    public final boolean _isIntNumber(String str) {
        int i;
        int length = str.length();
        if (length <= 0) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt == '-' || charAt == '+') {
            i = 1;
        } else {
            i = 0;
        }
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (charAt2 > '9' || charAt2 < '0') {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean _isNaN(String str) {
        return "NaN".equals(str);
    }

    public final boolean _isNegInf(String str) {
        if ("-Infinity".equals(str) || "-INF".equals(str)) {
            return true;
        }
        return false;
    }

    public final boolean _isPosInf(String str) {
        if ("Infinity".equals(str) || "INF".equals(str)) {
            return true;
        }
        return false;
    }

    public Number _nonNullNumber(Number number) {
        if (number == null) {
            return 0;
        }
        return number;
    }

    public boolean _parseBooleanFromInt(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        _verifyNumberForScalarCoercion(deserializationContext, jsonParser);
        return !"0".equals(jsonParser.getText());
    }

    public final boolean _parseBooleanPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (currentToken == JsonToken.VALUE_FALSE) {
            return false;
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            _verifyNullForPrimitive(deserializationContext);
            return false;
        } else if (currentToken == JsonToken.VALUE_NUMBER_INT) {
            return _parseBooleanFromInt(jsonParser, deserializationContext);
        } else {
            if (currentToken == JsonToken.VALUE_STRING) {
                String trim = jsonParser.getText().trim();
                if ("true".equals(trim) || "True".equals(trim)) {
                    return true;
                }
                if ("false".equals(trim) || "False".equals(trim)) {
                    return false;
                }
                if (_isEmptyOrTextualNull(trim)) {
                    _verifyNullForPrimitiveCoercion(deserializationContext, trim);
                    return false;
                }
                return Boolean.TRUE.equals((Boolean) deserializationContext.handleWeirdStringValue(this._valueClass, trim, "only \"true\" or \"false\" recognized", new Object[0]));
            } else if (currentToken != JsonToken.START_ARRAY || !deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                return ((Boolean) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser)).booleanValue();
            } else {
                jsonParser.nextToken();
                boolean _parseBooleanPrimitive = _parseBooleanPrimitive(jsonParser, deserializationContext);
                _verifyEndArrayForSingle(jsonParser, deserializationContext);
                return _parseBooleanPrimitive;
            }
        }
    }

    public final byte _parseBytePrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
        if (_byteOverflow(_parseIntPrimitive)) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(this._valueClass, String.valueOf(_parseIntPrimitive), "overflow, value cannot be represented as 8-bit value", new Object[0])).byteValue();
        }
        return (byte) _parseIntPrimitive;
    }

    public Date _parseDate(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        long j;
        int currentTokenId = jsonParser.getCurrentTokenId();
        if (currentTokenId == 3) {
            return _parseDateFromArray(jsonParser, deserializationContext);
        }
        if (currentTokenId == 11) {
            return (Date) getNullValue(deserializationContext);
        }
        if (currentTokenId == 6) {
            return _parseDate(jsonParser.getText().trim(), deserializationContext);
        }
        if (currentTokenId != 7) {
            return (Date) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        }
        try {
            j = jsonParser.getLongValue();
        } catch (JsonParseException unused) {
            j = ((Number) deserializationContext.handleWeirdNumberValue(this._valueClass, jsonParser.getNumberValue(), "not a valid 64-bit long for creating `java.util.Date`", new Object[0])).longValue();
        }
        return new Date(j);
    }

    public Date _parseDateFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken;
        if (deserializationContext.hasSomeOfFeatures(F_MASK_ACCEPT_ARRAYS)) {
            currentToken = jsonParser.nextToken();
            if (currentToken == JsonToken.END_ARRAY && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                return (Date) getNullValue(deserializationContext);
            }
            if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                Date _parseDate = _parseDate(jsonParser, deserializationContext);
                _verifyEndArrayForSingle(jsonParser, deserializationContext);
                return _parseDate;
            }
        } else {
            currentToken = jsonParser.getCurrentToken();
        }
        return (Date) deserializationContext.handleUnexpectedToken(this._valueClass, currentToken, jsonParser, (String) null, new Object[0]);
    }

    public final double _parseDoublePrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_FLOAT)) {
            return jsonParser.getDoubleValue();
        }
        int currentTokenId = jsonParser.getCurrentTokenId();
        if (currentTokenId != 3) {
            if (currentTokenId == 11) {
                _verifyNullForPrimitive(deserializationContext);
                return 0.0d;
            } else if (currentTokenId == 6) {
                String trim = jsonParser.getText().trim();
                if (!_isEmptyOrTextualNull(trim)) {
                    return _parseDoublePrimitive(deserializationContext, trim);
                }
                _verifyNullForPrimitiveCoercion(deserializationContext, trim);
                return 0.0d;
            } else if (currentTokenId == 7) {
                return jsonParser.getDoubleValue();
            }
        } else if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.nextToken();
            double _parseDoublePrimitive = _parseDoublePrimitive(jsonParser, deserializationContext);
            _verifyEndArrayForSingle(jsonParser, deserializationContext);
            return _parseDoublePrimitive;
        }
        return ((Number) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser)).doubleValue();
    }

    public final float _parseFloatPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_FLOAT)) {
            return jsonParser.getFloatValue();
        }
        int currentTokenId = jsonParser.getCurrentTokenId();
        if (currentTokenId != 3) {
            if (currentTokenId == 11) {
                _verifyNullForPrimitive(deserializationContext);
                return 0.0f;
            } else if (currentTokenId == 6) {
                String trim = jsonParser.getText().trim();
                if (!_isEmptyOrTextualNull(trim)) {
                    return _parseFloatPrimitive(deserializationContext, trim);
                }
                _verifyNullForPrimitiveCoercion(deserializationContext, trim);
                return 0.0f;
            } else if (currentTokenId == 7) {
                return jsonParser.getFloatValue();
            }
        } else if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.nextToken();
            float _parseFloatPrimitive = _parseFloatPrimitive(jsonParser, deserializationContext);
            _verifyEndArrayForSingle(jsonParser, deserializationContext);
            return _parseFloatPrimitive;
        }
        return ((Number) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser)).floatValue();
    }

    public final int _parseIntPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
            return jsonParser.getIntValue();
        }
        int currentTokenId = jsonParser.getCurrentTokenId();
        if (currentTokenId != 3) {
            if (currentTokenId == 6) {
                String trim = jsonParser.getText().trim();
                if (!_isEmptyOrTextualNull(trim)) {
                    return _parseIntPrimitive(deserializationContext, trim);
                }
                _verifyNullForPrimitiveCoercion(deserializationContext, trim);
                return 0;
            } else if (currentTokenId == 8) {
                if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    _failDoubleToIntCoercion(jsonParser, deserializationContext, "int");
                }
                return jsonParser.getValueAsInt();
            } else if (currentTokenId == 11) {
                _verifyNullForPrimitive(deserializationContext);
                return 0;
            }
        } else if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.nextToken();
            int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
            _verifyEndArrayForSingle(jsonParser, deserializationContext);
            return _parseIntPrimitive;
        }
        return ((Number) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser)).intValue();
    }

    public final long _parseLongPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
            return jsonParser.getLongValue();
        }
        int currentTokenId = jsonParser.getCurrentTokenId();
        if (currentTokenId != 3) {
            if (currentTokenId == 6) {
                String trim = jsonParser.getText().trim();
                if (!_isEmptyOrTextualNull(trim)) {
                    return _parseLongPrimitive(deserializationContext, trim);
                }
                _verifyNullForPrimitiveCoercion(deserializationContext, trim);
                return 0;
            } else if (currentTokenId == 8) {
                if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    _failDoubleToIntCoercion(jsonParser, deserializationContext, "long");
                }
                return jsonParser.getValueAsLong();
            } else if (currentTokenId == 11) {
                _verifyNullForPrimitive(deserializationContext);
                return 0;
            }
        } else if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.nextToken();
            long _parseLongPrimitive = _parseLongPrimitive(jsonParser, deserializationContext);
            _verifyEndArrayForSingle(jsonParser, deserializationContext);
            return _parseLongPrimitive;
        }
        return ((Number) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser)).longValue();
    }

    public final short _parseShortPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
        if (_shortOverflow(_parseIntPrimitive)) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(this._valueClass, String.valueOf(_parseIntPrimitive), "overflow, value cannot be represented as 16-bit value", new Object[0])).shortValue();
        }
        return (short) _parseIntPrimitive;
    }

    public final String _parseString(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
            return jsonParser.getText();
        }
        String valueAsString = jsonParser.getValueAsString();
        if (valueAsString != null) {
            return valueAsString;
        }
        return (String) deserializationContext.handleUnexpectedToken(String.class, jsonParser);
    }

    public void _reportFailedNullCoerce(DeserializationContext deserializationContext, boolean z, Enum<?> enumR, String str) throws JsonMappingException {
        String str2;
        if (z) {
            str2 = "enable";
        } else {
            str2 = "disable";
        }
        deserializationContext.reportInputMismatch((JsonDeserializer<?>) this, "Cannot coerce %s to Null value %s (%s `%s.%s` to allow)", str, _coercedTypeDesc(), str2, enumR.getClass().getSimpleName(), enumR.name());
    }

    public final boolean _shortOverflow(int i) {
        return i < -32768 || i > 32767;
    }

    public void _verifyEndArrayForSingle(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            handleMissingEndArrayForSingle(jsonParser, deserializationContext);
        }
    }

    public final void _verifyNullForPrimitive(DeserializationContext deserializationContext) throws JsonMappingException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            deserializationContext.reportInputMismatch((JsonDeserializer<?>) this, "Cannot coerce `null` %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", _coercedTypeDesc());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.fasterxml.jackson.databind.MapperFeature} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.fasterxml.jackson.databind.DeserializationFeature} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.fasterxml.jackson.databind.MapperFeature} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.fasterxml.jackson.databind.MapperFeature} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void _verifyNullForPrimitiveCoercion(com.fasterxml.jackson.databind.DeserializationContext r4, java.lang.String r5) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r3 = this;
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.ALLOW_COERCION_OF_SCALARS
            boolean r1 = r4.isEnabled((com.fasterxml.jackson.databind.MapperFeature) r0)
            if (r1 != 0) goto L_0x000a
            r1 = 1
            goto L_0x0013
        L_0x000a:
            com.fasterxml.jackson.databind.DeserializationFeature r0 = com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES
            boolean r1 = r4.isEnabled((com.fasterxml.jackson.databind.DeserializationFeature) r0)
            if (r1 == 0) goto L_0x0029
            r1 = 0
        L_0x0013:
            boolean r2 = r5.isEmpty()
            if (r2 == 0) goto L_0x001c
            java.lang.String r5 = "empty String (\"\")"
            goto L_0x0026
        L_0x001c:
            java.lang.String r2 = "String \"%s\""
            java.lang.Object[] r5 = new java.lang.Object[]{r5}
            java.lang.String r5 = java.lang.String.format(r2, r5)
        L_0x0026:
            r3._reportFailedNullCoerce(r4, r1, r0, r5)
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._verifyNullForPrimitiveCoercion(com.fasterxml.jackson.databind.DeserializationContext, java.lang.String):void");
    }

    public final void _verifyNullForScalarCoercion(DeserializationContext deserializationContext, String str) throws JsonMappingException {
        String str2;
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (!deserializationContext.isEnabled(mapperFeature)) {
            if (str.isEmpty()) {
                str2 = "empty String (\"\")";
            } else {
                str2 = String.format("String \"%s\"", new Object[]{str});
            }
            _reportFailedNullCoerce(deserializationContext, true, mapperFeature, str2);
        }
    }

    public void _verifyNumberForScalarCoercion(DeserializationContext deserializationContext, JsonParser jsonParser) throws IOException {
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (!deserializationContext.isEnabled(mapperFeature)) {
            deserializationContext.reportInputMismatch((JsonDeserializer<?>) this, "Cannot coerce Number (%s) %s (enable `%s.%s` to allow)", jsonParser.getText(), _coercedTypeDesc(), mapperFeature.getClass().getSimpleName(), mapperFeature.name());
        }
    }

    public void _verifyStringForScalarCoercion(DeserializationContext deserializationContext, String str) throws JsonMappingException {
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (!deserializationContext.isEnabled(mapperFeature)) {
            deserializationContext.reportInputMismatch((JsonDeserializer<?>) this, "Cannot coerce String \"%s\" %s (enable `%s.%s` to allow)", str, _coercedTypeDesc(), mapperFeature.getClass().getSimpleName(), mapperFeature.name());
        }
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    public NullValueProvider findContentNullProvider(DeserializationContext deserializationContext, BeanProperty beanProperty, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Nulls findContentNullStyle = findContentNullStyle(deserializationContext, beanProperty);
        if (findContentNullStyle == Nulls.SKIP) {
            return NullsConstantProvider.skipper();
        }
        NullValueProvider _findNullProvider = _findNullProvider(deserializationContext, beanProperty, findContentNullStyle, jsonDeserializer);
        if (_findNullProvider != null) {
            return _findNullProvider;
        }
        return jsonDeserializer;
    }

    public Nulls findContentNullStyle(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) {
            return beanProperty.getMetadata().getContentNulls();
        }
        return null;
    }

    public JsonDeserializer<?> findConvertingContentDeserializer(DeserializationContext deserializationContext, BeanProperty beanProperty, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        AnnotatedMember member;
        Object findDeserializationContentConverter;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (!_neitherNull(annotationIntrospector, beanProperty) || (member = beanProperty.getMember()) == null || (findDeserializationContentConverter = annotationIntrospector.findDeserializationContentConverter(member)) == null) {
            return jsonDeserializer;
        }
        Converter<Object, Object> converterInstance = deserializationContext.converterInstance(beanProperty.getMember(), findDeserializationContentConverter);
        JavaType inputType = converterInstance.getInputType(deserializationContext.getTypeFactory());
        JsonDeserializer<Object> jsonDeserializer2 = jsonDeserializer;
        if (jsonDeserializer == null) {
            jsonDeserializer2 = deserializationContext.findContextualValueDeserializer(inputType, beanProperty);
        }
        return new StdDelegatingDeserializer(converterInstance, inputType, jsonDeserializer2);
    }

    public JsonDeserializer<Object> findDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return deserializationContext.findContextualValueDeserializer(javaType, beanProperty);
    }

    public Boolean findFormatFeature(DeserializationContext deserializationContext, BeanProperty beanProperty, Class<?> cls, JsonFormat.Feature feature) {
        JsonFormat.Value findFormatOverrides = findFormatOverrides(deserializationContext, beanProperty, cls);
        if (findFormatOverrides != null) {
            return findFormatOverrides.getFeature(feature);
        }
        return null;
    }

    public JsonFormat.Value findFormatOverrides(DeserializationContext deserializationContext, BeanProperty beanProperty, Class<?> cls) {
        if (beanProperty != null) {
            return beanProperty.findPropertyFormat(deserializationContext.getConfig(), cls);
        }
        return deserializationContext.getDefaultPropertyFormat(cls);
    }

    public final NullValueProvider findValueNullProvider(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty, PropertyMetadata propertyMetadata) throws JsonMappingException {
        if (settableBeanProperty != null) {
            return _findNullProvider(deserializationContext, settableBeanProperty, propertyMetadata.getValueNulls(), settableBeanProperty.getValueDeserializer());
        }
        return null;
    }

    @Deprecated
    public final Class<?> getValueClass() {
        return this._valueClass;
    }

    public JavaType getValueType() {
        return null;
    }

    public void handleMissingEndArrayForSingle(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        deserializationContext.reportWrongTokenException((JsonDeserializer<?>) this, JsonToken.END_ARRAY, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", handledType().getName());
    }

    public void handleUnknownProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        if (obj == null) {
            obj = handledType();
        }
        if (!deserializationContext.handleUnknownProperty(jsonParser, this, obj, str)) {
            jsonParser.skipChildren();
        }
    }

    public Class<?> handledType() {
        return this._valueClass;
    }

    public boolean isDefaultDeserializer(JsonDeserializer<?> jsonDeserializer) {
        return ClassUtil.isJacksonStdImpl((Object) jsonDeserializer);
    }

    public boolean isDefaultKeyDeserializer(KeyDeserializer keyDeserializer) {
        return ClassUtil.isJacksonStdImpl((Object) keyDeserializer);
    }

    public StdDeserializer(JavaType javaType) {
        this._valueClass = javaType == null ? Object.class : javaType.getRawClass();
    }

    public StdDeserializer(StdDeserializer<?> stdDeserializer) {
        this._valueClass = stdDeserializer._valueClass;
    }

    public Date _parseDate(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            if (_isEmptyOrTextualNull(str)) {
                return (Date) getNullValue(deserializationContext);
            }
            return deserializationContext.parseDate(str);
        } catch (IllegalArgumentException e) {
            return (Date) deserializationContext.handleWeirdStringValue(this._valueClass, str, "not a valid representation (error: %s)", ClassUtil.exceptionMessage(e));
        }
    }

    public final double _parseDoublePrimitive(DeserializationContext deserializationContext, String str) throws IOException {
        char charAt = str.charAt(0);
        if (charAt != '-') {
            if (charAt != 'I') {
                if (charAt == 'N' && _isNaN(str)) {
                    return Double.NaN;
                }
            } else if (_isPosInf(str)) {
                return Double.POSITIVE_INFINITY;
            }
        } else if (_isNegInf(str)) {
            return Double.NEGATIVE_INFINITY;
        }
        try {
            return parseDouble(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(this._valueClass, str, "not a valid double value (as String to convert)", new Object[0])).doubleValue();
        }
    }

    public final float _parseFloatPrimitive(DeserializationContext deserializationContext, String str) throws IOException {
        char charAt = str.charAt(0);
        if (charAt != '-') {
            if (charAt != 'I') {
                if (charAt == 'N' && _isNaN(str)) {
                    return Float.NaN;
                }
            } else if (_isPosInf(str)) {
                return Float.POSITIVE_INFINITY;
            }
        } else if (_isNegInf(str)) {
            return Float.NEGATIVE_INFINITY;
        }
        try {
            return Float.parseFloat(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(this._valueClass, str, "not a valid float value", new Object[0])).floatValue();
        }
    }

    public final int _parseIntPrimitive(DeserializationContext deserializationContext, String str) throws IOException {
        try {
            if (str.length() <= 9) {
                return NumberInput.parseInt(str);
            }
            long parseLong = Long.parseLong(str);
            return _intOverflow(parseLong) ? _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(this._valueClass, str, "Overflow: numeric value (%s) out of range of int (%d -%d)", str, Integer.valueOf(PKIFailureInfo.systemUnavail), Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER))).intValue() : (int) parseLong;
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(this._valueClass, str, "not a valid int value", new Object[0])).intValue();
        }
    }

    public final long _parseLongPrimitive(DeserializationContext deserializationContext, String str) throws IOException {
        try {
            return NumberInput.parseLong(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(this._valueClass, str, "not a valid long value", new Object[0])).longValue();
        }
    }
}
