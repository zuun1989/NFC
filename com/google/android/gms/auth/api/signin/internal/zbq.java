package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapi.zbb;
import com.google.android.gms.internal.p001authapi.zbc;

public abstract class zbq extends zbb implements zbr {
    public zbq() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case LDSFile.EF_DG5_TAG:
                zbc.zbb(parcel);
                zbd((GoogleSignInAccount) zbc.zba(parcel, GoogleSignInAccount.CREATOR), (Status) zbc.zba(parcel, Status.CREATOR));
                break;
            case LDSFile.EF_DG6_TAG:
                zbc.zbb(parcel);
                zbc((Status) zbc.zba(parcel, Status.CREATOR));
                break;
            case LDSFile.EF_DG7_TAG:
                zbc.zbb(parcel);
                zbb((Status) zbc.zba(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
