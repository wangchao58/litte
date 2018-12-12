package com.litte.mapper.reception;

import com.litte.entity.reception.TEvaluate;
import com.litte.entity.reception.TEvaluateExample;
import java.util.List;

public interface TEvaluateMapper {

    int insertSelective(TEvaluate record);

    int deleteByPrimaryKey(List<String> ids);

    List<TEvaluate> selectByExample(TEvaluate record);


    int insert(TEvaluate record);

    int updateByPrimaryKeySelective(TEvaluate record);

    TEvaluate selectByPrimaryKey(String id);

    int updateByPrimaryKey(TEvaluate record);
}