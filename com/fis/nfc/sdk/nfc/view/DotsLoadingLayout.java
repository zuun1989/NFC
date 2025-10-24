package com.fis.nfc.sdk.nfc.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.n;
import t4.C0047a;
import t4.C0048b;
import x4.C0064a;

public final class DotsLoadingLayout extends LinearLayout {
    public View a;
    public View b;
    public View c;
    public View d;
    public View e;
    public int f;
    public final CountDownTimer g;
    public Map h = new LinkedHashMap();

    public DotsLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new C0064a(this);
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(C0048b.b, this, true);
        View findViewById = findViewById(C0047a.i);
        n.e(findViewById, "findViewById(R.id.view1)");
        setView1(findViewById);
        View findViewById2 = findViewById(C0047a.j);
        n.e(findViewById2, "findViewById(R.id.view2)");
        setView2(findViewById2);
        View findViewById3 = findViewById(C0047a.k);
        n.e(findViewById3, "findViewById(R.id.view3)");
        setView3(findViewById3);
        View findViewById4 = findViewById(C0047a.l);
        n.e(findViewById4, "findViewById(R.id.view4)");
        setView4(findViewById4);
        View findViewById5 = findViewById(C0047a.m);
        n.e(findViewById5, "findViewById(R.id.view5)");
        setView5(findViewById5);
        getView1().setSelected(true);
    }

    public final void c() {
        int i = this.f;
        if (i == 0) {
            getView1().setSelected(false);
            getView2().setSelected(false);
            getView3().setSelected(false);
            getView4().setSelected(false);
            getView5().setSelected(false);
        } else if (i == 1) {
            getView1().setSelected(true);
        } else if (i == 2) {
            getView2().setSelected(true);
        } else if (i == 3) {
            getView3().setSelected(true);
        } else if (i == 4) {
            getView4().setSelected(true);
        } else if (i == 5) {
            getView5().setSelected(true);
        }
    }

    public final int getPosition() {
        return this.f;
    }

    public final CountDownTimer getTimer() {
        return this.g;
    }

    public final View getView1() {
        View view = this.a;
        if (view != null) {
            return view;
        }
        n.t("view1");
        return null;
    }

    public final View getView2() {
        View view = this.b;
        if (view != null) {
            return view;
        }
        n.t("view2");
        return null;
    }

    public final View getView3() {
        View view = this.c;
        if (view != null) {
            return view;
        }
        n.t("view3");
        return null;
    }

    public final View getView4() {
        View view = this.d;
        if (view != null) {
            return view;
        }
        n.t("view4");
        return null;
    }

    public final View getView5() {
        View view = this.e;
        if (view != null) {
            return view;
        }
        n.t("view5");
        return null;
    }

    public void onVisibilityChanged(View view, int i) {
        n.f(view, "changedView");
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.g.start();
        } else {
            this.g.cancel();
        }
    }

    public final void setPosition(int i) {
        this.f = i;
    }

    public final void setView1(View view) {
        n.f(view, "<set-?>");
        this.a = view;
    }

    public final void setView2(View view) {
        n.f(view, "<set-?>");
        this.b = view;
    }

    public final void setView3(View view) {
        n.f(view, "<set-?>");
        this.c = view;
    }

    public final void setView4(View view) {
        n.f(view, "<set-?>");
        this.d = view;
    }

    public final void setView5(View view) {
        n.f(view, "<set-?>");
        this.e = view;
    }
}
