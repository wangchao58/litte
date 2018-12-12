package com.litte.service.reception.impl;

import com.litte.entity.reception.TProjects;
import com.litte.mapper.reception.TProjectsMapper;
import com.litte.service.reception.TProjectsService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TProjectsServiceImpl implements TProjectsService {


    @Autowired
    TProjectsMapper tProjectsMapper;


    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return tProjectsMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int insertSelective(TProjects record) {
        record.setId(UUIDUtil.getUUID());
        return tProjectsMapper.insertSelective(record);
    }

    @Override
    public List<TProjects> selectByExample(TProjects projects) {
        return tProjectsMapper.selectByExample(projects);
    }

    @Override
    public TProjects selectByPrimaryKey(String id) {
        return tProjectsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TProjects record) {
        return tProjectsMapper.updateByPrimaryKeySelective(record);
    }
}
