package com.litte.mapper.jurisdiction;

import com.litte.entity.jurisdiction.TRole;
import com.litte.entity.jurisdiction.TRoleExample;
import java.util.List;
import java.util.Map;

public interface TRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int deleteByListKey(List<String> ids);

    int insert(TRole record);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRole role);

    TRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
}