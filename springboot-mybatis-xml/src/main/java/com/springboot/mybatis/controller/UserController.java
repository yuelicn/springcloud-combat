package com.springboot.mybatis.controller;

import com.springboot.mybatis.po.User;
import com.springboot.mybatis.service.IUserService;
import com.springcloud.common.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueli
 * @date 2020/9/14 15:07
 */
@RestController
@RequestMapping("/mybatis/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/info")
    public ResponseData<User> getUserInfo(@RequestParam("id") long id) {
        User user = userService.getUserInfo(id);
        return ResponseData.success(user);
    }



}
