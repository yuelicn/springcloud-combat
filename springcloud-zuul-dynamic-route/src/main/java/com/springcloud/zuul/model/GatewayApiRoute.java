package com.springcloud.zuul.model;

import lombok.Data;

/**
 * @author yueli
 * @date 2020/9/30 16:24
 */
@Data
public class GatewayApiRoute {
    private String id;
    private String path;
    private String serviceId;
    private String url;
    private boolean stripPrefix = true;
    private Boolean retryable;
    private Boolean enabled;
}
