package com.google.android.gms.internal.measurement;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp.PKIFailureInfo;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzmf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzmf<MessageType extends zzmf<MessageType, BuilderType>, BuilderType extends zzmb<MessageType, BuilderType>> extends zzks<MessageType, BuilderType> {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzoj zzc = zzoj.zza();

    private final int zzc(zznx zznx) {
        return zznu.zza().zzb(getClass()).zze(this);
    }

    public static zzmf zzco(Class cls) {
        Map map = zzd;
        zzmf zzmf = (zzmf) map.get(cls);
        if (zzmf == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzmf = (zzmf) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzmf == null) {
            zzmf = (zzmf) ((zzmf) zzop.zzc(cls)).zzl(6, (Object) null, (Object) null);
            if (zzmf != null) {
                map.put(cls, zzmf);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzmf;
    }

    public static void zzcp(Class cls, zzmf zzmf) {
        zzmf.zzcg();
        zzd.put(cls, zzmf);
    }

    public static Object zzcq(zznm zznm, String str, Object[] objArr) {
        return new zznw(zznm, str, objArr);
    }

    public static Object zzcr(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static zzmm zzcs() {
        return zzmg.zzd();
    }

    public static zzmn zzct() {
        return zzna.zze();
    }

    public static zzmn zzcu(zzmn zzmn) {
        int size = zzmn.size();
        return zzmn.zzg(size + size);
    }

    public static zzmo zzcv() {
        return zznv.zzd();
    }

    public static zzmo zzcw(zzmo zzmo) {
        int size = zzmo.size();
        return zzmo.zzg(size + size);
    }

    /* access modifiers changed from: private */
    public static final boolean zzd(zzmf zzmf, boolean z) {
        zzmf zzmf2;
        byte byteValue = ((Byte) zzmf.zzl(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zznu.zza().zzb(zzmf.getClass()).zzk(zzmf);
        if (z) {
            if (true != zzk) {
                zzmf2 = null;
            } else {
                zzmf2 = zzmf;
            }
            zzmf.zzl(2, zzmf2, (Object) null);
        }
        return zzk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zznu.zza().zzb(getClass()).zzb(this, (zzmf) obj);
    }

    public final int hashCode() {
        if (zzcf()) {
            return zzci();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzci = zzci();
        this.zza = zzci;
        return zzci;
    }

    public final String toString() {
        return zzno.zza(this, super.toString());
    }

    public final void zzcB(zzlm zzlm) throws IOException {
        zznu.zza().zzb(getClass()).zzf(this, zzln.zza(zzlm));
    }

    public final /* synthetic */ zznl zzcC() {
        return (zzmb) zzl(5, (Object) null, (Object) null);
    }

    public final boolean zzcD() {
        return zzd(this, true);
    }

    public final /* synthetic */ zznm zzcE() {
        return (zzmf) zzl(6, (Object) null, (Object) null);
    }

    public final int zzcd(zznx zznx) {
        if (zzcf()) {
            int zze = zznx.zze(this);
            if (zze >= 0) {
                return zze;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(zze).length() + 42);
            sb2.append("serialized size must be non-negative, was ");
            sb2.append(zze);
            throw new IllegalStateException(sb2.toString());
        }
        int i = this.zzb & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zze2 = zznx.zze(this);
        if (zze2 >= 0) {
            this.zzb = (this.zzb & PKIFailureInfo.systemUnavail) | zze2;
            return zze2;
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(zze2).length() + 42);
        sb3.append("serialized size must be non-negative, was ");
        sb3.append(zze2);
        throw new IllegalStateException(sb3.toString());
    }

    public final boolean zzcf() {
        return (this.zzb & PKIFailureInfo.systemUnavail) != 0;
    }

    public final void zzcg() {
        this.zzb &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final zzmf zzch() {
        return (zzmf) zzl(4, (Object) null, (Object) null);
    }

    public final int zzci() {
        return zznu.zza().zzb(getClass()).zzc(this);
    }

    public final void zzcj() {
        zznu.zza().zzb(getClass()).zzj(this);
        zzcg();
    }

    public final zzmb zzck() {
        return (zzmb) zzl(5, (Object) null, (Object) null);
    }

    public final zzmb zzcl() {
        zzmb zzmb = (zzmb) zzl(5, (Object) null, (Object) null);
        zzmb.zzbd(this);
        return zzmb;
    }

    public final void zzcm(int i) {
        this.zzb = (this.zzb & PKIFailureInfo.systemUnavail) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int zzcn() {
        int i;
        if (zzcf()) {
            i = zzc((zznx) null);
            if (i < 0) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 42);
                sb2.append("serialized size must be non-negative, was ");
                sb2.append(i);
                throw new IllegalStateException(sb2.toString());
            }
        } else {
            i = this.zzb & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (i == Integer.MAX_VALUE) {
                i = zzc((zznx) null);
                if (i >= 0) {
                    this.zzb = (this.zzb & PKIFailureInfo.systemUnavail) | i;
                } else {
                    StringBuilder sb3 = new StringBuilder(String.valueOf(i).length() + 42);
                    sb3.append("serialized size must be non-negative, was ");
                    sb3.append(i);
                    throw new IllegalStateException(sb3.toString());
                }
            }
        }
        return i;
    }

    public abstract Object zzl(int i, Object obj, Object obj2);
}
