package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class zzg implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ CloudMessage zzb;
    public final /* synthetic */ CountDownLatch zzc;

    public /* synthetic */ zzg(Context context, CloudMessage cloudMessage, CountDownLatch countDownLatch) {
        this.zza = context;
        this.zzb = cloudMessage;
        this.zzc = countDownLatch;
    }

    public final void run() {
        Task task;
        CloudMessage cloudMessage = this.zzb;
        if (TextUtils.isEmpty(cloudMessage.getMessageId())) {
            task = Tasks.forResult((Object) null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", cloudMessage.getMessageId());
            Integer zza2 = cloudMessage.zza();
            if (zza2 != null) {
                bundle.putInt("google.product_id", zza2.intValue());
            }
            Context context = this.zza;
            bundle.putBoolean("supports_message_handled", true);
            task = zzv.zzb(context).zzc(2, bundle);
        }
        task.addOnCompleteListener(zze.zza, new zzf(this.zzc));
    }
}
