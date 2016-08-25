package com.cxmax.mvvmdemo.utils;

import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author CaiXi on  2016/8/26 01:00.
 * @Github: https://github.com/cxMax
 * @Description 字符串工具类
 */
public class StringUtil {

    //手机号正则表达式
    public final static String PHONE_PATTERN = "^[1][3-8]\\d{9}$";
    public final static String NUMBER_PATTERN = "^[0-9]\\d{10}$";

    public static final int BUF = 1024;

    public static boolean isNullOrEmpty(String str) {
        return null == str || str.trim().length() < 1;
    }

    public static boolean equals(String str1, String str2) {
        return null != str1 && null != str2 && str1.equals(str2);
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return null != str1 && null != str2 && str1.equalsIgnoreCase(str2);
    }

    /**
     * InputStream转换成字符串
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static String inputStream2String(InputStream in) throws IOException {
        StringBuffer buf = new StringBuffer();
        if (null != in) {
            byte[] b = new byte[BUF];
            int n;
            while ((n = in.read()) != -1) {
                buf.append(new String(b, 0, n));
            }
        }
        return buf.toString();
    }

    /**
     * 替换字符串中特殊字符
     *
     * @param strData 源字符串
     * @return 替换了特殊字符后的字符串，如果strData为NULL，则返回空字符串
     */
    public static String encodeString(String strData) {
        if (TextUtils.isEmpty(strData)) {
            return "";
        }
        return strData.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;").replaceAll("'", "&apos;")
                .replaceAll("\"", "&quot;");
    }

    /**
     * 还原字符串中特殊字符
     *
     * @param strData strData
     * @return 还原后的字符串
     */
    public static String decodeString(String strData) {
        if (TextUtils.isEmpty(strData)) {
            return "";
        }
        return strData.replaceAll("&lt;", "<").replaceAll("&gt;", ">")
                .replaceAll("&apos;", "'").replaceAll("&quot;", "\"")
                .replaceAll("&amp;", "&");
    }

    public static boolean isEmail(String email) {
        if (!TextUtils.isEmpty(email)) {
            String strPattern = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
            Pattern pattern = Pattern.compile(strPattern);
            Matcher m = pattern.matcher(email);
            return m.matches();
        }
        return false;
    }

    /**
     * <br>正则表达式匹配 </br>
     * @param patternStr
     * @param input
     * @return
     */
    public static boolean isMatcherFinded(String patternStr, CharSequence input) {
        if (!isNullOrEmpty(patternStr) && null != input) {
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(input);
            if (null != matcher && matcher.find()) {
                return true;
            }
        }

        return false;
    }

    /**
     * 整数取万
     * @param num
     * @return
     * */
    public static String numToMyriad(int num){
        return numToMyriad((long)num);
    }
    /**
     * 整数取万
     * @param num
     * @return
     * */
    public static String numToMyriad(long num){
        String str = "";
        if (num >9999) {
            String temp = String.valueOf(num);
            String start = temp.substring(0, temp.length() - 4);
            String end = temp.substring(temp.length() - 4,temp.length() - 3);
            str = start;
            if (Integer.parseInt(end) > 0) {
                str +=  "."+end;
            }
            str += "万";
        }else {
            str = (String.valueOf(num));
        }
        return str;
    }

    /**
     * 获取距离
     * @param addr
     * @return
     */
    public static String getApart(double addr){
        double apart = addr;
        String address = "";
        DecimalFormat df1 = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0.0");
        // 小于1千米时显示米
        if(apart <= 50.0d){
            address = "50m内";
        } else if (apart > 50.0d && apart < 1000.0d) {
            address = (int) apart + "m";
        } else if(apart >= 1000.0d && apart < 10000.0d){
            double aa = addr / 1000.0d;
            address = df1.format(aa) + "km";
        } else {
            double aa = addr / 1000.0d;
            address = df2.format(aa) + "km";
        }
        return address;
    }

    /**
     * 获取时长 s 保留一位小数  四舍五入
     * */
    public static float getDurationToFloat(long duration){
        float f = 0;
        try {
            BigDecimal b =  new BigDecimal(Long.toString(duration)) ;
            BigDecimal one = new BigDecimal("1000");
            f =  b.divide(one, 1, BigDecimal.ROUND_HALF_UP).floatValue();

        } catch (Exception e) {
            e.printStackTrace();
            f = 0;
        }
        return f;
    }

    /**
     * 获取时长，取整
     * */
    public static int getDurationToInt(long duration){
        int d = 0;
        try {
            BigDecimal b =  new BigDecimal(Long.toString(duration)) ;
            BigDecimal one = new BigDecimal("1000");
            d =  b.divide(one, 0, BigDecimal.ROUND_CEILING).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            d = 0;
        }
        return d;
    }

    /**
     * 格式化小数点后n位
     * @param price
     * @return
     */
    public synchronized static String getPriceByFormat(float price , int count){
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(count);
        format.setMaximumFractionDigits(count);
        String priceNum = format.format(price);
        return priceNum;
    }
}
