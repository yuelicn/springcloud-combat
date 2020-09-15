package com.springboot.mybatis.mult.service.impl;

import com.springboot.mybatis.mult.dao.test1.UserMapper;
import com.springboot.mybatis.mult.dao.test2.UserTestMapper;
import com.springboot.mybatis.mult.po.test1.User;
import com.springboot.mybatis.mult.po.test2.UserTest;
import com.springboot.mybatis.mult.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yueli
 * @date 2020/9/15 13:14
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserTestMapper userTestMapper;

    @Override
    public User getUserInfo(long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public UserTest getUserTestInfo(long id) {
        UserTest userTest = userTestMapper.selectByPrimaryKey(id);
        return userTest;
    }
}
