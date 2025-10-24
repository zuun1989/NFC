package com.fis.ekyc.nfc.build_in.eidparser.lds.io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class FragmentBuffer implements Serializable {
    private static final int DEFAULT_SIZE = 2000;
    private static final long serialVersionUID = -3510872461790499721L;
    private byte[] buffer;
    private Collection<Fragment> fragments;

    public static class Fragment implements Serializable {
        private static final long serialVersionUID = -3795931618553980328L;
        /* access modifiers changed from: private */
        public int length;
        /* access modifiers changed from: private */
        public int offset;

        private Fragment(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        public static Fragment getInstance(int i, int i2) {
            return new Fragment(i, i2);
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!obj.getClass().equals(Fragment.class)) {
                return false;
            }
            Fragment fragment = (Fragment) obj;
            if (fragment.offset == this.offset && fragment.length == this.length) {
                return true;
            }
            return false;
        }

        public int getLength() {
            return this.length;
        }

        public int getOffset() {
            return this.offset;
        }

        public int hashCode() {
            return (this.offset * 2) + (this.length * 3) + 5;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.offset);
            sb2.append(" .. ");
            sb2.append((this.offset + this.length) - 1);
            sb2.append(" (");
            sb2.append(this.length);
            sb2.append(")]");
            return sb2.toString();
        }
    }

    public FragmentBuffer() {
        this(2000);
    }

    private void setLength(int i) {
        synchronized (this) {
            try {
                byte[] bArr = this.buffer;
                if (i > bArr.length) {
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.buffer = bArr2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void addFragment(int i, byte b) {
        addFragment(i, new byte[]{b});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0055, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            if (r6 != 0) goto L_0x0006
            monitor-exit(r5)
            return r0
        L_0x0006:
            r1 = 1
            if (r6 != r5) goto L_0x000b
            monitor-exit(r5)
            return r1
        L_0x000b:
            java.lang.Class r2 = r6.getClass()     // Catch:{ all -> 0x0025 }
            java.lang.Class<com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer> r3 = com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer.class
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x0019
            monitor-exit(r5)
            return r0
        L_0x0019:
            com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer r6 = (com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer) r6     // Catch:{ all -> 0x0025 }
            byte[] r2 = r6.buffer     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x0027
            byte[] r3 = r5.buffer     // Catch:{ all -> 0x0025 }
            if (r3 == 0) goto L_0x0027
            monitor-exit(r5)
            return r0
        L_0x0025:
            r6 = move-exception
            goto L_0x0056
        L_0x0027:
            if (r2 == 0) goto L_0x002f
            byte[] r3 = r5.buffer     // Catch:{ all -> 0x0025 }
            if (r3 != 0) goto L_0x002f
            monitor-exit(r5)
            return r0
        L_0x002f:
            java.util.Collection<com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer$Fragment> r3 = r6.fragments     // Catch:{ all -> 0x0025 }
            if (r3 != 0) goto L_0x0039
            java.util.Collection<com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer$Fragment> r4 = r5.fragments     // Catch:{ all -> 0x0025 }
            if (r4 == 0) goto L_0x0039
            monitor-exit(r5)
            return r0
        L_0x0039:
            if (r3 == 0) goto L_0x0041
            java.util.Collection<com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer$Fragment> r3 = r5.fragments     // Catch:{ all -> 0x0025 }
            if (r3 != 0) goto L_0x0041
            monitor-exit(r5)
            return r0
        L_0x0041:
            byte[] r3 = r5.buffer     // Catch:{ all -> 0x0025 }
            boolean r2 = java.util.Arrays.equals(r2, r3)     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0054
            java.util.Collection<com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer$Fragment> r6 = r6.fragments     // Catch:{ all -> 0x0025 }
            java.util.Collection<com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer$Fragment> r2 = r5.fragments     // Catch:{ all -> 0x0025 }
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x0025 }
            if (r6 == 0) goto L_0x0054
            r0 = r1
        L_0x0054:
            monitor-exit(r5)
            return r0
        L_0x0056:
            monitor-exit(r5)     // Catch:{ all -> 0x0025 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.lds.io.FragmentBuffer.equals(java.lang.Object):boolean");
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public synchronized int getBufferedLength(int i) {
        int i2;
        int i3 = 0;
        if (i >= this.buffer.length) {
            return 0;
        }
        for (Fragment next : this.fragments) {
            int offset = next.getOffset();
            int offset2 = next.getOffset() + next.getLength();
            if (offset <= i && i < offset2 && (i2 = offset2 - i) > i3) {
                i3 = i2;
            }
        }
        return i3;
    }

    public synchronized int getBytesBuffered() {
        int i;
        i = 0;
        for (int i2 = 0; i2 < this.buffer.length; i2++) {
            if (isCoveredByFragment(i2)) {
                i++;
            }
        }
        return i;
    }

    public Collection<Fragment> getFragments() {
        return this.fragments;
    }

    public int getLength() {
        int length;
        synchronized (this) {
            length = this.buffer.length;
        }
        return length;
    }

    public synchronized int getPosition() {
        int i;
        i = 0;
        for (int i2 = 0; i2 < this.buffer.length; i2++) {
            if (isCoveredByFragment(i2)) {
                i = i2 + 1;
            }
        }
        return i;
    }

    public synchronized Fragment getSmallestUnbufferedFragment(int i, int i2) {
        int i3;
        try {
            Iterator<Fragment> it = this.fragments.iterator();
            i3 = i;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Fragment next = it.next();
                if (next.getOffset() <= i3 && i3 + i2 <= next.getOffset() + next.getLength()) {
                    i2 = 0;
                    break;
                } else if (next.getOffset() <= i3 && i3 < next.getOffset() + next.getLength()) {
                    int offset = next.getOffset() + next.getLength();
                    i2 = (i3 + i2) - offset;
                    i3 = offset;
                } else if (i3 > next.getOffset() || next.getOffset() + next.getLength() > i3 + i2) {
                    if (i <= next.getOffset() && next.getOffset() < i3 + i2) {
                        i2 = next.getOffset() - i3;
                    }
                }
            }
        } finally {
            while (true) {
            }
        }
        return Fragment.getInstance(i3, i2);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.buffer) * 3) + (this.fragments.hashCode() * 2) + 7;
    }

    public synchronized boolean isCoveredByFragment(int i) {
        return isCoveredByFragment(i, 1);
    }

    public synchronized String toString() {
        return "FragmentBuffer [" + this.buffer.length + ", " + this.fragments + "]";
    }

    public synchronized void updateFrom(FragmentBuffer fragmentBuffer) {
        for (Fragment next : fragmentBuffer.fragments) {
            addFragment(next.offset, fragmentBuffer.buffer, next.offset, next.length);
        }
    }

    public FragmentBuffer(int i) {
        this.buffer = new byte[i];
        this.fragments = new HashSet();
    }

    public synchronized boolean isCoveredByFragment(int i, int i2) {
        for (Fragment next : this.fragments) {
            int offset = next.getOffset();
            int offset2 = next.getOffset() + next.getLength();
            if (offset <= i && i + i2 <= offset2) {
                return true;
            }
        }
        return false;
    }

    public synchronized void addFragment(int i, byte[] bArr) {
        addFragment(i, bArr, 0, bArr.length);
    }

    public synchronized void addFragment(int i, byte[] bArr, int i2, int i3) {
        int i4 = i + i3;
        try {
            byte[] bArr2 = this.buffer;
            if (i4 > bArr2.length) {
                setLength(Math.max(i4, bArr2.length) * 2);
            }
            System.arraycopy(bArr, i2, this.buffer, i, i3);
            for (Fragment fragment : new ArrayList(this.fragments)) {
                if (fragment.getOffset() <= i && i + i3 <= fragment.getOffset() + fragment.getLength()) {
                    return;
                }
                if (fragment.getOffset() <= i && i <= fragment.getOffset() + fragment.getLength()) {
                    i3 = (i + i3) - fragment.getOffset();
                    i = fragment.getOffset();
                    this.fragments.remove(fragment);
                } else if (i <= fragment.getOffset() && fragment.getOffset() + fragment.getLength() <= i + i3) {
                    this.fragments.remove(fragment);
                } else if (i <= fragment.getOffset() && fragment.getOffset() <= i + i3) {
                    i3 = (fragment.getOffset() + fragment.getLength()) - i;
                    this.fragments.remove(fragment);
                }
            }
            this.fragments.add(Fragment.getInstance(i, i3));
        } finally {
            while (true) {
            }
        }
    }
}
