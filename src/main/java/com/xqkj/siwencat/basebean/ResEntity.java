package com.xqkj.siwencat.basebean;


public class ResEntity {
    private int code = 500;
    private String msg = "params error";
    private Object data = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResEntity(){};

    public ResEntity(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
