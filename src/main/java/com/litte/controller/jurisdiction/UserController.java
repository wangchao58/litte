package com.litte.controller.jurisdiction;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.jurisdiction.TRole;
import com.litte.entity.jurisdiction.TUser;
import com.litte.entity.jurisdiction.TUserRole;
import com.litte.service.jurisdiction.RoleService;
import com.litte.service.jurisdiction.TDeptService;
import com.litte.service.jurisdiction.TUserRoleService;
import com.litte.service.jurisdiction.UserService;
import com.litte.util.BaseController;
import com.litte.util.JsonUtil;
import com.litte.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 用户管理
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {


    @Autowired
    UserService userService;

    @Autowired
    TDeptService tDeptService;

    @Autowired
    RoleService roleService;

    @Autowired
    TUserRoleService tUserRoleService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(TUser user, HttpServletRequest req) {

        Map<String, Object> loginMap = new HashMap<>();
        user.setPassword(Md5Util.md5(user.getPassword()));
        TUser loginUser = userService.selectByNamePas(user);
        if (loginUser != null) {
            List<String> groupIds = tDeptService.getGroupListIds(loginUser.getDeptId());
            loginUser.setGroups(groupIds);
            req.getSession().setAttribute("user", loginUser);
            loginMap.put("statusCode", "200");
        }
        return loginMap;

    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Map<String,Object> logout(HttpServletRequest req){
        req.getSession().setAttribute("user","");
        Map<String,Object> loginMap = new HashMap<>();
        loginMap.put("statusCode","200");
        return loginMap;
    }

    /**
     * 进入用户列表页面
     * @return
     */
    @RequestMapping(value = "/listUserView")
    public String listUserView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/authority/user/userlist";
    }

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping(value = "/listUser")
    @ResponseBody
    public String listUser(TUser user, int rows,HttpServletRequest request) {
        PageHelper.startPage(user.getPage(),rows);//分页查询
        user.setGroups(this.getSession(request).getGroups());
        List<TUser> tUserList = userService.selectByExample(user);
        PageInfo<TUser> pageInfo = new PageInfo<>(tUserList);
        user.setPageSize(rows);
        user.setRows(tUserList);
        user.setPage(user.getPage());
        user.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(user);
    }


    /**
     * 增加、修改用户
     * @return
     */
    @RequestMapping(value = "/addUser")
    @ResponseBody
    public int addUser(TUser user) {
        int i = 0;
        if (StringUtil.isNotEmpty(user.getUserId())) {
            i = userService.updateByPrimaryKeySelective(user);
        } else {
            i = userService.insertSelective(user);
        }
        return i;
    }

    /**
     * 进入增加用户页面
     * @return
     */
    @RequestMapping(value = "/addUserView")
    public String addUserView() {
        return "html/authority/user/useradd";
    }

    /**
     * 进入修改用户页面
     * @return
     */
    @RequestMapping(value = "/updUserView")
    public String updUserView(String id,Model model) {
        TUser user = userService.selectByPrimaryKey(id);

        user.setUrl("/file/download?fileName="+user.getHeadPortrait());
        user.setPassword("");
        model.addAttribute("user",user);
        return "html/authority/user/userupd";
    }

    /**
     * 进入用户授角色页面
     * @return
     */
    @RequestMapping(value = "/accreditRoleView")
    public String accreditRoleView(String id,Model model) {
        model.addAttribute("userId",id);
        return "html/authority/user/accreditRoleView";
    }

    /**
     * 查询角色页面
     * @return
     */
    @RequestMapping(value = "/accreditRole")
    @ResponseBody
    public Map<String,Object> accreditRole(HttpServletRequest request,TRole role) {
        TUser user = this.getSession(request);
        role.setUserId(user.getUserId());
        List<TRole> roleList = roleService.selectByExample(role);
        Map<String,Object> map = new HashMap<>();
        map.put("roleList",roleList);
        return map;
    }

    /**
     * 给用户授角色
     * @return
     */
    @RequestMapping(value = "/addRole")
    @ResponseBody
    public int addRole(TUserRole userRole) {
        int i = tUserRoleService.insert(userRole);
        return i;
    }

    /**
     * 根据ID获取用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/getUserById")
    public @ResponseBody String getUserById(String id) {
        if(!StringUtil.isEmpty(id)) {
            TUser user = userService.selectByPrimaryKey(id);
            user.setPassword("");
            String users = JSON.toJSONString(user);
            return users;
        } else {
            return null;
        }
    }

    /**
     * 删除用户
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delUser")
    @ResponseBody
    public String delUser(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));
        int delUser = userService.deleteByPrimaryKey(idlist);
        if(delUser>0) {
            String a = JsonUtil.toSuccess();
            return a;
        } else {
            return "";
        }

    }


    /**
     * 列表
     * @param request
     * @return
     */
    @RequestMapping("/listUserSele")
    @ResponseBody
    public List<TUser> listUserSele(HttpServletRequest request) {
        String deptid = this.getSession(request).getDeptId();
        List<String>deptIds = new ArrayList<>();
        deptIds.add(deptid);

        List<TUser> listUser = userService.listUserByPort(deptIds);
        return listUser;
    }

    /**
     * 部门下所有员工接口
     * @param deptId
     * @return
     */
    @RequestMapping("/listUserByPort")
    @ResponseBody
    public List<Map<String,Object>> listUserByPort(String deptId) {
        Map<String,Object> map = new HashMap<>();
        map.put("deptId",deptId);
        List<String> deptList = new ArrayList<>();
        deptList.add(deptId);
        if(StringUtil.isEmpty(deptId)) {
            return null;
        }
        List<Map<String,Object>> listUser = userService.listUserByPortMap(deptList);
        return listUser;
    }

    /**
     * 对账查询多有理发师
     * @param request
     * @return
     */
    @RequestMapping("/selUserList")
    @ResponseBody
    public List<TUser> selUserList(HttpServletRequest request) {
        List<String> deptIds = this.getSession(request).getGroups();
        List<TUser> listUser = userService.listUserByPort(deptIds);
        return listUser;
    }

}
