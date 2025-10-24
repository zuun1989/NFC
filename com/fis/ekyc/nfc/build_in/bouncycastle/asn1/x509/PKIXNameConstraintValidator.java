package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERIA5String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.RDN;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.style.IETFUtils;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.style.RFC4519Style;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PKIXNameConstraintValidator implements NameConstraintValidator {
    private Set excludedSubtreesDN = new HashSet();
    private Set excludedSubtreesDNS = new HashSet();
    private Set excludedSubtreesEmail = new HashSet();
    private Set excludedSubtreesIP = new HashSet();
    private Set excludedSubtreesOtherName = new HashSet();
    private Set excludedSubtreesURI = new HashSet();
    private Set permittedSubtreesDN;
    private Set permittedSubtreesDNS;
    private Set permittedSubtreesEmail;
    private Set permittedSubtreesIP;
    private Set permittedSubtreesOtherName;
    private Set permittedSubtreesURI;

    private final void addLine(StringBuilder sb2, String str) {
        sb2.append(str);
        sb2.append(Strings.lineSeparator());
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkExcludedDNS(java.util.Set r3, java.lang.String r4) throws com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.NameConstraintValidatorException {
        /*
            r2 = this;
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.util.Iterator r3 = r3.iterator()
        L_0x000b:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = r2.withinDomain(r4, r0)
            if (r1 != 0) goto L_0x0024
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0024
            goto L_0x000b
        L_0x0024:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.NameConstraintValidatorException r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.NameConstraintValidatorException
            java.lang.String r4 = "DNS is from an excluded subtree."
            r3.<init>(r4)
            throw r3
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.PKIXNameConstraintValidator.checkExcludedDNS(java.util.Set, java.lang.String):void");
    }

    private void checkExcludedEmail(Set set, String str) throws NameConstraintValidatorException {
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (emailIsConstrained(str, (String) it.next())) {
                    throw new NameConstraintValidatorException("Email address is from an excluded subtree.");
                }
            }
        }
    }

    private void checkExcludedIP(Set set, byte[] bArr) throws NameConstraintValidatorException {
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (isIPConstrained(bArr, (byte[]) it.next())) {
                    throw new NameConstraintValidatorException("IP is from an excluded subtree.");
                }
            }
        }
    }

    private void checkExcludedOtherName(Set set, OtherName otherName) throws NameConstraintValidatorException {
        if (!set.isEmpty()) {
            for (Object instance : set) {
                if (otherNameIsConstrained(otherName, OtherName.getInstance(instance))) {
                    throw new NameConstraintValidatorException("OtherName is from an excluded subtree.");
                }
            }
        }
    }

    private void checkExcludedURI(Set set, String str) throws NameConstraintValidatorException {
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (isUriConstrained(str, (String) it.next())) {
                    throw new NameConstraintValidatorException("URI is from an excluded subtree.");
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkPermittedDNS(java.util.Set r4, java.lang.String r5) throws com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.NameConstraintValidatorException {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.Iterator r0 = r4.iterator()
        L_0x0007:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = r3.withinDomain(r5, r1)
            if (r2 != 0) goto L_0x001f
            boolean r1 = r5.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0007
        L_0x001f:
            return
        L_0x0020:
            int r5 = r5.length()
            if (r5 != 0) goto L_0x002d
            int r4 = r4.size()
            if (r4 != 0) goto L_0x002d
            return
        L_0x002d:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.NameConstraintValidatorException r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.NameConstraintValidatorException
            java.lang.String r5 = "DNS is not from a permitted subtree."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.PKIXNameConstraintValidator.checkPermittedDNS(java.util.Set, java.lang.String):void");
    }

    private void checkPermittedEmail(Set set, String str) throws NameConstraintValidatorException {
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (emailIsConstrained(str, (String) it.next())) {
                    return;
                }
            }
            if (str.length() != 0 || set.size() != 0) {
                throw new NameConstraintValidatorException("Subject email address is not from a permitted subtree.");
            }
        }
    }

    private void checkPermittedIP(Set set, byte[] bArr) throws NameConstraintValidatorException {
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (isIPConstrained(bArr, (byte[]) it.next())) {
                    return;
                }
            }
            if (bArr.length != 0 || set.size() != 0) {
                throw new NameConstraintValidatorException("IP is not from a permitted subtree.");
            }
        }
    }

    private void checkPermittedOtherName(Set set, OtherName otherName) throws NameConstraintValidatorException {
        if (set != null) {
            for (Object instance : set) {
                if (otherNameIsConstrained(otherName, OtherName.getInstance(instance))) {
                    return;
                }
            }
            throw new NameConstraintValidatorException("Subject OtherName is not from a permitted subtree.");
        }
    }

    private void checkPermittedURI(Set set, String str) throws NameConstraintValidatorException {
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (isUriConstrained(str, (String) it.next())) {
                    return;
                }
            }
            if (str.length() != 0 || set.size() != 0) {
                throw new NameConstraintValidatorException("URI is not from a permitted subtree.");
            }
        }
    }

    private boolean collectionsAreEqual(Collection collection, Collection collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        for (Object next : collection) {
            Iterator it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    return false;
                }
                if (equals(next, it.next())) {
                }
            }
        }
        return true;
    }

    private static int compareTo(byte[] bArr, byte[] bArr2) {
        if (Arrays.areEqual(bArr, bArr2)) {
            return 0;
        }
        if (Arrays.areEqual(max(bArr, bArr2), bArr)) {
            return 1;
        }
        return -1;
    }

    private boolean emailIsConstrained(String str, String str2) {
        String substring = str.substring(str.indexOf(64) + 1);
        if (str2.indexOf(64) != -1) {
            if (!str.equalsIgnoreCase(str2) && !substring.equalsIgnoreCase(str2.substring(1))) {
                return false;
            }
            return true;
        } else if (str2.charAt(0) != '.') {
            if (substring.equalsIgnoreCase(str2)) {
                return true;
            }
        } else if (withinDomain(substring, str2)) {
            return true;
        }
        return false;
    }

    private static String extractHostFromURL(String str) {
        String substring = str.substring(str.indexOf(58) + 1);
        if (substring.indexOf("//") != -1) {
            substring = substring.substring(substring.indexOf("//") + 2);
        }
        if (substring.lastIndexOf(58) != -1) {
            substring = substring.substring(0, substring.lastIndexOf(58));
        }
        String substring2 = substring.substring(substring.indexOf(58) + 1);
        String substring3 = substring2.substring(substring2.indexOf(64) + 1);
        if (substring3.indexOf(47) != -1) {
            return substring3.substring(0, substring3.indexOf(47));
        }
        return substring3;
    }

    private byte[][] extractIPsAndSubnetMasks(byte[] bArr, byte[] bArr2) {
        int length = bArr.length / 2;
        byte[] bArr3 = new byte[length];
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr, length, bArr4, 0, length);
        byte[] bArr5 = new byte[length];
        byte[] bArr6 = new byte[length];
        System.arraycopy(bArr2, 0, bArr5, 0, length);
        System.arraycopy(bArr2, length, bArr6, 0, length);
        return new byte[][]{bArr3, bArr4, bArr5, bArr6};
    }

    private String extractNameAsString(GeneralName generalName) {
        return DERIA5String.getInstance(generalName.getName()).getString();
    }

    private int hashCollection(Collection collection) {
        int hashCode;
        int i = 0;
        if (collection == null) {
            return 0;
        }
        for (Object next : collection) {
            if (next instanceof byte[]) {
                hashCode = Arrays.hashCode((byte[]) next);
            } else {
                hashCode = next.hashCode();
            }
            i += hashCode;
        }
        return i;
    }

    private Set intersectDN(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            ASN1Sequence instance = ASN1Sequence.getInstance(((GeneralSubtree) it.next()).getBase().getName().toASN1Primitive());
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) it2.next();
                    if (withinDNSubtree(instance, aSN1Sequence)) {
                        hashSet.add(instance);
                    } else if (withinDNSubtree(aSN1Sequence, instance)) {
                        hashSet.add(aSN1Sequence);
                    }
                }
            } else if (instance != null) {
                hashSet.add(instance);
            }
        }
        return hashSet;
    }

    private Set intersectDNS(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            String extractNameAsString = extractNameAsString(((GeneralSubtree) it.next()).getBase());
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (withinDomain(str, extractNameAsString)) {
                        hashSet.add(str);
                    } else if (withinDomain(extractNameAsString, str)) {
                        hashSet.add(extractNameAsString);
                    }
                }
            } else if (extractNameAsString != null) {
                hashSet.add(extractNameAsString);
            }
        }
        return hashSet;
    }

    private Set intersectEmail(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            String extractNameAsString = extractNameAsString(((GeneralSubtree) it.next()).getBase());
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    intersectEmail(extractNameAsString, (String) it2.next(), hashSet);
                }
            } else if (extractNameAsString != null) {
                hashSet.add(extractNameAsString);
            }
        }
        return hashSet;
    }

    private Set intersectIP(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            byte[] octets = ASN1OctetString.getInstance(((GeneralSubtree) it.next()).getBase().getName()).getOctets();
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    hashSet.addAll(intersectIPRange((byte[]) it2.next(), octets));
                }
            } else if (octets != null) {
                hashSet.add(octets);
            }
        }
        return hashSet;
    }

    private Set intersectIPRange(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return Collections.EMPTY_SET;
        }
        byte[][] extractIPsAndSubnetMasks = extractIPsAndSubnetMasks(bArr, bArr2);
        byte[] bArr3 = extractIPsAndSubnetMasks[0];
        byte[] bArr4 = extractIPsAndSubnetMasks[1];
        byte[] bArr5 = extractIPsAndSubnetMasks[2];
        byte[] bArr6 = extractIPsAndSubnetMasks[3];
        byte[][] minMaxIPs = minMaxIPs(bArr3, bArr4, bArr5, bArr6);
        if (compareTo(max(minMaxIPs[0], minMaxIPs[2]), min(minMaxIPs[1], minMaxIPs[3])) == 1) {
            return Collections.EMPTY_SET;
        }
        return Collections.singleton(ipWithSubnetMask(or(minMaxIPs[0], minMaxIPs[2]), or(bArr4, bArr6)));
    }

    private Set intersectOtherName(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            OtherName instance = OtherName.getInstance(((GeneralSubtree) it.next()).getBase().getName());
            if (set != null) {
                for (Object instance2 : set) {
                    intersectOtherName(instance, OtherName.getInstance(instance2), hashSet);
                }
            } else if (instance != null) {
                hashSet.add(instance);
            }
        }
        return hashSet;
    }

    private Set intersectURI(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            String extractNameAsString = extractNameAsString(((GeneralSubtree) it.next()).getBase());
            if (set != null) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    intersectURI((String) it2.next(), extractNameAsString, hashSet);
                }
            } else if (extractNameAsString != null) {
                hashSet.add(extractNameAsString);
            }
        }
        return hashSet;
    }

    private byte[] ipWithSubnetMask(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[(length * 2)];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr2, 0, bArr3, length, length);
        return bArr3;
    }

    private boolean isIPConstrained(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length / 2) {
            return false;
        }
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, length, bArr3, 0, length);
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr4[i] = (byte) (bArr2[i] & bArr3[i]);
            bArr5[i] = (byte) (bArr[i] & bArr3[i]);
        }
        return Arrays.areEqual(bArr4, bArr5);
    }

    private boolean isUriConstrained(String str, String str2) {
        String extractHostFromURL = extractHostFromURL(str);
        if (!str2.startsWith(".")) {
            if (extractHostFromURL.equalsIgnoreCase(str2)) {
                return true;
            }
            return false;
        } else if (withinDomain(extractHostFromURL, str2)) {
            return true;
        } else {
            return false;
        }
    }

    private static byte[] max(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 65535) > (65535 & bArr2[i])) {
                return bArr;
            }
        }
        return bArr2;
    }

    private static byte[] min(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 65535) < (65535 & bArr2[i])) {
                return bArr;
            }
        }
        return bArr2;
    }

    private byte[][] minMaxIPs(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int length = bArr.length;
        byte[] bArr5 = new byte[length];
        byte[] bArr6 = new byte[length];
        byte[] bArr7 = new byte[length];
        byte[] bArr8 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr5[i] = (byte) (bArr[i] & bArr2[i]);
            byte b = bArr[i];
            byte b2 = bArr2[i];
            bArr6[i] = (byte) ((b & b2) | (~b2));
            bArr7[i] = (byte) (bArr3[i] & bArr4[i]);
            byte b3 = bArr3[i];
            byte b4 = bArr4[i];
            bArr8[i] = (byte) ((b3 & b4) | (~b4));
        }
        return new byte[][]{bArr5, bArr6, bArr7, bArr8};
    }

    private static byte[] or(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] | bArr2[i]);
        }
        return bArr3;
    }

    private boolean otherNameIsConstrained(OtherName otherName, OtherName otherName2) {
        if (otherName2.equals(otherName)) {
            return true;
        }
        return false;
    }

    private String stringifyIP(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < bArr.length / 2; i++) {
            if (sb2.length() > 0) {
                sb2.append(".");
            }
            sb2.append(Integer.toString(bArr[i] & 255));
        }
        sb2.append("/");
        boolean z = true;
        for (int length = bArr.length / 2; length < bArr.length; length++) {
            if (z) {
                z = false;
            } else {
                sb2.append(".");
            }
            sb2.append(Integer.toString(bArr[length] & 255));
        }
        return sb2.toString();
    }

    private String stringifyIPCollection(Set set) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (sb2.length() > 1) {
                sb2.append(",");
            }
            sb2.append(stringifyIP((byte[]) it.next()));
        }
        sb2.append("]");
        return sb2.toString();
    }

    private String stringifyOtherNameCollection(Set set) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (Object instance : set) {
            if (sb2.length() > 1) {
                sb2.append(",");
            }
            OtherName instance2 = OtherName.getInstance(instance);
            sb2.append(instance2.getTypeID().getId());
            sb2.append(":");
            try {
                sb2.append(Hex.toHexString(instance2.getValue().toASN1Primitive().getEncoded()));
            } catch (IOException e) {
                sb2.append(e.toString());
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    private Set unionDN(Set set, ASN1Sequence aSN1Sequence) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (Object instance : set) {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(instance);
                if (withinDNSubtree(aSN1Sequence, instance2)) {
                    hashSet.add(instance2);
                } else if (withinDNSubtree(instance2, aSN1Sequence)) {
                    hashSet.add(aSN1Sequence);
                } else {
                    hashSet.add(instance2);
                    hashSet.add(aSN1Sequence);
                }
            }
            return hashSet;
        } else if (aSN1Sequence == null) {
            return set;
        } else {
            set.add(aSN1Sequence);
            return set;
        }
    }

    private Set unionDNS(Set set, String str) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (withinDomain(str2, str)) {
                    hashSet.add(str);
                } else if (withinDomain(str, str2)) {
                    hashSet.add(str2);
                } else {
                    hashSet.add(str2);
                    hashSet.add(str);
                }
            }
            return hashSet;
        } else if (str == null) {
            return set;
        } else {
            set.add(str);
            return set;
        }
    }

    private Set unionEmail(Set set, String str) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                unionEmail((String) it.next(), str, hashSet);
            }
            return hashSet;
        } else if (str == null) {
            return set;
        } else {
            set.add(str);
            return set;
        }
    }

    private Set unionIP(Set set, byte[] bArr) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.addAll(unionIPRange((byte[]) it.next(), bArr));
            }
            return hashSet;
        } else if (bArr == null) {
            return set;
        } else {
            set.add(bArr);
            return set;
        }
    }

    private Set unionIPRange(byte[] bArr, byte[] bArr2) {
        HashSet hashSet = new HashSet();
        if (Arrays.areEqual(bArr, bArr2)) {
            hashSet.add(bArr);
        } else {
            hashSet.add(bArr);
            hashSet.add(bArr2);
        }
        return hashSet;
    }

    private Set unionOtherName(Set set, OtherName otherName) {
        HashSet hashSet;
        if (set == null) {
            hashSet = new HashSet();
        }
        hashSet.add(otherName);
        return hashSet;
    }

    private void unionURI(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (str.equalsIgnoreCase(str2)) {
                    set.add(str);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (str2.startsWith(".")) {
                if (withinDomain(substring, str2)) {
                    set.add(str2);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (substring.equalsIgnoreCase(str2)) {
                set.add(str2);
            } else {
                set.add(str);
                set.add(str2);
            }
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) != -1) {
                if (withinDomain(str2.substring(str.indexOf(64) + 1), str)) {
                    set.add(str);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (str2.startsWith(".")) {
                if (withinDomain(str, str2) || str.equalsIgnoreCase(str2)) {
                    set.add(str2);
                } else if (withinDomain(str2, str)) {
                    set.add(str);
                } else {
                    set.add(str);
                    set.add(str2);
                }
            } else if (withinDomain(str2, str)) {
                set.add(str);
            } else {
                set.add(str);
                set.add(str2);
            }
        } else if (str2.indexOf(64) != -1) {
            if (str2.substring(str.indexOf(64) + 1).equalsIgnoreCase(str)) {
                set.add(str);
                return;
            }
            set.add(str);
            set.add(str2);
        } else if (str2.startsWith(".")) {
            if (withinDomain(str, str2)) {
                set.add(str2);
                return;
            }
            set.add(str);
            set.add(str2);
        } else if (str.equalsIgnoreCase(str2)) {
            set.add(str);
        } else {
            set.add(str);
            set.add(str2);
        }
    }

    private static boolean withinDNSubtree(ASN1Sequence aSN1Sequence, ASN1Sequence aSN1Sequence2) {
        if (aSN1Sequence2.size() < 1 || aSN1Sequence2.size() > aSN1Sequence.size()) {
            return false;
        }
        RDN instance = RDN.getInstance(aSN1Sequence2.getObjectAt(0));
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= aSN1Sequence.size()) {
                i = i2;
                break;
            } else if (IETFUtils.rDNAreEqual(instance, RDN.getInstance(aSN1Sequence.getObjectAt(i)))) {
                break;
            } else {
                i2 = i;
                i++;
            }
        }
        if (aSN1Sequence2.size() > aSN1Sequence.size() - i) {
            return false;
        }
        for (int i3 = 0; i3 < aSN1Sequence2.size(); i3++) {
            RDN instance2 = RDN.getInstance(aSN1Sequence2.getObjectAt(i3));
            RDN instance3 = RDN.getInstance(aSN1Sequence.getObjectAt(i + i3));
            if (instance2.size() != instance3.size() || !instance2.getFirst().getType().equals((ASN1Primitive) instance3.getFirst().getType())) {
                return false;
            }
            if (instance2.size() != 1 || !instance2.getFirst().getType().equals((ASN1Primitive) RFC4519Style.serialNumber)) {
                if (!IETFUtils.rDNAreEqual(instance2, instance3)) {
                    return false;
                }
            } else if (!instance3.getFirst().getValue().toString().startsWith(instance2.getFirst().getValue().toString())) {
                return false;
            }
        }
        return true;
    }

    private boolean withinDomain(String str, String str2) {
        if (str2.startsWith(".")) {
            str2 = str2.substring(1);
        }
        String[] split = Strings.split(str2, '.');
        String[] split2 = Strings.split(str, '.');
        if (split2.length <= split.length) {
            return false;
        }
        int length = split2.length - split.length;
        for (int i = -1; i < split.length; i++) {
            if (i == -1) {
                if (split2[i + length].equals("")) {
                    return false;
                }
            } else if (!split[i].equalsIgnoreCase(split2[i + length])) {
                return false;
            }
        }
        return true;
    }

    public void addExcludedSubtree(GeneralSubtree generalSubtree) {
        GeneralName base = generalSubtree.getBase();
        int tagNo = base.getTagNo();
        if (tagNo == 0) {
            this.excludedSubtreesOtherName = unionOtherName(this.excludedSubtreesOtherName, OtherName.getInstance(base.getName()));
        } else if (tagNo == 1) {
            this.excludedSubtreesEmail = unionEmail(this.excludedSubtreesEmail, extractNameAsString(base));
        } else if (tagNo == 2) {
            this.excludedSubtreesDNS = unionDNS(this.excludedSubtreesDNS, extractNameAsString(base));
        } else if (tagNo == 4) {
            this.excludedSubtreesDN = unionDN(this.excludedSubtreesDN, (ASN1Sequence) base.getName().toASN1Primitive());
        } else if (tagNo == 6) {
            this.excludedSubtreesURI = unionURI(this.excludedSubtreesURI, extractNameAsString(base));
        } else if (tagNo == 7) {
            this.excludedSubtreesIP = unionIP(this.excludedSubtreesIP, ASN1OctetString.getInstance(base.getName()).getOctets());
        } else {
            throw new IllegalStateException("Unknown tag encountered: " + base.getTagNo());
        }
    }

    public void checkExcluded(GeneralName generalName) throws NameConstraintValidatorException {
        int tagNo = generalName.getTagNo();
        if (tagNo == 0) {
            checkExcludedOtherName(this.excludedSubtreesOtherName, OtherName.getInstance(generalName.getName()));
        } else if (tagNo == 1) {
            checkExcludedEmail(this.excludedSubtreesEmail, extractNameAsString(generalName));
        } else if (tagNo == 2) {
            checkExcludedDNS(this.excludedSubtreesDNS, extractNameAsString(generalName));
        } else if (tagNo == 4) {
            checkExcludedDN(X500Name.getInstance(generalName.getName()));
        } else if (tagNo == 6) {
            checkExcludedURI(this.excludedSubtreesURI, extractNameAsString(generalName));
        } else if (tagNo == 7) {
            checkExcludedIP(this.excludedSubtreesIP, ASN1OctetString.getInstance(generalName.getName()).getOctets());
        }
    }

    public void checkExcludedDN(X500Name x500Name) throws NameConstraintValidatorException {
        checkExcludedDN(this.excludedSubtreesDN, ASN1Sequence.getInstance(x500Name));
    }

    public void checkPermitted(GeneralName generalName) throws NameConstraintValidatorException {
        int tagNo = generalName.getTagNo();
        if (tagNo == 0) {
            checkPermittedOtherName(this.permittedSubtreesOtherName, OtherName.getInstance(generalName.getName()));
        } else if (tagNo == 1) {
            checkPermittedEmail(this.permittedSubtreesEmail, extractNameAsString(generalName));
        } else if (tagNo == 2) {
            checkPermittedDNS(this.permittedSubtreesDNS, extractNameAsString(generalName));
        } else if (tagNo == 4) {
            checkPermittedDN(X500Name.getInstance(generalName.getName()));
        } else if (tagNo == 6) {
            checkPermittedURI(this.permittedSubtreesURI, extractNameAsString(generalName));
        } else if (tagNo == 7) {
            checkPermittedIP(this.permittedSubtreesIP, ASN1OctetString.getInstance(generalName.getName()).getOctets());
        }
    }

    public void checkPermittedDN(X500Name x500Name) throws NameConstraintValidatorException {
        checkPermittedDN(this.permittedSubtreesDN, ASN1Sequence.getInstance(x500Name.toASN1Primitive()));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PKIXNameConstraintValidator)) {
            return false;
        }
        PKIXNameConstraintValidator pKIXNameConstraintValidator = (PKIXNameConstraintValidator) obj;
        if (!collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesDN, this.excludedSubtreesDN) || !collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesDNS, this.excludedSubtreesDNS) || !collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesEmail, this.excludedSubtreesEmail) || !collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesIP, this.excludedSubtreesIP) || !collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesURI, this.excludedSubtreesURI) || !collectionsAreEqual(pKIXNameConstraintValidator.excludedSubtreesOtherName, this.excludedSubtreesOtherName) || !collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesDN, this.permittedSubtreesDN) || !collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesDNS, this.permittedSubtreesDNS) || !collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesEmail, this.permittedSubtreesEmail) || !collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesIP, this.permittedSubtreesIP) || !collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesURI, this.permittedSubtreesURI) || !collectionsAreEqual(pKIXNameConstraintValidator.permittedSubtreesOtherName, this.permittedSubtreesOtherName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return hashCollection(this.excludedSubtreesDN) + hashCollection(this.excludedSubtreesDNS) + hashCollection(this.excludedSubtreesEmail) + hashCollection(this.excludedSubtreesIP) + hashCollection(this.excludedSubtreesURI) + hashCollection(this.excludedSubtreesOtherName) + hashCollection(this.permittedSubtreesDN) + hashCollection(this.permittedSubtreesDNS) + hashCollection(this.permittedSubtreesEmail) + hashCollection(this.permittedSubtreesIP) + hashCollection(this.permittedSubtreesURI) + hashCollection(this.permittedSubtreesOtherName);
    }

    public void intersectEmptyPermittedSubtree(int i) {
        if (i == 0) {
            this.permittedSubtreesOtherName = new HashSet();
        } else if (i == 1) {
            this.permittedSubtreesEmail = new HashSet();
        } else if (i == 2) {
            this.permittedSubtreesDNS = new HashSet();
        } else if (i == 4) {
            this.permittedSubtreesDN = new HashSet();
        } else if (i == 6) {
            this.permittedSubtreesURI = new HashSet();
        } else if (i == 7) {
            this.permittedSubtreesIP = new HashSet();
        } else {
            throw new IllegalStateException("Unknown tag encountered: " + i);
        }
    }

    public void intersectPermittedSubtree(GeneralSubtree generalSubtree) {
        intersectPermittedSubtree(new GeneralSubtree[]{generalSubtree});
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        addLine(sb2, "permitted:");
        if (this.permittedSubtreesDN != null) {
            addLine(sb2, "DN:");
            addLine(sb2, this.permittedSubtreesDN.toString());
        }
        if (this.permittedSubtreesDNS != null) {
            addLine(sb2, "DNS:");
            addLine(sb2, this.permittedSubtreesDNS.toString());
        }
        if (this.permittedSubtreesEmail != null) {
            addLine(sb2, "Email:");
            addLine(sb2, this.permittedSubtreesEmail.toString());
        }
        if (this.permittedSubtreesURI != null) {
            addLine(sb2, "URI:");
            addLine(sb2, this.permittedSubtreesURI.toString());
        }
        if (this.permittedSubtreesIP != null) {
            addLine(sb2, "IP:");
            addLine(sb2, stringifyIPCollection(this.permittedSubtreesIP));
        }
        if (this.permittedSubtreesOtherName != null) {
            addLine(sb2, "OtherName:");
            addLine(sb2, stringifyOtherNameCollection(this.permittedSubtreesOtherName));
        }
        addLine(sb2, "excluded:");
        if (!this.excludedSubtreesDN.isEmpty()) {
            addLine(sb2, "DN:");
            addLine(sb2, this.excludedSubtreesDN.toString());
        }
        if (!this.excludedSubtreesDNS.isEmpty()) {
            addLine(sb2, "DNS:");
            addLine(sb2, this.excludedSubtreesDNS.toString());
        }
        if (!this.excludedSubtreesEmail.isEmpty()) {
            addLine(sb2, "Email:");
            addLine(sb2, this.excludedSubtreesEmail.toString());
        }
        if (!this.excludedSubtreesURI.isEmpty()) {
            addLine(sb2, "URI:");
            addLine(sb2, this.excludedSubtreesURI.toString());
        }
        if (!this.excludedSubtreesIP.isEmpty()) {
            addLine(sb2, "IP:");
            addLine(sb2, stringifyIPCollection(this.excludedSubtreesIP));
        }
        if (!this.excludedSubtreesOtherName.isEmpty()) {
            addLine(sb2, "OtherName:");
            addLine(sb2, stringifyOtherNameCollection(this.excludedSubtreesOtherName));
        }
        return sb2.toString();
    }

    private void checkExcludedDN(Set set, ASN1Sequence aSN1Sequence) throws NameConstraintValidatorException {
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (withinDNSubtree(aSN1Sequence, (ASN1Sequence) it.next())) {
                    throw new NameConstraintValidatorException("Subject distinguished name is from an excluded subtree");
                }
            }
        }
    }

    private void checkPermittedDN(Set set, ASN1Sequence aSN1Sequence) throws NameConstraintValidatorException {
        if (set != null) {
            if (!set.isEmpty() || aSN1Sequence.size() != 0) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    if (withinDNSubtree(aSN1Sequence, (ASN1Sequence) it.next())) {
                        return;
                    }
                }
                throw new NameConstraintValidatorException("Subject distinguished name is not from a permitted subtree");
            }
        }
    }

    public void intersectPermittedSubtree(GeneralSubtree[] generalSubtreeArr) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i != generalSubtreeArr.length; i++) {
            GeneralSubtree generalSubtree = generalSubtreeArr[i];
            Integer valueOf = Integers.valueOf(generalSubtree.getBase().getTagNo());
            if (hashMap.get(valueOf) == null) {
                hashMap.put(valueOf, new HashSet());
            }
            ((Set) hashMap.get(valueOf)).add(generalSubtree);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue == 0) {
                this.permittedSubtreesOtherName = intersectOtherName(this.permittedSubtreesOtherName, (Set) entry.getValue());
            } else if (intValue == 1) {
                this.permittedSubtreesEmail = intersectEmail(this.permittedSubtreesEmail, (Set) entry.getValue());
            } else if (intValue == 2) {
                this.permittedSubtreesDNS = intersectDNS(this.permittedSubtreesDNS, (Set) entry.getValue());
            } else if (intValue == 4) {
                this.permittedSubtreesDN = intersectDN(this.permittedSubtreesDN, (Set) entry.getValue());
            } else if (intValue == 6) {
                this.permittedSubtreesURI = intersectURI(this.permittedSubtreesURI, (Set) entry.getValue());
            } else if (intValue == 7) {
                this.permittedSubtreesIP = intersectIP(this.permittedSubtreesIP, (Set) entry.getValue());
            } else {
                throw new IllegalStateException("Unknown tag encountered: " + intValue);
            }
        }
    }

    private void unionEmail(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (str.equalsIgnoreCase(str2)) {
                    set.add(str);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (str2.startsWith(".")) {
                if (withinDomain(substring, str2)) {
                    set.add(str2);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (substring.equalsIgnoreCase(str2)) {
                set.add(str2);
            } else {
                set.add(str);
                set.add(str2);
            }
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) != -1) {
                if (withinDomain(str2.substring(str.indexOf(64) + 1), str)) {
                    set.add(str);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (str2.startsWith(".")) {
                if (withinDomain(str, str2) || str.equalsIgnoreCase(str2)) {
                    set.add(str2);
                } else if (withinDomain(str2, str)) {
                    set.add(str);
                } else {
                    set.add(str);
                    set.add(str2);
                }
            } else if (withinDomain(str2, str)) {
                set.add(str);
            } else {
                set.add(str);
                set.add(str2);
            }
        } else if (str2.indexOf(64) != -1) {
            if (str2.substring(str.indexOf(64) + 1).equalsIgnoreCase(str)) {
                set.add(str);
                return;
            }
            set.add(str);
            set.add(str2);
        } else if (str2.startsWith(".")) {
            if (withinDomain(str, str2)) {
                set.add(str2);
                return;
            }
            set.add(str);
            set.add(str2);
        } else if (str.equalsIgnoreCase(str2)) {
            set.add(str);
        } else {
            set.add(str);
            set.add(str2);
        }
    }

    private void intersectOtherName(OtherName otherName, OtherName otherName2, Set set) {
        if (otherName.equals(otherName2)) {
            set.add(otherName);
        }
    }

    private void intersectEmail(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (str.equalsIgnoreCase(str2)) {
                    set.add(str);
                }
            } else if (str2.startsWith(".")) {
                if (withinDomain(substring, str2)) {
                    set.add(str);
                }
            } else if (substring.equalsIgnoreCase(str2)) {
                set.add(str);
            }
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) != -1) {
                if (withinDomain(str2.substring(str.indexOf(64) + 1), str)) {
                    set.add(str2);
                }
            } else if (str2.startsWith(".")) {
                if (withinDomain(str, str2) || str.equalsIgnoreCase(str2)) {
                    set.add(str);
                } else if (withinDomain(str2, str)) {
                    set.add(str2);
                }
            } else if (withinDomain(str2, str)) {
                set.add(str2);
            }
        } else if (str2.indexOf(64) != -1) {
            if (str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str)) {
                set.add(str2);
            }
        } else if (str2.startsWith(".")) {
            if (withinDomain(str, str2)) {
                set.add(str);
            }
        } else if (str.equalsIgnoreCase(str2)) {
            set.add(str);
        }
    }

    private void intersectURI(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (str.equalsIgnoreCase(str2)) {
                    set.add(str);
                }
            } else if (str2.startsWith(".")) {
                if (withinDomain(substring, str2)) {
                    set.add(str);
                }
            } else if (substring.equalsIgnoreCase(str2)) {
                set.add(str);
            }
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) != -1) {
                if (withinDomain(str2.substring(str.indexOf(64) + 1), str)) {
                    set.add(str2);
                }
            } else if (str2.startsWith(".")) {
                if (withinDomain(str, str2) || str.equalsIgnoreCase(str2)) {
                    set.add(str);
                } else if (withinDomain(str2, str)) {
                    set.add(str2);
                }
            } else if (withinDomain(str2, str)) {
                set.add(str2);
            }
        } else if (str2.indexOf(64) != -1) {
            if (str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str)) {
                set.add(str2);
            }
        } else if (str2.startsWith(".")) {
            if (withinDomain(str, str2)) {
                set.add(str);
            }
        } else if (str.equalsIgnoreCase(str2)) {
            set.add(str);
        }
    }

    private boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
            return obj.equals(obj2);
        }
        return Arrays.areEqual((byte[]) obj, (byte[]) obj2);
    }

    private Set unionURI(Set set, String str) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                unionURI((String) it.next(), str, hashSet);
            }
            return hashSet;
        } else if (str == null) {
            return set;
        } else {
            set.add(str);
            return set;
        }
    }
}
