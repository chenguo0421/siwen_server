package com.xqkj.siwencat.models.portal.register;

/**
 * 注册-手机验证码请求参数实例
 */
public class ReqPhoneTokenBean {
    private String phone;
    private String imei;

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
}
