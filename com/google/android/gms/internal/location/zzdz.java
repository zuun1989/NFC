package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzad;
import com.google.android.gms.location.zzo;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import w0.k;

public final class zzdz extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final k zzf = new k();
    private final k zzg = new k();
    private final k zzh = new k();
    private final k zzi = new k();

    public zzdz(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 23, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    private final boolean zzG(Feature feature) {
        Feature feature2;
        Feature[] availableFeatures = getAvailableFeatures();
        if (availableFeatures != null) {
            int i = 0;
            while (true) {
                if (i >= availableFeatures.length) {
                    feature2 = null;
                    break;
                }
                feature2 = availableFeatures[i];
                if (feature.getName().equals(feature2.getName())) {
                    break;
                }
                i++;
            }
            if (feature2 != null && feature2.getVersion() >= feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (queryLocalInterface instanceof zzv) {
            return (zzv) queryLocalInterface;
        }
        return new zzu(iBinder);
    }

    public final Feature[] getApiFeatures() {
        return zzo.zzp;
    }

    public final int getMinApkVersion() {
        return 11717000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    public final void onConnectionSuspended(int i) {
        super.onConnectionSuspended(i);
        synchronized (this.zzf) {
            this.zzf.clear();
        }
        synchronized (this.zzg) {
            this.zzg.clear();
        }
        synchronized (this.zzh) {
            this.zzh.clear();
        }
    }

    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(Location location, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzh)) {
            ((zzv) getService()).zzB(location, new zzdj((Object) null, taskCompletionSource));
            return;
        }
        ((zzv) getService()).zzA(location);
        taskCompletionSource.setResult((Object) null);
    }

    public final void zzB(TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzv) getService()).zzC(new zzdn((Object) null, taskCompletionSource));
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.IBinder] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzC(com.google.android.gms.common.api.internal.ListenerHolder r6, com.google.android.gms.location.DeviceOrientationRequest r7, com.google.android.gms.tasks.TaskCompletionSource r8) throws android.os.RemoteException {
        /*
            r5 = this;
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey r0 = r6.getListenerKey()
            java.util.Objects.requireNonNull(r0)
            w0.k r1 = r5.zzh
            monitor-enter(r1)
            w0.k r2 = r5.zzh     // Catch:{ all -> 0x001f }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x001f }
            com.google.android.gms.internal.location.zzdq r2 = (com.google.android.gms.internal.location.zzdq) r2     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0021
            com.google.android.gms.internal.location.zzdq r2 = new com.google.android.gms.internal.location.zzdq     // Catch:{ all -> 0x001f }
            r2.<init>(r6)     // Catch:{ all -> 0x001f }
            w0.k r6 = r5.zzh     // Catch:{ all -> 0x001f }
            r6.put(r0, r2)     // Catch:{ all -> 0x001f }
            goto L_0x0024
        L_0x001f:
            r6 = move-exception
            goto L_0x0042
        L_0x0021:
            r2.zzc(r6)     // Catch:{ all -> 0x001f }
        L_0x0024:
            android.os.IInterface r6 = r5.getService()     // Catch:{ all -> 0x001f }
            com.google.android.gms.internal.location.zzv r6 = (com.google.android.gms.internal.location.zzv) r6     // Catch:{ all -> 0x001f }
            com.google.android.gms.internal.location.zzh r0 = new com.google.android.gms.internal.location.zzh     // Catch:{ all -> 0x001f }
            java.util.List r3 = com.google.android.gms.internal.location.zzh.zza     // Catch:{ all -> 0x001f }
            r4 = 0
            r0.<init>(r7, r3, r4)     // Catch:{ all -> 0x001f }
            com.google.android.gms.internal.location.zzdn r7 = new com.google.android.gms.internal.location.zzdn     // Catch:{ all -> 0x001f }
            r7.<init>(r4, r8)     // Catch:{ all -> 0x001f }
            com.google.android.gms.internal.location.zzj r8 = new com.google.android.gms.internal.location.zzj     // Catch:{ all -> 0x001f }
            r3 = 1
            r8.<init>(r3, r0, r2, r7)     // Catch:{ all -> 0x001f }
            r6.zzF(r8)     // Catch:{ all -> 0x001f }
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            return
        L_0x0042:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdz.zzC(com.google.android.gms.common.api.internal.ListenerHolder, com.google.android.gms.location.DeviceOrientationRequest, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* JADX WARNING: type inference failed for: r6v3, types: [com.google.android.gms.internal.location.zzdq, android.os.IBinder] */
    public final void zzD(ListenerHolder.ListenerKey listenerKey, TaskCompletionSource taskCompletionSource) throws RemoteException {
        synchronized (this.zzh) {
            try {
                ? r6 = (zzdq) this.zzh.remove(listenerKey);
                if (r6 == 0) {
                    taskCompletionSource.setResult(Boolean.FALSE);
                    return;
                }
                r6.zze();
                ((zzv) getService()).zzF(new zzj(2, (zzh) null, r6, new zzdn(Boolean.TRUE, taskCompletionSource)));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzE(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzn)) {
            ((zzv) getService()).zze(geofencingRequest, pendingIntent, new zzdj((Object) null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzd(geofencingRequest, pendingIntent, new zzdg(taskCompletionSource));
        }
    }

    public final void zzF(zzem zzem, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzn)) {
            ((zzv) getService()).zzg(zzem, new zzdj((Object) null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzf(zzem, new zzdg(taskCompletionSource));
        }
    }

    public final void zzp(zzad zzad, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzj)) {
            ((zzv) getService()).zzo(zzad, new zzee(5, (IBinder) null, new zzdl(taskCompletionSource), (PendingIntent) null, (String) null));
        } else {
            taskCompletionSource.setResult(((zzv) getService()).zzp(getContext().getPackageName()));
        }
    }

    public final void zzq(LastLocationRequest lastLocationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzj)) {
            ((zzv) getService()).zzq(lastLocationRequest, zzee.zzd(new zzdk(taskCompletionSource)));
        } else if (zzG(zzo.zzf)) {
            ((zzv) getService()).zzr(lastLocationRequest, new zzdk(taskCompletionSource));
        } else {
            taskCompletionSource.setResult(((zzv) getService()).zzs());
        }
    }

    public final void zzr(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzj)) {
            ICancelToken zzt = ((zzv) getService()).zzt(currentLocationRequest, zzee.zzd(new zzdk(taskCompletionSource)));
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new zzed(zzt));
            }
        } else if (zzG(zzo.zze)) {
            ICancelToken zzu = ((zzv) getService()).zzu(currentLocationRequest, new zzdk(taskCompletionSource));
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new zzeb(zzu));
            }
        } else {
            ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(new zzdh(this, taskCompletionSource), zzfc.zza(), "GetCurrentLocation");
            ListenerHolder.ListenerKey listenerKey = createListenerHolder.getListenerKey();
            Objects.requireNonNull(listenerKey);
            zzdi zzdi = new zzdi(this, createListenerHolder, taskCompletionSource);
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            LocationRequest.Builder builder = new LocationRequest.Builder(currentLocationRequest.getPriority(), 0);
            builder.setMinUpdateIntervalMillis(0);
            builder.setDurationMillis(currentLocationRequest.getDurationMillis());
            builder.setGranularity(currentLocationRequest.getGranularity());
            builder.setMaxUpdateAgeMillis(currentLocationRequest.getMaxUpdateAgeMillis());
            builder.zzb(currentLocationRequest.zza());
            builder.zza(currentLocationRequest.zzb());
            builder.setWaitForAccurateLocation(true);
            builder.zzc(currentLocationRequest.zzc());
            zzt(zzdi, builder.build(), taskCompletionSource2);
            taskCompletionSource2.getTask().addOnCompleteListener(new zzea(taskCompletionSource));
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new zzec(this, listenerKey));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f A[Catch:{ all -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056 A[Catch:{ all -> 0x002e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzs(com.google.android.gms.internal.location.zzdr r18, com.google.android.gms.location.LocationRequest r19, com.google.android.gms.tasks.TaskCompletionSource r20) throws android.os.RemoteException {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.ListenerHolder r3 = r18.zza()
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey r4 = r3.getListenerKey()
            java.util.Objects.requireNonNull(r4)
            com.google.android.gms.common.Feature r5 = com.google.android.gms.location.zzo.zzj
            boolean r5 = r1.zzG(r5)
            w0.k r6 = r1.zzf
            monitor-enter(r6)
            w0.k r7 = r1.zzf     // Catch:{ all -> 0x002e }
            java.lang.Object r7 = r7.get(r4)     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzdy r7 = (com.google.android.gms.internal.location.zzdy) r7     // Catch:{ all -> 0x002e }
            r8 = 0
            if (r7 == 0) goto L_0x0030
            if (r5 == 0) goto L_0x0028
            goto L_0x0030
        L_0x0028:
            r7.zzc(r3)     // Catch:{ all -> 0x002e }
            r12 = r7
            r7 = r8
            goto L_0x003d
        L_0x002e:
            r0 = move-exception
            goto L_0x0077
        L_0x0030:
            com.google.android.gms.internal.location.zzdy r3 = new com.google.android.gms.internal.location.zzdy     // Catch:{ all -> 0x002e }
            r9 = r18
            r3.<init>(r9)     // Catch:{ all -> 0x002e }
            w0.k r9 = r1.zzf     // Catch:{ all -> 0x002e }
            r9.put(r4, r3)     // Catch:{ all -> 0x002e }
            r12 = r3
        L_0x003d:
            if (r5 == 0) goto L_0x0056
            android.os.IInterface r3 = r17.getService()     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.location.zzv) r3     // Catch:{ all -> 0x002e }
            java.lang.String r4 = r4.toIdString()     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzee r4 = com.google.android.gms.internal.location.zzee.zza(r7, r12, r4)     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzdj r5 = new com.google.android.gms.internal.location.zzdj     // Catch:{ all -> 0x002e }
            r5.<init>(r8, r2)     // Catch:{ all -> 0x002e }
            r3.zzw(r4, r0, r5)     // Catch:{ all -> 0x002e }
            goto L_0x0075
        L_0x0056:
            android.os.IInterface r3 = r17.getService()     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.location.zzv) r3     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzeg r11 = com.google.android.gms.internal.location.zzeg.zza(r8, r0)     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzdo r15 = new com.google.android.gms.internal.location.zzdo     // Catch:{ all -> 0x002e }
            r15.<init>(r2, r12)     // Catch:{ all -> 0x002e }
            java.lang.String r16 = r4.toIdString()     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzei r0 = new com.google.android.gms.internal.location.zzei     // Catch:{ all -> 0x002e }
            r13 = 0
            r14 = 0
            r10 = 1
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x002e }
            r3.zzv(r0)     // Catch:{ all -> 0x002e }
        L_0x0075:
            monitor-exit(r6)     // Catch:{ all -> 0x002e }
            return
        L_0x0077:
            monitor-exit(r6)     // Catch:{ all -> 0x002e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdz.zzs(com.google.android.gms.internal.location.zzdr, com.google.android.gms.location.LocationRequest, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f A[Catch:{ all -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056 A[Catch:{ all -> 0x002e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzt(com.google.android.gms.internal.location.zzdr r18, com.google.android.gms.location.LocationRequest r19, com.google.android.gms.tasks.TaskCompletionSource r20) throws android.os.RemoteException {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.ListenerHolder r3 = r18.zza()
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey r4 = r3.getListenerKey()
            java.util.Objects.requireNonNull(r4)
            com.google.android.gms.common.Feature r5 = com.google.android.gms.location.zzo.zzj
            boolean r5 = r1.zzG(r5)
            w0.k r6 = r1.zzg
            monitor-enter(r6)
            w0.k r7 = r1.zzg     // Catch:{ all -> 0x002e }
            java.lang.Object r7 = r7.get(r4)     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzdv r7 = (com.google.android.gms.internal.location.zzdv) r7     // Catch:{ all -> 0x002e }
            r8 = 0
            if (r7 == 0) goto L_0x0030
            if (r5 == 0) goto L_0x0028
            goto L_0x0030
        L_0x0028:
            r7.zzc(r3)     // Catch:{ all -> 0x002e }
            r13 = r7
            r7 = r8
            goto L_0x003d
        L_0x002e:
            r0 = move-exception
            goto L_0x0077
        L_0x0030:
            com.google.android.gms.internal.location.zzdv r3 = new com.google.android.gms.internal.location.zzdv     // Catch:{ all -> 0x002e }
            r9 = r18
            r3.<init>(r9)     // Catch:{ all -> 0x002e }
            w0.k r9 = r1.zzg     // Catch:{ all -> 0x002e }
            r9.put(r4, r3)     // Catch:{ all -> 0x002e }
            r13 = r3
        L_0x003d:
            if (r5 == 0) goto L_0x0056
            android.os.IInterface r3 = r17.getService()     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.location.zzv) r3     // Catch:{ all -> 0x002e }
            java.lang.String r4 = r4.toIdString()     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzee r4 = com.google.android.gms.internal.location.zzee.zzb(r7, r13, r4)     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzdj r5 = new com.google.android.gms.internal.location.zzdj     // Catch:{ all -> 0x002e }
            r5.<init>(r8, r2)     // Catch:{ all -> 0x002e }
            r3.zzw(r4, r0, r5)     // Catch:{ all -> 0x002e }
            goto L_0x0075
        L_0x0056:
            android.os.IInterface r3 = r17.getService()     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.location.zzv) r3     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzeg r11 = com.google.android.gms.internal.location.zzeg.zza(r8, r0)     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzdd r15 = new com.google.android.gms.internal.location.zzdd     // Catch:{ all -> 0x002e }
            r15.<init>(r2, r13)     // Catch:{ all -> 0x002e }
            java.lang.String r16 = r4.toIdString()     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.location.zzei r0 = new com.google.android.gms.internal.location.zzei     // Catch:{ all -> 0x002e }
            r12 = 0
            r14 = 0
            r10 = 1
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x002e }
            r3.zzv(r0)     // Catch:{ all -> 0x002e }
        L_0x0075:
            monitor-exit(r6)     // Catch:{ all -> 0x002e }
            return
        L_0x0077:
            monitor-exit(r6)     // Catch:{ all -> 0x002e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdz.zzt(com.google.android.gms.internal.location.zzdr, com.google.android.gms.location.LocationRequest, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    public final void zzu(PendingIntent pendingIntent, LocationRequest locationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzj)) {
            ((zzv) getService()).zzw(zzee.zzc(pendingIntent), locationRequest, new zzdj((Object) null, taskCompletionSource));
            return;
        }
        zzeg zza = zzeg.zza((String) null, locationRequest);
        zzdn zzdn = new zzdn((Object) null, taskCompletionSource);
        int hashCode = pendingIntent.hashCode();
        StringBuilder sb2 = new StringBuilder(String.valueOf(hashCode).length() + 14);
        sb2.append("PendingIntent@");
        sb2.append(hashCode);
        ((zzv) getService()).zzv(new zzei(1, zza, (IBinder) null, (IBinder) null, pendingIntent, zzdn, sb2.toString()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzv(com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey r10, boolean r11, com.google.android.gms.tasks.TaskCompletionSource r12) throws android.os.RemoteException {
        /*
            r9 = this;
            w0.k r0 = r9.zzf
            monitor-enter(r0)
            w0.k r1 = r9.zzf     // Catch:{ all -> 0x0015 }
            java.lang.Object r10 = r1.remove(r10)     // Catch:{ all -> 0x0015 }
            r4 = r10
            com.google.android.gms.internal.location.zzdy r4 = (com.google.android.gms.internal.location.zzdy) r4     // Catch:{ all -> 0x0015 }
            if (r4 != 0) goto L_0x0017
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0015 }
            r12.setResult(r10)     // Catch:{ all -> 0x0015 }
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return
        L_0x0015:
            r10 = move-exception
            goto L_0x007c
        L_0x0017:
            r4.zzf()     // Catch:{ all -> 0x0015 }
            if (r11 == 0) goto L_0x0075
            com.google.android.gms.common.Feature r10 = com.google.android.gms.location.zzo.zzj     // Catch:{ all -> 0x0015 }
            boolean r10 = r9.zzG(r10)     // Catch:{ all -> 0x0015 }
            if (r10 == 0) goto L_0x0059
            android.os.IInterface r10 = r9.getService()     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzv r10 = (com.google.android.gms.internal.location.zzv) r10     // Catch:{ all -> 0x0015 }
            java.lang.String r11 = "ILocationListener@"
            int r1 = java.lang.System.identityHashCode(r4)     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0015 }
            int r2 = r2.length()     // Catch:{ all -> 0x0015 }
            int r2 = r2 + 18
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0015 }
            r3.<init>(r2)     // Catch:{ all -> 0x0015 }
            r3.append(r11)     // Catch:{ all -> 0x0015 }
            r3.append(r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r11 = r3.toString()     // Catch:{ all -> 0x0015 }
            r1 = 0
            com.google.android.gms.internal.location.zzee r11 = com.google.android.gms.internal.location.zzee.zza(r1, r4, r11)     // Catch:{ all -> 0x0015 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzdj r2 = new com.google.android.gms.internal.location.zzdj     // Catch:{ all -> 0x0015 }
            r2.<init>(r1, r12)     // Catch:{ all -> 0x0015 }
            r10.zzx(r11, r2)     // Catch:{ all -> 0x0015 }
            goto L_0x007a
        L_0x0059:
            android.os.IInterface r10 = r9.getService()     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzv r10 = (com.google.android.gms.internal.location.zzv) r10     // Catch:{ all -> 0x0015 }
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzdn r7 = new com.google.android.gms.internal.location.zzdn     // Catch:{ all -> 0x0015 }
            r7.<init>(r11, r12)     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzei r11 = new com.google.android.gms.internal.location.zzei     // Catch:{ all -> 0x0015 }
            r6 = 0
            r8 = 0
            r2 = 2
            r3 = 0
            r5 = 0
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0015 }
            r10.zzv(r11)     // Catch:{ all -> 0x0015 }
            goto L_0x007a
        L_0x0075:
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0015 }
            r12.setResult(r10)     // Catch:{ all -> 0x0015 }
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdz.zzv(com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey, boolean, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzw(com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey r10, boolean r11, com.google.android.gms.tasks.TaskCompletionSource r12) throws android.os.RemoteException {
        /*
            r9 = this;
            w0.k r0 = r9.zzg
            monitor-enter(r0)
            w0.k r1 = r9.zzg     // Catch:{ all -> 0x0015 }
            java.lang.Object r10 = r1.remove(r10)     // Catch:{ all -> 0x0015 }
            r5 = r10
            com.google.android.gms.internal.location.zzdv r5 = (com.google.android.gms.internal.location.zzdv) r5     // Catch:{ all -> 0x0015 }
            if (r5 != 0) goto L_0x0017
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0015 }
            r12.setResult(r10)     // Catch:{ all -> 0x0015 }
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return
        L_0x0015:
            r10 = move-exception
            goto L_0x007c
        L_0x0017:
            r5.zzg()     // Catch:{ all -> 0x0015 }
            if (r11 == 0) goto L_0x0075
            com.google.android.gms.common.Feature r10 = com.google.android.gms.location.zzo.zzj     // Catch:{ all -> 0x0015 }
            boolean r10 = r9.zzG(r10)     // Catch:{ all -> 0x0015 }
            if (r10 == 0) goto L_0x0059
            android.os.IInterface r10 = r9.getService()     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzv r10 = (com.google.android.gms.internal.location.zzv) r10     // Catch:{ all -> 0x0015 }
            java.lang.String r11 = "ILocationCallback@"
            int r1 = java.lang.System.identityHashCode(r5)     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0015 }
            int r2 = r2.length()     // Catch:{ all -> 0x0015 }
            int r2 = r2 + 18
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0015 }
            r3.<init>(r2)     // Catch:{ all -> 0x0015 }
            r3.append(r11)     // Catch:{ all -> 0x0015 }
            r3.append(r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r11 = r3.toString()     // Catch:{ all -> 0x0015 }
            r1 = 0
            com.google.android.gms.internal.location.zzee r11 = com.google.android.gms.internal.location.zzee.zzb(r1, r5, r11)     // Catch:{ all -> 0x0015 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzdj r2 = new com.google.android.gms.internal.location.zzdj     // Catch:{ all -> 0x0015 }
            r2.<init>(r1, r12)     // Catch:{ all -> 0x0015 }
            r10.zzx(r11, r2)     // Catch:{ all -> 0x0015 }
            goto L_0x007a
        L_0x0059:
            android.os.IInterface r10 = r9.getService()     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzv r10 = (com.google.android.gms.internal.location.zzv) r10     // Catch:{ all -> 0x0015 }
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzdn r7 = new com.google.android.gms.internal.location.zzdn     // Catch:{ all -> 0x0015 }
            r7.<init>(r11, r12)     // Catch:{ all -> 0x0015 }
            com.google.android.gms.internal.location.zzei r11 = new com.google.android.gms.internal.location.zzei     // Catch:{ all -> 0x0015 }
            r6 = 0
            r8 = 0
            r2 = 2
            r3 = 0
            r4 = 0
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0015 }
            r10.zzv(r11)     // Catch:{ all -> 0x0015 }
            goto L_0x007a
        L_0x0075:
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0015 }
            r12.setResult(r10)     // Catch:{ all -> 0x0015 }
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdz.zzw(com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey, boolean, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    public final void zzx(PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource, Object obj) throws RemoteException {
        if (zzG(zzo.zzj)) {
            ((zzv) getService()).zzx(zzee.zzc(pendingIntent), new zzdj((Object) null, taskCompletionSource));
            return;
        }
        ((zzv) getService()).zzv(new zzei(2, (zzeg) null, (IBinder) null, (IBinder) null, pendingIntent, new zzdn((Object) null, taskCompletionSource), (String) null));
    }

    public final void zzy(TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzg)) {
            ((zzv) getService()).zzz(true, new zzdj((Object) null, taskCompletionSource));
            return;
        }
        ((zzv) getService()).zzy(true);
        taskCompletionSource.setResult((Object) null);
    }

    public final void zzz(TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzg)) {
            ((zzv) getService()).zzz(false, new zzdj(Boolean.TRUE, taskCompletionSource));
            return;
        }
        ((zzv) getService()).zzy(false);
        taskCompletionSource.setResult(Boolean.TRUE);
    }
}
