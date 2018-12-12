package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litte.entity.reception.TPersonage;
import com.litte.service.reception.TPersonageService;
import com.litte.util.BaseController;
import com.litte.util.HttpUtil;
import com.litte.util.JsonUtil;
import com.litte.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关注用户管理
 */
@Controller
@RequestMapping(value = "/personage")
public class TPersonageController extends BaseController {

    @Autowired
    TPersonageService tPersonageService;


    /**
     * 进入关注用户列表页面
     * @return
     */
    @RequestMapping(value = "/listPersonageView")
    public String listPersonageView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/personagelist";
    }

    /**
     * 关注用户列表
     *
     * @return
     */
    @RequestMapping(value = "/listPersonage")
    @ResponseBody
    public String listPersonage(TPersonage personage, int rows) {

        PageHelper.startPage(personage.getPage(),rows);//分页查询
        List<TPersonage> tTPersonageList = tPersonageService.selectByExample(personage);
        PageInfo<TPersonage> pageInfo = new PageInfo<>(tTPersonageList);
        personage.setPageSize(rows);
        personage.setRows(tTPersonageList);
        personage.setPage(personage.getPage());
        personage.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(personage);
    }

    /**
     * 增加关注用户
     * @return
     */
    @RequestMapping(value = "/addPersonage")
    @ResponseBody
    public Map<String,Object> addPersonage(TPersonage personage,String code) {
        Map<String,Object> m = HttpUtil.sendGet(code);
        personage.setUserId(m.get("openid").toString());
        personage.setSessionKey(m.get("session_key").toString());
        personage.setId(UUIDUtil.getUUID());
        personage.setCreateTime(new Date());
        if(m.get("unionid") != null) {
            personage.setUnionid( m.get("unionid").toString());
        }
        int i = 0;
        Map<String,Object> map = new HashMap<>();
        if(m.get("errcode") != null) {
            map.put("id",null);
            return map;
        }
        String id  = tPersonageService.insertSelective(personage);
        map.put("id",id);
        return map;
    }

    /**
     * 修改关注用户可以登录后台
     * @return
     */
    @RequestMapping(value = "/updPersonage")
    @ResponseBody
    public int updPersonage(TPersonage personage) {
        int i = 0;
        /*if(personage.getIsLogin().equals("1")) {
            personage.setIsLogin("0");
        } else {
            personage.setIsLogin("1");
        }*/
        i = tPersonageService.updateByPrimaryKeySelective(personage);
        return i;
    }

    /**
     * 查询单个用户
     * @return
     */
    @RequestMapping(value = "/seleByKeyPort")
    @ResponseBody
    public TPersonage seleByKeyPort(String id) {

        TPersonage personage = tPersonageService.selectByPrimaryKeyUser(id);
        return personage;
    }


}
