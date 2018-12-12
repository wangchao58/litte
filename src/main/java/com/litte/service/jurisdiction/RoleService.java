package com.litte.service.jurisdiction;

import com.litte.entity.jurisdiction.TRole;

import java.util.List;
import java.util.Map;

public interface RoleService {

    List<TRole> selectByExample(TRole role);

    int insertSelective(TRole record);

    int updateByPrimaryKeySelective(TRole record);

    int deleteByListKey(List<String> ids);

    TRole selectByPrimaryKey(String roleId);
}
