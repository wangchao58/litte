package com.litte.mapper.jurisdiction;

import com.litte.entity.jurisdiction.TRecruitInfo;
import com.litte.entity.jurisdiction.TRecruitInfoExample;

import java.util.List;

public interface TRecruitInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TRecruitInfo record);

    int insertSelective(TRecruitInfo record);

    List<TRecruitInfo> selectByExample(TRecruitInfoExample example);

    TRecruitInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TRecruitInfo record);

    int updateByPrimaryKey(TRecruitInfo record);
}