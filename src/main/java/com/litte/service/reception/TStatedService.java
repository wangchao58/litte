package com.litte.service.reception;

import com.litte.entity.reception.TStated;

import java.util.List;

public interface TStatedService {

    int insertSelective(TStated record);

    List<TStated> selectByExample(TStated record);
}
