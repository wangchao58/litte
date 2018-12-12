package com.litte.service.reception;

import com.litte.entity.reception.TCoupon;

import java.util.List;

public interface TCouponService {

    int insertSelective(TCoupon record);

    List<TCoupon> selectByExample(TCoupon record);

    int updateByPrimaryKeySelective(TCoupon record);

    int deleteByPrimaryKey(List<String>ids);

    TCoupon selectByPrimaryKey(String id);
}
