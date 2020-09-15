package com.springboot.mybatis.mult.service;

import com.springboot.mybatis.mult.po.test1.User;
import com.springboot.mybatis.mult.po.test2.UserTest;

/**
 * @author yueli
 * @date 2020/9/14 15:12
 */
public interface IUserService {

    /**
     * 根据用户ID获取用户基本信息
     *
     * @param id
     * @return
     */
    User getUserInfo(long id);

    /**
     * 根据用户ID获取用户基本信息
     *
     * @param id
     * @return
     */
    UserTest getUserTestInfo(long id);
}
