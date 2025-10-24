package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.RunnableFuture;

final class zzew extends zzef implements RunnableFuture {
    private volatile zzer zzc;

    public zzew(zzxh zzxh) {
        this.zzc = new zzev(this, zzxh);
    }

    public final void run() {
        zzer zzer = this.zzc;
        if (zzer != null) {
            zzer.run();
        }
        this.zzc = null;
    }

    public final String zzf() {
        zzer zzer = this.zzc;
        if (zzer == null) {
            return super.zzf();
        }
        String obj = zzer.toString();
        return "task=[" + obj + "]";
    }

    public final void zzm() {
        zzer zzer;
        if (zzp() && (zzer = this.zzc) != null) {
            zzer.zze();
        }
        this.zzc = null;
    }
}
