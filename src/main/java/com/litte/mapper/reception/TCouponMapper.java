package com.litte.mapper.reception;

import com.litte.entity.reception.TCoupon;
import com.litte.entity.reception.TCouponExample;
import java.util.List;

public interface TCouponMapper {
    int deleteByPrimaryKey(List<String>ids);

    int insert(TCoupon record);

    int insertSelective(TCoupon record);

    List<TCoupon> selectByExample(TCoupon record);

    TCoupon selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TCoupon record);

    int updateByPrimaryKey(TCoupon record);
}