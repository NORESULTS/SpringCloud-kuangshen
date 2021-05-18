package com.learn.consumer.controller;

import com.learn.api.pojo.Dept;
import com.learn.api.service.DeptFeiginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liangchao
 * @create 2021-05-05 16:47
 * 通过feign替换掉 RestTemplate
 * 相当于RestTemplate + Ribbon 的整合优化版，直接通过接口调用就能实现httpclient访问
 */
@RestController
public class DeptConsumerController {


    @Autowired
    private DeptFeiginService deptFeiginService = null; // 不设置=null就报错。DeptFeiginService没必要有实现类，因为feigin注解会使其具备相应的功能。所以这里指定为null，不让其报错就行。


    @PostMapping("/consumer/dept/add")
    public Boolean addDept(@RequestBody Dept dept){
        return this.deptFeiginService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return this.deptFeiginService.queryById(id);

    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.deptFeiginService.queryAll();
    }



}
