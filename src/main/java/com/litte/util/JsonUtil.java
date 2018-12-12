package com.litte.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

/**
 * 转换json
 */
public class JsonUtil {

	public static String toJsonString( Object o ) {
		return JSON.toJSONString( o, SerializerFeature.IgnoreNonFieldGetter );
	}

	public static <T> T fromJsonString( String text, Class<T> clazz ) {
		return JSON.parseObject( text, clazz );
	}


	/**
	 * 返回成功
	 * @return
	 */
	public static String toSuccess() {

		Map<String,Object> map = new HashMap<>();
		map.put("statusCode",200);
		map.put("title","操作提示");
		map.put("message","恭喜你，操作成功！");


		return JSON.toJSONString(map);

	}
}
