package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TypeNameIdResolver extends TypeIdResolverBase {
    protected final MapperConfig<?> _config;
    protected final Map<String, JavaType> _idToType;
    protected final Map<String, String> _typeToId;

    public TypeNameIdResolver(MapperConfig<?> mapperConfig, JavaType javaType, Map<String, String> map, Map<String, JavaType> map2) {
        super(javaType, mapperConfig.getTypeFactory());
        this._config = mapperConfig;
        this._typeToId = map;
        this._idToType = map2;
    }

    public static String _defaultTypeId(Class<?> cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return name;
        }
        return name.substring(lastIndexOf + 1);
    }

    public static TypeNameIdResolver construct(MapperConfig<?> mapperConfig, JavaType javaType, Collection<NamedType> collection, boolean z, boolean z2) {
        Map map;
        String str;
        JavaType javaType2;
        if (z != z2) {
            HashMap hashMap = null;
            if (z) {
                map = new HashMap();
            } else {
                map = null;
            }
            if (z2) {
                hashMap = new HashMap();
                map = new TreeMap();
            }
            if (collection != null) {
                for (NamedType next : collection) {
                    Class<?> type = next.getType();
                    if (next.hasName()) {
                        str = next.getName();
                    } else {
                        str = _defaultTypeId(type);
                    }
                    if (z) {
                        map.put(type.getName(), str);
                    }
                    if (z2 && ((javaType2 = (JavaType) hashMap.get(str)) == null || !type.isAssignableFrom(javaType2.getRawClass()))) {
                        hashMap.put(str, mapperConfig.constructType(type));
                    }
                }
            }
            return new TypeNameIdResolver(mapperConfig, javaType, map, hashMap);
        }
        throw new IllegalArgumentException();
    }

    public JavaType _typeFromId(String str) {
        return this._idToType.get(str);
    }

    public String getDescForKnownTypeIds() {
        return new TreeSet(this._idToType.keySet()).toString();
    }

    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.NAME;
    }

    public String idFromClass(Class<?> cls) {
        String str;
        if (cls == null) {
            return null;
        }
        Class<?> rawClass = this._typeFactory.constructType((Type) cls).getRawClass();
        String name = rawClass.getName();
        synchronized (this._typeToId) {
            try {
                str = this._typeToId.get(name);
                if (str == null) {
                    if (this._config.isAnnotationProcessingEnabled()) {
                        str = this._config.getAnnotationIntrospector().findTypeName(this._config.introspectClassAnnotations(rawClass).getClassInfo());
                    }
                    if (str == null) {
                        str = _defaultTypeId(rawClass);
                    }
                    this._typeToId.put(name, str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public String idFromValue(Object obj) {
        return idFromClass(obj.getClass());
    }

    public String idFromValueAndType(Object obj, Class<?> cls) {
        if (obj == null) {
            return idFromClass(cls);
        }
        return idFromValue(obj);
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", new Object[]{getClass().getName(), this._idToType});
    }

    public JavaType typeFromId(DatabindContext databindContext, String str) {
        return _typeFromId(str);
    }
}
