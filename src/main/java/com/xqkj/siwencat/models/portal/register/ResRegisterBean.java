package com.xqkj.siwencat.models.portal.register;

/**
 * 注册-密码设置返回实例
 */
public class ResRegisterBean {
    private String userName;

    public ResRegisterBean(String phone) {
        this.userName = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
