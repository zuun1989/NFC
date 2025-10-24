package com.fis.ekyc.nfc.build_in.scuba.data;

public enum Gender {
    MALE {
        public int toInt() {
            return 1;
        }
    },
    FEMALE {
        public int toInt() {
            return 2;
        }
    },
    UNKNOWN {
        public int toInt() {
            return 255;
        }
    },
    UNSPECIFIED {
        public int toInt() {
            return 0;
        }
    };

    public static Gender getInstance(int i) {
        for (Gender gender : values()) {
            if (gender.toInt() == i) {
                return gender;
            }
        }
        return UNKNOWN;
    }

    public abstract int toInt();
}
