package com.litte.mapper.reception;

import com.litte.entity.reception.TWallet;
import com.litte.entity.reception.TWalletExample;
import java.util.List;

public interface TWalletMapper {
    int deleteByPrimaryKey(String id);

    int insert(TWallet record);

    int insertSelective(TWallet record);

    List<TWallet> selectByExample(TWallet record);

    TWallet selectByPrimaryKey(String id);

    TWallet selectByPrimaryUserId(String userId);

    int updateByPrimaryKeySelective(TWallet record);

    int updateByPrimaryKey(TWallet record);
}