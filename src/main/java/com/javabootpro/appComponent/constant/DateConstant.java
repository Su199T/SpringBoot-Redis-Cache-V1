package com.javabootpro.appComponent.constant;

public class DateConstant {
    // 日期格式
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    //
    public static final Integer day = 0;
    //常用时间 1h= 3600s 24h=86400s
    //常用时间（单位 秒）
    public static final Long oneHourSeconds= 3600L; //1h
    public static final Long fiveMinuteSeconds= 300L; // 5 Minute
    public static final Long quarterHourSeconds = 900L;//Quarter of an hour= 15 Minute
    public static final Long oneDaySeconds = 86400L; // 24h
    public static final Long oneWeekSeconds = 604800L; //一周

    // public static final Long oneMonthSeconds = ;


    //常用时间（单位 毫秒）
    public static final Long oneHourMilliseconds = oneHourSeconds * 1000;
    public static final Long fiveMinuteMilliseconds = fiveMinuteSeconds * 1000;
    public static final Long quarterHourMilliseconds = quarterHourSeconds * 1000;
    public static final Long oneDayMilliseconds = oneDaySeconds * 1000;
    public static final Long oneWeekMilliseconds = oneWeekSeconds * 1000;

    // Punctuation Split Format
    public static final String spaceSplitFormat = " "; // 必须是空格
    public static final String hPunctuationSplitFormat = "-";// 英文格式的 -
    public static final String colonSplitFormat = ":"; //英文冒号 :
    public static final String zeroHMSDateFormat = "00:00:00"; // 0时 0分 0秒
}
