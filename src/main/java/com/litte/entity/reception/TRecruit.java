package com.litte.entity.reception;

import com.litte.util.Page;

import java.util.Date;

public class TRecruit extends Page {
    private String id;

    private String rMessage;

    private String job;

    private String sear;

    private String salary;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getrMessage() {
        return rMessage;
    }

    public void setrMessage(String rMessage) {
        this.rMessage = rMessage;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSear() {
        return sear;
    }

    public void setSear(String sear) {
        this.sear = sear;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}