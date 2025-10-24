package com.google.android.datatransport.cct;

import P4.d;
import P4.h;
import P4.m;
import androidx.annotation.Keep;

@Keep
public class CctBackendFactory implements d {
    public m create(h hVar) {
        return new M4.d(hVar.b(), hVar.e(), hVar.d());
    }
}
