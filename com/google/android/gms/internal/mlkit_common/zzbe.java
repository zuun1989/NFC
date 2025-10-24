package com.google.android.gms.internal.mlkit_common;

import G6.c;
import G6.d;
import G6.e;
import G6.f;
import G6.g;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateBody;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

final class zzbe implements f {
    private static final Charset zza = Charset.forName("UTF-8");
    private static final d zzb;
    private static final d zzc;
    private static final e zzd = new zzbd();
    private OutputStream zze;
    private final Map zzf;
    private final Map zzg;
    private final e zzh;
    private final zzbi zzi = new zzbi(this);

    static {
        d.b a = d.a("key");
        zzay zzay = new zzay();
        zzay.zza(1);
        zzb = a.b(zzay.zzb()).a();
        d.b a2 = d.a("value");
        zzay zzay2 = new zzay();
        zzay2.zza(2);
        zzc = a2.b(zzay2.zzb()).a();
    }

    public zzbe(OutputStream outputStream, Map map, Map map2, e eVar) {
        this.zze = outputStream;
        this.zzf = map;
        this.zzg = map2;
        this.zzh = eVar;
    }

    public static /* synthetic */ void zzg(Map.Entry entry, f fVar) throws IOException {
        fVar.add(zzb, entry.getKey());
        fVar.add(zzc, entry.getValue());
    }

    private static int zzh(d dVar) {
        zzbc zzbc = (zzbc) dVar.c(zzbc.class);
        if (zzbc != null) {
            return zzbc.zza();
        }
        throw new c("Field has no @Protobuf config");
    }

