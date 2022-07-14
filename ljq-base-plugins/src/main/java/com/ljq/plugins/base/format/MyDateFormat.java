package com.ljq.plugins.base.format;

import java.text.*;
import java.util.Date;

/**
 * 重写springBoot 默认的日期转换，
 * 解决的问题是前端日期格式字符串无法接收
 */
public class MyDateFormat extends DateFormat {

    private DateFormat dateFormat;

    private String formatStr = "yyyy-MM-dd HH:mm:ss";

    public MyDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return dateFormat.format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
            date = sdf.parse(source, pos);
        } catch (Exception e) {
            date = dateFormat.parse(source, pos);
        }
        return date;
    }

    // 主要还是装饰这个方法
    @Override
    public Date parse(String source) throws ParseException {
        Date date = null;
        try {
            // 先按我的规则来
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
            date = sdf.parse(source);
        } catch (Exception e) {
            // 不行，那就按原先的规则吧
            date = dateFormat.parse(source);
        }
        return date;
    }

    // 这里装饰clone方法的原因是因为clone方法在jackson中也有用到
    @Override
    public Object clone() {
        Object format = dateFormat.clone();
        return new MyDateFormat((DateFormat) format);
    }


}
