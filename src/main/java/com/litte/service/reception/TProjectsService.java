package com.litte.service.reception;

import com.litte.entity.reception.TProjects;

import java.util.List;

public interface TProjectsService {

    int deleteByPrimaryKey(List<String>ids);

    int insertSelective(TProjects record);

    List<TProjects> selectByExample(TProjects projects);

    TProjects selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TProjects record);
}
