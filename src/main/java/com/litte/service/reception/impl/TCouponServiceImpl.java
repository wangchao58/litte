package com.litte.service.reception.impl;

import com.litte.entity.reception.TCoupon;
import com.litte.mapper.reception.TCouponMapper;
import com.litte.service.reception.TCouponService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TCouponServiceImpl implements TCouponService {

    @Autowired
    TCouponMapper tCouponMapper;


    @Override
    public int insertSelective(TCoupon record) {
        record.setId(UUIDUtil.getUUID());
        return tCouponMapper.insertSelective(record);
    }

    @Override
    public List<TCoupon> selectByExample(TCoupon record) {
        return tCouponMapper.selectByExample(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TCoupon record) {
        return tCouponMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return tCouponMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public TCoupon selectByPrimaryKey(String id) {
        return tCouponMapper.selectByPrimaryKey(id);
    }
}
