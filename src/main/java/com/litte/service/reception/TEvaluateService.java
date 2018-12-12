package com.litte.service.reception;

import com.litte.entity.reception.TEvaluate;

import java.util.List;

public interface TEvaluateService {

    int insertSelective(TEvaluate record);

    int deleteByPrimaryKey(List<String> ids);

    List<TEvaluate> selectByExample(TEvaluate record);
}
