package com.litte.service.tree.impl;

import com.alibaba.fastjson.JSONObject;
import com.litte.entity.jurisdiction.TMenu;
import com.litte.mapper.jurisdiction.TMenuMapper;
import com.litte.mapper.jurisdiction.TMenuRoleMapper;
import com.litte.service.tree.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    TMenuMapper tMenuMapper;
    @Autowired
    TMenuRoleMapper tMenuRoleMapper;
    @Override
    public String selectByExample(Map<String, Object> map) {
        List<String> menuIds = tMenuRoleMapper.selectByExample(map.get("roleId").toString());
        List<TMenu> listmap = tMenuMapper.selectByExample(map);
        List<JSONObject> nodeList = parseObjTree(listmap,menuIds);
        return JSONObject.toJSONString(nodeList);
    }

    @Override
    public String selectByLisAll(TMenu menu) {
        List<TMenu> listmap = tMenuMapper.selectByLisAll(menu);
        List<JSONObject> nodeList = parseObjTree(listmap);
        return JSONObject.toJSONString(nodeList);
    }

    /**
     * @Title: parseObj2Tree
     * @Description: 将查询的树转化成前台页面使用的数据
     * @author: 王超
     * @param listmap
     * @return
     */
    private List<JSONObject> parseObjTree(List<TMenu> listmap) {
        List<JSONObject> nodeList = new ArrayList<JSONObject>();
        for(TMenu mapdata :listmap) {
            JSONObject jb = new JSONObject();
            jb.put("id", mapdata.getId());
            jb.put("pId", mapdata.getPid());
            jb.put("name", mapdata.getText());
            nodeList.add(jb);
        }
        return nodeList;
    }
    /**
     * @Title: parseObj2Tree
     * @Description: 将查询的树转化成前台页面使用的数据
     * @author: 王超
     * @param listmap
     * @return
     */
    private List<JSONObject> parseObjTree(List<TMenu> listmap,List<String> menuId) {
        List<JSONObject> nodeList = new ArrayList<JSONObject>();
        for(TMenu mapdata :listmap) {
            JSONObject jb = new JSONObject();
            jb.put("id", mapdata.getId());
            jb.put("pId", mapdata.getPid());
            jb.put("name", mapdata.getText());
            if(menuId.contains(mapdata.getId())) {
                jb.put("checked", "true");
            }
            nodeList.add(jb);
        }
        return nodeList;
    }

}
