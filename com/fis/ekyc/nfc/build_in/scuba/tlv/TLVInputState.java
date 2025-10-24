package com.fis.ekyc.nfc.build_in.scuba.tlv;

import com.google.android.gms.common.api.Api;
import java.util.Stack;

class TLVInputState implements Cloneable {
    private boolean isAtStartOfLength;
    private boolean isAtStartOfTag;
    private boolean isReadingValue;
    private Stack<TLStruct> state;

    public class TLStruct implements Cloneable {
        private int length = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        private int tag;
        private int valueBytesRead = 0;

        public TLStruct(int i) {
            this.tag = i;
        }

        public Object clone() {
            TLStruct tLStruct = new TLStruct(this.tag);
            tLStruct.length = this.length;
            tLStruct.valueBytesRead = this.valueBytesRead;
            return tLStruct;
        }

        public int getLength() {
            return this.length;
        }

        public int getTag() {
            return this.tag;
        }

        public int getValueBytesProcessed() {
            return this.valueBytesRead;
        }

        public void setLength(int i) {
            this.length = i;
        }

        public String toString() {
            return "[TLStruct " + Integer.toHexString(this.tag) + ", " + this.length + ", " + this.valueBytesRead + "]";
        }

        public void updateValueBytesProcessed(int i) {
            this.valueBytesRead += i;
        }
    }

    public TLVInputState() {
        this.state = new Stack<>();
        this.isAtStartOfTag = true;
        this.isAtStartOfLength = false;
        this.isReadingValue = false;
    }

    public Object clone() {
        Stack stack = new Stack();
        for (int i = 0; i < this.state.size(); i++) {
            stack.add((TLStruct) this.state.get(i).clone());
        }
        return new TLVInputState(stack, this.isAtStartOfTag, this.isAtStartOfLength, this.isReadingValue);
    }

    public int getLength() {
        if (!this.state.isEmpty()) {
            return this.state.peek().getLength();
        }
        throw new IllegalStateException("Length not yet known.");
    }

    public int getTag() {
        if (!this.state.isEmpty()) {
            return this.state.peek().getTag();
        }
        throw new IllegalStateException("Tag not yet read.");
    }

    public int getValueBytesLeft() {
        if (!this.state.isEmpty()) {
            TLStruct peek = this.state.peek();
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

    public boolean isProcessingValue() {
        return this.isReadingValue;
    }

    public void setDummyLengthProcessed() {
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = false;
        this.isReadingValue = true;
    }

    public void setLengthProcessed(int i, int i2) {
        if (i >= 0) {
            TLStruct pop = this.state.pop();
            if (!this.state.isEmpty()) {
                this.state.peek().updateValueBytesProcessed(i2);
            }
            pop.setLength(i);
            this.state.push(pop);
            this.isAtStartOfTag = false;
            this.isAtStartOfLength = false;
            this.isReadingValue = true;
            return;
        }
        throw new IllegalArgumentException("Cannot set negative length (length = " + i + ", 0x" + Integer.toHexString(i) + " for tag " + Integer.toHexString(getTag()) + ").");
    }

    public void setTagProcessed(int i, int i2) {
        TLStruct tLStruct = new TLStruct(i);
        if (!this.state.isEmpty()) {
            this.state.peek().updateValueBytesProcessed(i2);
        }
        this.state.push(tLStruct);
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = true;
        this.isReadingValue = false;
    }

    public String toString() {
        return this.state.toString();
    }

    public void updateValueBytesProcessed(int i) {
        if (!this.state.isEmpty()) {
            TLStruct peek = this.state.peek();
            int length = peek.getLength() - peek.getValueBytesProcessed();
            if (i <= length) {
                peek.updateValueBytesProcessed(i);
                int length2 = peek.getLength();
                if (peek.getValueBytesProcessed() == length2) {
                    this.state.pop();
                    updateValueBytesProcessed(length2);
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
            throw new IllegalArgumentException("Cannot process " + i + " bytes! Only " + length + " bytes left in this TLV object " + peek);
        }
    }

    private TLVInputState(Stack<TLStruct> stack, boolean z, boolean z2, boolean z3) {
        this.state = stack;
        this.isAtStartOfTag = z;
        this.isAtStartOfLength = z2;
        this.isReadingValue = z3;
    }
}
