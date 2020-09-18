package com.springboot.webservice.cxf.config;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.model.ServiceInfo;

/**
 * 去掉命名空间
 *
 * @author yueli
 * @date 2020/9/18 14:04
 */
public class ServerNameSpaceInterceptor extends AbstractPhaseInterceptor<Message> {

    public ServerNameSpaceInterceptor() {
        super(Phase.RECEIVE);
    }


    @Override
    public void handleMessage(Message message) throws Fault {
        for (ServiceInfo si : message.getExchange().getService().getServiceInfos()) {
            si.setProperty("soap.force.doclit.bare", true);
        }

    }
}