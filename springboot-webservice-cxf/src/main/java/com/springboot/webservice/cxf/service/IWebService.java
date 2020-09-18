package com.springboot.webservice.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 * @author yueli
 * @date 2020/9/18 14:08
 */
@javax.jws.WebService(serviceName = "hello_word_webserviceService",
        targetNamespace = "http://127.0.0.1:8030/cxf/services/hello_word")
public interface IWebService {
    /**
     * hello word
     *
     * @param id
     * @param name
     * @return
     */
    @WebMethod(operationName = "hello_word")
    @WebResult(name = "hello_wordReturn")
    String hello_word(@WebParam(name = "id", targetNamespace = "http://127.0.0.1" +
            ":8030/cxf/services/hello_word") int id, @WebParam(name = "name") String name);
}
