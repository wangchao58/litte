package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.reception.TProjects;
import com.litte.service.reception.TProjectsService;
import com.litte.util.BaseController;
import com.litte.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 服务管理
 */
@Controller
@RequestMapping(value = "/projects")
public class TProjectsController extends BaseController {

    @Autowired
    TProjectsService tProjectsService;

    /**
     * 进入服务管理列表页面
     * @return
     */
    @RequestMapping(value = "/listProjectsView")
    public String listProjectsView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/projects/projectslist";
    }
    /**
     * 服务管理列表
     *
     * @return
     */
    @RequestMapping(value = "/listProjects")
    @ResponseBody
    public String listProjects(TProjects projects, int rows, HttpServletRequest request) {
        PageHelper.startPage(projects.getPage(),rows);//分页查询
        List<String> deptIds = this.getSession(request).getGroups();
        projects.setDeptIds(deptIds);
        List<TProjects> tProjectsList = tProjectsService.selectByExample(projects);
        PageInfo<TProjects> pageInfo = new PageInfo<>(tProjectsList);
        projects.setPageSize(rows);
        projects.setRows(tProjectsList);
        projects.setPage(projects.getPage());
        projects.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(projects);
    }

    /**
     * 服务管理列表
     *
     * @return
     */
    @RequestMapping(value = "/listProjectsByPort")
    @ResponseBody
    public List<TProjects> listProjectsByPort(String deptId,TProjects projects,HttpServletRequest request ) {
        if(StringUtil.isNotEmpty(deptId)) {
            projects.setDeptId(deptId);
        } else {
            projects.setDeptId(this.getSession(request).getDeptId());
        }
        if(StringUtil.isEmpty(projects.getDeptId())) {
            return null;
        }
        List<TProjects> tProjectsList = tProjectsService.selectByExample(projects);
        return tProjectsList;
    }


    /**
     * 增加\修改服务管理
     * @return
     */
    @RequestMapping(value = "/addProjects")
    @ResponseBody
    public int addProjects(TProjects projects,HttpServletRequest request) {
        int i = 0;
        if (StringUtil.isNotEmpty(projects.getId())) {
            i = tProjectsService.updateByPrimaryKeySelective(projects);
        } else {
            projects.setDeptId(this.getSession(request).getDeptId());
            i = tProjectsService.insertSelective(projects);
        }
        return i;
    }

    /**
     * 进入增加服务管理页面
     * @return
     */
    @RequestMapping(value = "/addProjectsView")
    public String addProjectsView() {
        return "html/reception/projects/projectsadd";
    }

    /**
     * 进入修改服务管理
     * @return
     */
    @RequestMapping(value = "/updProjectsView")
    public String updProjectsView(String id,Model model) {
        TProjects projects = tProjectsService.selectByPrimaryKey(id);
        model.addAttribute("projects",projects);
        return "html/reception/projects/projectsupd";
    }

    /**
     * 删除服务管理
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delProjects")
    @ResponseBody
    public int delProjects(String ids){
        List idlist = Arrays.asList(ids.split(","));
        int delProjects = tProjectsService.deleteByPrimaryKey(idlist);
        return delProjects;
    }
}
