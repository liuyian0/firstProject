package com.example.firstproject.service;

import com.example.firstproject.dao.UserMapper;
import com.example.firstproject.pojo.User;
import com.example.firstproject.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl {
        //1.定义登录方法接收web层传递的User实体类对象
    public User login(User user) {
        //2.在登录方法体中获取操作mybatis的会话对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //3.使用会话对象调用方法获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.使用接口代理对象调用接口中的登录方法
        User u = mapper.login(user);
        //5.释放资源
        sqlSession.close();
        //6.将查询的User类对象返回给web层
        return u;
    }

    //注册：先根据用户名查询用户再添加
    //1.定义注册方法接收web层传递的User实体类对象
    public boolean register(User user) {
       SqlSession sqlSession = null;
        try {
            //2.在注册方法体中获取操作mybatis的会话对象
            sqlSession = SqlSessionUtil.getSqlSession();
            //3.使用会话对象调用方法获取接口代理对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //4.使用接口代理对象调用接口中的登录方法
            User u = mapper.queryUserByUsername(user.getUsername());
            //5.判断返回的User对象是否为null
            if (u == null){
                //5.1如果为null，说明数据库中没有同名的数据，可以进行注册
                mapper.register(user);
                //返回web层true
                return true;
            }else{
                //5.2如果不为null，说明数据库中存在同名数据，不能注册,返回false
                return false;
            }
        } finally {
            if (sqlSession!=null){
                //防止空指针
                //释放资源
                sqlSession.close();
            }

        }
        //5.释放资源
        //6.将查询的User类对象返回给web层
    }
}
