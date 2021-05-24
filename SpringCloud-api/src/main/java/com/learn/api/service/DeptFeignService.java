package com.learn.api.service;

import com.learn.api.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author liangchao
 * @create 2021-05-18 15:58
 * feign封装了ribbon，将访问外部服务接口的模块进行封装
 * 要调用对应的外部服务接口，直接使用当前接口即可
 * 相当于模拟了httpclient的请求
 *
 * 接口的方法参数、返回值、作用域声明等，与生产者的Controller接口一模一样，
 * 用到哪个接口方法，直接在fegin接口中添加即可
 */
@Component
@FeignClient(value = "SpringCloud-provider-ribbon-spring-application", fallbackFactory = DeptFeignServiceFallbackFactory.class) // 指定当前Feign接口访问的生产者服务(或集群)
public interface DeptFeignService {

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();

    @PostMapping("/dept/add")
    public Boolean addDept(@RequestBody Dept dept);

}
