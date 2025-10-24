package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.q;

final class zae extends zag {
    final /* synthetic */ Intent zaa;
    final /* synthetic */ q zab;
    final /* synthetic */ int zac;

    public zae(Intent intent, q qVar, int i) {
        this.zaa = intent;
        this.zab = qVar;
        this.zac = i;
    }

    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, this.zac);
        }
    }
}
