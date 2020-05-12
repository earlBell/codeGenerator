package com.breakearl.code.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.LongStream;

/**
 *  LocalDate日期工具类
 */
public final class LocalDateUtil {

    private LocalDateUtil(){}


    public final static DateTimeFormatter YMDHMS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
    public final static DateTimeFormatter YMDHMS_NUMBER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss",Locale.CHINA);
    public final static DateTimeFormatter YMD_NUMBER = DateTimeFormatter.ofPattern("yyyyMMdd",Locale.CHINA);
    public final static DateTimeFormatter YM  = DateTimeFormatter.ofPattern("yyyy-MM",Locale.CHINA);
    public final static DateTimeFormatter YMD  = DateTimeFormatter.ofPattern("yyyy-MM-dd",Locale.CHINA);
    public final static DateTimeFormatter HMS  = DateTimeFormatter.ofPattern("HH:mm:ss",Locale.CHINA);
    public final static DateTimeFormatter HMS_NUMBER = DateTimeFormatter.ofPattern("HHmmss",Locale.CHINA);

    /**
     * 获取中文名称的星期几
     * @param date   某个日期
     * @return String ，如:星期日
     */
    public static String getChinaDayOfWeek(String date,DateTimeFormatter formatter){
        return LocalDate.parse(date,formatter).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CHINESE);
    }

    /**
     * 获取相差时间段的所有日期天数时间
     * 格式时间范围:2017-01-28~2017-03-10 ,这里相差41天，把相差的时间都设置到列表(包含开始、结束日期)
     * @param begin 开始日期
     * @param end  结束日期
     * @return List<LocalDate>-相差日期天数列表
     */
    public static List<LocalDate> getBetweenDayList(LocalDate begin, LocalDate end ){
        List<LocalDate> dateList = new ArrayList<>();
        Period period = Period.between(begin, end);
        List<TemporalUnit> temporalUnits = period.getUnits();
        //for循环获取相差的天数
        dateList.add(begin);
        LongStream.rangeClosed(1,temporalUnits.get(2).between(begin,end)).forEach(i->{
            //相加 i 天
            LocalDate nextDays = begin.plusDays(i);
            dateList.add(nextDays);
        });
        return dateList;
    }
    /**
     * 获取相差时间段的所有日期天数时间(字符串格式)
     * 格式时间范围:2017-01-28~2017-03-10 ,这里相差41天，把相差的时间都设置到列表(包含开始、结束日期)
     * @param begin 开始日期
     * @param end  结束日期
     * @return List<String>-相差日期天数列表
     */
    public static List<String> getBetweenDayList(LocalDate begin, LocalDate end ,final DateTimeFormatter formatter){
        List<String> dateList = new ArrayList<>();
        Period period = Period.between(begin, end);
        List<TemporalUnit> temporalUnits = period.getUnits();
        //for循环获取相差的天数
        dateList.add(begin.format(formatter));
        LongStream.rangeClosed(1,temporalUnits.get(2).between(begin,end)).forEach(i->{
            //相加 i 天
            LocalDate nextDays = begin.plusDays(i);
            dateList.add(nextDays.format(formatter));
        });
        return dateList;
    }

    /**
     * 字符串日期转LocalDateTime，如：2020-01-12 转换为 2020-01-12 00:00:00
     * @param date 字符串日期，格式：2020-01-01
     * @return
     */
    public static LocalDateTime string2DateTime(String date){
       if(StringUtils.isEmpty(date)){
           return null;
       }
       return   LocalDate.parse(date, YMD).atTime(0, 0, 0);
    }

    /**
     * 字符串日期转LocalDateTime,并且追加日期
     * 如：2020-01-12 转换为 2020-01-12 00:00:00,当plusDay为1，时间就是2020-01-13 00:00:00
     * @param date 字符串日期，格式：2020-01-01
     * @param plusDay 增加天数，如果为1，就是增加1天
     * @return
     */
    public static LocalDateTime string2DateTimePlusDay(String date,long plusDay){
        LocalDateTime localDateTime = string2DateTime(date);
        if(Objects.nonNull(localDateTime)){
            return localDateTime.plusDays(plusDay);
        }
        return null;
    }

    public static void main(String [] args){
        YearMonth yearMonth = YearMonth.parse("2017-11",YM);
        System.out.println(  yearMonth.atDay(1));
    }


}
