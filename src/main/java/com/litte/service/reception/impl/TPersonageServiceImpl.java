package com.litte.service.reception.impl;

import com.github.pagehelper.StringUtil;
import com.litte.entity.reception.TPersonage;
import com.litte.mapper.reception.TPersonageMapper;
import com.litte.service.reception.TPersonageService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TPersonageServiceImpl implements TPersonageService {


    @Autowired
    TPersonageMapper tPersonageMapper;

    @Override
    public String insertSelective(TPersonage record) {
        int i = 0;
        String id = "";
        TPersonage recordu =  tPersonageMapper.selectByPrimaryKey(record.getUserId());
        if(recordu != null && StringUtil.isNotEmpty(recordu.getId())) {
            recordu.setUserId(record.getUserId());
            recordu.setUpdateTime(new Date());
            i = tPersonageMapper.updateByPrimaryKeySelective(recordu);
            id=recordu.getId();
        } else {
            i = tPersonageMapper.insertSelective(record);
            id=record.getId();
        }

        return id;
    }

    @Override
    public List<TPersonage> selectByExample(TPersonage record) {

        return tPersonageMapper.selectByExample(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TPersonage record) {
        return tPersonageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public TPersonage selectByPrimaryKeyUser(String id) {
        return tPersonageMapper.selectByPrimaryKeyUser(id);
    }
}
