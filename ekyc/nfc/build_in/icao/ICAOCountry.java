package com.fis.ekyc.nfc.build_in.eidparser.lds.icao;

import com.fis.ekyc.nfc.build_in.scuba.data.Country;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ICAOCountry extends Country {
    public static final ICAOCountry DE;
    public static final ICAOCountry EUE;
    public static final ICAOCountry GBD;
    public static final ICAOCountry GBN;
    public static final ICAOCountry GBO;
    public static final ICAOCountry GBP;
    public static final ICAOCountry GBS;
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    public static final ICAOCountry UNA;
    public static final ICAOCountry UNK;
    public static final ICAOCountry UNO;
    private static final ICAOCountry[] VALUES;
    public static final ICAOCountry XBA;
    public static final ICAOCountry XCC;
    public static final ICAOCountry XCO;
    public static final ICAOCountry XEC;
    public static final ICAOCountry XIM;
    public static final ICAOCountry XOM;
    public static final ICAOCountry XPO;
    public static final ICAOCountry XXA;
    public static final ICAOCountry XXB;
    public static final ICAOCountry XXC;
    public static final ICAOCountry XXX;
    private static final long serialVersionUID = 2942942609311086138L;
    private String alpha2Code;
    private String alpha3Code;
    private String name;
    private String nationality;

    static {
        ICAOCountry iCAOCountry = r0;
        ICAOCountry iCAOCountry2 = new ICAOCountry("DE", "D<<", "Germany", "German");
        DE = iCAOCountry2;
        ICAOCountry iCAOCountry3 = r0;
        ICAOCountry iCAOCountry4 = new ICAOCountry("GB", "GBD", "British Dependent territories citizen");
        GBD = iCAOCountry4;
        ICAOCountry iCAOCountry5 = r0;
        ICAOCountry iCAOCountry6 = new ICAOCountry("GB", "GBN", "British National (Overseas)");
        GBN = iCAOCountry6;
        ICAOCountry iCAOCountry7 = r0;
        ICAOCountry iCAOCountry8 = new ICAOCountry("GB", "GBO", "British Overseas citizen");
        GBO = iCAOCountry8;
        ICAOCountry iCAOCountry9 = r0;
        ICAOCountry iCAOCountry10 = new ICAOCountry("GB", "GBP", "British Protected person");
        GBP = iCAOCountry10;
        ICAOCountry iCAOCountry11 = r0;
        ICAOCountry iCAOCountry12 = new ICAOCountry("GB", "GBS", "British Subject");
        GBS = iCAOCountry12;
        ICAOCountry iCAOCountry13 = r0;
        ICAOCountry iCAOCountry14 = new ICAOCountry("XX", "XXA", "Stateless person", "Stateless");
        XXA = iCAOCountry14;
        ICAOCountry iCAOCountry15 = r0;
        ICAOCountry iCAOCountry16 = new ICAOCountry("XX", "XXB", "Refugee", "Refugee");
        XXB = iCAOCountry16;
        ICAOCountry iCAOCountry17 = r0;
        ICAOCountry iCAOCountry18 = new ICAOCountry("XX", "XXC", "Refugee (other)", "Refugee (other)");
        XXC = iCAOCountry18;
        ICAOCountry iCAOCountry19 = r0;
        ICAOCountry iCAOCountry20 = new ICAOCountry("XX", "XXX", "Unspecified", "Unspecified");
        XXX = iCAOCountry20;
        ICAOCountry iCAOCountry21 = r0;
        ICAOCountry iCAOCountry22 = new ICAOCountry("EU", "EUE", "Europe", "European");
        EUE = iCAOCountry22;
        ICAOCountry iCAOCountry23 = r0;
        ICAOCountry iCAOCountry24 = new ICAOCountry("UN", "UNO", "United Nations Organization");
        UNO = iCAOCountry24;
        ICAOCountry iCAOCountry25 = r0;
        ICAOCountry iCAOCountry26 = iCAOCountry;
        ICAOCountry iCAOCountry27 = new ICAOCountry("UN", "UNA", "United Nations Agency");
        UNA = iCAOCountry27;
        ICAOCountry iCAOCountry28 = r0;
        ICAOCountry iCAOCountry29 = new ICAOCountry("UN", "UNK", "United Nations Interim Administration Mission in Kosovo");
        UNK = iCAOCountry29;
        String str = "XX";
        ICAOCountry iCAOCountry30 = r0;
        ICAOCountry iCAOCountry31 = new ICAOCountry(str, "XBA", "African Development Bank (ADB)");
        XBA = iCAOCountry31;
        ICAOCountry iCAOCountry32 = r0;
        ICAOCountry iCAOCountry33 = new ICAOCountry(str, "XIM", "African Export-Import Bank (AFREXIM bank)");
        XIM = iCAOCountry33;
        ICAOCountry iCAOCountry34 = r0;
        ICAOCountry iCAOCountry35 = new ICAOCountry("XC", "XCC", "Carribean Community or one of its emissaries (CARICOM)");
        XCC = iCAOCountry35;
        ICAOCountry iCAOCountry36 = r0;
        ICAOCountry iCAOCountry37 = new ICAOCountry(str, "XCO", "Common Market for Eastern an Southern Africa (COMESA)");
        XCO = iCAOCountry37;
        ICAOCountry iCAOCountry38 = r0;
        ICAOCountry iCAOCountry39 = new ICAOCountry(str, "XEC", "Economic Community of West African States (ECOWAS)");
        XEC = iCAOCountry39;
        ICAOCountry iCAOCountry40 = r0;
        ICAOCountry iCAOCountry41 = new ICAOCountry("XP", "XPO", "International Criminal Police Organization (INTERPOL)");
        XPO = iCAOCountry41;
        ICAOCountry iCAOCountry42 = r0;
        ICAOCountry iCAOCountry43 = new ICAOCountry("XO", "XOM", "Sovereign Military Order of Malta or one of its emissaries");
        XOM = iCAOCountry43;
        VALUES = new ICAOCountry[]{iCAOCountry26, iCAOCountry3, iCAOCountry5, iCAOCountry7, iCAOCountry9, iCAOCountry11, iCAOCountry13, iCAOCountry15, iCAOCountry17, iCAOCountry19, iCAOCountry21, iCAOCountry23, iCAOCountry25, iCAOCountry28, iCAOCountry30, iCAOCountry32, iCAOCountry34, iCAOCountry36, iCAOCountry38, iCAOCountry40, iCAOCountry42};
    }

    private ICAOCountry() {
    }

    public static Country getInstance(String str) {
        for (ICAOCountry iCAOCountry : VALUES) {
            if (iCAOCountry.alpha3Code.equals(str)) {
                return iCAOCountry;
            }
        }
        try {
            return Country.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Unknown country", e);
            throw new IllegalArgumentException("Illegal ICAO country alpha 3 code " + str);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String toAlpha2Code() {
        return this.alpha2Code;
    }

    public String toAlpha3Code() {
        return this.alpha3Code;
    }

    public int valueOf() {
        return -1;
    }

    private ICAOCountry(String str, String str2, String str3) {
        this(str, str2, str3, str3);
    }

    private ICAOCountry(String str, String str2, String str3, String str4) {
        this.alpha2Code = str;
        this.alpha3Code = str2;
        this.name = str3;
        this.nationality = str4;
    }
}
