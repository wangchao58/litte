package com.litte.util;

import java.util.UUID;

/**
 * 生成唯一码
 */
public class UUIDUtil {
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;

    }

    public static String getUUIDBig() {
        String uuid = UUID.randomUUID().toString().replace("-","");
        uuid = uuid.toUpperCase();
        return uuid;
    }


}
