package com.tuyendev.messagesender;

public enum MessageSenderType {
    
    ERROR("danger"),
    INFO("info"),
    SUCCESS("success"),
    WARNING("warning");

    MessageSenderType(String type) {
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
