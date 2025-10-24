package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

public class CryptoServicesPermission extends Permission {
    public static final String DEFAULT_RANDOM = "defaultRandomConfig";
    public static final String GLOBAL_CONFIG = "globalConfig";
    public static final String THREAD_LOCAL_CONFIG = "threadLocalConfig";
    private final Set<String> actions;

    public CryptoServicesPermission(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.actions = hashSet;
        hashSet.add(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CryptoServicesPermission) || !this.actions.equals(((CryptoServicesPermission) obj).actions)) {
            return false;
        }
        return true;
    }

    public String getActions() {
        return this.actions.toString();
    }

    public int hashCode() {
        return this.actions.hashCode();
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof CryptoServicesPermission)) {
            return false;
        }
        CryptoServicesPermission cryptoServicesPermission = (CryptoServicesPermission) permission;
        if (!getName().equals(cryptoServicesPermission.getName()) && !this.actions.containsAll(cryptoServicesPermission.actions)) {
            return false;
        }
        return true;
    }
}
