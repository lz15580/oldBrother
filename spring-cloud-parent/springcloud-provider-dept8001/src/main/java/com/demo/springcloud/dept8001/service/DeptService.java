package com.demo.springcloud.dept8001.service;

import api.entity.Dept;

import java.util.List;

public interface DeptService {
	
	Dept findById(Integer deptNo);

	List<Dept> findAll();

	boolean addDept(Dept dept);

}
