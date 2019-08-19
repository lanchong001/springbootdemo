package org.apereo.cas.model;

import java.io.Serializable;

/**
 * 白名单
 */
public class WhileList implements Serializable {

    private static final long serialVersionUID = -7645666784756123598L;
    /**
     *  是否白名单服务  1:允许在非IP-Guard环境下访问, 0:不允许在非IP-Guard环境下访问
     */
    private int isAuth;

    /**
     * 服务url地址
     */
    private String url;

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
