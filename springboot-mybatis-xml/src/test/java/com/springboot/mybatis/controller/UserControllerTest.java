package com.springboot.mybatis.controller;

/**
 * @author yueli
 * @date 2020/9/14 15:17
 */

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {


    @Autowired
    private WebApplicationContext context;

    protected MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();  //初始化MockMvc对象
    }


    @Test
    public void testGetUserInfo() throws Exception {
        JSONObject json = new JSONObject();
        json.put("id", 1);
        mvc.perform(MockMvcRequestBuilders.get("/mybatis/user/info?id=1").accept(MediaType.APPLICATION_JSON)
                .content(json.toJSONString()))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}
