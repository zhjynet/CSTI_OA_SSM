package com.pojo;

import java.util.Date;

public class Message {
    private Integer messageId;

    private Date messageTime;

    private String messageIp;

    private Integer messageUserId;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageIp() {
        return messageIp;
    }

    public void setMessageIp(String messageIp) {
        this.messageIp = messageIp == null ? null : messageIp.trim();
    }

    public Integer getMessageUserId() {
        return messageUserId;
    }

    public void setMessageUserId(Integer messageUserId) {
        this.messageUserId = messageUserId;
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