package com.litte.service.jurisdiction.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.litte.entity.jurisdiction.TDept;
import com.litte.mapper.jurisdiction.TDeptMapper;
import com.litte.service.jurisdiction.TDeptService;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TDeptServiceImpl implements TDeptService {


    @Autowired
    TDeptMapper tDeptMapper;

    @Override
    public List<TDept> selectByExample(TDept dept) {
        return tDeptMapper.selectByExample(dept);
    }

    @Override
    public List<TDept> selectByExampleByPort(TDept dept) {

        return tDeptMapper.selectByExampleByPort(dept);
    }

    @Override
    public int insertSelective(TDept record) {
        record.setId(UUIDUtil.getUUID());
        String groupId = "";
        String maxGroupId = tDeptMapper.getMaxGroupId(record.getPid());
        if(StringUtil.isNotEmpty(maxGroupId)) {
            groupId = (Long.parseLong(maxGroupId)+1)+"";
        } else {
            TDept dept = tDeptMapper.selectByPrimaryKey(record.getPid());
            groupId =  dept.getGroupId()+"0001";
        }

        record.setGroupId(groupId);
        int i = tDeptMapper.insertSelective(record);
        return i;
    }

    @Override
    public int updateByPrimaryKeySelective(TDept record) {
        return tDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public TDept selectByPrimaryKey(String id) {
        return tDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public TDept selectBySmsKey(String id) {
        return tDeptMapper.selectBySmsKey(id);
    }

    @Override
    public int deleteByList(List<String> idlist) {
        return tDeptMapper.deleteByList(idlist);
    }

    /**
     * 部门树
     * @return
     */
    @Override
    public String selectByTree(TDept dept) {
        List<TDept> listmap = tDeptMapper.selectByExample(dept);
        List<JSONObject> nodeList = parseObjTree(listmap);
        return JSONObject.toJSONString(nodeList);
    }

    @Override
    public List<String> getGroupListIds(String id) {
        return tDeptMapper.getGroupListIds(id);
    }

    /**
     * 对账查询所有店铺
     * @param deptIds
     * @return
     */
    @Override
    public List<TDept> selDeptList(List<String> deptIds) {
        return tDeptMapper.selDeptList(deptIds);
    }

    /**
     * @Title: parseObj2Tree
     * @Description: 将查询的树转化成前台页面使用的数据
     * @author: huzhenxing
     * @param listmap
     * @return
     */
    private List<JSONObject> parseObjTree(List<TDept> listmap) {
        List<JSONObject> nodeList = new ArrayList<JSONObject>();
        for(TDept mapdata :listmap) {
            JSONObject jb = new JSONObject();
            jb.put("id", mapdata.getId());

            jb.put("pId", mapdata.getPid());
            jb.put("name", mapdata.getDeptName());

            nodeList.add(jb);
        }
        return nodeList;
    }
}
