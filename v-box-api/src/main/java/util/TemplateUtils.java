package com.wecon.springcloud.util;

/**
 * @author zhl
 * @create 2021/2/19 14:02
 * @description
 */
public class TemplateUtils {
    // 0-模板(未发布模板或历史模板) 1-慧盒 2-已关联模板慧盒

    //判断是纯模板还是关联模板慧盒  0 模板 2 模板慧盒
    public static boolean isFromTemplate(String fromType) {
        return "0".equals(fromType) || "2".equals(fromType);
    }
    //判断是否与模板有关
    public static boolean notFromTemplate(String fromType) {
        return !isFromTemplate(fromType);
    }
    //判断是否纯模板(未发布模板或历史模板)
    public static boolean onlyTemplate(String fromType) {
        return "0".equals(fromType);
    }
    //判断是否纯慧盒
    public static boolean onlyDevice(String fromType) {
        return "1".equals(fromType);
    }
    //判断是否关联模板慧盒
    public static boolean templateDevice(String fromType) {
        return "2".equals(fromType);
    }
}
