package com.learn.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  // 开启代理
public class SpringCloudZuul9527Starter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuul9527Starter.class,args);
    }
}
