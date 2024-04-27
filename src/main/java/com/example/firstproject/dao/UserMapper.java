package com.example.firstproject.dao;

import com.example.firstproject.pojo.User;
import org.apache.ibatis.annotations.Select;

//1.定义接口UserMapper
public interface UserMapper {
    //2.在接口中定义登陆方法
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);

    //3.在接口中定义查找方法
    @Select("select * from user where username=#{username}")
    User queryUserByUsername(String username);

    //4.在接口中定义注册方法
    @Select("insert into user values (null,#{username},#{password})")
    void register(User user);
}
