package com.fis.ekyc.nfc.build_in.eidparser.cert;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum;
import com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum;

public class CVCAuthorizationTemplate {
    private Permission accessRight;
    private Role role;

    /* renamed from: com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightEnum;
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleEnum;
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission;
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role;

        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ac */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b6 */
        static {
            /*
                com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum[] r0 = com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightEnum = r0
                r1 = 1
                com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum r2 = com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum.READ_ACCESS_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum r3 = com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum.READ_ACCESS_DG3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum r4 = com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum.READ_ACCESS_DG4     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum r5 = com.fis.ekyc.nfc.build_in.cvc.AccessRightEnum.READ_ACCESS_DG3_AND_DG4     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum[] r4 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleEnum = r4
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum r5 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum.CVCA     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleEnum     // Catch:{ NoSuchFieldError -> 0x004e }
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum r5 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum.DV_D     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r4 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleEnum     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum r5 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum.DV_F     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r4 = $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleEnum     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum r5 = com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum.IS     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role[] r4 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role = r4
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role r5 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.CVCA     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r4 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role     // Catch:{ NoSuchFieldError -> 0x007d }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role r5 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.DV_D     // Catch:{ NoSuchFieldError -> 0x007d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r4 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role r5 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.DV_F     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r4 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role     // Catch:{ NoSuchFieldError -> 0x0091 }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Role r5 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Role.IS     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission[] r4 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission = r4
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission r5 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_NONE     // Catch:{ NoSuchFieldError -> 0x00a2 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a2 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00a2 }
            L_0x00a2:
                int[] r1 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission     // Catch:{ NoSuchFieldError -> 0x00ac }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission r4 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_DG3     // Catch:{ NoSuchFieldError -> 0x00ac }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ac }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x00ac }
            L_0x00ac:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission r1 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_DG4     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate$Permission r1 = com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_DG3_AND_DG4     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.cert.CVCAuthorizationTemplate.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Permission {
        READ_ACCESS_NONE(0),
        READ_ACCESS_DG3(1),
        READ_ACCESS_DG4(2),
        READ_ACCESS_DG3_AND_DG4(3);
        
        /* access modifiers changed from: private */
        public byte value;

        private Permission(int i) {
            this.value = (byte) i;
        }

        public byte getValue() {
            return this.value;
        }

        public boolean implies(Permission permission) {
            int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Permission[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        if (permission == READ_ACCESS_DG3 || permission == READ_ACCESS_DG4 || permission == READ_ACCESS_DG3_AND_DG4) {
                            return true;
                        }
                        return false;
                    } else if (permission == READ_ACCESS_DG4) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (permission == READ_ACCESS_DG3) {
                    return true;
                } else {
                    return false;
                }
            } else if (permission == READ_ACCESS_NONE) {
                return true;
            } else {
                return false;
            }
        }
    }

    public enum Role {
        CVCA(CertificateHolderAuthorization.CVCA),
        DV_D(128),
        DV_F(64),
        IS(0);
        
        /* access modifiers changed from: private */
        public byte value;

        private Role(int i) {
            this.value = (byte) i;
        }

        public byte getValue() {
            return this.value;
        }
    }

    public CVCAuthorizationTemplate(com.fis.ekyc.nfc.build_in.cvc.CVCAuthorizationTemplate cVCAuthorizationTemplate) {
        this.role = toRole(cVCAuthorizationTemplate);
        this.accessRight = toPermission(cVCAuthorizationTemplate);
    }

    public static AccessRightEnum fromPermission(Permission permission) {
        try {
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
            throw new IllegalArgumentException("Error getting permission for " + permission);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error getting permission from AuthZ template", e);
        }
    }

    public static AuthorizationRoleEnum fromRole(Role role2) {
        try {
            int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$cert$CVCAuthorizationTemplate$Role[role2.ordinal()];
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
            throw new IllegalArgumentException("Error getting role from AuthZ template " + role2);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error getting role from AuthZ template", e);
        }
    }

    private static Permission toPermission(com.fis.ekyc.nfc.build_in.cvc.CVCAuthorizationTemplate cVCAuthorizationTemplate) {
        try {
            AccessRightEnum accessRight2 = cVCAuthorizationTemplate.getAuthorizationField().getAccessRight();
            int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AccessRightEnum[accessRight2.ordinal()];
            if (i == 1) {
                return Permission.READ_ACCESS_NONE;
            }
            if (i == 2) {
                return Permission.READ_ACCESS_DG3;
            }
            if (i == 3) {
                return Permission.READ_ACCESS_DG4;
            }
            if (i == 4) {
                return Permission.READ_ACCESS_DG3_AND_DG4;
            }
            throw new IllegalArgumentException("Unsupported access right " + accessRight2);
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("Unsupported access right", e);
        }
    }

    private static Role toRole(com.fis.ekyc.nfc.build_in.cvc.CVCAuthorizationTemplate cVCAuthorizationTemplate) {
        try {
            AuthorizationRoleEnum role2 = cVCAuthorizationTemplate.getAuthorizationField().getRole();
            int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$cvc$AuthorizationRoleEnum[role2.ordinal()];
            if (i == 1) {
                return Role.CVCA;
            }
            if (i == 2) {
                return Role.DV_D;
            }
            if (i == 3) {
                return Role.DV_F;
            }
            if (i == 4) {
                return Role.IS;
            }
            throw new IllegalArgumentException("Unsupported role " + role2);
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("Error getting role from AuthZ template", e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        CVCAuthorizationTemplate cVCAuthorizationTemplate = (CVCAuthorizationTemplate) obj;
        if (this.role == cVCAuthorizationTemplate.role && this.accessRight == cVCAuthorizationTemplate.accessRight) {
            return true;
        }
        return false;
    }

    public Permission getAccessRight() {
        return this.accessRight;
    }

    public Role getRole() {
        return this.role;
    }

    public int hashCode() {
        return (this.role.value * 2) + (this.accessRight.value * 3) + 61;
    }

    public String toString() {
        return this.role.toString() + this.accessRight.toString();
    }

    public CVCAuthorizationTemplate(Role role2, Permission permission) {
        this.role = role2;
        this.accessRight = permission;
    }
}
