package com.fis.ekyc.nfc.build_in.bouncycastle.i18n.filter;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.EACTags;

public class HTMLFilter implements Filter {
    public String doFilter(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        while (i < stringBuffer.length()) {
            char charAt = stringBuffer.charAt(i);
            if (charAt == '\"') {
                stringBuffer.replace(i, i + 1, "&#34");
            } else if (charAt == '#') {
                stringBuffer.replace(i, i + 1, "&#35");
            } else if (charAt == '+') {
                stringBuffer.replace(i, i + 1, "&#43");
            } else if (charAt == '-') {
                stringBuffer.replace(i, i + 1, "&#45");
            } else if (charAt == '>') {
                stringBuffer.replace(i, i + 1, "&#62");
            } else if (charAt == ';') {
                stringBuffer.replace(i, i + 1, "&#59");
            } else if (charAt != '<') {
                switch (charAt) {
                    case '%':
                        stringBuffer.replace(i, i + 1, "&#37");
                        break;
                    case EACTags.CARD_EFFECTIVE_DATE:
                        stringBuffer.replace(i, i + 1, "&#38");
                        break;
                    case EACTags.INTERCHANGE_CONTROL:
                        stringBuffer.replace(i, i + 1, "&#39");
                        break;
                    case '(':
                        stringBuffer.replace(i, i + 1, "&#40");
                        break;
                    case EACTags.INTERCHANGE_PROFILE:
                        stringBuffer.replace(i, i + 1, "&#41");
                        break;
                    default:
                        i -= 3;
                        break;
                }
            } else {
                stringBuffer.replace(i, i + 1, "&#60");
            }
            i += 4;
        }
        return stringBuffer.toString();
    }

    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
