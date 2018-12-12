package com.litte.service.jurisdiction;

import com.litte.entity.jurisdiction.TUser;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<TUser> selectByExample(TUser user);

    List<TUser> listUserByPort(List<String> deptId);

    int insertSelective(TUser record);

    int updateByPrimaryKeySelective(TUser record);

    int deleteByPrimaryKey(List<String> ids);

    TUser selectByPrimaryKey(String userId);

    TUser selectByNamePas(TUser user);
}
