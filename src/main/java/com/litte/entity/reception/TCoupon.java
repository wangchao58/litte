package com.litte.entity.reception;

import com.litte.util.Page;

public class TCoupon extends Page {
    private String id;

    private String cCode;

    private String cMoney;

    private String cMoneyReceipts;

    private String isStatus;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getcMoney() {
        return cMoney;
    }

    public void setcMoney(String cMoney) {
        this.cMoney = cMoney;
    }

    public String getcMoneyReceipts() {
        return cMoneyReceipts;
    }

    public void setcMoneyReceipts(String cMoneyReceipts) {
        this.cMoneyReceipts = cMoneyReceipts;
    }

    public String getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(String isStatus) {
        this.isStatus = isStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}