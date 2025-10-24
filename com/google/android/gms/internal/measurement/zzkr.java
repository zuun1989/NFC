package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkr;
import com.google.android.gms.internal.measurement.zzks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class zzkr<MessageType extends zzks<MessageType, BuilderType>, BuilderType extends zzkr<MessageType, BuilderType>> implements zznl {
    private static void zza(List list, int i) {
        int size = list.size() - i;
        StringBuilder sb2 = new StringBuilder(String.valueOf(size).length() + 26);
        sb2.append("Element at index ");
        sb2.append(size);
        sb2.append(" is null.");
        String sb3 = sb2.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 >= i) {
                list.remove(size2);
            } else {
                throw new NullPointerException(sb3);
            }
        }
    }

    public static void zzaU(Iterable iterable, List list) {
        byte[] bArr = zzmp.zzb;
        iterable.getClass();
        if (iterable instanceof zzmx) {
            List zza = ((zzmx) iterable).zza();
            zzmx zzmx = (zzmx) list;
            int size = list.size();
            for (Object next : zza) {
                if (next == null) {
                    int size2 = zzmx.size() - size;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(size2).length() + 26);
                    sb2.append("Element at index ");
                    sb2.append(size2);
                    sb2.append(" is null.");
                    String sb3 = sb2.toString();
                    int size3 = zzmx.size();
                    while (true) {
                        size3--;
                        if (size3 >= size) {
                            zzmx.remove(size3);
                        } else {
                            throw new NullPointerException(sb3);
                        }
                    }
                } else if (next instanceof zzlh) {
                    zzlh zzlh = (zzlh) next;
                    zzmx.zzb();
                } else if (next instanceof byte[]) {
                    byte[] bArr2 = (byte[]) next;
                    zzlh.zzh(bArr2, 0, bArr2.length);
                    zzmx.zzb();
                } else {
                    zzmx.add((String) next);
                }
            }
        } else if (!(iterable instanceof zznt)) {
            if (iterable instanceof Collection) {
                int size4 = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size4);
                } else if (list instanceof zznv) {
                    ((zznv) list).zze(list.size() + size4);
                }
            }
            int size5 = list.size();
            if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
                for (Object next2 : iterable) {
                    if (next2 == null) {
                        zza(list, size5);
                    }
                    list.add(next2);
                }
                return;
            }
            List list2 = (List) iterable;
            int size6 = list2.size();
            for (int i = 0; i < size6; i++) {
                Object obj = list2.get(i);
                if (obj == null) {
                    zza(list, size5);
                }
                list.add(obj);
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    /* renamed from: zzaR */
    public abstract zzkr clone();

    public zzkr zzaS(byte[] bArr, int i, int i2) throws zzmr {
        throw null;
    }

    public zzkr zzaT(byte[] bArr, int i, int i2, zzlr zzlr) throws zzmr {
        throw null;
    }

    public final /* synthetic */ zznl zzaV(byte[] bArr, zzlr zzlr) throws zzmr {
        return zzaT(bArr, 0, bArr.length, zzlr);
    }

    public final /* synthetic */ zznl zzaW(byte[] bArr) throws zzmr {
        return zzaS(bArr, 0, bArr.length);
    }
}
