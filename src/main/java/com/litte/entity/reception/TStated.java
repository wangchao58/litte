package com.litte.entity.reception;

import com.litte.util.Page;

import java.util.Date;

public class TStated extends Page {
    private String id;

    private String userId;

    private Date createTime;

    private String sAmount;

    private String sReal;

    private String isSucceed;

    private String realNmae;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getsAmount() {
        return sAmount;
    }

    public void setsAmount(String sAmount) {
        this.sAmount = sAmount;
    }

    public String getsReal() {
        return sReal;
    }

    public void setsReal(String sReal) {
        this.sReal = sReal;
    }

    public String getIsSucceed() {
        return isSucceed;
    }

    public void setIsSucceed(String isSucceed) {
        this.isSucceed = isSucceed;
    }

    public String getRealNmae() {
        return realNmae;
    }

    public void setRealNmae(String realNmae) {
        this.realNmae = realNmae;
    }
}