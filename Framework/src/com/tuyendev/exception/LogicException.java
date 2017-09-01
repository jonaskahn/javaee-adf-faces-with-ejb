package com.tuyendev.exception;

public class LogicException extends Exception {

    private String keyMsg;
    private String errCode;
    private Object[] params;


    public LogicException(String errCode, String keyMsg, Object... values ) {
        super();
        this.keyMsg = keyMsg;
        this.errCode = errCode;
        this.params = values;
    }


    public void setKeyMsg(String keyMsg) {
        this.keyMsg = keyMsg;
    }

    public String getKeyMsg() {
        return keyMsg;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object[] getParams() {
        return params;
    }
}

