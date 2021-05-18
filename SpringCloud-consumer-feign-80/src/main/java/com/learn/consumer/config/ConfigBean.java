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
     * 将Ribbon默认的均衡算法，从 轮询 RoundRobinRule 改为自定义
     * 与在Starter上指定对应服务的自定义算法，作用相同
     * @return
     */
    @Bean
    public IRule myRule(){
        return new MyRule();
    }

}
