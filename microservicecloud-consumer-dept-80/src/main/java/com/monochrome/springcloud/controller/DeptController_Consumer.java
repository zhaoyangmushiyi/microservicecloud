package com.monochrome.springcloud.controller;

import com.monochrome.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    private final RestTemplate restTemplate;

    @Autowired
    public DeptController_Consumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/dept/list") public List<Dept> listDept() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping("/dept/discovery") public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
