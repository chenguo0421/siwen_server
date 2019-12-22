package com.xqkj.siwencat.models.portal.register;

public class ResPhoneTokenBean {
    private String authCode;

    public ResPhoneTokenBean(int randomCode) {
        this.authCode = randomCode + "";
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
