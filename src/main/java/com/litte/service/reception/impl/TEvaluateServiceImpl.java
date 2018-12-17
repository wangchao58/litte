package com.litte.service.reception.impl;

import com.litte.entity.reception.TEvaluate;
import com.litte.mapper.reception.TEvaluateMapper;
import com.litte.service.reception.TEvaluateService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TEvaluateServiceImpl implements TEvaluateService {

    @Autowired
    TEvaluateMapper tEvaluateMapper;

    @Override
    public int insertSelective(TEvaluate record) {
        record.setId(UUIDUtil.getUUID());
        record.setCreateTime(new Date());
        return tEvaluateMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return tEvaluateMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public List<TEvaluate> selectByExample(TEvaluate record) {
        return tEvaluateMapper.selectByExample(record);
    }

    @Override
    public List<Map<String, Object>> selectByExampleByPort(TEvaluate record) {
        return tEvaluateMapper.selectByExampleByPort(record);
    }
}
