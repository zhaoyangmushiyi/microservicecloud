package com.monochrome.springcloud.service;

import java.util.List;

import com.monochrome.springcloud.entities.Dept;

public interface DeptService {

    boolean insert(Dept dept);

    Dept findOneById(Long id);

    List<Dept> findAll();

}
