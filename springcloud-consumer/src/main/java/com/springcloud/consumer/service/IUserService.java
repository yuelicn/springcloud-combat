package com.springcloud.consumer.service;

import com.springcloud.consumer.vo.UserInfo;

/**
 * @author yueli
 * @date 2020/9/9 10:10
 */
public interface IUserService {
    /**
     * 根据用户id获取用户基本信息
     * @param id
     * @return UserInfo
     */
    UserInfo findUserInfoById(Integer id);

}
