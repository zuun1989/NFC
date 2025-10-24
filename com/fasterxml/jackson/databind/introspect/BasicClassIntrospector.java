package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.io.Serializable;

public class BasicClassIntrospector extends ClassIntrospector implements Serializable {
    protected static final BasicBeanDescription BOOLEAN_DESC;
    protected static final BasicBeanDescription INT_DESC;
    protected static final BasicBeanDescription LONG_DESC;
    protected static final BasicBeanDescription STRING_DESC;
    private static final long serialVersionUID = 1;
    protected final LRUMap<JavaType, BasicBeanDescription> _cachedFCA = new LRUMap<>(16, 64);

    static {
        Class<String> cls = String.class;
        STRING_DESC = BasicBeanDescription.forOtherUse((MapperConfig<?>) null, SimpleType.constructUnsafe(cls), AnnotatedClassResolver.createPrimordial(cls));
        Class cls2 = Boolean.TYPE;
        BOOLEAN_DESC = BasicBeanDescription.forOtherUse((MapperConfig<?>) null, SimpleType.constructUnsafe(cls2), AnnotatedClassResolver.createPrimordial(cls2));
        Class cls3 = Integer.TYPE;
        INT_DESC = BasicBeanDescription.forOtherUse((MapperConfig<?>) null, SimpleType.constructUnsafe(cls3), AnnotatedClassResolver.createPrimordial(cls3));
        Class cls4 = Long.TYPE;
        LONG_DESC = BasicBeanDescription.forOtherUse((MapperConfig<?>) null, SimpleType.constructUnsafe(cls4), AnnotatedClassResolver.createPrimordial(cls4));
    }

    public BasicBeanDescription _findStdJdkCollectionDesc(MapperConfig<?> mapperConfig, JavaType javaType) {
        if (_isStdJDKCollection(javaType)) {
            return BasicBeanDescription.forOtherUse(mapperConfig, javaType, _resolveAnnotatedClass(mapperConfig, javaType, mapperConfig));
        }
        return null;
    }

