package com.pojo;

public class MessageWithBLOBs extends Message {
    private String messageUa;

    private String messageInfo;

    public String getMessageUa() {
        return messageUa;
    }

    public void setMessageUa(String messageUa) {
        this.messageUa = messageUa == null ? null : messageUa.trim();
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo == null ? null : messageInfo.trim();
    }
}