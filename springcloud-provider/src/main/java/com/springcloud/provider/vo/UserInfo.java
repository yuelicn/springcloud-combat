package com.springcloud.provider.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yueli
 * @date 2020/9/8 15:10
 */
@Data
@AllArgsConstructor
public class UserInfo {

    private Integer id;

    private String userName;

    private int sex;


}
