package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.reception.TCoupon;
import com.litte.service.reception.TCouponService;
import com.litte.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * 卡券管理
 */
@Controller
@RequestMapping(value = "/coupon")
public class TCouponController {

    @Autowired
    TCouponService tCouponService;


    /**
     * 进入卡券管理列表页面
     * @return
     */
    @RequestMapping(value = "/listCouponView")
    public String listCouponView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/coupon/couponlist";
    }

    /**
     * 卡券列表
     *
     * @return
     */
    @RequestMapping(value = "/listCoupon")
    @ResponseBody
    public String listCoupon(TCoupon coupon, int rows) {
        PageHelper.startPage(coupon.getPage(),rows);//分页查询
        List<TCoupon> tCouponList = tCouponService.selectByExample(coupon);
        PageInfo<TCoupon> pageInfo = new PageInfo<>(tCouponList);
        coupon.setPageSize(rows);
        coupon.setRows(tCouponList);
        coupon.setPage(coupon.getPage());
        coupon.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(coupon);
    }

    /**
     * 增加卡券
     * @return
     */
    @RequestMapping(value = "/addCoupon")
    @ResponseBody
    public int addCoupon(TCoupon coupon) {
        int i = 0;
        if (StringUtil.isEmpty(coupon.getId())) {
            i = tCouponService.insertSelective(coupon);
        } else {
            i = tCouponService.updateByPrimaryKeySelective(coupon);
        }
        return i;
    }

    /**
     * 接口卡券列表
     *
     * @return
     */
    @RequestMapping(value = "/listCouponByPort")
    @ResponseBody
    public List<TCoupon> listCouponByPort(TCoupon coupon) {
        List<TCoupon> tCouponList = tCouponService.selectByExample(coupon);
        return tCouponList;
    }

    /**
     * 进入增加卡券页面
     * @return
     */
    @RequestMapping(value = "/addCouponView")
    public String addCouponView() {
        return "html/reception/coupon/couponadd";
    }

    /**
     * 进入修改卡券页面
     * @return
     */
    @RequestMapping(value = "/updCouponView")
    public String updCouponView(String id,Model model) {
        if(StringUtil.isNotEmpty(id)) {
            TCoupon coupon = tCouponService.selectByPrimaryKey(id);
            model.addAttribute("coupon",coupon);
        }
        return "html/reception/coupon/couponupd";
    }

    /**
     * 删除卡券
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delCoupon")
    @ResponseBody
    public int delCoupon(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));
        int delCoupon = tCouponService.deleteByPrimaryKey(idlist);
        return delCoupon;

    }
}
