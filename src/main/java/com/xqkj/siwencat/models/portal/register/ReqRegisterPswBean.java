package com.xqkj.siwencat.models.portal.register;

public class ReqRegisterPswBean {
    private String phone;
    private String psw;
    private String confirmPsw;

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getConfirmPsw() {
        return confirmPsw;
    }

    public void setConfirmPsw(String confirmPsw) {
        this.confirmPsw = confirmPsw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
