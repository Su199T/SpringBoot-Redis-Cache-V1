package com.javabootpro.utils;

import java.math.BigDecimal;
import java.util.logging.Logger;


//https://blog.csdn.net/shadow_zed/article/details/73522157

//  可能在原文的代码基础上进行了修改

//@Slf4j
public class MathUtil {

    // jdk1.7自带
    private static Logger sysLog = Logger.getGlobal();

    public static void main(String args[]) {
        sysLog.info(""+sub(  10.5789 , 0.46));
        //("减法 {}",sub(  10.5789 , 0.46));
//
//        log.info("加法 {}",add(  20.5 , 100.123));
//
//        log.info("乘法 {}",mul(10,2.0202));
//
//        log.info("除法 {} ", div(106, 3, 3)); //   106 / 3

    }

    /**
     * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精
     * 确的浮点数运算，包括加减乘除和四舍五入。
     */
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;


    //这个类不能实例化
    private MathUtil() {
    }

    /**
     * 提供精确的加法运算。
     *
     * @param source 被加数
     * @param addArg 加数
     * @return 两个参数的和
     */
    public static double add(double source, double addArg) {
        BigDecimal sourceBd = new BigDecimal(Double.toString(source));
        BigDecimal b2 = new BigDecimal(Double.toString(addArg));
        return sourceBd.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param source 被减数
     * @param subArg 减数
     * @return 两个参数的差
     */
    public static double sub(double source, double subArg) {
        BigDecimal sourceBd = new BigDecimal(Double.toString(source));
        BigDecimal b2 = new BigDecimal(Double.toString(subArg));
        return sourceBd.subtract(b2).doubleValue();
    }

    /**
     * multiply
     * 提供精确的乘法运算。
     *
     * @param source 被乘数
     * @param mulArg 乘数
     * @return 两个参数的积
     */
    public static double mul(double source, double mulArg) {
        BigDecimal sourceBd = new BigDecimal(Double.toString(source));
        BigDecimal b2 = new BigDecimal(Double.toString(mulArg));
        return sourceBd.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     *
     * @param source 被除数
     * @param divArg 除数
     * @return 两个参数的商
     */
    public static double div(double source, double divArg) {
        return div(source, divArg, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param source    被除数
     * @param divArg    除数
     * @param scale (比例) 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double source, double divArg, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(source));
        BigDecimal b2 = new BigDecimal(Double.toString(divArg));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
