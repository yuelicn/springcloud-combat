package com.springboot.webservice.axis.servlet;

import org.apache.axis.transport.http.AxisServlet;
import org.springframework.stereotype.Component;

/**
 * @author yueli
 * @date 2020-09-16 19:14
 */
@Component
@javax.servlet.annotation.WebServlet(
        urlPatterns =  "/axis/services/*",
        loadOnStartup = 1,
        name = "AxisServlet"
)
public class WebServlet extends AxisServlet {


}
