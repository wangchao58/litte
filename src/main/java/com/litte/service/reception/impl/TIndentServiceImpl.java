package com.litte.service.reception.impl;

import com.github.pagehelper.StringUtil;
import com.litte.entity.jurisdiction.TUser;
import com.litte.entity.reception.TIndent;
import com.litte.entity.reception.TPersonage;
import com.litte.entity.reception.TWallet;
import com.litte.mapper.jurisdiction.TUserMapper;
import com.litte.mapper.reception.TIndentMapper;
import com.litte.mapper.reception.TPersonageMapper;
import com.litte.mapper.reception.TWalletMapper;
import com.litte.service.reception.TIndentService;
import com.litte.util.DateUtil;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TIndentServiceImpl implements TIndentService {

    @Autowired
    TIndentMapper tIndentMapper;

    @Autowired
    TWalletMapper tWalletMapper;

    @Autowired
    TPersonageMapper tPersonageMapper;

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return 0;
    }

    @Override
    public TIndent insertSelective(TIndent record) {

        int i = 0;
        /*TWallet tWallet = tWalletMapper.selectByPrimaryUserId(record.getUserId());
        Double wMoney = Double.parseDouble(tWallet.getwMoney());
        Double iPrice = Double.parseDouble(record.getiPrice());
        Double m = wMoney - iPrice;
        if(m>=0) {
            tWallet.setwMoney(m.toString());
            int j = tWalletMapper.updateByPrimaryKeySelective(tWallet);
            if(j > 0) {*/
        record.setiTime(record.getIsTime());
        record.setiCode(DateUtil.getDateTime());
        record.setiCondition("0");
        i = tIndentMapper.insertSelective(record);
        if(i>0) {
            record = tIndentMapper.selectByPrimaryKey(record.getId());
        }
         /*   }
        } else {
            return i;
        }*/

        return record;

    }

    @Override
    public List<TIndent> selectByExample(TIndent record) {
        return tIndentMapper.selectByExample(record);
    }

    @Override
    public TIndent updateByPrimaryKeySelective(TIndent record) {
        record.setChangingTime(record.getiTime());
        int i = tIndentMapper.updateByPrimaryKeySelective(record);
        if(i>0) {
            record =tIndentMapper.selectByPrimaryKey(record.getId());
        }
        return record;
    }

    @Override
    public int updateByPrimaryKeyJob(TIndent record) {
        return tIndentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyPay(TIndent record) {
        int i = 0;
        TIndent records = tIndentMapper.selectByPrimaryKey(record.getId());
        TWallet tWallet = tWalletMapper.selectByPrimaryUserId(records.getOpenid());
        Double wMoney = Double.parseDouble(tWallet.getwMoney());
        Double iPrice = Double.parseDouble(record.getiPrice());
        Double m = wMoney - iPrice;
        if(m>=0) {
            tWallet.setwMoney(String.format("%.2f", m));
            i = tWalletMapper.updateByPrimaryKeySelective(tWallet);
        }
        return i;
    }

    @Override
    public int updateByPrimaryKeyRefund(TIndent record) {
        int i = 0;
        TIndent records = tIndentMapper.selectByPrimaryKey(record.getId());
        TWallet tWallet = tWalletMapper.selectByPrimaryUserId(records.getOpenid());
        Double wMoney = Double.parseDouble(tWallet.getwMoney());
        Double iPrice = Double.parseDouble(records.getiPrice());
        Double m = wMoney + iPrice;
        tWallet.setwMoney(String.format("%.2f", m));
        i = tWalletMapper.updateByPrimaryKeySelective(tWallet);
        records.setiCondition("5");
        tIndentMapper.updateByPrimaryKeySelective(records);
        return i;
    }

    @Override
    public Map<String, Object> accountByList(Map<String, Object> map) {
        Map<String,Object> mapAll = new HashMap<>();
        map.put("mode","0");
        String weinxin = tIndentMapper.accountByList(map);
        map.put("mode","1");
        String kaquan = tIndentMapper.accountByList(map);
        mapAll.put("weinxin",weinxin);
        mapAll.put("kaquan",kaquan);
        return mapAll;
    }

    @Override
    public TIndent selectByPrimaryKey(String id) {
        TIndent indent = tIndentMapper.selectByPrimaryKey(id);
        TPersonage tPersonage = tPersonageMapper.selectByPrimaryKeyUser(indent.getOpenid());
        indent.setOpenid(tPersonage.getUserId());
        return indent;
    }

    @Override
    public TIndent selectJob() {
        return tIndentMapper.selectJob();
    }

    @Override
    public TIndent selectCancelIndent() {
        return tIndentMapper.selectCancelIndent();
    }

    @Override
    public List<Map<String, Object>> selIndentByUser(TIndent record) {
        return tIndentMapper.selIndentByUser(record);
    }

    @Override
    public List<Map<String, Object>> selIndentByHair(TIndent record) {
        TPersonage personage  = tPersonageMapper.selectByPrimaryKeyUser(record.getOpenid());
        TUser user = tUserMapper.selectByNamePhone(personage.getPhone());
        if(user != null && StringUtil.isNotEmpty(user.getUserId())) {
            record.setHairId(user.getUserId());
            if(record.getiCondition().equals("undefined")) {
                record.setiCondition("1");
            }
            List<Map<String, Object>> mapList = tIndentMapper.selIndentByHair(record);
            return mapList;
        } else {
            return null;
        }

    }

    @Override
    public List<Map<String, Object>> selIndentByHairById(TIndent record) {
        List<Map<String, Object>> mapList = tIndentMapper.selIndentByHairById(record);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> selIndentByPort(TIndent record) {
        return tIndentMapper.selIndentByPort(record);
    }


}
