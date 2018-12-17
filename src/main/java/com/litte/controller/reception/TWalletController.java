package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.reception.TIndent;
import com.litte.entity.reception.TWallet;
import com.litte.service.reception.TWalletService;
import com.litte.util.BaseController;
import com.litte.util.JsonUtil;
import com.litte.util.NotifyServlet;
import com.litte.util.WinxinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 钱包管理
 */
@Controller
@RequestMapping(value = "/wallet")
public class TWalletController extends BaseController {

    @Autowired
    TWalletService tWalletService;

    /**
     * 进入钱包管理列表页面
     * @return
     */
    @RequestMapping(value = "/listWalletView")
    public String listCouponView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/wallet/walletlist";
    }

    /**
     * 钱包列表
     *
     * @return
     */
    @RequestMapping(value = "/listWallet")
    @ResponseBody
    public String listWallet(TWallet record, int rows) {
        PageHelper.startPage(record.getPage(),rows);//分页查询
        List<TWallet> tWalletList = tWalletService.selectByExample(record);
        PageInfo<TWallet> pageInfo = new PageInfo<>(tWalletList);
        record.setPageSize(rows);
        record.setRows(tWalletList);
        record.setPage(record.getPage());
        record.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(record);
    }


    /**
     * 充值钱包接口
     *
     * @return
     */
    @RequestMapping(value = "/payWallet")
    @ResponseBody
    public Map<String,Object> payWallet(String userId,String id, HttpServletRequest request) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("id",id);
        Map<String,Object > maps = tWalletService.payWallet(map,request);
        return  maps;
    }

    /**
     * 付款后微信返回信息，更改订单状态
     */
    @RequestMapping(value = "/walletCardOrder")
    @ResponseBody
    public void walletCardOrder(HttpServletRequest request) throws Exception {
        String xmlStr = NotifyServlet.getWxXml(request);
        Map map2 = WinxinUtil.doXMLParse(xmlStr);
        tWalletService.payUpdateWallet(map2);
    }

    /**
     * 接口查询余额
     */
    @RequestMapping(value = "/selWalletByUser")
    @ResponseBody
    public TWallet selWalletByUser(TWallet record)   {

        if(record != null && StringUtil.isNotEmpty(record.getUserId())) {
            TWallet wallet = tWalletService.selWalletByUser(record);
            return wallet;
        } else {
            return null;
        }

    }



}
