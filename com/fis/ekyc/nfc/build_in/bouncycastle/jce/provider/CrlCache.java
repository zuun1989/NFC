package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCRLStore;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.CollectionStore;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Iterable;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Selector;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Store;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

class CrlCache {
    private static final int DEFAULT_TIMEOUT = 15000;
    private static Map<URI, WeakReference<PKIXCRLStore>> cache = Collections.synchronizedMap(new WeakHashMap());

    public static class LocalCRLStore<T extends CRL> implements PKIXCRLStore, Iterable<CRL> {
        private Collection<CRL> _local;

        public LocalCRLStore(Store<CRL> store) {
            this._local = new ArrayList(store.getMatches((Selector<CRL>) null));
        }

        public Collection getMatches(Selector selector) {
            if (selector == null) {
                return new ArrayList(this._local);
            }
            ArrayList arrayList = new ArrayList();
            for (CRL next : this._local) {
                if (selector.match(next)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        public Iterator<CRL> iterator() {
            return getMatches((Selector) null).iterator();
        }
    }

    public static synchronized PKIXCRLStore getCrl(CertificateFactory certificateFactory, Date date, URI uri) throws IOException, CRLException {
        PKIXCRLStore pKIXCRLStore;
        Collection collection;
        synchronized (CrlCache.class) {
            try {
                WeakReference weakReference = cache.get(uri);
                if (weakReference != null) {
                    pKIXCRLStore = (PKIXCRLStore) weakReference.get();
                } else {
                    pKIXCRLStore = null;
                }
                if (pKIXCRLStore != null) {
                    for (X509CRL nextUpdate : pKIXCRLStore.getMatches((Selector) null)) {
                        Date nextUpdate2 = nextUpdate.getNextUpdate();
                        if (nextUpdate2 == null || !nextUpdate2.before(date)) {
                        }
                    }
                    return pKIXCRLStore;
                }
                if (uri.getScheme().equals("ldap")) {
                    collection = getCrlsFromLDAP(certificateFactory, uri);
                } else {
                    collection = getCrls(certificateFactory, uri);
                }
                LocalCRLStore localCRLStore = new LocalCRLStore(new CollectionStore(collection));
                cache.put(uri, new WeakReference(localCRLStore));
                return localCRLStore;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private static Collection getCrls(CertificateFactory certificateFactory, URI uri) throws IOException, CRLException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
        httpURLConnection.setConnectTimeout(DEFAULT_TIMEOUT);
        httpURLConnection.setReadTimeout(DEFAULT_TIMEOUT);
        InputStream inputStream = httpURLConnection.getInputStream();
        Collection<? extends CRL> generateCRLs = certificateFactory.generateCRLs(inputStream);
        inputStream.close();
        return generateCRLs;
    }

    private static Collection getCrlsFromLDAP(CertificateFactory certificateFactory, URI uri) throws IOException, CRLException {
        return null;
    }
}
