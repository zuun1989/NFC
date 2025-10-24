package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzala;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaky  reason: invalid package */
final class zzaky<T extends zzala<T>> {
    private static final zzaky<?> zzb = new zzaky<>(true);
    final zzanh<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    private zzaky() {
        this.zza = new zzang();
    }

    public static int zza(zzaoh zzaoh, int i, Object obj) {
        int zzg = zzako.zzg(i);
        if (zzaoh == zzaoh.GROUP) {
            zzali.zza((zzamn) obj);
            zzg <<= 1;
        }
        return zzg + zza(zzaoh, obj);
    }

    public static <T extends zzala<T>> zzaky<T> zzb() {
        return zzb;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzaky zzaky = new zzaky();
        int zzb2 = this.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            Map.Entry<T, Object> zza2 = this.zza.zza(i);
            zzaky.zzb((zzala) zza2.getKey(), zza2.getValue());
        }
        for (Map.Entry next : this.zza.zzc()) {
            zzaky.zzb((zzala) next.getKey(), next.getValue());
        }
        zzaky.zzd = this.zzd;
        return zzaky;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaky)) {
            return false;
        }
        return this.zza.equals(((zzaky) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzalt(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzalt(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zze() {
        if (!this.zzc) {
            int zzb2 = this.zza.zzb();
            for (int i = 0; i < zzb2; i++) {
                Object value = this.zza.zza(i).getValue();
                if (value instanceof zzalg) {
                    ((zzalg) value).zzt();
                }
            }
            for (Map.Entry<T, Object> value2 : this.zza.zzc()) {
                Object value3 = value2.getValue();
                if (value3 instanceof zzalg) {
                    ((zzalg) value3).zzt();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        int zzb2 = this.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            if (!zzc(this.zza.zza(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzc()) {
            if (!zzc(zzc2)) {
                return false;
            }
        }
        return true;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzala zzala = (zzala) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzalr;
        if (zzala.zze()) {
            if (!z) {
                Object zza2 = zza(zzala);
                List list = (List) value;
                int size = list.size();
                if (zza2 == null) {
                    zza2 = new ArrayList(size);
                }
                List list2 = (List) zza2;
                for (int i = 0; i < size; i++) {
                    list2.add(zza(list.get(i)));
                }
                this.zza.put(zzala, zza2);
                return;
            }
            throw new IllegalStateException("Lazy fields can not be repeated");
        } else if (zzala.zzc() == zzaok.MESSAGE) {
            Object zza3 = zza(zzala);
            if (zza3 == null) {
                this.zza.put(zzala, zza(value));
                if (z) {
                    this.zzd = true;
                }
            } else if (!z) {
                if (zza3 instanceof zzams) {
                    obj = zzala.zza((zzams) zza3, (zzams) value);
                } else {
                    obj = zzala.zza(((zzamn) zza3).zzr(), (zzamn) value).zze();
                }
                this.zza.put(zzala, obj);
            } else {
                throw new NoSuchMethodError();
            }
        } else if (!z) {
            this.zza.put(zzala, zza(value));
        } else {
            throw new IllegalStateException("Lazy fields must be message-valued");
        }
    }

    private zzaky(zzanh<T, Object> zzanh) {
        this.zza = zzanh;
        zze();
    }

    private static int zza(zzaoh zzaoh, Object obj) {
        switch (zzalb.zzb[zzaoh.ordinal()]) {
            case 1:
                return zzako.zza(((Double) obj).doubleValue());
            case 2:
                return zzako.zza(((Float) obj).floatValue());
            case 3:
                return zzako.zzb(((Long) obj).longValue());
            case 4:
                return zzako.zze(((Long) obj).longValue());
            case 5:
                return zzako.zzc(((Integer) obj).intValue());
            case 6:
                return zzako.zza(((Long) obj).longValue());
            case 7:
                return zzako.zzb(((Integer) obj).intValue());
            case 8:
                return zzako.zza(((Boolean) obj).booleanValue());
            case 9:
                return ((zzamn) obj).zzl();
            case 10:
                if (obj instanceof zzalr) {
                    return zzako.zza((zzalv) (zzalr) obj);
                }
                return zzako.zza((zzamn) obj);
            case 11:
                if (obj instanceof zzajw) {
                    return zzako.zza((zzajw) obj);
                }
                return zzako.zza((String) obj);
            case 12:
                if (obj instanceof zzajw) {
                    return zzako.zza((zzajw) obj);
                }
                return zzako.zza((byte[]) obj);
            case 13:
                return zzako.zzh(((Integer) obj).intValue());
            case 14:
                return zzako.zze(((Integer) obj).intValue());
            case 15:
                return zzako.zzc(((Long) obj).longValue());
            case 16:
                return zzako.zzf(((Integer) obj).intValue());
            case 17:
                return zzako.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzall) {
                    return zzako.zza(((zzall) obj).zza());
                }
                return zzako.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        if ((r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzall) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if ((r4 instanceof byte[]) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if ((r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzalr) == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzc(T r3, java.lang.Object r4) {
        /*
            com.google.android.gms.internal.firebase-auth-api.zzaoh r0 = r3.zzb()
            com.google.android.gms.internal.p002firebaseauthapi.zzali.zza(r4)
            int[] r1 = com.google.android.gms.internal.p002firebaseauthapi.zzalb.zza
            com.google.android.gms.internal.firebase-auth-api.zzaok r0 = r0.zzb()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L_0x0044;
                case 2: goto L_0x0041;
                case 3: goto L_0x003e;
                case 4: goto L_0x003b;
                case 5: goto L_0x0038;
                case 6: goto L_0x0035;
                case 7: goto L_0x002c;
                case 8: goto L_0x0023;
                case 9: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r1 = r2
            goto L_0x0046
        L_0x001a:
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzamn
            if (r0 != 0) goto L_0x0046
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzalr
            if (r0 == 0) goto L_0x0018
            goto L_0x0046
        L_0x0023:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x0046
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzall
            if (r0 == 0) goto L_0x0018
            goto L_0x0046
        L_0x002c:
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajw
            if (r0 != 0) goto L_0x0046
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L_0x0018
            goto L_0x0046
        L_0x0035:
            boolean r1 = r4 instanceof java.lang.String
            goto L_0x0046
        L_0x0038:
            boolean r1 = r4 instanceof java.lang.Boolean
            goto L_0x0046
        L_0x003b:
            boolean r1 = r4 instanceof java.lang.Double
            goto L_0x0046
        L_0x003e:
            boolean r1 = r4 instanceof java.lang.Float
            goto L_0x0046
        L_0x0041:
            boolean r1 = r4 instanceof java.lang.Long
            goto L_0x0046
        L_0x0044:
            boolean r1 = r4 instanceof java.lang.Integer
        L_0x0046:
            if (r1 == 0) goto L_0x0049
            return
        L_0x0049:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r3.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.firebase-auth-api.zzaoh r3 = r3.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzaok r3 = r3.zzb()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r1, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaky.zzc(com.google.android.gms.internal.firebase-auth-api.zzala, java.lang.Object):void");
    }

    private zzaky(boolean z) {
        this(new zzang());
        zze();
    }

    private static <T extends zzala<T>> boolean zzc(Map.Entry<T, Object> entry) {
        zzala zzala = (zzala) entry.getKey();
        if (zzala.zzc() != zzaok.MESSAGE) {
            return true;
        }
        if (!zzala.zze()) {
            return zzb(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzb(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private final void zzb(T t, Object obj) {
        if (!t.zze()) {
            zzc(t, obj);
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzc(t, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzalr) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    public static int zza(zzala<?> zzala, Object obj) {
        zzaoh zzb2 = zzala.zzb();
        int zza2 = zzala.zza();
        if (!zzala.zze()) {
            return zza(zzb2, zza2, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzala.zzd()) {
            int i2 = 0;
            while (i < size) {
                i2 += zza(zzb2, zza2, list.get(i));
                i++;
            }
            return i2;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            int i3 = 0;
            while (i < size) {
                i3 += zza(zzb2, list.get(i));
                i++;
            }
            return zzako.zzg(zza2) + i3 + zzako.zzh(i3);
        }
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzamp) {
            return ((zzamp) obj).zzv();
        }
        if (obj instanceof zzalr) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public final int zza() {
        int zzb2 = this.zza.zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2; i2++) {
            i += zza(this.zza.zza(i2));
        }
        for (Map.Entry<T, Object> zza2 : this.zza.zzc()) {
            i += zza(zza2);
        }
        return i;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        zzala zzala = (zzala) entry.getKey();
        Object value = entry.getValue();
        if (zzala.zzc() != zzaok.MESSAGE || zzala.zze() || zzala.zzd()) {
            return zza((zzala<?>) zzala, value);
        }
        if (value instanceof zzalr) {
            return zzako.zza(((zzala) entry.getKey()).zza(), (zzalv) (zzalr) value);
        }
        return zzako.zza(((zzala) entry.getKey()).zza(), (zzamn) value);
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzams) {
            return ((zzams) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzalr)) {
            return obj;
        }
        throw new NoSuchMethodError();
    }

    public final void zza(zzaky<T> zzaky) {
        int zzb2 = zzaky.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            zzb(zzaky.zza.zza(i));
        }
        for (Map.Entry<T, Object> zzb3 : zzaky.zza.zzc()) {
            zzb(zzb3);
        }
    }

    public static void zza(zzako zzako, zzaoh zzaoh, int i, Object obj) throws IOException {
        if (zzaoh == zzaoh.GROUP) {
            zzamn zzamn = (zzamn) obj;
            zzali.zza(zzamn);
            zzako.zzj(i, 3);
            zzamn.zza(zzako);
            zzako.zzj(i, 4);
            return;
        }
        zzako.zzj(i, zzaoh.zza());
        switch (zzalb.zzb[zzaoh.ordinal()]) {
            case 1:
                zzako.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzako.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzako.zzh(((Long) obj).longValue());
                return;
            case 4:
                zzako.zzh(((Long) obj).longValue());
                return;
            case 5:
                zzako.zzj(((Integer) obj).intValue());
                return;
            case 6:
                zzako.zzf(((Long) obj).longValue());
                return;
            case 7:
                zzako.zzi(((Integer) obj).intValue());
                return;
            case 8:
                zzako.zzb(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzamn) obj).zza(zzako);
                return;
            case 10:
                zzako.zzb((zzamn) obj);
                return;
            case 11:
                if (obj instanceof zzajw) {
                    zzako.zzb((zzajw) obj);
                    return;
                } else {
                    zzako.zzb((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzajw) {
                    zzako.zzb((zzajw) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzako.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzako.zzl(((Integer) obj).intValue());
                return;
            case 14:
                zzako.zzi(((Integer) obj).intValue());
                return;
            case 15:
                zzako.zzf(((Long) obj).longValue());
                return;
            case 16:
                zzako.zzk(((Integer) obj).intValue());
                return;
            case 17:
                zzako.zzg(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzall) {
                    zzako.zzj(((zzall) obj).zza());
                    return;
                } else {
                    zzako.zzj(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }
}
