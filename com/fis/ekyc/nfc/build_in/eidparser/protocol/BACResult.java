package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.AccessKeySpec;
import java.io.Serializable;

public class BACResult implements Serializable {
    private static final long serialVersionUID = -7114911372181772099L;
    private AccessKeySpec bacKey;
    private SecureMessagingWrapper wrapper;

    public BACResult(SecureMessagingWrapper secureMessagingWrapper) {
        this((AccessKeySpec) null, secureMessagingWrapper);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BACResult bACResult = (BACResult) obj;
        AccessKeySpec accessKeySpec = this.bacKey;
        if (accessKeySpec == null) {
            if (bACResult.bacKey != null) {
                return false;
            }
        } else if (!accessKeySpec.equals(bACResult.bacKey)) {
            return false;
        }
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper == null) {
            if (bACResult.wrapper != null) {
                return false;
            }
        } else if (!secureMessagingWrapper.equals(bACResult.wrapper)) {
            return false;
        }
        return true;
    }

    public AccessKeySpec getBACKey() {
        return this.bacKey;
    }

    public SecureMessagingWrapper getWrapper() {
        return this.wrapper;
    }

    public int hashCode() {
        int i;
        AccessKeySpec accessKeySpec = this.bacKey;
        int i2 = 0;
        if (accessKeySpec == null) {
            i = 0;
        } else {
            i = accessKeySpec.hashCode();
        }
        int i3 = (1303377669 + i) * 1234567891;
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper != null) {
            i2 = secureMessagingWrapper.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("BACResult [bacKey: ");
        Object obj = this.bacKey;
        if (obj == null) {
            obj = "-";
        }
        sb2.append(obj);
        sb2.append(", wrapper: ");
        sb2.append(this.wrapper);
        sb2.append("]");
        return sb2.toString();
    }

    public BACResult(AccessKeySpec accessKeySpec, SecureMessagingWrapper secureMessagingWrapper) {
        this.bacKey = accessKeySpec;
        this.wrapper = secureMessagingWrapper;
    }
}
