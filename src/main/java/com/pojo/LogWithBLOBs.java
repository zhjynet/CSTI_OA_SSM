package com.pojo;

public class LogWithBLOBs extends Log {
    private String logUa;

    private String logUrl;

    public String getLogUa() {
        return logUa;
    }

    public void setLogUa(String logUa) {
        this.logUa = logUa == null ? null : logUa.trim();
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl == null ? null : logUrl.trim();
    }
}