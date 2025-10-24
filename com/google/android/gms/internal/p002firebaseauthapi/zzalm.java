package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalm  reason: invalid package */
public class zzalm extends IOException {
    private boolean zza;

    public zzalm(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public static zzalp zza() {
        return new zzalp("Protocol message tag had invalid wire type.");
    }

    public static zzalm zzb() {
        return new zzalm("Protocol message end-group tag did not match expected tag.");
    }

    public static zzalm zzc() {
        return new zzalm("Protocol message contained an invalid tag (zero).");
    }

    public static zzalm zzd() {
        return new zzalm("Protocol message had invalid UTF-8.");
    }

    public static zzalm zze() {
        return new zzalm("CodedInputStream encountered a malformed varint.");
    }

    public static zzalm zzf() {
        return new zzalm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzalm zzg() {
        return new zzalm("Failed to parse the message.");
    }

    public static zzalm zzh() {
        return new zzalm("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static zzalm zzi() {
        return new zzalm("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    public static zzalm zzj() {
        return new zzalm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final void zzk() {
        this.zza = true;
    }

    public final boolean zzl() {
        return this.zza;
    }

    public zzalm(String str) {
        super(str);
    }

    public zzalm(String str, IOException iOException) {
        super(str, iOException);
    }
}
