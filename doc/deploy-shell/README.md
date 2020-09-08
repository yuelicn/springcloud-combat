### 使用说明

├── bin <br/>
│   ├── restart.sh  重启脚本 <br/>
│   ├── server.sh <br/>
│   ├── start.bat <br/>
│   ├── start.sh    启动脚本 <br/>
│   └── stop.sh     停止脚本 <br/>
├── conf <br/>
│   ├── application-dev.properties  开发环境配置 <br/>
│   ├── application-prod.properties 线上环境配置 <br/>
│   ├── application-test.properties 测试环境配置 <br/>
│   └── application.properties      配置指引 <br/>
├── lib                             工程jar位置 <br/>
└── logs                            日志文件位置 <br/>


##application.properties说明

配置文件路径 <br/>
spring.config.location=conf/

环境 dev/test/prod <br/>
spring.profiles.active=dev

日志文件 <br/>
spring.logging.file=logs/xxx.log