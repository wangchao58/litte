package com.litte.controller.jurisdiction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.jurisdiction.TTerritory;
import com.litte.service.jurisdiction.TerritoryService;
import com.litte.util.BaseController;
import com.litte.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 地区管理
 */
@Controller
@RequestMapping(value = "/territory")
public class TerritoryController extends BaseController {

    @Autowired
    TerritoryService territoryService;

    /**
     * 进入地区管理列表页面
     * @return
     */
    @RequestMapping(value = "/listTerritoryView")
    public String listMenuView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/authority/territory/territorylist";
    }

    /**
     * 地区管理列表
     * @return
     */
    @RequestMapping(value = "/listTerritory")
    @ResponseBody
    public String listTerritory(TTerritory tTerritory, int rows, HttpServletRequest request) {
        PageHelper.startPage(tTerritory.getPage(),rows);//分页查询
        List<TTerritory> tRoleList = territoryService.selectByExample(tTerritory);
        PageInfo<TTerritory> pageInfo = new PageInfo<>(tRoleList);
        tTerritory.setPageSize(rows);
        tTerritory.setRows(tRoleList);
        tTerritory.setPage(tTerritory.getPage());
        tTerritory.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(tTerritory);
    }

    /**
     * 查询地区列表
     * @return
     */
    @RequestMapping(value = "/listTerritorySele")
    @ResponseBody
    public List<TTerritory> listTerritorySele(TTerritory tTerritory) {
        List<TTerritory> tRoleList = territoryService.selectByExample(tTerritory);
        return tRoleList;
    }

    /**
     * 进入增加地区管理页面
     * @return
     */
    @RequestMapping(value = "/addTerritoryView")
    public String addTerritoryView() {

        return "html/authority/territory/territoryadd";
    }

    /**
     * 进入修改地区管理页面
     * @return
     */
    @RequestMapping(value = "/updTerritoryView")
    public String updTerritoryView(String id,Model model) {

        if(StringUtil.isNotEmpty(id)) {
            TTerritory tTerritory = territoryService.selectByPrimaryKey(id);
            model.addAttribute("tTerritory",tTerritory);
        }
        return "html/authority/territory/territoryupd";

    }

    /**
     * 增加、修改地区管理
     * @return
     */
    @RequestMapping(value = "/addTerritory")
    @ResponseBody
    public int addTerritory(TTerritory tTerritory) {
        int i = 0;
        tTerritory.setCreateTime(new Date());
        if (StringUtil.isNotEmpty(tTerritory.getId())) {
            i = territoryService.updateByPrimaryKeySelective(tTerritory);
        } else {
            i = territoryService.insertSelective(tTerritory);
        }
        return i;
    }

    /**
     * 删除地区管理
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delTerritory")
    @ResponseBody
    public String delTerritory(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));
        int delUser = territoryService.deleteByPrimaryKey(idlist);
        if(delUser>0) {
            String a = JsonUtil.toSuccess();
            return a;
        } else {
            return "";
        }

    }
}
