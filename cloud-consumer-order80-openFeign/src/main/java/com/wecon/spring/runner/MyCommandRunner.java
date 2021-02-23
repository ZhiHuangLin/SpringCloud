package com.wecon.spring.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * @author zhl
 * @create 2021/2/4 14:38
 * @description 容器加载后自动监听
 */
//@Component 前端页面暂时取消
public class MyCommandRunner implements CommandLineRunner {

    @Value("${spring.web.index}")
    private String index;

    @Value("${spring.auto.openUrl}")
    private boolean isOpen;

    @Override
    public void run(String... args) {
        if (isOpen) {
            System.out.println("自动加载指定的页面");
            try {
                Runtime.getRuntime().exec("cmd /c start " + index);  // 可以指定自己的路径
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("浏览器打开页面异常");
            }
        }
    }

}
