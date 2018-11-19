package com.monochrome.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monochrome.springcloud.dao.DeptDao;
import com.monochrome.springcloud.entities.Dept;
import com.monochrome.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

    private final DeptDao deptDao;

    @Autowired
    public DeptServiceImpl(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override public boolean insert(Dept dept) {
        return deptDao.insert(dept);
    }

    @Override public Dept findOneById(Long id) {
        return deptDao.findOneById(id);
    }

    @Override public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
