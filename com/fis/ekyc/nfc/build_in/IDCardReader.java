package com.fis.ekyc.nfc.build_in;

import android.app.Activity;
import android.nfc.tech.IsoDep;
import android.util.Log;
import androidx.lifecycle.u;
import com.fis.ekyc.nfc.build_in.eidparser.ICaoReaderParser;
import com.fis.ekyc.nfc.build_in.model.CardResult;
import com.fis.ekyc.nfc.build_in.model.ResultCode;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;

public class IDCardReader {
    private static final String TAG = "IDCardReader";

    public CardResult readData(IsoDep isoDep, String str, String str2, String str3, boolean z, boolean z2, boolean z3, u uVar, Activity activity) {
        try {
            return new ICaoReaderParser().readData(CardService.getInstance(isoDep), str, str2, str3, z, z2, z3, uVar, activity);
        } catch (Exception e) {
            Log.e("ErrorReadCard", "An Error Occurred While Reading Card", e);
            Log.e(TAG, "Error", e);
            CardResult cardResult = new CardResult();
            cardResult.setCode(ResultCode.CANNOT_OPEN_DEVICE);
            return cardResult;
        }
    }
}
