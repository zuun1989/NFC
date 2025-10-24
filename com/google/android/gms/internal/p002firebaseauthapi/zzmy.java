package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmy  reason: invalid package */
public final class zzmy {
    /* access modifiers changed from: private */
    public static final Object zza = new Object();
    /* access modifiers changed from: private */
    public static final String zzb = "zzmy";
    private zzbv zzc;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmy$zza */
    public static final class zza {
        /* access modifiers changed from: private */
        public Context zza = null;
        /* access modifiers changed from: private */
        public String zzb = null;
        /* access modifiers changed from: private */
        public String zzc = null;
        private String zzd = null;
        private zzaz zze = null;
        private boolean zzf = true;
        private zzbm zzg = null;
        private zzxe zzh = null;
        /* access modifiers changed from: private */
        public zzbv zzi;

        private static zzbv zza(byte[] bArr) throws GeneralSecurityException, IOException {
            return zzbv.zza(zzcc.zza(zzbc.zza(bArr), zzbi.zza()));
        }

        private final zzaz zzb() throws GeneralSecurityException {
            zzmy.zzd();
            zznd zznd = new zznd();
            try {
                boolean zzc2 = zznd.zzc(this.zzd);
                try {
                    return zznd.zza(this.zzd);
                } catch (GeneralSecurityException | ProviderException e) {
                    if (zzc2) {
                        Log.w(zzmy.zzb, "cannot use Android Keystore, it'll be disabled", e);
                        return null;
                    }
                    throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.zzd}), e);
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                Log.w(zzmy.zzb, "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }

        public final zza zza(zzxe zzxe) {
            this.zzh = zzxe;
            return this;
        }

        public final zza zza(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            } else if (this.zzf) {
                this.zzd = str;
                return this;
            } else {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
        }

        private final zzbv zzb(byte[] bArr) throws GeneralSecurityException, IOException {
            try {
                this.zze = new zznd().zza(this.zzd);
                try {
                    return zzbv.zza(zzbl.zza(zzbc.zza(bArr), this.zze, new byte[0]));
                } catch (IOException | GeneralSecurityException e) {
                    try {
                        return zza(bArr);
                    } catch (IOException unused) {
                        throw e;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                try {
                    zzbv zza2 = zza(bArr);
                    Log.w(zzmy.zzb, "cannot use Android Keystore, it'll be disabled", e2);
                    return zza2;
                } catch (IOException unused2) {
                    throw e2;
                }
            }
        }

        public final zza zza(Context context, String str, String str2) throws IOException {
            if (context != null) {
                this.zza = context;
                this.zzb = str;
                this.zzc = str2;
                return this;
            }
            throw new IllegalArgumentException("need an Android context");
        }

        public final synchronized zzmy zza() throws GeneralSecurityException, IOException {
            zzmy zzmy;
            try {
                if (this.zzb != null) {
                    zzxe zzxe = this.zzh;
                    if (zzxe != null && this.zzg == null) {
                        this.zzg = zzbm.zza(zzcm.zza(zzxe.zzk()));
                    }
                    synchronized (zzmy.zza) {
                        byte[] zzb2 = zzb(this.zza, this.zzb, this.zzc);
                        if (zzb2 == null) {
                            if (this.zzd != null) {
                                this.zze = zzb();
                            }
                            zzbm zzbm = this.zzg;
                            if (zzbm != null) {
                                zzbl zza2 = zzbl.zza(zzbm);
                                zzmy.zza(zza2, new zznf(this.zza, this.zzb, this.zzc), this.zze);
                                this.zzi = zzbv.zza(zza2);
                            } else {
                                throw new GeneralSecurityException("cannot read or generate keyset");
                            }
                        } else if (this.zzd != null) {
                            zzmy.zzd();
                            this.zzi = zzb(zzb2);
                        } else {
                            this.zzi = zza(zzb2);
                        }
                        zzmy = new zzmy(this);
                    }
                } else {
                    throw new IllegalArgumentException("keysetName cannot be null");
                }
            } catch (Throwable th) {
                throw th;
            } finally {
                while (true) {
                }
            }
            return zzmy;
        }

        private static byte[] zzb(Context context, String str, String str2) throws IOException {
            SharedPreferences sharedPreferences;
            if (str != null) {
                Context applicationContext = context.getApplicationContext();
                if (str2 == null) {
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                } else {
                    sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
                }
                try {
                    String string = sharedPreferences.getString(str, (String) null);
                    if (string == null) {
                        return null;
                    }
                    return zzaaa.zza(string);
                } catch (ClassCastException | IllegalArgumentException unused) {
                    throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", new Object[]{str}));
                }
            } else {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
        }
    }

    public static /* synthetic */ boolean zzd() {
        return true;
    }

    public final synchronized zzbl zza() throws GeneralSecurityException {
        return this.zzc.zza();
    }

    private zzmy(zza zza2) {
        new zznf(zza2.zza, zza2.zzb, zza2.zzc);
        this.zzc = zza2.zzi;
    }

    public static /* synthetic */ void zza(zzbl zzbl, zzbx zzbx, zzaz zzaz) {
        if (zzaz != null) {
            try {
                zzbl.zza(zzbx, zzaz, new byte[0]);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            }
        } else {
            zzcc.zza(zzbl, zzbx, zzbi.zza());
        }
    }
}
