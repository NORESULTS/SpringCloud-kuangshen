package com.learn.api.service;

import com.learn.api.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 配置服务降级响应机制
 * @author liangchao
 * @create 2021-05-24 15:54
 */
@Component
public class DeptFeignServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptFeignService create(Throwable throwable) {
        // 这里直接写方法实现
        return new DeptFeignService(){

            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptNo(id)
                        .setDbName("id=>" +id+ "没有对应的信息，这里是消费者预设的服务降级操作，因为服务提供者无法响应，或已经被关闭。")
                        .setDbSource("无法访问提供者");
            }

            @Override
            public List<Dept> queryAll() {
                // 测试时忽略，参考 queryById
                return null;
            }

            @Override
            public Boolean addDept(Dept dept) {
                // 测试时忽略，参考 queryById
                return null;
            }
        };
    }
}
