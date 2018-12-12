package com.litte.mapper.reception;

import com.litte.entity.reception.TStated;
import com.litte.entity.reception.TStatedExample;
import java.util.List;

public interface TStatedMapper {
    int deleteByPrimaryKey(String id);

    int insert(TStated record);

    int insertSelective(TStated record);

    List<TStated> selectByExample(TStated record);

    TStated selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TStated record);

    int updateByPrimaryKey(TStated record);
}