package com.litte.entity.reception;

import com.litte.util.Page;

import java.util.List;

public class TPrice extends Page {
    private String id;

    private String project;

    private String price;

    private String remark;

    private String userId;

    private String deptId;

    private String userName;

    private String headPortrait ;

    private String isHour ;//最早可预约

    private String isRest ;

    private String isReserve ;

    private String isDate ;

    private List<String> deptIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<String> deptIds) {
        this.deptIds = deptIds;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getIsHour() {
        return isHour;
    }

    public void setIsHour(String isHour) {
        this.isHour = isHour;
    }

    public String getIsRest() {
        return isRest;
    }

    public void setIsRest(String isRest) {
        this.isRest = isRest;
    }

    public String getIsReserve() {
        return isReserve;
    }

    public void setIsReserve(String isReserve) {
        this.isReserve = isReserve;
    }

    public String getIsDate() {
        return isDate;
    }

    public void setIsDate(String isDate) {
        this.isDate = isDate;
    }
}