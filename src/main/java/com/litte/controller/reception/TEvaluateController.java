package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litte.entity.reception.TCoupon;
import com.litte.entity.reception.TEvaluate;
import com.litte.service.reception.TEvaluateService;
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
 *  评价管理
 */
@Controller
@RequestMapping(value = "/evaluate")
public class TEvaluateController extends BaseController {

    @Autowired
    TEvaluateService tEvaluateService;

    /**
     * 进入评价管理列表页面
     * @return
     */
    @RequestMapping(value = "/listEvaluateView")
    public String listCouponView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/evaluate/evaluatelist";
    }

    /**
     * 评价列表
     *
     * @return
     */
    @RequestMapping(value = "/listEvaluate")
    @ResponseBody
    public String listCoupon(TEvaluate evaluate, int rows, HttpServletRequest request) {
        PageHelper.startPage(evaluate.getPage(),rows);//分页查询
        evaluate.setDeptIds(this.getSession(request).getGroups());
        List<TEvaluate> tEvaluateList = tEvaluateService.selectByExample(evaluate);
        PageInfo<TEvaluate> pageInfo = new PageInfo<>(tEvaluateList);
        evaluate.setPageSize(rows);
        evaluate.setRows(tEvaluateList);
        evaluate.setPage(evaluate.getPage());
        evaluate.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(evaluate);
    }


    /**
     * 增加评价
     * @return
     */
    @RequestMapping(value = "/addEvaluate")
    @ResponseBody
    public int addEvaluate(TEvaluate evaluate) {
        int i = 0;
        i = tEvaluateService.insertSelective(evaluate);
        return i;
    }


    /**
     * 接口评价列表
     *
     * @return
     */
    @RequestMapping(value = "/listEvaluateByPort")
    @ResponseBody
    public List<TEvaluate> listEvaluateByPort(TEvaluate evaluate) {
        List<TEvaluate> tEvaluateList = tEvaluateService.selectByExample(evaluate);
        return tEvaluateList;
    }

    /**
     * 删除评价
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delEvaluate")
    @ResponseBody
    public int delEvaluate(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));
        int delEvaluate = tEvaluateService.deleteByPrimaryKey(idlist);
        return delEvaluate;

    }

}
