package com.springboot.mybatis.mult.controller;

import com.springboot.mybatis.mult.po.test1.User;
import com.springboot.mybatis.mult.po.test2.UserTest;
import com.springboot.mybatis.mult.service.IUserService;
import com.springcloud.common.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueli
 * @date 2020/9/15 13:10
 */
@RestController
@RequestMapping("/mybatis/mult/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/info")
    public ResponseData<User> getUserInfo(@RequestParam("id") long id) {
        User user = userService.getUserInfo(id);
        return ResponseData.success(user);
    }
    @GetMapping("/test/info")
    public ResponseData<UserTest> getUserTestInfo(@RequestParam("id") long id) {
        UserTest user = userService.getUserTestInfo(id);
        return ResponseData.success(user);
    }
}
