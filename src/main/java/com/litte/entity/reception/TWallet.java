package com.litte.entity.reception;

import com.litte.util.Page;

public class TWallet extends Page {
    private String id;

    private String userId;

    private String wMoney;

    private String phone;

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

    public String getwMoney() {
        return wMoney;
    }

    public void setwMoney(String wMoney) {
        this.wMoney = wMoney;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}