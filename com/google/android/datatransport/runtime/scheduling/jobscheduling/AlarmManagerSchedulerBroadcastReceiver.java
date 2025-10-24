package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import O4.p;
import O4.u;
import Z4.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ void b() {
    }

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        u.f(context);
        p.a d = p.a().b(queryParameter).d(a.b(intValue));
        if (queryParameter2 != null) {
            d.c(Base64.decode(queryParameter2, 0));
        }
        u.c().e().v(d.a(), i, new V4.a());
    }
}
