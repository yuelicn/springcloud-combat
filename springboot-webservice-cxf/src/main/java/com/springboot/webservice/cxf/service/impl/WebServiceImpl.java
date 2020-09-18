package com.springboot.webservice.cxf.service.impl;

import com.springboot.webservice.cxf.service.IWebService;

/**
 * @author yueli
 * @date 2020/9/18 14:09
 */
@javax.jws.WebService(serviceName = "hello_word_webserviceService",
        targetNamespace = "http://127.0.0.1:8030/cxf/services/hello_word")
public class WebServiceImpl implements IWebService {
    @Override
    public String hello_word(int id, String name) {
        return null;
    }
}
