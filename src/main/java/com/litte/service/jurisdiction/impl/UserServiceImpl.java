package com.litte.service.jurisdiction.impl;

import com.github.pagehelper.StringUtil;
import com.litte.entity.jurisdiction.TUser;
import com.litte.mapper.jurisdiction.TUserMapper;
import com.litte.service.jurisdiction.UserService;
import com.litte.util.Md5Util;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public List<TUser> selectByExample(TUser user) {
        return tUserMapper.selectByExample(user);
    }

    @Override
    public List<TUser> listUserByPort(List<String> deptId) {
        return tUserMapper.listUserByPort(deptId);
    }

    @Override
    public int insertSelective(TUser record) {
        record.setPassword(Md5Util.md5(record.getPassword()));
        record.setAddTime(new Date());
        record.setUserId(UUIDUtil.getUUID());
        return tUserMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TUser record) {
        if(StringUtil.isNotEmpty(record.getPassword())) {
            record.setPassword(Md5Util.md5(record.getPassword()));
        }
        return tUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return tUserMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public TUser selectByPrimaryKey(String userId) {
        return tUserMapper.selectByPrimaryKey(userId);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public TUser selectByNamePas(TUser user) {
        return tUserMapper.selectByNamePas(user);
    }
}
