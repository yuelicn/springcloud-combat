package com.springcloud.zuul.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 动态发送刷新路由表事件
 *
 * @author yueli
 * @date 2020/9/30 15:15
 */
@Component
@Configuration
@EnableScheduling
public class RefreshRouteTask {

    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private RouteLocator routeLocator;

    @Scheduled(fixedRate = 5000)
    private void refreshRoute() {
        // org.springframework.cloud.netflix.zuul.ZuulConfiguration#ZuulRefreshListener 实现动态路由的关键，路由事件监听器
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
        publisher.publishEvent(routesRefreshedEvent);
    }

}
