package com.tuyendev.messenger;

public enum MessengerType {

    ERROR("danger"),
    INFO("info"),
    SUCCESS("success"),
    WARNING("warning");

    MessengerType(String type) {
        this.type = type;
    }

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
