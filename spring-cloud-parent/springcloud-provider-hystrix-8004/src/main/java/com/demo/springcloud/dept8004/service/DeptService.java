package com.demo.springcloud.dept8004.service;

import com.demo.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {
	
	Dept findById(Integer deptNo);

	List<Dept> findAll();

	boolean addDept(Dept dept);

}
