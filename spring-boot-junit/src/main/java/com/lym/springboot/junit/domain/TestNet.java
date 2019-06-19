package com.lym.springboot.junit.domain;

import java.math.BigDecimal;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/6/12 10:08
 */
public class TestNet {

    private BigDecimal bspeed;

    private String testtime;

    private int testtype;

    private int testname;

    private String testurl;

    private int avgspeed;

    private int fspeed;

    private int sspeed;

    private String msg;

    private int isbroken;

    private int issatisfy;

    public TestNet(BigDecimal bspeed, String testtime, int testtype, int testname, String testurl, int avgspeed, int fspeed, int sspeed, String msg, int isbroken, int issatisfy) {
        this.bspeed = bspeed;
        this.testtime = testtime;
        this.testtype = testtype;
        this.testname = testname;
        this.testurl = testurl;
        this.avgspeed = avgspeed;
        this.fspeed = fspeed;
        this.sspeed = sspeed;
        this.msg = msg;
        this.isbroken = isbroken;
        this.issatisfy = issatisfy;
    }

    public BigDecimal getBspeed() {
        return bspeed;
    }

    public void setBspeed(BigDecimal bspeed) {
        this.bspeed = bspeed;
    }

    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
        this.testtime = testtime;
    }

    public int getTesttype() {
        return testtype;
    }

    public void setTesttype(int testtype) {
        this.testtype = testtype;
    }

    public int getTestname() {
        return testname;
    }

    public void setTestname(int testname) {
        this.testname = testname;
    }

    public String getTesturl() {
        return testurl;
    }

    public void setTesturl(String testurl) {
        this.testurl = testurl;
    }

    public int getAvgspeed() {
        return avgspeed;
    }

    public void setAvgspeed(int avgspeed) {
        this.avgspeed = avgspeed;
    }

    public int getFspeed() {
        return fspeed;
    }

    public void setFspeed(int fspeed) {
        this.fspeed = fspeed;
    }

    public int getSspeed() {
        return sspeed;
    }

    public void setSspeed(int sspeed) {
        this.sspeed = sspeed;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIsbroken() {
        return isbroken;
    }

    public void setIsbroken(int isbroken) {
        this.isbroken = isbroken;
    }

    public int getIssatisfy() {
        return issatisfy;
    }

    public void setIssatisfy(int issatisfy) {
        this.issatisfy = issatisfy;
    }
}
