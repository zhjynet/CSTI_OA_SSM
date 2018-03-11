package com.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String studentNumber;

    private String name;

    private String password;

    private Integer groupId;

    private Integer isSigninToday;

    private Integer smallGroup;

    private Integer configPermission;

    private String activationCode;

    private Date gmtCreate;

    private Date gmtModified;

    private String imagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getIsSigninToday() {
        return isSigninToday;
    }

    public void setIsSigninToday(Integer isSigninToday) {
        this.isSigninToday = isSigninToday;
    }

    public Integer getSmallGroup() {
        return smallGroup;
    }

    public void setSmallGroup(Integer smallGroup) {
        this.smallGroup = smallGroup;
    }

    public Integer getConfigPermission() {
        return configPermission;
    }

    public void setConfigPermission(Integer configPermission) {
        this.configPermission = configPermission;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode == null ? null : activationCode.trim();
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }
}