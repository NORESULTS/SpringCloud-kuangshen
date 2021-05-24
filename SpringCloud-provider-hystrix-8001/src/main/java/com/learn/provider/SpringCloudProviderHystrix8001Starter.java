package com.learn.provider;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

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


    // 添加一个Servlet，为bean增加访问路径
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream"); // http:/localhost:9001/hystrix hystirx监控页面上声明的路径
        return registrationBean;
    }
}
