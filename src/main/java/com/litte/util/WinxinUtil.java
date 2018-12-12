package com.litte.util;

import com.litte.entity.PayUtil;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 微信支付、退款
 */
public class WinxinUtil {

    /**
     * 支付
     * @param payUtil
     * @param request
     * @return
     * @throws Exception
     */
    public static Map<String, Object> wxPay(PayUtil payUtil, HttpServletRequest request) throws Exception {

        //生成的随机字符串
        payUtil.setAppid("wx64219b04c3af9d85");
        payUtil.setMch_id("1515291591");
        String spbill_create_ip = Util.getIpAddr(request);//当前服务器IP
        //payUtil.setOut_trade_no(DateUtil.getDateTime());
        String stringA = "appid="
                + payUtil.getAppid()
                + "&body="
                + payUtil.getBody()
                + "&device_info="
                + payUtil.getDevice_info()
                + "&mch_id=" + payUtil.getMch_id() + "&nonce_str=" + payUtil.getNonce_str() + "&key=cff148670d0e8dd06be650a6ed6774fe";
        String sign = Md5Util.md5(stringA).toUpperCase();

        String xml = "<xml>" +
                "   <appid>" + payUtil.getAppid() + "</appid>" +
                "   <attach>" + payUtil.getAttach() + "</attach>" +
                "   <body>" + payUtil.getBody() + "</body>" +
                "   <mch_id>" + payUtil.getMch_id() + "</mch_id>" +
                "   <nonce_str>" + payUtil.getNonce_str() + "</nonce_str>" +
                "   <notify_url>" + payUtil.getNotify_url() + "</notify_url>" +
                "   <openid>" + payUtil.getOpenid() + "</openid>" +
                "   <out_trade_no>" + payUtil.getOut_trade_no() + "</out_trade_no>" +
                "   <spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>" +
                "   <total_fee>" + payUtil.getTotal_fee() + "</total_fee>" +
                "   <trade_type>JSAPI</trade_type>" +
                "   <sign>" + sign + "</sign>" +
                "</xml> ";

        System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);

        //调用统一下单接口，并接受返回的结果
        String result = BasePay.httpRequest("https://api.mch.weixin.qq.com/pay/unifiedorder", "POST", xml);
        // 将解析结果存储在HashMap中
        Map map = doXMLParse(result);
        return map;

        //String return_code = (String) map.get("return_code");//返回状态码

    }

     /**
     * 支付
     * @param payUtil
     * @param request
     * @return
     * @throws Exception
     */
    public static Map<String, Object> wxRefund(PayUtil payUtil, HttpServletRequest request) throws Exception {

        //生成的随机字符串
        payUtil.setAppid("wx64219b04c3af9d85");
        payUtil.setMch_id("1515291591");
        //payUtil.setOut_trade_no(DateUtil.getDateTime());
        String stringA = "appid="
                + payUtil.getAppid()
                + "&body="
                + payUtil.getBody()
                + "&device_info="
                + payUtil.getDevice_info()
                + "&mch_id=" + payUtil.getMch_id() + "&nonce_str=" + payUtil.getNonce_str() + "&key=cff148670d0e8dd06be650a6ed6774fe";

        String sign = Md5Util.md5(stringA).toUpperCase();

        String xml = "<xml>" +
                "   <appid>" + payUtil.getAppid() + "</appid>" +
                "   <mch_id>" + payUtil.getMch_id() + "</mch_id>" +
                "   <nonce_str>" + payUtil.getNonce_str() + "</nonce_str>" +
                "   <out_refund_no>" + payUtil.getOut_refund_no() + "</out_refund_no>" +
                "   <out_trade_no>" + payUtil.getOut_trade_no() + "</out_trade_no>" +
                "   <refund_fee>"+ payUtil.getRefund_fee()+"</refund_fee>" +
                "   <total_fee>"+ payUtil.getTotal_fee()+"</total_fee>" +
                "   <transaction_id></transaction_id>" +
                "   <sign>"+sign+"</sign>" +
                "</xml> ";

        System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);

        //调用统一下单接口，并接受返回的结果
        String result = BasePay.httpRequest("https://api.mch.weixin.qq.com/pay/unifiedorder", "POST", xml);
        // 将解析结果存储在HashMap中
        Map map = doXMLParse(result);
        return map;

        //String return_code = (String) map.get("return_code");//返回状态码

    }



    /**
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     *
     * @param strxml
     * @return
     */
    public static Map doXMLParse(String strxml) throws Exception {
        if (null == strxml || "".equals(strxml)) {
            return null;
        }

        Map m = new HashMap();
        InputStream in = String2Inputstream(strxml);
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List children = e.getChildren();
            if (children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = getChildrenText(children);
            }

            m.put(k, v);
        }

        //关闭流
        in.close();

        return m;
    }

    /**
     * 获取子结点的xml
     *
     * @param children
     * @return String
     */
    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if (!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }

        return sb.toString();
    }

    public static InputStream String2Inputstream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }
}
