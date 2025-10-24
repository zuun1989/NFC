package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp.PKIFailureInfo;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzeh<MessageType extends zzeh<MessageType, BuilderType>, BuilderType extends zzeb<MessageType, BuilderType>> extends zzcq<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzgt zzc = zzgt.zzc();
    private int zzd = -1;

    public static zzef zzI(zzfm zzfm, Object obj, zzfm zzfm2, zzek zzek, int i, zzhf zzhf, Class cls) {
        return new zzef(zzfm, obj, zzfm2, new zzee((zzek) null, i, zzhf, false, false), cls);
    }

    public static zzeh zzJ(Class cls) {
        Map map = zzb;
        zzeh zzeh = (zzeh) map.get(cls);
        if (zzeh == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzeh = (zzeh) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzeh == null) {
            zzeh = (zzeh) ((zzeh) zzgz.zze(cls)).zzg(6, (Object) null, (Object) null);
            if (zzeh != null) {
                map.put(cls, zzeh);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzeh;
    }

    public static zzeh zzL(zzeh zzeh, byte[] bArr, zzds zzds) throws zzer {
        zzeh zze = zze(zzeh, bArr, 0, bArr.length, zzds);
        if (zze == null || zzX(zze, true)) {
            return zze;
        }
        throw new zzgr(zze).zza();
    }

    public static zzem zzM() {
        return zzdz.zzf();
    }

    public static zzem zzN(zzem zzem) {
        int i;
        int size = zzem.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        return zzem.zzg(i);
    }

    public static zzen zzO() {
        return zzei.zzf();
    }

    public static zzeo zzP() {
        return zzfv.zze();
    }

    public static zzeo zzQ(zzeo zzeo) {
        int i;
        int size = zzeo.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        return zzeo.zzd(i);
    }

    public static Object zzR(Method method, Object obj, Object... objArr) {
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

    public static Object zzS(zzfm zzfm, String str, Object[] objArr) {
        return new zzfw(zzfm, str, objArr);
    }

    public static void zzV(Class cls, zzeh zzeh) {
        zzeh.zzU();
        zzb.put(cls, zzeh);
    }

    public static final boolean zzX(zzeh zzeh, boolean z) {
        zzeh zzeh2;
        byte byteValue = ((Byte) zzeh.zzg(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzfu.zza().zzb(zzeh.getClass()).zzk(zzeh);
        if (z) {
            if (true != zzk) {
                zzeh2 = null;
            } else {
                zzeh2 = zzeh;
            }
            zzeh.zzg(2, zzeh2, (Object) null);
        }
        return zzk;
    }

    private final int zzc(zzge zzge) {
        return zzfu.zza().zzb(getClass()).zza(this);
    }

    private static zzeh zze(zzeh zzeh, byte[] bArr, int i, int i2, zzds zzds) throws zzer {
        if (i2 == 0) {
            return zzeh;
        }
        zzeh zzK = zzeh.zzK();
        try {
            zzge zzb2 = zzfu.zza().zzb(zzK.getClass());
            zzb2.zzh(zzK, bArr, 0, i2, new zzcu(zzds));
            zzb2.zzf(zzK);
            return zzK;
        } catch (zzer e) {
            throw e;
        } catch (zzgr e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzer) {
                throw ((zzer) e3.getCause());
            }
            throw new zzer(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzfu.zza().zzb(getClass()).zzj(this, (zzeh) obj);
    }

    public final int hashCode() {
        if (zzY()) {
            return zzE();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzE = zzE();
        this.zza = zzE;
        return zzE;
    }

    public final String toString() {
        return zzfo.zza(this, super.toString());
    }

    public final int zzB(zzge zzge) {
        if (zzY()) {
            int zza = zzge.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zzge.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & PKIFailureInfo.systemUnavail) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    public final int zzE() {
        return zzfu.zza().zzb(getClass()).zzb(this);
    }

    public final int zzF() {
        int i;
        if (zzY()) {
            i = zzc((zzge) null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (i == Integer.MAX_VALUE) {
                i = zzc((zzge) null);
                if (i >= 0) {
                    this.zzd = (this.zzd & PKIFailureInfo.systemUnavail) | i;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
            }
        }
        return i;
    }

    public final zzeb zzG() {
        return (zzeb) zzg(5, (Object) null, (Object) null);
    }

    public final zzeb zzH() {
        zzeb zzeb = (zzeb) zzg(5, (Object) null, (Object) null);
        zzeb.zzg(this);
        return zzeb;
    }

    public final zzeh zzK() {
        return (zzeh) zzg(4, (Object) null, (Object) null);
    }

    public final void zzT() {
        zzfu.zza().zzb(getClass()).zzf(this);
        zzU();
    }

    public final void zzU() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void zzW(int i) {
        this.zzd = (this.zzd & PKIFailureInfo.systemUnavail) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final boolean zzY() {
        return (this.zzd & PKIFailureInfo.systemUnavail) != 0;
    }

    public final /* synthetic */ zzfl zzZ() {
        return (zzeb) zzg(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzfl zzaa() {
        zzeb zzeb = (zzeb) zzg(5, (Object) null, (Object) null);
        zzeb.zzg(this);
        return zzeb;
    }

    public final void zzab(zzdn zzdn) throws IOException {
        zzfu.zza().zzb(getClass()).zzi(this, zzdo.zza(zzdn));
    }

    public final /* synthetic */ zzfm zzac() {
        return (zzeh) zzg(6, (Object) null, (Object) null);
    }

    public final boolean zzad() {
        return zzX(this, true);
    }

    public abstract Object zzg(int i, Object obj, Object obj2);
}
