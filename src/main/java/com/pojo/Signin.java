package com.pojo;

import java.util.Date;

public class Signin {
    private Integer id;

    private Integer signinUserId;

    private Date signinTime;

    private String signinIp;

    private String signinUa;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSigninUserId() {
        return signinUserId;
    }

    public void setSigninUserId(Integer signinUserId) {
        this.signinUserId = signinUserId;
    }

    public Date getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    public String getSigninIp() {
        return signinIp;
    }

    public void setSigninIp(String signinIp) {
        this.signinIp = signinIp == null ? null : signinIp.trim();
    }

    public String getSigninUa() {
        return signinUa;
    }

    public void setSigninUa(String signinUa) {
        this.signinUa = signinUa == null ? null : signinUa.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}