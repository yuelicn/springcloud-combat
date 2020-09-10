package com.springcloud.zuul.utils;

import com.springcloud.zuul.properties.TokenAccessProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.Set;

/**
 * @author yueli
 * @date 2020/9/10 14:49
 */
@Component
public class TokenUtils {


    @Autowired
    TokenAccessProperties properties;

    PathMatcher pathMatcher = new AntPathMatcher();

    public boolean isTokenAccessFilter(String requestUrl) {
        return !matchesIgnoreTokenAccessUrl(requestUrl);
    }

    /**
     * 校验请求路径是否在token白名单中
     *
     * @param requestUrl 请求路径
     * @return
     */
    private boolean matchesIgnoreTokenAccessUrl(String requestUrl) {

        boolean isIgnore = false;

        Set<String> tokenAccessIgnoreUrlSet = properties.getTokenAccessIgnoreUrlSet();
        if (tokenAccessIgnoreUrlSet.isEmpty()) {
            return false;
        }

        for (String ignoreUrl : tokenAccessIgnoreUrlSet) {
            if (StringUtils.isBlank(ignoreUrl)) {
                continue;
            }

            if (pathMatcher.match(ignoreUrl, requestUrl)) {
                isIgnore = true;
                break;
            }
        }
        return isIgnore;

    }


}
