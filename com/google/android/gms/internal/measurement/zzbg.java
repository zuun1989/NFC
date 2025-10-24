package com.google.android.gms.internal.measurement;

import java.util.Iterator;

public final class zzbg extends zzav {
    public zzbg() {
        this.zza.add(zzbk.FOR_IN);
        this.zza.add(zzbk.FOR_IN_CONST);
        this.zza.add(zzbk.FOR_IN_LET);
        this.zza.add(zzbk.FOR_LET);
        this.zza.add(zzbk.FOR_OF);
        this.zza.add(zzbk.FOR_OF_CONST);
        this.zza.add(zzbk.FOR_OF_LET);
        this.zza.add(zzbk.WHILE);
    }

    private static zzao zzc(zzbe zzbe, zzao zzao, zzao zzao2) {
        return zze(zzbe, zzao.zzf(), zzao2);
    }

    private static zzao zzd(zzbe zzbe, zzao zzao, zzao zzao2) {
        if (zzao instanceof Iterable) {
            return zze(zzbe, ((Iterable) zzao).iterator(), zzao2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    private static zzao zze(zzbe zzbe, Iterator it, zzao zzao) {
        if (it != null) {
            while (it.hasNext()) {
                zzao zzb = zzbe.zza((zzao) it.next()).zzb((zzae) zzao);
                if (zzb instanceof zzag) {
                    zzag zzag = (zzag) zzb;
                    if ("break".equals(zzag.zzg())) {
                        return zzao.zzf;
                    }
                    if ("return".equals(zzag.zzg())) {
                        return zzag;
                    }
                }
            }
        }
        return zzao.zzf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02b0, code lost:
        if ("return".equals(r1.zzg()) != false) goto L_0x02b2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzao zza(java.lang.String r12, com.google.android.gms.internal.measurement.zzg r13, java.util.List r14) {
        /*
            r11 = this;
            r0 = 1
            com.google.android.gms.internal.measurement.zzbk r1 = com.google.android.gms.internal.measurement.zzbk.ADD
            com.google.android.gms.internal.measurement.zzbk r1 = com.google.android.gms.internal.measurement.zzh.zze(r12)
            int r1 = r1.ordinal()
            r2 = 65
            r3 = 4
            java.lang.String r4 = "return"
            java.lang.String r5 = "break"
            r6 = 3
            r7 = 2
            r8 = 0
            if (r1 == r2) goto L_0x025a
            switch(r1) {
                case 26: goto L_0x0218;
                case 27: goto L_0x01d6;
                case 28: goto L_0x0194;
                case 29: goto L_0x00e6;
                case 30: goto L_0x00a4;
                case 31: goto L_0x0062;
                case 32: goto L_0x0020;
                default: goto L_0x001a;
            }
        L_0x001a:
            com.google.android.gms.internal.measurement.zzao r12 = super.zzb(r12)
            goto L_0x02ed
        L_0x0020:
            com.google.android.gms.internal.measurement.zzbk r12 = com.google.android.gms.internal.measurement.zzbk.FOR_OF_LET
            java.lang.String r12 = r12.name()
            com.google.android.gms.internal.measurement.zzh.zza(r12, r6, r14)
            java.lang.Object r12 = r14.get(r8)
            boolean r12 = r12 instanceof com.google.android.gms.internal.measurement.zzas
            if (r12 == 0) goto L_0x005a
            java.lang.Object r12 = r14.get(r8)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            java.lang.String r12 = r12.zzc()
            java.lang.Object r0 = r14.get(r0)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r13.zza(r0)
            java.lang.Object r14 = r14.get(r7)
            com.google.android.gms.internal.measurement.zzao r14 = (com.google.android.gms.internal.measurement.zzao) r14
            com.google.android.gms.internal.measurement.zzao r14 = r13.zza(r14)
            com.google.android.gms.internal.measurement.zzbd r1 = new com.google.android.gms.internal.measurement.zzbd
            r1.<init>(r13, r12)
            com.google.android.gms.internal.measurement.zzao r12 = zzd(r1, r0, r14)
            goto L_0x02ed
        L_0x005a:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Variable name in FOR_OF_LET must be a string"
            r12.<init>(r13)
            throw r12
        L_0x0062:
            com.google.android.gms.internal.measurement.zzbk r12 = com.google.android.gms.internal.measurement.zzbk.FOR_OF_CONST
            java.lang.String r12 = r12.name()
            com.google.android.gms.internal.measurement.zzh.zza(r12, r6, r14)
            java.lang.Object r12 = r14.get(r8)
            boolean r12 = r12 instanceof com.google.android.gms.internal.measurement.zzas
            if (r12 == 0) goto L_0x009c
            java.lang.Object r12 = r14.get(r8)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            java.lang.String r12 = r12.zzc()
            java.lang.Object r0 = r14.get(r0)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r13.zza(r0)
            java.lang.Object r14 = r14.get(r7)
            com.google.android.gms.internal.measurement.zzao r14 = (com.google.android.gms.internal.measurement.zzao) r14
            com.google.android.gms.internal.measurement.zzao r14 = r13.zza(r14)
            com.google.android.gms.internal.measurement.zzbc r1 = new com.google.android.gms.internal.measurement.zzbc
            r1.<init>(r13, r12)
            com.google.android.gms.internal.measurement.zzao r12 = zzd(r1, r0, r14)
            goto L_0x02ed
        L_0x009c:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Variable name in FOR_OF_CONST must be a string"
            r12.<init>(r13)
            throw r12
        L_0x00a4:
            com.google.android.gms.internal.measurement.zzbk r12 = com.google.android.gms.internal.measurement.zzbk.FOR_OF
            java.lang.String r12 = r12.name()
            com.google.android.gms.internal.measurement.zzh.zza(r12, r6, r14)
            java.lang.Object r12 = r14.get(r8)
            boolean r12 = r12 instanceof com.google.android.gms.internal.measurement.zzas
            if (r12 == 0) goto L_0x00de
            java.lang.Object r12 = r14.get(r8)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            java.lang.String r12 = r12.zzc()
            java.lang.Object r0 = r14.get(r0)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r13.zza(r0)
            java.lang.Object r14 = r14.get(r7)
            com.google.android.gms.internal.measurement.zzao r14 = (com.google.android.gms.internal.measurement.zzao) r14
            com.google.android.gms.internal.measurement.zzao r14 = r13.zza(r14)
            com.google.android.gms.internal.measurement.zzbf r1 = new com.google.android.gms.internal.measurement.zzbf
            r1.<init>(r13, r12)
            com.google.android.gms.internal.measurement.zzao r12 = zzd(r1, r0, r14)
            goto L_0x02ed
        L_0x00de:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Variable name in FOR_OF must be a string"
            r12.<init>(r13)
            throw r12
        L_0x00e6:
            com.google.android.gms.internal.measurement.zzbk r12 = com.google.android.gms.internal.measurement.zzbk.FOR_LET
            java.lang.String r12 = r12.name()
            com.google.android.gms.internal.measurement.zzh.zza(r12, r3, r14)
            java.lang.Object r12 = r14.get(r8)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            com.google.android.gms.internal.measurement.zzao r12 = r13.zza(r12)
            boolean r1 = r12 instanceof com.google.android.gms.internal.measurement.zzae
            if (r1 == 0) goto L_0x018c
            com.google.android.gms.internal.measurement.zzae r12 = (com.google.android.gms.internal.measurement.zzae) r12
            java.lang.Object r1 = r14.get(r0)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            java.lang.Object r2 = r14.get(r7)
            com.google.android.gms.internal.measurement.zzao r2 = (com.google.android.gms.internal.measurement.zzao) r2
            java.lang.Object r14 = r14.get(r6)
            com.google.android.gms.internal.measurement.zzao r14 = (com.google.android.gms.internal.measurement.zzao) r14
            com.google.android.gms.internal.measurement.zzao r14 = r13.zza(r14)
            com.google.android.gms.internal.measurement.zzg r3 = r13.zzc()
            r6 = r8
        L_0x011a:
            int r7 = r12.zzh()
            if (r6 >= r7) goto L_0x0131
            com.google.android.gms.internal.measurement.zzao r7 = r12.zzl(r6)
            java.lang.String r7 = r7.zzc()
            com.google.android.gms.internal.measurement.zzao r9 = r13.zzh(r7)
            r3.zze(r7, r9)
            int r6 = r6 + r0
            goto L_0x011a
        L_0x0131:
            com.google.android.gms.internal.measurement.zzao r6 = r13.zza(r1)
            java.lang.Boolean r6 = r6.zze()
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0188
            r6 = r14
            com.google.android.gms.internal.measurement.zzae r6 = (com.google.android.gms.internal.measurement.zzae) r6
            com.google.android.gms.internal.measurement.zzao r6 = r13.zzb(r6)
            boolean r7 = r6 instanceof com.google.android.gms.internal.measurement.zzag
            if (r7 == 0) goto L_0x0167
            com.google.android.gms.internal.measurement.zzag r6 = (com.google.android.gms.internal.measurement.zzag) r6
            java.lang.String r7 = r6.zzg()
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x015a
            com.google.android.gms.internal.measurement.zzao r12 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x02ed
        L_0x015a:
            java.lang.String r7 = r6.zzg()
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L_0x0167
            r12 = r6
            goto L_0x02ed
        L_0x0167:
            com.google.android.gms.internal.measurement.zzg r6 = r13.zzc()
            r7 = r8
        L_0x016c:
            int r9 = r12.zzh()
            if (r7 >= r9) goto L_0x0183
            com.google.android.gms.internal.measurement.zzao r9 = r12.zzl(r7)
            java.lang.String r9 = r9.zzc()
            com.google.android.gms.internal.measurement.zzao r10 = r3.zzh(r9)
            r6.zze(r9, r10)
            int r7 = r7 + r0
            goto L_0x016c
        L_0x0183:
            r6.zza(r2)
            r3 = r6
            goto L_0x0131
        L_0x0188:
            com.google.android.gms.internal.measurement.zzao r12 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x02ed
        L_0x018c:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Initializer variables in FOR_LET must be an ArrayList"
            r12.<init>(r13)
            throw r12
        L_0x0194:
            com.google.android.gms.internal.measurement.zzbk r12 = com.google.android.gms.internal.measurement.zzbk.FOR_IN_LET
            java.lang.String r12 = r12.name()
            com.google.android.gms.internal.measurement.zzh.zza(r12, r6, r14)
            java.lang.Object r12 = r14.get(r8)
            boolean r12 = r12 instanceof com.google.android.gms.internal.measurement.zzas
            if (r12 == 0) goto L_0x01ce
            java.lang.Object r12 = r14.get(r8)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            java.lang.String r12 = r12.zzc()
            java.lang.Object r0 = r14.get(r0)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r13.zza(r0)
            java.lang.Object r14 = r14.get(r7)
            com.google.android.gms.internal.measurement.zzao r14 = (com.google.android.gms.internal.measurement.zzao) r14
            com.google.android.gms.internal.measurement.zzao r14 = r13.zza(r14)
            com.google.android.gms.internal.measurement.zzbd r1 = new com.google.android.gms.internal.measurement.zzbd
            r1.<init>(r13, r12)
            com.google.android.gms.internal.measurement.zzao r12 = zzc(r1, r0, r14)
            goto L_0x02ed
        L_0x01ce:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Variable name in FOR_IN_LET must be a string"
            r12.<init>(r13)
            throw r12
        L_0x01d6:
            com.google.android.gms.internal.measurement.zzbk r12 = com.google.android.gms.internal.measurement.zzbk.FOR_IN_CONST
            java.lang.String r12 = r12.name()
            com.google.android.gms.internal.measurement.zzh.zza(r12, r6, r14)
            java.lang.Object r12 = r14.get(r8)
            boolean r12 = r12 instanceof com.google.android.gms.internal.measurement.zzas
            if (r12 == 0) goto L_0x0210
            java.lang.Object r12 = r14.get(r8)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            java.lang.String r12 = r12.zzc()
            java.lang.Object r0 = r14.get(r0)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r13.zza(r0)
            java.lang.Object r14 = r14.get(r7)
            com.google.android.gms.internal.measurement.zzao r14 = (com.google.android.gms.internal.measurement.zzao) r14
            com.google.android.gms.internal.measurement.zzao r14 = r13.zza(r14)
            com.google.android.gms.internal.measurement.zzbc r1 = new com.google.android.gms.internal.measurement.zzbc
            r1.<init>(r13, r12)
            com.google.android.gms.internal.measurement.zzao r12 = zzc(r1, r0, r14)
            goto L_0x02ed
        L_0x0210:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Variable name in FOR_IN_CONST must be a string"
            r12.<init>(r13)
            throw r12
        L_0x0218:
            com.google.android.gms.internal.measurement.zzbk r12 = com.google.android.gms.internal.measurement.zzbk.FOR_IN
            java.lang.String r12 = r12.name()
            com.google.android.gms.internal.measurement.zzh.zza(r12, r6, r14)
            java.lang.Object r12 = r14.get(r8)
            boolean r12 = r12 instanceof com.google.android.gms.internal.measurement.zzas
            if (r12 == 0) goto L_0x0252
            java.lang.Object r12 = r14.get(r8)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            java.lang.String r12 = r12.zzc()
            java.lang.Object r0 = r14.get(r0)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r13.zza(r0)
            java.lang.Object r14 = r14.get(r7)
            com.google.android.gms.internal.measurement.zzao r14 = (com.google.android.gms.internal.measurement.zzao) r14
            com.google.android.gms.internal.measurement.zzao r14 = r13.zza(r14)
            com.google.android.gms.internal.measurement.zzbf r1 = new com.google.android.gms.internal.measurement.zzbf
            r1.<init>(r13, r12)
            com.google.android.gms.internal.measurement.zzao r12 = zzc(r1, r0, r14)
            goto L_0x02ed
        L_0x0252:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Variable name in FOR_IN must be a string"
            r12.<init>(r13)
            throw r12
        L_0x025a:
            com.google.android.gms.internal.measurement.zzbk r12 = com.google.android.gms.internal.measurement.zzbk.WHILE
            java.lang.String r12 = r12.name()
            com.google.android.gms.internal.measurement.zzh.zza(r12, r3, r14)
            java.lang.Object r12 = r14.get(r8)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            java.lang.Object r0 = r14.get(r0)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            java.lang.Object r1 = r14.get(r7)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            java.lang.Object r14 = r14.get(r6)
            com.google.android.gms.internal.measurement.zzao r14 = (com.google.android.gms.internal.measurement.zzao) r14
            com.google.android.gms.internal.measurement.zzao r14 = r13.zza(r14)
            com.google.android.gms.internal.measurement.zzao r1 = r13.zza(r1)
            java.lang.Boolean r1 = r1.zze()
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x028e
            goto L_0x02b4
        L_0x028e:
            r1 = r14
            com.google.android.gms.internal.measurement.zzae r1 = (com.google.android.gms.internal.measurement.zzae) r1
            com.google.android.gms.internal.measurement.zzao r1 = r13.zzb(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r2 == 0) goto L_0x02b4
            com.google.android.gms.internal.measurement.zzag r1 = (com.google.android.gms.internal.measurement.zzag) r1
            java.lang.String r2 = r1.zzg()
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x02a8
            com.google.android.gms.internal.measurement.zzao r12 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x02ed
        L_0x02a8:
            java.lang.String r2 = r1.zzg()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x02b4
        L_0x02b2:
            r12 = r1
            goto L_0x02ed
        L_0x02b4:
            com.google.android.gms.internal.measurement.zzao r1 = r13.zza(r12)
            java.lang.Boolean r1 = r1.zze()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x02eb
            r1 = r14
            com.google.android.gms.internal.measurement.zzae r1 = (com.google.android.gms.internal.measurement.zzae) r1
            com.google.android.gms.internal.measurement.zzao r1 = r13.zzb(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r2 == 0) goto L_0x02e7
            com.google.android.gms.internal.measurement.zzag r1 = (com.google.android.gms.internal.measurement.zzag) r1
            java.lang.String r2 = r1.zzg()
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x02dc
            com.google.android.gms.internal.measurement.zzao r12 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x02ed
        L_0x02dc:
            java.lang.String r2 = r1.zzg()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x02e7
            goto L_0x02b2
        L_0x02e7:
            r13.zza(r0)
            goto L_0x02b4
        L_0x02eb:
            com.google.android.gms.internal.measurement.zzao r12 = com.google.android.gms.internal.measurement.zzao.zzf
        L_0x02ed:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbg.zza(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzao");
    }
}
