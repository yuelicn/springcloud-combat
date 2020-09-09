package com.springcloud.consumer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yueli
 * @date 2020/9/9 10:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer id;

    private String userName;

    private int sex;


}
