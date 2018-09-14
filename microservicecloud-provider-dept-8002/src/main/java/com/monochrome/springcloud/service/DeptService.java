package com.monochrome.springcloud.service;

import com.monochrome.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    boolean insert(Dept dept);

    Dept findOneById(Long id);

    List<Dept> findAll();

}
