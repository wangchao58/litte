package com.litte.service.reception;

import com.litte.entity.reception.TPrice;

import java.util.List;
import java.util.Map;

public interface TPriceService {

    int deleteByPrimaryKey(List<String> ids);

    int insertSelective(TPrice record);

    TPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPrice record);

    List<TPrice> selectByExample(TPrice record);

    List<TPrice> listPriceUserByPort(Map<String,Object> map);

    List<Map<String,Object>> listPriceRestByPort(Map<String,Object> map);
}
