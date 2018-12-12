package com.litte.controller.jurisdiction;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.jurisdiction.TMenu;
import com.litte.entity.jurisdiction.TUser;
import com.litte.service.jurisdiction.TMenuService;
import com.litte.util.BaseController;
import com.litte.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {


    @Autowired
    TMenuService tMenuService;

    /**
     * 菜单连接
     * @param request
     * @return
     */
    @RequestMapping(value = "/menuTree")
    @ResponseBody
    public List<TMenu> menuList( HttpServletRequest request) {
        TUser user = this.getSession(request);
        Map<String, Object> map = new HashMap<>();
        map.put("userId",user.getUserId());
        List<TMenu> tMenuList = tMenuService.selectByExample(map);
        return tMenuList;
    }

    /**
     * 店长排班权限接口
     * @param phone
     * @return
     */
    @RequestMapping(value = "/menuTreePort")
    @ResponseBody
    public Map<String,Object> menuTreePort(String phone) {
        Map<String, Object> map = new HashMap<>();
        if(StringUtil.isNotEmpty(phone)) {
            map.put("phone",phone);
            Map<String,Object> tMenuList = tMenuService.menuTreePort(map);
            return tMenuList;
        }
        return map;
    }


    /**
     * 进入菜单列表页面
     * @return
     */
    @RequestMapping(value = "/listMenuView")
    public String listMenuView(Model model,String pid,String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/authority/menu/menulist";
    }

    /**
     * 菜单列表
     *
     * @return
     */
    @RequestMapping(value = "/listMenu")
    @ResponseBody
    public String listMenu(TMenu menu,int rows) {

        PageHelper.startPage(menu.getPage(),rows);//分页查询
        List<TMenu> tMenuList = tMenuService.selectByLisAll(menu);
        PageInfo<TMenu> pageInfo = new PageInfo<>(tMenuList);
        menu.setPageSize(rows);
        menu.setRows(tMenuList);
        menu.setPage(menu.getPage());
        menu.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(menu);
    }


    /**
     * 增加菜单
     * @return
     */
    @RequestMapping(value = "/addMenu")
    @ResponseBody
    public int addMenu(TMenu menu) {
        int i = 0;
        if (StringUtil.isEmpty(menu.getId())) {
            i = tMenuService.insert(menu);
        } else {
            i = tMenuService.updateByPrimaryKeySelective(menu);
        }

        return i;
    }

    /**
     * 进入增加菜单页面
     * @return
     */
    @RequestMapping(value = "/addMenuView")
    public String addMenuView() {

        return "html/authority/menu/menuadd";
    }

    /**
     * 进入修改菜单页面
     * @return
     */
    @RequestMapping(value = "/updMenuView")
    public String updMenuView(String id,Model model) {

        if(StringUtil.isNotEmpty(id)) {
            TMenu menu = tMenuService.selectByPrimaryKey(id);
            model.addAttribute("menu",menu);
        }
        return "html/authority/menu/menuupd";
    }

    /**
     * 根据ID获取菜单
     * @param id
     * @return
     */
    @RequestMapping(value = "/getTmenu")
    public @ResponseBody String getTmenu(String id) {
        if(!StringUtil.isEmpty(id)) {
            TMenu menu = tMenuService.selectByPrimaryKey(id);
            String menus = JSON.toJSONString(menu);
            return menus;
        } else {
            return null;
        }
    }

    /**
     * 删除菜单
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delTmenu")
    @ResponseBody
    public int delTmenu(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));
        int delTmenu = tMenuService.deleteByList(idlist);
        return delTmenu;

    }
}
