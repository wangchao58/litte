package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.reception.TRest;
import com.litte.service.reception.TRestService;
import com.litte.util.BaseController;
import com.litte.util.DateUtil;
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
import java.util.*;

/**
 * 员工休息管理
 */
@Controller
@RequestMapping(value = "/rest")
public class TRestController extends BaseController {


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//自定义格式
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor( dateFormat, true));
    }

    @Autowired
    TRestService tRestService;

    /**
     * 进入员工休息列表页面
     * @return
     */
    @RequestMapping(value = "/listRestView")
    public String listRestView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/rest/restlist";
    }

    /**
     * 进入店长排班列表页面
     * @return
     */
   /* @RequestMapping(value = "/listManagerView")
    public String listManagerView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/rest/restlist";
    }*/


    /**
     * 员工休息列表
     *
     * @return
     */
    @RequestMapping(value = "/listRest")
    @ResponseBody
    public String listRest(TRest rest, int rows) {
        PageHelper.startPage(rest.getPage(),rows);//分页查询
        List<TRest> tRestList = tRestService.selectByExample(rest);
        PageInfo<TRest> pageInfo = new PageInfo<>(tRestList);
        rest.setPageSize(rows);
        rest.setRows(tRestList);
        rest.setPage(rest.getPage());
        rest.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(rest);
    }


    /**
     * 进入增加员工休息页面
     * @return
     */
    @RequestMapping(value = "/addRestView")
    public String addRestView() {
        return "html/reception/rest/restadd";
    }


    /**
     * 进入修改员工休息页面
     * @return
     */
    @RequestMapping(value = "/updRestView")
    public String updRestView(String id,Model model) {
        if(StringUtil.isNotEmpty(id)) {
            TRest rest = tRestService.selectByPrimaryKey(id);
            model.addAttribute("rest",rest);
        }
        return "html/reception/rest/restupd";
    }

    /**
     * 增加员工休息
     * @return
     */
    @RequestMapping(value = "/addRest")
    @ResponseBody
    public int addRest(TRest rest, HttpServletRequest request) {
        rest.setDeptId(this.getSession(request).getDeptId());
        rest.setStaffId(this.getSession(request).getUserId());
        int i = 0;
        if (StringUtil.isEmpty(rest.getId())) {
            i = tRestService.insertSelective(rest);
        } else {
            i = tRestService.updateByPrimaryKeySelective(rest);
        }
        return i;
    }



    /**
     * 删除员工休息
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delRest")
    @ResponseBody
    public int delRest(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));
        int delRest = tRestService.deleteByPrimaryKey(idlist);
        return delRest;
    }

    /**
     * 增加员工排班
     * @return
     */
    @RequestMapping(value = "/addRestRort")
    @ResponseBody
    public int addRestRort(TRest rest, HttpServletRequest request) {
        int i = 0;
        i = tRestService.insertSelective(rest);
        return i;
    }

    /**
     * 获取5天时间与星期
     * @return
     */
    @RequestMapping(value = "/seleDateRort")
    @ResponseBody
    public List<String> seleDateRort() {
        List<String> list = DateUtil.getWeekOfDate();
        return list;
    }

    /**
     * 获取当前时间
     * @return
     */
    @RequestMapping(value = "/getNowDateRort")
    @ResponseBody
    public String getNowDateRort() {
        String dateNow = DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        //List<String> list = DateUtil.getWeekOfDate();
        return dateNow;
    }



    /**
     * 获取店员是否可预定
     * @return
     */
    @RequestMapping(value = "/seleDateStaffRort")
    @ResponseBody
    public List<TRest> seleDateStaffRort(TRest rest, HttpServletRequest request) {
        List<TRest> list = tRestService.seleDateStaffRort(rest);
        return list;
    }


}
