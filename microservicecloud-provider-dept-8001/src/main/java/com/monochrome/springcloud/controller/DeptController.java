package com.monochrome.springcloud.controller;

import com.monochrome.springcloud.entities.Dept;
import com.monochrome.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/get/{id}")
    public Dept getDept(@PathVariable("id") Long id) {
        return deptService.findOneById(id);
    }

    @PostMapping("/add") public boolean addDept(@RequestBody Dept dept) {
        return deptService.insert(dept);
    }

    @GetMapping("/list")
    public List<Dept> listDept() {
        return deptService.findAll();
    }


}

