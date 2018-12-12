package com.litte.mapper.reception;

import com.litte.entity.reception.TPersonage;
import com.litte.entity.reception.TPersonageExample;
import java.util.List;

public interface TPersonageMapper {
    int deleteByPrimaryKey(String id);

    int insert(TPersonage record);

    int insertSelective(TPersonage record);

    List<TPersonage> selectByExample(TPersonage tPersonage);

    TPersonage selectByPrimaryKey(String userId);

    TPersonage selectByPrimaryKeyUser(String id);

    int updateByPrimaryKeySelective(TPersonage record);

    int updateByPrimaryKey(TPersonage record);
}