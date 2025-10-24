package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.eidparser.cert.CVCPrincipal;
import com.fis.ekyc.nfc.build_in.eidparser.cert.CardVerifiableCertificate;
import com.fis.ekyc.nfc.build_in.scuba.util.Hex;
import java.io.Serializable;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EACTAResult implements Serializable {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final long serialVersionUID = -2926063872890928748L;
    private CVCPrincipal caReference;
    private byte[] cardChallenge;
    private EACCAResult chipAuthenticationResult;
    private String documentNumber;
    private List<CardVerifiableCertificate> terminalCertificates = new ArrayList();
    private PrivateKey terminalKey;

    public EACTAResult(EACCAResult eACCAResult, CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, byte[] bArr) {
        this.chipAuthenticationResult = eACCAResult;
        this.caReference = cVCPrincipal;
        for (CardVerifiableCertificate add : list) {
            this.terminalCertificates.add(add);
        }
        this.terminalKey = privateKey;
        this.documentNumber = str;
        this.cardChallenge = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EACTAResult eACTAResult = (EACTAResult) obj;
        CVCPrincipal cVCPrincipal = this.caReference;
        if (cVCPrincipal == null) {
            if (eACTAResult.caReference != null) {
                return false;
            }
        } else if (!cVCPrincipal.equals(eACTAResult.caReference)) {
            return false;
        }
        if (!Arrays.equals(this.cardChallenge, eACTAResult.cardChallenge)) {
            return false;
        }
        EACCAResult eACCAResult = this.chipAuthenticationResult;
        if (eACCAResult == null) {
            if (eACTAResult.chipAuthenticationResult != null) {
                return false;
            }
        } else if (!eACCAResult.equals(eACTAResult.chipAuthenticationResult)) {
            return false;
        }
        String str = this.documentNumber;
        if (str == null) {
            if (eACTAResult.documentNumber != null) {
                return false;
            }
        } else if (!str.equals(eACTAResult.documentNumber)) {
            return false;
        }
        List<CardVerifiableCertificate> list = this.terminalCertificates;
        if (list == null) {
            if (eACTAResult.terminalCertificates != null) {
                return false;
            }
        } else if (!list.equals(eACTAResult.terminalCertificates)) {
            return false;
        }
        PrivateKey privateKey = this.terminalKey;
        if (privateKey != null) {
            return privateKey.equals(eACTAResult.terminalKey);
        }
        if (eACTAResult.terminalKey == null) {
            return true;
        }
        return false;
    }

    public CVCPrincipal getCAReference() {
        return this.caReference;
    }

    public List<CardVerifiableCertificate> getCVCertificates() {
        return this.terminalCertificates;
    }

    public byte[] getCardChallenge() {
        return this.cardChallenge;
    }

    public EACCAResult getChipAuthenticationResult() {
        return this.chipAuthenticationResult;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public PrivateKey getTerminalKey() {
        return this.terminalKey;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        CVCPrincipal cVCPrincipal = this.caReference;
        int i5 = 0;
        if (cVCPrincipal == null) {
            i = 0;
        } else {
            i = cVCPrincipal.hashCode();
        }
        int hashCode = (((i + 31) * 31) + Arrays.hashCode(this.cardChallenge)) * 31;
        EACCAResult eACCAResult = this.chipAuthenticationResult;
        if (eACCAResult == null) {
            i2 = 0;
        } else {
            i2 = eACCAResult.hashCode();
        }
        int i6 = (hashCode + i2) * 31;
        String str = this.documentNumber;
        if (str == null) {
            i3 = 0;
        } else {
            i3 = str.hashCode();
        }
        int i7 = (i6 + i3) * 31;
        List<CardVerifiableCertificate> list = this.terminalCertificates;
        if (list == null) {
            i4 = 0;
        } else {
            i4 = list.hashCode();
        }
        int i8 = (i7 + i4) * 31;
        PrivateKey privateKey = this.terminalKey;
        if (privateKey != null) {
            i5 = privateKey.hashCode();
        }
        return i8 + i5;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TAResult [chipAuthenticationResult: " + this.chipAuthenticationResult);
        sb2.append(", ");
        sb2.append("caReference: " + this.caReference);
        sb2.append(", ");
        sb2.append("terminalCertificates: [");
        boolean z = true;
        for (CardVerifiableCertificate next : this.terminalCertificates) {
            if (z) {
                z = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(toString(next));
        }
        sb2.append("terminalKey = ");
        sb2.append(Util.getDetailedPrivateKeyAlgorithm(this.terminalKey));
        sb2.append(", ");
        sb2.append("documentNumber = ");
        sb2.append(this.documentNumber);
        sb2.append(", ");
        sb2.append("cardChallenge = ");
        sb2.append(Hex.bytesToHexString(this.cardChallenge));
        sb2.append(", ");
        sb2.append("]");
        return sb2.toString();
    }

    private Object toString(CardVerifiableCertificate cardVerifiableCertificate) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CardVerifiableCertificate [");
        try {
            CVCPrincipal holderReference = cardVerifiableCertificate.getHolderReference();
            if (!this.caReference.equals(holderReference)) {
                sb2.append("holderReference: " + holderReference);
            }
        } catch (CertificateException e) {
            sb2.append("holderReference = ???");
            LOGGER.log(Level.WARNING, "Exception", e);
        }
        sb2.append("]");
        return sb2.toString();
    }
}
