package com.litte.service.reception.impl;

import com.litte.entity.reception.TRecruit;
import com.litte.mapper.reception.TRecruitMapper;
import com.litte.service.reception.TRecruitService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TRecruitServiceImpl implements TRecruitService {

    @Autowired
    TRecruitMapper tRecruitMapper;


    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return tRecruitMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int insertSelective(TRecruit record) {
        record.setId(UUIDUtil.getUUID());
        return tRecruitMapper.insertSelective(record);
    }

    @Override
    public List<TRecruit> selectByExample(TRecruit record) {
        return tRecruitMapper.selectByExample(record);
    }

    @Override
    public TRecruit selectByPrimaryKey(String id) {
        return tRecruitMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TRecruit record) {
        return tRecruitMapper.updateByPrimaryKeySelective(record);
    }
}
