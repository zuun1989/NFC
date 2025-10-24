package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p001authapi.zba;
import com.google.android.gms.internal.p001authapi.zbc;

public final class zbs extends zba implements IInterface {
    public zbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zbc(zbr zbr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbr);
        zbc.zbc(zba, googleSignInOptions);
        zbb(LDSFile.EF_DG7_TAG, zba);
    }

    public final void zbd(zbr zbr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbr);
        zbc.zbc(zba, googleSignInOptions);
        zbb(LDSFile.EF_DG6_TAG, zba);
    }

    public final void zbe(zbr zbr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbr);
        zbc.zbc(zba, googleSignInOptions);
        zbb(LDSFile.EF_DG5_TAG, zba);
    }
}
