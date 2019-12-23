package com.xqkj.siwencat.basebean;

public enum IStatue {
    SUCCESS(200,"OK"),
    PARAMS_ERROR(20100,"params error"),
    PARAMS_ERROR_AUTH_CODE(20101,"手机号和短信验证码不匹配"),
    DATABASE_ERROR(20200,"database jdbc error");

    private final int code;
    private final String msg;

    private IStatue(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
