package com.springboot.mybatis.service;

import com.springboot.mybatis.po.User;

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
}
