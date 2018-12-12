package com.litte.mapper.reception;

import com.litte.entity.reception.TRecruit;
import com.litte.entity.reception.TRecruitExample;
import java.util.List;

public interface TRecruitMapper {

    int insert(TRecruit record);

    int deleteByPrimaryKey(List<String> ids);

    int insertSelective(TRecruit record);

    List<TRecruit> selectByExample(TRecruit record);

    TRecruit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TRecruit record);

    int updateByPrimaryKey(TRecruit record);
}