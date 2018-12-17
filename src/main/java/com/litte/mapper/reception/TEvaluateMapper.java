package com.litte.mapper.reception;

import com.litte.entity.reception.TEvaluate;
import com.litte.entity.reception.TEvaluateExample;
import java.util.List;
import java.util.Map;

public interface TEvaluateMapper {

    int insertSelective(TEvaluate record);

    int deleteByPrimaryKey(List<String> ids);

    List<Map<String,Object>> selectByExample(TEvaluate record);

    List<Map<String,Object>> selectByExampleByPort(TEvaluate record);

    int insert(TEvaluate record);

    int updateByPrimaryKeySelective(TEvaluate record);

    TEvaluate selectByPrimaryKey(String id);

    int updateByPrimaryKey(TEvaluate record);
}