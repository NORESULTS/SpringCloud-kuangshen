package com.learn.provider.controller;

import com.learn.api.pojo.Dept;
import com.learn.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liangchao
 * @create 2021-05-05 15:36
 * 提供Restful服务
 */

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client; // 用于服务发现，获取eureka注册信息中有所有微服务的信息

    /**
     * 测试服务发现，查看当前eureka集群中所有服务的信息
     * @return
     */
    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println("当前eureka中注册的服务清单为："+services);

        String serviceId = "SPRINGCLOUD-PROVIDER-8001-SPRING-APPLICATION";
        System.out.println("获取serviceId为：" + serviceId + "的服务信息");
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-8001-SPRING-APPLICATION");
        for(ServiceInstance i : instances){
            System.out.println(
                    i.getHost() + "\t"
                    + i.getPort() + "\t"
                    + i.getUri() + "\t"
                    + i.getServiceId()
            );
        }
        return this.client;
    }

    @PostMapping("/dept/add")
    public Boolean addDept(@RequestBody  Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id) {
        System.out.println(7777);
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

}
