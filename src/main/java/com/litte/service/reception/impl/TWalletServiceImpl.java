package com.litte.service.reception.impl;

import com.litte.entity.PayUtil;
import com.litte.entity.reception.*;
import com.litte.mapper.reception.TCouponMapper;
import com.litte.mapper.reception.TPersonageMapper;
import com.litte.mapper.reception.TStatedMapper;
import com.litte.mapper.reception.TWalletMapper;
import com.litte.service.reception.TWalletService;
import com.litte.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TWalletServiceImpl implements TWalletService {


    @Autowired
    TWalletMapper tWalletMapper;

    @Autowired
    TCouponMapper tCouponMapper;

    @Autowired
    TPersonageMapper tPersonageMapper;

    @Autowired
    TStatedMapper tStatedMapper;
    @Autowired
    FileUploadUtil fileUploadUtil;

    @Override
    public int insertSelective(TWallet record) {
        record.setId(UUIDUtil.getUUID());
        return tWalletMapper.insertSelective(record);
    }

    @Override
    public List<TWallet> selectByExample(TWallet record) {
        return tWalletMapper.selectByExample(record);
    }

    @Override
    public Map<String, Object> payWallet(Map<String,Object> map, HttpServletRequest request) throws Exception {
        TCoupon coupon = tCouponMapper.selectByPrimaryKey(map.get("id").toString());
        TPersonage personage = tPersonageMapper.selectByPrimaryKeyUser(map.get("userId").toString());
        double total_fee = Double.parseDouble(coupon.getcMoneyReceipts())*100;
        int isss =  (new Double(total_fee)).intValue();
        String code = DateUtil.getDateTime();
        String id = UUIDUtil.getUUID();
        PayUtil payUtil = new PayUtil();
        payUtil.setBody("xxszfzx-czzf");
        payUtil.setOut_trade_no(code);
        payUtil.setNonce_str(id);
        payUtil.setTotal_fee(isss);
        payUtil.setNotify_url(fileUploadUtil.getBaseUrl()+"/wallet/walletCardOrder");
        payUtil.setOpenid(personage.getUserId());
        map=WinxinUtil.wxPay(payUtil,request);
        //map.put("timeStamp",new Date().getTime());

        String nonceStr = UUIDUtil.getUUID().toUpperCase();
        String dateTime = String.valueOf (new Date().getTime());
        String signType = "MD5";
        String packages = "prepay_id="+map.get("prepay_id").toString();
        map.put("timeStamp",dateTime);
        String paySign="appId="+map.get("appid")
                +"&nonceStr=" +nonceStr
                +"&package="+packages
                +"&signType="+signType
                +"&timeStamp="+dateTime
                +"&key=xinxingshang2018xinxingshang2018";
        map.put("paySign",Md5Util.md5(paySign).toUpperCase());
        map.put("nonceStr",nonceStr);
        map.put("signType",signType);
        map.put("package",packages);
        TStated record = new TStated();

        record.setId(id);
        record.setCreateTime(new Date());
        record.setUserId(personage.getId());
        record.setsAmount(coupon.getcMoney());
        record.setsReal(coupon.getcMoneyReceipts());
        TWallet wallet = new TWallet();
        wallet.setId(UUIDUtil.getUUID());
        wallet.setUserId(personage.getId());
        wallet.setPhone(personage.getPhone());
        wallet.setCouponId(coupon.getId());
        wallet.setwMoney("0");
        tWalletMapper.insert(wallet);
        int i = tStatedMapper.insertSelective(record);
        if (i > 0) {
            return  map;
        }
        return  null;
    }

    @Override
    public int payUpdateWallet(Map<String, Object> map) throws Exception {
        String return_code = (String) map.get("return_code");
        System.out.println("接收到的状态是否成功："+ return_code);
        String id = (String) map.get("nonce_str");
        System.out.println("接收到的ID是否正常："+ id);
        TStated stated = tStatedMapper.selectByPrimaryKey(id);
        System.out.println("查出的ID是否正常："+ stated.getId());
        if (stated.getIsSucceed().equals("0")) {
            if (return_code.equals("SUCCESS")) {
                TWallet wallet = tWalletMapper.selectByPrimaryUserId(stated.getUserId());
                System.out.println("查出的钱包ID："+ wallet.getId());
                Double a = Double.parseDouble(wallet.getwMoney())+Double.parseDouble(stated.getsAmount());
                wallet.setwMoney(a.toString());
                System.out.println("充值的钱数："+ a);
                int i = tWalletMapper.updateByPrimaryKeySelective(wallet);
                System.out.println("钱包是否充值成功："+ i);
                stated.setIsSucceed("1");
                int j = tStatedMapper.updateByPrimaryKeySelective(stated);
                System.out.println("充值记录是否充值成功："+ j);
            }
        }
        return 0;
    }

    @Override
    public TWallet selWalletByUser(TWallet record) {
        return tWalletMapper.selectByPrimaryUser(record.getUserId());
    }
}
