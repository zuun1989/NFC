package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;

public class PropertyName implements Serializable {
    public static final PropertyName NO_NAME = new PropertyName(new String(""), (String) null);
    public static final PropertyName USE_DEFAULT = new PropertyName("", (String) null);
    private static final String _NO_NAME = "";
    private static final String _USE_DEFAULT = "";
    private static final long serialVersionUID = 1;
    protected SerializableString _encodedSimple;
    protected final String _namespace;
    protected final String _simpleName;

    public PropertyName(String str) {
        this(str, (String) null);
    }

    public static PropertyName construct(String str) {
        if (str == null || str.length() == 0) {
            return USE_DEFAULT;
        }
        return new PropertyName(InternCache.instance.intern(str), (String) null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        PropertyName propertyName = (PropertyName) obj;
        String str = this._simpleName;
        if (str == null) {
            if (propertyName._simpleName != null) {
                return false;
            }
        } else if (!str.equals(propertyName._simpleName)) {
            return false;
        }
        String str2 = this._namespace;
        if (str2 != null) {
            return str2.equals(propertyName._namespace);
        }
        if (propertyName._namespace == null) {
            return true;
        }
        return false;
    }

    public String getNamespace() {
        return this._namespace;
    }

    public String getSimpleName() {
        return this._simpleName;
    }

    public boolean hasNamespace() {
        if (this._namespace != null) {
            return true;
        }
        return false;
    }

    public boolean hasSimpleName() {
        return this._simpleName.length() > 0;
    }

    public int hashCode() {
        String str = this._namespace;
        if (str == null) {
            return this._simpleName.hashCode();
        }
        return str.hashCode() ^ this._simpleName.hashCode();
    }

    public PropertyName internSimpleName() {
        String intern;
        if (this._simpleName.length() == 0 || (intern = InternCache.instance.intern(this._simpleName)) == this._simpleName) {
            return this;
        }
        return new PropertyName(intern, this._namespace);
    }

    public boolean isEmpty() {
        if (this._namespace != null || !this._simpleName.isEmpty()) {
            return false;
        }
        return true;
    }

    public Object readResolve() {
        String str;
        if (this._namespace != null || ((str = this._simpleName) != null && !"".equals(str))) {
            return this;
        }
        return USE_DEFAULT;
    }

    public SerializableString simpleAsEncoded(MapperConfig<?> mapperConfig) {
        SerializedString compileString;
        SerializedString serializedString = this._encodedSimple;
        if (serializedString == null) {
            if (mapperConfig == null) {
                compileString = new SerializedString(this._simpleName);
            } else {
                compileString = mapperConfig.compileString(this._simpleName);
            }
            serializedString = compileString;
            this._encodedSimple = serializedString;
        }
        return serializedString;
    }

    public String toString() {
        if (this._namespace == null) {
            return this._simpleName;
        }
        return "{" + this._namespace + "}" + this._simpleName;
    }

    public PropertyName withNamespace(String str) {
        if (str == null) {
            if (this._namespace == null) {
                return this;
            }
        } else if (str.equals(this._namespace)) {
            return this;
        }
        return new PropertyName(this._simpleName, str);
    }

    public PropertyName withSimpleName(String str) {
        if (str == null) {
            str = "";
        }
        if (str.equals(this._simpleName)) {
            return this;
        }
        return new PropertyName(str, this._namespace);
    }

    public PropertyName(String str, String str2) {
        this._simpleName = ClassUtil.nonNullString(str);
        this._namespace = str2;
    }

    public boolean hasSimpleName(String str) {
        return this._simpleName.equals(str);
    }

    public static PropertyName construct(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null && str.length() == 0) {
            return USE_DEFAULT;
        }
        return new PropertyName(InternCache.instance.intern(str), str2);
    }
}
