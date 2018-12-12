package com.litte.entity.reception;

import com.litte.util.Page;

import java.util.Date;
import java.util.List;

public class TEvaluate extends Page {
    private String id;

    private String eUserid;

    private String ePersonShop;

    private String ePersonShopId;

    private String eContent;

    private String picture;

    private Date createTime;

    private String score;

    private List<String> deptIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String geteUserid() {
        return eUserid;
    }

    public void seteUserid(String eUserid) {
        this.eUserid = eUserid;
    }

    public String getePersonShop() {
        return ePersonShop;
    }

    public void setePersonShop(String ePersonShop) {
        this.ePersonShop = ePersonShop;
    }

    public String getePersonShopId() {
        return ePersonShopId;
    }

    public void setePersonShopId(String ePersonShopId) {
        this.ePersonShopId = ePersonShopId;
    }

    public String geteContent() {
        return eContent;
    }

    public void seteContent(String eContent) {
        this.eContent = eContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<String> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<String> deptIds) {
        this.deptIds = deptIds;
    }


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}