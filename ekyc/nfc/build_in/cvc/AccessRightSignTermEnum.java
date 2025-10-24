package com.fis.ekyc.nfc.build_in.cvc;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;

public enum AccessRightSignTermEnum implements AccessRights {
    ACCESS_NONE(0),
    ACCESS_SIGN(1),
    ACCESS_QUALSIGN(2),
    ACCESS_SIGN_AND_QUALSIGN(3);
    
    private byte value;

    /* renamed from: com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightSignTermEnum = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum[] r0 = com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightSignTermEnum = r0
                com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum r1 = com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum.ACCESS_SIGN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightSignTermEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum r1 = com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum.ACCESS_QUALSIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightSignTermEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum r1 = com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum.ACCESS_SIGN_AND_QUALSIGN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightSignTermEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum r1 = com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum.ACCESS_NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.cvc.AccessRightSignTermEnum.AnonymousClass1.<clinit>():void");
        }
    }

    private AccessRightSignTermEnum(int i) {
        this.value = (byte) i;
    }

    public boolean allowsQualifiedSignature() {
        if ((this.value & ACCESS_QUALSIGN.value) != 0) {
            return true;
        }
        return false;
    }

    public boolean allowsSignature() {
        if ((this.value & ACCESS_SIGN.value) != 0) {
            return true;
        }
        return false;
    }

    public byte[] getEncoded() {
        return new byte[]{this.value};
    }

    public byte getValue() {
        return this.value;
    }

    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightSignTermEnum[ordinal()];
        if (i == 1) {
            return "Signature";
        }
        if (i == 2) {
            return "Qualified_Signature";
        }
        if (i == 3) {
            return "Signature_and_Qualified_Signature";
        }
        if (i == 4) {
            return DevicePublicKeyStringDef.NONE;
        }
        throw new IllegalStateException("Enum case not handled");
    }
}
