package com.springcloud.zuul.fallback;

import com.springcloud.zuul.utils.ResponseBodyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yueli
 * @date 2020/9/11 14:13
 * <p>
 * 当Zuul中给定路由的电路跳闸时，可以通过创建类型为FallbackProvider的bean提供回退响应。
 * 在此bean中，您需要指定回退的路由ID，并提供一个ClientHttpResponse
 * 作为回退的路由。以下示例显示了一个相对简单的FallbackProvider实现：
 */
@Slf4j
@Component
public class CombatFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        /**
         * 这个可以返回route的名称combat
         * zuul:
         *   routes:
         *     combat:
         *       path: /combat/**
         *  或者全部 *
         */
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                log.info("[网关-服务]-触发fallback: e:{}", cause);
                // 返回前端的内容
                return new ByteArrayInputStream(ResponseBodyUtils.fallBack().getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                // 设置头
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }
        };
    }
}
