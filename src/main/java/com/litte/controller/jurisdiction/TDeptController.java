package com.litte.controller.jurisdiction;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.jurisdiction.TDept;
import com.litte.entity.jurisdiction.TUser;
import com.litte.service.jurisdiction.TDeptService;
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
 * 部门管理
 */
@Controller
@RequestMapping(value = "/dept")
public class TDeptController extends BaseController {

    @Autowired
    TDeptService tDeptService;

    /**
     * 进入部门列表页面
     * @return
     */
    @RequestMapping(value = "/listDeptView")
    public String listDeptView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/authority/dept/deptlist";
    }

    /**
     * 部门列表
     *
     * @return
     */
    @RequestMapping(value = "/listDept")
    @ResponseBody
    public String listDept(TDept dept, int rows, HttpServletRequest request) {
        PageHelper.startPage(dept.getPage(),rows);//分页查询
        dept.setIds(this.getSession(request).getGroups());
        List<TDept> tDeptList = tDeptService.selectByExample(dept);
        PageInfo<TDept> pageInfo = new PageInfo<>(tDeptList);
        dept.setPageSize(rows);
        dept.setRows(tDeptList);
        dept.setPage(dept.getPage());
        dept.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(dept);
    }


    /**
     * 接口部门列表
     *
     * @return
     */
    @RequestMapping(value = "/listDeptByPort")
    @ResponseBody
    public List<TDept> listDeptByPort(TDept dept,String id) {
        dept.setArea(id);
        List<TDept> tDeptList = tDeptService.selectByExampleByPort(dept);
        return tDeptList;
    }


    /**
     * 增加、修改部门
     * @return
     */
    @RequestMapping(value = "/addDept")
    @ResponseBody
    public int addDept(TDept dept,HttpServletRequest request,String headPortrait) {
        int i = 0;
        dept.setPortrait(headPortrait);
        if (StringUtil.isNotEmpty(dept.getId())) {
            i = tDeptService.updateByPrimaryKeySelective(dept);
        } else {
            i = tDeptService.insertSelective(dept);
            TUser user = (TUser) request.getSession().getAttribute("user");
            List<String> groupIds = tDeptService.getGroupListIds(user.getDeptId());
            user.setGroups(groupIds);
            request.getSession().setAttribute("user", user);
        }
        return i;
    }

    /**
     * 进入增加部门页面
     * @return
     */
    @RequestMapping(value = "/addDeptView")
    public String addDeptView() {
        return "html/authority/dept/deptadd";
    }

    /**
     * 进入修改部门页面
     * @return
     */
    @RequestMapping(value = "/updDeptView")
    public String updDeptView(String id,Model model) {
        TDept dept = tDeptService.selectByPrimaryKey(id);
        model.addAttribute("dept",dept);
        return "html/authority/dept/deptupd";
    }

    /**
     * 获取单个部门数据
     * @return
     */
    @RequestMapping(value = "/selDeptByIdPort")
    @ResponseBody
    public TDept selDeptByIdPort(String id) {
        if(StringUtil.isNotEmpty(id)) {
            TDept dept = tDeptService.selectByPrimaryKey(id);
            return dept;
        }
        return null;
    }

    /**
     * 删除部门
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delDept")
    @ResponseBody
    public String delDept(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));
        if(idlist.contains("1")) {
            idlist.remove("1");
        }
        int deldDept = tDeptService.deleteByList(idlist);
        if(deldDept>0) {
            String a = JsonUtil.toSuccess();
            return a;
        } else {
            return "";
        }

    }

}
