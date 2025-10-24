package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVInputStream;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class DisplayedImageDataGroup extends DataGroup {
    private static final int DISPLAYED_IMAGE_COUNT_TAG = 2;
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final long serialVersionUID = 5994136177872308962L;
    private int displayedImageTagToUse;
    private List<DisplayedImageInfo> imageInfos;

    public DisplayedImageDataGroup(int i, List<DisplayedImageInfo> list, int i2) {
        super(i);
        if (list != null) {
            this.displayedImageTagToUse = i2;
            this.imageInfos = new ArrayList(list);
            checkTypesConsistentWithTag();
            return;
        }
        throw new IllegalArgumentException("imageInfos cannot be null");
    }

    private void add(DisplayedImageInfo displayedImageInfo) {
        if (this.imageInfos == null) {
            this.imageInfos = new ArrayList();
        }
        this.imageInfos.add(displayedImageInfo);
    }

    private void checkTypesConsistentWithTag() {
        for (DisplayedImageInfo next : this.imageInfos) {
            if (next != null) {
                int type = next.getType();
                if (type != 0) {
                    if (type != 1) {
                        LOGGER.warning("Unsupported image type");
                    } else if (this.displayedImageTagToUse != 24387) {
                        throw new IllegalArgumentException("'Portrait' image cannot be part of a 'Signature or usual mark' displayed image datagroup");
                    }
                } else if (this.displayedImageTagToUse != 24384) {
                    throw new IllegalArgumentException("'Signature or usual mark' image cannot be part of a 'Portrait' displayed image datagroup");
                }
            } else {
                throw new IllegalArgumentException("Found a null image info");
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        List<DisplayedImageInfo> list = this.imageInfos;
        List<DisplayedImageInfo> list2 = ((DisplayedImageDataGroup) obj).imageInfos;
        if (list == list2 || (list != null && list.equals(list2))) {
            return true;
        }
        return false;
    }

    public List<DisplayedImageInfo> getImages() {
        return new ArrayList(this.imageInfos);
    }

    public int hashCode() {
        int i;
        List<DisplayedImageInfo> list = this.imageInfos;
        if (list == null) {
            i = 1;
        } else {
            i = list.hashCode();
        }
        return i + 32674;
    }

    public void readContent(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream;
        if (inputStream instanceof TLVInputStream) {
            tLVInputStream = (TLVInputStream) inputStream;
        } else {
            tLVInputStream = new TLVInputStream(inputStream);
        }
        int readTag = tLVInputStream.readTag();
        if (readTag != 2) {
            throw new IllegalArgumentException("Expected tag 0x02 in displayed image structure, found " + Integer.toHexString(readTag));
        } else if (tLVInputStream.readLength() == 1) {
            byte b = tLVInputStream.readValue()[0] & 255;
            for (int i = 0; i < b; i++) {
                DisplayedImageInfo displayedImageInfo = new DisplayedImageInfo(tLVInputStream);
                if (i == 0) {
                    this.displayedImageTagToUse = displayedImageInfo.getDisplayedImageTag();
                } else if (displayedImageInfo.getDisplayedImageTag() != this.displayedImageTagToUse) {
                    throw new IOException("Found images with different displayed image tags inside displayed image datagroup");
                }
                add(displayedImageInfo);
            }
        } else {
            throw new IllegalArgumentException("DISPLAYED_IMAGE_COUNT should have length 1");
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" [");
        List<DisplayedImageInfo> list = this.imageInfos;
        if (list != null) {
            boolean z = true;
            for (DisplayedImageInfo next : list) {
                if (z) {
                    z = false;
                } else {
                    sb2.append(", ");
                }
                sb2.append(next.toString());
            }
            sb2.append("]");
            return sb2.toString();
        }
        throw new IllegalStateException("imageInfos cannot be null");
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream;
        if (outputStream instanceof TLVOutputStream) {
            tLVOutputStream = (TLVOutputStream) outputStream;
        } else {
            tLVOutputStream = new TLVOutputStream(outputStream);
        }
        tLVOutputStream.writeTag(2);
        tLVOutputStream.writeValue(new byte[]{(byte) this.imageInfos.size()});
        for (DisplayedImageInfo writeObject : this.imageInfos) {
            writeObject.writeObject(tLVOutputStream);
        }
    }

    public DisplayedImageDataGroup(int i, InputStream inputStream) throws IOException {
        super(i, inputStream);
        if (this.imageInfos == null) {
            this.imageInfos = new ArrayList();
        }
        checkTypesConsistentWithTag();
    }
}
