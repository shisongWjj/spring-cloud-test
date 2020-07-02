package com.ss.springcloud.controller;

import com.ss.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * DeptController_Consumer
 *
 * @author shisong
 * @date 2019/6/9
 */
@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX= "http://localhost:8081";
    private static final String REST_URL_PREFIX= "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("MICROSERVICECLOUD-DEPT");
        String url = String.format("http://%s:%s/",serviceInstance.getHost(),serviceInstance.getPort());
        return restTemplate.getForObject(url + "dept/discovery",Object.class);
        /*return restTemplate.getForObject(REST_URL_PREFIX + "dept/discovery",Object.class);*/
    }


}
