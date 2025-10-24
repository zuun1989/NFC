package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.cvc.exception.ConstructionException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CVCertificateExtensions extends AbstractArray {
    private static final long serialVersionUID = 1;

    public CVCertificateExtensions() {
        super(CVCTagEnum.CERTIFICATE_EXTENSIONS);
    }

    public CVCTagEnum getAllowedField() {
        return CVCTagEnum.DISCRETIONARY_DATA_TEMPLATE;
    }

    public List<CVCDiscretionaryDataTemplate> getExtensions() {
        ArrayList arrayList = new ArrayList();
        Iterator<CVCObject> it = getEncodableFields().iterator();
        while (it.hasNext()) {
            arrayList.add((CVCDiscretionaryDataTemplate) it.next());
        }
        return arrayList;
    }

    public CVCertificateExtensions(Collection<CVCDiscretionaryDataTemplate> collection) throws ConstructionException {
        this();
        for (CVCDiscretionaryDataTemplate addSubfield : collection) {
            addSubfield(addSubfield);
        }
    }
}
