package com.monochrome.springcloud.controller;

import com.monochrome.springcloud.entities.Dept;
import com.monochrome.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
//    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    private final DeptClientService deptClientService;

    @Autowired
    public DeptController_Consumer(DeptClientService deptClientService) {
        this.deptClientService = deptClientService;
    }

    @RequestMapping("/dept/add")
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    @RequestMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id) {
        return deptClientService.get(id);
    }

    @RequestMapping("/dept/list") public List<Dept> listDept() {
        return deptClientService.list();
    }

}
