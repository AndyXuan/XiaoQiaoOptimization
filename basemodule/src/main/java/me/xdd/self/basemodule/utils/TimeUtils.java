package me.xdd.self.basemodule.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xuandong on 2019/5/15
 */
public class TimeUtils {
    public static final String ALL = "yyyy-MM-dd HH:mm:ss";
    public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String HOUR_MINUTE = "HH:mm";

    /**
     * 将date转换成 2018-11-10 13:20:22
     * @param date
     * @param timeType
     * @return
     */
    public static String dateToTime(Date date,String timeType) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat(timeType);
        return format.format(date);
    }

    /**
     * 将timestamp 转 时间  1517392033 --->  2018-01-31 17:47:13
     * @param timestamp 时间戳 10位
     * @param timeType 类型 ALL ,YEAR_MONTH_DAY ,YEAR_MONTH_DAY_HOUR_MINUTE,HOUR_MINUTE
     * @return
     */
    public static String timestampToTime(long timestamp,String timeType){
        Timestamp ts = new Timestamp(timestamp);
        DateFormat dateFormat = new SimpleDateFormat(timeType);
        try {
            return dateFormat.format(ts);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取  date 的前几天 ，day为负数    ； 后几天 day 正数
     * @param date  日期
     * @param day  负数，提前day天，正数，往后day天
     * @return
     */
    public static Calendar getAgoOrAfterCalendar(Date date, int day){
        Calendar changeDate = Calendar.getInstance();
        if(date == null){
            date = new Date();
        }

        changeDate.setTime(date);
        changeDate.add(Calendar.DATE, day);
        return changeDate;
    }

    /**
     * 获取当前时间戳 10位
     * @return 1517392033
     */
    public static long getCurrentTimeMillis(){
        return System.currentTimeMillis()/1000 ;
    }


}
