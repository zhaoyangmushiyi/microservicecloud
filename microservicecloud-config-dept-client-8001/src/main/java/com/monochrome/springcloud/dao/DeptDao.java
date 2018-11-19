package com.monochrome.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.monochrome.springcloud.entities.Dept;

@Mapper
public interface DeptDao {

    boolean insert(Dept dept);

    Dept findOneById(Long id);

    List<Dept> findAll();

}
