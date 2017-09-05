package com.tuyendev.common;

public enum Lang {
    DEFAULT_LANGUAGE("default_language"),
    VIETNAM("vi"),
    ENGLISH("en");
    
    private String code;

    Lang(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
