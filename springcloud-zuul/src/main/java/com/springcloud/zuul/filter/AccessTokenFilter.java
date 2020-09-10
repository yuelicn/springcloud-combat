package com.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.zuul.utils.ResponseBodyUtils;
import com.springcloud.zuul.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yueli
 * @date 2020/9/10 14:42
 */
@Slf4j
public class AccessTokenFilter extends ZuulFilter {

    @Autowired
    TokenUtils token;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("AccessTokenFilter >>> reqeust_url:{}", request.getRequestURI().toString());
        return token.isTokenAccessFilter(request.getRequestURI().toString());
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("accessFilter >> send:{}, request to :{}", request.getMethod(), request.getRequestURI().toString());

        String accessToken = request.getHeader("token");

        if (StringUtils.isBlank(accessToken)) {
            // 不进行路由，流程不会往下走
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.set("isToken", false);
            ctx.setResponseBody(ResponseBodyUtils.tokenIsNull());
            return null;
        }
        return null;
    }
}
