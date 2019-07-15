package com.ss.springcloud.dao;

import com.ss.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DeptDao
 *
 * @author shisong
 * @date 2019/6/8
 */
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(@Param("deptno") Long id);

    List<Dept> findAll();
}
