package com.wecon.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @author zhl
 * @create 2020年12月24日
 */
@MapperScan("com.wecon.springcloud.dao")
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("请输入端口号：");
       String port = scanner.nextLine();
       new SpringApplicationBuilder(PaymentMain8001.class).properties("server.port="+port).run(args);
   }
}
