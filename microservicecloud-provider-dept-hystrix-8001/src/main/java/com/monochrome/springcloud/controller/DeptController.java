package com.monochrome.springcloud.controller;

import com.monochrome.springcloud.entities.Dept;
import com.monochrome.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    final private DeptService deptService;
    final private DiscoveryClient client;

    @Autowired
    public DeptController(DeptService deptService, DiscoveryClient client) {
        this.deptService = deptService;
        this.client = client;
    }
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept getDept(@PathVariable("id") Long id) {
        Dept dept = deptService.findOneById(id);
        if (dept == null) {
            throw new RuntimeException("该ID" + id + "没有相应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

    @PostMapping("/add") public boolean addDept(@RequestBody Dept dept) {
        return deptService.insert(dept);
    }

    @GetMapping("/list")
    public List<Dept> listDept() {
        return deptService.findAll();
    }

    @GetMapping(value = "/discovery")
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}

