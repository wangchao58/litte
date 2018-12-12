package com.litte.service.reception;

import com.litte.entity.reception.TRecruit;

import java.util.List;

public interface TRecruitService {

    int deleteByPrimaryKey(List<String> ids);

    int insertSelective(TRecruit record);

    List<TRecruit> selectByExample(TRecruit record);

    TRecruit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TRecruit record);
}
