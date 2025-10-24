package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

public class ResolvedRecursiveType extends TypeBase {
    private static final long serialVersionUID = 1;
    protected JavaType _referencedType;

    public ResolvedRecursiveType(Class<?> cls, TypeBindings typeBindings) {
        super(cls, typeBindings, (JavaType) null, (JavaType[]) null, 0, (Object) null, (Object) null, false);
    }

    @Deprecated
    public JavaType _narrow(Class<?> cls) {
        return this;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public StringBuilder getErasedSignature(StringBuilder sb2) {
        return this._referencedType.getErasedSignature(sb2);
    }

    public StringBuilder getGenericSignature(StringBuilder sb2) {
        return this._referencedType.getGenericSignature(sb2);
    }

    public JavaType getSelfReferencedType() {
        return this._referencedType;
    }

    public JavaType getSuperClass() {
        JavaType javaType = this._referencedType;
        if (javaType != null) {
            return javaType.getSuperClass();
        }
        return super.getSuperClass();
    }

    public boolean isContainerType() {
        return false;
    }

    public JavaType refine(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    public void setReference(JavaType javaType) {
        if (this._referencedType == null) {
            this._referencedType = javaType;
            return;
        }
        throw new IllegalStateException("Trying to re-set self reference; old value = " + this._referencedType + ", new = " + javaType);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("[recursive type; ");
        JavaType javaType = this._referencedType;
        if (javaType == null) {
            sb2.append("UNRESOLVED");
        } else {
            sb2.append(javaType.getRawClass().getName());
        }
        return sb2.toString();
    }

    public JavaType withContentType(JavaType javaType) {
        return this;
    }

    public JavaType withContentTypeHandler(Object obj) {
        return this;
    }

    public JavaType withContentValueHandler(Object obj) {
        return this;
    }

    public JavaType withStaticTyping() {
        return this;
    }

    public JavaType withTypeHandler(Object obj) {
        return this;
    }

    public JavaType withValueHandler(Object obj) {
        return this;
    }
}
