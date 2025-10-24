package com.fis.ekyc.nfc.build_in.scuba.tlv;

import com.fis.ekyc.nfc.build_in.scuba.util.Hex;
import com.google.android.gms.common.api.Api;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

class TLVOutputState implements Cloneable {
    private boolean isAtStartOfLength;
    private boolean isAtStartOfTag;
    private boolean isReadingValue;
    private Stack<TLVStruct> state;

    public class TLVStruct implements Cloneable {
        /* access modifiers changed from: private */
        public boolean isLengthSet = false;
        private int length = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        private int tag;
        private ByteArrayOutputStream value = new ByteArrayOutputStream();

        public TLVStruct(int i) {
            this.tag = i;
        }

        public Object clone() {
            TLVStruct tLVStruct = new TLVStruct(this.tag);
            tLVStruct.length = this.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            tLVStruct.value = byteArrayOutputStream;
            try {
                byteArrayOutputStream.write(this.value.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tLVStruct;
        }

        public int getLength() {
            return this.length;
        }

        public int getTag() {
            return this.tag;
        }

        public byte[] getValue() {
            return this.value.toByteArray();
        }

        public int getValueBytesProcessed() {
            return this.value.size();
        }

        public boolean isLengthSet() {
            return this.isLengthSet;
        }

        public void setLength(int i) {
            this.length = i;
            this.isLengthSet = true;
        }

        public String toString() {
            Object obj;
            byte[] byteArray = this.value.toByteArray();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[TLVStruct ");
            sb2.append(Integer.toHexString(this.tag));
            sb2.append(", ");
            if (this.isLengthSet) {
                obj = Integer.valueOf(this.length);
            } else {
                obj = "UNDEFINED";
            }
            sb2.append(obj);
            sb2.append(", ");
            sb2.append(Hex.bytesToHexString(byteArray));
            sb2.append("(");
            sb2.append(byteArray.length);
            sb2.append(") ]");
            return sb2.toString();
        }

        public void write(byte[] bArr, int i, int i2) {
            this.value.write(bArr, i, i2);
        }
    }

    public TLVOutputState() {
        this.state = new Stack<>();
        this.isAtStartOfTag = true;
        this.isAtStartOfLength = false;
        this.isReadingValue = false;
    }

    public boolean canBeWritten() {
        Iterator<TLVStruct> it = this.state.iterator();
        while (it.hasNext()) {
            if (!it.next().isLengthSet()) {
                return false;
            }
        }
        return true;
    }

    public Object clone() {
        return new TLVOutputState((Stack) this.state.clone(), this.isAtStartOfTag, this.isAtStartOfLength, this.isReadingValue);
    }

    public int getLength() {
        if (!this.state.isEmpty()) {
            int length = this.state.peek().getLength();
            if (length >= 0) {
                return length;
            }
            throw new IllegalStateException("Length not yet knwon.");
        }
        throw new IllegalStateException("Length not yet known.");
    }

    public int getTag() {
        if (!this.state.isEmpty()) {
            return this.state.peek().getTag();
        }
        throw new IllegalStateException("Tag not yet read.");
    }

    public byte[] getValue() {
        if (!this.state.isEmpty()) {
            return this.state.peek().getValue();
        }
        throw new IllegalStateException("Cannot get value yet.");
    }

    public int getValueBytesLeft() {
        if (!this.state.isEmpty()) {
            TLVStruct peek = this.state.peek();
            return peek.getLength() - peek.getValueBytesProcessed();
        }
        throw new IllegalStateException("Length of value is unknown.");
    }

    public int getValueBytesProcessed() {
        return this.state.peek().getValueBytesProcessed();
    }

    public boolean isAtStartOfLength() {
        return this.isAtStartOfLength;
    }

    public boolean isAtStartOfTag() {
        return this.isAtStartOfTag;
    }

    public boolean isDummyLengthSet() {
        if (this.state.isEmpty()) {
            return false;
        }
        return !this.state.peek().isLengthSet();
    }

    public boolean isProcessingValue() {
        return this.isReadingValue;
    }

    public void setDummyLengthProcessed() {
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = false;
        this.isReadingValue = true;
    }

    public void setLengthProcessed(int i) {
        if (i >= 0) {
            TLVStruct pop = this.state.pop();
            if (!this.state.isEmpty()) {
                byte[] lengthAsBytes = TLVUtil.getLengthAsBytes(i);
                this.state.peek().write(lengthAsBytes, 0, lengthAsBytes.length);
            }
            pop.setLength(i);
            this.state.push(pop);
            this.isAtStartOfTag = false;
            this.isAtStartOfLength = false;
            this.isReadingValue = true;
            return;
        }
        throw new IllegalArgumentException("Cannot set negative length (length = " + i + ").");
    }

    public void setTagProcessed(int i) {
        TLVStruct tLVStruct = new TLVStruct(i);
        if (!this.state.isEmpty()) {
            byte[] tagAsBytes = TLVUtil.getTagAsBytes(i);
            this.state.peek().write(tagAsBytes, 0, tagAsBytes.length);
        }
        this.state.push(tLVStruct);
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = true;
        this.isReadingValue = false;
    }

    public String toString() {
        return this.state.toString();
    }

    public void updatePreviousLength(int i) {
        if (!this.state.isEmpty()) {
            TLVStruct peek = this.state.peek();
            if (!peek.isLengthSet || peek.getLength() != i) {
                peek.setLength(i);
                if (peek.getValueBytesProcessed() == peek.getLength()) {
                    this.state.pop();
                    byte[] lengthAsBytes = TLVUtil.getLengthAsBytes(i);
                    byte[] value = peek.getValue();
                    updateValueBytesProcessed(lengthAsBytes, 0, lengthAsBytes.length);
                    updateValueBytesProcessed(value, 0, value.length);
                    this.isAtStartOfTag = true;
                    this.isAtStartOfLength = false;
                    this.isReadingValue = false;
                }
            }
        }
    }

    public void updateValueBytesProcessed(byte[] bArr, int i, int i2) {
        if (!this.state.isEmpty()) {
            TLVStruct peek = this.state.peek();
            int length = peek.getLength() - peek.getValueBytesProcessed();
            if (i2 <= length) {
                peek.write(bArr, i, i2);
                if (peek.getValueBytesProcessed() == peek.getLength()) {
                    this.state.pop();
                    updateValueBytesProcessed(peek.getValue(), 0, peek.getLength());
                    this.isAtStartOfTag = true;
                    this.isAtStartOfLength = false;
                    this.isReadingValue = false;
                    return;
                }
                this.isAtStartOfTag = false;
                this.isAtStartOfLength = false;
                this.isReadingValue = true;
                return;
            }
            throw new IllegalArgumentException("Cannot process " + i2 + " bytes! Only " + length + " bytes left in this TLV object " + peek);
        }
    }

    private TLVOutputState(Stack<TLVStruct> stack, boolean z, boolean z2, boolean z3) {
        this.state = stack;
        this.isAtStartOfTag = z;
        this.isAtStartOfLength = z2;
        this.isReadingValue = z3;
    }
}
