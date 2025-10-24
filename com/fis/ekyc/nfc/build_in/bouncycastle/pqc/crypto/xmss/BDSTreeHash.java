package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss;

import com.google.android.gms.common.api.Api;
import java.io.Serializable;

class BDSTreeHash implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private boolean finished = false;
    private int height;
    private final int initialHeight;
    private boolean initialized = false;
    private int nextIndex;
    private XMSSNode tailNode;

    public BDSTreeHash(int i) {
        this.initialHeight = i;
    }

    public int getHeight() {
        if (!this.initialized || this.finished) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return this.height;
    }

    public int getIndexLeaf() {
        return this.nextIndex;
    }

    public XMSSNode getTailNode() {
        return this.tailNode;
    }

    public void initialize(int i) {
        this.tailNode = null;
        this.height = this.initialHeight;
        this.nextIndex = i;
        this.initialized = true;
        this.finished = false;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public void setNode(XMSSNode xMSSNode) {
        this.tailNode = xMSSNode;
        int height2 = xMSSNode.getHeight();
        this.height = height2;
        if (height2 == this.initialHeight) {
            this.finished = true;
        }
    }

    /* JADX WARNING: type inference failed for: r7v17, types: [com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(java.util.Stack<com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode> r5, com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.WOTSPlus r6, byte[] r7, byte[] r8, com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress r9) {
        /*
            r4 = this;
            if (r9 == 0) goto L_0x021e
            boolean r0 = r4.finished
            if (r0 != 0) goto L_0x0216
            boolean r0 = r4.initialized
            if (r0 == 0) goto L_0x0216
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder
            r0.<init>()
            int r1 = r9.getLayerAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r0 = r0.withLayerAddress(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress.Builder) r0
            long r1 = r9.getTreeAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r0 = r0.withTreeAddress(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress.Builder) r0
            int r1 = r4.nextIndex
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = r0.withOTSAddress(r1)
            int r1 = r9.getChainAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = r0.withChainAddress(r1)
            int r1 = r9.getHashAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder r0 = r0.withHashAddress(r1)
            int r9 = r9.getKeyAndMask()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r9 = r0.withKeyAndMask(r9)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder r9 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress.Builder) r9
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress r9 = r9.build()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress r9 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress) r9
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.LTreeAddress$Builder r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.LTreeAddress$Builder
            r0.<init>()
            int r1 = r9.getLayerAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r0 = r0.withLayerAddress(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.LTreeAddress$Builder r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.LTreeAddress.Builder) r0
            long r1 = r9.getTreeAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r0 = r0.withTreeAddress(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.LTreeAddress$Builder r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.LTreeAddress.Builder) r0
            int r1 = r4.nextIndex
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.LTreeAddress$Builder r0 = r0.withLTreeAddress(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress r0 = r0.build()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.LTreeAddress r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.LTreeAddress) r0
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r1.<init>()
            int r2 = r9.getLayerAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r1 = r1.withLayerAddress(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r1 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r1
            long r2 = r9.getTreeAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r1 = r1.withTreeAddress(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r1 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r1
            int r2 = r4.nextIndex
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r1 = r1.withTreeIndex(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress r1 = r1.build()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress r1 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress) r1
            byte[] r8 = r6.getWOTSPlusSecretKey(r8, r9)
            r6.importKeys(r8, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.WOTSPlusPublicKeyParameters r7 = r6.getPublicKey(r9)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r7 = com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNodeUtil.lTree(r6, r7, r0)
        L_0x00a2:
            boolean r8 = r5.isEmpty()
            r9 = 1
            if (r8 != 0) goto L_0x0159
            java.lang.Object r8 = r5.peek()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r8 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode) r8
            int r8 = r8.getHeight()
            int r0 = r7.getHeight()
            if (r8 != r0) goto L_0x0159
            java.lang.Object r8 = r5.peek()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r8 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode) r8
            int r8 = r8.getHeight()
            int r0 = r4.initialHeight
            if (r8 == r0) goto L_0x0159
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r8.<init>()
            int r0 = r1.getLayerAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r8 = r8.withLayerAddress(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r8
            long r2 = r1.getTreeAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r8 = r8.withTreeAddress(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r8
            int r0 = r1.getTreeHeight()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = r8.withTreeHeight(r0)
            int r0 = r1.getTreeIndex()
            int r0 = r0 - r9
            int r0 = r0 / 2
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = r8.withTreeIndex(r0)
            int r0 = r1.getKeyAndMask()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r8 = r8.withKeyAndMask(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r8 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r8
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress r8 = r8.build()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress r8 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress) r8
            java.lang.Object r0 = r5.pop()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode) r0
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r7 = com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNodeUtil.randomizeHash(r6, r0, r7, r8)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode
            int r1 = r7.getHeight()
            int r1 = r1 + r9
            byte[] r7 = r7.getValue()
            r0.<init>(r1, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r7.<init>()
            int r1 = r8.getLayerAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.withLayerAddress(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r7
            long r1 = r8.getTreeAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.withTreeAddress(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r7
            int r1 = r8.getTreeHeight()
            int r1 = r1 + r9
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = r7.withTreeHeight(r1)
            int r9 = r8.getTreeIndex()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = r7.withTreeIndex(r9)
            int r8 = r8.getKeyAndMask()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.withKeyAndMask(r8)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r7
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress r7 = r7.build()
            r1 = r7
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress r1 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress) r1
            r7 = r0
            goto L_0x00a2
        L_0x0159:
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r8 = r4.tailNode
            if (r8 != 0) goto L_0x0161
            r4.tailNode = r7
            goto L_0x01fd
        L_0x0161:
            int r8 = r8.getHeight()
            int r0 = r7.getHeight()
            if (r8 != r0) goto L_0x01fa
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r5.<init>()
            int r8 = r1.getLayerAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.withLayerAddress(r8)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            long r2 = r1.getTreeAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.withTreeAddress(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            int r8 = r1.getTreeHeight()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = r5.withTreeHeight(r8)
            int r8 = r1.getTreeIndex()
            int r8 = r8 - r9
            int r8 = r8 / 2
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = r5.withTreeIndex(r8)
            int r8 = r1.getKeyAndMask()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.withKeyAndMask(r8)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress r5 = r5.build()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress) r5
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r8 = r4.tailNode
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r6 = com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNodeUtil.randomizeHash(r6, r8, r7, r5)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r8 = r4.tailNode
            int r8 = r8.getHeight()
            int r8 = r8 + r9
            byte[] r6 = r6.getValue()
            r7.<init>(r8, r6)
            r4.tailNode = r7
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r6.<init>()
            int r8 = r5.getLayerAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r6 = r6.withLayerAddress(r8)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r6
            long r0 = r5.getTreeAddress()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r6 = r6.withTreeAddress(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r6
            int r8 = r5.getTreeHeight()
            int r8 = r8 + r9
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = r6.withTreeHeight(r8)
            int r8 = r5.getTreeIndex()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r6 = r6.withTreeIndex(r8)
            int r5 = r5.getKeyAndMask()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r6.withKeyAndMask(r5)
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress r5 = r5.build()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.HashTreeAddress) r5
            goto L_0x01fd
        L_0x01fa:
            r5.push(r7)
        L_0x01fd:
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSNode r5 = r4.tailNode
            int r5 = r5.getHeight()
            int r6 = r4.initialHeight
            if (r5 != r6) goto L_0x020a
            r4.finished = r9
            goto L_0x0215
        L_0x020a:
            int r5 = r7.getHeight()
            r4.height = r5
            int r5 = r4.nextIndex
            int r5 = r5 + r9
            r4.nextIndex = r5
        L_0x0215:
            return
        L_0x0216:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "finished or not initialized"
            r5.<init>(r6)
            throw r5
        L_0x021e:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "otsHashAddress == null"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.BDSTreeHash.update(java.util.Stack, com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.WOTSPlus, byte[], byte[], com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress):void");
    }

    public BDSTreeHash clone() {
        BDSTreeHash bDSTreeHash = new BDSTreeHash(this.initialHeight);
        bDSTreeHash.tailNode = this.tailNode;
        bDSTreeHash.height = this.height;
        bDSTreeHash.nextIndex = this.nextIndex;
        bDSTreeHash.initialized = this.initialized;
        bDSTreeHash.finished = this.finished;
        return bDSTreeHash;
    }
}
