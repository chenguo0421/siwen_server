package com.xqkj.siwencat.models.portal.login;

public class ResLoginBean {
    private String userName;
    private String token;
    private String salt;

    public ResLoginBean(){}

    public ResLoginBean(String userName,String token,String salt){
        this.userName = userName;
        this.token = token;
        this.salt = salt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
