package com.springboot.webservice.cxf.config;

import com.springboot.webservice.cxf.Application;
import com.springboot.webservice.cxf.service.IWebService;
import com.springboot.webservice.cxf.service.impl.WebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * @author yueli
 * @date 2020/9/18 14:04
 */
@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class CxfConfig {
    @SuppressWarnings("all")
    @Bean(name = "cxfServletRegistration")
    public ServletRegistrationBean dispatcherServlet() {
        //创建服务并指定服务名称
        return new ServletRegistrationBean(new CXFServlet(), "/cxf/services/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }


    @Bean
    public IWebService iwebService() {

        return new WebServiceImpl();
    }

    /**
     * 注册WebServiceDemoService接口到webservice服务
     *
     * @return
     */
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), iwebService());
        endpoint.publish("/hello_word");
        endpoint.getInInterceptors().add(new ServerNameSpaceInterceptor());
        //endpoint.getInInterceptors().add(new InInterceptor());
        return endpoint;
    }

}
