package com.fis.ekyc.nfc.build_in.eidparser.lds;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractListInfo<R extends Serializable> extends AbstractLDSInfo {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final long serialVersionUID = 2970076896364365191L;
    private List<R> subRecords;

    public void add(R r) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.add(r);
    }

    public void addAll(List<R> list) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.addAll(list);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractListInfo)) {
            return false;
        }
        try {
            List subRecords2 = getSubRecords();
            List subRecords3 = ((AbstractListInfo) obj).getSubRecords();
            int size = subRecords2.size();
            if (size != subRecords3.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                Serializable serializable = (Serializable) subRecords2.get(i);
                Serializable serializable2 = (Serializable) subRecords3.get(i);
                if (serializable == null) {
                    if (serializable2 != null) {
                        return false;
                    }
                } else if (!serializable.equals(serializable2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e) {
            LOGGER.log(Level.WARNING, "Wrong class", e);
            return false;
        }
    }

    public List<R> getSubRecords() {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        return new ArrayList(this.subRecords);
    }

    public int hashCode() {
        int i = 1234567891;
        for (Serializable serializable : getSubRecords()) {
            if (serializable == null) {
                i = (i * 3) + 5;
            } else {
                i = ((i + serializable.hashCode()) * 5) + 7;
            }
        }
        return (i * 7) + 11;
    }

    public abstract void readObject(InputStream inputStream) throws IOException;

    public void remove(int i) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.remove(i);
    }

    public abstract void writeObject(OutputStream outputStream) throws IOException;
}
