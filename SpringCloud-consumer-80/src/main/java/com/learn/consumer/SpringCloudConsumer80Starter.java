package com.learn.consumer;

import com.learn.consumer.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author liangchao
 * @create 2021-05-05 17:18
 */
@SpringBootApplication
@EnableEurekaClient // Ribbon和Eureka整合后，客户端可以直接通过提供者的服务名去调用，无需指定提供者的IP地址与端口号
@RibbonClient(name="SpringCloud-provider-ribbon-spring-application",configuration = MyRule.class) // 配置当服务启动时，就加载针对目标提供者提供自定义的负载均衡算法
public class SpringCloudConsumer80Starter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumer80Starter.class,args);
    }
}
