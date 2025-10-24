package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class DefaultDeserializationContext extends DeserializationContext implements Serializable {
    private static final long serialVersionUID = 1;
    private List<ObjectIdResolver> _objectIdResolvers;
    protected transient LinkedHashMap<ObjectIdGenerator.IdKey, ReadableObjectId> _objectIds;

    public static final class Impl extends DefaultDeserializationContext {
        private static final long serialVersionUID = 1;

        public Impl(DeserializerFactory deserializerFactory) {
            super(deserializerFactory, (DeserializerCache) null);
        }

        public DefaultDeserializationContext copy() {
            ClassUtil.verifyMustOverride(Impl.class, this, "copy");
            return new Impl(this);
        }

        public DefaultDeserializationContext createInstance(DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
            return new Impl(this, deserializationConfig, jsonParser, injectableValues);
        }

        public DefaultDeserializationContext with(DeserializerFactory deserializerFactory) {
            return new Impl(this, deserializerFactory);
        }

        public Impl(Impl impl, DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
            super(impl, deserializationConfig, jsonParser, injectableValues);
        }

        public Impl(Impl impl) {
            super(impl);
        }

        public Impl(Impl impl, DeserializerFactory deserializerFactory) {
            super((DefaultDeserializationContext) impl, deserializerFactory);
        }
    }

    public DefaultDeserializationContext(DeserializerFactory deserializerFactory, DeserializerCache deserializerCache) {
        super(deserializerFactory, deserializerCache);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.fasterxml.jackson.databind.deser.UnresolvedForwardReference} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.fasterxml.jackson.databind.deser.UnresolvedForwardReference} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.fasterxml.jackson.databind.deser.UnresolvedForwardReference} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0019, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkUnresolvedObjectId() throws com.fasterxml.jackson.databind.deser.UnresolvedForwardReference {
        /*
            r6 = this;
            java.util.LinkedHashMap<com.fasterxml.jackson.annotation.ObjectIdGenerator$IdKey, com.fasterxml.jackson.databind.deser.impl.ReadableObjectId> r0 = r6._objectIds
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.fasterxml.jackson.databind.DeserializationFeature r0 = com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS
            boolean r0 = r6.isEnabled((com.fasterxml.jackson.databind.DeserializationFeature) r0)
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            java.util.LinkedHashMap<com.fasterxml.jackson.annotation.ObjectIdGenerator$IdKey, com.fasterxml.jackson.databind.deser.impl.ReadableObjectId> r0 = r6._objectIds
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0019:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0068
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getValue()
            com.fasterxml.jackson.databind.deser.impl.ReadableObjectId r2 = (com.fasterxml.jackson.databind.deser.impl.ReadableObjectId) r2
            boolean r3 = r2.hasReferringProperties()
            if (r3 != 0) goto L_0x0032
            goto L_0x0019
        L_0x0032:
            boolean r3 = r6.tryToResolveUnresolvedObjectId(r2)
            if (r3 == 0) goto L_0x0039
            goto L_0x0019
        L_0x0039:
            if (r1 != 0) goto L_0x0046
            com.fasterxml.jackson.databind.deser.UnresolvedForwardReference r1 = new com.fasterxml.jackson.databind.deser.UnresolvedForwardReference
            com.fasterxml.jackson.core.JsonParser r3 = r6.getParser()
            java.lang.String r4 = "Unresolved forward references for: "
            r1.<init>(r3, r4)
        L_0x0046:
            com.fasterxml.jackson.annotation.ObjectIdGenerator$IdKey r3 = r2.getKey()
            java.lang.Object r3 = r3.key
            java.util.Iterator r2 = r2.referringProperties()
        L_0x0050:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0019
            java.lang.Object r4 = r2.next()
            com.fasterxml.jackson.databind.deser.impl.ReadableObjectId$Referring r4 = (com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring) r4
            java.lang.Class r5 = r4.getBeanType()
            com.fasterxml.jackson.core.JsonLocation r4 = r4.getLocation()
            r1.addUnresolvedId(r3, r5, r4)
            goto L_0x0050
        L_0x0068:
            if (r1 != 0) goto L_0x006b
            return
        L_0x006b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.checkUnresolvedObjectId():void");
    }

    public DefaultDeserializationContext copy() {
        throw new IllegalStateException("DefaultDeserializationContext sub-class not overriding copy()");
    }

    public abstract DefaultDeserializationContext createInstance(DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues);

    public ReadableObjectId createReadableObjectId(ObjectIdGenerator.IdKey idKey) {
        return new ReadableObjectId(idKey);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Class<com.fasterxml.jackson.databind.JsonDeserializer$None>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: com.fasterxml.jackson.databind.JsonDeserializer<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object> deserializerInstance(com.fasterxml.jackson.databind.introspect.Annotated r3, java.lang.Object r4) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r2 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r4 instanceof com.fasterxml.jackson.databind.JsonDeserializer
            if (r1 == 0) goto L_0x000b
            com.fasterxml.jackson.databind.JsonDeserializer r4 = (com.fasterxml.jackson.databind.JsonDeserializer) r4
            goto L_0x0044
        L_0x000b:
            boolean r1 = r4 instanceof java.lang.Class
            if (r1 == 0) goto L_0x0070
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.Class<com.fasterxml.jackson.databind.JsonDeserializer$None> r1 = com.fasterxml.jackson.databind.JsonDeserializer.None.class
            if (r4 == r1) goto L_0x006f
            boolean r1 = com.fasterxml.jackson.databind.util.ClassUtil.isBogusClass(r4)
            if (r1 == 0) goto L_0x001c
            goto L_0x006f
        L_0x001c:
            java.lang.Class<com.fasterxml.jackson.databind.JsonDeserializer> r1 = com.fasterxml.jackson.databind.JsonDeserializer.class
            boolean r1 = r1.isAssignableFrom(r4)
            if (r1 == 0) goto L_0x004f
            com.fasterxml.jackson.databind.DeserializationConfig r1 = r2._config
            com.fasterxml.jackson.databind.cfg.HandlerInstantiator r1 = r1.getHandlerInstantiator()
            if (r1 != 0) goto L_0x002d
            goto L_0x0033
        L_0x002d:
            com.fasterxml.jackson.databind.DeserializationConfig r0 = r2._config
            com.fasterxml.jackson.databind.JsonDeserializer r0 = r1.deserializerInstance(r0, r3, r4)
        L_0x0033:
            if (r0 != 0) goto L_0x0043
            com.fasterxml.jackson.databind.DeserializationConfig r3 = r2._config
            boolean r3 = r3.canOverrideAccessModifiers()
            java.lang.Object r3 = com.fasterxml.jackson.databind.util.ClassUtil.createInstance(r4, r3)
            r4 = r3
            com.fasterxml.jackson.databind.JsonDeserializer r4 = (com.fasterxml.jackson.databind.JsonDeserializer) r4
            goto L_0x0044
        L_0x0043:
            r4 = r0
        L_0x0044:
            boolean r3 = r4 instanceof com.fasterxml.jackson.databind.deser.ResolvableDeserializer
            if (r3 == 0) goto L_0x004e
            r3 = r4
            com.fasterxml.jackson.databind.deser.ResolvableDeserializer r3 = (com.fasterxml.jackson.databind.deser.ResolvableDeserializer) r3
            r3.resolve(r2)
        L_0x004e:
            return r4
        L_0x004f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned Class "
            r0.append(r1)
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = "; expected Class<JsonDeserializer>"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        L_0x006f:
            return r0
        L_0x0070:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned deserializer definition of type "
            r0.append(r1)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = "; expected type JsonDeserializer or Class<JsonDeserializer> instead"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.deserializerInstance(com.fasterxml.jackson.databind.introspect.Annotated, java.lang.Object):com.fasterxml.jackson.databind.JsonDeserializer");
    }

    public ReadableObjectId findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator, ObjectIdResolver objectIdResolver) {
        ObjectIdResolver objectIdResolver2 = null;
        if (obj == null) {
            return null;
        }
        ObjectIdGenerator.IdKey key = objectIdGenerator.key(obj);
        LinkedHashMap<ObjectIdGenerator.IdKey, ReadableObjectId> linkedHashMap = this._objectIds;
        if (linkedHashMap == null) {
            this._objectIds = new LinkedHashMap<>();
        } else {
            ReadableObjectId readableObjectId = linkedHashMap.get(key);
            if (readableObjectId != null) {
                return readableObjectId;
            }
        }
        List<ObjectIdResolver> list = this._objectIdResolvers;
        if (list != null) {
            Iterator<ObjectIdResolver> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ObjectIdResolver next = it.next();
                if (next.canUseFor(objectIdResolver)) {
                    objectIdResolver2 = next;
                    break;
                }
            }
        } else {
            this._objectIdResolvers = new ArrayList(8);
        }
        if (objectIdResolver2 == null) {
            objectIdResolver2 = objectIdResolver.newForDeserialization(this);
            this._objectIdResolvers.add(objectIdResolver2);
        }
        ReadableObjectId createReadableObjectId = createReadableObjectId(key);
        createReadableObjectId.setResolver(objectIdResolver2);
        this._objectIds.put(key, createReadableObjectId);
        return createReadableObjectId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Class<com.fasterxml.jackson.databind.KeyDeserializer$None>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: com.fasterxml.jackson.databind.KeyDeserializer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.fasterxml.jackson.databind.KeyDeserializer keyDeserializerInstance(com.fasterxml.jackson.databind.introspect.Annotated r3, java.lang.Object r4) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r2 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r4 instanceof com.fasterxml.jackson.databind.KeyDeserializer
            if (r1 == 0) goto L_0x000b
            com.fasterxml.jackson.databind.KeyDeserializer r4 = (com.fasterxml.jackson.databind.KeyDeserializer) r4
            goto L_0x0044
        L_0x000b:
            boolean r1 = r4 instanceof java.lang.Class
            if (r1 == 0) goto L_0x0070
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.Class<com.fasterxml.jackson.databind.KeyDeserializer$None> r1 = com.fasterxml.jackson.databind.KeyDeserializer.None.class
            if (r4 == r1) goto L_0x006f
            boolean r1 = com.fasterxml.jackson.databind.util.ClassUtil.isBogusClass(r4)
            if (r1 == 0) goto L_0x001c
            goto L_0x006f
        L_0x001c:
            java.lang.Class<com.fasterxml.jackson.databind.KeyDeserializer> r1 = com.fasterxml.jackson.databind.KeyDeserializer.class
            boolean r1 = r1.isAssignableFrom(r4)
            if (r1 == 0) goto L_0x004f
            com.fasterxml.jackson.databind.DeserializationConfig r1 = r2._config
            com.fasterxml.jackson.databind.cfg.HandlerInstantiator r1 = r1.getHandlerInstantiator()
            if (r1 != 0) goto L_0x002d
            goto L_0x0033
        L_0x002d:
            com.fasterxml.jackson.databind.DeserializationConfig r0 = r2._config
            com.fasterxml.jackson.databind.KeyDeserializer r0 = r1.keyDeserializerInstance(r0, r3, r4)
        L_0x0033:
            if (r0 != 0) goto L_0x0043
            com.fasterxml.jackson.databind.DeserializationConfig r3 = r2._config
            boolean r3 = r3.canOverrideAccessModifiers()
            java.lang.Object r3 = com.fasterxml.jackson.databind.util.ClassUtil.createInstance(r4, r3)
            r4 = r3
            com.fasterxml.jackson.databind.KeyDeserializer r4 = (com.fasterxml.jackson.databind.KeyDeserializer) r4
            goto L_0x0044
        L_0x0043:
            r4 = r0
        L_0x0044:
            boolean r3 = r4 instanceof com.fasterxml.jackson.databind.deser.ResolvableDeserializer
            if (r3 == 0) goto L_0x004e
            r3 = r4
            com.fasterxml.jackson.databind.deser.ResolvableDeserializer r3 = (com.fasterxml.jackson.databind.deser.ResolvableDeserializer) r3
            r3.resolve(r2)
        L_0x004e:
            return r4
        L_0x004f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned Class "
            r0.append(r1)
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = "; expected Class<KeyDeserializer>"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        L_0x006f:
            return r0
        L_0x0070:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned key deserializer definition of type "
            r0.append(r1)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = "; expected type KeyDeserializer or Class<KeyDeserializer> instead"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.keyDeserializerInstance(com.fasterxml.jackson.databind.introspect.Annotated, java.lang.Object):com.fasterxml.jackson.databind.KeyDeserializer");
    }

    public boolean tryToResolveUnresolvedObjectId(ReadableObjectId readableObjectId) {
        return readableObjectId.tryToResolveUnresolved(this);
    }

    public abstract DefaultDeserializationContext with(DeserializerFactory deserializerFactory);

    public DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext, DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
        super(defaultDeserializationContext, deserializationConfig, jsonParser, injectableValues);
    }

    public DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext, DeserializerFactory deserializerFactory) {
        super((DeserializationContext) defaultDeserializationContext, deserializerFactory);
    }

    public DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext) {
        super((DeserializationContext) defaultDeserializationContext);
    }
}
