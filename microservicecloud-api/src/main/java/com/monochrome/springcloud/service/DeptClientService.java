package com.monochrome.springcloud.service;

import com.monochrome.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService
{
    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") long id);

    @GetMapping(value = "/dept/list")
    public List<Dept> list();

    @PostMapping(value = "/dept/add")
    public boolean add(Dept dept);
}