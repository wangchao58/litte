package com.litte.controller.jurisdiction;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.jurisdiction.TMenuRole;
import com.litte.entity.jurisdiction.TRole;
import com.litte.entity.jurisdiction.TUser;
import com.litte.service.jurisdiction.RoleService;
import com.litte.service.jurisdiction.TMenuRoleService;
import com.litte.util.BaseController;
import com.litte.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 角色管理
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    @Autowired
    RoleService roleService;
    @Autowired
    TMenuRoleService tMenuRoleService;

    /**
     * 进入角色列表页面
     * @return
     */
    @RequestMapping(value = "/listRoleView")
    public String listRoleView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/authority/role/rolelist";
    }

    /**
     * 角色列表
     *
     * @return
     */
    @RequestMapping(value = "/listRole")
    @ResponseBody
    public String listRole(TRole role, int rows,HttpServletRequest request) {
        role.setUserId(this.getSession(request).getUserId());
        PageHelper.startPage(role.getPage(),rows);//分页查询
        List<TRole> tRoleList = roleService.selectByExample(role);
        PageInfo<TRole> pageInfo = new PageInfo<>(tRoleList);
        role.setPageSize(rows);
        role.setRows(tRoleList);
        role.setPage(role.getPage());
        role.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(role);
    }


    /**
     * 增加\角色
     * @return
     */
    @RequestMapping(value = "/addRole")
    @ResponseBody
    public int addRole(TRole role, HttpServletRequest request) {
        int i = 0;
        TUser user = this.getSession(request);
        if (StringUtil.isEmpty(role.getRoleId())) {
            role.setUserId(user.getUserId());
            i = roleService.insertSelective(role);
        } else {
            i = roleService.updateByPrimaryKeySelective(role);
        }
        return i;
    }

    /**
     * 进入增加角色页面
     * @return
     */
    @RequestMapping(value = "/addRoleView")
    public String addRoleView() {
        return "html/authority/role/roleadd";
    }

    /**
     * 进入修改角色页面
     * @return
     */
    @RequestMapping(value = "/updRoleView")
    public String updRoleView(String id,Model model) {
        TRole role = roleService.selectByPrimaryKey(id);
        model.addAttribute("role",role);
        return "html/authority/role/roleupd";
    }

    /**
     * 进入授权页面
     * @return
     */
    @RequestMapping(value = "/accredit")
    public String accredit(String id,Model model) {
        model.addAttribute("id",id);
        return "html/authority/role/accredit";
    }

    /**
     * 给角色授权
     * @return
     */
    @RequestMapping(value = "/accreditAdd")
    public @ResponseBody int accreditAdd(TMenuRole tMenuRole) {
        int i = tMenuRoleService.insert(tMenuRole);

        return i;
    }

    /**
     * 根据ID获取角色
     * @param id
     * @return
     */
    @RequestMapping(value = "/getRole")
    public @ResponseBody String getRole(String id) {
        if(!StringUtil.isEmpty(id)) {
            TRole role = roleService.selectByPrimaryKey(id);
            String roles = JSON.toJSONString(role);
            return roles;
        } else {
            return null;
        }
    }

    /**
     * 删除角色
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delRole")
    @ResponseBody
    public String delRole(String ids){
        List idlist = Arrays.asList(ids.split(","));
        int delRole = roleService.deleteByListKey(idlist);
        if(delRole>0) {
            String a = JsonUtil.toSuccess();
            return a;
        } else {
            return "";
        }

    }
}
