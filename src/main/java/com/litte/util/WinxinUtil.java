package com.litte.util;

import com.litte.entity.PayUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
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
        String stringA = "appid="  + payUtil.getAppid()
                + "&body=" + payUtil.getBody()
                + "&mch_id=" + payUtil.getMch_id()
                + "&nonce_str=" + payUtil.getNonce_str()
                + "&notify_url=" + payUtil.getNotify_url()
                + "&openid=" + payUtil.getOpenid()
                + "&out_trade_no=" + payUtil.getOut_trade_no()
                + "&spbill_create_ip=120.27.11.164"
                + "&total_fee="+ payUtil.getTotal_fee()
                + "&trade_type=JSAPI"
                + "&key=xinxingshang2018xinxingshang2018";
        String sign = Md5Util.md5(stringA).toUpperCase();

        String xml = "<xml>" +
                "   <appid>" + payUtil.getAppid() + "</appid>" +
                "   <body>" + payUtil.getBody() + "</body>" +
                "   <mch_id>" + payUtil.getMch_id() + "</mch_id>" +
                "   <nonce_str>" + payUtil.getNonce_str() + "</nonce_str>" +
                "   <notify_url>" + payUtil.getNotify_url() + "</notify_url>" +
                "   <openid>" + payUtil.getOpenid() + "</openid>" +
                "   <out_trade_no>" + payUtil.getOut_trade_no() + "</out_trade_no>" +
                "   <spbill_create_ip>120.27.11.164</spbill_create_ip>" +
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
     * 退款
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
        String stringA = "appid="  + payUtil.getAppid()
                + "&mch_id=" + payUtil.getMch_id()
                + "&nonce_str="  + payUtil.getNonce_str()
                + "&out_trade_no="  + payUtil.getOut_trade_no()
                + "&out_refund_no="  + payUtil.getOut_refund_no()
                + "&total_fee="  + payUtil.getTotal_fee()
                + "&refund_fee="  + payUtil.getRefund_fee()
                + "&key=xinxingshang2018xinxingshang2018";

        String sign = Md5Util.md5(stringA).toUpperCase();

        String xml = "<xml>" +
                "   <appid>" + payUtil.getAppid() + "</appid>" +
                "   <mch_id>" + payUtil.getMch_id() + "</mch_id>" +
                "   <nonce_str>" + payUtil.getNonce_str() + "</nonce_str>" +
                "   <out_trade_no>" + payUtil.getOut_trade_no() + "</out_trade_no>" +
                "   <out_refund_no>" + payUtil.getOut_refund_no() + "</out_refund_no>" +
                "   <total_fee>"+ payUtil.getTotal_fee()+"</total_fee>" +
                "   <refund_fee>"+ payUtil.getRefund_fee()+"</refund_fee>" +
                "   <sign>"+sign+"</sign>" +
                "</xml> ";

        System.out.println("调试模式_退款接口 请求XML数据：" + xml);

        //调用统一下单接口，并接受返回的结果
        String result = doRefund("https://api.mch.weixin.qq.com/secapi/pay/refund",  xml);
        // 将解析结果存储在HashMap中
        Map map = doXMLParse(result);
        return map;

        //String return_code = (String) map.get("return_code");//返回状态码

    }


    /**
     * 申请退款
     */
    public static String doRefund(String url, String data) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream is = new FileInputStream(new File("****证书文件存放的路劲*******"));
        try {
            keyStore.load(is, "xinxingshang2018xinxingshang2018".toCharArray());
        } finally {
            is.close();
        }
        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(
                keyStore,
                "xinxingshang2018xinxingshang2018".toCharArray())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[]{"TLSv1"},
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER
        );
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {
            HttpPost httpost = new HttpPost(url); // 设置响应头信息
            httpost.addHeader("Connection", "keep-alive");
            httpost.addHeader("Accept", "*/*");
            httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpost.addHeader("Host", "api.mch.weixin.qq.com");
            httpost.addHeader("X-Requested-With", "XMLHttpRequest");
            httpost.addHeader("Cache-Control", "max-age=0");
            httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
            httpost.setEntity(new StringEntity(data, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httpost);
            try {
                HttpEntity entity = response.getEntity();

                String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
                EntityUtils.consume(entity);
                return jsonStr;
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
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
