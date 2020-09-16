package com.springboot.webservice.axis.service.impl;

import com.springboot.webservice.axis.service.IAxisService;

/**
 * @author yueli
 * @date 2020/9/16 15:29
 */
public class AxisServiceImpl implements IAxisService {
    @Override
    public String axis_test(int id, String name) {
        return id + ":" + name;
    }
}
