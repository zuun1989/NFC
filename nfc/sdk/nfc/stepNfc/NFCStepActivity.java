package com.fis.nfc.sdk.nfc.stepNfc;

import Mc.l;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import androidx.lifecycle.u;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp.PKIFailureInfo;
import com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail;
import com.fis.ekyc.nfc.build_in.model.CardResult;
import com.fis.ekyc.nfc.build_in.model.ResultCode;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.o;
import m.c;
import u4.C0052c;
import u4.C0053d;
import u4.C0056g;
import u4.C0057h;
import u4.C0058i;
import u4.j;
import v4.C0059a;
import w4.C0061b;

public final class NFCStepActivity extends c {
    public C0052c c;
    public CardResult d;
    public BroadcastReceiver e;
    public u f = new u();
    public ExecutorService g;
    public boolean h;
    public boolean i;
    public Map j = new LinkedHashMap();

    public static final class a extends BroadcastReceiver {
        public final /* synthetic */ NFCStepActivity a;

        public a(NFCStepActivity nFCStepActivity) {
            this.a = nFCStepActivity;
        }

        public void onReceive(Context context, Intent intent) {
            n.f(context, "context");
            n.f(intent, "intent");
            if (n.a(intent.getAction(), "android.nfc.action.ADAPTER_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.nfc.extra.ADAPTER_STATE", 1);
                if (intExtra == 1 || intExtra == 4) {
                    this.a.q0(ResultCode.NFC_IS_OFF);
                }
            }
        }
    }

    public static final class b extends o implements l {
        public final /* synthetic */ NFCStepActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NFCStepActivity nFCStepActivity) {
            super(1);
            this.a = nFCStepActivity;
        }

