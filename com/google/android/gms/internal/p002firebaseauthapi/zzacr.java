package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import b6.g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.b;
import j6.A;
import j6.C;
import j6.O;
import j6.P;
import j6.S;
import j6.V;
import j6.W;
import j6.d;
import j6.d0;
import j6.e;
import j6.h;
import j6.i;
import j6.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import k6.N;
import k6.j0;
import k6.k;
import k6.p;
import k6.t0;
import k6.x;
import k6.y;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacr  reason: invalid package */
public final class zzacr extends zzafp {
    public zzacr(g gVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzaep(gVar, scheduledExecutorService);
        this.zzb = executor;
    }

    public final Task<Void> zza(g gVar, String str, String str2) {
        return zza((zzacq) new zzacq(str, str2).zza(gVar));
    }

    public final Task<d> zzb(g gVar, String str, String str2) {
        return zza((zzact) new zzact(str, str2).zza(gVar));
    }

    public final Task<V> zzc(g gVar, String str, String str2) {
        return zza((zzacx) new zzacx(str, str2).zza(gVar));
    }

    public final Task<Void> zzd(g gVar, A a, String str, j0 j0Var) {
        return zza((zzaeh) new zzaeh(str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(g gVar, String str, String str2, String str3) {
        return zza((zzacs) new zzacs(str, str2, str3).zza(gVar));
    }

    public final Task<Void> zzb(g gVar, A a, h hVar, String str, j0 j0Var) {
        return zza((zzadh) new zzadh(hVar, str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<i> zzc(g gVar, A a, h hVar, String str, j0 j0Var) {
        return zza((zzadg) new zzadg(hVar, str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<i> zza(g gVar, String str, String str2, String str3, String str4, t0 t0Var) {
        return zza((zzacv) new zzacv(str, str2, str3, str4).zza(gVar).zza(t0Var));
    }

    public final Task<String> zzd(g gVar, String str, String str2) {
        return zza((zzael) new zzael(str, str2).zza(gVar));
    }

    public final Task<i> zzb(g gVar, A a, j jVar, String str, j0 j0Var) {
        return zza((zzadi) new zzadi(jVar, str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zzc(g gVar, A a, String str, j0 j0Var) {
        return zza((zzaee) new zzaee(str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(A a, y yVar) {
        return zza((zzacu) new zzacu().zza(a).zza(yVar).zza((x) yVar));
    }

    public final Task<Void> zza(g gVar, P p, A a, String str, t0 t0Var) {
        zzagc.zza();
        zzacw zzacw = new zzacw(p, a.zze(), str, (String) null);
        zzacw.zza(gVar).zza(t0Var);
        return zza(zzacw);
    }

    public final Task<i> zzb(g gVar, A a, String str, String str2, String str3, String str4, j0 j0Var) {
        return zza((zzadk) new zzadk(str, str2, str3, str4).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(g gVar, W w, A a, String str, String str2, t0 t0Var) {
        zzacw zzacw = new zzacw(w, a.zze(), str, str2);
        zzacw.zza(gVar).zza(t0Var);
        return zza(zzacw);
    }

    public final Task<i> zzb(g gVar, A a, O o, String str, j0 j0Var) {
        zzagc.zza();
        return zza((zzadm) new zzadm(o, str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<i> zza(g gVar, A a, P p, String str, t0 t0Var) {
        zzagc.zza();
        zzacz zzacz = new zzacz(p, str, (String) null);
        zzacz.zza(gVar).zza(t0Var);
        if (a != null) {
            zzacz.zza(a);
        }
        return zza(zzacz);
    }

    public final Task<Void> zzb(g gVar, String str, e eVar, String str2, String str3) {
        eVar.zza(6);
        return zza((zzadq) new zzadq(str, eVar, str2, str3, "sendSignInLinkToEmail").zza(gVar));
    }

    public final Task<i> zza(g gVar, A a, W w, String str, String str2, t0 t0Var) {
        zzacz zzacz = new zzacz(w, str, str2);
        zzacz.zza(gVar).zza(t0Var);
        if (a != null) {
            zzacz.zza(a);
        }
        return zza(zzacz);
    }

    public final Task<i> zzb(g gVar, String str, String str2, String str3, String str4, t0 t0Var) {
        return zza((zzadx) new zzadx(str, str2, str3, str4).zza(gVar).zza(t0Var));
    }

    public final Task<C> zza(g gVar, A a, String str, j0 j0Var) {
        return zza((zzacy) new zzacy(str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<i> zzb(g gVar, A a, String str, j0 j0Var) {
        Preconditions.checkNotNull(gVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(j0Var);
        List zzg = a.zzg();
        if ((zzg != null && !zzg.contains(str)) || a.Q1()) {
            return Tasks.forException(zzaeo.zza(new Status(17016, str)));
        }
        str.hashCode();
        if (!str.equals("password")) {
            return zza((zzaef) new zzaef(str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
        }
        return zza((zzaec) new zzaec().zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<zzahs> zza() {
        return zza(new zzadb());
    }

    public final Task<zzaht> zza(String str, String str2) {
        return zza(new zzada(str, str2));
    }

    public final Task<i> zza(g gVar, A a, h hVar, String str, j0 j0Var) {
        Preconditions.checkNotNull(gVar);
        Preconditions.checkNotNull(hVar);
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(j0Var);
        List zzg = a.zzg();
        if (zzg != null && zzg.contains(hVar.K1())) {
            return Tasks.forException(zzaeo.zza(new Status(17015)));
        }
        if (hVar instanceof j) {
            j jVar = (j) hVar;
            if (!jVar.zzf()) {
                return zza((zzadd) new zzadd(jVar, str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
            }
            return zza((zzade) new zzade(jVar).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
        } else if (hVar instanceof O) {
            zzagc.zza();
            return zza((zzadf) new zzadf((O) hVar).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
        } else {
            Preconditions.checkNotNull(gVar);
            Preconditions.checkNotNull(hVar);
            Preconditions.checkNotNull(a);
            Preconditions.checkNotNull(j0Var);
            return zza((zzadc) new zzadc(hVar).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
        }
    }

    public final Task<Void> zza(g gVar, A a, j jVar, String str, j0 j0Var) {
        return zza((zzadj) new zzadj(jVar, str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(g gVar, A a, String str, String str2, String str3, String str4, j0 j0Var) {
        return zza((zzadl) new zzadl(str, str2, str3, str4).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(g gVar, A a, O o, String str, j0 j0Var) {
        zzagc.zza();
        return zza((zzadn) new zzadn(o, str).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(g gVar, A a, j0 j0Var) {
        return zza((zzadp) new zzadp().zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(String str, String str2, String str3, String str4) {
        return zza(new zzado(str, str2, str3, str4));
    }

    public final Task<Void> zza(g gVar, e eVar, String str) {
        return zza((zzadr) new zzadr(str, eVar).zza(gVar));
    }

    public final Task<Void> zza(g gVar, String str, e eVar, String str2, String str3) {
        eVar.zza(1);
        return zza((zzadq) new zzadq(str, eVar, str2, str3, "sendPasswordResetEmail").zza(gVar));
    }

    public final Task<Void> zza(String str) {
        return zza(new zzadt(str));
    }

    public final Task<i> zza(g gVar, t0 t0Var, String str) {
        return zza((zzads) new zzads(str).zza(gVar).zza(t0Var));
    }

    public final Task<i> zza(g gVar, h hVar, String str, t0 t0Var) {
        return zza((zzadv) new zzadv(hVar, str).zza(gVar).zza(t0Var));
    }

    public final Task<i> zza(g gVar, String str, String str2, t0 t0Var) {
        return zza((zzadu) new zzadu(str, str2).zza(gVar).zza(t0Var));
    }

    public final Task<i> zza(g gVar, j jVar, String str, t0 t0Var) {
        return zza((zzadw) new zzadw(jVar, str).zza(gVar).zza(t0Var));
    }

    public final Task<i> zza(g gVar, O o, String str, t0 t0Var) {
        zzagc.zza();
        return zza((zzadz) new zzadz(o, str).zza(gVar).zza(t0Var));
    }

    public final Task<Void> zza(p pVar, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, boolean z3, b.b bVar, Executor executor, Activity activity) {
        zzady zzady = new zzady(pVar, str, str2, j, z, z2, str3, str4, str5, z3);
        String str6 = str;
        zzady.zza(bVar, activity, executor, str);
        return zza(zzady);
    }

    public final Task<zzais> zza(p pVar, String str) {
        return zza(new zzaeb(pVar, str));
    }

    public final Task<Void> zza(p pVar, S s, String str, long j, boolean z, boolean z2, String str2, String str3, String str4, boolean z3, b.b bVar, Executor executor, Activity activity) {
        zzaea zzaea = new zzaea(s, Preconditions.checkNotEmpty(pVar.zzc()), str, j, z, z2, str2, str3, str4, z3);
        Activity activity2 = activity;
        zzaea.zza(bVar, activity2, executor, s.d());
        return zza(zzaea);
    }

    public final Task<Void> zza(g gVar, A a, String str, String str2, j0 j0Var) {
        return zza((zzaed) new zzaed(a.zze(), str, str2).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(g gVar, A a, O o, j0 j0Var) {
        zzagc.zza();
        return zza((zzaeg) new zzaeg(o).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(g gVar, A a, d0 d0Var, j0 j0Var) {
        return zza((zzaej) new zzaej(d0Var).zza(gVar).zza(a).zza(j0Var).zza((x) j0Var));
    }

    public final Task<Void> zza(String str, String str2, e eVar) {
        eVar.zza(7);
        return zza(new zzaei(str, str2, eVar));
    }

    public static k6.i zza(g gVar, zzahl zzahl) {
        Preconditions.checkNotNull(gVar);
        Preconditions.checkNotNull(zzahl);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new k6.e(zzahl, "firebase"));
        List<zzaic> zzl = zzahl.zzl();
        if (zzl != null && !zzl.isEmpty()) {
            for (int i = 0; i < zzl.size(); i++) {
                arrayList.add(new k6.e(zzl.get(i)));
            }
        }
        k6.i iVar = new k6.i(gVar, arrayList);
        iVar.p2(new k(zzahl.zzb(), zzahl.zza()));
        iVar.q2(zzahl.zzn());
        iVar.o2(zzahl.zze());
        iVar.l2(N.b(zzahl.zzk()));
        iVar.j2(zzahl.zzd());
        return iVar;
    }

    public final void zza(g gVar, zzaik zzaik, b.b bVar, Activity activity, Executor executor) {
        zza((zzaek) new zzaek(zzaik).zza(gVar).zza(bVar, activity, executor, zzaik.zzd()));
    }
}
