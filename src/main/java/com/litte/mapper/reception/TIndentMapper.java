package com.litte.mapper.reception;

import com.litte.entity.reception.TIndent;
import com.litte.entity.reception.TIndentExample;
import java.util.List;
import java.util.Map;

public interface TIndentMapper {
    int deleteByPrimaryKey(List<String> ids);

    int insert(TIndent record);

    int insertSelective(TIndent record);

    List<TIndent> selectByExample(TIndent record);

    List<Map<String,Object>> selIndentByUser(TIndent record);

    List<Map<String,Object>> selIndentByHair(TIndent record);

    List<Map<String,Object>> selIndentByHairById(TIndent record);

    List<Map<String,Object>> selIndentByPort(TIndent record);

    TIndent selectByPrimaryKey(String id);

    TIndent selectJob();

    TIndent selectCancelIndent();

    int updateByPrimaryKeySelective(TIndent record);

    int updateByPrimaryKey(TIndent record);

    String accountByList(Map<String, Object> map);
}