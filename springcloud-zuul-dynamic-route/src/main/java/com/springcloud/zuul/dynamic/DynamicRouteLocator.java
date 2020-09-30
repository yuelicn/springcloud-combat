package com.springcloud.zuul.dynamic;

import com.springcloud.zuul.model.GatewayApiRoute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yueli
 * @date 2020/9/30 15:35
 */
@Slf4j
public class DynamicRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {


    private JdbcTemplate jdbcTemplate;
    private ZuulProperties properties;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DynamicRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }


    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<String,
                ZuulProperties.ZuulRoute>();
        // 加载application.yml中配置的路由
        routesMap.putAll(super.locateRoutes());

        //加载DB中的路由表
        routesMap.putAll(locateRoutesFromDB());

        // 统一处理一下路由path的格式
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();

        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routesMap.entrySet()) {
            String path = entry.getKey();
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (null != this.properties && StringUtils.hasText(this.properties.getPrefix())) {
                path = this.properties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, entry.getValue());
        }
        log.info("动态路由表:routesMap:{}", routesMap.toString());
        return values;
    }

    private Map<? extends String, ? extends ZuulProperties.ZuulRoute> locateRoutesFromDB() {
        Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
        //从数据库查询路由信息
        String sql = "select * from gateway_api_route where enabled = 1 ";
        List<GatewayApiRoute> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GatewayApiRoute.class));

        if (null == query || query.isEmpty()) {
            return routes;
        }
        for (GatewayApiRoute route : query) {
            if (StringUtils.isEmpty(route.getPath())) {
                continue;
            }
            if (StringUtils.isEmpty(route.getServiceId()) && StringUtils.isEmpty(route.getUrl())) {
                continue;
            }
            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();

            BeanUtils.copyProperties(route, zuulRoute);
            routes.put(zuulRoute.getPath(), zuulRoute);
        }
        return routes;
    }
}
