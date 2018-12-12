package com.litte.service.reception;

import com.litte.entity.reception.TPersonage;

import java.util.List;

public interface TPersonageService {

    String insertSelective(TPersonage record);

    List<TPersonage> selectByExample(TPersonage record);

    int updateByPrimaryKeySelective(TPersonage record);

    TPersonage selectByPrimaryKeyUser(String id);
}
