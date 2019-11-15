package com.demo.springcloud.service.factory;

import com.demo.springcloud.entity.Dept;
import com.demo.springcloud.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallBackFactory
        //当前类作为降级机制的备选方案，必须实现FallbackFactory接口
        //接口里面的泛型是Feign接口类型
        implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Integer deptNo) {
                //在cosummer为自己提供一个备用的返回值
                return new Dept(deptNo,"provider remote call failed,use dept object by myself","provider remote call failed,use dataBase by myself");
            }

            @Override
            public List<Dept> getAll() {
                return null;
            }
        };
    }
}
