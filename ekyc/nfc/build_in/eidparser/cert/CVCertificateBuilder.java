package com.fis.ekyc.nfc.build_in.eidparser.cert;

import com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum;
import com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum;
import com.fis.ekyc.nfc.build_in.cvc.CAReferenceField;
import com.fis.ekyc.nfc.build_in.cvc.CertificateGenerator;
import com.fis.ekyc.nfc.build_in.cvc.HolderReferenceField;
import com.fis.ekyc.nfc.build_in.cvc.exception.ConstructionException;
import com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Date;

public class CVCertificateBuilder {

    /* renamed from: com.fis.ekyc.nfc.build_in.eidparser.cert.CVCertificateBuilder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission;
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        static {
            /*
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission[] r0 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission = r0
                r1 = 1
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission r2 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission r3 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_DG3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission r4 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_DG4     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission r5 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_DG3_AND_DG4     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role[] r4 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role = r4
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role r5 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.CVCA     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role     // Catch:{ NoSuchFieldError -> 0x004e }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role r4 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.DV_D     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role r1 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.DV_F     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role r1 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.IS     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.cert.CVCertificateBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    private CVCertificateBuilder() {
    }

    public static CardVerifiableCertificate createCertificate(PublicKey publicKey, PrivateKey privateKey, String str, CVCPrincipal cVCPrincipal, CVCPrincipal cVCPrincipal2, CVCAuthorizationTemplate cVCAuthorizationTemplate, Date date, Date date2, String str2) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException, ConstructionException {
        return new CardVerifiableCertificate(CertificateGenerator.createCertificate(publicKey, privateKey, str, new CAReferenceField(cVCPrincipal.getCountry().toAlpha2Code(), cVCPrincipal.getMnemonic(), cVCPrincipal.getSeqNumber()), new HolderReferenceField(cVCPrincipal2.getCountry().toAlpha2Code(), cVCPrincipal2.getMnemonic(), cVCPrincipal2.getSeqNumber()), getRole(cVCAuthorizationTemplate.getRole()), getAccessRight(cVCAuthorizationTemplate.getAccessRight()), date, date2, str2));
    }

    private static AccessRightEnum getAccessRight(CVCAuthorizationTemplate.Permission permission) {
        int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission[permission.ordinal()];
        if (i == 1) {
            return AccessRightEnum.READ_ACCESS_NONE;
        }
        if (i == 2) {
            return AccessRightEnum.READ_ACCESS_DG3;
        }
        if (i == 3) {
            return AccessRightEnum.READ_ACCESS_DG4;
        }
        if (i == 4) {
            return AccessRightEnum.READ_ACCESS_DG3_AND_DG4;
        }
        throw new NumberFormatException("Cannot decode access right " + permission);
    }

    private static AuthorizationRoleEnum getRole(CVCAuthorizationTemplate.Role role) {
        int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role[role.ordinal()];
        if (i == 1) {
            return AuthorizationRoleEnum.CVCA;
        }
        if (i == 2) {
            return AuthorizationRoleEnum.DV_D;
        }
        if (i == 3) {
            return AuthorizationRoleEnum.DV_F;
        }
        if (i == 4) {
            return AuthorizationRoleEnum.IS;
        }
        throw new NumberFormatException("Cannot decode role " + role);
    }
}
