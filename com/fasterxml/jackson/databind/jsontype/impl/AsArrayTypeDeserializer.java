package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;

public class AsArrayTypeDeserializer extends TypeDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;

    public AsArrayTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, String str, boolean z, JavaType javaType2) {
        super(javaType, typeIdResolver, str, z, javaType2);
    }

    public Object _deserialize(JsonParserSequence jsonParserSequence, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonToken;
        Object typeId;
        if (jsonParserSequence.canReadTypeId() && (typeId = jsonParserSequence.getTypeId()) != null) {
            return _deserializeWithNativeTypeId(jsonParserSequence, deserializationContext, typeId);
        }
        boolean isExpectedStartArrayToken = jsonParserSequence.isExpectedStartArrayToken();
        String _locateTypeId = _locateTypeId(jsonParserSequence, deserializationContext);
        JsonDeserializer<Object> _findDeserializer = _findDeserializer(deserializationContext, _locateTypeId);
        if (this._typeIdVisible && !_usesExternalId() && jsonParserSequence.getCurrentToken() == JsonToken.START_OBJECT) {
            TokenBuffer tokenBuffer = new TokenBuffer((ObjectCodec) null, false);
            tokenBuffer.writeStartObject();
            tokenBuffer.writeFieldName(this._typePropertyName);
            tokenBuffer.writeString(_locateTypeId);
            jsonParserSequence.clearCurrentToken();
            jsonParserSequence = JsonParserSequence.createFlattened(false, tokenBuffer.asParser(jsonParserSequence), jsonParserSequence);
            jsonParserSequence.nextToken();
        }
        Object deserialize = _findDeserializer.deserialize(jsonParserSequence, deserializationContext);
        if (isExpectedStartArrayToken && jsonParserSequence.nextToken() != (jsonToken = JsonToken.END_ARRAY)) {
            deserializationContext.reportWrongTokenException(baseType(), jsonToken, "expected closing END_ARRAY after type information and deserialized value", new Object[0]);
        }
        return deserialize;
    }

    public String _locateTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.isExpectedStartArrayToken()) {
            JsonToken nextToken = jsonParser.nextToken();
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            if (nextToken == jsonToken) {
                String text = jsonParser.getText();
                jsonParser.nextToken();
                return text;
            } else if (this._defaultImpl != null) {
                return this._idResolver.idFromBaseType();
            } else {
                deserializationContext.reportWrongTokenException(baseType(), jsonToken, "need JSON String that contains type id (for subtype of %s)", baseTypeName());
                return null;
            }
        } else if (this._defaultImpl != null) {
            return this._idResolver.idFromBaseType();
        } else {
            JavaType baseType = baseType();
            JsonToken jsonToken2 = JsonToken.START_ARRAY;
            deserializationContext.reportWrongTokenException(baseType, jsonToken2, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + baseTypeName(), new Object[0]);
            return null;
        }
    }

    public boolean _usesExternalId() {
        return false;
    }

    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public TypeDeserializer forProperty(BeanProperty beanProperty) {
        if (beanProperty == this._property) {
            return this;
        }
        return new AsArrayTypeDeserializer(this, beanProperty);
    }

    public JsonTypeInfo.As getTypeInclusion() {
        return JsonTypeInfo.As.WRAPPER_ARRAY;
    }

    public AsArrayTypeDeserializer(AsArrayTypeDeserializer asArrayTypeDeserializer, BeanProperty beanProperty) {
        super(asArrayTypeDeserializer, beanProperty);
    }
}
