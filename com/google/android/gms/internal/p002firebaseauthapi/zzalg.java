package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp.PKIFailureInfo;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p002firebaseauthapi.zzalg;
import com.google.android.gms.internal.p002firebaseauthapi.zzalg.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalg  reason: invalid package */
public abstract class zzalg<MessageType extends zzalg<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzajn<MessageType, BuilderType> {
    private static Map<Class<?>, zzalg<?, ?>> zzc = new ConcurrentHashMap();
    protected zzany zzb = zzany.zzc();
    private int zzd = -1;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalg$zza */
    public static class zza<T extends zzalg<T, ?>> extends zzajr<T> {
        public zza(T t) {
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalg$zzc */
    public static final class zzc implements zzala<zzc> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzaoh zzb() {
            throw new NoSuchMethodError();
        }

        public final zzaok zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        public final zzamm zza(zzamm zzamm, zzamn zzamn) {
            throw new NoSuchMethodError();
        }

        public final zzams zza(zzams zzams, zzams zzams2) {
            throw new NoSuchMethodError();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalg$zzd */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzalg<MessageType, BuilderType> implements zzamp {
        protected zzaky<zzc> zzc = zzaky.zzb();

        public final zzaky<zzc> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzaky) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* 'enum' modifier removed */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalg$zze */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalg$zzf */
    public static class zzf<ContainingType extends zzamn, Type> extends zzaks<ContainingType, Type> {
    }

    private final int zzb(zzanc<?> zzanc) {
        if (zzanc == null) {
            return zzamy.zza().zza(this).zza(this);
        }
        return zzanc.zza(this);
    }

    public static <E> zzaln<E> zzp() {
        return zzanb.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzamy.zza().zza(this).zzb(this, (zzalg) obj);
        }
        return false;
    }

    public int hashCode() {
        if (zzw()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    public String toString() {
        return zzamo.zza((zzamn) this, super.toString());
    }

    public abstract Object zza(int i, Object obj, Object obj2);

    public final int zzi() {
        return this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int zzl() {
        return zza((zzanc) null);
    }

    public final <MessageType2 extends zzalg<MessageType2, BuilderType2>, BuilderType2 extends zzb<MessageType2, BuilderType2>> BuilderType2 zzm() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzn() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    public final MessageType zzo() {
        return (zzalg) zza(zze.zzd, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzamm zzq() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzamm zzr() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    public final /* synthetic */ zzamn zzs() {
        return (zzalg) zza(zze.zzf, (Object) null, (Object) null);
    }

    public final void zzt() {
        zzamy.zza().zza(this).zzd(this);
        zzu();
    }

    public final void zzu() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final boolean zzv() {
        return zzb(this, true);
    }

    public final boolean zzw() {
        if ((this.zzd & PKIFailureInfo.systemUnavail) != 0) {
            return true;
        }
        return false;
    }

    private final int zza() {
        return zzamy.zza().zza(this).zzb(this);
    }

    private static <T extends zzalg<T, ?>> T zzb(T t, zzajw zzajw, zzakv zzakv) throws zzalm {
        zzaki zzc2 = zzajw.zzc();
        T zza2 = zza(t, zzc2, zzakv);
        zzc2.zzc(0);
        return zza2;
    }

    public final int zza(zzanc zzanc) {
        if (zzw()) {
            int zzb2 = zzb((zzanc<?>) zzanc);
            if (zzb2 >= 0) {
                return zzb2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzb2);
        } else if (zzi() != Integer.MAX_VALUE) {
            return zzi();
        } else {
            int zzb3 = zzb((zzanc<?>) zzanc);
            zzb(zzb3);
            return zzb3;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalg$zzb */
    public static abstract class zzb<MessageType extends zzalg<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzajp<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        public zzb(MessageType messagetype) {
            this.zzb = messagetype;
            if (!messagetype.zzw()) {
                this.zza = messagetype.zzo();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) this.zzb.zza(zze.zze, (Object) null, (Object) null);
            zzb2.zza = (zzalg) zzf();
            return zzb2;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzw()) {
                zzh();
            }
            zza(this.zza, messagetype);
            return this;
        }

        public final /* synthetic */ zzajp zzb() {
            return (zzb) clone();
        }

        /* renamed from: zzc */
        public final MessageType zze() {
            MessageType messagetype = (zzalg) zzf();
            if (messagetype.zzv()) {
                return messagetype;
            }
            throw new zzanw(messagetype);
        }

        /* renamed from: zzd */
        public MessageType zzf() {
            if (!this.zza.zzw()) {
                return this.zza;
            }
            this.zza.zzt();
            return this.zza;
        }

        public final void zzg() {
            if (!this.zza.zzw()) {
                zzh();
            }
        }

        public void zzh() {
            MessageType zzo = this.zzb.zzo();
            zza(zzo, this.zza);
            this.zza = zzo;
        }

        public final /* synthetic */ zzamn zzs() {
            return this.zzb;
        }

        public final boolean zzv() {
            return zzalg.zzb(this.zza, false);
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzamy.zza().zza(messagetype).zza(messagetype, messagetype2);
        }
    }

    public final void zzb(int i) {
        if (i >= 0) {
            this.zzd = (i & Api.BaseClientBuilder.API_PRIORITY_OTHER) | (this.zzd & PKIFailureInfo.systemUnavail);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i);
    }

    /* access modifiers changed from: private */
    public static final <T extends zzalg<T, ?>> boolean zzb(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zze2 = zzamy.zza().zza(t).zze(t);
        if (z) {
            t.zza(zze.zzb, (Object) zze2 ? t : null, (Object) null);
        }
        return zze2;
    }

    private static <T extends zzalg<T, ?>> T zza(T t) throws zzalm {
        if (t == null || zzb(t, true)) {
            return t;
        }
        zzalm zza2 = new zzanw(t).zza();
        zza2.getClass();
        throw zza2;
    }

    public static <T extends zzalg<?, ?>> T zza(Class<T> cls) {
        T t = (zzalg) zzc.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzalg) zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzalg) ((zzalg) zzaoa.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzc.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static <T extends zzalg<T, ?>> T zza(T t, zzajw zzajw, zzakv zzakv) throws zzalm {
        return zza(zzb(t, zzajw, zzakv));
    }

    public static <T extends zzalg<T, ?>> T zza(T t, InputStream inputStream, zzakv zzakv) throws zzalm {
        zzaki zzaki;
        if (inputStream == null) {
            byte[] bArr = zzali.zzb;
            zzaki = zzaki.zza(bArr, 0, bArr.length, false);
        } else {
            zzaki = new zzakk(inputStream);
        }
        return zza(zza(t, zzaki, zzakv));
    }

    public static <T extends zzalg<T, ?>> T zza(T t, byte[] bArr, zzakv zzakv) throws zzalm {
        return zza(zza(t, bArr, 0, bArr.length, zzakv));
    }

    private static <T extends zzalg<T, ?>> T zza(T t, zzaki zzaki, zzakv zzakv) throws zzalm {
        T zzo = t.zzo();
        try {
            zzanc zza2 = zzamy.zza().zza(zzo);
            zza2.zza(zzo, zzakm.zza(zzaki), zzakv);
            zza2.zzd(zzo);
            return zzo;
        } catch (zzalm e) {
            e = e;
            if (e.zzl()) {
                e = new zzalm((IOException) e);
            }
            throw e;
        } catch (zzanw e2) {
            zzalm zza3 = e2.zza();
            zza3.getClass();
            throw zza3;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzalm) {
                throw ((zzalm) e3.getCause());
            }
            throw new zzalm(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzalm) {
                throw ((zzalm) e4.getCause());
            }
            throw e4;
        }
    }

    private static <T extends zzalg<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzakv zzakv) throws zzalm {
        if (i2 == 0) {
            return t;
        }
        T zzo = t.zzo();
        try {
            zzanc zza2 = zzamy.zza().zza(zzo);
            zza2.zza(zzo, bArr, 0, i2, new zzajv(zzakv));
            zza2.zzd(zzo);
            return zzo;
        } catch (zzalm e) {
            e = e;
            if (e.zzl()) {
                e = new zzalm((IOException) e);
            }
            throw e;
        } catch (zzanw e2) {
            zzalm zza3 = e2.zza();
            zza3.getClass();
            throw zza3;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzalm) {
                throw ((zzalm) e3.getCause());
            }
            throw new zzalm(e3);
        } catch (IndexOutOfBoundsException unused) {
            zzalm zzj = zzalm.zzj();
            zzj.getClass();
            throw zzj;
        }
    }

    public static <E> zzaln<E> zza(zzaln<E> zzaln) {
        return zzaln.zza(zzaln.size() << 1);
    }

    public static Object zza(Method method, Object obj, Object... objArr) {
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

    public static Object zza(zzamn zzamn, String str, Object[] objArr) {
        return new zzana(zzamn, str, objArr);
    }

    public static <T extends zzalg<?, ?>> void zza(Class<T> cls, T t) {
        t.zzu();
        zzc.put(cls, t);
    }

    public final void zza(zzako zzako) throws IOException {
        zzamy.zza().zza(this).zza(this, (zzaom) zzakq.zza(zzako));
    }
}
