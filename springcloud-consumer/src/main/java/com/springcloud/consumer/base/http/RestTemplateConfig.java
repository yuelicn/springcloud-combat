package com.springcloud.consumer.base.http;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author yueli
 * @date 2020/9/9 10:46
 */
@Configuration
public class RestTemplateConfig {
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        RestTemplate template = new RestTemplate();
//        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
//        factory.setConnectTimeout(600000);
//        factory.setReadTimeout(600000);
//        return template;
//    }

    @Bean
    @LoadBalanced
    RestOperations restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
