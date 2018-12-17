package com.litte.service.reception;

import com.litte.entity.reception.TStated;
import com.litte.entity.reception.TWallet;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface TWalletService {

    int insertSelective(TWallet record);

    List<TWallet> selectByExample(TWallet record);

    Map<String,Object> payWallet(Map<String,Object> map , HttpServletRequest request) throws Exception;

    int payUpdateWallet(Map<String,Object> map) throws Exception;

    TWallet selWalletByUser(TWallet record);
}
