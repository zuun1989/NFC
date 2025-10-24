package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.ext.Java7Support;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class JacksonAnnotationIntrospector extends AnnotationIntrospector implements Serializable {
    private static final Class<? extends Annotation>[] ANNOTATIONS_TO_INFER_DESER = {JsonDeserialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class, JsonMerge.class};
    private static final Class<? extends Annotation>[] ANNOTATIONS_TO_INFER_SER = {JsonSerialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonRawValue.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class};
    private static final Java7Support _java7Helper;
    private static final long serialVersionUID = 1;
    protected transient LRUMap<Class<?>, Boolean> _annotationsInside = new LRUMap<>(48, 48);
    protected boolean _cfgConstructorPropertiesImpliesCreator = true;

    /* renamed from: com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$databind$annotation$JsonSerialize$Inclusion;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fasterxml.jackson.databind.annotation.JsonSerialize$Inclusion[] r0 = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fasterxml$jackson$databind$annotation$JsonSerialize$Inclusion = r0
                com.fasterxml.jackson.databind.annotation.JsonSerialize$Inclusion r1 = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$databind$annotation$JsonSerialize$Inclusion     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.databind.annotation.JsonSerialize$Inclusion r1 = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$databind$annotation$JsonSerialize$Inclusion     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.databind.annotation.JsonSerialize$Inclusion r1 = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$databind$annotation$JsonSerialize$Inclusion     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.databind.annotation.JsonSerialize$Inclusion r1 = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$databind$annotation$JsonSerialize$Inclusion     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.databind.annotation.JsonSerialize$Inclusion r1 = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.DEFAULT_INCLUSION     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        Java7Support java7Support;
        try {
            java7Support = Java7Support.instance();
        } catch (Throwable unused) {
            java7Support = null;
        }
        _java7Helper = java7Support;
    }

    private final Boolean _findSortAlpha(Annotated annotated) {
        JsonPropertyOrder _findAnnotation = _findAnnotation(annotated, JsonPropertyOrder.class);
        if (_findAnnotation == null || !_findAnnotation.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    private boolean _primitiveAndWrapper(Class<?> cls, Class<?> cls2) {
        if (cls.isPrimitive()) {
            if (cls == ClassUtil.primitiveType(cls2)) {
                return true;
            }
            return false;
        } else if (!cls2.isPrimitive()) {
            return false;
        } else {
            if (cls2 == ClassUtil.primitiveType(cls)) {
                return true;
            }
            return false;
        }
    }

    private JsonInclude.Value _refinePropertyInclusion(Annotated annotated, JsonInclude.Value value) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotated, JsonSerialize.class);
        if (jsonSerialize != null) {
            int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$databind$annotation$JsonSerialize$Inclusion[jsonSerialize.include().ordinal()];
            if (i == 1) {
                return value.withValueInclusion(JsonInclude.Include.ALWAYS);
            }
            if (i == 2) {
                return value.withValueInclusion(JsonInclude.Include.NON_NULL);
            }
            if (i == 3) {
                return value.withValueInclusion(JsonInclude.Include.NON_DEFAULT);
            }
            if (i == 4) {
                return value.withValueInclusion(JsonInclude.Include.NON_EMPTY);
            }
        }
        return value;
    }

    public Class<?> _classIfExplicit(Class<?> cls) {
        if (cls == null || ClassUtil.isBogusClass(cls)) {
            return null;
        }
        return cls;
    }

    public StdTypeResolverBuilder _constructNoTypeResolverBuilder() {
        return StdTypeResolverBuilder.noTypeInfoBuilder();
    }

    public StdTypeResolverBuilder _constructStdTypeResolverBuilder() {
        return new StdTypeResolverBuilder();
    }

    public BeanPropertyWriter _constructVirtualProperty(JsonAppend.Attr attr, MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        PropertyMetadata propertyMetadata = attr.required() ? PropertyMetadata.STD_REQUIRED : PropertyMetadata.STD_OPTIONAL;
        String value = attr.value();
        PropertyName _propertyName = _propertyName(attr.propName(), attr.propNamespace());
        if (!_propertyName.hasSimpleName()) {
            _propertyName = PropertyName.construct(value);
        }
        return AttributePropertyWriter.construct(value, SimpleBeanPropertyDefinition.construct(mapperConfig, (AnnotatedMember) new VirtualAnnotatedMember(annotatedClass, annotatedClass.getRawType(), value, javaType), _propertyName, propertyMetadata, attr.include()), annotatedClass.getAnnotations(), javaType);
    }

    public PropertyName _findConstructorName(Annotated annotated) {
        Java7Support java7Support;
        PropertyName findConstructorName;
        if (!(annotated instanceof AnnotatedParameter)) {
            return null;
        }
        AnnotatedParameter annotatedParameter = (AnnotatedParameter) annotated;
        if (annotatedParameter.getOwner() == null || (java7Support = _java7Helper) == null || (findConstructorName = java7Support.findConstructorName(annotatedParameter)) == null) {
            return null;
        }
        return findConstructorName;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.fasterxml.jackson.databind.cfg.MapperConfig<?>, com.fasterxml.jackson.databind.cfg.MapperConfig] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder<?> _findTypeResolver(com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5, com.fasterxml.jackson.databind.introspect.Annotated r6, com.fasterxml.jackson.databind.JavaType r7) {
        /*
            r4 = this;
            java.lang.Class<com.fasterxml.jackson.annotation.JsonTypeInfo> r0 = com.fasterxml.jackson.annotation.JsonTypeInfo.class
            java.lang.annotation.Annotation r0 = r4._findAnnotation(r6, r0)
            com.fasterxml.jackson.annotation.JsonTypeInfo r0 = (com.fasterxml.jackson.annotation.JsonTypeInfo) r0
            java.lang.Class<com.fasterxml.jackson.databind.annotation.JsonTypeResolver> r1 = com.fasterxml.jackson.databind.annotation.JsonTypeResolver.class
            java.lang.annotation.Annotation r1 = r4._findAnnotation(r6, r1)
            com.fasterxml.jackson.databind.annotation.JsonTypeResolver r1 = (com.fasterxml.jackson.databind.annotation.JsonTypeResolver) r1
            r2 = 0
            if (r1 == 0) goto L_0x001f
            if (r0 != 0) goto L_0x0016
            return r2
        L_0x0016:
            java.lang.Class r1 = r1.value()
            com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder r1 = r5.typeResolverBuilderInstance(r6, r1)
            goto L_0x0033
        L_0x001f:
            if (r0 != 0) goto L_0x0022
            return r2
        L_0x0022:
            com.fasterxml.jackson.annotation.JsonTypeInfo$Id r1 = r0.use()
            com.fasterxml.jackson.annotation.JsonTypeInfo$Id r3 = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NONE
            if (r1 != r3) goto L_0x002f
            com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder r5 = r4._constructNoTypeResolverBuilder()
            return r5
        L_0x002f:
            com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder r1 = r4._constructStdTypeResolverBuilder()
        L_0x0033:
            java.lang.Class<com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver> r3 = com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver.class
            java.lang.annotation.Annotation r3 = r4._findAnnotation(r6, r3)
            com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver r3 = (com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver) r3
            if (r3 != 0) goto L_0x003e
            goto L_0x0046
        L_0x003e:
            java.lang.Class r2 = r3.value()
            com.fasterxml.jackson.databind.jsontype.TypeIdResolver r2 = r5.typeIdResolverInstance(r6, r2)
        L_0x0046:
            if (r2 == 0) goto L_0x004b
            r2.init(r7)
        L_0x004b:
            com.fasterxml.jackson.annotation.JsonTypeInfo$Id r5 = r0.use()
            com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder r5 = r1.init(r5, r2)
            com.fasterxml.jackson.annotation.JsonTypeInfo$As r7 = r0.include()
            com.fasterxml.jackson.annotation.JsonTypeInfo$As r1 = com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXTERNAL_PROPERTY
            if (r7 != r1) goto L_0x0061
            boolean r6 = r6 instanceof com.fasterxml.jackson.databind.introspect.AnnotatedClass
            if (r6 == 0) goto L_0x0061
            com.fasterxml.jackson.annotation.JsonTypeInfo$As r7 = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY
        L_0x0061:
            com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder r5 = r5.inclusion(r7)
            java.lang.String r6 = r0.property()
            com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder r5 = r5.typeProperty(r6)
            java.lang.Class r6 = r0.defaultImpl()
            java.lang.Class<com.fasterxml.jackson.annotation.JsonTypeInfo$None> r7 = com.fasterxml.jackson.annotation.JsonTypeInfo.None.class
            if (r6 == r7) goto L_0x007f
            boolean r7 = r6.isAnnotation()
            if (r7 != 0) goto L_0x007f
            com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder r5 = r5.defaultImpl(r6)
        L_0x007f:
            boolean r6 = r0.visible()
            com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder r5 = r5.typeIdVisibility(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector._findTypeResolver(com.fasterxml.jackson.databind.cfg.MapperConfig, com.fasterxml.jackson.databind.introspect.Annotated, com.fasterxml.jackson.databind.JavaType):com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder");
    }

    public boolean _isIgnorable(Annotated annotated) {
        Boolean findTransient;
        JsonIgnore _findAnnotation = _findAnnotation(annotated, JsonIgnore.class);
        if (_findAnnotation != null) {
            return _findAnnotation.value();
        }
        Java7Support java7Support = _java7Helper;
        if (java7Support == null || (findTransient = java7Support.findTransient(annotated)) == null) {
            return false;
        }
        return findTransient.booleanValue();
    }

    public PropertyName _propertyName(String str, String str2) {
        if (str.isEmpty()) {
            return PropertyName.USE_DEFAULT;
        }
        if (str2 == null || str2.isEmpty()) {
            return PropertyName.construct(str);
        }
        return PropertyName.construct(str, str2);
    }

    public void findAndAddVirtualProperties(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, List<BeanPropertyWriter> list) {
        JsonAppend jsonAppend = (JsonAppend) _findAnnotation(annotatedClass, JsonAppend.class);
        if (jsonAppend != null) {
            boolean prepend = jsonAppend.prepend();
            JsonAppend.Attr[] attrs = jsonAppend.attrs();
            int length = attrs.length;
            JavaType javaType = null;
            for (int i = 0; i < length; i++) {
                if (javaType == null) {
                    javaType = mapperConfig.constructType((Class<?>) Object.class);
                }
                BeanPropertyWriter _constructVirtualProperty = _constructVirtualProperty(attrs[i], mapperConfig, annotatedClass, javaType);
                if (prepend) {
                    list.add(i, _constructVirtualProperty);
                } else {
                    list.add(_constructVirtualProperty);
                }
            }
            JsonAppend.Prop[] props = jsonAppend.props();
            int length2 = props.length;
            for (int i2 = 0; i2 < length2; i2++) {
                BeanPropertyWriter _constructVirtualProperty2 = _constructVirtualProperty(props[i2], mapperConfig, annotatedClass);
                if (prepend) {
                    list.add(i2, _constructVirtualProperty2);
                } else {
                    list.add(_constructVirtualProperty2);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.fasterxml.jackson.databind.introspect.VisibilityChecker, com.fasterxml.jackson.databind.introspect.VisibilityChecker<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.introspect.VisibilityChecker<?> findAutoDetectVisibility(com.fasterxml.jackson.databind.introspect.AnnotatedClass r2, com.fasterxml.jackson.databind.introspect.VisibilityChecker<?> r3) {
        /*
            r1 = this;
            java.lang.Class<com.fasterxml.jackson.annotation.JsonAutoDetect> r0 = com.fasterxml.jackson.annotation.JsonAutoDetect.class
            java.lang.annotation.Annotation r2 = r1._findAnnotation(r2, r0)
            com.fasterxml.jackson.annotation.JsonAutoDetect r2 = (com.fasterxml.jackson.annotation.JsonAutoDetect) r2
            if (r2 != 0) goto L_0x000b
            goto L_0x000f
        L_0x000b:
            com.fasterxml.jackson.databind.introspect.VisibilityChecker r3 = r3.with((com.fasterxml.jackson.annotation.JsonAutoDetect) r2)
        L_0x000f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector.findAutoDetectVisibility(com.fasterxml.jackson.databind.introspect.AnnotatedClass, com.fasterxml.jackson.databind.introspect.VisibilityChecker):com.fasterxml.jackson.databind.introspect.VisibilityChecker");
    }

    public String findClassDescription(AnnotatedClass annotatedClass) {
        JsonClassDescription _findAnnotation = _findAnnotation(annotatedClass, JsonClassDescription.class);
        if (_findAnnotation == null) {
            return null;
        }
        return _findAnnotation.value();
    }

    public Object findContentDeserializer(Annotated annotated) {
        Class<? extends JsonDeserializer> contentUsing;
        JsonDeserialize jsonDeserialize = (JsonDeserialize) _findAnnotation(annotated, JsonDeserialize.class);
        if (jsonDeserialize == null || (contentUsing = jsonDeserialize.contentUsing()) == JsonDeserializer.None.class) {
            return null;
        }
        return contentUsing;
    }

    public Object findContentSerializer(Annotated annotated) {
        Class<? extends JsonSerializer> contentUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotated, JsonSerialize.class);
        if (jsonSerialize == null || (contentUsing = jsonSerialize.contentUsing()) == JsonSerializer.None.class) {
            return null;
        }
        return contentUsing;
    }

    public JsonCreator.Mode findCreatorAnnotation(MapperConfig<?> mapperConfig, Annotated annotated) {
        Java7Support java7Support;
        Boolean hasCreatorAnnotation;
        JsonCreator _findAnnotation = _findAnnotation(annotated, JsonCreator.class);
        if (_findAnnotation != null) {
            return _findAnnotation.mode();
        }
        if (!this._cfgConstructorPropertiesImpliesCreator || !mapperConfig.isEnabled(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES) || !(annotated instanceof AnnotatedConstructor) || (java7Support = _java7Helper) == null || (hasCreatorAnnotation = java7Support.hasCreatorAnnotation(annotated)) == null || !hasCreatorAnnotation.booleanValue()) {
            return null;
        }
        return JsonCreator.Mode.PROPERTIES;
    }

    @Deprecated
    public JsonCreator.Mode findCreatorBinding(Annotated annotated) {
        JsonCreator _findAnnotation = _findAnnotation(annotated, JsonCreator.class);
        if (_findAnnotation == null) {
            return null;
        }
        return _findAnnotation.mode();
    }

    public Enum<?> findDefaultEnumValue(Class<Enum<?>> cls) {
        return ClassUtil.findFirstAnnotatedEnumValue(cls, JsonEnumDefaultValue.class);
    }

    public Object findDeserializationContentConverter(AnnotatedMember annotatedMember) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) _findAnnotation(annotatedMember, JsonDeserialize.class);
        if (jsonDeserialize == null) {
            return null;
        }
        return _classIfExplicit(jsonDeserialize.contentConverter(), Converter.None.class);
    }

    @Deprecated
    public Class<?> findDeserializationContentType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public Object findDeserializationConverter(Annotated annotated) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) _findAnnotation(annotated, JsonDeserialize.class);
        if (jsonDeserialize == null) {
            return null;
        }
        return _classIfExplicit(jsonDeserialize.converter(), Converter.None.class);
    }

    @Deprecated
    public Class<?> findDeserializationKeyType(Annotated annotated, JavaType javaType) {
        return null;
    }

    @Deprecated
    public Class<?> findDeserializationType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public Object findDeserializer(Annotated annotated) {
        Class<? extends JsonDeserializer> using;
        JsonDeserialize jsonDeserialize = (JsonDeserialize) _findAnnotation(annotated, JsonDeserialize.class);
        if (jsonDeserialize == null || (using = jsonDeserialize.using()) == JsonDeserializer.None.class) {
            return null;
        }
        return using;
    }

    @Deprecated
    public String findEnumValue(Enum<?> enumR) {
        JsonProperty annotation;
        String value;
        try {
            Field field = enumR.getClass().getField(enumR.name());
            if (!(field == null || (annotation = field.getAnnotation(JsonProperty.class)) == null || (value = annotation.value()) == null || value.isEmpty())) {
                return value;
            }
        } catch (NoSuchFieldException | SecurityException unused) {
        }
        return enumR.name();
    }

    public String[] findEnumValues(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        JsonProperty annotation;
        HashMap hashMap = null;
        for (Field field : ClassUtil.getDeclaredFields(cls)) {
            if (field.isEnumConstant() && (annotation = field.getAnnotation(JsonProperty.class)) != null) {
                String value = annotation.value();
                if (!value.isEmpty()) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(field.getName(), value);
                }
            }
        }
        if (hashMap != null) {
            int length = enumArr.length;
            for (int i = 0; i < length; i++) {
                String str = (String) hashMap.get(enumArr[i].name());
                if (str != null) {
                    strArr[i] = str;
                }
            }
        }
        return strArr;
    }

    public Object findFilterId(Annotated annotated) {
        JsonFilter _findAnnotation = _findAnnotation(annotated, JsonFilter.class);
        if (_findAnnotation == null) {
            return null;
        }
        String value = _findAnnotation.value();
        if (value.length() > 0) {
            return value;
        }
        return null;
    }

    public JsonFormat.Value findFormat(Annotated annotated) {
        JsonFormat _findAnnotation = _findAnnotation(annotated, JsonFormat.class);
        if (_findAnnotation == null) {
            return null;
        }
        return new JsonFormat.Value(_findAnnotation);
    }

    public String findImplicitPropertyName(AnnotatedMember annotatedMember) {
        PropertyName _findConstructorName = _findConstructorName(annotatedMember);
        if (_findConstructorName == null) {
            return null;
        }
        return _findConstructorName.getSimpleName();
    }

    public JacksonInject.Value findInjectableValue(AnnotatedMember annotatedMember) {
        String str;
        JacksonInject _findAnnotation = _findAnnotation(annotatedMember, JacksonInject.class);
        if (_findAnnotation == null) {
            return null;
        }
        JacksonInject.Value from = JacksonInject.Value.from(_findAnnotation);
        if (from.hasId()) {
            return from;
        }
        if (!(annotatedMember instanceof AnnotatedMethod)) {
            str = annotatedMember.getRawType().getName();
        } else {
            AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
            if (annotatedMethod.getParameterCount() == 0) {
                str = annotatedMember.getRawType().getName();
            } else {
                str = annotatedMethod.getRawParameterType(0).getName();
            }
        }
        return from.withId(str);
    }

    @Deprecated
    public Object findInjectableValueId(AnnotatedMember annotatedMember) {
        JacksonInject.Value findInjectableValue = findInjectableValue(annotatedMember);
        if (findInjectableValue == null) {
            return null;
        }
        return findInjectableValue.getId();
    }

    public Object findKeyDeserializer(Annotated annotated) {
        Class<? extends KeyDeserializer> keyUsing;
        JsonDeserialize jsonDeserialize = (JsonDeserialize) _findAnnotation(annotated, JsonDeserialize.class);
        if (jsonDeserialize == null || (keyUsing = jsonDeserialize.keyUsing()) == KeyDeserializer.None.class) {
            return null;
        }
        return keyUsing;
    }

    public Object findKeySerializer(Annotated annotated) {
        Class<? extends JsonSerializer> keyUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotated, JsonSerialize.class);
        if (jsonSerialize == null || (keyUsing = jsonSerialize.keyUsing()) == JsonSerializer.None.class) {
            return null;
        }
        return keyUsing;
    }

    public Boolean findMergeInfo(Annotated annotated) {
        JsonMerge _findAnnotation = _findAnnotation(annotated, JsonMerge.class);
        if (_findAnnotation == null) {
            return null;
        }
        return _findAnnotation.value().asBoolean();
    }

    public PropertyName findNameForDeserialization(Annotated annotated) {
        boolean z;
        JsonSetter _findAnnotation = _findAnnotation(annotated, JsonSetter.class);
        if (_findAnnotation != null) {
            String value = _findAnnotation.value();
            if (!value.isEmpty()) {
                return PropertyName.construct(value);
            }
            z = true;
        } else {
            z = false;
        }
        JsonProperty _findAnnotation2 = _findAnnotation(annotated, JsonProperty.class);
        if (_findAnnotation2 != null) {
            return PropertyName.construct(_findAnnotation2.value());
        }
        if (z || _hasOneOf(annotated, ANNOTATIONS_TO_INFER_DESER)) {
            return PropertyName.USE_DEFAULT;
        }
        return null;
    }

    public PropertyName findNameForSerialization(Annotated annotated) {
        boolean z;
        JsonGetter _findAnnotation = _findAnnotation(annotated, JsonGetter.class);
        if (_findAnnotation != null) {
            String value = _findAnnotation.value();
            if (!value.isEmpty()) {
                return PropertyName.construct(value);
            }
            z = true;
        } else {
            z = false;
        }
        JsonProperty _findAnnotation2 = _findAnnotation(annotated, JsonProperty.class);
        if (_findAnnotation2 != null) {
            return PropertyName.construct(_findAnnotation2.value());
        }
        if (z || _hasOneOf(annotated, ANNOTATIONS_TO_INFER_SER)) {
            return PropertyName.USE_DEFAULT;
        }
        return null;
    }

    public Object findNamingStrategy(AnnotatedClass annotatedClass) {
        JsonNaming jsonNaming = (JsonNaming) _findAnnotation(annotatedClass, JsonNaming.class);
        if (jsonNaming == null) {
            return null;
        }
        return jsonNaming.value();
    }

    public Object findNullSerializer(Annotated annotated) {
        Class<? extends JsonSerializer> nullsUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotated, JsonSerialize.class);
        if (jsonSerialize == null || (nullsUsing = jsonSerialize.nullsUsing()) == JsonSerializer.None.class) {
            return null;
        }
        return nullsUsing;
    }

    public ObjectIdInfo findObjectIdInfo(Annotated annotated) {
        JsonIdentityInfo _findAnnotation = _findAnnotation(annotated, JsonIdentityInfo.class);
        if (_findAnnotation == null || _findAnnotation.generator() == ObjectIdGenerators.None.class) {
            return null;
        }
        return new ObjectIdInfo(PropertyName.construct(_findAnnotation.property()), (Class<?>) _findAnnotation.scope(), (Class<? extends ObjectIdGenerator<?>>) _findAnnotation.generator(), (Class<? extends ObjectIdResolver>) _findAnnotation.resolver());
    }

    public ObjectIdInfo findObjectReferenceInfo(Annotated annotated, ObjectIdInfo objectIdInfo) {
        JsonIdentityReference _findAnnotation = _findAnnotation(annotated, JsonIdentityReference.class);
        if (_findAnnotation == null) {
            return objectIdInfo;
        }
        if (objectIdInfo == null) {
            objectIdInfo = ObjectIdInfo.empty();
        }
        return objectIdInfo.withAlwaysAsId(_findAnnotation.alwaysAsId());
    }

    public Class<?> findPOJOBuilder(AnnotatedClass annotatedClass) {
        JsonDeserialize jsonDeserialize = (JsonDeserialize) _findAnnotation(annotatedClass, JsonDeserialize.class);
        if (jsonDeserialize == null) {
            return null;
        }
        return _classIfExplicit(jsonDeserialize.builder());
    }

    public JsonPOJOBuilder.Value findPOJOBuilderConfig(AnnotatedClass annotatedClass) {
        JsonPOJOBuilder jsonPOJOBuilder = (JsonPOJOBuilder) _findAnnotation(annotatedClass, JsonPOJOBuilder.class);
        if (jsonPOJOBuilder == null) {
            return null;
        }
        return new JsonPOJOBuilder.Value(jsonPOJOBuilder);
    }

    public JsonProperty.Access findPropertyAccess(Annotated annotated) {
        JsonProperty _findAnnotation = _findAnnotation(annotated, JsonProperty.class);
        if (_findAnnotation != null) {
            return _findAnnotation.access();
        }
        return null;
    }

    public List<PropertyName> findPropertyAliases(Annotated annotated) {
        JsonAlias _findAnnotation = _findAnnotation(annotated, JsonAlias.class);
        if (_findAnnotation == null) {
            return null;
        }
        if (r0 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(r0);
        for (String construct : _findAnnotation.value()) {
            arrayList.add(PropertyName.construct(construct));
        }
        return arrayList;
    }

    public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.getContentType() != null) {
            return _findTypeResolver(mapperConfig, annotatedMember, javaType);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + javaType + ")");
    }

    public String findPropertyDefaultValue(Annotated annotated) {
        JsonProperty _findAnnotation = _findAnnotation(annotated, JsonProperty.class);
        if (_findAnnotation == null) {
            return null;
        }
        String defaultValue = _findAnnotation.defaultValue();
        if (defaultValue.isEmpty()) {
            return null;
        }
        return defaultValue;
    }

    public String findPropertyDescription(Annotated annotated) {
        JsonPropertyDescription _findAnnotation = _findAnnotation(annotated, JsonPropertyDescription.class);
        if (_findAnnotation == null) {
            return null;
        }
        return _findAnnotation.value();
    }

    public JsonIgnoreProperties.Value findPropertyIgnorals(Annotated annotated) {
        JsonIgnoreProperties _findAnnotation = _findAnnotation(annotated, JsonIgnoreProperties.class);
        if (_findAnnotation == null) {
            return JsonIgnoreProperties.Value.empty();
        }
        return JsonIgnoreProperties.Value.from(_findAnnotation);
    }

    public JsonInclude.Value findPropertyInclusion(Annotated annotated) {
        JsonInclude.Value value;
        JsonInclude _findAnnotation = _findAnnotation(annotated, JsonInclude.class);
        if (_findAnnotation == null) {
            value = JsonInclude.Value.empty();
        } else {
            value = JsonInclude.Value.from(_findAnnotation);
        }
        if (value.getValueInclusion() == JsonInclude.Include.USE_DEFAULTS) {
            return _refinePropertyInclusion(annotated, value);
        }
        return value;
    }

    public Integer findPropertyIndex(Annotated annotated) {
        int index;
        JsonProperty _findAnnotation = _findAnnotation(annotated, JsonProperty.class);
        if (_findAnnotation == null || (index = _findAnnotation.index()) == -1) {
            return null;
        }
        return Integer.valueOf(index);
    }

    public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.isContainerType() || javaType.isReferenceType()) {
            return null;
        }
        return _findTypeResolver(mapperConfig, annotatedMember, javaType);
    }

    public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        JsonManagedReference _findAnnotation = _findAnnotation(annotatedMember, JsonManagedReference.class);
        if (_findAnnotation != null) {
            return AnnotationIntrospector.ReferenceProperty.managed(_findAnnotation.value());
        }
        JsonBackReference _findAnnotation2 = _findAnnotation(annotatedMember, JsonBackReference.class);
        if (_findAnnotation2 != null) {
            return AnnotationIntrospector.ReferenceProperty.back(_findAnnotation2.value());
        }
        return null;
    }

    public PropertyName findRootName(AnnotatedClass annotatedClass) {
        JsonRootName _findAnnotation = _findAnnotation(annotatedClass, JsonRootName.class);
        String str = null;
        if (_findAnnotation == null) {
            return null;
        }
        String namespace = _findAnnotation.namespace();
        if (namespace == null || namespace.length() != 0) {
            str = namespace;
        }
        return PropertyName.construct(_findAnnotation.value(), str);
    }

    public Object findSerializationContentConverter(AnnotatedMember annotatedMember) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotatedMember, JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return _classIfExplicit(jsonSerialize.contentConverter(), Converter.None.class);
    }

    @Deprecated
    public Class<?> findSerializationContentType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public Object findSerializationConverter(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotated, JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return _classIfExplicit(jsonSerialize.converter(), Converter.None.class);
    }

    @Deprecated
    public Class<?> findSerializationKeyType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public String[] findSerializationPropertyOrder(AnnotatedClass annotatedClass) {
        JsonPropertyOrder _findAnnotation = _findAnnotation(annotatedClass, JsonPropertyOrder.class);
        if (_findAnnotation == null) {
            return null;
        }
        return _findAnnotation.value();
    }

    public Boolean findSerializationSortAlphabetically(Annotated annotated) {
        return _findSortAlpha(annotated);
    }

    @Deprecated
    public Class<?> findSerializationType(Annotated annotated) {
        return null;
    }

    public JsonSerialize.Typing findSerializationTyping(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotated, JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return jsonSerialize.typing();
    }

    public Object findSerializer(Annotated annotated) {
        Class<? extends JsonSerializer> using;
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotated, JsonSerialize.class);
        if (jsonSerialize != null && (using = jsonSerialize.using()) != JsonSerializer.None.class) {
            return using;
        }
        JsonRawValue _findAnnotation = _findAnnotation(annotated, JsonRawValue.class);
        if (_findAnnotation == null || !_findAnnotation.value()) {
            return null;
        }
        return new RawSerializer(annotated.getRawType());
    }

    public JsonSetter.Value findSetterInfo(Annotated annotated) {
        return JsonSetter.Value.from(_findAnnotation(annotated, JsonSetter.class));
    }

    public List<NamedType> findSubtypes(Annotated annotated) {
        JsonSubTypes _findAnnotation = _findAnnotation(annotated, JsonSubTypes.class);
        if (_findAnnotation == null) {
            return null;
        }
        JsonSubTypes.Type[] value = _findAnnotation.value();
        ArrayList arrayList = new ArrayList(value.length);
        for (JsonSubTypes.Type type : value) {
            arrayList.add(new NamedType(type.value(), type.name()));
        }
        return arrayList;
    }

    public String findTypeName(AnnotatedClass annotatedClass) {
        JsonTypeName _findAnnotation = _findAnnotation(annotatedClass, JsonTypeName.class);
        if (_findAnnotation == null) {
            return null;
        }
        return _findAnnotation.value();
    }

    public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return _findTypeResolver(mapperConfig, annotatedClass, javaType);
    }

    public NameTransformer findUnwrappingNameTransformer(AnnotatedMember annotatedMember) {
        JsonUnwrapped _findAnnotation = _findAnnotation(annotatedMember, JsonUnwrapped.class);
        if (_findAnnotation == null || !_findAnnotation.enabled()) {
            return null;
        }
        return NameTransformer.simpleTransformer(_findAnnotation.prefix(), _findAnnotation.suffix());
    }

    public Object findValueInstantiator(AnnotatedClass annotatedClass) {
        JsonValueInstantiator jsonValueInstantiator = (JsonValueInstantiator) _findAnnotation(annotatedClass, JsonValueInstantiator.class);
        if (jsonValueInstantiator == null) {
            return null;
        }
        return jsonValueInstantiator.value();
    }

    public Class<?>[] findViews(Annotated annotated) {
        JsonView _findAnnotation = _findAnnotation(annotated, JsonView.class);
        if (_findAnnotation == null) {
            return null;
        }
        return _findAnnotation.value();
    }

    public Boolean hasAnyGetter(Annotated annotated) {
        JsonAnyGetter _findAnnotation = _findAnnotation(annotated, JsonAnyGetter.class);
        if (_findAnnotation == null) {
            return null;
        }
        return Boolean.valueOf(_findAnnotation.enabled());
    }

    @Deprecated
    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return _hasAnnotation(annotatedMethod, JsonAnyGetter.class);
    }

    public Boolean hasAnySetter(Annotated annotated) {
        JsonAnySetter _findAnnotation = _findAnnotation(annotated, JsonAnySetter.class);
        if (_findAnnotation == null) {
            return null;
        }
        return Boolean.valueOf(_findAnnotation.enabled());
    }

    @Deprecated
    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return _hasAnnotation(annotatedMethod, JsonAnySetter.class);
    }

    public Boolean hasAsValue(Annotated annotated) {
        JsonValue _findAnnotation = _findAnnotation(annotated, JsonValue.class);
        if (_findAnnotation == null) {
            return null;
        }
        return Boolean.valueOf(_findAnnotation.value());
    }

    @Deprecated
    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        JsonValue _findAnnotation = _findAnnotation(annotatedMethod, JsonValue.class);
        if (_findAnnotation == null || !_findAnnotation.value()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean hasCreatorAnnotation(Annotated annotated) {
        Java7Support java7Support;
        Boolean hasCreatorAnnotation;
        JsonCreator _findAnnotation = _findAnnotation(annotated, JsonCreator.class);
        if (_findAnnotation != null) {
            if (_findAnnotation.mode() != JsonCreator.Mode.DISABLED) {
                return true;
            }
            return false;
        } else if (!this._cfgConstructorPropertiesImpliesCreator || !(annotated instanceof AnnotatedConstructor) || (java7Support = _java7Helper) == null || (hasCreatorAnnotation = java7Support.hasCreatorAnnotation(annotated)) == null) {
            return false;
        } else {
            return hasCreatorAnnotation.booleanValue();
        }
    }

    public boolean hasIgnoreMarker(AnnotatedMember annotatedMember) {
        return _isIgnorable(annotatedMember);
    }

    public Boolean hasRequiredMarker(AnnotatedMember annotatedMember) {
        JsonProperty _findAnnotation = _findAnnotation(annotatedMember, JsonProperty.class);
        if (_findAnnotation != null) {
            return Boolean.valueOf(_findAnnotation.required());
        }
        return null;
    }

    public boolean isAnnotationBundle(Annotation annotation) {
        boolean z;
        Class<? extends Annotation> annotationType = annotation.annotationType();
        Boolean bool = this._annotationsInside.get(annotationType);
        if (bool == null) {
            if (annotationType.getAnnotation(JacksonAnnotationsInside.class) != null) {
                z = true;
            } else {
                z = false;
            }
            bool = Boolean.valueOf(z);
            this._annotationsInside.putIfAbsent(annotationType, bool);
        }
        return bool.booleanValue();
    }

    public Boolean isIgnorableType(AnnotatedClass annotatedClass) {
        JsonIgnoreType _findAnnotation = _findAnnotation(annotatedClass, JsonIgnoreType.class);
        if (_findAnnotation == null) {
            return null;
        }
        return Boolean.valueOf(_findAnnotation.value());
    }

    public Boolean isTypeId(AnnotatedMember annotatedMember) {
        return Boolean.valueOf(_hasAnnotation(annotatedMember, JsonTypeId.class));
    }

    public Object readResolve() {
        if (this._annotationsInside == null) {
            this._annotationsInside = new LRUMap<>(48, 48);
        }
        return this;
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    /* JADX WARNING: type inference failed for: r0v8, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    public JavaType refineDeserializationType(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) throws JsonMappingException {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        TypeFactory typeFactory = mapperConfig.getTypeFactory();
        JsonDeserialize jsonDeserialize = (JsonDeserialize) _findAnnotation(annotated, JsonDeserialize.class);
        if (jsonDeserialize == null) {
            cls = null;
        } else {
            cls = _classIfExplicit(jsonDeserialize.as());
        }
        if (cls != null && !javaType.hasRawClass(cls) && !_primitiveAndWrapper(javaType, cls)) {
            try {
                javaType = typeFactory.constructSpecializedType(javaType, cls);
            } catch (IllegalArgumentException e) {
                throw new JsonMappingException((Closeable) null, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", new Object[]{javaType, cls.getName(), annotated.getName(), e.getMessage()}), (Throwable) e);
            }
        }
        if (javaType.isMapLikeType()) {
            JavaType keyType = javaType.getKeyType();
            if (jsonDeserialize == null) {
                cls3 = null;
            } else {
                cls3 = _classIfExplicit(jsonDeserialize.keyAs());
            }
            if (cls3 != null && !_primitiveAndWrapper(keyType, cls3)) {
                try {
                    javaType = ((MapLikeType) javaType).withKeyType(typeFactory.constructSpecializedType(keyType, cls3));
                } catch (IllegalArgumentException e2) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{javaType, cls3.getName(), annotated.getName(), e2.getMessage()}), (Throwable) e2);
                }
            }
        }
        JavaType contentType = javaType.getContentType();
        if (contentType == null) {
            return javaType;
        }
        if (jsonDeserialize == null) {
            cls2 = null;
        } else {
            cls2 = _classIfExplicit(jsonDeserialize.contentAs());
        }
        if (cls2 == null || _primitiveAndWrapper(contentType, cls2)) {
            return javaType;
        }
        try {
            return javaType.withContentType(typeFactory.constructSpecializedType(contentType, cls2));
        } catch (IllegalArgumentException e3) {
            throw new JsonMappingException((Closeable) null, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{javaType, cls2.getName(), annotated.getName(), e3.getMessage()}), (Throwable) e3);
        }
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    /* JADX WARNING: type inference failed for: r7v5, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    /* JADX WARNING: type inference failed for: r0v8, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    /* JADX WARNING: type inference failed for: r7v11, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    /* JADX WARNING: type inference failed for: r0v11, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    /* JADX WARNING: type inference failed for: r7v13, types: [java.lang.Throwable, com.fasterxml.jackson.databind.JsonMappingException] */
    public JavaType refineSerializationType(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) throws JsonMappingException {
        Class<?> cls;
        Class<?> cls2;
        JavaType javaType2;
        Class<?> cls3;
        JavaType javaType3;
        TypeFactory typeFactory = mapperConfig.getTypeFactory();
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotated, JsonSerialize.class);
        if (jsonSerialize == null) {
            cls = null;
        } else {
            cls = _classIfExplicit(jsonSerialize.as());
        }
        if (cls != null) {
            if (javaType.hasRawClass(cls)) {
                javaType = javaType.withStaticTyping();
            } else {
                Class<?> rawClass = javaType.getRawClass();
                try {
                    if (cls.isAssignableFrom(rawClass)) {
                        javaType = typeFactory.constructGeneralizedType(javaType, cls);
                    } else if (rawClass.isAssignableFrom(cls)) {
                        javaType = typeFactory.constructSpecializedType(javaType, cls);
                    } else if (_primitiveAndWrapper(rawClass, cls)) {
                        javaType = javaType.withStaticTyping();
                    } else {
                        throw new JsonMappingException((Closeable) null, String.format("Cannot refine serialization type %s into %s; types not related", new Object[]{javaType, cls.getName()}));
                    }
                } catch (IllegalArgumentException e) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", new Object[]{javaType, cls.getName(), annotated.getName(), e.getMessage()}), (Throwable) e);
                }
            }
        }
        if (javaType.isMapLikeType()) {
            JavaType keyType = javaType.getKeyType();
            if (jsonSerialize == null) {
                cls3 = null;
            } else {
                cls3 = _classIfExplicit(jsonSerialize.keyAs());
            }
            if (cls3 != null) {
                if (keyType.hasRawClass(cls3)) {
                    javaType3 = keyType.withStaticTyping();
                } else {
                    Class<?> rawClass2 = keyType.getRawClass();
                    try {
                        if (cls3.isAssignableFrom(rawClass2)) {
                            javaType3 = typeFactory.constructGeneralizedType(keyType, cls3);
                        } else if (rawClass2.isAssignableFrom(cls3)) {
                            javaType3 = typeFactory.constructSpecializedType(keyType, cls3);
                        } else if (_primitiveAndWrapper(rawClass2, cls3)) {
                            javaType3 = keyType.withStaticTyping();
                        } else {
                            throw new JsonMappingException((Closeable) null, String.format("Cannot refine serialization key type %s into %s; types not related", new Object[]{keyType, cls3.getName()}));
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new JsonMappingException((Closeable) null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{javaType, cls3.getName(), annotated.getName(), e2.getMessage()}), (Throwable) e2);
                    }
                }
                javaType = ((MapLikeType) javaType).withKeyType(javaType3);
            }
        }
        JavaType contentType = javaType.getContentType();
        if (contentType == null) {
            return javaType;
        }
        if (jsonSerialize == null) {
            cls2 = null;
        } else {
            cls2 = _classIfExplicit(jsonSerialize.contentAs());
        }
        if (cls2 == null) {
            return javaType;
        }
        if (contentType.hasRawClass(cls2)) {
            javaType2 = contentType.withStaticTyping();
        } else {
            Class<?> rawClass3 = contentType.getRawClass();
            try {
                if (cls2.isAssignableFrom(rawClass3)) {
                    javaType2 = typeFactory.constructGeneralizedType(contentType, cls2);
                } else if (rawClass3.isAssignableFrom(cls2)) {
                    javaType2 = typeFactory.constructSpecializedType(contentType, cls2);
                } else if (_primitiveAndWrapper(rawClass3, cls2)) {
                    javaType2 = contentType.withStaticTyping();
                } else {
                    throw new JsonMappingException((Closeable) null, String.format("Cannot refine serialization content type %s into %s; types not related", new Object[]{contentType, cls2.getName()}));
                }
            } catch (IllegalArgumentException e3) {
                throw new JsonMappingException((Closeable) null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{javaType, cls2.getName(), annotated.getName(), e3.getMessage()}), (Throwable) e3);
            }
        }
        return javaType.withContentType(javaType2);
    }

    public AnnotatedMethod resolveSetterConflict(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        Class<?> rawParameterType = annotatedMethod.getRawParameterType(0);
        Class<?> rawParameterType2 = annotatedMethod2.getRawParameterType(0);
        if (rawParameterType.isPrimitive()) {
            if (!rawParameterType2.isPrimitive()) {
                return annotatedMethod;
            }
        } else if (rawParameterType2.isPrimitive()) {
            return annotatedMethod2;
        }
        Class<String> cls = String.class;
        if (rawParameterType == cls) {
            if (rawParameterType2 != cls) {
                return annotatedMethod;
            }
            return null;
        } else if (rawParameterType2 == cls) {
            return annotatedMethod2;
        } else {
            return null;
        }
    }

    public JacksonAnnotationIntrospector setConstructorPropertiesImpliesCreator(boolean z) {
        this._cfgConstructorPropertiesImpliesCreator = z;
        return this;
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public Class<?> _classIfExplicit(Class<?> cls, Class<?> cls2) {
        Class<?> _classIfExplicit = _classIfExplicit(cls);
        if (_classIfExplicit == null || _classIfExplicit == cls2) {
            return null;
        }
        return _classIfExplicit;
    }

    private boolean _primitiveAndWrapper(JavaType javaType, Class<?> cls) {
        if (javaType.isPrimitive()) {
            return javaType.hasRawClass(ClassUtil.primitiveType(cls));
        }
        if (!cls.isPrimitive() || cls != ClassUtil.primitiveType(javaType.getRawClass())) {
            return false;
        }
        return true;
    }

    public BeanPropertyWriter _constructVirtualProperty(JsonAppend.Prop prop, MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
        VirtualBeanPropertyWriter virtualBeanPropertyWriter;
        PropertyMetadata propertyMetadata = prop.required() ? PropertyMetadata.STD_REQUIRED : PropertyMetadata.STD_OPTIONAL;
        PropertyName _propertyName = _propertyName(prop.name(), prop.namespace());
        JavaType constructType = mapperConfig.constructType(prop.type());
        SimpleBeanPropertyDefinition construct = SimpleBeanPropertyDefinition.construct(mapperConfig, (AnnotatedMember) new VirtualAnnotatedMember(annotatedClass, annotatedClass.getRawType(), _propertyName.getSimpleName(), constructType), _propertyName, propertyMetadata, prop.include());
        Class<? extends VirtualBeanPropertyWriter> value = prop.value();
        HandlerInstantiator handlerInstantiator = mapperConfig.getHandlerInstantiator();
        if (handlerInstantiator == null) {
            virtualBeanPropertyWriter = null;
        } else {
            virtualBeanPropertyWriter = handlerInstantiator.virtualPropertyWriterInstance(mapperConfig, value);
        }
        if (virtualBeanPropertyWriter == null) {
            virtualBeanPropertyWriter = (VirtualBeanPropertyWriter) ClassUtil.createInstance(value, mapperConfig.canOverrideAccessModifiers());
        }
        return virtualBeanPropertyWriter.withConfig(mapperConfig, annotatedClass, construct, constructType);
    }
}
