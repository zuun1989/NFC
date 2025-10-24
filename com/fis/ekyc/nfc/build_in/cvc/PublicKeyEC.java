package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.ECPointUtil;
import com.fis.ekyc.nfc.build_in.cvc.exception.ConstructionException;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;

public class PublicKeyEC extends CVCPublicKey implements ECPublicKey {
    public static final byte UNCOMPRESSED_POINT_TAG = 4;
    private static CVCTagEnum[] allowedFields = {CVCTagEnum.OID, CVCTagEnum.MODULUS, CVCTagEnum.COEFFICIENT_A, CVCTagEnum.COEFFICIENT_B, CVCTagEnum.BASE_POINT_G, CVCTagEnum.BASE_POINT_R_ORDER, CVCTagEnum.PUBLIC_POINT_Y, CVCTagEnum.COFACTOR_F};
    static final long serialVersionUID = 1;

    public PublicKeyEC(GenericPublicKeyField genericPublicKeyField) throws ConstructionException, NoSuchFieldException {
        addSubfield(genericPublicKeyField.getSubfield(CVCTagEnum.OID));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.MODULUS));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.COEFFICIENT_A));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.COEFFICIENT_B));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.BASE_POINT_G));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.BASE_POINT_R_ORDER));
        addSubfield(genericPublicKeyField.getSubfield(CVCTagEnum.PUBLIC_POINT_Y));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.COFACTOR_F));
    }

    public static ECPoint decodePoint(byte[] bArr) {
        if (bArr[0] == 4) {
            int length = (bArr.length - 1) / 2;
            byte[] bArr2 = new byte[length];
            int length2 = (bArr.length - 1) / 2;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, 1, bArr2, 0, length);
            System.arraycopy(bArr, length + 1, bArr3, 0, length2);
            return new ECPoint(new BigInteger(1, bArr2), new BigInteger(1, bArr3));
        }
        throw new IllegalArgumentException("First byte must be 0x4");
    }

    public static byte[] encodePoint(ECPoint eCPoint, EllipticCurve ellipticCurve) {
        int i;
        int i2;
        int i3;
        byte[] trimByteArray = CVCObject.trimByteArray(eCPoint.getAffineX().toByteArray());
        byte[] trimByteArray2 = CVCObject.trimByteArray(eCPoint.getAffineY().toByteArray());
        if (ellipticCurve != null) {
            i = (ellipticCurve.getField().getFieldSize() + 7) >> 3;
        } else if (trimByteArray.length > trimByteArray2.length) {
            i = trimByteArray.length;
        } else {
            i = trimByteArray2.length;
        }
        if (trimByteArray.length < i) {
            i2 = i - trimByteArray.length;
        } else {
            i2 = 0;
        }
        if (trimByteArray2.length < i) {
            i3 = i - trimByteArray2.length;
        } else {
            i3 = 0;
        }
        byte[] bArr = new byte[((i << 1) + 1)];
        Arrays.fill(bArr, (byte) 0);
        bArr[0] = 4;
        System.arraycopy(trimByteArray, 0, bArr, i2 + 1, i - i2);
        System.arraycopy(trimByteArray2, 0, bArr, i + 1 + i3, i - i3);
        return bArr;
    }

    public String getAlgorithm() {
        return "ECDSA";
    }

    public CVCTagEnum[] getAllowedFields() {
        return allowedFields;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r3.getAuthRole().isCVCA() != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r3 == null) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.fis.ekyc.nfc.build_in.cvc.CVCObject> getEncodableFields() {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ NoSuchFieldException -> 0x0042 }
            r0.<init>()     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r1 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.OID     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            java.security.spec.ECParameterSpec r1 = r7.getParams()     // Catch:{ NoSuchFieldException -> 0x0042 }
            r2 = 0
            if (r1 == 0) goto L_0x0047
            com.fis.ekyc.nfc.build_in.cvc.AbstractSequence r3 = r7.getParent()     // Catch:{ NoSuchFieldException -> 0x0042 }
            r4 = 1
            if (r3 == 0) goto L_0x0044
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r5 = r3.getTag()     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r6 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.CERTIFICATE_BODY     // Catch:{ NoSuchFieldException -> 0x0042 }
            if (r5 != r6) goto L_0x0044
            com.fis.ekyc.nfc.build_in.cvc.CVCertificateBody r3 = (com.fis.ekyc.nfc.build_in.cvc.CVCertificateBody) r3     // Catch:{ NoSuchFieldException -> 0x0047 }
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r5 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.HOLDER_AUTH_TEMPLATE     // Catch:{ NoSuchFieldException -> 0x0047 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r3 = r3.getOptionalSubfield(r5)     // Catch:{ NoSuchFieldException -> 0x0047 }
            if (r3 != 0) goto L_0x002f
            goto L_0x0046
        L_0x002f:
            com.fis.ekyc.nfc.build_in.cvc.CVCAuthorizationTemplate r3 = (com.fis.ekyc.nfc.build_in.cvc.CVCAuthorizationTemplate) r3     // Catch:{ NoSuchFieldException -> 0x0047 }
            com.fis.ekyc.nfc.build_in.cvc.AuthorizationField r3 = r3.getAuthorizationField()     // Catch:{ NoSuchFieldException -> 0x0047 }
            if (r3 == 0) goto L_0x0047
            com.fis.ekyc.nfc.build_in.cvc.AuthorizationRole r3 = r3.getAuthRole()     // Catch:{ NoSuchFieldException -> 0x0047 }
            boolean r3 = r3.isCVCA()     // Catch:{ NoSuchFieldException -> 0x0047 }
            if (r3 == 0) goto L_0x0047
            goto L_0x0046
        L_0x0042:
            r0 = move-exception
            goto L_0x0097
        L_0x0044:
            if (r3 != 0) goto L_0x0047
        L_0x0046:
            r2 = r4
        L_0x0047:
            if (r2 == 0) goto L_0x0082
            java.security.spec.EllipticCurve r1 = r1.getCurve()     // Catch:{ NoSuchFieldException -> 0x0042 }
            java.security.spec.ECField r1 = r1.getField()     // Catch:{ NoSuchFieldException -> 0x0042 }
            boolean r1 = r1 instanceof java.security.spec.ECFieldFp     // Catch:{ NoSuchFieldException -> 0x0042 }
            if (r1 == 0) goto L_0x005e
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r1 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.MODULUS     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
        L_0x005e:
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r1 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.COEFFICIENT_A     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r1 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.COEFFICIENT_B     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r1 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.BASE_POINT_G     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r1 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.BASE_POINT_R_ORDER     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
        L_0x0082:
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r1 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.PUBLIC_POINT_Y     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            if (r2 == 0) goto L_0x0096
            com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r1 = com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum.COFACTOR_F     // Catch:{ NoSuchFieldException -> 0x0042 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0042 }
        L_0x0096:
            return r0
        L_0x0097:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.cvc.PublicKeyEC.getEncodableFields():java.util.List");
    }

    public String getFormat() {
        return "CVC";
    }

    public ECParameterSpec getParams() {
        ByteField byteField = (ByteField) getOptionalSubfield(CVCTagEnum.MODULUS);
        ByteField byteField2 = (ByteField) getOptionalSubfield(CVCTagEnum.COEFFICIENT_A);
        ByteField byteField3 = (ByteField) getOptionalSubfield(CVCTagEnum.COEFFICIENT_B);
        ByteField byteField4 = (ByteField) getOptionalSubfield(CVCTagEnum.BASE_POINT_G);
        ByteField byteField5 = (ByteField) getOptionalSubfield(CVCTagEnum.BASE_POINT_R_ORDER);
        IntegerField integerField = (IntegerField) getOptionalSubfield(CVCTagEnum.COFACTOR_F);
        if (byteField == null) {
            return null;
        }
        EllipticCurve ellipticCurve = new EllipticCurve(new ECFieldFp(new BigInteger(1, byteField.getData())), new BigInteger(1, byteField2.getData()), new BigInteger(1, byteField3.getData()));
        return new ECParameterSpec(ellipticCurve, ECPointUtil.decodePoint(ellipticCurve, byteField4.getData()), new BigInteger(1, byteField5.getData()), integerField.getValue());
    }

    public ECPoint getW() {
        try {
            return decodePoint(((ByteField) getSubfield(CVCTagEnum.PUBLIC_POINT_Y)).getData());
        } catch (NoSuchFieldException e) {
            throw new IllegalStateException(e);
        }
    }

    public PublicKeyEC(OIDField oIDField, ECPublicKey eCPublicKey, AuthorizationRole authorizationRole) throws ConstructionException {
        addSubfield(oIDField);
        ECParameterSpec params = eCPublicKey.getParams();
        boolean z = authorizationRole == null || authorizationRole.isCVCA();
        if (z) {
            ECField field = params.getCurve().getField();
            if (field instanceof ECFieldFp) {
                addSubfield(new ByteField(CVCTagEnum.MODULUS, CVCObject.trimByteArray(((ECFieldFp) field).getP().toByteArray())));
            }
            addSubfield(new ByteField(CVCTagEnum.COEFFICIENT_A, CVCObject.trimByteArray(params.getCurve().getA().toByteArray())));
            addSubfield(new ByteField(CVCTagEnum.COEFFICIENT_B, CVCObject.trimByteArray(params.getCurve().getB().toByteArray())));
            addSubfield(new ByteField(CVCTagEnum.BASE_POINT_G, encodePoint(params.getGenerator(), params.getCurve())));
            addSubfield(new ByteField(CVCTagEnum.BASE_POINT_R_ORDER, CVCObject.trimByteArray(params.getOrder().toByteArray())));
        }
        addSubfield(new ByteField(CVCTagEnum.PUBLIC_POINT_Y, encodePoint(eCPublicKey.getW(), params.getCurve())));
        if (z) {
            addSubfield(new IntegerField(CVCTagEnum.COFACTOR_F, params.getCofactor()));
        }
    }

    public PublicKeyEC(OIDField oIDField, ECPublicKey eCPublicKey, AuthorizationRoleEnum authorizationRoleEnum) throws ConstructionException {
        this(oIDField, eCPublicKey, (AuthorizationRole) authorizationRoleEnum);
    }
}
