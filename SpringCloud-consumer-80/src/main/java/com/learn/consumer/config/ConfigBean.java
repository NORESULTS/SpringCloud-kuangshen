package com.learn.consumer.config;

import com.netflix.loadbalancer.IRule;
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
    @LoadBalanced // 通过这个注解，实现在客户端消费者要去通过Rest访问提供者时，去做ribbon负载均衡 .此处只起到开启负载均衡的开关作用
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 将Ribbon默认的均衡算法，从 轮询 RoundRobinRule 改为自定义
     * 与在Starter上指定对应服务的自定义算法，作用相同
     * @return
     */
    @Bean
    public IRule myRule(){
        return new MyRule();
    }

}
