package com.springcloud.consumer.base.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yueli
 * @date 2020/9/9 16:39
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    /**
     * 分组信息
     */
    private static final String GROUP_NAME = "springcloud-consumer";
    /**
     * swagger 需要扫描的包
     */
    private static final String BASE_PACKAGE = "com.springcloud.consumer.controller";
    /**
     * title
     */
    private static final String TITLE = "springcloud-consumer-APIs";
    /**
     * api 的描述信息
     */
    private static final String DESCRIPTION = "接口接口集合";
    /**
     * 版本号
     */
    private static final String VERSION = "v1.0.0";

    @Bean
    public Docket buildDocket() {
        Docket docket =
                new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInfo()).useDefaultResponseMessages(false);
        docket
                .groupName(GROUP_NAME)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .build();
    }
}
