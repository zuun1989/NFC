package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.eidparser.io.FragmentBuffer;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFileUtil;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.SecureMessagingWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.FileInfo;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.FileSystemStructured;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVInputStream;
import com.fis.ekyc.nfc.build_in.scuba.util.Hex;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultFileSystem implements FileSystemStructured {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    public static final int NO_SFI = -1;
    private static final int READ_AHEAD_LENGTH = 8;
    private Map<Short, Byte> fidToSFI;
    private Map<Short, DefaultFileInfo> fileInfos;
    private boolean isSFIEnabled;
    private boolean isSelected;
    private int maxReadBinaryLength;
    private APDUWrapper oldWrapper;
    private short selectedFID;
    private APDULevelReadBinaryCapable service;
    private APDUWrapper wrapper;

    public static class DefaultFileInfo extends FileInfo implements Serializable {
        private static final long serialVersionUID = 6727369753765119839L;
        private FragmentBuffer buffer;
        private short fid;

        public DefaultFileInfo(short s, int i) {
            this.fid = s;
            this.buffer = new FragmentBuffer(i);
        }

        public void addFragment(int i, byte[] bArr) {
            this.buffer.addFragment(i, bArr);
        }

        public byte[] getBuffer() {
            return this.buffer.getBuffer();
        }

        public short getFID() {
            return this.fid;
        }

        public int getFileLength() {
            return this.buffer.getLength();
        }

        public FragmentBuffer.Fragment getSmallestUnbufferedFragment(int i, int i2) {
            return this.buffer.getSmallestUnbufferedFragment(i, i2);
        }

        public String toString() {
            return Integer.toHexString(this.fid);
        }
    }

    public DefaultFileSystem(APDULevelReadBinaryCapable aPDULevelReadBinaryCapable, boolean z) {
        this(aPDULevelReadBinaryCapable, z, LDSFileUtil.FID_TO_SFI);
    }

    private synchronized DefaultFileInfo getFileInfo() throws CardServiceException {
        byte[] bArr;
        try {
            short s = this.selectedFID;
            if (s > 0) {
                DefaultFileInfo defaultFileInfo = this.fileInfos.get(Short.valueOf(s));
                if (defaultFileInfo != null) {
                    return defaultFileInfo;
                }
                if (this.isSFIEnabled) {
                    Byte b = this.fidToSFI.get(Short.valueOf(this.selectedFID));
                    if (b != null) {
                        bArr = sendReadBinary((b.byteValue() & 255) | ISOFileInfo.DATA_BYTES1, 0, 8, false);
                        this.isSelected = true;
                    } else {
                        throw new NumberFormatException("Unknown FID " + Integer.toHexString(this.selectedFID));
                    }
                } else {
                    if (!this.isSelected) {
                        sendSelectFile(this.selectedFID);
                        this.isSelected = true;
                    }
                    bArr = sendReadBinary(0, 8, false);
                }
                if (bArr != null) {
                    if (bArr.length != 0) {
                        int fileLength = getFileLength(this.selectedFID, 8, bArr);
                        if (fileLength < bArr.length) {
                            bArr = Arrays.copyOf(bArr, fileLength);
                        }
                        DefaultFileInfo defaultFileInfo2 = new DefaultFileInfo(this.selectedFID, fileLength);
                        defaultFileInfo2.addFragment(0, bArr);
                        this.fileInfos.put(Short.valueOf(this.selectedFID), defaultFileInfo2);
                        return defaultFileInfo2;
                    }
                }
                Logger logger = LOGGER;
                logger.warning("Something is wrong with prefix, prefix = " + Hex.bytesToHexString(bArr));
                return null;
            }
            throw new CardServiceException("No file selected");
        } catch (IOException e) {
            throw new CardServiceException("Error getting file info for " + Integer.toHexString(this.selectedFID), (Throwable) e);
        } finally {
        }
    }

    private static int getFileLength(short s, int i, byte[] bArr) throws IOException {
        if (bArr.length < i) {
            return bArr.length;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        TLVInputStream tLVInputStream = new TLVInputStream(byteArrayInputStream);
        try {
            if (tLVInputStream.readTag() == 66) {
                try {
                    return 36;
                } catch (IOException e) {
                    return 36;
                }
            } else {
                int length = (bArr.length - byteArrayInputStream.available()) + tLVInputStream.readLength();
                try {
                    tLVInputStream.close();
                } catch (IOException e2) {
                    LOGGER.log(Level.FINE, "Error closing stream", e2);
                }
                return length;
            }
        } finally {
            try {
                tLVInputStream.close();
            } catch (IOException e3) {
                LOGGER.log(Level.FINE, "Error closing stream", e3);
            }
        }
    }

    public int getMaxReadBinaryLength() {
        return this.maxReadBinaryLength;
    }

    public synchronized FileInfo[] getSelectedPath() throws CardServiceException {
        DefaultFileInfo fileInfo = getFileInfo();
        if (fileInfo == null) {
            return null;
        }
        return new DefaultFileInfo[]{fileInfo};
    }

    public APDUWrapper getWrapper() {
        return this.wrapper;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.fis.ekyc.nfc.build_in.eidparser.DefaultFileSystem$DefaultFileInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] readBinary(int r8, int r9) throws com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            r1 = 0
            short r2 = r7.selectedFID     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            if (r2 <= 0) goto L_0x00c0
            com.fis.ekyc.nfc.build_in.eidparser.DefaultFileSystem$DefaultFileInfo r1 = r7.getFileInfo()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            if (r1 == 0) goto L_0x00b8
            int r2 = r7.maxReadBinaryLength     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            int r9 = java.lang.Math.min(r9, r2)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            com.fis.ekyc.nfc.build_in.eidparser.io.FragmentBuffer$Fragment r2 = r1.getSmallestUnbufferedFragment(r8, r9)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            int r3 = r2.getLength()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            if (r3 <= 0) goto L_0x00ad
            boolean r3 = r7.isSFIEnabled     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r4 = 1
            if (r3 == 0) goto L_0x0073
            r3 = 256(0x100, float:3.59E-43)
            if (r8 >= r3) goto L_0x0073
            java.util.Map<java.lang.Short, java.lang.Byte> r3 = r7.fidToSFI     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            short r5 = r7.selectedFID     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.Short r5 = java.lang.Short.valueOf(r5)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.Byte r3 = (java.lang.Byte) r3     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            if (r3 == 0) goto L_0x0056
            byte r3 = r3.byteValue()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r3 | 128(0x80, float:1.794E-43)
            int r5 = r2.getOffset()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            int r6 = r2.getLength()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            byte[] r3 = r7.sendReadBinary(r3, r5, r6, r0)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r7.isSelected = r4     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            goto L_0x0090
        L_0x004d:
            r8 = move-exception
            goto L_0x0120
        L_0x0050:
            r8 = move-exception
            goto L_0x00c8
        L_0x0053:
            r8 = move-exception
            goto L_0x00e7
        L_0x0056:
            java.lang.NumberFormatException r8 = new java.lang.NumberFormatException     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r9.<init>()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.String r2 = "Unknown FID "
            r9.append(r2)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            short r2 = r7.selectedFID     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.String r2 = java.lang.Integer.toHexString(r2)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r9.append(r2)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.String r9 = r9.toString()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r8.<init>(r9)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            throw r8     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
        L_0x0073:
            boolean r3 = r7.isSelected     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            if (r3 != 0) goto L_0x007e
            short r3 = r7.selectedFID     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r7.sendSelectFile(r3)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r7.isSelected = r4     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
        L_0x007e:
            int r3 = r2.getOffset()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            int r5 = r2.getLength()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r6 = 32767(0x7fff, float:4.5916E-41)
            if (r8 <= r6) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r4 = r0
        L_0x008c:
            byte[] r3 = r7.sendReadBinary(r3, r5, r4)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
        L_0x0090:
            if (r3 == 0) goto L_0x00a5
            int r4 = r3.length     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            if (r4 <= 0) goto L_0x009c
            int r4 = r2.getOffset()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            r1.addFragment(r4, r3)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
        L_0x009c:
            int r4 = r3.length     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            int r2 = r2.getLength()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            if (r4 >= r2) goto L_0x00ad
            int r9 = r3.length     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            goto L_0x00ad
        L_0x00a5:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.String r9 = "Could not read bytes"
            r8.<init>(r9)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            throw r8     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
        L_0x00ad:
            byte[] r2 = r1.getBuffer()     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            byte[] r3 = new byte[r9]     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.System.arraycopy(r2, r8, r3, r0, r9)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            monitor-exit(r7)
            return r3
        L_0x00b8:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.String r9 = "Could not get file info"
            r8.<init>(r9)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            throw r8     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
        L_0x00c0:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r8 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            java.lang.String r9 = "No file selected"
            r8.<init>(r9)     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
            throw r8     // Catch:{ CardServiceException -> 0x0053, Exception -> 0x0050 }
        L_0x00c8:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r9 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r0.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "Read binary failed on file "
            r0.append(r2)     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x00dc
            short r1 = r7.selectedFID     // Catch:{ all -> 0x004d }
            java.lang.String r1 = java.lang.Integer.toHexString(r1)     // Catch:{ all -> 0x004d }
        L_0x00dc:
            r0.append(r1)     // Catch:{ all -> 0x004d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004d }
            r9.<init>((java.lang.String) r0, (java.lang.Throwable) r8)     // Catch:{ all -> 0x004d }
            throw r9     // Catch:{ all -> 0x004d }
        L_0x00e7:
            int r9 = r8.getSW()     // Catch:{ all -> 0x004d }
            short r9 = (short) r9     // Catch:{ all -> 0x004d }
            r2 = 26368(0x6700, float:3.695E-41)
            r9 = r9 & r2
            if (r9 != r2) goto L_0x0101
            int r9 = r7.maxReadBinaryLength     // Catch:{ all -> 0x004d }
            r2 = 223(0xdf, float:3.12E-43)
            if (r9 <= r2) goto L_0x0101
            com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper r8 = r7.oldWrapper     // Catch:{ all -> 0x004d }
            r7.wrapper = r8     // Catch:{ all -> 0x004d }
            r7.maxReadBinaryLength = r2     // Catch:{ all -> 0x004d }
            byte[] r8 = new byte[r0]     // Catch:{ all -> 0x004d }
            monitor-exit(r7)
            return r8
        L_0x0101:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r9 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r0.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "Read binary failed on file "
            r0.append(r2)     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x0115
            short r1 = r7.selectedFID     // Catch:{ all -> 0x004d }
            java.lang.String r1 = java.lang.Integer.toHexString(r1)     // Catch:{ all -> 0x004d }
        L_0x0115:
            r0.append(r1)     // Catch:{ all -> 0x004d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004d }
            r9.<init>((java.lang.String) r0, (java.lang.Throwable) r8)     // Catch:{ all -> 0x004d }
            throw r9     // Catch:{ all -> 0x004d }
        L_0x0120:
            monitor-exit(r7)     // Catch:{ all -> 0x004d }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.DefaultFileSystem.readBinary(int, int):byte[]");
    }

    public synchronized void selectFile(short s) throws CardServiceException {
        if (this.selectedFID != s) {
            this.selectedFID = s;
            this.isSelected = false;
        }
    }

    public synchronized byte[] sendReadBinary(int i, int i2, boolean z) throws CardServiceException {
        try {
            APDUWrapper aPDUWrapper = this.wrapper;
            if (aPDUWrapper instanceof SecureMessagingWrapper) {
                aPDUWrapper = SecureMessagingWrapper.getInstance((SecureMessagingWrapper) aPDUWrapper);
            }
            this.oldWrapper = aPDUWrapper;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.service.sendReadBinary(this.wrapper, -1, i, i2, false, z);
    }

    public synchronized void sendSelectFile(short s) throws CardServiceException {
        this.service.sendSelectFile(this.wrapper, s);
    }

    public void setWrapper(APDUWrapper aPDUWrapper) {
        this.oldWrapper = this.wrapper;
        this.wrapper = aPDUWrapper;
    }

    public DefaultFileSystem(APDULevelReadBinaryCapable aPDULevelReadBinaryCapable, boolean z, Map<Short, Byte> map) {
        this.service = aPDULevelReadBinaryCapable;
        this.fileInfos = new HashMap();
        this.selectedFID = 0;
        this.isSelected = false;
        this.isSFIEnabled = z;
        this.fidToSFI = map;
        this.maxReadBinaryLength = 65536;
    }

    public synchronized byte[] sendReadBinary(int i, int i2, int i3, boolean z) throws CardServiceException {
        return this.service.sendReadBinary(this.wrapper, i, i2, i3, true, z);
    }
}
