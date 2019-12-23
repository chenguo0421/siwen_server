package com.xqkj.siwencat.models.portal.register;

/**
 * 注册-手机验证码返回实例
 */
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
