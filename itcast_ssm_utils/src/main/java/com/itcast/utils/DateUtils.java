package com.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期=====》字符串
    public static String dateToString(Date date,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String str = simpleDateFormat.format(date);
        return str;
    }


    //字符串=====》日期
    public static Date stringToDate(String date,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date date1 = simpleDateFormat.parse(date);
        return date1;
    }
}
