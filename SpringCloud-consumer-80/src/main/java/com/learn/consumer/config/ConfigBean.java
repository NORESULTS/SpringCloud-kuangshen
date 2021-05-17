package com.learn.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liangchao
 * @create 2021-05-05 16:52
 * 相当于spring中的 applicationContext.xml
 */
@Configuration
public class ConfigBean {

    /**
     * RestTemplate中本身没有@Bean，需要手动注册到spring中
     * @return
     */
    @Bean
    @LoadBalanced // 通过这个注解，实现在客户端消费者要去通过Rest访问提供者时，去做ribbon负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
