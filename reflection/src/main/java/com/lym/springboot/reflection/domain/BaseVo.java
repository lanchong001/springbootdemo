package com.lym.springboot.reflection.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/7 21:36
 */
public class BaseVo implements Serializable {

    private static final long serialVersionUID = -4393645586341152106L;

    @JsonProperty("app_id")
    private String appId;

    @JsonProperty("time_stamp")
    private int timeStamp;

    @JsonProperty("nonce_str")
    private String nonceStr;

    @JsonProperty("sign")
    private String sign;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
