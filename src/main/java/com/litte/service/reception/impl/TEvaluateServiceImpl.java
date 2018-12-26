package com.litte.service.reception.impl;

import com.litte.entity.reception.TEvaluate;
import com.litte.entity.reception.TIndent;
import com.litte.mapper.reception.TEvaluateMapper;
import com.litte.mapper.reception.TIndentMapper;
import com.litte.service.reception.TEvaluateService;
import com.litte.util.DateUtil;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TEvaluateServiceImpl implements TEvaluateService {

    @Autowired
    TEvaluateMapper tEvaluateMapper;
    @Autowired
    TIndentMapper tIndentMapper;

    @Override
    public int insertSelective(TEvaluate record) {

        TIndent indent = new TIndent();
        indent.setId(record.getId());
        indent.setiCondition("4");
        tIndentMapper.updateByPrimaryKeySelective(indent);
        record.setId(UUIDUtil.getUUID());
        record.setCreateTime(new Date());

        return tEvaluateMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return tEvaluateMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public List<Map<String,Object>> selectByExample(TEvaluate record) {
        return tEvaluateMapper.selectByExample(record);
    }

    @Override
    public List<Map<String, Object>> selectByExampleByPort(TEvaluate record) {
        List<Map<String, Object>> mapList = tEvaluateMapper.selectByExampleByPort(record);
        for (Map<String,Object> map: mapList) {
            map.put("createTime",DateUtil.formatDate((Date) map.get("createTime"),"yyyy-MM-dd HH:mm"));
        }
        return mapList;
    }

    @Override
    public int selCountByExampleByPort(TEvaluate evaluate) {
        return tEvaluateMapper.selCountByExampleByPort(evaluate);
    }
}
