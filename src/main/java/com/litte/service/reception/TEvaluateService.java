package com.litte.service.reception;

import com.litte.entity.reception.TEvaluate;

import java.util.List;
import java.util.Map;

public interface TEvaluateService {

    int insertSelective(TEvaluate record);

    int deleteByPrimaryKey(List<String> ids);

    List<Map<String,Object>> selectByExample(TEvaluate record);

    List<Map<String,Object>> selectByExampleByPort(TEvaluate record);

    int selCountByExampleByPort(TEvaluate evaluate);
}
