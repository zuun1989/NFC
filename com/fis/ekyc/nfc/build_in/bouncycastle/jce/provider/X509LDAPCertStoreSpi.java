package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.X509LDAPCertStoreParameters;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public class X509LDAPCertStoreSpi extends CertStoreSpi {
    private static String LDAP_PROVIDER = "com.sun.jndi.ldap.LdapCtxFactory";
    private static String REFERRALS_IGNORE = "ignore";
    private static final String SEARCH_SECURITY_LEVEL = "none";
    private static final String URL_CONTEXT_PREFIX = "com.sun.jndi.url";
    private X509LDAPCertStoreParameters params;

    public X509LDAPCertStoreSpi(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
        super(certStoreParameters);
        if (certStoreParameters instanceof X509LDAPCertStoreParameters) {
            this.params = (X509LDAPCertStoreParameters) certStoreParameters;
            return;
        }
        throw new InvalidAlgorithmParameterException(X509LDAPCertStoreSpi.class.getName() + ": parameter must be a " + X509LDAPCertStoreParameters.class.getName() + " object\n" + certStoreParameters.toString());
    }

    private Set certSubjectSerialSearch(X509CertSelector x509CertSelector, String[] strArr, String str, String str2) throws CertStoreException {
        String str3;
        String str4;
        HashSet hashSet = new HashSet();
        try {
            if (x509CertSelector.getSubjectAsBytes() == null) {
                if (x509CertSelector.getSubjectAsString() == null) {
                    if (x509CertSelector.getCertificate() == null) {
                        hashSet.addAll(search(str, "*", strArr));
                        return hashSet;
                    }
                }
            }
            if (x509CertSelector.getCertificate() != null) {
                str4 = x509CertSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
                str3 = x509CertSelector.getCertificate().getSerialNumber().toString();
            } else {
                if (x509CertSelector.getSubjectAsBytes() != null) {
                    str4 = new X500Principal(x509CertSelector.getSubjectAsBytes()).getName("RFC1779");
                } else {
                    str4 = x509CertSelector.getSubjectAsString();
                }
                str3 = null;
            }
            hashSet.addAll(search(str, "*" + parseDN(str4, str2) + "*", strArr));
            if (!(str3 == null || this.params.getSearchForSerialNumberIn() == null)) {
                hashSet.addAll(search(this.params.getSearchForSerialNumberIn(), "*" + str3 + "*", strArr));
            }
            return hashSet;
        } catch (IOException e) {
            throw new CertStoreException("exception processing selector: " + e);
        }
    }

    private Set getCACertificates(X509CertSelector x509CertSelector) throws CertStoreException {
        String[] strArr = {this.params.getCACertificateAttribute()};
        Set certSubjectSerialSearch = certSubjectSerialSearch(x509CertSelector, strArr, this.params.getLdapCACertificateAttributeName(), this.params.getCACertificateSubjectAttributeName());
        if (certSubjectSerialSearch.isEmpty()) {
            certSubjectSerialSearch.addAll(search((String) null, "*", strArr));
        }
        return certSubjectSerialSearch;
    }

    private Set getCrossCertificates(X509CertSelector x509CertSelector) throws CertStoreException {
        String[] strArr = {this.params.getCrossCertificateAttribute()};
        Set certSubjectSerialSearch = certSubjectSerialSearch(x509CertSelector, strArr, this.params.getLdapCrossCertificateAttributeName(), this.params.getCrossCertificateSubjectAttributeName());
        if (certSubjectSerialSearch.isEmpty()) {
            certSubjectSerialSearch.addAll(search((String) null, "*", strArr));
        }
        return certSubjectSerialSearch;
    }

    private Set getEndCertificates(X509CertSelector x509CertSelector) throws CertStoreException {
        return certSubjectSerialSearch(x509CertSelector, new String[]{this.params.getUserCertificateAttribute()}, this.params.getLdapUserCertificateAttributeName(), this.params.getUserCertificateSubjectAttributeName());
    }

    private String parseDN(String str, String str2) {
        int i;
        String substring = str.substring(str.toLowerCase().indexOf(str2.toLowerCase()) + str2.length());
        int indexOf = substring.indexOf(44);
        if (indexOf == -1) {
            indexOf = substring.length();
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

    private Set search(String str, String str2, String[] strArr) throws CertStoreException {
        return null;
    }

    public Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        String str;
        String[] strArr = {this.params.getCertificateRevocationListAttribute()};
        if (cRLSelector instanceof X509CRLSelector) {
            X509CRLSelector x509CRLSelector = (X509CRLSelector) cRLSelector;
            HashSet hashSet = new HashSet();
            String ldapCertificateRevocationListAttributeName = this.params.getLdapCertificateRevocationListAttributeName();
            HashSet<byte[]> hashSet2 = new HashSet<>();
            if (x509CRLSelector.getIssuerNames() != null) {
                for (Object next : x509CRLSelector.getIssuerNames()) {
                    if (next instanceof String) {
                        str = parseDN((String) next, this.params.getCertificateRevocationListIssuerAttributeName());
                    } else {
                        str = parseDN(new X500Principal((byte[]) next).getName("RFC1779"), this.params.getCertificateRevocationListIssuerAttributeName());
                    }
                    hashSet2.addAll(search(ldapCertificateRevocationListAttributeName, "*" + str + "*", strArr));
                }
            } else {
                hashSet2.addAll(search(ldapCertificateRevocationListAttributeName, "*", strArr));
            }
            hashSet2.addAll(search((String) null, "*", strArr));
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME);
                for (byte[] byteArrayInputStream : hashSet2) {
                    CRL generateCRL = instance.generateCRL(new ByteArrayInputStream(byteArrayInputStream));
                    if (x509CRLSelector.match(generateCRL)) {
                        hashSet.add(generateCRL);
                    }
                }
                return hashSet;
            } catch (Exception e) {
                throw new CertStoreException("CRL cannot be constructed from LDAP result " + e);
            }
        } else {
            throw new CertStoreException("selector is not a X509CRLSelector");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.security.cert.CertificateFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.security.cert.CertificateFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.security.cert.CertificateFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.security.cert.CertificateFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.security.cert.CertificateFactory} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0082 A[Catch:{ Exception -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002f A[Catch:{ Exception -> 0x0065 }] */
    public java.util.Collection engineGetCertificates(java.security.cert.CertSelector r7) throws java.security.cert.CertStoreException {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.security.cert.X509CertSelector
            if (r0 == 0) goto L_0x00b3
            java.security.cert.X509CertSelector r7 = (java.security.cert.X509CertSelector) r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Set r1 = r6.getEndCertificates(r7)
            java.util.Set r2 = r6.getCACertificates(r7)
            r1.addAll(r2)
            java.util.Set r2 = r6.getCrossCertificates(r7)
            r1.addAll(r2)
            java.util.Iterator r1 = r1.iterator()
            java.lang.String r2 = "X.509"
            java.lang.String r3 = "BC"
            java.security.cert.CertificateFactory r2 = java.security.cert.CertificateFactory.getInstance(r2, r3)     // Catch:{ Exception -> 0x0065 }
        L_0x0029:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x0065 }
            if (r3 == 0) goto L_0x009b
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x0065 }
            byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x0065 }
            if (r3 == 0) goto L_0x0029
            int r4 = r3.length     // Catch:{ Exception -> 0x0065 }
            if (r4 != 0) goto L_0x003b
            goto L_0x0029
        L_0x003b:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0065 }
            r4.<init>()     // Catch:{ Exception -> 0x0065 }
            r4.add(r3)     // Catch:{ Exception -> 0x0065 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            r5.<init>((byte[]) r3)     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r3 = r5.readObject()     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CertificatePair r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CertificatePair.getInstance(r3)     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            r4.clear()     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate r5 = r3.getForward()     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            if (r5 == 0) goto L_0x0067
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate r5 = r3.getForward()     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            byte[] r5 = r5.getEncoded()     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            r4.add(r5)     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            goto L_0x0067
        L_0x0065:
            r7 = move-exception
            goto L_0x009c
        L_0x0067:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate r5 = r3.getReverse()     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            if (r5 == 0) goto L_0x0078
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate r3 = r3.getReverse()     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            byte[] r3 = r3.getEncoded()     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
            r4.add(r3)     // Catch:{ IOException | IllegalArgumentException -> 0x0078 }
        L_0x0078:
            java.util.Iterator r3 = r4.iterator()     // Catch:{ Exception -> 0x0065 }
        L_0x007c:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x0065 }
            if (r4 == 0) goto L_0x0029
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0065 }
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x0065 }
            byte[] r5 = (byte[]) r5     // Catch:{ Exception -> 0x0065 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0065 }
            java.security.cert.Certificate r4 = r2.generateCertificate(r4)     // Catch:{ Exception -> 0x007c }
            boolean r5 = r7.match(r4)     // Catch:{ Exception -> 0x007c }
            if (r5 == 0) goto L_0x007c
            r0.add(r4)     // Catch:{ Exception -> 0x007c }
            goto L_0x007c
        L_0x009b:
            return r0
        L_0x009c:
            java.security.cert.CertStoreException r0 = new java.security.cert.CertStoreException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "certificate cannot be constructed from LDAP result: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x00b3:
            java.security.cert.CertStoreException r7 = new java.security.cert.CertStoreException
            java.lang.String r0 = "selector is not a X509CertSelector"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.X509LDAPCertStoreSpi.engineGetCertificates(java.security.cert.CertSelector):java.util.Collection");
    }
}
