package com.powernode.crm.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    对date类型数据进行处理的工具类
 */
public class DateUtils {
    //静态方法
    public static String formateDateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }
}
