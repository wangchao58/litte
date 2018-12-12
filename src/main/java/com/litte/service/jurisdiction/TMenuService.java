package com.litte.service.jurisdiction;

import com.litte.entity.jurisdiction.TMenu;

import java.util.List;
import java.util.Map;

public interface TMenuService {
    List<TMenu> selectByExample(Map<String, Object> map);

    Map<String,Object> menuTreePort(Map<String, Object> map);

    int insert(TMenu record);

    TMenu selectByPrimaryKey(String id);

    int deleteByList(List<String> ids);

    int updateByPrimaryKeySelective(TMenu record);


    List<TMenu> selectByLisAll(TMenu menu);
}
