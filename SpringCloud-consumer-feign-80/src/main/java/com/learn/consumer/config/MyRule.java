package com.learn.consumer.config;//package com.learn.RibbonRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liangchao
 * @create 2021-05-17 18:24
 *
 * 模拟 RandomRule RoundRobinRule ，自定义一个算法
 * 该算法简单实现每5次换一个服务提供者
 *
 * IRule为Ribbon的负载均衡算法基础接口
 * AbstractLoadBalancerRule为其抽象层，所有算法都要继承它
 * 常见的算法有：
 * RoundRobinRule 轮询算法，默认
 * RandomRule 随机算法
 * AvailabilityFilteringRule 过滤掉无效、故障的服务，只对正常的服务进行轮询
 * RetryRule 先正常轮询，若遇见服务获取失败，会在指定的时间内进行重试
 *
 *
 */
//@Component // 统一在ConfigBean中进行添加Bean，也行
public class MyRule extends AbstractLoadBalancerRule {

    private int total = 0; // 针对当前选中的提供者，访问了多少次
    private int currentIndex = 0; // 当前要访问的提供者的序号

    public Server choose(ILoadBalancer lb, Object key) {
        if(lb == null){
            // 负载均衡开关没开
            return null;
        }
        Server server = null;
        while(server == null){
            if(Thread.interrupted()){
                return null;
            }
            List<Server> upList = lb.getReachableServers(); // 获取还存活的服务提供者
            List<Server> allList = lb.getAllServers(); // 获取所有服务提供者

            int serverCount = allList.size();
            if (serverCount == 0 ){
                // 无服务可用
                return null;
            }

//            int index = chooseRandomInt(serverCount); // 随机抽取一个服务
//            server = upList.get(index);

            if (total < 5){
                server = upList.get(currentIndex);
                total++;
            }else{
                total =0;
                currentIndex++;
                if (currentIndex > upList.size()-1){
                    currentIndex=0;
                }
                server = upList.get(currentIndex);
            }

            if (server == null){
                Thread.yield();
                continue;
            }

            if (server.isAlive()){
                return server;
            }
            server = null;
            Thread.yield();

        }
        return server;
    }
    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
