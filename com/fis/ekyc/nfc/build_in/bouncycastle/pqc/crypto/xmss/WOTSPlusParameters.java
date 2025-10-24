package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;

final class WOTSPlusParameters {
    private final int digestSize;
    private final int len;
    private final int len1;
    private final int len2;
    private final XMSSOid oid;
    private final ASN1ObjectIdentifier treeDigest;
    private final int winternitzParameter;

    public WOTSPlusParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier != null) {
            this.treeDigest = aSN1ObjectIdentifier;
            Digest digest = DigestUtil.getDigest(aSN1ObjectIdentifier);
            int digestSize2 = XMSSUtil.getDigestSize(digest);
            this.digestSize = digestSize2;
            this.winternitzParameter = 16;
            int ceil = (int) Math.ceil(((double) (digestSize2 * 8)) / ((double) XMSSUtil.log2(16)));
            this.len1 = ceil;
            int floor = ((int) Math.floor((double) (XMSSUtil.log2((16 - 1) * ceil) / XMSSUtil.log2(16)))) + 1;
            this.len2 = floor;
            int i = ceil + floor;
            this.len = i;
            WOTSPlusOid lookup = WOTSPlusOid.lookup(digest.getAlgorithmName(), digestSize2, 16, i);
            this.oid = lookup;
            if (lookup == null) {
                throw new IllegalArgumentException("cannot find OID for digest algorithm: " + digest.getAlgorithmName());
            }
            return;
        }
        throw new NullPointerException("treeDigest == null");
    }

    public int getLen() {
        return this.len;
    }

    public int getLen1() {
        return this.len1;
    }

    public int getLen2() {
        return this.len2;
    }

    public XMSSOid getOid() {
        return this.oid;
    }

    public ASN1ObjectIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public int getTreeDigestSize() {
        return this.digestSize;
    }

    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
