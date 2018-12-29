package com.litte.service.jurisdiction;

import com.litte.entity.jurisdiction.TDept;

import java.util.List;

public interface TDeptService {
    List<TDept> selectByExample(TDept dept);

    List<TDept> selectByExampleByPort(TDept dept);

    int insertSelective(TDept record);

    int updateByPrimaryKeySelective(TDept record);

    TDept selectByPrimaryKey(String id);

    TDept selectBySmsKey(String id);

    int deleteByList(List<String> idlist);

    String selectByTree(TDept dept);

    List<String> getGroupListIds(String id);

    List<TDept> selDeptList(List<String> deptIds);
}
