package com.learn.consumer.config;

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
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
