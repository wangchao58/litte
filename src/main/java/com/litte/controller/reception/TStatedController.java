package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litte.entity.reception.TStated;
import com.litte.service.reception.TStatedService;
import com.litte.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 充值记录管理
 */
@Controller
@RequestMapping(value = "/stated")
public class TStatedController {

    @Autowired
    TStatedService tStatedService;

    /**
     * 进入卡券管理列表页面
     * @return
     */
    @RequestMapping(value = "/listStatedView")
    public String listCouponView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/stated/statedlist";
    }

    /**
     * 卡券列表
     *
     * @return
     */
    @RequestMapping(value = "/listStated")
    @ResponseBody
    public String listStated(TStated stated, int rows) {
        PageHelper.startPage(stated.getPage(),rows);//分页查询
        List<TStated> tStatedList = tStatedService.selectByExample(stated);
        PageInfo<TStated> pageInfo = new PageInfo<>(tStatedList);
        stated.setPageSize(rows);
        stated.setRows(tStatedList);
        stated.setPage(stated.getPage());
        stated.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(stated);
    }

}
