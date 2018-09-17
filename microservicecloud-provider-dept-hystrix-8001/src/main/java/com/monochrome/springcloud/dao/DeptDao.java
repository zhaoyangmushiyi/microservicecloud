package com.monochrome.springcloud.dao;

import com.monochrome.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    boolean insert(Dept dept);

    Dept findOneById(Long id);

    List<Dept> findAll();

}
