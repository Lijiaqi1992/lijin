package com.ljq.plugins.base.util;

import java.util.Base64;

/**
 * @描述： 工具箱
 * @作者： 李佳琪
 * @时间 2022-01-09
 */
public class LjqUtils {

    public static String base64Encode(String src){
        return Base64.getEncoder().encodeToString(src.getBytes());
    }
    public static String base64Decode(String src){
        return new String(Base64.getDecoder().decode(src));
    }
}
