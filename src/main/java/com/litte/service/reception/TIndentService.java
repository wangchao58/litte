package com.litte.service.reception;

import com.litte.entity.reception.TIndent;

import java.util.List;
import java.util.Map;

public interface TIndentService {
    int deleteByPrimaryKey(List<String> ids);

    TIndent insertSelective(TIndent record);

    List<TIndent> selectByExample(TIndent record);

    TIndent updateByPrimaryKeySelective(TIndent record);

    int updateByPrimaryKeyJob(TIndent record);

    int updateByPrimaryKeyPay(TIndent record);

    int updateByPrimaryKeyRefund(TIndent record);

    Map<String,Object> accountByList(Map<String,Object> map);

    TIndent selectByPrimaryKey(String id);

    TIndent selectJob();
}
