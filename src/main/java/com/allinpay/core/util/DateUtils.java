package com.allinpay.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author : wuchao
 * Date   : 2019/7/3
 * Desc   :
 */
public class DateUtils {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static String getNowTime() {
        String dateStr = dateFormat.format(new Date());
        return dateStr;
    }

    public static void main(String[] args) {
        String dateStr = DateUtils.getNowTime();
        System.out.println(dateStr);
    }
}
