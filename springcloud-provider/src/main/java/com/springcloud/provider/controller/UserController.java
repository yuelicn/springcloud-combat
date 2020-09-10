package com.springcloud.provider.controller;

import com.springcloud.common.response.ResponseData;
import com.springcloud.provider.vo.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueli
 * @date 2020/9/8 13:31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/info")
    public ResponseData getUerInfoById(@RequestParam Integer id) {
        UserInfo userInfo = new UserInfo(1, "张三",  0);
        System.out.println("====================:" + userInfo.toString());
        return ResponseData.success(userInfo);
    }
}
