package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;

public abstract class DatabindContext {
    private static final int MAX_ERROR_STR_LEN = 500;

    public String _colonConcat(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + ": " + str2;
    }

    public String _desc(String str) {
        if (str == null) {
            return "[N/A]";
        }
        return _truncate(str);
    }

    public final String _format(String str, Object... objArr) {
        if (objArr.length > 0) {
            return String.format(str, objArr);
        }
        return str;
    }

    public String _quotedString(String str) {
        if (str == null) {
            return "[N/A]";
        }
        return String.format("\"%s\"", new Object[]{_truncate(str)});
    }

    public final String _truncate(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= MAX_ERROR_STR_LEN) {
            return str;
        }
        return str.substring(0, MAX_ERROR_STR_LEN) + "]...[" + str.substring(str.length() - MAX_ERROR_STR_LEN);
    }

    public abstract boolean canOverrideAccessModifiers();

    public JavaType constructSpecializedType(JavaType javaType, Class<?> cls) {
        if (javaType.getRawClass() == cls) {
            return javaType;
        }
        return getConfig().constructSpecializedType(javaType, cls);
    }

    public JavaType constructType(Type type) {
        if (type == null) {
            return null;
        }
        return getTypeFactory().constructType(type);
    }

    public Converter<Object, Object> converterInstance(Annotated annotated, Object obj) throws JsonMappingException {
        Converter<?, ?> converter = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Converter) {
            return (Converter) obj;
        }
        if (obj instanceof Class) {
            Class<Converter.None> cls = (Class) obj;
            if (cls == Converter.None.class || ClassUtil.isBogusClass(cls)) {
                return null;
            }
            if (Converter.class.isAssignableFrom(cls)) {
                MapperConfig<?> config = getConfig();
                HandlerInstantiator handlerInstantiator = config.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    converter = handlerInstantiator.converterInstance(config, annotated, cls);
                }
                if (converter == null) {
                    return (Converter) ClassUtil.createInstance(cls, config.canOverrideAccessModifiers());
                }
                return converter;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }

    public abstract Class<?> getActiveView();

    public abstract AnnotationIntrospector getAnnotationIntrospector();

    public abstract Object getAttribute(Object obj);

    public abstract MapperConfig<?> getConfig();

    public abstract JsonFormat.Value getDefaultPropertyFormat(Class<?> cls);

    public abstract Locale getLocale();

    public abstract TimeZone getTimeZone();

    public abstract TypeFactory getTypeFactory();

    public abstract JsonMappingException invalidTypeIdException(JavaType javaType, String str, String str2);

    public abstract boolean isEnabled(MapperFeature mapperFeature);

    public ObjectIdGenerator<?> objectIdGeneratorInstance(Annotated annotated, ObjectIdInfo objectIdInfo) throws JsonMappingException {
        ObjectIdGenerator<?> objectIdGenerator;
        Class<? extends ObjectIdGenerator<?>> generatorType = objectIdInfo.getGeneratorType();
        MapperConfig<?> config = getConfig();
        HandlerInstantiator handlerInstantiator = config.getHandlerInstantiator();
        if (handlerInstantiator == null) {
            objectIdGenerator = null;
        } else {
            objectIdGenerator = handlerInstantiator.objectIdGeneratorInstance(config, annotated, generatorType);
        }
        if (objectIdGenerator == null) {
            objectIdGenerator = (ObjectIdGenerator) ClassUtil.createInstance(generatorType, config.canOverrideAccessModifiers());
        }
        return objectIdGenerator.forScope(objectIdInfo.getScope());
    }

    public ObjectIdResolver objectIdResolverInstance(Annotated annotated, ObjectIdInfo objectIdInfo) {
        ObjectIdResolver objectIdResolver;
        Class<? extends ObjectIdResolver> resolverType = objectIdInfo.getResolverType();
        MapperConfig<?> config = getConfig();
        HandlerInstantiator handlerInstantiator = config.getHandlerInstantiator();
        if (handlerInstantiator == null) {
            objectIdResolver = null;
        } else {
            objectIdResolver = handlerInstantiator.resolverIdGeneratorInstance(config, annotated, resolverType);
        }
        if (objectIdResolver == null) {
            return (ObjectIdResolver) ClassUtil.createInstance(resolverType, config.canOverrideAccessModifiers());
        }
        return objectIdResolver;
    }

    public abstract <T> T reportBadDefinition(JavaType javaType, String str) throws JsonMappingException;

    public <T> T reportBadDefinition(Class<?> cls, String str) throws JsonMappingException {
        return reportBadDefinition(constructType(cls), str);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    public JavaType resolveSubType(JavaType javaType, String str) throws JsonMappingException {
        if (str.indexOf(60) > 0) {
            JavaType constructFromCanonical = getTypeFactory().constructFromCanonical(str);
            if (constructFromCanonical.isTypeOrSubTypeOf(javaType.getRawClass())) {
                return constructFromCanonical;
            }
        } else {
            try {
                Class<?> findClass = getTypeFactory().findClass(str);
                if (javaType.isTypeOrSuperTypeOf(findClass)) {
                    return getTypeFactory().constructSpecializedType(javaType, findClass);
                }
            } catch (ClassNotFoundException unused) {
                return null;
            } catch (Exception e) {
                throw invalidTypeIdException(javaType, str, String.format("problem: (%s) %s", new Object[]{e.getClass().getName(), ClassUtil.exceptionMessage(e)}));
            }
        }
        throw invalidTypeIdException(javaType, str, "Not a subtype");
    }

    public abstract DatabindContext setAttribute(Object obj, Object obj2);
}
