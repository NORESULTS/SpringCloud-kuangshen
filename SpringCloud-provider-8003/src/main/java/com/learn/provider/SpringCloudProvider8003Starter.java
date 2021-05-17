package com.learn.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liangchao
 * @create 2021-05-05 15:41
 */
@SpringBootApplication
@EnableEurekaClient // 作用：在服务启动后，自动将其注册到eureka中。
@EnableDiscoveryClient // 开启服务发现功能
public class SpringCloudProvider8003Starter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvider8003Starter.class,args);
    }

}
