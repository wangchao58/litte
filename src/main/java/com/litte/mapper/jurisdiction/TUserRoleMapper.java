package com.litte.mapper.jurisdiction;

import com.litte.entity.jurisdiction.TUserRole;

import java.util.List;
import java.util.Map;

public interface TUserRoleMapper {
    int deleteByPrimaryKey(String userId);

    int insert(Map<String,Object> map);

    int insertSelective(TUserRole record);

    List<String> selectByExample(String userId);

    TUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);

    /**
     * 删除用户时，同时删除角色
     * @param userId
     * @return
     */
    int deleteUserRole(List<String > userId);
}