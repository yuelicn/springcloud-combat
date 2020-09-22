package com.example.screw.config;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import lombok.Data;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yueli
 * @date 2020/9/22 13:00
 */
public class DocExecute {

    public static void generateDoc(Config config) {

        // 生成文件配置
        EngineConfig engineConfig = EngineConfig.builder()
                // 生成文件路径，自己mac本地的地址，这里需要自己更换下路径
                .fileOutputDir(config.getLocalDir())
                // 打开目录
                .openOutputDir(true)
                // 文件类型
                .fileType(config.getFileType())
                // 生成模板实现
                .produceType(EngineTemplateType.freemarker)
                //自定义文件名称
                .fileName(config.getDocName()).build();

        // 生成文档配置（包含以下自定义版本号、描述等配置连接）
        Configuration cfg = Configuration.builder()
                .version(config.getVersion())
                .description(config.getDescription())
                ////数据源
                .dataSource(config.getDataSource())
                //生成配置
                .engineConfig(engineConfig)
                //生成配置
                .produceConfig(ProcessCfg.getProcessConfig(config))
                .build();

        // 执行生成
        new DocumentationExecute(cfg).execute();
    }

    @Data
    class Config {
        /**
         * 数据源
         */
        private DataSource dataSource;
        /**
         * 文档名称
         */
        private String docName;
        /**
         * 文档生成路径
         */
        private String localDir;
        /**
         * 文档类型
         */
        private EngineFileType fileType;
        /**
         * 文档版本号
         */
        private String version = "1.0.0";
        /**
         * 文档描述信息
         */
        private String description = "文档描述信息";
        /**
         * 忽略表名
         */
        private List<String> ignoreTableName = new ArrayList<>();
        /**
         * 忽略以某某开头的表名
         */
        private List<String> ignorePrefix = new ArrayList<>();
        /**
         * 忽略某某后缀的表名
         */
        private List<String> ignoreSuffix = new ArrayList<>();
    }


}
