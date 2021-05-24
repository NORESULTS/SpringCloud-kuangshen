package com.learn.provider.controller;

import com.learn.api.pojo.Dept;
import com.learn.provider.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangchao
 * @create 2021-05-05 15:36
 * 提供Restful服务
 */

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixQueryById")
    public Dept queryById(@PathVariable("id") Long id) {
        Dept dept =  deptService.queryById(id);

        if (dept == null){
            throw new RuntimeException("id=>" + id + "，不存在该用户，或者信息无法找到。");
        }
        return dept;
    }

    public Dept hystrixQueryById(@PathVariable("id") Long id) {
        return new Dept().setDeptNo(id).
                setDbName("id=>"+id+"没有对应的信息，由Hystrix生产者服务熔断报出错误")
                .setDbSource("未找到数据库资源，由Hystrix生产者报出错误。");
    }


}
