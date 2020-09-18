## spring cloud
### 一、doc
1、deploy-shell: 提供一个简单部署shell脚本<br/>
2、mybatis-generator: 生成mybatis mapping 文件的工具类（mysql）<br/>
3、mysql: springboot-mybatis-xml-sql: 存放springboot-mubatis-xml功能的测试sql脚本

### 二、springcloud-eureka
1、eureka server端服务，并对其参数进行优化，可直接用于生产环境<br/>

### 三、springcloud-api-common
1、分布式id生成器工具类 <br/>
2、业务异常封装工具类 <br/>
3、获取请求IP工具类 <br/>
4、图片验证码生成器的工具类 <br/>

### 四、springcloud-consumer
1、集成注册中心 eureka <br/>
2、集成 Ribbon 实现负载均衡 <br/>
3、集成 swagger2 实现在线接口 <br/>
4、实现统一异常处理 <br/>

### 五、springcloud-provider
1、集成注册中心eureka <br/>
2、实现了一个简单的接口测试功能 <br/>

### 六、springcloud-zuul 
1、集成注册注册中心eureka <br/>
2、实现token权限拦截filter、可配置白名单 <br/>
3、集成Hystrix实现请求降级 <br/>
4、实现跨域功能 <br/>

## spring boot 功能
### 一、springboot集成mybatis
1、集成 mysql + durid <br/>
2、集成 mybatis (xml方式)<br/>
3、实现一个简单查找功能&测试方法

### 二、springboot集成mybatis(多数据源)
1、集成 mysql + durid （两个数据源）<br/>
2、集成 mybatis (xml方式) + 多数据源<br/>
3、实现一个简单查找功能&测试多数据源 <br/>
注意事项：<br/>
1、多数据源配置时必须指定一个主数据源（@Primary）<br/>
2、非主数据源在使用事物时必须指定数据源如：（@Transactional(value = "testTransactionManager")）

### 三、springboot集成webservice axis
##### 集成步骤：
1、需要引入对应的jar, 请查看pom <br/>
2、需要重写`org.apache.axis.configuration.EngineConfigurationFactoryServlet.java` 项目中的可以直接copy过去用 <br/>
3、启动类添加 `@ServletComponentScan` 注解 <br/>
4、创建`WebServlet.java` <br/>
5、创建对应暴露的接口 <br/>
6、创建server-config.wsdd文件配置暴露的service，在resource/WEB-INF下 <br/>
7、请求路径`http://localhost:8090/axis/services/axis_test?wsdl` <br/>
到此springboot整合webservice完成 <br/>

### 四、springboot集成webservice cxf
##### 集成步骤
1、需要引入对应的jar, 请查看pom <br/>
2、cxf的集成全部支持注解，这里注意配置两个配置类就好 <br/>
2.1、`com.springboot.webservice.cxf.config.CxfConfig` servlet配置以及监听<br/>
2.2、`com.springboot.webservice.cxf.config.ServerNameSpaceInterceptor` 去掉命名空间的拦截器<br/>
3、其它的service等直接使用注解就可以。<br/>
7、请求路径`http://127.0.0.1:8030/cxf/services/hello_word?wsdl`

## 持续更新中……
