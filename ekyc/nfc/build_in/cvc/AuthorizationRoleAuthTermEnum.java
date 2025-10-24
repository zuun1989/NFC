package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;

public enum AuthorizationRoleAuthTermEnum implements AuthorizationRole {
    CVCA(CertificateHolderAuthorization.CVCA),
    DV_D(128),
    DV_F(64),
    AUTHTERM(0);
    
    private byte value;

    /* renamed from: com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleAuthTermEnum = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum[] r0 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleAuthTermEnum = r0
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum r1 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum.CVCA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleAuthTermEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum r1 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum.DV_D     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleAuthTermEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum r1 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum.DV_F     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleAuthTermEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum r1 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum.AUTHTERM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleAuthTermEnum.AnonymousClass1.<clinit>():void");
        }
    }

    private AuthorizationRoleAuthTermEnum(int i) {
        this.value = (byte) i;
    }

    public byte getValue() {
        return this.value;
    }

    public boolean isAccreditationBodyDV() {
        return false;
    }

    public boolean isAuthenticationTerminal() {
        if (this == AUTHTERM) {
            return true;
        }
        return false;
    }

    public boolean isCVCA() {
        if (this == CVCA) {
            return true;
        }
        return false;
    }

    public boolean isCertificationServiceProviderDV() {
        return false;
    }

    public boolean isDV() {
        if (this == DV_D || this == DV_F) {
            return true;
        }
        return false;
    }

    public boolean isDomesticDV() {
        if (this == DV_D) {
            return true;
        }
        return false;
    }

    public boolean isForeignDV() {
        if (this == DV_F) {
            return true;
        }
        return false;
    }

    public boolean isIS() {
        return false;
    }

    public boolean isSignatureTerminal() {
        return false;
    }

    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleAuthTermEnum[ordinal()];
        if (i == 1) {
            return "CVCA";
        }
        if (i == 2) {
            return "DV-domestic";
        }
        if (i == 3) {
            return "DV-foreign";
        }
        if (i == 4) {
            return "Authentication-Terminal";
        }
        throw new IllegalStateException("Enum case not handled");
    }
}
