package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;

public final class zzba {
    /* JADX WARNING: type inference failed for: r0v120, types: [com.google.android.gms.internal.measurement.zzao] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x020c, code lost:
        if (r26.size() <= 1) goto L_0x0274;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x020e, code lost:
        r1 = java.lang.Math.max(0, (int) com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x022a, code lost:
        if (r1 <= 0) goto L_0x0246;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x022c, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0233, code lost:
        if (r7 >= java.lang.Math.min(r2, r4 + r1)) goto L_0x0246;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0235, code lost:
        r6.zzn(r6.zzh(), r5.zzl(r4));
        r5.zzr(r4);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x024b, code lost:
        if (r26.size() <= 2) goto L_0x0287;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x024d, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0252, code lost:
        if (r7 >= r26.size()) goto L_0x0287;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0254, code lost:
        r1 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0260, code lost:
        if ((r1 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0262, code lost:
        r5.zzq((r4 + r7) - 2, r1);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0273, code lost:
        throw new java.lang.IllegalArgumentException("Failed to parse elements to add");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0274, code lost:
        if (r4 >= r2) goto L_0x0287;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0276, code lost:
        r6.zzn(r6.zzh(), r5.zzl(r4));
        r5.zzn(r4, (com.google.android.gms.internal.measurement.zzao) null);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x028a, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzc("sort", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0299, code lost:
        if (r24.zzh() < 2) goto L_0x043c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x029b, code lost:
        r2 = r24.zzb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02a3, code lost:
        if (r26.isEmpty() != false) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02a5, code lost:
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02b2, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x02b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02b4, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02bf, code lost:
        throw new java.lang.IllegalArgumentException("Comparator should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02c0, code lost:
        java.util.Collections.sort(r2, new com.google.android.gms.internal.measurement.zzaz(r1, r3));
        r24.zzp();
        r0 = r2.iterator();
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02d4, code lost:
        if (r0.hasNext() == false) goto L_0x043c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02d6, code lost:
        r5.zzn(r7, (com.google.android.gms.internal.measurement.zzao) r0.next());
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02e4, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("some", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02fb, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x0357;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0301, code lost:
        if (r24.zzh() != 0) goto L_0x0307;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0307, code lost:
        r0 = (com.google.android.gms.internal.measurement.zzai) r0;
        r1 = r24.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0311, code lost:
        if (r1.hasNext() == false) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0313, code lost:
        r2 = ((java.lang.Integer) r1.next()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0321, code lost:
        if (r5.zzo(r2) == false) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x034d, code lost:
        if (r0.zza(r3, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzao[]{r5.zzl(r2), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2)), r5})).zze().booleanValue() == false) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x035c, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x035d, code lost:
        r5 = r24;
        r0 = r26;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzh.zzc("slice", 2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x036c, code lost:
        if (r26.isEmpty() == false) goto L_0x0374;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0374, code lost:
        r1 = (double) r24.zzh();
        r6 = com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0394, code lost:
        if (r6 >= 0.0d) goto L_0x039c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0396, code lost:
        r6 = java.lang.Math.max(r6 + r1, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x039c, code lost:
        r6 = java.lang.Math.min(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03a5, code lost:
        if (r26.size() != 2) goto L_0x03ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a7, code lost:
        r3 = com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03c2, code lost:
        if (r3 >= 0.0d) goto L_0x03ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03c4, code lost:
        r1 = java.lang.Math.max(r1 + r3, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03ca, code lost:
        r1 = java.lang.Math.min(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03ce, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r3 = (int) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03d7, code lost:
        if (((double) r3) >= r1) goto L_0x07a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03d9, code lost:
        r0.zzn(r0.zzh(), r5.zzl(r3));
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03e7, code lost:
        r5 = r24;
        com.google.android.gms.internal.measurement.zzh.zza("shift", 0, r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03f3, code lost:
        if (r24.zzh() != 0) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03f9, code lost:
        r0 = r5.zzl(0);
        r5.zzr(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0402, code lost:
        r5 = r24;
        com.google.android.gms.internal.measurement.zzh.zza(r21, 0, r26);
        r0 = r24.zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0410, code lost:
        if (r0 == 0) goto L_0x043c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0412, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0416, code lost:
        if (r7 >= (r0 / 2)) goto L_0x043c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x041c, code lost:
        if (r5.zzo(r7) == false) goto L_0x0438;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x041e, code lost:
        r2 = r5.zzl(r7);
        r5.zzn(r7, (com.google.android.gms.internal.measurement.zzao) null);
        r3 = (r0 - 1) - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x042c, code lost:
        if (r5.zzo(r3) == false) goto L_0x0435;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x042e, code lost:
        r5.zzn(r7, r5.zzl(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0435, code lost:
        r5.zzn(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0438, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0459, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0463, code lost:
        if (r26.isEmpty() != false) goto L_0x0481;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0465, code lost:
        r0 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x046d, code lost:
        if (r0.hasNext() == false) goto L_0x0481;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x046f, code lost:
        r5.zzn(r24.zzh(), r3.zza((com.google.android.gms.internal.measurement.zzao) r0.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0491, code lost:
        r5 = r24;
        com.google.android.gms.internal.measurement.zzh.zza("pop", 0, r26);
        r0 = r24.zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x049d, code lost:
        if (r0 != 0) goto L_0x04a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04a3, code lost:
        r0 = r0 - 1;
        r1 = r5.zzl(r0);
        r5.zzr(r0);
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04af, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("map", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04c6, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) == false) goto L_0x04dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04cc, code lost:
        if (r24.zzh() != 0) goto L_0x04d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04e2, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04e3, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzc("lastIndexOf", 2, r0);
        r1 = com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04f3, code lost:
        if (r26.isEmpty() != false) goto L_0x0500;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x04f5, code lost:
        r1 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0500, code lost:
        r2 = r24.zzh() - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x050b, code lost:
        if (r26.size() <= 1) goto L_0x0547;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x050d, code lost:
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0523, code lost:
        if (java.lang.Double.isNaN(r0.zzd().doubleValue()) == false) goto L_0x052f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0525, code lost:
        r2 = (double) (r24.zzh() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x052c, code lost:
        r6 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x052f, code lost:
        r2 = com.google.android.gms.internal.measurement.zzh.zzi(r0.zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x053e, code lost:
        if (r2 >= 0.0d) goto L_0x054a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0540, code lost:
        r2 = r2 + ((double) r24.zzh());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0547, code lost:
        r6 = 0.0d;
        r2 = (double) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x054c, code lost:
        if (r2 >= r6) goto L_0x0559;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0559, code lost:
        r0 = (int) java.lang.Math.min((double) r24.zzh(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0563, code lost:
        if (r0 < 0) goto L_0x0585;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0569, code lost:
        if (r5.zzo(r0) == false) goto L_0x0582;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0573, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzf(r5.zzl(r0), r1) == false) goto L_0x0582;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0582, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0590, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        r1 = r16;
        com.google.android.gms.internal.measurement.zzh.zzc("join", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x05a0, code lost:
        if (r24.zzh() != 0) goto L_0x05a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x05aa, code lost:
        if (r26.isEmpty() != false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x05ac, code lost:
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x05b9, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzam) != false) goto L_0x05c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x05bd, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzat) == false) goto L_0x05c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x05c0, code lost:
        r4 = r0.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x05c5, code lost:
        r4 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x05c8, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x05d4, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzc(r22, 2, r0);
        r1 = com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x05e6, code lost:
        if (r26.isEmpty() != false) goto L_0x05f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x05e8, code lost:
        r1 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x05f8, code lost:
        if (r26.size() <= 1) goto L_0x0631;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05fa, code lost:
        r2 = com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0617, code lost:
        if (r2 < ((double) r24.zzh())) goto L_0x0624;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0628, code lost:
        if (r2 >= 0.0d) goto L_0x0634;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x062a, code lost:
        r2 = r2 + ((double) r24.zzh());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0631, code lost:
        r2 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0634, code lost:
        r0 = r24.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x063c, code lost:
        if (r0.hasNext() == false) goto L_0x0662;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x063e, code lost:
        r4 = ((java.lang.Integer) r0.next()).intValue();
        r6 = (double) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x064b, code lost:
        if (r6 < r2) goto L_0x0638;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0655, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzf(r5.zzl(r4), r1) == false) goto L_0x0638;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x066d, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("forEach", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0684, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) == false) goto L_0x0699;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x068a, code lost:
        if (r24.zzi() != 0) goto L_0x0690;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0690, code lost:
        zzc(r5, r3, (com.google.android.gms.internal.measurement.zzan) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x069e, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x069f, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("filter", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x06b6, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) == false) goto L_0x06f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x06bc, code lost:
        if (r24.zzi() != 0) goto L_0x06c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x06c5, code lost:
        r2 = (com.google.android.gms.internal.measurement.zzae) r24.zzt();
        r0 = zzc(r5, r3, (com.google.android.gms.internal.measurement.zzan) r0, (java.lang.Boolean) null, java.lang.Boolean.TRUE);
        r1 = new com.google.android.gms.internal.measurement.zzae();
        r0 = r0.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x06e0, code lost:
        if (r0.hasNext() == false) goto L_0x04ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x06e2, code lost:
        r1.zzn(r1.zzh(), r2.zzl(((java.lang.Integer) r0.next()).intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x06fd, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x06fe, code lost:
        r1 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("every", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x0715, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) == false) goto L_0x073b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x071b, code lost:
        if (r24.zzh() != 0) goto L_0x0721;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x0733, code lost:
        if (zzc(r1, r3, (com.google.android.gms.internal.measurement.zzan) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).zzh() == r24.zzh()) goto L_0x0738;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x0740, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0741, code lost:
        r1 = r24;
        r3 = r25;
        r0 = r26;
        r1 = (com.google.android.gms.internal.measurement.zzae) r24.zzt();
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0751, code lost:
        if (r26.isEmpty() != false) goto L_0x04ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0753, code lost:
        r0 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x075b, code lost:
        if (r0.hasNext() == false) goto L_0x04ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0033, code lost:
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x075d, code lost:
        r2 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0769, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x079a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x076b, code lost:
        r4 = r1.zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0771, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzae) == false) goto L_0x0796;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x0773, code lost:
        r2 = (com.google.android.gms.internal.measurement.zzae) r2;
        r5 = r2.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x077d, code lost:
        if (r5.hasNext() == false) goto L_0x0757;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x077f, code lost:
        r6 = (java.lang.Integer) r5.next();
        r1.zzn(r6.intValue() + r4, r2.zzl(r6.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0796, code lost:
        r1.zzn(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x07a1, code lost:
        throw new java.lang.IllegalStateException("Failed evaluation of arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x04ac, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x04ac, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r24.zzh()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:?, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r24.zzs(r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:?, code lost:
        return r24.zzt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:?, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:?, code lost:
        return zzb(r24, r25, r26, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:?, code lost:
        return zzb(r24, r25, r26, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r24.zzh()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:?, code lost:
        return zzc(r5, r3, (com.google.android.gms.internal.measurement.zzan) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:?, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r5.zzs(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ff, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0101, code lost:
        r21 = "reverse";
        r22 = "indexOf";
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010a, code lost:
        switch(r0) {
            case 0: goto L_0x0741;
            case 1: goto L_0x06fe;
            case 2: goto L_0x069f;
            case 3: goto L_0x066d;
            case 4: goto L_0x05d4;
            case 5: goto L_0x0590;
            case 6: goto L_0x04e3;
            case 7: goto L_0x04af;
            case 8: goto L_0x0491;
            case 9: goto L_0x0459;
            case 10: goto L_0x044c;
            case 11: goto L_0x043f;
            case 12: goto L_0x0402;
            case 13: goto L_0x03e7;
            case 14: goto L_0x035d;
            case 15: goto L_0x02e4;
            case 16: goto L_0x028a;
            case 17: goto L_0x01bd;
            case 18: goto L_0x01a8;
            case 19: goto L_0x0115;
            default: goto L_0x010d;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0114, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003e, code lost:
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0119, code lost:
        if (r26.isEmpty() != false) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011b, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r1 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0128, code lost:
        if (r1.hasNext() == false) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012a, code lost:
        r2 = r25.zza((com.google.android.gms.internal.measurement.zzao) r1.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0138, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x013a, code lost:
        r0.zzn(r0.zzh(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0149, code lost:
        throw new java.lang.IllegalStateException("Argument evaluation failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014a, code lost:
        r1 = r0.zzh();
        r2 = r24.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0156, code lost:
        if (r2.hasNext() == false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0158, code lost:
        r3 = (java.lang.Integer) r2.next();
        r0.zzn(r3.intValue() + r1, r24.zzl(r3.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0171, code lost:
        r5 = r24;
        r24.zzp();
        r1 = r0.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x017e, code lost:
        if (r1.hasNext() == false) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0180, code lost:
        r2 = (java.lang.Integer) r1.next();
        r5.zzn(r2.intValue(), r0.zzl(r2.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0196, code lost:
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a8, code lost:
        com.google.android.gms.internal.measurement.zzh.zza(r6, 0, r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01bd, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c8, code lost:
        if (r26.isEmpty() == false) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d1, code lost:
        r4 = (int) com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01e8, code lost:
        if (r4 >= 0) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01ea, code lost:
        r4 = java.lang.Math.max(0, r4 + r24.zzh());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f8, code lost:
        if (r4 <= r24.zzh()) goto L_0x01fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01fa, code lost:
        r4 = r24.zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01fe, code lost:
        r2 = r24.zzh();
        r6 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzao zza(java.lang.String r23, com.google.android.gms.internal.measurement.zzae r24, com.google.android.gms.internal.measurement.zzg r25, java.util.List r26) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            java.lang.String r4 = ","
            int r6 = r23.hashCode()
            java.lang.String r7 = "toString"
            java.lang.String r8 = "filter"
            java.lang.String r9 = "forEach"
            java.lang.String r10 = "lastIndexOf"
            java.lang.String r11 = "map"
            java.lang.String r12 = "pop"
            java.lang.String r13 = "join"
            java.lang.String r14 = "some"
            java.lang.String r15 = "sort"
            java.lang.String r5 = "every"
            r16 = r4
            java.lang.String r4 = "shift"
            java.lang.String r3 = "slice"
            java.lang.String r1 = "reverse"
            java.lang.String r2 = "indexOf"
            r17 = -1
            r18 = r7
            switch(r6) {
                case -1776922004: goto L_0x00f4;
                case -1354795244: goto L_0x00e8;
                case -1274492040: goto L_0x00de;
                case -934873754: goto L_0x00d2;
                case -895859076: goto L_0x00c6;
                case -678635926: goto L_0x00bc;
                case -467511597: goto L_0x00b4;
                case -277637751: goto L_0x00a9;
                case 107868: goto L_0x00a1;
                case 111185: goto L_0x0098;
                case 3267882: goto L_0x0090;
                case 3452698: goto L_0x0085;
                case 3536116: goto L_0x007c;
                case 3536286: goto L_0x0073;
                case 96891675: goto L_0x0068;
                case 109407362: goto L_0x005f;
                case 109526418: goto L_0x0056;
                case 965561430: goto L_0x004b;
                case 1099846370: goto L_0x0042;
                case 1943291465: goto L_0x0037;
                default: goto L_0x0033;
            }
        L_0x0033:
            r6 = r18
            goto L_0x00ff
        L_0x0037:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0033
            r0 = 4
        L_0x003e:
            r6 = r18
            goto L_0x0101
        L_0x0042:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0033
            r0 = 12
            goto L_0x003e
        L_0x004b:
            java.lang.String r6 = "reduceRight"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 11
            goto L_0x003e
        L_0x0056:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 14
            goto L_0x003e
        L_0x005f:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0033
            r0 = 13
            goto L_0x003e
        L_0x0068:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 1
            goto L_0x0101
        L_0x0073:
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0033
            r0 = 16
            goto L_0x003e
        L_0x007c:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0033
            r0 = 15
            goto L_0x003e
        L_0x0085:
            java.lang.String r6 = "push"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 9
            goto L_0x003e
        L_0x0090:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0033
            r0 = 5
            goto L_0x003e
        L_0x0098:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0033
            r0 = 8
            goto L_0x003e
        L_0x00a1:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0033
            r0 = 7
            goto L_0x003e
        L_0x00a9:
            java.lang.String r6 = "unshift"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 19
            goto L_0x003e
        L_0x00b4:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0033
            r0 = 6
            goto L_0x003e
        L_0x00bc:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 3
            goto L_0x0101
        L_0x00c6:
            java.lang.String r6 = "splice"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 17
            goto L_0x003e
        L_0x00d2:
            java.lang.String r6 = "reduce"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 10
            goto L_0x003e
        L_0x00de:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 2
            goto L_0x0101
        L_0x00e8:
            java.lang.String r6 = "concat"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 0
            goto L_0x0101
        L_0x00f4:
            r6 = r18
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00ff
            r0 = 18
            goto L_0x0101
        L_0x00ff:
            r0 = r17
        L_0x0101:
            r19 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.String r7 = "Callback should be a method"
            r21 = r1
            r22 = r2
            r1 = 0
            switch(r0) {
                case 0: goto L_0x0741;
                case 1: goto L_0x06fe;
                case 2: goto L_0x069f;
                case 3: goto L_0x066d;
                case 4: goto L_0x05d4;
                case 5: goto L_0x0590;
                case 6: goto L_0x04e3;
                case 7: goto L_0x04af;
                case 8: goto L_0x0491;
                case 9: goto L_0x0459;
                case 10: goto L_0x044c;
                case 11: goto L_0x043f;
                case 12: goto L_0x0402;
                case 13: goto L_0x03e7;
                case 14: goto L_0x035d;
                case 15: goto L_0x02e4;
                case 16: goto L_0x028a;
                case 17: goto L_0x01bd;
                case 18: goto L_0x01a8;
                case 19: goto L_0x0115;
                default: goto L_0x010d;
            }
        L_0x010d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0115:
            boolean r0 = r26.isEmpty()
            if (r0 != 0) goto L_0x0196
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            java.util.Iterator r1 = r26.iterator()
        L_0x0124:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x014a
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzao r2 = (com.google.android.gms.internal.measurement.zzao) r2
            r3 = r25
            com.google.android.gms.internal.measurement.zzao r2 = r3.zza(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x0142
            int r4 = r0.zzh()
            r0.zzn(r4, r2)
            goto L_0x0124
        L_0x0142:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x014a:
            int r1 = r0.zzh()
            java.util.Iterator r2 = r24.zzg()
        L_0x0152:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0171
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            r5 = r24
            com.google.android.gms.internal.measurement.zzao r3 = r5.zzl(r3)
            r0.zzn(r4, r3)
            goto L_0x0152
        L_0x0171:
            r5 = r24
            r24.zzp()
            java.util.Iterator r1 = r0.zzg()
        L_0x017a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0198
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.zzao r2 = r0.zzl(r2)
            r5.zzn(r3, r2)
            goto L_0x017a
        L_0x0196:
            r5 = r24
        L_0x0198:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r24.zzh()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            goto L_0x07a2
        L_0x01a8:
            r5 = r24
            r0 = r26
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zza(r6, r2, r0)
            com.google.android.gms.internal.measurement.zzas r0 = new com.google.android.gms.internal.measurement.zzas
            r1 = r16
            java.lang.String r1 = r5.zzs(r1)
            r0.<init>(r1)
            goto L_0x07a2
        L_0x01bd:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 0
            boolean r4 = r26.isEmpty()
            if (r4 == 0) goto L_0x01d1
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x07a2
        L_0x01d1:
            java.lang.Object r4 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r4 = (com.google.android.gms.internal.measurement.zzao) r4
            com.google.android.gms.internal.measurement.zzao r4 = r3.zza(r4)
            java.lang.Double r4 = r4.zzd()
            double r6 = r4.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzh.zzi(r6)
            int r4 = (int) r6
            if (r4 >= 0) goto L_0x01f4
            int r6 = r24.zzh()
            int r4 = r4 + r6
            int r4 = java.lang.Math.max(r2, r4)
            goto L_0x01fe
        L_0x01f4:
            int r2 = r24.zzh()
            if (r4 <= r2) goto L_0x01fe
            int r4 = r24.zzh()
        L_0x01fe:
            int r2 = r24.zzh()
            com.google.android.gms.internal.measurement.zzae r6 = new com.google.android.gms.internal.measurement.zzae
            r6.<init>()
            int r7 = r26.size()
            r8 = 1
            if (r7 <= r8) goto L_0x0274
            java.lang.Object r1 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
            java.lang.Double r1 = r1.zzd()
            double r7 = r1.doubleValue()
            double r7 = com.google.android.gms.internal.measurement.zzh.zzi(r7)
            int r1 = (int) r7
            r7 = 0
            int r1 = java.lang.Math.max(r7, r1)
            if (r1 <= 0) goto L_0x0246
            r7 = r4
        L_0x022d:
            int r8 = r4 + r1
            int r8 = java.lang.Math.min(r2, r8)
            if (r7 >= r8) goto L_0x0246
            com.google.android.gms.internal.measurement.zzao r8 = r5.zzl(r4)
            int r9 = r6.zzh()
            r6.zzn(r9, r8)
            r5.zzr(r4)
            r8 = 1
            int r7 = r7 + r8
            goto L_0x022d
        L_0x0246:
            int r1 = r26.size()
            r2 = 2
            if (r1 <= r2) goto L_0x0287
            r7 = 2
        L_0x024e:
            int r1 = r26.size()
            if (r7 >= r1) goto L_0x0287
            java.lang.Object r1 = r0.get(r7)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r2 != 0) goto L_0x026c
            int r2 = r4 + r7
            int r2 = r2 + -2
            r5.zzq(r2, r1)
            r1 = 1
            int r7 = r7 + r1
            goto L_0x024e
        L_0x026c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x0274:
            if (r4 >= r2) goto L_0x0287
            com.google.android.gms.internal.measurement.zzao r0 = r5.zzl(r4)
            int r3 = r6.zzh()
            r6.zzn(r3, r0)
            r5.zzn(r4, r1)
            r7 = 1
            int r4 = r4 + r7
            goto L_0x0274
        L_0x0287:
            r0 = r6
            goto L_0x07a2
        L_0x028a:
            r5 = r24
            r3 = r25
            r0 = r26
            r7 = 1
            com.google.android.gms.internal.measurement.zzh.zzc(r15, r7, r0)
            int r2 = r24.zzh()
            r4 = 2
            if (r2 < r4) goto L_0x043c
            java.util.List r2 = r24.zzb()
            boolean r4 = r26.isEmpty()
            if (r4 != 0) goto L_0x02c0
            r4 = 0
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r1 == 0) goto L_0x02b8
            r1 = r0
            com.google.android.gms.internal.measurement.zzai r1 = (com.google.android.gms.internal.measurement.zzai) r1
            goto L_0x02c0
        L_0x02b8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x02c0:
            com.google.android.gms.internal.measurement.zzaz r0 = new com.google.android.gms.internal.measurement.zzaz
            r0.<init>(r1, r3)
            java.util.Collections.sort(r2, r0)
            r24.zzp()
            java.util.Iterator r0 = r2.iterator()
            r7 = 0
        L_0x02d0:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x043c
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            r2 = 1
            int r3 = r7 + 1
            r5.zzn(r7, r1)
            r7 = r3
            goto L_0x02d0
        L_0x02e4:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r14, r2, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r1 == 0) goto L_0x0357
            int r1 = r24.zzh()
            if (r1 != 0) goto L_0x0307
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzl
            goto L_0x07a2
        L_0x0307:
            com.google.android.gms.internal.measurement.zzai r0 = (com.google.android.gms.internal.measurement.zzai) r0
            java.util.Iterator r1 = r24.zzg()
        L_0x030d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0353
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            boolean r4 = r5.zzo(r2)
            if (r4 == 0) goto L_0x030d
            com.google.android.gms.internal.measurement.zzao r4 = r5.zzl(r2)
            double r6 = (double) r2
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            r2.<init>(r6)
            r6 = 3
            com.google.android.gms.internal.measurement.zzao[] r7 = new com.google.android.gms.internal.measurement.zzao[r6]
            r8 = 0
            r7[r8] = r4
            r4 = 1
            r7[r4] = r2
            r2 = 2
            r7[r2] = r5
            java.util.List r2 = java.util.Arrays.asList(r7)
            com.google.android.gms.internal.measurement.zzao r2 = r0.zza(r3, r2)
            java.lang.Boolean r2 = r2.zze()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x030d
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzk
            goto L_0x07a2
        L_0x0353:
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzl
            goto L_0x07a2
        L_0x0357:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x035d:
            r5 = r24
            r0 = r26
            r1 = r3
            r2 = 2
            r3 = r25
            com.google.android.gms.internal.measurement.zzh.zzc(r1, r2, r0)
            boolean r1 = r26.isEmpty()
            if (r1 == 0) goto L_0x0374
            com.google.android.gms.internal.measurement.zzao r0 = r24.zzt()
            goto L_0x07a2
        L_0x0374:
            int r1 = r24.zzh()
            double r1 = (double) r1
            r4 = 0
            java.lang.Object r4 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r4 = (com.google.android.gms.internal.measurement.zzao) r4
            com.google.android.gms.internal.measurement.zzao r4 = r3.zza(r4)
            java.lang.Double r4 = r4.zzd()
            double r6 = r4.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzh.zzi(r6)
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x039c
            double r6 = r6 + r1
            double r6 = java.lang.Math.max(r6, r8)
            goto L_0x03a0
        L_0x039c:
            double r6 = java.lang.Math.min(r6, r1)
        L_0x03a0:
            int r4 = r26.size()
            r8 = 2
            if (r4 != r8) goto L_0x03ce
            r4 = 1
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r3 = r0.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzh.zzi(r3)
            r8 = 0
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x03ca
            double r1 = r1 + r3
            double r1 = java.lang.Math.max(r1, r8)
            goto L_0x03ce
        L_0x03ca:
            double r1 = java.lang.Math.min(r1, r3)
        L_0x03ce:
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            int r3 = (int) r6
        L_0x03d4:
            double r6 = (double) r3
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x07a2
            com.google.android.gms.internal.measurement.zzao r4 = r5.zzl(r3)
            int r6 = r0.zzh()
            r0.zzn(r6, r4)
            r4 = 1
            int r3 = r3 + r4
            goto L_0x03d4
        L_0x03e7:
            r5 = r24
            r0 = r26
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zza(r4, r2, r0)
            int r0 = r24.zzh()
            if (r0 != 0) goto L_0x03f9
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x07a2
        L_0x03f9:
            com.google.android.gms.internal.measurement.zzao r0 = r5.zzl(r2)
            r5.zzr(r2)
            goto L_0x07a2
        L_0x0402:
            r5 = r24
            r0 = r26
            r3 = r21
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zza(r3, r2, r0)
            int r0 = r24.zzh()
            if (r0 == 0) goto L_0x043c
            r2 = 2
            r7 = 0
        L_0x0414:
            int r3 = r0 / 2
            if (r7 >= r3) goto L_0x043c
            boolean r2 = r5.zzo(r7)
            if (r2 == 0) goto L_0x0438
            com.google.android.gms.internal.measurement.zzao r2 = r5.zzl(r7)
            r5.zzn(r7, r1)
            int r3 = r0 + -1
            int r3 = r3 - r7
            boolean r4 = r5.zzo(r3)
            if (r4 == 0) goto L_0x0435
            com.google.android.gms.internal.measurement.zzao r4 = r5.zzl(r3)
            r5.zzn(r7, r4)
        L_0x0435:
            r5.zzn(r3, r2)
        L_0x0438:
            r2 = 1
            int r7 = r7 + r2
            r2 = 2
            goto L_0x0414
        L_0x043c:
            r0 = r5
            goto L_0x07a2
        L_0x043f:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = 0
            com.google.android.gms.internal.measurement.zzao r0 = zzb(r5, r3, r0, r1)
            goto L_0x07a2
        L_0x044c:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzao r0 = zzb(r5, r3, r0, r2)
            goto L_0x07a2
        L_0x0459:
            r5 = r24
            r3 = r25
            r0 = r26
            boolean r1 = r26.isEmpty()
            if (r1 != 0) goto L_0x0481
            java.util.Iterator r0 = r26.iterator()
        L_0x0469:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0481
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
            int r2 = r24.zzh()
            r5.zzn(r2, r1)
            goto L_0x0469
        L_0x0481:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r24.zzh()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            goto L_0x07a2
        L_0x0491:
            r5 = r24
            r0 = r26
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zza(r12, r2, r0)
            int r0 = r24.zzh()
            if (r0 != 0) goto L_0x04a3
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x07a2
        L_0x04a3:
            int r0 = r0 + -1
            com.google.android.gms.internal.measurement.zzao r1 = r5.zzl(r0)
            r5.zzr(r0)
        L_0x04ac:
            r0 = r1
            goto L_0x07a2
        L_0x04af:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 0
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r11, r4, r0)
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r2 == 0) goto L_0x04dd
            int r2 = r24.zzh()
            if (r2 != 0) goto L_0x04d5
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x07a2
        L_0x04d5:
            com.google.android.gms.internal.measurement.zzan r0 = (com.google.android.gms.internal.measurement.zzan) r0
            com.google.android.gms.internal.measurement.zzae r0 = zzc(r5, r3, r0, r1, r1)
            goto L_0x07a2
        L_0x04dd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x04e3:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r10, r1, r0)
            com.google.android.gms.internal.measurement.zzao r1 = com.google.android.gms.internal.measurement.zzao.zzf
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x0500
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
        L_0x0500:
            int r2 = r24.zzh()
            int r2 = r2 + -1
            int r4 = r26.size()
            r6 = 1
            if (r4 <= r6) goto L_0x0547
            java.lang.Object r0 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            java.lang.Double r2 = r0.zzd()
            double r2 = r2.doubleValue()
            boolean r2 = java.lang.Double.isNaN(r2)
            if (r2 == 0) goto L_0x052f
            int r0 = r24.zzh()
            int r0 = r0 + -1
            double r2 = (double) r0
        L_0x052c:
            r6 = 0
            goto L_0x053c
        L_0x052f:
            java.lang.Double r0 = r0.zzd()
            double r2 = r0.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzh.zzi(r2)
            goto L_0x052c
        L_0x053c:
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x054a
            int r0 = r24.zzh()
            double r8 = (double) r0
            double r2 = r2 + r8
            goto L_0x054a
        L_0x0547:
            r6 = 0
            double r2 = (double) r2
        L_0x054a:
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0559
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x07a2
        L_0x0559:
            int r0 = r24.zzh()
            double r6 = (double) r0
            double r2 = java.lang.Math.min(r6, r2)
            int r0 = (int) r2
        L_0x0563:
            if (r0 < 0) goto L_0x0585
            boolean r2 = r5.zzo(r0)
            if (r2 == 0) goto L_0x0582
            com.google.android.gms.internal.measurement.zzao r2 = r5.zzl(r0)
            boolean r2 = com.google.android.gms.internal.measurement.zzh.zzf(r2, r1)
            if (r2 == 0) goto L_0x0582
            double r0 = (double) r0
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r2.<init>(r0)
            r0 = r2
            goto L_0x07a2
        L_0x0582:
            int r0 = r0 + -1
            goto L_0x0563
        L_0x0585:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x07a2
        L_0x0590:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = r16
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzc(r13, r2, r0)
            int r2 = r24.zzh()
            if (r2 != 0) goto L_0x05a6
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzm
            goto L_0x07a2
        L_0x05a6:
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x05c8
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzam
            if (r1 != 0) goto L_0x05c5
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzat
            if (r1 == 0) goto L_0x05c0
            goto L_0x05c5
        L_0x05c0:
            java.lang.String r4 = r0.zzc()
            goto L_0x05c9
        L_0x05c5:
            java.lang.String r4 = ""
            goto L_0x05c9
        L_0x05c8:
            r4 = r1
        L_0x05c9:
            com.google.android.gms.internal.measurement.zzas r0 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r1 = r5.zzs(r4)
            r0.<init>(r1)
            goto L_0x07a2
        L_0x05d4:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = r22
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r1, r2, r0)
            com.google.android.gms.internal.measurement.zzao r1 = com.google.android.gms.internal.measurement.zzao.zzf
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x05f3
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
        L_0x05f3:
            int r2 = r26.size()
            r4 = 1
            if (r2 <= r4) goto L_0x0631
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r2 = r0.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzh.zzi(r2)
            int r0 = r24.zzh()
            double r6 = (double) r0
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0624
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x07a2
        L_0x0624:
            r6 = 0
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0634
            int r0 = r24.zzh()
            double r6 = (double) r0
            double r2 = r2 + r6
            goto L_0x0634
        L_0x0631:
            r6 = 0
            r2 = r6
        L_0x0634:
            java.util.Iterator r0 = r24.zzg()
        L_0x0638:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0662
            java.lang.Object r4 = r0.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            double r6 = (double) r4
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x0638
            com.google.android.gms.internal.measurement.zzao r4 = r5.zzl(r4)
            boolean r4 = com.google.android.gms.internal.measurement.zzh.zzf(r4, r1)
            if (r4 == 0) goto L_0x0638
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r6)
            r0.<init>(r1)
            goto L_0x07a2
        L_0x0662:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x07a2
        L_0x066d:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r9, r2, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r2 == 0) goto L_0x0699
            int r2 = r24.zzi()
            if (r2 != 0) goto L_0x0690
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x07a2
        L_0x0690:
            com.google.android.gms.internal.measurement.zzan r0 = (com.google.android.gms.internal.measurement.zzan) r0
            zzc(r5, r3, r0, r1, r1)
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x07a2
        L_0x0699:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x069f:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r8, r2, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r2 == 0) goto L_0x06f8
            int r2 = r24.zzi()
            if (r2 != 0) goto L_0x06c5
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x07a2
        L_0x06c5:
            com.google.android.gms.internal.measurement.zzao r2 = r24.zzt()
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            com.google.android.gms.internal.measurement.zzan r0 = (com.google.android.gms.internal.measurement.zzan) r0
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.zzae r0 = zzc(r5, r3, r0, r1, r4)
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r1.<init>()
            java.util.Iterator r0 = r0.zzg()
        L_0x06dc:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x04ac
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.zzao r3 = r2.zzl(r3)
            int r4 = r1.zzh()
            r1.zzn(r4, r3)
            goto L_0x06dc
        L_0x06f8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x06fe:
            r1 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r5, r2, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r2 == 0) goto L_0x073b
            int r2 = r24.zzh()
            if (r2 != 0) goto L_0x0721
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzk
            goto L_0x07a2
        L_0x0721:
            com.google.android.gms.internal.measurement.zzan r0 = (com.google.android.gms.internal.measurement.zzan) r0
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.zzae r0 = zzc(r1, r3, r0, r2, r4)
            int r0 = r0.zzh()
            int r1 = r24.zzh()
            if (r0 == r1) goto L_0x0738
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzl
            goto L_0x07a2
        L_0x0738:
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzk
            goto L_0x07a2
        L_0x073b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x0741:
            r1 = r24
            r3 = r25
            r0 = r26
            com.google.android.gms.internal.measurement.zzao r1 = r24.zzt()
            com.google.android.gms.internal.measurement.zzae r1 = (com.google.android.gms.internal.measurement.zzae) r1
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x04ac
            java.util.Iterator r0 = r26.iterator()
        L_0x0757:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x04ac
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.zzao r2 = (com.google.android.gms.internal.measurement.zzao) r2
            com.google.android.gms.internal.measurement.zzao r2 = r3.zza(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x079a
            int r4 = r1.zzh()
            boolean r5 = r2 instanceof com.google.android.gms.internal.measurement.zzae
            if (r5 == 0) goto L_0x0796
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            java.util.Iterator r5 = r2.zzg()
        L_0x0779:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0757
            java.lang.Object r6 = r5.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r7 = r6.intValue()
            int r7 = r7 + r4
            int r6 = r6.intValue()
            com.google.android.gms.internal.measurement.zzao r6 = r2.zzl(r6)
            r1.zzn(r7, r6)
            goto L_0x0779
        L_0x0796:
            r1.zzn(r4, r2)
            goto L_0x0757
        L_0x079a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x07a2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzba.zza(java.lang.String, com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzao");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.zzao zzb(com.google.android.gms.internal.measurement.zzae r10, com.google.android.gms.internal.measurement.zzg r11, java.util.List r12, boolean r13) {
        /*
            r0 = -1
            java.lang.String r1 = "reduce"
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzb(r1, r2, r12)
            r3 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r1, r3, r12)
            r1 = 0
            java.lang.Object r4 = r12.get(r1)
            com.google.android.gms.internal.measurement.zzao r4 = (com.google.android.gms.internal.measurement.zzao) r4
            com.google.android.gms.internal.measurement.zzao r4 = r11.zza(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzai
            if (r5 == 0) goto L_0x009d
            int r5 = r12.size()
            if (r5 != r3) goto L_0x0037
            java.lang.Object r12 = r12.get(r2)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            com.google.android.gms.internal.measurement.zzao r12 = r11.zza(r12)
            boolean r5 = r12 instanceof com.google.android.gms.internal.measurement.zzag
            if (r5 != 0) goto L_0x002f
            goto L_0x003e
        L_0x002f:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Failed to parse initial value"
            r10.<init>(r11)
            throw r10
        L_0x0037:
            int r12 = r10.zzh()
            if (r12 == 0) goto L_0x0095
            r12 = 0
        L_0x003e:
            com.google.android.gms.internal.measurement.zzai r4 = (com.google.android.gms.internal.measurement.zzai) r4
            int r5 = r10.zzh()
            if (r13 == 0) goto L_0x0048
            r6 = r1
            goto L_0x004a
        L_0x0048:
            int r6 = r5 + -1
        L_0x004a:
            if (r13 == 0) goto L_0x004e
            int r5 = r5 + r0
            goto L_0x004f
        L_0x004e:
            r5 = r1
        L_0x004f:
            if (r2 == r13) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r0 = r2
        L_0x0053:
            if (r12 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzao r12 = r10.zzl(r6)
        L_0x0059:
            int r6 = r6 + r0
        L_0x005a:
            int r13 = r5 - r6
            int r13 = r13 * r0
            if (r13 < 0) goto L_0x0094
            boolean r13 = r10.zzo(r6)
            if (r13 == 0) goto L_0x0059
            com.google.android.gms.internal.measurement.zzao r13 = r10.zzl(r6)
            double r7 = (double) r6
            com.google.android.gms.internal.measurement.zzah r9 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r9.<init>(r7)
            r7 = 4
            com.google.android.gms.internal.measurement.zzao[] r7 = new com.google.android.gms.internal.measurement.zzao[r7]
            r7[r1] = r12
            r7[r2] = r13
            r7[r3] = r9
            r12 = 3
            r7[r12] = r10
            java.util.List r12 = java.util.Arrays.asList(r7)
            com.google.android.gms.internal.measurement.zzao r12 = r4.zza(r11, r12)
            boolean r13 = r12 instanceof com.google.android.gms.internal.measurement.zzag
            if (r13 != 0) goto L_0x008c
            goto L_0x0059
        L_0x008c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Reduce operation failed"
            r10.<init>(r11)
            throw r10
        L_0x0094:
            return r12
        L_0x0095:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Empty array with no initial value error"
            r10.<init>(r11)
            throw r10
        L_0x009d:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Callback should be a method"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzba.zzb(com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List, boolean):com.google.android.gms.internal.measurement.zzao");
    }

    private static zzae zzc(zzae zzae, zzg zzg, zzai zzai, Boolean bool, Boolean bool2) {
        zzae zzae2 = new zzae();
        Iterator zzg2 = zzae.zzg();
        while (zzg2.hasNext()) {
            int intValue = ((Integer) zzg2.next()).intValue();
            if (zzae.zzo(intValue)) {
                zzao zza = zzai.zza(zzg, Arrays.asList(new zzao[]{zzae.zzl(intValue), new zzah(Double.valueOf((double) intValue)), zzae}));
                if (zza.zze().equals(bool)) {
                    break;
                } else if (bool2 == null || zza.zze().equals(bool2)) {
                    zzae2.zzn(intValue, zza);
                }
            }
        }
        return zzae2;
    }
}
