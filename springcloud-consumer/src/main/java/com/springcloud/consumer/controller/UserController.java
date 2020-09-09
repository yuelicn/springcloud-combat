package com.springcloud.consumer.controller;

import com.springcloud.common.response.ResponseData;
import com.springcloud.consumer.service.IUserService;
import com.springcloud.consumer.vo.UserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueli
 * @date 2020/9/9 10:08
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    IUserService userService;

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public ResponseData getUserInfoByUserId(@RequestParam("id") Integer id) {

        UserInfo userInfo = userService.findUserInfoById(id);
        return ResponseData.success(userInfo);
    }
}
