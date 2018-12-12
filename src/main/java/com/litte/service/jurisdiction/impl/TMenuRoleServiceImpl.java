package com.litte.service.jurisdiction.impl;

import com.litte.entity.jurisdiction.TMenuRole;
import com.litte.mapper.jurisdiction.TMenuRoleMapper;
import com.litte.service.jurisdiction.TMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TMenuRoleServiceImpl implements TMenuRoleService {

    @Autowired
    TMenuRoleMapper tMenuRoleMapper;

    @Override
    public int insert(TMenuRole record) {

        tMenuRoleMapper.deleteByPrimaryKey(record.getRoleId());

        List<String> menuId = Arrays.asList(record.getMenuId().split(","));
        Map<String,Object> map = new HashMap<>();
        map.put("roleId",record.getRoleId());
        map.put("menuId",menuId);

        return tMenuRoleMapper.insert(map);
    }
}
