package com.google.android.gms.internal.base;

import I0.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

public final class zao extends b {
    @ResultIgnorabilityUnspecified
    @Deprecated
    public static Intent zaa(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i;
        if (!zan.zaa()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        if (true != zan.zaa()) {
            i = 0;
        } else {
            i = 2;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, i);
    }
}
