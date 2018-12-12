package com.litte.mapper.reception;

import com.litte.entity.reception.TRest;
import com.litte.entity.reception.TRestExample;
import java.util.List;

public interface TRestMapper {

    int insert(TRest record);

    int deleteByPrimaryKey(List<String> ids);

    int deleteByPrimary(TRest record);

    int insertSelective(TRest record);

    List<TRest> selectByExample(TRest record);

    List<TRest> seleDateStaffRort(TRest record);

    TRest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TRest record);

    int updateByPrimaryKey(TRest record);
}