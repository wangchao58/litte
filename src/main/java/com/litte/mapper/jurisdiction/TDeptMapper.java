package com.litte.mapper.jurisdiction;

import com.litte.entity.jurisdiction.TDept;

import java.util.List;

public interface TDeptMapper {
    int deleteByPrimaryKey(String id);

    int deleteByList(List<String> idlist);

    int insert(TDept record);

    int insertSelective(TDept record);

    List<TDept> selectByExample(TDept tDept);

    List<TDept> selectByExampleByPort(TDept dept);

    TDept selectByPrimaryKey(String id);

    TDept selectBySmsKey(String id);

    int updateByPrimaryKeySelective(TDept record);

    int updateByPrimaryKey(TDept record);

    String getMaxGroupId(String pId);

    List<String> getGroupListIds(String id);

    List<TDept> selDeptList(List<String> deptIds);
}