package com.ljq.plugins.base.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * 小工具类
 */
public class CommonTools {

    /**
     * id生成器
     *
     * @return
     */
    public static synchronized String idGenerate() {
        return UUID.randomUUID().toString();
    }

    /**
     * UUID随机字符串
     *
     * @return
     */
    public static synchronized String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatDate(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 字符串转日期
     *
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date parse(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(strDate);
    }

    public static Date addDays(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置起时间
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    // 将字符串转换成二进制字符串
    public static String strToBinstr(String str) {
        char[] strChar = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : strChar) {
            result.append(Integer.toBinaryString(c));
        }
        return result.toString();
    }

}
