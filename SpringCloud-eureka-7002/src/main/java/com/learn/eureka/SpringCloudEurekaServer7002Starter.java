package com.learn.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liangchao
 * @create 2021-05-06 12:54
 */
@SpringBootApplication
@EnableEurekaServer // eureka服务端的启动类，可以接受别人的注册请求
public class SpringCloudEurekaServer7002Starter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServer7002Starter.class,args);
    }
}
