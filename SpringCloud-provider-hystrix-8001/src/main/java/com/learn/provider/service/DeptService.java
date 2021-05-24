package com.learn.provider.service;

import com.learn.api.pojo.Dept;

import java.util.List;

/**
 * @author liangchao
 * @create 2021-05-05 15:34
 */
public interface DeptService {

    public Boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();

}
