package com.google.android.gms.internal.clearcut;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzei<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzgu;
    private final int zzol;
    /* access modifiers changed from: private */
    public List<zzep> zzom;
    /* access modifiers changed from: private */
    public Map<K, V> zzon;
    private volatile zzer zzoo;
    /* access modifiers changed from: private */
    public Map<K, V> zzop;
    private volatile zzel zzoq;

    private zzei(int i) {
        this.zzol = i;
        this.zzom = Collections.emptyList();
        this.zzon = Collections.emptyMap();
        this.zzop = Collections.emptyMap();
    }

    private final int zza(K k) {
        int i;
        int size = this.zzom.size();
        int i2 = size - 1;
        if (i2 >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzom.get(i2).getKey());
            if (compareTo > 0) {
                i = size + 1;
                return -i;
            } else if (compareTo == 0) {
                return i2;
            }
        }
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzom.get(i4).getKey());
            if (compareTo2 < 0) {
                i2 = i4 - 1;
            } else if (compareTo2 <= 0) {
                return i4;
            } else {
                i3 = i4 + 1;
            }
        }
        i = i3 + 1;
        return -i;
    }

    public static <FieldDescriptorType extends zzca<FieldDescriptorType>> zzei<FieldDescriptorType, Object> zzaj(int i) {
        return new zzej(i);
    }

    /* access modifiers changed from: private */
    public final V zzal(int i) {
        zzdu();
        V value = this.zzom.remove(i).getValue();
        if (!this.zzon.isEmpty()) {
            Iterator it = zzdv().entrySet().iterator();
            this.zzom.add(new zzep(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void zzdu() {
        if (this.zzgu) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzdv() {
        zzdu();
        if (this.zzon.isEmpty() && !(this.zzon instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzon = treeMap;
            this.zzop = treeMap.descendingMap();
        }
        return (SortedMap) this.zzon;
    }

    public void clear() {
        zzdu();
        if (!this.zzom.isEmpty()) {
            this.zzom.clear();
        }
        if (!this.zzon.isEmpty()) {
            this.zzon.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzon.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzoo == null) {
            this.zzoo = new zzer(this, (zzej) null);
        }
        return this.zzoo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzei)) {
            return super.equals(obj);
        }
        zzei zzei = (zzei) obj;
        int size = size();
        if (size != zzei.size()) {
            return false;
        }
        int zzdr = zzdr();
        if (zzdr != zzei.zzdr()) {
            return entrySet().equals(zzei.entrySet());
        }
        for (int i = 0; i < zzdr; i++) {
            if (!zzak(i).equals(zzei.zzak(i))) {
                return false;
            }
        }
        if (zzdr != size) {
            return this.zzon.equals(zzei.zzon);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? this.zzom.get(zza).getValue() : this.zzon.get(comparable);
    }

    public int hashCode() {
        int zzdr = zzdr();
        int i = 0;
        for (int i2 = 0; i2 < zzdr; i2++) {
            i += this.zzom.get(i2).hashCode();
        }
        return this.zzon.size() > 0 ? i + this.zzon.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzgu;
    }

    public V remove(Object obj) {
        zzdu();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzal(zza);
        }
        if (this.zzon.isEmpty()) {
            return null;
        }
        return this.zzon.remove(comparable);
    }

    public int size() {
        return this.zzom.size() + this.zzon.size();
    }

    public final Map.Entry<K, V> zzak(int i) {
        return this.zzom.get(i);
    }

    public final int zzdr() {
        return this.zzom.size();
    }

    public final Iterable<Map.Entry<K, V>> zzds() {
        return this.zzon.isEmpty() ? zzem.zzdx() : this.zzon.entrySet();
    }

    public final Set<Map.Entry<K, V>> zzdt() {
        if (this.zzoq == null) {
            this.zzoq = new zzel(this, (zzej) null);
        }
        return this.zzoq;
    }

    public void zzv() {
        if (!this.zzgu) {
            this.zzon = this.zzon.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzon);
            this.zzop = this.zzop.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzop);
            this.zzgu = true;
        }
    }

    public /* synthetic */ zzei(int i, zzej zzej) {
        this(i);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzdu();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzom.get(zza).setValue(v);
        }
        zzdu();
        if (this.zzom.isEmpty() && !(this.zzom instanceof ArrayList)) {
            this.zzom = new ArrayList(this.zzol);
        }
        int i = -(zza + 1);
        if (i >= this.zzol) {
            return zzdv().put(k, v);
        }
        int size = this.zzom.size();
        int i2 = this.zzol;
        if (size == i2) {
            zzep remove = this.zzom.remove(i2 - 1);
            zzdv().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzom.add(i, new zzep(this, k, v));
        return null;
    }
}
