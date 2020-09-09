package com.springcloud.consumer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.springcloud.common.response.ResponseData;
import com.springcloud.consumer.service.IUserService;
import com.springcloud.consumer.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yueli
 * @date 2020/9/9 10:10
 */
@Service
public class UserService implements IUserService {

    @Autowired
    RestOperations restTemplate;

    @Override
    public UserInfo findUserInfoById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        ResponseEntity<ResponseData> forEntity = restTemplate.getForEntity("http://springcloud-provider/user/info?id=1",
                ResponseData.class, map);
//        ResponseEntity<ResponseData> exchange = restTemplate.exchange("http://localhost:8081/user/info?id=1",
//                HttpMethod.GET, null, ResponseData.class, 1, 9);
        Object result = forEntity.getBody().getResult();
        String jsonString = JSONObject.toJSONString(result);
        UserInfo userInfo = JSONObject.parseObject(jsonString, UserInfo.class);
        return userInfo;
    }
}
