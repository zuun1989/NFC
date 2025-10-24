package com.google.android.gms.internal.clearcut;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateBody;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzfs {
    private final ByteBuffer zzgd;
    private zzbn zzrh;
    private int zzri;

    private zzfs(ByteBuffer byteBuffer) {
        this.zzgd = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                StringBuilder sb2 = new StringBuilder(39);
                                sb2.append("Unpaired surrogate at index ");
                                sb2.append(i2);
                                throw new IllegalArgumentException(sb2.toString());
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb3 = new StringBuilder(54);
        sb3.append("UTF-8 length does not fit in int: ");
        sb3.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(sb3.toString());
    }

    private final void zzao(int i) throws IOException {
        byte b = (byte) i;
        if (this.zzgd.hasRemaining()) {
            this.zzgd.put(b);
            return;
        }
        throw new zzft(this.zzgd.position(), this.zzgd.limit());
    }

    private final void zzap(int i) throws IOException {
        while ((i & -128) != 0) {
            zzao((i & CertificateBody.profileType) | 128);
            i >>>= 7;
        }
        zzao(i);
    }

    public static int zzb(int i, zzfz zzfz) {
        int zzr = zzr(i);
        int zzas = zzfz.zzas();
        return zzr + zzz(zzas) + zzas;
    }

    public static int zzd(int i, long j) {
        return zzr(i) + zzo(j);
    }

    public static zzfs zzg(byte[] bArr) {
        return zzh(bArr, 0, bArr.length);
    }

    public static int zzh(String str) {
        int zza = zza(str);
        return zzz(zza) + zza;
    }

    public static long zzj(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzo(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int zzr(int i) {
        return zzz(i << 3);
    }

    public static int zzs(int i) {
        if (i >= 0) {
            return zzz(i);
        }
        return 10;
    }

    private static int zzz(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public final void zzc(int i, int i2) throws IOException {
        zzb(i, 0);
        if (i2 >= 0) {
            zzap(i2);
        } else {
            zzn((long) i2);
        }
    }

    public final void zze(int i, zzdo zzdo) throws IOException {
        if (this.zzrh == null) {
            this.zzrh = zzbn.zza(this.zzgd);
        } else {
            if (this.zzri != this.zzgd.position()) {
                this.zzrh.write(this.zzgd.array(), this.zzri, this.zzgd.position() - this.zzri);
            }
            zzbn zzbn = this.zzrh;
            zzbn.zza(i, zzdo);
            zzbn.flush();
            this.zzri = this.zzgd.position();
        }
        this.zzri = this.zzgd.position();
        zzbn zzbn2 = this.zzrh;
        zzbn2.zza(i, zzdo);
        zzbn2.flush();
        this.zzri = this.zzgd.position();
    }

    public final void zzem() {
        if (this.zzgd.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzgd.remaining())}));
        }
    }

    public final void zzi(int i, long j) throws IOException {
        zzb(i, 0);
        zzn(j);
    }

    public final void zzn(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzao((((int) j) & CertificateBody.profileType) | 128);
            j >>>= 7;
        }
        zzao((int) j);
    }

    private zzfs(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzb(int i, String str) {
        return zzr(i) + zzh(str);
    }

    private static void zzd(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        char charAt;
        CharSequence charSequence2 = charSequence;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (!byteBuffer.isReadOnly()) {
            char c = 57343;
            int i2 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i3 = remaining + arrayOffset;
                    while (i2 < length) {
                        int i4 = i2 + arrayOffset;
                        if (i4 >= i3 || (charAt = charSequence2.charAt(i2)) >= 128) {
                            break;
                        }
                        array[i4] = (byte) charAt;
                        i2++;
                    }
                    if (i2 == length) {
                        i = arrayOffset + length;
                    } else {
                        i = arrayOffset + i2;
                        while (i2 < length) {
                            char charAt2 = charSequence2.charAt(i2);
                            if (charAt2 < 128 && i < i3) {
                                array[i] = (byte) charAt2;
                                i++;
                            } else if (charAt2 < 2048 && i <= i3 - 2) {
                                int i5 = i + 1;
                                array[i] = (byte) ((charAt2 >>> 6) | 960);
                                i += 2;
                                array[i5] = (byte) ((charAt2 & '?') | 128);
                            } else if ((charAt2 < 55296 || c < charAt2) && i <= i3 - 3) {
                                array[i] = (byte) ((charAt2 >>> 12) | 480);
                                int i6 = i + 2;
                                array[i + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                i += 3;
                                array[i6] = (byte) ((charAt2 & '?') | 128);
                            } else if (i <= i3 - 4) {
                                int i7 = i2 + 1;
                                if (i7 != charSequence.length()) {
                                    char charAt3 = charSequence2.charAt(i7);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        array[i] = (byte) ((codePoint >>> 18) | 240);
                                        array[i + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i8 = i + 3;
                                        array[i + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i += 4;
                                        array[i8] = (byte) ((codePoint & 63) | 128);
                                        i2 = i7;
                                    } else {
                                        i2 = i7;
                                    }
                                }
                                StringBuilder sb2 = new StringBuilder(39);
                                sb2.append("Unpaired surrogate at index ");
                                sb2.append(i2 - 1);
                                throw new IllegalArgumentException(sb2.toString());
                            } else {
                                StringBuilder sb3 = new StringBuilder(37);
                                sb3.append("Failed writing ");
                                sb3.append(charAt2);
                                sb3.append(" at index ");
                                sb3.append(i);
                                throw new ArrayIndexOutOfBoundsException(sb3.toString());
                            }
                            i2++;
                            c = 57343;
                        }
                    }
                    byteBuffer2.position(i - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt4 = charSequence2.charAt(i2);
                    if (charAt4 >= 128) {
                        if (charAt4 < 2048) {
                            byteBuffer2.put((byte) ((charAt4 >>> 6) | 960));
                            charAt4 = (charAt4 & '?') | 128;
                        } else if (charAt4 < 55296 || 57343 < charAt4) {
                            byteBuffer2.put((byte) ((charAt4 >>> 12) | 480));
                            byteBuffer2.put((byte) (((charAt4 >>> 6) & 63) | 128));
                            byteBuffer2.put((byte) ((charAt4 & '?') | 128));
                            i2++;
                        } else {
                            int i9 = i2 + 1;
                            if (i9 != charSequence.length()) {
                                char charAt5 = charSequence2.charAt(i9);
                                if (Character.isSurrogatePair(charAt4, charAt5)) {
                                    int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                    byteBuffer2.put((byte) ((codePoint2 >>> 18) | 240));
                                    byteBuffer2.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                    byteBuffer2.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                    byteBuffer2.put((byte) ((codePoint2 & 63) | 128));
                                    i2 = i9;
                                    i2++;
                                } else {
                                    i2 = i9;
                                }
                            }
                            StringBuilder sb4 = new StringBuilder(39);
                            sb4.append("Unpaired surrogate at index ");
                            sb4.append(i2 - 1);
                            throw new IllegalArgumentException(sb4.toString());
                        }
                    }
                    byteBuffer2.put((byte) charAt4);
                    i2++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    public static int zzh(byte[] bArr) {
        return zzz(bArr.length) + bArr.length;
    }

    public final void zza(int i, zzfz zzfz) throws IOException {
        zzb(i, 2);
        if (zzfz.zzrs < 0) {
            zzfz.zzas();
        }
        zzap(zzfz.zzrs);
        zzfz.zza(this);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzr(i) + zzh(bArr);
    }

    public static zzfs zzh(byte[] bArr, int i, int i2) {
        return new zzfs(bArr, 0, i2);
    }

    public final void zza(int i, String str) throws IOException {
        zzb(i, 2);
        try {
            int zzz = zzz(str.length());
            if (zzz == zzz(str.length() * 3)) {
                int position = this.zzgd.position();
                if (this.zzgd.remaining() >= zzz) {
                    this.zzgd.position(position + zzz);
                    zzd((CharSequence) str, this.zzgd);
                    int position2 = this.zzgd.position();
                    this.zzgd.position(position);
                    zzap((position2 - position) - zzz);
                    this.zzgd.position(position2);
                    return;
                }
                throw new zzft(position + zzz, this.zzgd.limit());
            }
            zzap(zza(str));
            zzd((CharSequence) str, this.zzgd);
        } catch (BufferOverflowException e) {
            zzft zzft = new zzft(this.zzgd.position(), this.zzgd.limit());
            zzft.initCause(e);
            throw zzft;
        }
    }

    public final void zza(int i, byte[] bArr) throws IOException {
        zzb(i, 2);
        zzap(bArr.length);
        int length = bArr.length;
        if (this.zzgd.remaining() >= length) {
            this.zzgd.put(bArr, 0, length);
            return;
        }
        throw new zzft(this.zzgd.position(), this.zzgd.limit());
    }

    public final void zzb(int i, int i2) throws IOException {
        zzap((i << 3) | i2);
    }

    public final void zzb(int i, boolean z) throws IOException {
        zzb(25, 0);
        byte b = z ? (byte) 1 : 0;
        if (this.zzgd.hasRemaining()) {
            this.zzgd.put(b);
            return;
        }
        throw new zzft(this.zzgd.position(), this.zzgd.limit());
    }
}
