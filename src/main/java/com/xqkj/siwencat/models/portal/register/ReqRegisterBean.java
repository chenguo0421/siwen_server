package com.xqkj.siwencat.models.portal.register;

/**
 * 注册-手机号验证请求参数实例
 */
public class ReqRegisterBean {
    private String phone;
    private String imei;
    private String authCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
