package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERIA5String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.NetscapeCertType;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.NetscapeRevocationURL;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.VerisignCzagExtension;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.util.ASN1Dump;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.style.RFC4519Style;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.BasicConstraints;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extension;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extensions;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.KeyUsage;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.TBSCertificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.CompositePublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.interfaces.BCX509Certificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.io.OutputStreamFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.X509Principal;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import com.google.android.gms.common.api.Api;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

abstract class X509CertificateImpl extends X509Certificate implements BCX509Certificate {
    protected BasicConstraints basicConstraints;
    protected JcaJceHelper bcHelper;
    protected Certificate c;
    protected boolean[] keyUsage;
    protected String sigAlgName;
    protected byte[] sigAlgParams;

    public X509CertificateImpl(JcaJceHelper jcaJceHelper, Certificate certificate, BasicConstraints basicConstraints2, boolean[] zArr, String str, byte[] bArr) {
        this.bcHelper = jcaJceHelper;
        this.c = certificate;
        this.basicConstraints = basicConstraints2;
        this.keyUsage = zArr;
        this.sigAlgName = str;
        this.sigAlgParams = bArr;
    }

    private void checkSignature(PublicKey publicKey, Signature signature, ASN1Encodable aSN1Encodable, byte[] bArr) throws CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (isAlgIdEqual(this.c.getSignatureAlgorithm(), this.c.getTBSCertificate().getSignature())) {
            X509SignatureUtil.setSignatureParameters(signature, aSN1Encodable);
            signature.initVerify(publicKey);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(OutputStreamFactory.createStream(signature), 512);
                this.c.getTBSCertificate().encodeTo(bufferedOutputStream, ASN1Encoding.DER);
                bufferedOutputStream.close();
                if (!signature.verify(bArr)) {
                    throw new SignatureException("certificate does not verify with supplied key");
                }
            } catch (IOException e) {
                throw new CertificateEncodingException(e.toString());
            }
        } else {
            throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
        }
    }

    private void doVerify(PublicKey publicKey, SignatureCreator signatureCreator) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException {
        SignatureException e;
        boolean z = publicKey instanceof CompositePublicKey;
        int i = 0;
        if (z && X509SignatureUtil.isCompositeAlgorithm(this.c.getSignatureAlgorithm())) {
            List<PublicKey> publicKeys = ((CompositePublicKey) publicKey).getPublicKeys();
            ASN1Sequence instance = ASN1Sequence.getInstance(this.c.getSignatureAlgorithm().getParameters());
            ASN1Sequence instance2 = ASN1Sequence.getInstance(DERBitString.getInstance(this.c.getSignature()).getBytes());
            boolean z2 = false;
            while (i != publicKeys.size()) {
                if (publicKeys.get(i) != null) {
                    AlgorithmIdentifier instance3 = AlgorithmIdentifier.getInstance(instance.getObjectAt(i));
                    try {
                        checkSignature(publicKeys.get(i), signatureCreator.createSignature(X509SignatureUtil.getSignatureName(instance3)), instance3.getParameters(), DERBitString.getInstance(instance2.getObjectAt(i)).getBytes());
                        e = null;
                        z2 = true;
                    } catch (SignatureException e2) {
                        e = e2;
                    }
                    if (e != null) {
                        throw e;
                    }
                }
                i++;
            }
            if (!z2) {
                throw new InvalidKeyException("no matching key found");
            }
        } else if (X509SignatureUtil.isCompositeAlgorithm(this.c.getSignatureAlgorithm())) {
            ASN1Sequence instance4 = ASN1Sequence.getInstance(this.c.getSignatureAlgorithm().getParameters());
            ASN1Sequence instance5 = ASN1Sequence.getInstance(DERBitString.getInstance(this.c.getSignature()).getBytes());
            boolean z3 = false;
            while (i != instance5.size()) {
                AlgorithmIdentifier instance6 = AlgorithmIdentifier.getInstance(instance4.getObjectAt(i));
                try {
                    checkSignature(publicKey, signatureCreator.createSignature(X509SignatureUtil.getSignatureName(instance6)), instance6.getParameters(), DERBitString.getInstance(instance5.getObjectAt(i)).getBytes());
                    e = null;
                    z3 = true;
                } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
                    e = null;
                } catch (SignatureException e3) {
                    e = e3;
                }
                if (e == null) {
                    i++;
                } else {
                    throw e;
                }
            }
            if (!z3) {
                throw new InvalidKeyException("no matching key found");
            }
        } else {
            Signature createSignature = signatureCreator.createSignature(X509SignatureUtil.getSignatureName(this.c.getSignatureAlgorithm()));
            if (z) {
                List<PublicKey> publicKeys2 = ((CompositePublicKey) publicKey).getPublicKeys();
                while (i != publicKeys2.size()) {
                    try {
                        checkSignature(publicKeys2.get(i), createSignature, this.c.getSignatureAlgorithm().getParameters(), getSignature());
                        return;
                    } catch (InvalidKeyException unused2) {
                        i++;
                    }
                }
                throw new InvalidKeyException("no matching signature found");
            }
            checkSignature(publicKey, createSignature, this.c.getSignatureAlgorithm().getParameters(), getSignature());
        }
    }

    private static Collection getAlternativeNames(Certificate certificate, String str) throws CertificateParsingException {
        byte[] extensionOctets = getExtensionOctets(certificate, str);
        if (extensionOctets == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration objects = ASN1Sequence.getInstance(extensionOctets).getObjects();
            while (objects.hasMoreElements()) {
                GeneralName instance = GeneralName.getInstance(objects.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Integers.valueOf(instance.getTagNo()));
                switch (instance.getTagNo()) {
                    case 0:
                    case 3:
                    case 5:
                        arrayList2.add(instance.getEncoded());
                        break;
                    case 1:
                    case 2:
                    case 6:
                        arrayList2.add(((ASN1String) instance.getName()).getString());
                        break;
                    case 4:
                        arrayList2.add(X500Name.getInstance(RFC4519Style.INSTANCE, (Object) instance.getName()).toString());
                        break;
                    case 7:
                        try {
                            arrayList2.add(InetAddress.getByAddress(ASN1OctetString.getInstance(instance.getName()).getOctets()).getHostAddress());
                            break;
                        } catch (UnknownHostException unused) {
                            break;
                        }
                    case 8:
                        arrayList2.add(ASN1ObjectIdentifier.getInstance(instance.getName()).getId());
                        break;
                    default:
                        throw new IOException("Bad tag number: " + instance.getTagNo());
                }
                arrayList.add(Collections.unmodifiableList(arrayList2));
            }
            if (arrayList.size() == 0) {
                return null;
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e) {
            throw new CertificateParsingException(e.getMessage());
        }
    }

    public static byte[] getExtensionOctets(Certificate certificate, String str) {
        ASN1OctetString extensionValue = getExtensionValue(certificate, str);
        if (extensionValue != null) {
            return extensionValue.getOctets();
        }
        return null;
    }

    private boolean isAlgIdEqual(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        if (!algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) algorithmIdentifier2.getAlgorithm())) {
            return false;
        }
        if (Properties.isOverrideSet("com.fis.ekyc.nfc.build_in.bouncycastle.x509.allow_absent_equiv_NULL")) {
            if (algorithmIdentifier.getParameters() == null) {
                if (algorithmIdentifier2.getParameters() == null || algorithmIdentifier2.getParameters().equals(DERNull.INSTANCE)) {
                    return true;
                }
                return false;
            } else if (algorithmIdentifier2.getParameters() == null) {
                if (algorithmIdentifier.getParameters() == null || algorithmIdentifier.getParameters().equals(DERNull.INSTANCE)) {
                    return true;
                }
                return false;
            }
        }
        if (algorithmIdentifier.getParameters() != null) {
            return algorithmIdentifier.getParameters().equals(algorithmIdentifier2.getParameters());
        }
        if (algorithmIdentifier2.getParameters() != null) {
            return algorithmIdentifier2.getParameters().equals(algorithmIdentifier.getParameters());
        }
        return true;
    }

    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(new Date());
    }

    public int getBasicConstraints() {
        BasicConstraints basicConstraints2 = this.basicConstraints;
        if (basicConstraints2 == null || !basicConstraints2.isCA()) {
            return -1;
        }
        if (this.basicConstraints.getPathLenConstraint() == null) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return this.basicConstraints.getPathLenConstraint().intValue();
    }

    public Set getCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Extensions extensions = this.c.getTBSCertificate().getExtensions();
        if (extensions == null) {
            return null;
        }
        Enumeration oids = extensions.oids();
        while (oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
            if (extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                hashSet.add(aSN1ObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            return this.c.getEncoded(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] extensionOctets = getExtensionOctets(this.c, "2.5.29.37");
        if (extensionOctets == null) {
            return null;
        }
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(ASN1Primitive.fromByteArray(extensionOctets));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i != instance.size(); i++) {
                arrayList.add(((ASN1ObjectIdentifier) instance.getObjectAt(i)).getId());
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception unused) {
            throw new CertificateParsingException("error processing extended key usage extension");
        }
    }

    public byte[] getExtensionValue(String str) {
        ASN1OctetString extensionValue = getExtensionValue(this.c, str);
        if (extensionValue == null) {
            return null;
        }
        try {
            return extensionValue.getEncoded();
        } catch (Exception e) {
            throw new IllegalStateException("error parsing " + e.toString());
        }
    }

    public Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return getAlternativeNames(this.c, Extension.issuerAlternativeName.getId());
    }

    public Principal getIssuerDN() {
        return new X509Principal(this.c.getIssuer());
    }

    public boolean[] getIssuerUniqueID() {
        boolean z;
        DERBitString issuerUniqueId = this.c.getTBSCertificate().getIssuerUniqueId();
        if (issuerUniqueId == null) {
            return null;
        }
        byte[] bytes = issuerUniqueId.getBytes();
        int length = (bytes.length * 8) - issuerUniqueId.getPadBits();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            if ((bytes[i / 8] & (128 >>> (i % 8))) != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
        }
        return zArr;
    }

    public X500Name getIssuerX500Name() {
        return this.c.getIssuer();
    }

    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.c.getIssuer().getEncoded(ASN1Encoding.DER));
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public boolean[] getKeyUsage() {
        return Arrays.clone(this.keyUsage);
    }

    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Extensions extensions = this.c.getTBSCertificate().getExtensions();
        if (extensions == null) {
            return null;
        }
        Enumeration oids = extensions.oids();
        while (oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
            if (!extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                hashSet.add(aSN1ObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    public Date getNotAfter() {
        return this.c.getEndDate().getDate();
    }

    public Date getNotBefore() {
        return this.c.getStartDate().getDate();
    }

    public PublicKey getPublicKey() {
        try {
            return BouncyCastleProvider.getPublicKey(this.c.getSubjectPublicKeyInfo());
        } catch (IOException unused) {
            return null;
        }
    }

    public BigInteger getSerialNumber() {
        return this.c.getSerialNumber().getValue();
    }

    public String getSigAlgName() {
        return this.sigAlgName;
    }

    public String getSigAlgOID() {
        return this.c.getSignatureAlgorithm().getAlgorithm().getId();
    }

    public byte[] getSigAlgParams() {
        return Arrays.clone(this.sigAlgParams);
    }

    public byte[] getSignature() {
        return this.c.getSignature().getOctets();
    }

    public Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return getAlternativeNames(this.c, Extension.subjectAlternativeName.getId());
    }

    public Principal getSubjectDN() {
        return new X509Principal(this.c.getSubject());
    }

    public boolean[] getSubjectUniqueID() {
        boolean z;
        DERBitString subjectUniqueId = this.c.getTBSCertificate().getSubjectUniqueId();
        if (subjectUniqueId == null) {
            return null;
        }
        byte[] bytes = subjectUniqueId.getBytes();
        int length = (bytes.length * 8) - subjectUniqueId.getPadBits();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            if ((bytes[i / 8] & (128 >>> (i % 8))) != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
        }
        return zArr;
    }

    public X500Name getSubjectX500Name() {
        return this.c.getSubject();
    }

    public X500Principal getSubjectX500Principal() {
        try {
            return new X500Principal(this.c.getSubject().getEncoded(ASN1Encoding.DER));
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode subject DN");
        }
    }

    public byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.c.getTBSCertificate().getEncoded(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public TBSCertificate getTBSCertificateNative() {
        return this.c.getTBSCertificate();
    }

    public int getVersion() {
        return this.c.getVersionNumber();
    }

    public boolean hasUnsupportedCriticalExtension() {
        Extensions extensions;
        if (getVersion() != 3 || (extensions = this.c.getTBSCertificate().getExtensions()) == null) {
            return false;
        }
        Enumeration oids = extensions.oids();
        while (oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
            if (!aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.keyUsage) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.certificatePolicies) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.policyMappings) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.inhibitAnyPolicy) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.cRLDistributionPoints) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.issuingDistributionPoint) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.deltaCRLIndicator) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.policyConstraints) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.basicConstraints) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.subjectAlternativeName) && !aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.nameConstraints) && extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("  [0]         Version: ");
        stringBuffer.append(getVersion());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("         SerialNumber: ");
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("             IssuerDN: ");
        stringBuffer.append(getIssuerDN());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("           Start Date: ");
        stringBuffer.append(getNotBefore());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("           Final Date: ");
        stringBuffer.append(getNotAfter());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            SubjectDN: ");
        stringBuffer.append(getSubjectDN());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("           Public Key: ");
        stringBuffer.append(getPublicKey());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("  Signature Algorithm: ");
        stringBuffer.append(getSigAlgName());
        stringBuffer.append(lineSeparator);
        X509SignatureUtil.prettyPrintSignature(getSignature(), stringBuffer, lineSeparator);
        Extensions extensions = this.c.getTBSCertificate().getExtensions();
        if (extensions != null) {
            Enumeration oids = extensions.oids();
            if (oids.hasMoreElements()) {
                stringBuffer.append("       Extensions: \n");
            }
            while (oids.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
                Extension extension = extensions.getExtension(aSN1ObjectIdentifier);
                if (extension.getExtnValue() != null) {
                    ASN1InputStream aSN1InputStream = new ASN1InputStream(extension.getExtnValue().getOctets());
                    stringBuffer.append("                       critical(");
                    stringBuffer.append(extension.isCritical());
                    stringBuffer.append(") ");
                    try {
                        if (aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.basicConstraints)) {
                            stringBuffer.append(BasicConstraints.getInstance(aSN1InputStream.readObject()));
                            stringBuffer.append(lineSeparator);
                        } else if (aSN1ObjectIdentifier.equals((ASN1Primitive) Extension.keyUsage)) {
                            stringBuffer.append(KeyUsage.getInstance(aSN1InputStream.readObject()));
                            stringBuffer.append(lineSeparator);
                        } else if (aSN1ObjectIdentifier.equals((ASN1Primitive) MiscObjectIdentifiers.netscapeCertType)) {
                            stringBuffer.append(new NetscapeCertType(DERBitString.getInstance(aSN1InputStream.readObject())));
                            stringBuffer.append(lineSeparator);
                        } else if (aSN1ObjectIdentifier.equals((ASN1Primitive) MiscObjectIdentifiers.netscapeRevocationURL)) {
                            stringBuffer.append(new NetscapeRevocationURL(DERIA5String.getInstance(aSN1InputStream.readObject())));
                            stringBuffer.append(lineSeparator);
                        } else if (aSN1ObjectIdentifier.equals((ASN1Primitive) MiscObjectIdentifiers.verisignCzagExtension)) {
                            stringBuffer.append(new VerisignCzagExtension(DERIA5String.getInstance(aSN1InputStream.readObject())));
                            stringBuffer.append(lineSeparator);
                        } else {
                            stringBuffer.append(aSN1ObjectIdentifier.getId());
                            stringBuffer.append(" value = ");
                            stringBuffer.append(ASN1Dump.dumpAsString(aSN1InputStream.readObject()));
                            stringBuffer.append(lineSeparator);
                        }
                    } catch (Exception unused) {
                        stringBuffer.append(aSN1ObjectIdentifier.getId());
                        stringBuffer.append(" value = ");
                        stringBuffer.append("*****");
                        stringBuffer.append(lineSeparator);
                    }
                } else {
                    stringBuffer.append(lineSeparator);
                }
            }
        }
        return stringBuffer.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        doVerify(publicKey, new SignatureCreator() {
            public Signature createSignature(String str) throws NoSuchAlgorithmException {
                try {
                    return X509CertificateImpl.this.bcHelper.createSignature(str);
                } catch (Exception unused) {
                    return Signature.getInstance(str);
                }
            }
        });
    }

    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (date.getTime() > getNotAfter().getTime()) {
            throw new CertificateExpiredException("certificate expired on " + this.c.getEndDate().getTime());
        } else if (date.getTime() < getNotBefore().getTime()) {
            throw new CertificateNotYetValidException("certificate not valid till " + this.c.getStartDate().getTime());
        }
    }

    public final void verify(PublicKey publicKey, final String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        doVerify(publicKey, new SignatureCreator() {
            public Signature createSignature(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
                String str2 = str;
                if (str2 != null) {
                    return Signature.getInstance(str, str2);
                }
                return Signature.getInstance(str);
            }
        });
    }

    public final void verify(PublicKey publicKey, final Provider provider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        try {
            doVerify(publicKey, new SignatureCreator() {
                public Signature createSignature(String str) throws NoSuchAlgorithmException {
                    Provider provider = provider;
                    if (provider != null) {
                        return Signature.getInstance(str, provider);
                    }
                    return Signature.getInstance(str);
                }
            });
        } catch (NoSuchProviderException e) {
            throw new NoSuchAlgorithmException("provider issue: " + e.getMessage());
        }
    }

    public static ASN1OctetString getExtensionValue(Certificate certificate, String str) {
        Extension extension;
        Extensions extensions = certificate.getTBSCertificate().getExtensions();
        if (extensions == null || (extension = extensions.getExtension(new ASN1ObjectIdentifier(str))) == null) {
            return null;
        }
        return extension.getExtnValue();
    }
}
