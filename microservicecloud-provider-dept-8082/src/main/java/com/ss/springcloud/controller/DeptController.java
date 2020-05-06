package com.ss.springcloud.controller;

import com.ss.springcloud.entities.Dept;
import com.ss.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * DeptController
 *
 * @author shisong
 * @date 2019/6/9
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "dept/list",method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping("dept/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("**********" + services);
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println("host:"+instance.getHost() + ",serviceName:" + instance.getServiceId() +",port:" + instance.getPort());
        }
        return instances;
    }
}
