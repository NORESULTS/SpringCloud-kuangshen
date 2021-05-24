package com.learn.consumer;

import com.learn.consumer.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liangchao
 * @create 2021-05-05 17:18
 */
@SpringBootApplication
@EnableEurekaClient // Ribbon和Eureka整合后，客户端可以直接通过提供者的服务名去调用，无需指定提供者的IP地址与端口号
@EnableFeignClients(basePackages = {"com.learn.api"}) // 指定feign所在的包，即使是引用的外部项目的包地址也可以
@RibbonClient(name="SpringCloud-provider-ribbon-spring-application",configuration = MyRule.class) // 配置当服务启动时，就加载针对目标提供者提供自定义的负载均衡算法
//@ComponentScan("com.learn.api")
@ComponentScan({"com.learn.api","com.learn.consumer.controller"}) // DeptFeignServiceFallbackFactory 对应的包路径  注意，如果api模块的包路径和消费者controller的包路径不同，一定要单独指定controller的包路径
public class SpringCloudConsumerFeign80Starter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerFeign80Starter.class,args);
    }
}
