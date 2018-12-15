package com.litte.service.jurisdiction.impl;

import com.github.pagehelper.StringUtil;
import com.litte.entity.jurisdiction.TMenu;
import com.litte.entity.jurisdiction.TUser;
import com.litte.mapper.jurisdiction.TMenuMapper;
import com.litte.mapper.jurisdiction.TUserMapper;
import com.litte.service.jurisdiction.TMenuService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 */
@Service
public class TMenuServiceImpl implements TMenuService {

    @Autowired
    TMenuMapper tMenuMapper;

    @Autowired
    TUserMapper tUserMapper;

    /**
     * 查询所有菜单
     * @param map
     * @return
     */
    @Override
    public List<TMenu> selectByExample(Map<String, Object>map) {
        List<TMenu> tMenuList = tMenuMapper.selectByExample(map);
        return tMenuList;
    }

    @Override
    public Map<String,Object> menuTreePort(Map<String, Object> map) {
        TUser user = tUserMapper.selectByNamePhone(map.get("phone").toString());
        if (user != null && StringUtil.isNotEmpty(user.getUserId())) {
            map.put("userId",user.getUserId());
            List<TMenu> tMenuList = tMenuMapper.selectByExample(map);
            map.clear();
            for(TMenu menu : tMenuList) {
                if(menu.getId().equals("723faaa445e8488d8294c095e85b4ae1")){
                    map.put("arrange","1");
                }
                if(menu.getId().equals("caff701003f54dea8a2d40965851c950")){
                    map.put("isIndent","1");
                }
            }
            map.put("deptId",user.getDeptId());
            return map;
        }

        return null;
    }

    /**
     * 增加菜单
     * @param record
     * @return
     */
    @Override
    public int insert(TMenu record) {
        record.setId(UUIDUtil.getUUID());
        return tMenuMapper.insert(record);
    }

    /**
     * 根据ID查询菜单
     * @param id
     * @return
     */
    @Override
    public TMenu selectByPrimaryKey(String id) {
        return tMenuMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除菜单
     * @param ids
     * @return
     */
    @Override
    public int deleteByList(List<String> ids) {
        return tMenuMapper.deleteByList(ids);
    }

    /**
     * 修改菜单
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(TMenu record) {
        return tMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TMenu> selectByLisAll(TMenu record) {
        return tMenuMapper.selectByLisAll(record);
    }


}
