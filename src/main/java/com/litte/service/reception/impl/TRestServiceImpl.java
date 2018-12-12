package com.litte.service.reception.impl;

import com.litte.entity.reception.TRest;
import com.litte.mapper.reception.TRestMapper;
import com.litte.service.reception.TRestService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TRestServiceImpl implements TRestService {

    @Autowired
    TRestMapper tRestMapper;

    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return tRestMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int insertSelective(TRest record) {
        int i =0;
        record.getIsDate();
        tRestMapper.deleteByPrimary(record);
        if(record.getIsHour() != null) {
            List<String> listHour = Arrays.asList(record.getIsHour().split(","));
            record.setListHour(listHour);
            i = tRestMapper.insert(record);
        } else {
            record.setId(UUIDUtil.getUUID());
            i = tRestMapper.insertSelective(record);
        }
        return i;
    }

    @Override
    public List<TRest> selectByExample(TRest record) {
        return tRestMapper.selectByExample(record);
    }

    @Override
    public List<TRest> seleDateStaffRort(TRest record) {
        return tRestMapper.seleDateStaffRort(record);
    }

    @Override
    public TRest selectByPrimaryKey(String id) {
        return tRestMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TRest record) {
        return tRestMapper.updateByPrimaryKeySelective(record);
    }
}
