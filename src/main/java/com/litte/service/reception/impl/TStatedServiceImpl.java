package com.litte.service.reception.impl;

import com.litte.entity.reception.TStated;
import com.litte.mapper.reception.TStatedMapper;
import com.litte.service.reception.TStatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TStatedServiceImpl implements TStatedService {

    @Autowired
    TStatedMapper tStatedMapper;

    @Override
    public int insertSelective(TStated record) {
        return tStatedMapper.insertSelective(record);
    }

    @Override
    public List<TStated> selectByExample(TStated record) {
        return tStatedMapper.selectByExample(record);
    }
}
