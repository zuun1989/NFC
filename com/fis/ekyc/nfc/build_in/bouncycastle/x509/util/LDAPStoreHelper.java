package com.fis.ekyc.nfc.build_in.bouncycastle.x509.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.X509LDAPCertStoreParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.X509AttrCertParser;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.X509CRLParser;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.X509CertParser;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.StoreException;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertStoreSelector;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertPairStoreSelector;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertStoreSelector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public class LDAPStoreHelper {
    private static String LDAP_PROVIDER = "com.sun.jndi.ldap.LdapCtxFactory";
    private static String REFERRALS_IGNORE = "ignore";
    private static final String SEARCH_SECURITY_LEVEL = "none";
    private static final String URL_CONTEXT_PREFIX = "com.sun.jndi.url";
    private static int cacheSize = 32;
    private static long lifeTime = 60000;
    private Map cacheMap = new HashMap(cacheSize);
    private X509LDAPCertStoreParameters params;

    public LDAPStoreHelper(X509LDAPCertStoreParameters x509LDAPCertStoreParameters) {
        this.params = x509LDAPCertStoreParameters;
    }

    private synchronized void addToCache(String str, List list) {
        try {
            Date date = new Date(System.currentTimeMillis());
            ArrayList arrayList = new ArrayList();
            arrayList.add(date);
            arrayList.add(list);
            if (this.cacheMap.containsKey(str)) {
                this.cacheMap.put(str, arrayList);
            } else {
                if (this.cacheMap.size() >= cacheSize) {
                    long time = date.getTime();
                    Object obj = null;
                    for (Map.Entry entry : this.cacheMap.entrySet()) {
                        long time2 = ((Date) ((List) entry.getValue()).get(0)).getTime();
                        if (time2 < time) {
                            obj = entry.getKey();
                            time = time2;
                        }
                    }
                    this.cacheMap.remove(obj);
                }
                this.cacheMap.put(str, arrayList);
            }
        } finally {
            while (true) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0098 A[LOOP:0: B:26:0x0098->B:28:0x009b, LOOP_START, PHI: r4 
      PHI: (r4v5 int) = (r4v1 int), (r4v6 int) binds: [B:25:0x0096, B:28:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d5 A[LOOP:1: B:34:0x00cf->B:36:0x00d5, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List attrCertSubjectSerialSearch(com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertStoreSelector r7, java.lang.String[] r8, java.lang.String[] r9, java.lang.String[] r10) throws com.fis.ekyc.nfc.build_in.bouncycastle.util.StoreException {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.AttributeCertificateHolder r2 = r7.getHolder()
            r3 = 0
            if (r2 == 0) goto L_0x003d
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.AttributeCertificateHolder r2 = r7.getHolder()
            java.math.BigInteger r2 = r2.getSerialNumber()
            if (r2 == 0) goto L_0x002a
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.AttributeCertificateHolder r2 = r7.getHolder()
            java.math.BigInteger r2 = r2.getSerialNumber()
            java.lang.String r2 = r2.toString()
            r1.add(r2)
        L_0x002a:
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.AttributeCertificateHolder r2 = r7.getHolder()
            java.security.Principal[] r2 = r2.getEntityNames()
            if (r2 == 0) goto L_0x003d
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.AttributeCertificateHolder r2 = r7.getHolder()
            java.security.Principal[] r2 = r2.getEntityNames()
            goto L_0x003e
        L_0x003d:
            r2 = r3
        L_0x003e:
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertificate r4 = r7.getAttributeCert()
            if (r4 == 0) goto L_0x006d
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertificate r4 = r7.getAttributeCert()
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.AttributeCertificateHolder r4 = r4.getHolder()
            java.security.Principal[] r4 = r4.getEntityNames()
            if (r4 == 0) goto L_0x005e
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertificate r2 = r7.getAttributeCert()
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.AttributeCertificateHolder r2 = r2.getHolder()
            java.security.Principal[] r2 = r2.getEntityNames()
        L_0x005e:
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertificate r4 = r7.getAttributeCert()
            java.math.BigInteger r4 = r4.getSerialNumber()
            java.lang.String r4 = r4.toString()
            r1.add(r4)
        L_0x006d:
            r4 = 0
            if (r2 == 0) goto L_0x0083
            r2 = r2[r4]
            boolean r3 = r2 instanceof javax.security.auth.x500.X500Principal
            if (r3 == 0) goto L_0x007f
            javax.security.auth.x500.X500Principal r2 = (javax.security.auth.x500.X500Principal) r2
            java.lang.String r3 = "RFC1779"
            java.lang.String r3 = r2.getName(r3)
            goto L_0x0083
        L_0x007f:
            java.lang.String r3 = r2.getName()
        L_0x0083:
            java.math.BigInteger r2 = r7.getSerialNumber()
            if (r2 == 0) goto L_0x0094
            java.math.BigInteger r7 = r7.getSerialNumber()
            java.lang.String r7 = r7.toString()
            r1.add(r7)
        L_0x0094:
            java.lang.String r7 = "*"
            if (r3 == 0) goto L_0x00bd
        L_0x0098:
            int r2 = r10.length
            if (r4 >= r2) goto L_0x00bd
            r2 = r10[r4]
            java.lang.String r2 = r6.parseDN(r3, r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r7)
            r5.append(r2)
            r5.append(r7)
            java.lang.String r2 = r5.toString()
            java.util.List r2 = r6.search(r9, r2, r8)
            r0.addAll(r2)
            int r4 = r4 + 1
            goto L_0x0098
        L_0x00bd:
            int r10 = r1.size()
            if (r10 <= 0) goto L_0x00ed
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.X509LDAPCertStoreParameters r10 = r6.params
            java.lang.String r10 = r10.getSearchForSerialNumberIn()
            if (r10 == 0) goto L_0x00ed
            java.util.Iterator r10 = r1.iterator()
        L_0x00cf:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00ed
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.X509LDAPCertStoreParameters r4 = r6.params
            java.lang.String r4 = r4.getSearchForSerialNumberIn()
            java.lang.String[] r4 = r6.splitString(r4)
            java.util.List r2 = r6.search(r4, r2, r8)
            r0.addAll(r2)
            goto L_0x00cf
        L_0x00ed:
            int r10 = r1.size()
            if (r10 != 0) goto L_0x00fc
            if (r3 != 0) goto L_0x00fc
            java.util.List r7 = r6.search(r9, r7, r8)
            r0.addAll(r7)
        L_0x00fc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.x509.util.LDAPStoreHelper.attrCertSubjectSerialSearch(com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertStoreSelector, java.lang.String[], java.lang.String[], java.lang.String[]):java.util.List");
    }

    private List cRLIssuerSearch(X509CRLStoreSelector x509CRLStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) throws StoreException {
        ArrayList arrayList = new ArrayList();
        HashSet<X500Principal> hashSet = new HashSet<>();
        if (x509CRLStoreSelector.getIssuers() != null) {
            hashSet.addAll(x509CRLStoreSelector.getIssuers());
        }
        if (x509CRLStoreSelector.getCertificateChecking() != null) {
            hashSet.add(getCertificateIssuer(x509CRLStoreSelector.getCertificateChecking()));
        }
        if (x509CRLStoreSelector.getAttrCertificateChecking() != null) {
            Principal[] principals = x509CRLStoreSelector.getAttrCertificateChecking().getIssuer().getPrincipals();
            for (Principal principal : principals) {
                if (principal instanceof X500Principal) {
                    hashSet.add(principal);
                }
            }
        }
        String str = null;
        for (X500Principal name : hashSet) {
            str = name.getName("RFC1779");
            for (String parseDN : strArr3) {
                arrayList.addAll(search(strArr2, "*" + parseDN(str, parseDN) + "*", strArr));
            }
        }
        if (str == null) {
            arrayList.addAll(search(strArr2, "*", strArr));
        }
        return arrayList;
    }

    private List certSubjectSerialSearch(X509CertStoreSelector x509CertStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) throws StoreException {
        String str;
        ArrayList arrayList = new ArrayList();
        String subjectAsString = getSubjectAsString(x509CertStoreSelector);
        if (x509CertStoreSelector.getSerialNumber() != null) {
            str = x509CertStoreSelector.getSerialNumber().toString();
        } else {
            str = null;
        }
        if (x509CertStoreSelector.getCertificate() != null) {
            subjectAsString = x509CertStoreSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
            str = x509CertStoreSelector.getCertificate().getSerialNumber().toString();
        }
        if (subjectAsString != null) {
            for (String parseDN : strArr3) {
                arrayList.addAll(search(strArr2, "*" + parseDN(subjectAsString, parseDN) + "*", strArr));
            }
        }
        if (!(str == null || this.params.getSearchForSerialNumberIn() == null)) {
            arrayList.addAll(search(splitString(this.params.getSearchForSerialNumberIn()), str, strArr));
        }
        if (str == null && subjectAsString == null) {
            arrayList.addAll(search(strArr2, "*", strArr));
        }
        return arrayList;
    }

    private Set createAttributeCertificates(List list, X509AttributeCertStoreSelector x509AttributeCertStoreSelector) throws StoreException {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        X509AttrCertParser x509AttrCertParser = new X509AttrCertParser();
        while (it.hasNext()) {
            try {
                x509AttrCertParser.engineInit(new ByteArrayInputStream((byte[]) it.next()));
                X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) x509AttrCertParser.engineRead();
                if (x509AttributeCertStoreSelector.match(x509AttributeCertificate)) {
                    hashSet.add(x509AttributeCertificate);
                }
            } catch (StreamParsingException unused) {
            }
        }
        return hashSet;
    }

    private Set createCRLs(List list, X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        HashSet hashSet = new HashSet();
        X509CRLParser x509CRLParser = new X509CRLParser();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                x509CRLParser.engineInit(new ByteArrayInputStream((byte[]) it.next()));
                X509CRL x509crl = (X509CRL) x509CRLParser.engineRead();
                if (x509CRLStoreSelector.match((Object) x509crl)) {
                    hashSet.add(x509crl);
                }
            } catch (StreamParsingException unused) {
            }
        }
        return hashSet;
    }

    private Set createCerts(List list, X509CertStoreSelector x509CertStoreSelector) throws StoreException {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        X509CertParser x509CertParser = new X509CertParser();
        while (it.hasNext()) {
            try {
                x509CertParser.engineInit(new ByteArrayInputStream((byte[]) it.next()));
                X509Certificate x509Certificate = (X509Certificate) x509CertParser.engineRead();
                if (x509CertStoreSelector.match((Object) x509Certificate)) {
                    hashSet.add(x509Certificate);
                }
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0026 */
    /* JADX WARNING: Removed duplicated region for block: B:11:? A[ExcHandler: IOException | CertificateParsingException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:5:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set createCrossCertificatePairs(java.util.List r9, com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertPairStoreSelector r10) throws com.fis.ekyc.nfc.build_in.bouncycastle.util.StoreException {
        /*
            r8 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r1 = 0
        L_0x0006:
            int r2 = r9.size()
            if (r1 >= r2) goto L_0x0066
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.X509CertPairParser r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.X509CertPairParser     // Catch:{ StreamParsingException -> 0x0026 }
            r2.<init>()     // Catch:{ StreamParsingException -> 0x0026 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ StreamParsingException -> 0x0026 }
            java.lang.Object r4 = r9.get(r1)     // Catch:{ StreamParsingException -> 0x0026 }
            byte[] r4 = (byte[]) r4     // Catch:{ StreamParsingException -> 0x0026 }
            r3.<init>(r4)     // Catch:{ StreamParsingException -> 0x0026 }
            r2.engineInit(r3)     // Catch:{ StreamParsingException -> 0x0026 }
            java.lang.Object r2 = r2.engineRead()     // Catch:{ StreamParsingException -> 0x0026 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertificatePair r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertificatePair) r2     // Catch:{ StreamParsingException -> 0x0026 }
            goto L_0x005a
        L_0x0026:
            java.lang.Object r2 = r9.get(r1)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            byte[] r2 = (byte[]) r2     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            int r3 = r1 + 1
            java.lang.Object r4 = r9.get(r3)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            byte[] r4 = (byte[]) r4     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertificatePair r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertificatePair     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CertificatePair r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CertificatePair     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r7.<init>((byte[]) r2)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r2 = r7.readObject()     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate.getInstance(r2)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r7.<init>((byte[]) r4)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r4 = r7.readObject()     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate.getInstance(r4)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r6.<init>(r2, r4)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r5.<init>(r6)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r1 = r3
            r2 = r5
        L_0x005a:
            boolean r3 = r10.match(r2)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            if (r3 == 0) goto L_0x0063
            r0.add(r2)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
        L_0x0063:
            int r1 = r1 + 1
            goto L_0x0006
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.x509.util.LDAPStoreHelper.createCrossCertificatePairs(java.util.List, com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertPairStoreSelector):java.util.Set");
    }

    private List crossCertificatePairSubjectSearch(X509CertPairStoreSelector x509CertPairStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) throws StoreException {
        String str;
        ArrayList arrayList = new ArrayList();
        if (x509CertPairStoreSelector.getForwardSelector() != null) {
            str = getSubjectAsString(x509CertPairStoreSelector.getForwardSelector());
        } else {
            str = null;
        }
        if (!(x509CertPairStoreSelector.getCertPair() == null || x509CertPairStoreSelector.getCertPair().getForward() == null)) {
            str = x509CertPairStoreSelector.getCertPair().getForward().getSubjectX500Principal().getName("RFC1779");
        }
        if (str != null) {
            for (String parseDN : strArr3) {
                arrayList.addAll(search(strArr2, "*" + parseDN(str, parseDN) + "*", strArr));
            }
        }
        if (str == null) {
            arrayList.addAll(search(strArr2, "*", strArr));
        }
        return arrayList;
    }

    private X500Principal getCertificateIssuer(X509Certificate x509Certificate) {
        return x509Certificate.getIssuerX500Principal();
    }

    private List getFromCache(String str) {
        List list = (List) this.cacheMap.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || ((Date) list.get(0)).getTime() < currentTimeMillis - lifeTime) {
            return null;
        }
        return (List) list.get(1);
    }

    private String getSubjectAsString(X509CertStoreSelector x509CertStoreSelector) {
        try {
            byte[] subjectAsBytes = x509CertStoreSelector.getSubjectAsBytes();
            if (subjectAsBytes != null) {
                return new X500Principal(subjectAsBytes).getName("RFC1779");
            }
            return null;
        } catch (IOException e) {
            throw new StoreException("exception processing name: " + e.getMessage(), e);
        }
    }

    private String parseDN(String str, String str2) {
        int i;
        String lowerCase = str.toLowerCase();
        int indexOf = lowerCase.indexOf(str2.toLowerCase() + "=");
        if (indexOf == -1) {
            return "";
        }
        String substring = str.substring(indexOf + str2.length());
        int indexOf2 = substring.indexOf(44);
        if (indexOf2 == -1) {
            indexOf2 = substring.length();
        }
        while (substring.charAt(i - 1) == '\\') {
            i = substring.indexOf(44, i + 1);
            if (i == -1) {
                i = substring.length();
            }
        }
        String substring2 = substring.substring(0, i);
        String substring3 = substring2.substring(substring2.indexOf(61) + 1);
        if (substring3.charAt(0) == ' ') {
            substring3 = substring3.substring(1);
        }
        if (substring3.startsWith("\"")) {
            substring3 = substring3.substring(1);
        }
        if (substring3.endsWith("\"")) {
            return substring3.substring(0, substring3.length() - 1);
        }
        return substring3;
    }

    private List search(String[] strArr, String str, String[] strArr2) throws StoreException {
        return null;
    }

    private String[] splitString(String str) {
        return str.split("\\s+");
    }

    public Collection getAACertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getAACertificateAttribute());
        String[] splitString2 = splitString(this.params.getLdapAACertificateAttributeName());
        String[] splitString3 = splitString(this.params.getAACertificateSubjectAttributeName());
        Set createAttributeCertificates = createAttributeCertificates(attrCertSubjectSerialSearch(x509AttributeCertStoreSelector, splitString, splitString2, splitString3), x509AttributeCertStoreSelector);
        if (createAttributeCertificates.size() == 0) {
            createAttributeCertificates.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), splitString, splitString2, splitString3), x509AttributeCertStoreSelector));
        }
        return createAttributeCertificates;
    }

    public Collection getAttributeAuthorityRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getAttributeAuthorityRevocationListAttribute());
        String[] splitString2 = splitString(this.params.getLdapAttributeAuthorityRevocationListAttributeName());
        String[] splitString3 = splitString(this.params.getAttributeAuthorityRevocationListIssuerAttributeName());
        Set createCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, splitString, splitString2, splitString3), x509CRLStoreSelector);
        if (createCRLs.size() == 0) {
            createCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), splitString, splitString2, splitString3), x509CRLStoreSelector));
        }
        return createCRLs;
    }

    public Collection getAttributeCertificateAttributes(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getAttributeCertificateAttributeAttribute());
        String[] splitString2 = splitString(this.params.getLdapAttributeCertificateAttributeAttributeName());
        String[] splitString3 = splitString(this.params.getAttributeCertificateAttributeSubjectAttributeName());
        Set createAttributeCertificates = createAttributeCertificates(attrCertSubjectSerialSearch(x509AttributeCertStoreSelector, splitString, splitString2, splitString3), x509AttributeCertStoreSelector);
        if (createAttributeCertificates.size() == 0) {
            createAttributeCertificates.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), splitString, splitString2, splitString3), x509AttributeCertStoreSelector));
        }
        return createAttributeCertificates;
    }

    public Collection getAttributeCertificateRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getAttributeCertificateRevocationListAttribute());
        String[] splitString2 = splitString(this.params.getLdapAttributeCertificateRevocationListAttributeName());
        String[] splitString3 = splitString(this.params.getAttributeCertificateRevocationListIssuerAttributeName());
        Set createCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, splitString, splitString2, splitString3), x509CRLStoreSelector);
        if (createCRLs.size() == 0) {
            createCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), splitString, splitString2, splitString3), x509CRLStoreSelector));
        }
        return createCRLs;
    }

    public Collection getAttributeDescriptorCertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getAttributeDescriptorCertificateAttribute());
        String[] splitString2 = splitString(this.params.getLdapAttributeDescriptorCertificateAttributeName());
        String[] splitString3 = splitString(this.params.getAttributeDescriptorCertificateSubjectAttributeName());
        Set createAttributeCertificates = createAttributeCertificates(attrCertSubjectSerialSearch(x509AttributeCertStoreSelector, splitString, splitString2, splitString3), x509AttributeCertStoreSelector);
        if (createAttributeCertificates.size() == 0) {
            createAttributeCertificates.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), splitString, splitString2, splitString3), x509AttributeCertStoreSelector));
        }
        return createAttributeCertificates;
    }

    public Collection getAuthorityRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getAuthorityRevocationListAttribute());
        String[] splitString2 = splitString(this.params.getLdapAuthorityRevocationListAttributeName());
        String[] splitString3 = splitString(this.params.getAuthorityRevocationListIssuerAttributeName());
        Set createCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, splitString, splitString2, splitString3), x509CRLStoreSelector);
        if (createCRLs.size() == 0) {
            createCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), splitString, splitString2, splitString3), x509CRLStoreSelector));
        }
        return createCRLs;
    }

    public Collection getCACertificates(X509CertStoreSelector x509CertStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getCACertificateAttribute());
        String[] splitString2 = splitString(this.params.getLdapCACertificateAttributeName());
        String[] splitString3 = splitString(this.params.getCACertificateSubjectAttributeName());
        Set createCerts = createCerts(certSubjectSerialSearch(x509CertStoreSelector, splitString, splitString2, splitString3), x509CertStoreSelector);
        if (createCerts.size() == 0) {
            createCerts.addAll(createCerts(certSubjectSerialSearch(new X509CertStoreSelector(), splitString, splitString2, splitString3), x509CertStoreSelector));
        }
        return createCerts;
    }

    public Collection getCertificateRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getCertificateRevocationListAttribute());
        String[] splitString2 = splitString(this.params.getLdapCertificateRevocationListAttributeName());
        String[] splitString3 = splitString(this.params.getCertificateRevocationListIssuerAttributeName());
        Set createCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, splitString, splitString2, splitString3), x509CRLStoreSelector);
        if (createCRLs.size() == 0) {
            createCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), splitString, splitString2, splitString3), x509CRLStoreSelector));
        }
        return createCRLs;
    }

    public Collection getCrossCertificatePairs(X509CertPairStoreSelector x509CertPairStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getCrossCertificateAttribute());
        String[] splitString2 = splitString(this.params.getLdapCrossCertificateAttributeName());
        String[] splitString3 = splitString(this.params.getCrossCertificateSubjectAttributeName());
        Set createCrossCertificatePairs = createCrossCertificatePairs(crossCertificatePairSubjectSearch(x509CertPairStoreSelector, splitString, splitString2, splitString3), x509CertPairStoreSelector);
        if (createCrossCertificatePairs.size() == 0) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            X509CertPairStoreSelector x509CertPairStoreSelector2 = new X509CertPairStoreSelector();
            x509CertPairStoreSelector2.setForwardSelector(x509CertStoreSelector);
            x509CertPairStoreSelector2.setReverseSelector(x509CertStoreSelector);
            createCrossCertificatePairs.addAll(createCrossCertificatePairs(crossCertificatePairSubjectSearch(x509CertPairStoreSelector2, splitString, splitString2, splitString3), x509CertPairStoreSelector));
        }
        return createCrossCertificatePairs;
    }

    public Collection getDeltaCertificateRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getDeltaRevocationListAttribute());
        String[] splitString2 = splitString(this.params.getLdapDeltaRevocationListAttributeName());
        String[] splitString3 = splitString(this.params.getDeltaRevocationListIssuerAttributeName());
        Set createCRLs = createCRLs(cRLIssuerSearch(x509CRLStoreSelector, splitString, splitString2, splitString3), x509CRLStoreSelector);
        if (createCRLs.size() == 0) {
            createCRLs.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), splitString, splitString2, splitString3), x509CRLStoreSelector));
        }
        return createCRLs;
    }

    public Collection getUserCertificates(X509CertStoreSelector x509CertStoreSelector) throws StoreException {
        String[] splitString = splitString(this.params.getUserCertificateAttribute());
        String[] splitString2 = splitString(this.params.getLdapUserCertificateAttributeName());
        String[] splitString3 = splitString(this.params.getUserCertificateSubjectAttributeName());
        Set createCerts = createCerts(certSubjectSerialSearch(x509CertStoreSelector, splitString, splitString2, splitString3), x509CertStoreSelector);
        if (createCerts.size() == 0) {
            createCerts.addAll(createCerts(certSubjectSerialSearch(new X509CertStoreSelector(), splitString, splitString2, splitString3), x509CertStoreSelector));
        }
        return createCerts;
    }
}
