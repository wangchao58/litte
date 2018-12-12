package com.litte.controller.tree;


import com.litte.entity.jurisdiction.TDept;
import com.litte.entity.jurisdiction.TMenu;
import com.litte.service.jurisdiction.TDeptService;
import com.litte.service.tree.TreeService;
import com.litte.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 树管理
 */
@Controller
@RequestMapping(value = "/tree")
public class TreeController extends BaseController {

    @Autowired
    TreeService treeService;

    @Autowired
    TDeptService tDeptService;

    /**
     * 菜单连接
     * @param request
     * @return
     */
    @RequestMapping(value = "/menuTree")
    @ResponseBody
    public String menuList(HttpServletRequest request,String roleId) {
        Map<String, Object> map = new HashMap<>();
        String userId = this.getSession(request).getUserId();
        map.put("userId",userId);
        map.put("roleId",roleId);
        String ztree = treeService.selectByExample(map);
        return ztree;
    }

    /**
     * 所有菜单连接
     * @param
     * @return
     */
    @RequestMapping(value = "/menuListAll")
    @ResponseBody
    public String menuListAll(TMenu menu) {
        String ztree = treeService.selectByLisAll(menu);
        return ztree;
    }

    /**
     * 部门菜单
     * @param
     * @return
     */
    @RequestMapping(value = "/deptZtree")
    @ResponseBody
    public String deptZtree(TDept dept, HttpServletRequest request) {

        dept.setIds(this.getSession(request).getGroups());
        String ztree = tDeptService.selectByTree(dept);
        return ztree;
    }


}
