package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;

@Deprecated
public class AccessDeniedException extends CardServiceException {
    private static final long serialVersionUID = -7094953658210693249L;
    private final AccessKeySpec bacKey;

    public AccessDeniedException(String str, int i) {
        this(str, (AccessKeySpec) null, i);
    }

    public AccessKeySpec getAccessKey() {
        return this.bacKey;
    }

    public AccessDeniedException(String str, AccessKeySpec accessKeySpec, int i) {
        super(str, i);
        this.bacKey = accessKeySpec;
    }
}
