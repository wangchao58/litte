package com.litte.service.jurisdiction.impl;

import com.litte.entity.jurisdiction.TRole;
import com.litte.mapper.jurisdiction.TRoleMapper;
import com.litte.mapper.jurisdiction.TUserRoleMapper;
import com.litte.service.jurisdiction.RoleService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    TRoleMapper tRoleMapper;
    @Autowired
    TUserRoleMapper tUserRoleMapper;

    @Override
    public List<TRole> selectByExample(TRole role) {
        List<String> roleIds = tUserRoleMapper.selectByExample(role.getChecked());
        List<TRole> roleList = tRoleMapper.selectByExample(role);
        for (TRole roles : roleList) {
            if(roleIds.contains(roles.getRoleId())) {
                roles.setChecked("true");
            }
        }
        return roleList;
    }

    @Override
    public int insertSelective(TRole record) {
        record.setRoleId(UUIDUtil.getUUID());
        return tRoleMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TRole record) {
        return tRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByListKey(List<String> ids) {
        return tRoleMapper.deleteByListKey(ids);
    }

    @Override
    public TRole selectByPrimaryKey(String roleId) {
        return tRoleMapper.selectByPrimaryKey(roleId);
    }
}
