package com.litte.mapper.jurisdiction;

import com.litte.entity.jurisdiction.TMenu;

import java.util.List;
import java.util.Map;


public interface TMenuMapper {
    int deleteByPrimaryKey(String id);

    int deleteByList(List<String> ids);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    List<TMenu> selectByExample(Map<String,Object> map);

    List<TMenu> selectByLisAll(TMenu record);

    TMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);
}