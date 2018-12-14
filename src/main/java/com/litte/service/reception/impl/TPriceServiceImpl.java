package com.litte.service.reception.impl;

import com.github.pagehelper.StringUtil;
import com.litte.entity.reception.TPrice;
import com.litte.mapper.reception.TPriceMapper;
import com.litte.service.reception.TPriceService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TPriceServiceImpl implements TPriceService {


    @Autowired
    TPriceMapper tPriceMapper;

    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return tPriceMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int insertSelective(TPrice record) {
        record.setId(UUIDUtil.getUUID());
        return tPriceMapper.insertSelective(record);
    }

    @Override
    public TPrice selectByPrimaryKey(String id) {
        return tPriceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TPrice record) {
        return tPriceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TPrice> selectByExample(TPrice record) {
        return tPriceMapper.selectByExample(record);
    }

    @Override
    public List<TPrice> listPriceUserByPort(Map<String, Object> map) {
        List<TPrice> pricesList = tPriceMapper.listPriceUserByPort(map);

        List<Map<String,Object>> maps = tPriceMapper.listPriceUserRestByPort(map);

        for(TPrice price : pricesList) {
            for( int i =0;i< maps.size();i++) {
                if(maps.get(i).get("staffId").equals(price.getUserId())) {
                    price.setIsHour(maps.get(i).get("isHour").toString());//最早可预约
                    price.setIsRest(maps.get(i).get("isRest").toString());//是否休息
                    price.setIsDate(maps.get(i).get("isDate").toString());//日期
                    maps.remove(i);
                }
            }
            if(StringUtil.isNotEmpty(price.getIsRest()) && !price.getIsRest().equals("1")) {
                price.setIsRest("2");//约满
            }
            if(StringUtil.isEmpty(price.getIsRest()) || !price.getIsRest().equals("0") ){//如果休息或约满
                map.put("staffId",price.getUserId());
                Map<String,Object> listPriceDate = tPriceMapper.listPriceDateRestByPort(map);
                price.setIsHour(listPriceDate.get("isHour").toString());//最早可预约
                price.setIsDate(listPriceDate.get("isDate").toString());//日期
            }
        }
        return pricesList;
    }


    @Override
    public List<Map<String, Object>> listPriceRestByPort(Map<String, Object> map) {
        List<Map<String, Object>> pricesList =tPriceMapper.listPriceRestByPort(map);
        return pricesList;
    }
}
