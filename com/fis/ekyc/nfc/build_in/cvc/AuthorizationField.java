package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.cvc.util.StringConverter;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;

public class AuthorizationField extends AbstractDataField {
    private static final long serialVersionUID = -5478250843535697147L;
    private AccessRights rights;
    private AuthorizationRole role;

    public AuthorizationField() {
        super(CVCTagEnum.ROLE_AND_ACCESS_RIGHTS);
    }

    private static AccessRights getRightsFromBytes(OIDField oIDField, byte[] bArr) {
        int i = 0;
        if (CVCObjectIdentifiers.id_EAC_ePassport.equals(oIDField)) {
            if (bArr.length == 1) {
                byte b = (byte) (bArr[0] & 3);
                AccessRightEnum[] values = AccessRightEnum.values();
                int length = values.length;
                while (i < length) {
                    AccessRightEnum accessRightEnum = values[i];
                    if (b == accessRightEnum.getValue()) {
                        return accessRightEnum;
                    }
                    i++;
                }
                return null;
            }
            throw new IllegalArgumentException("byte array length must be 1, was " + bArr.length);
        } else if (CVCObjectIdentifiers.id_EAC_roles_ST.equals(oIDField)) {
            if (bArr.length == 1) {
                byte b2 = (byte) (bArr[0] & 3);
                AccessRightSignTermEnum[] values2 = AccessRightSignTermEnum.values();
                int length2 = values2.length;
                while (i < length2) {
                    AccessRightSignTermEnum accessRightSignTermEnum = values2[i];
                    if (b2 == accessRightSignTermEnum.getValue()) {
                        return accessRightSignTermEnum;
                    }
                    i++;
                }
                return null;
            }
            throw new IllegalArgumentException("byte array length must be 1, was " + bArr.length);
        } else if (!CVCObjectIdentifiers.id_EAC_roles_AT.equals(oIDField)) {
            return new AccessRightsRawValue(bArr);
        } else {
            if (bArr.length == 5) {
                return new AccessRightAuthTerm(bArr);
            }
            throw new IllegalArgumentException("byte array length must be 5, was " + bArr.length);
        }
    }

    private static AuthorizationRole getRoleFromByte(OIDField oIDField, byte b) {
        AuthorizationRole[] authorizationRoleArr;
        byte b2 = (byte) (b & ISO7816.INS_GET_RESPONSE);
        if (CVCObjectIdentifiers.id_EAC_ePassport.equals(oIDField)) {
            authorizationRoleArr = AuthorizationRoleEnum.values();
        } else if (CVCObjectIdentifiers.id_EAC_roles_ST.equals(oIDField)) {
            authorizationRoleArr = AuthorizationRoleSignTermEnum.values();
        } else if (!CVCObjectIdentifiers.id_EAC_roles_AT.equals(oIDField)) {
            return new AuthorizationRoleRawValue(b);
        } else {
            authorizationRoleArr = AuthorizationRoleAuthTermEnum.values();
        }
        for (AuthorizationRole authorizationRole : authorizationRoleArr) {
            if (b2 == authorizationRole.getValue()) {
                return authorizationRole;
            }
        }
        return null;
    }

    public void fixEnumTypes(OIDField oIDField) {
        this.role = getRoleFromByte(oIDField, this.role.getValue());
        this.rights = getRightsFromBytes(oIDField, this.rights.getEncoded());
    }

    @Deprecated
    public AccessRightEnum getAccessRight() {
        AccessRights accessRights = this.rights;
        if (accessRights instanceof AccessRightEnum) {
            return (AccessRightEnum) accessRights;
        }
        throw new UnsupportedOperationException("Attempted to use deprecated getAccessRight method with an AT or ST certificate chain. It handles IS only.");
    }

    public AccessRights getAccessRights() {
        return this.rights;
    }

    public AuthorizationRole getAuthRole() {
        return this.role;
    }

    public byte[] getEncoded() {
        byte[] encoded = this.rights.getEncoded();
        encoded[0] = (byte) (encoded[0] | this.role.getValue());
        return encoded;
    }

    @Deprecated
    public AuthorizationRoleEnum getRole() {
        AuthorizationRole authorizationRole = this.role;
        if (authorizationRole instanceof AuthorizationRoleEnum) {
            return (AuthorizationRoleEnum) authorizationRole;
        }
        throw new UnsupportedOperationException("Attempted to use deprecated getRole method with in an AT or ST certificate chain. It handles IS only.");
    }

    public String valueAsText() {
        return StringConverter.byteToHex(getEncoded()) + ": " + this.role + "/" + this.rights;
    }

    public AuthorizationField(AuthorizationRole authorizationRole, AccessRights accessRights) {
        this();
        this.role = authorizationRole;
        this.rights = accessRights;
    }

    public AuthorizationField(AuthorizationRoleEnum authorizationRoleEnum, AccessRightEnum accessRightEnum) {
        this((AuthorizationRole) authorizationRoleEnum, (AccessRights) accessRightEnum);
    }

    public AuthorizationField(byte[] bArr) {
        this();
        if (bArr.length >= 1) {
            this.role = new AuthorizationRoleRawValue(bArr[0]);
            this.rights = new AccessRightsRawValue(bArr);
            return;
        }
        throw new IllegalArgumentException("byte array length must be at least 1");
    }
}
