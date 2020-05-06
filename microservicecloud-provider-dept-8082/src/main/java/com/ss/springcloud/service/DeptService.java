package com.ss.springcloud.service;

import com.ss.springcloud.entities.Dept;

import java.util.List;

/**
 * DeptService
 *
 * @author shisong
 * @date 2019/6/9
 */
public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
