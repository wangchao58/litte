package com.litte.mapper.reception;

import com.litte.entity.reception.TProjects;
import com.litte.entity.reception.TProjectsExample;
import java.util.List;

public interface TProjectsMapper {
    int deleteByPrimaryKey(List<String>ids);

    int insert(TProjects record);

    int insertSelective(TProjects record);

    List<TProjects> selectByExample(TProjects record);

    TProjects selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TProjects record);

    int updateByPrimaryKey(TProjects record);
}