package com.litte.controller.reception;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.litte.entity.PayUtil;
import com.litte.entity.jurisdiction.TUser;
import com.litte.entity.reception.TIndent;
import com.litte.service.reception.TIndentService;
import com.litte.util.*;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  订单管理
 */
@Controller
@RequestMapping(value = "/indent")
public class TIndentController extends BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//自定义格式
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor( dateFormat, true));
    }

    @Autowired
    TIndentService tIndentService;
    @Autowired
    FileUploadUtil fileUploadUtil;
    /**
     * 进入订单管理列表页面
     * @return
     */
    @RequestMapping(value = "/listIndentView")
    public String listCouponView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/indent/indentlist";
    }

    /**
     * 订单列表
     *
     * @return
     */
    @RequestMapping(value = "/listIndent")
    @ResponseBody
    public String listIndent(TIndent indent, int rows, HttpServletRequest request) {
        PageHelper.startPage(indent.getPage(),rows);//分页查询
        indent.setDeptIds(this.getSession(request).getGroups());
        List<TIndent> tIndentList = tIndentService.selectByExample(indent);
        PageInfo<TIndent> pageInfo = new PageInfo<>(tIndentList);
        indent.setPageSize(rows);
        indent.setRows(tIndentList);
        indent.setPage(indent.getPage());
        indent.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(indent);
    }

    /**
     * 增加、修改订单
     * @return
     */
    @RequestMapping(value = "/addIndent")
    @ResponseBody
    public TIndent addUser(TIndent indent,String userId) {
        int i = 0;
        if(StringUtil.isNotEmpty(userId)) {
            indent.setOpenid(userId);
        }
        if (StringUtil.isNotEmpty(indent.getId())) {
            indent = tIndentService.updateByPrimaryKeySelective(indent);
        } else {
            indent.setId(UUIDUtil.getUUIDBig());
            indent = tIndentService.insertSelective(indent);
        }
        return indent;
    }


    /**
     * 支付
     * @return
     */
    @RequestMapping(value = "/payIndent")
    @ResponseBody
    public Map<String,Object> payIndent(String id,String iMode,HttpServletRequest request) throws Exception {
        Map<String,Object> map = new HashMap<>();
        TIndent indent = tIndentService.selectByPrimaryKey(id);
        if(iMode.equals("0")) {
            PayUtil payUtil = new PayUtil();
            payUtil.setBody("欣星尚支付中心-剪发支付");
            payUtil.setOut_trade_no(indent.getiCode());
            payUtil.setNonce_str(indent.getId());
            payUtil.setTotal_fee(Integer.parseInt(indent.getiPrice())*100);
            payUtil.setNotify_url(fileUploadUtil.getBaseUrl()+"/indent/noticeCardOrder");
            payUtil.setOpenid(indent.getOpenid());
            map=WinxinUtil.wxPay(payUtil,request);
            map.put("timeStamp",new Date().getTime());
        } else if(iMode.equals("1")){
            int i  = tIndentService.updateByPrimaryKeyPay(indent);
            if(i>0) {
                map.put("return_code","SUCCESS");
                map.put("return_msg","支付成功");
            } else {
                map.put("return_code","ERROR");
                map.put("return_msg","支付失败");
            }
        }
        return  map;
    }


    /**
     * 退款
     * @return
     */
    @RequestMapping(value = "/refund")
    @ResponseBody
    public Map<String,Object> refund(String id,HttpServletRequest request) throws Exception {
        Map<String,Object> map = new HashMap<>();
        TIndent indent = tIndentService.selectByPrimaryKey(id);
        String mode = indent.getiMode();
        String out_refund_no = UUIDUtil.getUUID();
        indent.setOut_refund_no(out_refund_no);
        if(mode.equals("0")) {
            PayUtil payUtil = new PayUtil();
            payUtil.setOut_trade_no(indent.getiCode());
            payUtil.setNonce_str(indent.getId());
            payUtil.setTotal_fee(Integer.parseInt(indent.getiPrice())*100);
            payUtil.setRefund_fee(Integer.parseInt(indent.getiPrice())*100);
            payUtil.setOut_refund_no(out_refund_no);
            payUtil.setOpenid(indent.getOpenid());
            payUtil.setNotify_url(fileUploadUtil.getBaseUrl()+"/indent/refundCardOrder");
            map=WinxinUtil.wxPay(payUtil,request);
            indent.setiCondition("6");
            tIndentService.updateByPrimaryKeySelective(indent);
        } else if(mode.equals("1")){
            int i  = tIndentService.updateByPrimaryKeyRefund(indent);
            if(i>0) {
                map.put("return_code","SUCCESS");
                map.put("return_msg","已退款");
            } else {
                map.put("return_code","ERROR");
                map.put("return_msg","退款失败");
            }
        }
        return  map;
    }

    /**
     * 付款后微信返回信息，更改订单状态
     */
    @RequestMapping(value = "/noticeCardOrder")
    public void noticeCardOrder(HttpServletRequest request) throws Exception {
        String xmlStr = NotifyServlet.getWxXml(request);
        Map map2 = WinxinUtil.doXMLParse(xmlStr);
        String return_code = (String) map2.get("return_code");
        String id = (String) map2.get("nonce_str");
        TIndent indent = tIndentService.selectByPrimaryKey(id);
        indent.setiCondition("1");
        if (indent.getiCondition().equals("0")) {
            if (return_code.equals("SUCCESS")) {
                tIndentService.updateByPrimaryKeySelective(indent);
            }
        }
    }

    /**
     * 退款后微信返回信息，更改订单状态
     */
    @RequestMapping(value = "/refundCardOrder")
    public void refundCardOrder(HttpServletRequest request) throws Exception {
        String xmlStr = NotifyServlet.getWxXml(request);
        Map map2 = WinxinUtil.doXMLParse(xmlStr);
        String return_code = (String) map2.get("return_code");
        String id = (String) map2.get("nonce_str");
        TIndent indent = tIndentService.selectByPrimaryKey(id);
        indent.setiCondition("5");
        if (indent.getiCondition().equals("0")) {
            if (return_code.equals("SUCCESS")) {
                tIndentService.updateByPrimaryKeySelective(indent);
            }
        }
    }

    /**
     * 进入关注用户列表页面
     * @return
     */
    @RequestMapping(value = "/listAccountView")
    public String listAccountView() {
        return "html/reception/indent/accountlist";
    }

    /**
     * 对账
     * @return
     */
    @RequestMapping(value = "/accountByList")
    @ResponseBody
    public Map<String,Object> accountByList(String startTime,String entTime,HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        map.put("startTime",startTime);
        map.put("entTime",entTime);
        map.put("deptId",this.getSession(request).getGroups());
        map = tIndentService.accountByList(map);
        return map;
    }

    /**
     * 发送短信
     * @return
     */
    @RequestMapping(value = "/smsXxs")
    @ResponseBody
    public Map<String,Object> smsXxs(String phone,HttpServletRequest request) throws ClientException {
        Map<String,Object> map = new HashMap<>();
        String code = CodeUtil.generateVerifyCode(6);
        String TemplateParam = "{\"code\":\""+code+"\"}";
        String TemplateCode = "SMS_152440521";
        SendSmsResponse response = SmsXsk.sendSms(phone,TemplateParam,TemplateCode);
        map.put("verifyCode",code);
        map.put("phone",phone);
        request.getSession().setAttribute("CodePhone",map);
        Map<String,Object> mapSuc = new HashMap<>();
        if( response.getCode().equals("OK")) {
            mapSuc.put("isOk","OK");
        }
        return mapSuc;
    }

    /**
     * 验证验证码是否正确
     * @return
     */
    @RequestMapping(value = "/verifyConde")
    @ResponseBody
    public Map<String,Object> verifyConde(String phone,String code,HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> mapCodePhone  = (Map<String, Object>) request.getSession().getAttribute("CodePhone");
        if(mapCodePhone != null && mapCodePhone.get("phone").equals(phone) && code.equals(mapCodePhone.get("verifyCode")) ) {
            map.put("isOk","OK");
        }
        return map;
    }

}
