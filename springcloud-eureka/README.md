### eureka server ，必须优化参数
#### eureka server刷新readCacheMap的时间，注意，client读取的是readCacheMap，这个时间决定了多久会把readWriteCacheMap的缓存更新到readCacheMap上 默认30s
eureka.server.responseCacheUpdateIntervalMs = 3000 

#### 从eureka服务端获取注册信息的间隔时间
eureka.client.registryFetchIntervalSeconds = 30000 

#### 续约更新时间间隔（默认30秒），eureka客户端向服务端发送心跳的时间间隔
eureka.client.leaseRenewalIntervalInSeconds = 30 

#### 清理间隔（单位毫秒，默认是60*1000）5秒将客户端剔除的服务在服务注册列表中剔除#
eureka.server.evictionIntervalTimerInMs = 60000 

#### 续约到期时间（默认90秒）
eureka.instance.leaseExpirationDurationInSeconds = 90 

根据业务需求可以将服务发现的时效性变成秒级，几秒钟可以感知服务的上线和下线
