package com.tuyendev.message;

import java.util.List;



public class BaseMessage {
    private boolean success;
    private String message;
    private String value;
    private List successValue;
    private List failedValue;

    public BaseMessage() {
    }

    public BaseMessage(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public BaseMessage(boolean isSuccess, String message, String value) {
        this.success = isSuccess;
        this.message = message;
        this.value = value;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setSuccessValue(List successValue) {
        this.successValue = successValue;
    }

    public List getSuccessValue() {
        return successValue;
    }

    public void setFailedValue(List failedValue) {
        this.failedValue = failedValue;
    }

    public List getFailedValue() {
        return failedValue;
    }

}