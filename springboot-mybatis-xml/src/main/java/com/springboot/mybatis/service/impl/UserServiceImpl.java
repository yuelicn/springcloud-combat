package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.dao.UserMapper;
import com.springboot.mybatis.po.User;
import com.springboot.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yueli
 * @date 2020/9/14 15:13
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserInfo(long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
