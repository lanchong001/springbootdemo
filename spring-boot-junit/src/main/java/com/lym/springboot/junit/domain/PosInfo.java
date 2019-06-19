package com.lym.springboot.junit.domain;


import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/6/12 10:03
 */
public class PosInfo extends WebApiBase {

    private int deptid;

    private String deptname;

    private String sadress;

    private String padress;

    private String netaddress;

    private String nettype;

    private List<TestNet> detail;

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getSadress() {
        return sadress;
    }

    public void setSadress(String sadress) {
        this.sadress = sadress;
    }

    public String getPadress() {
        return padress;
    }

    public void setPadress(String padress) {
        this.padress = padress;
    }

    public String getNetaddress() {
        return netaddress;
    }

    public void setNetaddress(String netaddress) {
        this.netaddress = netaddress;
    }

    public String getNettype() {
        return nettype;
    }

    public void setNettype(String nettype) {
        this.nettype = nettype;
    }

    public List<TestNet> getDetail() {
        return detail;
    }

    public void setDetail(List<TestNet> detail) {
        this.detail = detail;
    }
}