        public final void b(C0052c cVar) {
            n.f(cVar, "bottomSheetDialog");
            if (this.a.g != null) {
                ExecutorService h0 = this.a.g;
                n.c(h0);
                h0.shutdown();
            }
            cVar.dismissAllowingStateLoss();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((C0052c) obj);
            return xc.u.a;
        }
    }

    public static final void k0(NFCStepActivity nFCStepActivity, String str) {
        n.f(nFCStepActivity, "this$0");
        C0052c cVar = nFCStepActivity.c;
        n.c(cVar);
        n.c(str);
        cVar.d0(str);
    }

    public static final void l0(NFCStepActivity nFCStepActivity, String str) {
        n.f(nFCStepActivity, "this$0");
        C0052c cVar = nFCStepActivity.c;
        n.c(cVar);
        n.c(str);
        cVar.d0(str);
        C0053d.a aVar = C0053d.a;
        if (aVar.j() != null) {
            u j2 = aVar.j();
            n.c(j2);
            j2.m(str);
        }
    }

    public static final void m0(NFCStepActivity nFCStepActivity, Tag tag) {
        n.f(nFCStepActivity, "this$0");
        nFCStepActivity.n0(tag);
    }

    public static final void o0(NFCStepActivity nFCStepActivity, C0059a aVar, IDCardDetail iDCardDetail) {
        n.f(nFCStepActivity, "this$0");
        n.f(aVar, "$cardObject");
        C0052c cVar = nFCStepActivity.c;
        if (cVar != null) {
            String json = new Gson().toJson(aVar);
            n.e(json, "Gson().toJson(cardObject)");
            n.e(iDCardDetail, "personalData");
            cVar.V(json, iDCardDetail);
        }
    }

    public static final void r0(NFCStepActivity nFCStepActivity, ResultCode resultCode) {
        n.f(nFCStepActivity, "this$0");
        n.f(resultCode, "$resultCode");
        C0052c cVar = nFCStepActivity.c;
        n.c(cVar);
        cVar.Y(resultCode.toString());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.fis.nfc.sdk.nfc.stepNfc.NFCStepActivity, androidx.lifecycle.m, android.app.Activity] */
    public final void j0() {
        this.h = true;
        C0061b.a.r(this);
        ResultCode a2 = C0053d.a.a(this);
        if (a2 != ResultCode.NFC_IS_AVAILABLE) {
            q0(a2);
        }
        this.f.i(this, new C0058i(this));
        this.f.i(this, new j(this));
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [com.fis.nfc.sdk.nfc.stepNfc.NFCStepActivity, android.app.Activity] */
    /* JADX WARNING: type inference failed for: r10v0, types: [android.app.Activity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0170 A[Catch:{ Exception -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0189 A[Catch:{ Exception -> 0x0150 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n0(android.nfc.Tag r22) {
        /*
            r21 = this;
            r11 = r21
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            long r12 = r0.getTimeInMillis()
            android.nfc.tech.IsoDep r2 = android.nfc.tech.IsoDep.get(r22)
            com.fis.ekyc.nfc.build_in.IDCardReader r1 = new com.fis.ekyc.nfc.build_in.IDCardReader     // Catch:{ Exception -> 0x0150 }
            r1.<init>()     // Catch:{ Exception -> 0x0150 }
            u4.d$a r0 = u4.C0053d.a     // Catch:{ Exception -> 0x0150 }
            java.lang.String r3 = r0.g()     // Catch:{ Exception -> 0x0150 }
            java.lang.String r4 = r0.c()     // Catch:{ Exception -> 0x0150 }
            java.lang.String r5 = r0.f()     // Catch:{ Exception -> 0x0150 }
            androidx.lifecycle.u r9 = r11.f     // Catch:{ Exception -> 0x0150 }
            r6 = 1
            r7 = 1
            r8 = 1
            r10 = r21
            com.fis.ekyc.nfc.build_in.model.CardResult r1 = r1.readData(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0150 }
            r11.d = r1     // Catch:{ Exception -> 0x0150 }
            if (r1 == 0) goto L_0x01b2
            kotlin.jvm.internal.n.c(r1)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.ResultCode r1 = r1.getCode()     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.ResultCode r2 = com.fis.ekyc.nfc.build_in.model.ResultCode.SUCCESS     // Catch:{ Exception -> 0x0150 }
            if (r1 != r2) goto L_0x0192
            com.fis.ekyc.nfc.build_in.model.CardResult r1 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r1)     // Catch:{ Exception -> 0x0150 }
            byte[] r1 = r1.getSOD()     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.CardResult r2 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r2)     // Catch:{ Exception -> 0x0150 }
            r3 = 1
            byte[] r2 = r2.getDG(r3)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.CardResult r4 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r4)     // Catch:{ Exception -> 0x0150 }
            r5 = 2
            byte[] r4 = r4.getDG(r5)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.CardResult r6 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r6)     // Catch:{ Exception -> 0x0150 }
            r7 = 13
            byte[] r6 = r6.getDG(r7)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.CardResult r7 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r7)     // Catch:{ Exception -> 0x0150 }
            r8 = 14
            byte[] r7 = r7.getDG(r8)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.CardResult r8 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r8)     // Catch:{ Exception -> 0x0150 }
            r9 = 15
            byte[] r8 = r8.getDG(r9)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.CardResult r9 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r9)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail r9 = r9.getPersonalDetail()     // Catch:{ Exception -> 0x0150 }
            java.lang.String r10 = ""
            if (r1 != 0) goto L_0x0088
            r15 = r10
            goto L_0x008d
        L_0x0088:
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r5)     // Catch:{ Exception -> 0x0150 }
            r15 = r1
        L_0x008d:
            r9.setSodBase64(r15)     // Catch:{ Exception -> 0x0150 }
            if (r2 != 0) goto L_0x0095
            r16 = r10
            goto L_0x009b
        L_0x0095:
            java.lang.String r1 = android.util.Base64.encodeToString(r2, r5)     // Catch:{ Exception -> 0x0150 }
            r16 = r1
        L_0x009b:
            if (r4 != 0) goto L_0x009f
            r1 = r10
            goto L_0x00a3
        L_0x009f:
            java.lang.String r1 = android.util.Base64.encodeToString(r4, r5)     // Catch:{ Exception -> 0x0150 }
        L_0x00a3:
            r9.setPhotoBase64(r1)     // Catch:{ Exception -> 0x0150 }
            if (r6 != 0) goto L_0x00ab
            r18 = r10
            goto L_0x00b1
        L_0x00ab:
            java.lang.String r2 = android.util.Base64.encodeToString(r6, r5)     // Catch:{ Exception -> 0x0150 }
            r18 = r2
        L_0x00b1:
            if (r7 != 0) goto L_0x00b6
            r19 = r10
            goto L_0x00bc
        L_0x00b6:
            java.lang.String r2 = android.util.Base64.encodeToString(r7, r5)     // Catch:{ Exception -> 0x0150 }
            r19 = r2
        L_0x00bc:
            if (r8 != 0) goto L_0x00c1
        L_0x00be:
            r20 = r10
            goto L_0x00c6
        L_0x00c1:
            java.lang.String r10 = android.util.Base64.encodeToString(r8, r5)     // Catch:{ Exception -> 0x0150 }
            goto L_0x00be
        L_0x00c6:
            v4.a r2 = new v4.a     // Catch:{ Exception -> 0x0150 }
            r14 = r2
            r17 = r1
            r14.<init>(r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x0150 }
            androidx.lifecycle.u r1 = r11.f     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.D r4 = kotlin.jvm.internal.D.a     // Catch:{ Exception -> 0x0150 }
            java.lang.String r4 = "Read DG2: %s millis\nTotal: %s millis"
            com.fis.ekyc.nfc.build_in.model.CardResult r6 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r6)     // Catch:{ Exception -> 0x0150 }
            long r6 = r6.getReadDG2Time()     // Catch:{ Exception -> 0x0150 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0150 }
            java.util.Calendar r7 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0150 }
            long r7 = r7.getTimeInMillis()     // Catch:{ Exception -> 0x0150 }
            long r7 = r7 - r12
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0150 }
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7}     // Catch:{ Exception -> 0x0150 }
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r5)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r4 = java.lang.String.format(r4, r6)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r6 = "format(format, *args)"
            kotlin.jvm.internal.n.e(r4, r6)     // Catch:{ Exception -> 0x0150 }
            r1.m(r4)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.CardResult r1 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r1)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r1 = r1.getChallengeBase64()     // Catch:{ Exception -> 0x0150 }
            r2.e(r1)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.CardResult r1 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r1)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.eidparser.protocol.AAResult r1 = r1.getAaResult()     // Catch:{ Exception -> 0x0150 }
            byte[] r1 = r1.getResponse()     // Catch:{ Exception -> 0x0150 }
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r5)     // Catch:{ Exception -> 0x0150 }
            r2.f(r1)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.CardResult r1 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r1)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.eidparser.protocol.EACCAResult r1 = r1.getEaccaResult()     // Catch:{ Exception -> 0x0150 }
            byte[] r1 = r1.getKeyHash()     // Catch:{ Exception -> 0x0150 }
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r5)     // Catch:{ Exception -> 0x0150 }
            r2.g(r1)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r1 = r2.b()     // Catch:{ Exception -> 0x0150 }
            if (r1 == 0) goto L_0x0152
            int r1 = r1.length()     // Catch:{ Exception -> 0x0150 }
            if (r1 != 0) goto L_0x0143
            goto L_0x0152
        L_0x0143:
            java.lang.String r1 = r2.d()     // Catch:{ Exception -> 0x0150 }
            if (r1 == 0) goto L_0x0152
            int r1 = r1.length()     // Catch:{ Exception -> 0x0150 }
            if (r1 != 0) goto L_0x016c
            goto L_0x0152
        L_0x0150:
            r0 = move-exception
            goto L_0x01b8
        L_0x0152:
            java.lang.String r1 = r2.a()     // Catch:{ Exception -> 0x0150 }
            if (r1 == 0) goto L_0x018c
            int r1 = r1.length()     // Catch:{ Exception -> 0x0150 }
            if (r1 != 0) goto L_0x015f
            goto L_0x018c
        L_0x015f:
            java.lang.String r1 = r2.c()     // Catch:{ Exception -> 0x0150 }
            if (r1 == 0) goto L_0x018c
            int r1 = r1.length()     // Catch:{ Exception -> 0x0150 }
            if (r1 != 0) goto L_0x016c
            goto L_0x018c
        L_0x016c:
            boolean r1 = r11.h     // Catch:{ Exception -> 0x0150 }
            if (r1 == 0) goto L_0x0189
            w4.b$a r1 = w4.C0061b.a     // Catch:{ Exception -> 0x0150 }
            java.lang.String r3 = r0.g()     // Catch:{ Exception -> 0x0150 }
            r1.x(r3, r11)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r0 = r0.h()     // Catch:{ Exception -> 0x0150 }
            r1.y(r0, r11)     // Catch:{ Exception -> 0x0150 }
            u4.k r0 = new u4.k     // Catch:{ Exception -> 0x0150 }
            r0.<init>(r11, r2, r9)     // Catch:{ Exception -> 0x0150 }
            r11.runOnUiThread(r0)     // Catch:{ Exception -> 0x0150 }
            goto L_0x01c4
        L_0x0189:
            r11.i = r3     // Catch:{ Exception -> 0x0150 }
            goto L_0x01c4
        L_0x018c:
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = com.fis.ekyc.nfc.build_in.model.ResultCode.MISSING_PARAMS     // Catch:{ Exception -> 0x0150 }
            r11.q0(r0)     // Catch:{ Exception -> 0x0150 }
            goto L_0x01c4
        L_0x0192:
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r0)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = r0.getCode()     // Catch:{ Exception -> 0x0150 }
            if (r0 == 0) goto L_0x01a7
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r11.d     // Catch:{ Exception -> 0x0150 }
            kotlin.jvm.internal.n.c(r0)     // Catch:{ Exception -> 0x0150 }
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = r0.getCode()     // Catch:{ Exception -> 0x0150 }
            goto L_0x01a9
        L_0x01a7:
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = com.fis.ekyc.nfc.build_in.model.ResultCode.UNKNOWN     // Catch:{ Exception -> 0x0150 }
        L_0x01a9:
            java.lang.String r1 = "if (mCardResult!!.code !…e else ResultCode.UNKNOWN"
            kotlin.jvm.internal.n.e(r0, r1)     // Catch:{ Exception -> 0x0150 }
            r11.q0(r0)     // Catch:{ Exception -> 0x0150 }
            goto L_0x01c4
        L_0x01b2:
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = com.fis.ekyc.nfc.build_in.model.ResultCode.UNKNOWN     // Catch:{ Exception -> 0x0150 }
            r11.q0(r0)     // Catch:{ Exception -> 0x0150 }
            goto L_0x01c4
        L_0x01b8:
            java.lang.String r1 = "Read_NFC"
            java.lang.String r2 = "Error while process"
            android.util.Log.e(r1, r2, r0)
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = com.fis.ekyc.nfc.build_in.model.ResultCode.UNKNOWN
            r11.q0(r0)
        L_0x01c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.nfc.sdk.nfc.stepNfc.NFCStepActivity.n0(android.nfc.Tag):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.fis.nfc.sdk.nfc.stepNfc.NFCStepActivity, android.content.Context, m.c, androidx.fragment.app.v] */
    public void onCreate(Bundle bundle) {
        Locale locale = new Locale(C0053d.a.i());
        Configuration configuration = getResources().getConfiguration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        NFCStepActivity.super.onCreate(bundle);
        this.c = new C0052c();
        this.e = new a(this);
        registerReceiver(this.e, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
        j0();
        s0();
    }

    public void onNewIntent(Intent intent) {
        n.f(intent, "intent");
        NFCStepActivity.super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        n.c(extras);
        Tag tag = (Tag) extras.getParcelable("android.nfc.extra.TAG");
        C0052c cVar = this.c;
        n.c(cVar);
        cVar.c0();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.g = newSingleThreadExecutor;
        if (newSingleThreadExecutor != null) {
            newSingleThreadExecutor.execute(new C0056g(this, tag));
        }
        ExecutorService executorService = this.g;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.fis.nfc.sdk.nfc.stepNfc.NFCStepActivity, android.content.Context, android.app.Activity, androidx.fragment.app.v] */
    public void onPause() {
        NFCStepActivity.super.onPause();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        if (defaultAdapter != null) {
            defaultAdapter.disableForegroundDispatch(this);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.fis.nfc.sdk.nfc.stepNfc.NFCStepActivity, android.app.Activity, androidx.fragment.app.v] */
    public void onResume() {
        NFCStepActivity.super.onResume();
        if (!this.i) {
            p0();
            return;
        }
        C0052c cVar = this.c;
        if (cVar != null) {
            cVar.b0(false);
        }
        finish();
    }

    public void onStop() {
        NFCStepActivity.super.onStop();
        this.h = false;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.fis.nfc.sdk.nfc.stepNfc.NFCStepActivity, android.content.Context, android.app.Activity] */
    public final void p0() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        if (defaultAdapter != null) {
            Intent intent = new Intent(getApplicationContext(), NFCStepActivity.class);
            intent.setFlags(PKIFailureInfo.duplicateCertReq);
            defaultAdapter.enableForegroundDispatch(this, PendingIntent.getActivity(this, 0, intent, 33554432), (IntentFilter[]) null, new String[][]{new String[]{"android.nfc.tech.IsoDep"}});
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.fis.nfc.sdk.nfc.stepNfc.NFCStepActivity, android.app.Activity] */
    public final void q0(ResultCode resultCode) {
        if (this.h) {
            runOnUiThread(new C0057h(this, resultCode));
        } else {
            this.i = true;
        }
    }

    public final void s0() {
        C0052c cVar = this.c;
        n.c(cVar);
        cVar.show(getSupportFragmentManager(), "BottomSheetDialog");
        C0052c cVar2 = this.c;
        n.c(cVar2);
        cVar2.a0(new b(this));
    }
}
