package com.paprika.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

/**
 * @author adam
 * @date 2019/5/14
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    private static final char SEPARATOR = '_';

    /**
     * 判断一系列的字符串中是否包含某字符串片段
     *
     * @param str 要被验证的字符串
     * @param args 字符串组
     * @return true表示包含 false表示不包含
     */
    public static boolean inString(String str, String... args){
        if(str != null){
            for(String s : args){
                if (str.equals(trim(s))){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 小驼峰转下划线
     * @param str 小驼峰风格字符串
     * @return 转化为下划线风格的字符串
     */
    public static String toUnderScoreCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean nextUpperCase = true;
            if (i < (str.length() - 1)) {
                nextUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }
            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    /**
     * 下划线风格转小驼峰
     */
    public static String toCamelCase(String str){
        if (str == null) {
            return null;
        }
        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder(str.length());
        boolean upperCase = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线风格转大驼峰
     */
    public static String toCapitalizeCamelCase(String str){
        if(str == null){
            return null;
        }
        str = toCamelCase(str);
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * 获取客户端真实IPv4地址
     *
     * @param request HttpServletRequest
     * @return 真实IP
     */
    public static String getRealIP(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        String unknown = "unknown";
        String ipv6 = "0:0:0:0:0:0:0:1";
        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ipv6.equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 获取当前时间是周几
     */
    public static String getWeekDay(){
        String[] weekDays = {"星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        return weekDays[w];
    }
}
