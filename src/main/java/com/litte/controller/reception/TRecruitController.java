package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.reception.TRecruit;
import com.litte.service.reception.TRecruitService;
import com.litte.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * 招聘管理
 */
@Controller
@RequestMapping(value = "/recruit")
public class TRecruitController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//自定义格式
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor( dateFormat, true));
    }

    @Autowired
    TRecruitService tRecruitService;

    /**
     * 进入招聘列表页面
     * @return
     */
    @RequestMapping(value = "/listRecruitView")
    public String listRecruitView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/recruit/recruitlist";
    }

    /**
     * 招聘列表
     *
     * @return
     */
    @RequestMapping(value = "/listRecruit")
    @ResponseBody
    public String listRecruit(TRecruit recruit, int rows, HttpServletRequest request) {
        PageHelper.startPage(recruit.getPage(),rows);//分页查询
        List<TRecruit> tRecruitList = tRecruitService.selectByExample(recruit);
        PageInfo<TRecruit> pageInfo = new PageInfo<>(tRecruitList);
        recruit.setPageSize(rows);
        recruit.setRows(tRecruitList);
        recruit.setPage(recruit.getPage());
        recruit.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(recruit);
    }


    /**
     * 接口招聘列表
     *
     * @return
     */
    @RequestMapping(value = "/listRecruitByPort")
    @ResponseBody
    public List<TRecruit> listRecruitByPort(TRecruit recruit) {
        List<TRecruit> tDeptList = tRecruitService.selectByExample(recruit);
        return tDeptList;
    }


    /**
     * 接口单条招聘列表
     *
     * @return
     */
    @RequestMapping(value = "/listRecruitByPortId")
    @ResponseBody
    public TRecruit listRecruitByPortId(TRecruit recruit) {
        TRecruit tDeptList = tRecruitService.selectByPrimaryKey(recruit.getId());
        return tDeptList;
    }


    /**
     * 增加、修改部门
     * @return
     */
    @RequestMapping(value = "/addRecruit")
    @ResponseBody
    public int addRecruit(TRecruit recruit,HttpServletRequest request,String headPortrait) {
        int i = 0;
        if (StringUtil.isNotEmpty(recruit.getId())) {
            i = tRecruitService.updateByPrimaryKeySelective(recruit);
        } else {
            i = tRecruitService.insertSelective(recruit);
        }
        return i;
    }

    /**
     * 进入增加部门页面
     * @return
     */
    @RequestMapping(value = "/addRecruitView")
    public String addRecruitView() {
        return "html/reception/recruit/recruitadd";
    }

    /**
     * 进入修改部门页面
     * @return
     */
    @RequestMapping(value = "/updRecruitView")
    public String updRecruitView(String id,Model model) {
        TRecruit recruit = tRecruitService.selectByPrimaryKey(id);
        model.addAttribute("recruit",recruit);
        return "html/reception/recruit/recruitupd";
    }

    /**
     * 删除部门
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delRecruit")
    @ResponseBody
    public String delRecruit(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));

        int deldRecruit = tRecruitService.deleteByPrimaryKey(idlist);
        if(deldRecruit>0) {
            String a = JsonUtil.toSuccess();
            return a;
        } else {
            return "";
        }

    }
}
