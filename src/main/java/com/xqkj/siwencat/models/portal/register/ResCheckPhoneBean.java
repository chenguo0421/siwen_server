package com.xqkj.siwencat.models.portal.register;

/**
 * 注册-手机号校验返回实例
 */
public class ResCheckPhoneBean {
    private String randomKey;//MD5值

    public ResCheckPhoneBean(String md5) {
        this.randomKey = md5;
    }

    public String getRandomKey() {
        return randomKey;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
    }
}
