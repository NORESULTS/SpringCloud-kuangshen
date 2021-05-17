package com.learn.consumer.controller;

import com.learn.api.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liangchao
 * @create 2021-05-05 16:47
 * 消费者不应该存在service层
 * spring提供了很多XXXTemplate模板来模拟一些操作，例如MybatisTempl、RestTemplate，供我们直接调用。
 * RestTemplate用来模拟访问http服务，提供简单的Restful服务模板，
 * 由于其本身没有@Bean，需要先将其注册到spring中，然后调用。当前项目通过创建ConfigBean来实现。
 * 传参包含三个主要内容：（URL、实体类（或Map）、返回类Class--ResponseType）
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

//    public static final String REST_URL_PREFIX = "http://localhost:8001";
    // 引用ribbon后，访问地址变为一个变量，我们改为用服务名来访问
    public static final String REST_URL_PREFIX = "http://SpringCloud-provider-ribbon-spring-application";
//    public static final String REST_URL_PREFIX = "http://SpringCloud-provider-8001-spring-application";


    @PostMapping("/consumer/dept/add")
    public Boolean addDept(@RequestBody Dept dept){
        // 传参格式为 请求连接、请求传参的body实体类、返回类型Class、请求连接中传递的参数
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add/",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        // 传参格式为 请求连接、返回类型Class、请求连接中传递的参数
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        // 传参格式为 请求连接、返回类型Class、请求连接中传递的参数
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }



}
