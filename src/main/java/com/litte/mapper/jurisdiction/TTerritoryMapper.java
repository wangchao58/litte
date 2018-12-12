package com.litte.mapper.jurisdiction;

import com.litte.entity.jurisdiction.TTerritory;
import com.litte.entity.jurisdiction.TTerritoryExample;
import java.util.List;

public interface TTerritoryMapper {
    int deleteByPrimaryKey(List<String> ids);

    int insert(TTerritory record);

    int insertSelective(TTerritory record);

    List<TTerritory> selectByExample(TTerritory record);

    TTerritory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TTerritory record);

    int updateByPrimaryKey(TTerritory record);
}