package com.demo.springcloud.dept8004.controller;

import com.demo.springcloud.dept8004.service.DeptService;
import com.demo.springcloud.entity.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//相当于@Controller + @ResponseBody(转成json格式传输)
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value="/dept/add", method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		
		return deptService.addDept(dept);
	}

	//在主体方法出现问题时调用备用方法
	@RequestMapping(value="/dept/get/{deptNo}", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getHystrix")
	public Dept get(@PathVariable("deptNo") Integer deptNo) throws InterruptedException {
	    if(deptNo == 999){
	        throw new RuntimeException("");
        }
        if(deptNo == 555){
            Thread.sleep(5000);
	    }
		return deptService.findById(deptNo);
	}

	//原主体方法熔断后调用的备用方法
	public Dept getHystrix(@PathVariable("deptNo") Integer deptNo){
		return new Dept(deptNo,"haven't got effective dept object from dbSource","haven't got effective dataBase information");
	}

	@RequestMapping(value="/dept/get/all", method=RequestMethod.GET)
	public List<Dept> getAll() {
		return deptService.findAll();
	}

}
