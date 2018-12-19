package com.litte.service.reception.impl;

import com.github.pagehelper.StringUtil;
import com.litte.entity.reception.TPrice;
import com.litte.mapper.reception.TPriceMapper;
import com.litte.service.reception.TPriceService;
import com.litte.util.DateUtil;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
                    List dateHours = Arrays.asList(maps.get(i).get("dateHour").toString().split(" ")) ;
                    price.setIsDate(dateHours.get(0).toString());//日期
                    price.setIsHour(dateHours.get(1).toString());//最早可预约
                    price.setIsReserve(maps.get(i).get("isReserve").toString());
                    maps.remove(i);
                }
            }

            if(StringUtil.isNotEmpty(price.getIsDate())&&!price.getIsDate().equals(DateUtil.nowDate())){//如果不是当天
                map.put("isDate",DateUtil.nowDate());
                map.put("staffId",price.getUserId());
                Map<String,Object> listPriceDate = tPriceMapper.listPriceDateRestByPort(map);

                if(!listPriceDate.get("isRest").equals("1") && !price.getIsReserve().equals("1")) {
                    price.setIsRest("2");//约满
                } else {
                    price.setIsRest(listPriceDate.get("isRest").toString());//正常
                }


                /*map.put("staffId",price.getUserId());
                if(StringUtil.isEmpty(price.getIsRest())) {
                    price.setIsRest("2");//约满
                }

                if(listPriceDate != null){
                    price.setIsHour(listPriceDate.get("isHour").toString());//最早可预约
                    price.setIsDate(listPriceDate.get("isDate").toString());//日期
                }*/
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
