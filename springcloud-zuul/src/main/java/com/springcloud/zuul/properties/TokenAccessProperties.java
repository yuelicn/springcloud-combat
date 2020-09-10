package com.springcloud.zuul.properties;

import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yueli
 * @date 2020/9/10 14:51
 */
@Component
@Data
public class TokenAccessProperties {

    @Value("${token.ignore.filter.url:/combat/v1/**}")
    private String tokenAccessIgnoreUrl;


    /**
     * 存放忽略地址
     */
    private Set<String> tokenAccessIgnoreUrlSet = new HashSet<>();


    public Set<String> getTokenAccessIgnoreUrlSet() {
        return getUrlSet(tokenAccessIgnoreUrl, tokenAccessIgnoreUrlSet);
    }

    private Set<String> getUrlSet(String tokenAccessUrl, Set<String> tokenAccessUrlSet) {
        if (StringUtils.isBlank(tokenAccessUrl)) {
            return tokenAccessUrlSet;
        }
        String[] ignores = tokenAccessUrl.split(",");
        for (int i = 0, size = ignores.length; i < size; i++) {
            tokenAccessUrlSet.add(ignores[i]);
        }
        return tokenAccessUrlSet;
    }


}
