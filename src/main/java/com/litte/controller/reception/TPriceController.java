package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.reception.TPrice;
import com.litte.service.reception.TPriceService;
import com.litte.util.BaseController;
import com.litte.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定价管理
 */
@Controller
@RequestMapping(value = "/price")
public class TPriceController extends BaseController {

    @Autowired
    TPriceService tPriceService;

    /**
     * 进入定价管理列表页面
     * @return
     */
    @RequestMapping(value = "/listPriceView")
    public String listCouponView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/price/pricelist";
    }


    /**
     * 定价列表
     *
     * @return
     */
    @RequestMapping(value = "/listPrice")
    @ResponseBody
    public String listPrice(TPrice price, int rows, HttpServletRequest request) {
        PageHelper.startPage(price.getPage(),rows);//分页查询
        price.setDeptIds(this.getSession(request).getGroups());
        List<TPrice> tPriceList = tPriceService.selectByExample(price);
        PageInfo<TPrice> pageInfo = new PageInfo<>(tPriceList);
        price.setPageSize(rows);
        price.setRows(tPriceList);
        price.setPage(price.getPage());
        price.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(price);
    }

    /**
     * 增加\修改定价
     * @return
     */
    @RequestMapping(value = "/addPrice")
    @ResponseBody
    public int addPrice(TPrice price,HttpServletRequest request) {
        int i = 0;
        if (StringUtil.isEmpty(price.getId())) {
            price.setDeptId(this.getSession(request).getDeptId());
            i = tPriceService.insertSelective(price);
        } else {
            i = tPriceService.updateByPrimaryKeySelective(price);
        }
        return i;
    }

    /**
     * 进入增加菜单页面
     * @return
     */
    @RequestMapping(value = "/addPriceView")
    public String addPriceView() {
        return "html/reception/price/priceadd";
    }

    /**
     * 进入修改定价页面
     * @return
     */
    @RequestMapping(value = "/updPriceView")
    public String updPriceView(String id,Model model) {

        if(StringUtil.isNotEmpty(id)) {
            TPrice price = tPriceService.selectByPrimaryKey(id);
            model.addAttribute("price",price);
        }
        return "html/reception/price/priceupd";
    }

    /**
     * 删除菜单
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delPrice")
    @ResponseBody
    public int delPrice(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));
        int delTmenu = tPriceService.deleteByPrimaryKey(idlist);
        return delTmenu;
    }

    /**
     * 接口
     * @param deptId
     * @param projectId
     * @param request
     * @return
     */
    @RequestMapping("/listPriceUserByPort")
    @ResponseBody
    public List<TPrice> listPriceUserByPort(String deptId, String projectId, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();

        map.put("deptId",deptId);
        map.put("projectId",projectId);
        if(StringUtil.isEmpty(deptId) || StringUtil.isEmpty(projectId)) {
            return null;
        }
        List<TPrice> listPrice = tPriceService.listPriceUserByPort(map);
        return listPrice;
    }




    /**
     * 排班接口
     * @param deptId
     * @return
     */
    @RequestMapping("/listPriceRestByPort")
    @ResponseBody
    public List<Map<String,Object>> listPriceRestByPort(String deptId) {
        Map<String,Object> map = new HashMap<>();
        map.put("deptId",deptId);
        if(StringUtil.isEmpty(deptId)) {
            return null;
        }
        List<Map<String,Object>> listPrice = tPriceService.listPriceRestByPort(map);
        return listPrice;
    }


}
