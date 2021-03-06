package com.wecon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

/**
 * @author zhl
 * @create 2021/2/1 15:36
 * @description
 */
@SpringBootApplication
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入端口号：");
        String port = scanner.nextLine();
        new SpringApplicationBuilder(ConfigClientMain3355.class).properties("server.port="+port).run(args);
    }
}
