package com.google.android.gms.internal.mlkit_vision_face;

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

final class zzcw implements f {
    private static final Charset zza = Charset.forName("UTF-8");
    private static final d zzb;
    private static final d zzc;
    private static final e zzd = zzcv.zza;
    private OutputStream zze;
    private final Map zzf;
    private final Map zzg;
    private final e zzh;
    private final zzda zzi = new zzda(this);

    static {
        d.b a = d.a("key");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("value");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = a2.b(zzcq2.zzb()).a();
    }

    public zzcw(OutputStream outputStream, Map map, Map map2, e eVar) {
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
        zzcu zzcu = (zzcu) dVar.c(zzcu.class);
        if (zzcu != null) {
            return zzcu.zza();
        }
        throw new c("Field has no @Protobuf config");
    }

    private final long zzi(e eVar, Object obj) throws IOException {
        OutputStream outputStream;
        Class<Throwable> cls = Throwable.class;
        zzcr zzcr = new zzcr();
        try {
            outputStream = this.zze;
            this.zze = zzcr;
            eVar.encode(obj, this);
            this.zze = outputStream;
            long zza2 = zzcr.zza();
            zzcr.close();
            return zza2;
        } catch (Throwable th) {
            try {
                cls.getDeclaredMethod("addSuppressed", new Class[]{cls}).invoke(th, new Object[]{th});
            } catch (Exception unused) {
            }
        }
        throw th;
    }

    private static zzcu zzj(d dVar) {
        zzcu zzcu = (zzcu) dVar.c(zzcu.class);
        if (zzcu != null) {
            return zzcu;
        }
        throw new c("Field has no @Protobuf config");
    }

    private final zzcw zzk(e eVar, d dVar, Object obj, boolean z) throws IOException {
        long zzi2 = zzi(eVar, obj);
        if (z && zzi2 == 0) {
            return this;
        }
        zzn((zzh(dVar) << 3) | 2);
        zzo(zzi2);
        eVar.encode(obj, this);
        return this;
    }

    private final zzcw zzl(g gVar, d dVar, Object obj, boolean z) throws IOException {
        this.zzi.zza(dVar, z);
        gVar.encode(obj, this.zzi);
        return this;
    }

    private static ByteBuffer zzm(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void zzn(int i) throws IOException {
        while (((long) (i & -128)) != 0) {
            this.zze.write((i & CertificateBody.profileType) | 128);
            i >>>= 7;
        }
        this.zze.write(i & CertificateBody.profileType);
    }

    private final void zzo(long j) throws IOException {
        while ((-128 & j) != 0) {
            this.zze.write((((int) j) & CertificateBody.profileType) | 128);
            j >>>= 7;
        }
        this.zze.write(((int) j) & CertificateBody.profileType);
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
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            zzn((zzh(dVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(zza);
            zzn(bytes.length);
            this.zze.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object zzc2 : (Collection) obj) {
                zzc(dVar, zzc2, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry zzk : ((Map) obj).entrySet()) {
                zzk(zzd, dVar, zzk, false);
            }
            return this;
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
            if (z && bArr.length == 0) {
                return this;
            }
            zzn((zzh(dVar) << 3) | 2);
            zzn(bArr.length);
            this.zze.write(bArr);
            return this;
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
            } else if (obj instanceof zzcs) {
                zzd(dVar, ((zzcs) obj).zza(), true);
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

    public final zzcw zzd(d dVar, int i, boolean z) throws IOException {
        if (z && i == 0) {
            return this;
        }
        zzcu zzj = zzj(dVar);
        zzct zzct = zzct.DEFAULT;
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
        return this;
    }

    public final zzcw zze(d dVar, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        zzcu zzj = zzj(dVar);
        zzct zzct = zzct.DEFAULT;
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
        return this;
    }

    public final zzcw zzf(Object obj) throws IOException {
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
