package com.fis.ekyc.nfc.build_in.model;

import android.util.Base64;
import com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.AAResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.EACCAResult;
import java.nio.ByteBuffer;

public class CardResult {
    private byte[] AllData;
    private ByteBuffer[] DgAll;
    private byte[] SOD;
    private AAResult aaResult = null;
    private CheckingCode activeCheck;
    private String challengeBase64;
    private CheckingCode chipCheck;
    private ResultCode code = ResultCode.UNKNOWN;
    private EACCAResult eaccaResult = null;
    private CheckingCode hashCheck;
    private IDCardDetail personalDetail;
    private long readDG2Time;

    public CardResult() {
        CheckingCode checkingCode = CheckingCode.NOT_CHECK;
        this.hashCheck = checkingCode;
        this.chipCheck = checkingCode;
        this.activeCheck = checkingCode;
        this.DgAll = new ByteBuffer[16];
        this.SOD = null;
        this.AllData = null;
    }

    public void buildData() {
        int i;
        try {
            byte[] bArr = this.SOD;
            if (bArr != null) {
                int length = bArr.length + 68;
                for (ByteBuffer byteBuffer : this.DgAll) {
                    if (byteBuffer != null) {
                        length += byteBuffer.array().length;
                    }
                }
                ByteBuffer allocate = ByteBuffer.allocate(length);
                int length2 = this.SOD.length;
                allocate.put(new byte[]{(byte) ((length2 >> 24) & 255), (byte) ((length2 >> 16) & 255), (byte) ((length2 >> 8) & 255), (byte) (length2 & 255)});
                allocate.put(this.SOD);
                int i2 = 0;
                while (true) {
                    ByteBuffer[] byteBufferArr = this.DgAll;
                    if (i2 < byteBufferArr.length) {
                        ByteBuffer byteBuffer2 = byteBufferArr[i2];
                        if (byteBuffer2 != null) {
                            i = byteBuffer2.array().length;
                        } else {
                            i = 0;
                        }
                        allocate.put(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)});
                        if (byteBuffer2 != null) {
                            allocate.put(byteBuffer2.array());
                        }
                        i2++;
                    } else {
                        this.AllData = allocate.array();
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AAResult getAaResult() {
        return this.aaResult;
    }

    public String getBase64Data() {
        byte[] data = getData();
        if (data != null) {
            return Base64.encodeToString(data, 0);
        }
        return null;
    }

    public String getChallengeBase64() {
        return this.challengeBase64.replaceAll("\n", "");
    }

    public ResultCode getCode() {
        return this.code;
    }

    public byte[] getDG(int i) {
        ByteBuffer byteBuffer;
        if (i < 1) {
            return null;
        }
        ByteBuffer[] byteBufferArr = this.DgAll;
        if (i > byteBufferArr.length || (byteBuffer = byteBufferArr[i - 1]) == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public byte[] getData() {
        if (this.AllData == null) {
            buildData();
        }
        return this.AllData;
    }

    public EACCAResult getEaccaResult() {
        return this.eaccaResult;
    }

    public IDCardDetail getPersonalDetail() {
        return this.personalDetail;
    }

    public long getReadDG2Time() {
        return this.readDG2Time;
    }

    public byte[] getSOD() {
        return this.SOD;
    }

    public void setAaResult(AAResult aAResult) {
        this.aaResult = aAResult;
    }

    public void setActiveCheck(CheckingCode checkingCode) {
        this.activeCheck = checkingCode;
    }

    public void setChallengeBase64(String str) {
        this.challengeBase64 = str;
    }

    public void setChipCheck(CheckingCode checkingCode) {
        this.chipCheck = checkingCode;
    }

    public void setCode(ResultCode resultCode) {
        this.code = resultCode;
    }

    public void setDG(int i, byte[] bArr) {
        if (i >= 1) {
            ByteBuffer[] byteBufferArr = this.DgAll;
            if (i <= byteBufferArr.length) {
                int i2 = i - 1;
                byteBufferArr[i2] = ByteBuffer.allocate(bArr.length);
                this.DgAll[i2].put(bArr);
            }
        }
    }

    public void setEaccaResult(EACCAResult eACCAResult) {
        this.eaccaResult = eACCAResult;
    }

    public void setPersonalDetail(IDCardDetail iDCardDetail) {
        this.personalDetail = iDCardDetail;
    }

    public void setReadDG2Time(long j) {
        this.readDG2Time = j;
    }

    public void setSOD(byte[] bArr) {
        this.SOD = bArr;
    }
}