    public BasicBeanDescription _findStdTypeDesc(JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            if (rawClass == Boolean.TYPE) {
                return BOOLEAN_DESC;
            }
            if (rawClass == Integer.TYPE) {
                return INT_DESC;
            }
            if (rawClass == Long.TYPE) {
                return LONG_DESC;
            }
            return null;
        } else if (rawClass == String.class) {
            return STRING_DESC;
        } else {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r4.getRawClass();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean _isStdJDKCollection(com.fasterxml.jackson.databind.JavaType r4) {
        /*
            r3 = this;
            boolean r0 = r4.isContainerType()
            r1 = 0
            if (r0 == 0) goto L_0x003a
            boolean r0 = r4.isArrayType()
            if (r0 == 0) goto L_0x000e
            goto L_0x003a
        L_0x000e:
            java.lang.Class r4 = r4.getRawClass()
            java.lang.String r0 = com.fasterxml.jackson.databind.util.ClassUtil.getPackageName(r4)
            if (r0 == 0) goto L_0x003a
            java.lang.String r2 = "java.lang"
            boolean r2 = r0.startsWith(r2)
            if (r2 != 0) goto L_0x0028
            java.lang.String r2 = "java.util"
            boolean r0 = r0.startsWith(r2)
            if (r0 == 0) goto L_0x003a
        L_0x0028:
            java.lang.Class<java.util.Collection> r0 = java.util.Collection.class
            boolean r0 = r0.isAssignableFrom(r4)
            if (r0 != 0) goto L_0x0038
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            boolean r4 = r0.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x003a
        L_0x0038:
            r4 = 1
            return r4
        L_0x003a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.BasicClassIntrospector._isStdJDKCollection(com.fasterxml.jackson.databind.JavaType):boolean");
    }

    public AnnotatedClass _resolveAnnotatedClass(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        return AnnotatedClassResolver.resolve(mapperConfig, javaType, mixInResolver);
    }

    public AnnotatedClass _resolveAnnotatedWithoutSuperTypes(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        return AnnotatedClassResolver.resolveWithoutSuperTypes(mapperConfig, javaType, mixInResolver);
    }

    public POJOPropertiesCollector collectProperties(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver, boolean z, String str) {
        return constructPropertyCollector(mapperConfig, _resolveAnnotatedClass(mapperConfig, javaType, mixInResolver), javaType, z, str);
    }

    public POJOPropertiesCollector collectPropertiesWithBuilder(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver, boolean z) {
        AnnotationIntrospector annotationIntrospector;
        String str;
        AnnotatedClass _resolveAnnotatedClass = _resolveAnnotatedClass(mapperConfig, javaType, mixInResolver);
        JsonPOJOBuilder.Value value = null;
        if (mapperConfig.isAnnotationProcessingEnabled()) {
            annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        } else {
            annotationIntrospector = null;
        }
        if (annotationIntrospector != null) {
            value = annotationIntrospector.findPOJOBuilderConfig(_resolveAnnotatedClass);
        }
        if (value == null) {
            str = JsonPOJOBuilder.DEFAULT_WITH_PREFIX;
        } else {
            str = value.withPrefix;
        }
        return constructPropertyCollector(mapperConfig, _resolveAnnotatedClass, javaType, z, str);
    }

    public POJOPropertiesCollector constructPropertyCollector(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType, boolean z, String str) {
        return new POJOPropertiesCollector(mapperConfig, z, javaType, annotatedClass, str);
    }

    public ClassIntrospector copy() {
        return new BasicClassIntrospector();
    }

    public BasicBeanDescription forClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        BasicBeanDescription basicBeanDescription = this._cachedFCA.get(javaType);
        if (basicBeanDescription != null) {
            return basicBeanDescription;
        }
        BasicBeanDescription forOtherUse = BasicBeanDescription.forOtherUse(mapperConfig, javaType, _resolveAnnotatedClass(mapperConfig, javaType, mixInResolver));
        this._cachedFCA.put(javaType, forOtherUse);
        return forOtherUse;
    }

    public BasicBeanDescription forCreation(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        BasicBeanDescription _findStdJdkCollectionDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType);
        return _findStdJdkCollectionDesc == null ? BasicBeanDescription.forDeserialization(collectProperties(deserializationConfig, javaType, mixInResolver, false, "set")) : _findStdJdkCollectionDesc;
    }

    public BasicBeanDescription forDeserialization(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc == null) {
            _findStdTypeDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType);
            if (_findStdTypeDesc == null) {
                _findStdTypeDesc = BasicBeanDescription.forDeserialization(collectProperties(deserializationConfig, javaType, mixInResolver, false, "set"));
            }
            this._cachedFCA.putIfAbsent(javaType, _findStdTypeDesc);
        }
        return _findStdTypeDesc;
    }

    public BasicBeanDescription forDeserializationWithBuilder(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription forDeserialization = BasicBeanDescription.forDeserialization(collectPropertiesWithBuilder(deserializationConfig, javaType, mixInResolver, false));
        this._cachedFCA.putIfAbsent(javaType, forDeserialization);
        return forDeserialization;
    }

    public BasicBeanDescription forDirectClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        return _findStdTypeDesc == null ? BasicBeanDescription.forOtherUse(mapperConfig, javaType, _resolveAnnotatedWithoutSuperTypes(mapperConfig, javaType, mixInResolver)) : _findStdTypeDesc;
    }

    public BasicBeanDescription forSerialization(SerializationConfig serializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc == null) {
            _findStdTypeDesc = _findStdJdkCollectionDesc(serializationConfig, javaType);
            if (_findStdTypeDesc == null) {
                _findStdTypeDesc = BasicBeanDescription.forSerialization(collectProperties(serializationConfig, javaType, mixInResolver, true, "set"));
            }
            this._cachedFCA.putIfAbsent(javaType, _findStdTypeDesc);
        }
        return _findStdTypeDesc;
    }
}
