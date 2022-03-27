package com.example.demo.Mapper;

import com.example.demo.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper//表示Mapper类接口，表示创建Mapper时需要扫这个接口
@Component
public interface personMapper {
    //根据用户名查询用户
    public Person showuser(String name);

}
