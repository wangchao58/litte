package com.litte.entity.reception;

import com.litte.util.Page;

import java.util.Date;
import java.util.List;

public class TRest extends Page {
    private String id;

    private String staffId;

    private Date timeStart;

    private Date timeEnd;

    private String remark;

    private String deptId;

    private String userName;

    private String isReserve;

    private String isDate;

    private String isHour;

    private String isRest;

    List<String> listHour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }


    public Date getTimeStart() {
        return timeStart;
    }


    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public List<String> getListHour() {
        return listHour;
    }

    public void setListHour(List<String> listHour) {
        this.listHour = listHour;
    }
}