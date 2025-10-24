package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzano  reason: invalid package */
final class zzano {
    public static String zza(zzajw zzajw) {
        zzanr zzanr = new zzanr(zzajw);
        StringBuilder sb2 = new StringBuilder(zzanr.zza());
        for (int i = 0; i < zzanr.zza(); i++) {
            byte zza = zzanr.zza(i);
            if (zza == 34) {
                sb2.append("\\\"");
            } else if (zza == 39) {
                sb2.append("\\'");
            } else if (zza != 92) {
                switch (zza) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (zza >= 32 && zza <= 126) {
                            sb2.append((char) zza);
                            break;
                        } else {
                            sb2.append('\\');
                            sb2.append((char) (((zza >>> 6) & 3) + 48));
                            sb2.append((char) (((zza >>> 3) & 7) + 48));
                            sb2.append((char) ((zza & 7) + ISO7816.INS_DECREASE));
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }
}
