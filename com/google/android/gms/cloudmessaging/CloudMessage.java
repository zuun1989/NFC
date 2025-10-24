package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Objects;
import w0.a;

@SafeParcelable.Class(creator = "CloudMessageCreator")
public final class CloudMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CloudMessage> CREATOR = new zza();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @SafeParcelable.Field(id = 1)
    final Intent zza;
    private Map zzb;

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public CloudMessage(@SafeParcelable.Param(id = 1) Intent intent) {
        this.zza = intent;
    }

    private static int zzb(String str) {
        if (Objects.equals(str, "high")) {
            return 1;
        }
        if (Objects.equals(str, "normal")) {
            return 2;
        }
        return 0;
    }

    public String getCollapseKey() {
        return this.zza.getStringExtra("collapse_key");
    }

    public synchronized Map<String, String> getData() {
        try {
            if (this.zzb == null) {
                Bundle extras = this.zza.getExtras();
                a aVar = new a();
                if (extras != null) {
                    for (String next : extras.keySet()) {
                        Object obj = extras.get(next);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (!next.startsWith("google.") && !next.equals("from") && !next.equals("message_type") && !next.equals("collapse_key")) {
                                aVar.put(next, str);
                            }
                        }
                    }
                }
                this.zzb = aVar;
            }
        } finally {
            while (true) {
            }
        }
        return this.zzb;
    }

    public String getFrom() {
        return this.zza.getStringExtra("from");
    }

    public Intent getIntent() {
        return this.zza;
    }

    public String getMessageId() {
        String stringExtra = this.zza.getStringExtra("google.message_id");
        if (stringExtra == null) {
            return this.zza.getStringExtra("message_id");
        }
        return stringExtra;
    }

    public String getMessageType() {
        return this.zza.getStringExtra("message_type");
    }

    public int getOriginalPriority() {
        String stringExtra = this.zza.getStringExtra("google.original_priority");
        if (stringExtra == null) {
            stringExtra = this.zza.getStringExtra("google.priority");
        }
        return zzb(stringExtra);
    }

    public int getPriority() {
        String stringExtra = this.zza.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if (Objects.equals(this.zza.getStringExtra("google.priority_reduced"), "1")) {
                return 2;
            }
            stringExtra = this.zza.getStringExtra("google.priority");
        }
        return zzb(stringExtra);
    }

    public byte[] getRawData() {
        return this.zza.getByteArrayExtra("rawData");
    }

    public String getSenderId() {
        return this.zza.getStringExtra("google.c.sender.id");
    }

    public long getSentTime() {
        Object obj;
        Bundle extras = this.zza.getExtras();
        if (extras != null) {
            obj = extras.get("google.sent_time");
        } else {
            obj = null;
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("CloudMessage", "Invalid sent time: ".concat(String.valueOf(obj)));
            return 0;
        }
    }

    public String getTo() {
        return this.zza.getStringExtra("google.to");
    }

    public int getTtl() {
        Object obj;
        Bundle extras = this.zza.getExtras();
        if (extras != null) {
            obj = extras.get("google.ttl");
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("CloudMessage", "Invalid TTL: ".concat(String.valueOf(obj)));
            return 0;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Integer zza() {
        if (this.zza.hasExtra("google.product_id")) {
            return Integer.valueOf(this.zza.getIntExtra("google.product_id", 0));
        }
        return null;
    }
}
