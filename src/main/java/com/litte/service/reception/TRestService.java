package com.litte.service.reception;

import com.litte.entity.reception.TRest;

import java.util.List;

public interface TRestService {

    int deleteByPrimaryKey(List<String> ids);

    int insertSelective(TRest record);

    List<TRest> selectByExample(TRest record);

    List<TRest> seleDateStaffRort(TRest record);

    TRest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TRest record);
}
