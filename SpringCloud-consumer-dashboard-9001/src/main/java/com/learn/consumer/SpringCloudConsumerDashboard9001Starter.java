package com.learn.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author liangchao
 * @create 2021-05-24 20:52
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启流监控页面
public class SpringCloudConsumerDashboard9001Starter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerDashboard9001Starter.class,args);

    }
}
