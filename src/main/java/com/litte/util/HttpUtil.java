package com.litte.util;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http接口类
 */
public class HttpUtil {
    public static Map<String,Object> sendGet(String code) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = "https://api.weixin.qq.com/sns/jscode2session?appid=wx64219b04c3af9d85&secret=cff148670d0e8dd06be650a6ed6774fe&"+
                    "js_code="+code+"&&grant_type=authorization_code";
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            // Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            /*for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }*/
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Map<String,Object> map = HttpUtil.mapAll(result);
        return map;
    }


    public static Map<String,Object> mapAll(String result) {
        Map<String,Object> mapJson = JSONObject.fromObject(result);
        Map<String,Object> mapAll = new HashMap<>();
        for (Object map: mapJson.entrySet()){
            mapAll.put(((Map.Entry)map).getKey().toString(),((Map.Entry)map).getValue());
        }

        /*Object value = mapJson.get("list");
        JSONArray array = (JSONArray)value;
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i = 0; i < array.size(); i++) {
            Object values = array.get(i);

            Map<String,Object> mapJsons = JSONObject.fromObject(values);
            Map<String,Object> maps = new HashMap<>();
            for (Object map: mapJsons.entrySet()){
                maps.put(((Map.Entry)map).getKey().toString(),((Map.Entry)map).getValue());
            }
            list.add(maps);
        }
        mapAll.put("list",list);*/
        return mapAll;
    }

   /* public static void main(String[] args) {
       // String sr = HttpUtil.sendGet();

    }*/
}
