package util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhl
 * @create 2021/2/19 14:31
 * @description
 */

public class Utils {
    private static final Log logger= LogFactory.getLog(Utils.class);

    private static final String ENCODING="UTF-8";

    /**
     * 校验一个字符串是否为空判断 改名为notEmpty LinLW // 2005-09-19 原名为validNull容易产生歧义
     *
     * @param str
     * @return
     */
    public static boolean notEmpty(String str) {
        return str != null && str.length() > 0;
    }

    /**
     * 判断一个字符串为空或空串或全部有空格组成
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断一个List是否非空 ZHL 2008-07-28
     *
     * @param c
     * @return
     */
    public static boolean notEmpty(Collection<?> c) {
        return c != null && c.size() > 0;
    }

    /**
     * 判断一个List是否为空 ZHL 2008-07-28
     *
     * @param c
     * @return
     */
    public static boolean isEmpty(Collection<?> c) {
        return c == null || c.size() <= 0;
    }

    /**
     *  判断一个对象数组是否为空/非空 ZHL 2009-10-19
     *
     * @param os
     * @return
     */
    public static boolean notEmpty(Object[] os) {
        return os != null && os.length > 0;
    }

    public static boolean isEmpty(Object[] os) {
        return os == null || os.length <= 0;
    }

    /**
     *  判断一个Map否非空 ZHL 2009-10-19
     *
     * @param m
     * @return
     */
    public static boolean notEmpty(Map<?, ?> m) {
        return m != null && !m.isEmpty();
    }

    /**
     *  判断一个Map否为空 ZHL 2009-10-19
     *
     * @param m
     * @return
     */
    public static boolean isEmpty(Map<?, ?> m) {
        return m == null || m.isEmpty();
    }
}
