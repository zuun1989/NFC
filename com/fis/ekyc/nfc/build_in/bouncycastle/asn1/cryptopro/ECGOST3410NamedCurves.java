package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.WNafUtil;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;

public class ECGOST3410NamedCurves {
    static final Hashtable names;
    static final Hashtable objIds;
    static final Hashtable params;

    static {
        Hashtable hashtable = new Hashtable();
        objIds = hashtable;
        Hashtable hashtable2 = new Hashtable();
        params = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        names = hashtable3;
        BigInteger bigInteger = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger2 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        BigInteger bigInteger3 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316");
        BigInteger bigInteger4 = new BigInteger("166");
        BigInteger bigInteger5 = ECConstants.ONE;
        ECCurve configureCurve = configureCurve(new ECCurve.Fp(bigInteger, bigInteger3, bigInteger4, bigInteger2, bigInteger5));
        ECDomainParameters eCDomainParameters = new ECDomainParameters(configureCurve, configureBasepoint(configureCurve, new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), bigInteger2, bigInteger5);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A;
        hashtable2.put(aSN1ObjectIdentifier, eCDomainParameters);
        BigInteger bigInteger6 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger7 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        BigInteger bigInteger8 = bigInteger5;
        BigInteger bigInteger9 = bigInteger8;
        ECCurve configureCurve2 = configureCurve(new ECCurve.Fp(bigInteger6, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), bigInteger7, bigInteger9));
        ECDomainParameters eCDomainParameters2 = new ECDomainParameters(configureCurve2, configureBasepoint(configureCurve2, new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), bigInteger7, bigInteger8);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA;
        hashtable2.put(aSN1ObjectIdentifier2, eCDomainParameters2);
        BigInteger bigInteger10 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
        BigInteger bigInteger11 = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
        ECCurve configureCurve3 = configureCurve(new ECCurve.Fp(bigInteger10, new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823190"), new BigInteger("28091019353058090096996979000309560759124368558014865957655842872397301267595"), bigInteger11, bigInteger9));
        ECDomainParameters eCDomainParameters3 = new ECDomainParameters(configureCurve3, configureBasepoint(configureCurve3, new BigInteger("1"), new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124")), bigInteger11, bigInteger8);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B;
        hashtable2.put(aSN1ObjectIdentifier3, eCDomainParameters3);
        BigInteger bigInteger12 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger13 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        Hashtable hashtable4 = hashtable3;
        ECCurve configureCurve4 = configureCurve(new ECCurve.Fp(bigInteger12, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), bigInteger13, bigInteger9));
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = aSN1ObjectIdentifier2;
        ECDomainParameters eCDomainParameters4 = new ECDomainParameters(configureCurve4, configureBasepoint(configureCurve4, new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), bigInteger13, bigInteger8);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB;
        hashtable2.put(aSN1ObjectIdentifier5, eCDomainParameters4);
        BigInteger bigInteger14 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger15 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        ECCurve configureCurve5 = configureCurve(new ECCurve.Fp(bigInteger14, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), bigInteger15, bigInteger9));
        ECDomainParameters eCDomainParameters5 = new ECDomainParameters(configureCurve5, configureBasepoint(configureCurve5, new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), bigInteger15, bigInteger8);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C;
        hashtable2.put(aSN1ObjectIdentifier6, eCDomainParameters5);
        BigInteger bigInteger16 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD97", 16);
        BigInteger bigInteger17 = new BigInteger("400000000000000000000000000000000FD8CDDFC87B6635C115AF556C360C67", 16);
        BigInteger bigInteger18 = new BigInteger("C2173F1513981673AF4892C23035A27CE25E2013BF95AA33B22C656F277E7335", 16);
        BigInteger bigInteger19 = new BigInteger("295F9BAE7428ED9CCC20E7C359A9D41A22FCCD9108E17BF7BA9337A6F8AE9513", 16);
        BigInteger bigInteger20 = ECConstants.FOUR;
        ECCurve configureCurve6 = configureCurve(new ECCurve.Fp(bigInteger16, bigInteger18, bigInteger19, bigInteger17, bigInteger20));
        ECDomainParameters eCDomainParameters6 = new ECDomainParameters(configureCurve6, configureBasepoint(configureCurve6, new BigInteger("91E38443A5E82C0D880923425712B2BB658B9196932E02C78B2582FE742DAA28", 16), new BigInteger("32879423AB1A0375895786C4BB46E9565FDE0B5344766740AF268ADB32322E5C", 16)), bigInteger17, bigInteger20);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256_paramSetA;
        hashtable2.put(aSN1ObjectIdentifier7, eCDomainParameters6);
        BigInteger bigInteger21 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
        BigInteger bigInteger22 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF27E69532F48D89116FF22B8D4E0560609B4B38ABFAD2B85DCACDB1411F10B275", 16);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = aSN1ObjectIdentifier7;
        ECCurve configureCurve7 = configureCurve(new ECCurve.Fp(bigInteger21, new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC4", 16), new BigInteger("E8C2505DEDFC86DDC1BD0B2B6667F1DA34B82574761CB0E879BD081CFD0B6265EE3CB090F30D27614CB4574010DA90DD862EF9D4EBEE4761503190785A71C760", 16), bigInteger22, bigInteger9));
        ECDomainParameters eCDomainParameters7 = new ECDomainParameters(configureCurve7, configureBasepoint(configureCurve7, new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003"), new BigInteger("7503CFE87A836AE3A61B8816E25450E6CE5E1C93ACF1ABC1778064FDCBEFA921DF1626BE4FD036E93D75E6A50E3A41E98028FE5FC235F5B889A589CB5215F2A4", 16)), bigInteger22, bigInteger8);
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetA;
        hashtable2.put(aSN1ObjectIdentifier9, eCDomainParameters7);
        BigInteger bigInteger23 = new BigInteger("8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006F", 16);
        BigInteger bigInteger24 = new BigInteger("800000000000000000000000000000000000000000000000000000000000000149A1EC142565A545ACFDB77BD9D40CFA8B996712101BEA0EC6346C54374F25BD", 16);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = aSN1ObjectIdentifier9;
        ECCurve configureCurve8 = configureCurve(new ECCurve.Fp(bigInteger23, new BigInteger("8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006C", 16), new BigInteger("687D1B459DC841457E3E06CF6F5E2517B97C7D614AF138BCBF85DC806C4B289F3E965D2DB1416D217F8B276FAD1AB69C50F78BEE1FA3106EFB8CCBC7C5140116", 16), bigInteger24, bigInteger9));
        ECDomainParameters eCDomainParameters8 = new ECDomainParameters(configureCurve8, configureBasepoint(configureCurve8, new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002"), new BigInteger("1A8F7EDA389B094C2C071E3647A8940F3C123B697578C213BE6DD9E6C8EC7335DCB228FD1EDF4A39152CBCAAF8C0398828041055F94CEEEC7E21340780FE41BD", 16)), bigInteger24, bigInteger8);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetB;
        hashtable2.put(aSN1ObjectIdentifier11, eCDomainParameters8);
        BigInteger bigInteger25 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
        BigInteger bigInteger26 = new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC98CDBA46506AB004C33A9FF5147502CC8EDA9E7A769A12694623CEF47F023ED", 16);
        ECCurve configureCurve9 = configureCurve(new ECCurve.Fp(bigInteger25, new BigInteger("DC9203E514A721875485A529D2C722FB187BC8980EB866644DE41C68E143064546E861C0E2C9EDD92ADE71F46FCF50FF2AD97F951FDA9F2A2EB6546F39689BD3", 16), new BigInteger("B4C4EE28CEBC6C2C8AC12952CF37F16AC7EFB6A9F69F4B57FFDA2E4F0DE5ADE038CBC2FFF719D2C18DE0284B8BFEF3B52B8CC7A5F5BF0A3C8D2319A5312557E1", 16), bigInteger26, bigInteger20));
        ECDomainParameters eCDomainParameters9 = new ECDomainParameters(configureCurve9, configureBasepoint(configureCurve9, new BigInteger("E2E31EDFC23DE7BDEBE241CE593EF5DE2295B7A9CBAEF021D385F7074CEA043AA27272A7AE602BF2A7B9033DB9ED3610C6FB85487EAE97AAC5BC7928C1950148", 16), new BigInteger("F5CE40D95B5EB899ABBCCFF5911CB8577939804D6527378B8C108C3D2090FF9BE18E2D33E3021ED2EF32D85822423B6304F726AA854BAE07D0396E9A9ADDC40F", 16)), bigInteger26, bigInteger20);
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512_paramSetC;
        hashtable2.put(aSN1ObjectIdentifier12, eCDomainParameters9);
        hashtable.put("GostR3410-2001-CryptoPro-A", aSN1ObjectIdentifier);
        hashtable.put("GostR3410-2001-CryptoPro-B", aSN1ObjectIdentifier3);
        hashtable.put("GostR3410-2001-CryptoPro-C", aSN1ObjectIdentifier6);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = aSN1ObjectIdentifier4;
        hashtable.put("GostR3410-2001-CryptoPro-XchA", aSN1ObjectIdentifier13);
        hashtable.put("GostR3410-2001-CryptoPro-XchB", aSN1ObjectIdentifier5);
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = aSN1ObjectIdentifier8;
        hashtable.put("Tc26-Gost-3410-12-256-paramSetA", aSN1ObjectIdentifier14);
        hashtable.put("Tc26-Gost-3410-12-512-paramSetA", aSN1ObjectIdentifier10);
        hashtable.put("Tc26-Gost-3410-12-512-paramSetB", aSN1ObjectIdentifier11);
        hashtable.put("Tc26-Gost-3410-12-512-paramSetC", aSN1ObjectIdentifier12);
        Hashtable hashtable5 = hashtable4;
        hashtable5.put(aSN1ObjectIdentifier, "GostR3410-2001-CryptoPro-A");
        hashtable5.put(aSN1ObjectIdentifier3, "GostR3410-2001-CryptoPro-B");
        hashtable5.put(aSN1ObjectIdentifier6, "GostR3410-2001-CryptoPro-C");
        hashtable5.put(aSN1ObjectIdentifier13, "GostR3410-2001-CryptoPro-XchA");
        hashtable5.put(aSN1ObjectIdentifier5, "GostR3410-2001-CryptoPro-XchB");
        hashtable5.put(aSN1ObjectIdentifier14, "Tc26-Gost-3410-12-256-paramSetA");
        hashtable5.put(aSN1ObjectIdentifier10, "Tc26-Gost-3410-12-512-paramSetA");
        hashtable5.put(aSN1ObjectIdentifier11, "Tc26-Gost-3410-12-512-paramSetB");
        hashtable5.put(aSN1ObjectIdentifier12, "Tc26-Gost-3410-12-512-paramSetC");
    }

    private static ECPoint configureBasepoint(ECCurve eCCurve, BigInteger bigInteger, BigInteger bigInteger2) {
        ECPoint createPoint = eCCurve.createPoint(bigInteger, bigInteger2);
        WNafUtil.configureBasepoint(createPoint);
        return createPoint;
    }

    private static ECCurve configureCurve(ECCurve eCCurve) {
        return eCCurve;
    }

    public static ECDomainParameters getByName(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) objIds.get(str);
        if (aSN1ObjectIdentifier == null) {
            return null;
        }
        return (ECDomainParameters) params.get(aSN1ObjectIdentifier);
    }

    public static X9ECParameters getByNameX9(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) objIds.get(str);
        if (aSN1ObjectIdentifier == null) {
            return null;
        }
        return getByOIDX9(aSN1ObjectIdentifier);
    }

    public static ECDomainParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (ECDomainParameters) params.get(aSN1ObjectIdentifier);
    }

    public static X9ECParameters getByOIDX9(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        ECDomainParameters eCDomainParameters = (ECDomainParameters) params.get(aSN1ObjectIdentifier);
        if (eCDomainParameters == null) {
            return null;
        }
        return new X9ECParameters(eCDomainParameters.getCurve(), new X9ECPoint(eCDomainParameters.getG(), false), eCDomainParameters.getN(), eCDomainParameters.getH(), eCDomainParameters.getSeed());
    }

    public static String getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) names.get(aSN1ObjectIdentifier);
    }

    public static Enumeration getNames() {
        return names.elements();
    }

    public static ASN1ObjectIdentifier getOID(String str) {
        return (ASN1ObjectIdentifier) objIds.get(str);
    }
}
