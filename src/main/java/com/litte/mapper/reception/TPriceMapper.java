package com.litte.mapper.reception;

import com.litte.entity.reception.TPrice;
import com.litte.entity.reception.TPriceExample;
import java.util.List;
import java.util.Map;

public interface TPriceMapper {
    int deleteByPrimaryKey(List<String> ids);

    int insert(TPrice record);

    int insertSelective(TPrice record);

    List<TPrice> selectByExample(TPrice record);

    List<TPrice> listPriceUserByPort(Map<String,Object> map);

    List<Map<String, Object>> listPriceRestByPort(Map<String,Object> map);

    List<Map<String,Object>> listPriceUserRestByPort(Map<String,Object> map);

    List<Map<String,Object>> listPriceDateRestByPort(Map<String,Object> map);

    TPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPrice record);

    int updateByPrimaryKey(TPrice record);
}