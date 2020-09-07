### eureka server ，必须优化参数

#### 客户端的有效负载缓存应该更新的时间间隔，默认为30 * 1000毫秒
eureka.server.responseCacheUpdateIntervalMs = 30000

#### 主动失效检测间隔、默认60000L（60秒）
eureka.server.evictionIntervalTimerInMs = 60000 

#### 心跳间隔 默认90秒
eureka.instance.leaseExpirationDurationInSeconds = 90

#### 没有心跳的淘汰时间 默认180秒
eureka.instance.leaseExpirationDurationInSeconds


根据业务需求可以将服务发现的时效性变成秒级，几秒钟可以感知服务的上线和下线
