package com.google.android.gms.internal.measurement;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;

final class zzor extends IllegalArgumentException {
    public zzor(int i, int i2) {
        super(zzkw.zza(i2, i, ISO7816.INS_VERIFY, "Unpaired surrogate at index ", " of "));
    }
}
