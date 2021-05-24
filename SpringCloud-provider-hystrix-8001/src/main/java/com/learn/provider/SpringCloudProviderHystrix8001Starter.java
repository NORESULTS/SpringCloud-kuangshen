package com.learn.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liangchao
 * @create 2021-05-05 15:41
 */
@SpringBootApplication
@EnableEurekaClient // 作用：在服务启动后，自动将其注册到eureka中。
@EnableDiscoveryClient // 开启服务发现功能
@EnableCircuitBreaker // 添加对Hystrix熔断的支持
public class SpringCloudProviderHystrix8001Starter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderHystrix8001Starter.class,args);
    }

}
