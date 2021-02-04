package com.wecon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

/**
 * @author zhl
 * @create 2021/2/3 10:51
 * @description
 */
@SpringBootApplication
public class StreamMQMain8802 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入端口号和RabbitMQ分组：");
        String port = scanner.nextLine();
        String group = scanner.nextLine();
        new SpringApplicationBuilder(StreamMQMain8802.class).properties("server.port="+port,"spring.cloud.stream.bindings.input.group="+group).run(args);
    }
}