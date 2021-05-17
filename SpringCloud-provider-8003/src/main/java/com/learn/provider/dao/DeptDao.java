package com.learn.provider.dao;

import com.learn.api.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangchao
 * @create 2021-05-05 15:25
 */
@Mapper
@Repository // 使得该类被springboot托管
public interface DeptDao {

    public Boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();

}