    private final long zzi(e eVar, Object obj) throws IOException {
        OutputStream outputStream;
        zzaz zzaz = new zzaz();
        try {
            outputStream = this.zze;
            this.zze = zzaz;
            eVar.encode(obj, this);
            this.zze = outputStream;
            long zza2 = zzaz.zza();
            zzaz.close();
            return zza2;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static zzbc zzj(d dVar) {
        zzbc zzbc = (zzbc) dVar.c(zzbc.class);
        if (zzbc != null) {
            return zzbc;
        }
        throw new c("Field has no @Protobuf config");
    }

    private final zzbe zzk(e eVar, d dVar, Object obj, boolean z) throws IOException {
        long zzi2 = zzi(eVar, obj);
        if (z && zzi2 == 0) {
            return this;
        }
        zzn((zzh(dVar) << 3) | 2);
        zzo(zzi2);
        eVar.encode(obj, this);
        return this;
    }

    private final zzbe zzl(g gVar, d dVar, Object obj, boolean z) throws IOException {
        this.zzi.zza(dVar, z);
        gVar.encode(obj, this.zzi);
        return this;
    }

    private static ByteBuffer zzm(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void zzn(int i) throws IOException {
        while (true) {
            int i2 = (((long) (i & -128)) > 0 ? 1 : (((long) (i & -128)) == 0 ? 0 : -1));
            int i3 = i & CertificateBody.profileType;
            if (i2 != 0) {
                this.zze.write(i3 | 128);
                i >>>= 7;
            } else {
                this.zze.write(i3);
                return;
            }
        }
    }

    private final void zzo(long j) throws IOException {
        while (true) {
            int i = ((-128 & j) > 0 ? 1 : ((-128 & j) == 0 ? 0 : -1));
            int i2 = ((int) j) & CertificateBody.profileType;
            if (i != 0) {
                this.zze.write(i2 | 128);
                j >>>= 7;
            } else {
                this.zze.write(i2);
                return;
            }
        }
    }

    public final f add(d dVar, double d) throws IOException {
        zza(dVar, d, true);
        return this;
    }

    public final f inline(Object obj) throws IOException {
        zzf(obj);
        return this;
    }

    public final f nested(d dVar) throws IOException {
        throw new c("nested() is not implemented for protobuf encoding.");
    }

    public final f zza(d dVar, double d, boolean z) throws IOException {
        if (z && d == 0.0d) {
            return this;
        }
        zzn((zzh(dVar) << 3) | 1);
        this.zze.write(zzm(8).putDouble(d).array());
        return this;
    }

    public final f zzb(d dVar, float f, boolean z) throws IOException {
        if (z && f == 0.0f) {
            return this;
        }
        zzn((zzh(dVar) << 3) | 5);
        this.zze.write(zzm(4).putFloat(f).array());
        return this;
    }

    public final f zzc(d dVar, Object obj, boolean z) throws IOException {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z || charSequence.length() != 0) {
                    zzn((zzh(dVar) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(zza);
                    zzn(bytes.length);
                    this.zze.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                for (Object zzc2 : (Collection) obj) {
                    zzc(dVar, zzc2, false);
                }
            } else if (obj instanceof Map) {
                for (Map.Entry zzk : ((Map) obj).entrySet()) {
                    zzk(zzd, dVar, zzk, false);
                }
            } else if (obj instanceof Double) {
                zza(dVar, ((Double) obj).doubleValue(), z);
                return this;
            } else if (obj instanceof Float) {
                zzb(dVar, ((Float) obj).floatValue(), z);
                return this;
            } else if (obj instanceof Number) {
                zze(dVar, ((Number) obj).longValue(), z);
                return this;
            } else if (obj instanceof Boolean) {
                zzd(dVar, ((Boolean) obj).booleanValue() ? 1 : 0, z);
                return this;
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (!z || bArr.length != 0) {
                    zzn((zzh(dVar) << 3) | 2);
                    zzn(bArr.length);
                    this.zze.write(bArr);
                    return this;
                }
            } else {
                e eVar = (e) this.zzf.get(obj.getClass());
                if (eVar != null) {
                    zzk(eVar, dVar, obj, z);
                    return this;
                }
                g gVar = (g) this.zzg.get(obj.getClass());
                if (gVar != null) {
                    zzl(gVar, dVar, obj, z);
                    return this;
                } else if (obj instanceof zzba) {
                    zzd(dVar, ((zzba) obj).zza(), true);
                    return this;
                } else if (obj instanceof Enum) {
                    zzd(dVar, ((Enum) obj).ordinal(), true);
                    return this;
                } else {
                    zzk(this.zzh, dVar, obj, z);
                    return this;
                }
            }
        }
        return this;
    }

    public final zzbe zzd(d dVar, int i, boolean z) throws IOException {
        if (!z || i != 0) {
            zzbc zzj = zzj(dVar);
            int ordinal = zzj.zzb().ordinal();
            if (ordinal == 0) {
                zzn(zzj.zza() << 3);
                zzn(i);
            } else if (ordinal == 1) {
                zzn(zzj.zza() << 3);
                zzn((i + i) ^ (i >> 31));
            } else if (ordinal == 2) {
                zzn((zzj.zza() << 3) | 5);
                this.zze.write(zzm(4).putInt(i).array());
            }
        }
        return this;
    }

    public final zzbe zze(d dVar, long j, boolean z) throws IOException {
        if (!z || j != 0) {
            zzbc zzj = zzj(dVar);
            int ordinal = zzj.zzb().ordinal();
            if (ordinal == 0) {
                zzn(zzj.zza() << 3);
                zzo(j);
            } else if (ordinal == 1) {
                zzn(zzj.zza() << 3);
                zzo((j >> 63) ^ (j + j));
            } else if (ordinal == 2) {
                zzn((zzj.zza() << 3) | 1);
                this.zze.write(zzm(8).putLong(j).array());
            }
        }
        return this;
    }

    public final zzbe zzf(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        e eVar = (e) this.zzf.get(obj.getClass());
        if (eVar != null) {
            eVar.encode(obj, this);
            return this;
        }
        throw new c("No encoder for ".concat(String.valueOf(obj.getClass())));
    }

    public final f add(d dVar, float f) throws IOException {
        zzb(dVar, f, true);
        return this;
    }

    public final f nested(String str) throws IOException {
        return nested(d.d(str));
    }

    public final /* synthetic */ f add(d dVar, int i) throws IOException {
        zzd(dVar, i, true);
        return this;
    }

    public final /* synthetic */ f add(d dVar, long j) throws IOException {
        zze(dVar, j, true);
        return this;
    }

    public final f add(d dVar, Object obj) throws IOException {
        zzc(dVar, obj, true);
        return this;
    }

    public final /* synthetic */ f add(d dVar, boolean z) throws IOException {
        zzd(dVar, z ? 1 : 0, true);
        return this;
    }

    public final f add(String str, double d) throws IOException {
        zza(d.d(str), d, true);
        return this;
    }

    public final f add(String str, int i) throws IOException {
        zzd(d.d(str), i, true);
        return this;
    }

    public final f add(String str, long j) throws IOException {
        zze(d.d(str), j, true);
        return this;
    }

    public final f add(String str, Object obj) throws IOException {
        zzc(d.d(str), obj, true);
        return this;
    }

    public final f add(String str, boolean z) throws IOException {
        zzd(d.d(str), z ? 1 : 0, true);
        return this;
    }
}
