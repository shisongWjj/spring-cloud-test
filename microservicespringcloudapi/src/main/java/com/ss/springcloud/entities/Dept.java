package com.ss.springcloud.entities;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * dept
 *
 * @author shisong
 * @date 2019/6/8
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable{

    private Long deptno;
    private String dname;
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

    public static void main(String[] args) {
        /*Dept dept = new Dept();
        dept.setDeptno(11L).setDb_source("db01").setDname("RD");*/
    }
}
