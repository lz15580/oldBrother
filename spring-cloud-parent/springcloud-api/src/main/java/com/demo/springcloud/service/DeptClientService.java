package com.demo.springcloud.service;

import java.util.List;

import com.demo.springcloud.service.factory.DeptClientServiceFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springcloud.entity.Dept;

// value：指定要调用的provider的微服务名称
//fallbackFactory：指定服务降级时使用的备选工厂方案
@FeignClient(value="Demo-SCMS-Dept",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

    @RequestMapping(value="/dept/add", method=RequestMethod.POST)
    public boolean add(@RequestBody Dept dept);

    @RequestMapping(value="/dept/get/{deptNo}", method=RequestMethod.GET)
    public Dept get(@PathVariable("deptNo") Integer deptNo);

    @RequestMapping(value="/dept/get/all", method=RequestMethod.GET)
    public List<Dept> getAll();

}