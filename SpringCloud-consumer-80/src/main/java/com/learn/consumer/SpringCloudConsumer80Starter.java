package com.learn.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liangchao
 * @create 2021-05-05 17:18
 */
@SpringBootApplication
@EnableEurekaClient // Ribbon和Eureka整合后，客户端可以直接通过提供者的服务名去调用，无需指定提供者的IP地址与端口号
public class SpringCloudConsumer80Starter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumer80Starter.class,args);
    }
}
